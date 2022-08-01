package com.gm.ventas;

import java.util.StringJoiner;

public class Producto {
    private int idProducto;
    private String nombre;
    private double precio;
    private static int contadorProducto;

    public Producto() {
    }

    public Producto(String nombre, double precio) {
        this.idProducto = ++contadorProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Producto.class.getSimpleName() + "[", "]")
                .add("idProducto=" + idProducto)
                .add("nombre='" + nombre + "'")
                .add("precio=" + precio)
                .toString();
    }
}
