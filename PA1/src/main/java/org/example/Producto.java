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

    // Método que no retorna valor
    public void mostrarProducto(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: S/ " + precio);
        System.out.println("Stock: " + stock);
    }

    // Método que aumenta el stock
    public void aumentarStock(int cantidad){
        stock = stock + cantidad;
    }

    // Método que retorna boolean para validad stock
    public boolean validarStock(int cantidadSolicitada){
        return stock >= cantidadSolicitada;
    }

    // Método que reduce el stock (se usa el if-else y llama al método anterior)
    public void reducirStock(int cantidad){
        if (validarStock(cantidad)){
            stock = stock - cantidad;
            System.out.println("Venta realizada. Nuevo stock: " + stock);
        } else {
            System.out.println("Stock insuficiente. Stock actual: " + stock);
        }
    }

    // Método estático que retorna valor (calcular valor de inventario)
    public static double calcularValorInventario(double precio, int stock){
        return precio * stock;
    }






}
