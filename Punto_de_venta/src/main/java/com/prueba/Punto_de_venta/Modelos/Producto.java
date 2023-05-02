package com.prueba.Punto_de_venta.Modelos;

public class Producto {
    private int id;
    private String producto_name;
    private int stock;
    private double precio;
    private String imagen;

    public  Producto(){

    }

    public Producto(int id, String producto_name, int stock, double precio, String imagen) {
        this.id = id;
        this.producto_name = producto_name;
        this.stock = stock;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto_name() {
        return producto_name;
    }

    public void setProducto_name(String producto_name) {
        this.producto_name = producto_name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
