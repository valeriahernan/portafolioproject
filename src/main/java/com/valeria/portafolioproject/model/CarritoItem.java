package com.valeria.portafolioproject.model;

public class CarritoItem {

    private Long productoId;
    private String nombre;
    private String imagen;
    private double precio;
    private int cantidad;

    public CarritoItem() {
    }

    public CarritoItem(Long productoId, String nombre, String imagen, double precio, int cantidad) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Long getProductoId() {
        return productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void incrementar() {
        this.cantidad++;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return precio * cantidad;
    }
}
