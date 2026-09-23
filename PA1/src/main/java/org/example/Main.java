package org.example;

import java.util.Scanner;

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

        //Parte de integrante 3
Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu principal");
            System.out.println("Registro del producto");
            System.out.println("Mostrar productos");
            System.out.println("Validar stock");
            System.out.println("Salir");
            System.out.println("Seleccione una opcion");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                System.out.println("Menu principal");
                break;

                case 2:
                 System.out.println("Productos");
                    p1.mostrarProducto();
                    p2.mostrarProducto();
                    p.mostrarProducto();
                    break;

                case 3:
                      System.out.println("Validar stock");
                    System.out.println("PC gamer: " + p1.validarStock(3));
                    System.out.println("Laptop: " + p2.validarStock(3));
                    System.out.println("Mouse: " + p.validarStock(3));
                    break;

                case 4:
                     System.out.println("Saliendo del programa...");
                    break;

                  default:
                    System.out.println("Opcion no valida.");
            }

        } while  (opcion !=4);

        sc.close();
                    
                          
    }

}
