package com.prueba.Punto_de_venta.Modelos;

public class Venta {
    private int vendedor_id;
    private String producto;
    private int cantidad;
    private double costo;

    public Venta() {
    }

    public Venta(int vendedor_id ,String producto, int cantidad, double costo) {
        this.vendedor_id=vendedor_id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public int getVendedor_id() {
        return vendedor_id;
    }

    public void setVendedor_id(int vendedor_id) {
        this.vendedor_id = vendedor_id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
