/**
 * Clase principal cuenta con el metodo main del programa y es la encargada de solo imprimir y recibir datos del usuario.
 *
 * @author Javier Alexander Linares Chang - carnet 231135
 * @version 1.0
 * @since 2023-10-23
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase Principal contiene el método principal (main) que ejecuta la aplicación de gestión de inventario.
 */
public class Principal {
    public static void main(String[] args) {
        ControladorInventario controlador = new ControladorInventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------------- Menú ----------------");
            System.out.println("1. Ingresar producto nuevo");
            System.out.println("2. Cargar productos desde archivo CSV");
            System.out.println("3. Buscar producto por ID");
            System.out.println("4. Listar productos de una categoría");
            System.out.println("5. Mostrar ventas y comisión");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los detalles del nuevo producto:");
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cantidad disponible: ");
                    int cantidadDisponible = scanner.nextInt();
                    System.out.print("Cantidad vendidos: ");
                    int cantidadVendidos = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.println("Selecciona la disponibilidad del producto:");
                    System.out.println("1. Disponible");
                    System.out.println("2. No disponible");
                    int disponibilidad = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    boolean estado = (disponibilidad == 1);

                    System.out.println("Selecciona la categoría del producto:");
                    System.out.println("1. Fruta");
                    System.out.println("2. Bebida");
                    System.out.println("3. Snack");
                    int categoria = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    Producto producto = null;

                    switch (categoria) {
                        case 1:
                            System.out.print("Libras: ");
                            int libras = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea
                            System.out.print("Madurez: ");
                            String madurez = scanner.nextLine();
                            producto = new Fruta(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, libras, madurez);
                            break;
                        case 2:
                            System.out.print("Mililitros: ");
                            int mililitros = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea
                            System.out.print("Tipo: ");
                            String tipo = scanner.nextLine();
                            producto = new Bebida(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, mililitros, tipo);
                            break;
                        case 3:
                            System.out.print("Gramos: ");
                            int gramos = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea
                            System.out.print("Sabor: ");
                            String sabor = scanner.nextLine();
                            System.out.print("Tamaño: ");
                            String tamaño = scanner.nextLine();
                            producto = new Snack(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, gramos, sabor, tamaño);
                            break;
                        default:
                            System.out.println("Categoría no válida");
                            break;
                    }

                    if (producto != null) {
                        controlador.agregarProducto(producto, "inventario.csv");
                        System.out.println("Producto registrado exitosamente.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del archivo CSV: ");
                    String archivo = scanner.next();
                    try {
                        controlador.cargarProductosDesdeCSV(archivo);
                        System.out.println("Productos cargados exitosamente.");
                    } catch (IOException e) {
                        System.err.println("Error al cargar productos desde el archivo CSV: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del producto a buscar: ");
                    int ID = scanner.nextInt();
                    Producto product = controlador.buscarProductoPorId(ID);
                    if (product != null) {
                        System.out.println("Producto encontrado: " + product.toString());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Seleccione la categoría para listar productos:");
                    System.out.println("1. Fruta");
                    System.out.println("2. Bebida");
                    System.out.println("3. Snack");
                    int opcionCategoria = scanner.nextInt();
                    String categoriaSeleccionada = "";

                    switch (opcionCategoria) {
                        case 1:
                            categoriaSeleccionada = "Fruta";
                            break;
                        case 2:
                            categoriaSeleccionada = "Bebida";
                            break;
                        case 3:
                            categoriaSeleccionada = "Snack";
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }

                    if (!categoriaSeleccionada.isEmpty()) {
                        ArrayList<Producto> productosCategoria = controlador.listarProductosDeUnaCategoria(categoriaSeleccionada);
                        if (productosCategoria.isEmpty()) {
                            System.out.println("No hay productos en la categoría especificada.");
                        } else {
                            System.out.println("Productos en la categoría " + categoriaSeleccionada + ":");
                            for (Producto prod : productosCategoria) {
                                System.out.println(prod.getId() + " - " + prod.getNombre());
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("-------- INFORME DE VENTAS --------");
                    controlador.generarInformeDeVentas();
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
