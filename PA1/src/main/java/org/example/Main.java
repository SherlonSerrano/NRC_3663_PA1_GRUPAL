package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Scanner para leer lo que el usuario escribe por consola
        Scanner sc = new Scanner(System.in);

        // Producto "activo": el único que el sistema maneja en un momento dado.
        // Se inicializa con el constructor por defecto mientras el usuario no registre uno propio.
        Producto producto = new Producto();

        // Variable que guardará la opción elegida en el menú
        int opcion;

        // Contador: cuenta cuántas operaciones (registrar, aumentar, vender) se realizaron
        int operacionesRealizadas = 0;

        // Acumulador: suma el valor total de lo vendido durante toda la ejecución
        double valorTotalMovido = 0;

        // Ciclo do-while: se usa porque el menú debe mostrarse al menos una vez,
        // sin importar qué elija el usuario después
        do {
            System.out.println("\n===== MENÚ - CONTROL DE PRODUCTOS =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar información del producto");
            System.out.println("3. Aumentar stock");
            System.out.println("4. Vender / reducir stock");
            System.out.println("5. Calcular valor total del inventario");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            // switch: evalúa la opción elegida y ejecuta el bloque correspondiente
            switch (opcion) {

                case 1:
                    // Se limpia el buffer del Scanner (queda pendiente el "Enter" del nextInt anterior)
                    sc.nextLine();

                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    System.out.print("Stock inicial: ");
                    int stock = sc.nextInt();

                    // Se reemplaza el producto activo por uno nuevo con los datos ingresados.
                    // El producto anterior (si existía) deja de estar accesible.
                    producto = new Producto(nombre, precio, stock);

                    System.out.println("Producto registrado correctamente.");
                    operacionesRealizadas++; // se suma 1 al contador de operaciones
                    break;

                case 2:
                    // Muestra los datos del producto activo actual
                    producto.mostrarProducto();
                    break;

                case 3:
                    System.out.print("Cantidad a aumentar: ");
                    int cantidadAumentar = sc.nextInt();

                    // Llama al método de la clase Producto que suma stock
                    producto.aumentarStock(cantidadAumentar);
                    operacionesRealizadas++;
                    break;

                case 4:
                    System.out.print("Cantidad a vender: ");
                    int cantidadVender = sc.nextInt();

                    // reducirStock ya internamente valida si hay stock suficiente (if-else)
                    producto.reducirStock(cantidadVender);

                    // Se acumula el valor de la venta, aunque no se haya podido concretar
                    // (esto podría ajustarse para acumular solo ventas exitosas si se desea)
                    valorTotalMovido += cantidadVender * producto.precio;
                    operacionesRealizadas++;
                    break;

                case 5:
                    // Método estático: se llama directamente desde la clase, no desde un objeto
                    double valorInventario = Producto.calcularValorInventario(producto.precio, producto.stock);
                    System.out.println("Valor total del inventario: S/ " + valorInventario);
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    // Se ejecuta si el usuario ingresa una opción fuera del 1 al 6
                    System.out.println("Opción inválida, intente nuevamente.");
            }

        } while (opcion != 6); // el ciclo se repite hasta que el usuario elija salir

        // Resumen final que se muestra una sola vez, al terminar el programa
        System.out.println("\nOperaciones realizadas: " + operacionesRealizadas);
        System.out.println("Valor total movido en ventas: S/ " + valorTotalMovido);

        // Atributo de clase: cuenta todos los productos creados durante la ejecución,
        // incluyendo el inicial y cada vez que se usó la opción 1
        System.out.println("Productos creados en total: " + Producto.contadorProductos);

        sc.close(); // se cierra el Scanner al finalizar
    }
}
