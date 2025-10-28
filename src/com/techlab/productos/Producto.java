package com.techlab.productos;

public class Producto {
    private static int idContador = 1;

    private int id;
    private String nombre;
    private double precio;
     private int stock;

    public Producto(String nombre, double precio, int stock) {
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;

    id = idContador;
    idContador++;
    }

    public Producto(int id, String nombre, double precio, int stock){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void reducirStock(int cantidad){
        stock = stock - cantidad;
    }

    public double precioTotal(){
        return precio * stock;
    }
}
