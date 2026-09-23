package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Verificamos que compila sin errores
        Producto p1 = new Producto("PC gamer", 2500, 50);
        Producto p2 = new Producto("Laptop", 1500, 20);
        Producto p3 = new Producto(p2);

        System.out.println(p1.nombre);
        System.out.println(p1.precio);
        System.out.println(p1.stock);
        System.out.println(p3.nombre);  // Imprime nombre p2
        System.out.println(p3.precio);  // Imprime precio p2
        System.out.println(p3.stock);   // Imprime stock p2


        // Verificación integrante 2
        Producto p = new Producto("Mouse", 50, 5);
        p.mostrarProducto();
        p.aumentarStock(10);
        System.out.println(p.validarStock(3));
        p.reducirStock(20); // debe decir "Stock insuficiente"
    }



}