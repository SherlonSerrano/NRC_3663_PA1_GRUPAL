package org.example;

public class Producto {

    // Atributos de instancia
    String nombre;
    double precio;
    int stock;

    // Atributo de clase (compartido por todos los objetos): cuenta cuántos productos se han creado
    static int contadorProductos = 0;

    // Constructor por defecto
    public Producto(){
        this.nombre = "Producto sin nombre";
        this.precio = 0.0;
        this.stock = 0;
        contadorProductos++;
    }

    // Constructor parametrizado
    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        contadorProductos++;
    }

    // Constructor de copia
    public Producto(Producto producto){
        this.nombre = producto.nombre;
        this.precio = producto.precio;
        this.stock = producto.stock;
        contadorProductos++;
    }

}
