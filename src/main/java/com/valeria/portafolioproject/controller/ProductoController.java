package com.valeria.portafolioproject.controller;

import com.valeria.portafolioproject.model.Producto;
import com.valeria.portafolioproject.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        model.addAttribute("productos", productoService.listarTodos());
        return "catalogo";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("productos", productoService.listarTodos());
        if (!model.containsAttribute("producto")) {
            model.addAttribute("producto", new Producto());
        }
        model.addAttribute("modoEdicion", false);
        return "admin";
    }

    @PostMapping("/admin/guardar")
    public String guardar(@Valid @ModelAttribute("producto") Producto producto,
                          BindingResult result,
                          RedirectAttributes redirectAttributes,
                          Model model) {

        if (result.hasErrors()) {
            model.addAttribute("productos", productoService.listarTodos());
            model.addAttribute("modoEdicion", false);
            return "admin";
        }

        productoService.guardar(producto);
        redirectAttributes.addFlashAttribute("success", "Producto guardado correctamente.");
        return "redirect:/admin";
    }

    @GetMapping("/admin/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Producto producto = productoService.obtenerPorId(id);
        if (producto == null) {
            redirectAttributes.addFlashAttribute("error", "El producto no existe.");
            return "redirect:/admin";
        }

        model.addAttribute("productos", productoService.listarTodos());
        model.addAttribute("producto", producto);
        model.addAttribute("modoEdicion", true);
        return "admin";
    }

    @PostMapping("/admin/actualizar/{id}")
    public String actualizar(@PathVariable Long id,
                             @Valid @ModelAttribute("producto") Producto producto,
                             BindingResult result,
                             RedirectAttributes redirectAttributes,
                             Model model) {

        if (result.hasErrors()) {
            model.addAttribute("productos", productoService.listarTodos());
            model.addAttribute("modoEdicion", true);
            return "admin";
        }

        Producto existente = productoService.obtenerPorId(id);
        if (existente == null) {
            redirectAttributes.addFlashAttribute("error", "No se pudo actualizar el producto.");
            return "redirect:/admin";
        }

        existente.setNombre(producto.getNombre());
        existente.setTipo(producto.getTipo());
        existente.setDescripcion(producto.getDescripcion());
        existente.setPrecio(producto.getPrecio());
        existente.setStock(producto.getStock());
        existente.setImagen(producto.getImagen());

        productoService.guardar(existente);
        redirectAttributes.addFlashAttribute("success", "Producto actualizado correctamente.");
        return "redirect:/admin";
    }

    @GetMapping("/admin/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (!productoService.existe(id)) {
            redirectAttributes.addFlashAttribute("error", "El producto no existe.");
            return "redirect:/admin";
        }

        productoService.eliminar(id);
        redirectAttributes.addFlashAttribute("success", "Producto eliminado correctamente.");
        return "redirect:/admin";
    }
}
