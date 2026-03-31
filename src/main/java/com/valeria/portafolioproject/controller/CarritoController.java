package com.valeria.portafolioproject.controller;

import com.valeria.portafolioproject.model.CarritoItem;
import com.valeria.portafolioproject.model.Producto;
import com.valeria.portafolioproject.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("/carrito")
@SessionAttributes("carrito")
public class CarritoController {

    private final ProductoService productoService;

    public CarritoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @ModelAttribute("carrito")
    public Map<Long, CarritoItem> carrito() {
        return new LinkedHashMap<>();
    }

    @PostMapping("/agregar/{id}")
    public String agregar(@PathVariable Long id,
                          @ModelAttribute("carrito") Map<Long, CarritoItem> carrito,
                          RedirectAttributes redirectAttributes) {

        Producto producto = productoService.obtenerPorId(id);
        if (producto == null) {
            redirectAttributes.addFlashAttribute("error", "No se pudo agregar el producto al carrito.");
            return "redirect:/catalogo";
        }

        if (producto.getStock() <= 0) {
            redirectAttributes.addFlashAttribute("error", "Este producto no tiene stock disponible.");
            return "redirect:/catalogo";
        }

        CarritoItem item = carrito.get(id);
        if (item == null) {
            carrito.put(id, new CarritoItem(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getImagen(),
                    producto.getPrecio(),
                    1
            ));
        } else {
            item.incrementar();
        }

        redirectAttributes.addFlashAttribute("success", "Producto agregado al carrito.");
        return "redirect:/catalogo";
    }

    @GetMapping
    public String verCarrito(@ModelAttribute("carrito") Map<Long, CarritoItem> carrito, Model model) {
        model.addAttribute("items", carrito.values());
        model.addAttribute("total", carrito.values().stream().mapToDouble(CarritoItem::getSubtotal).sum());
        return "carrito";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarCantidad(@PathVariable Long id,
                                     @RequestParam int cantidad,
                                     @ModelAttribute("carrito") Map<Long, CarritoItem> carrito,
                                     RedirectAttributes redirectAttributes) {

        CarritoItem item = carrito.get(id);
        if (item == null) {
            redirectAttributes.addFlashAttribute("error", "No se encontró el producto en el carrito.");
            return "redirect:/carrito";
        }

        if (cantidad <= 0) {
            carrito.remove(id);
            redirectAttributes.addFlashAttribute("success", "Producto eliminado del carrito.");
        } else {
            item.setCantidad(cantidad);
            redirectAttributes.addFlashAttribute("success", "Cantidad actualizada correctamente.");
        }

        return "redirect:/carrito";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id,
                           @ModelAttribute("carrito") Map<Long, CarritoItem> carrito,
                           RedirectAttributes redirectAttributes) {

        carrito.remove(id);
        redirectAttributes.addFlashAttribute("success", "Producto eliminado del carrito.");
        return "redirect:/carrito";
    }

    @GetMapping("/vaciar")
    public String vaciar(@ModelAttribute("carrito") Map<Long, CarritoItem> carrito,
                         RedirectAttributes redirectAttributes,
                         SessionStatus sessionStatus) {
        carrito.clear();
        sessionStatus.setComplete();
        redirectAttributes.addFlashAttribute("success", "Carrito vaciado correctamente.");
        return "redirect:/carrito";
    }
}
