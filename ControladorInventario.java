import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Esta clase representa un controlador para gestionar un inventario de productos.
 */
public class ControladorInventario {
    private ArrayList<Producto> productos = new ArrayList<>();

    /**
     * Agrega un producto al inventario y guarda la actualización en un archivo CSV.
     *
     * @param producto El producto a agregar.
     * @param archivo  El archivo CSV donde se guardará el inventario.
     */
    public void agregarProducto(Producto producto, String archivo) {
        productos.add(producto);
        guardarInventarioEnCSV(productos, archivo);
    }

    private void guardarInventarioEnCSV(ArrayList<Producto> productos, String archivo) {
        if (!archivo.endsWith(".csv")) {
            archivo += ".csv"; // Añadir la extensión .csv si no está presente
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Producto producto : productos) {
                writer.write(producto.toCSV() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el inventario en el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Carga productos desde un archivo CSV y los agrega al inventario.
     *
     * @param archivo El archivo CSV desde el cual cargar los productos.
     * @throws IOException Si ocurre un error de lectura del archivo.
     */
    public void cargarProductosDesdeCSV(String archivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            productos.clear(); // Limpiar la lista actual antes de cargar desde el archivo
    
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|"); // Usamos "|" como delimitador
    
                if (parts.length >= 7) { // Verificamos que haya al menos 7 columnas
                    int id = Integer.parseInt(parts[0]);
                    String nombre = parts[1];
                    int cantidadDisponible = Integer.parseInt(parts[2]);
                    int cantidadVendidos = Integer.parseInt(parts[3]);
                    boolean estado = Boolean.parseBoolean(parts[4]);
                    double precio = Double.parseDouble(parts[5]);
                    String categoria = parts[6];
    
                    if (categoria.equals("Fruta") && parts.length >= 8) {
                        int libras = Integer.parseInt(parts[7]);
                        String madurez = parts[8];
                        Fruta fruta = new Fruta(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, libras, madurez);
                        productos.add(fruta);
                    } else if (categoria.equals("Bebida") && parts.length >= 8) {
                        int mililitros = Integer.parseInt(parts[7]);
                        String tipo = parts[8];
                        Bebida bebida = new Bebida(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, mililitros, tipo);
                        productos.add(bebida);
                    } else if (categoria.equals("Snack") && parts.length >= 9) {
                        int gramos = Integer.parseInt(parts[7]);
                        String sabor = parts[8];
                        String tamaño = parts[9];
                        Snack snack = new Snack(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, gramos, sabor, tamaño);
                        productos.add(snack);
                    }
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }
    

    /**
     * Busca un producto por su ID en el inventario.
     *
     * @param id El ID del producto a buscar.
     * @return El producto si se encuentra, o null si no se encuentra.
     */
    public Producto buscarProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto; // Devuelve el producto si se encuentra
            }
        }
        return null; // Retorna null si el producto no se encuentra
    }

    /**
     * Lista los productos de una categoría específica en el inventario.
     *
     * @param categoria La categoría de productos a listar (ej. "Fruta", "Bebida", "Snack").
     * @return Una lista de productos de la categoría especificada.
     */
    public ArrayList<Producto> listarProductosDeUnaCategoria(String categoria) {
        ArrayList<Producto> productosCategoria = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto instanceof Fruta && categoria.equals("Fruta")) {
                productosCategoria.add(producto);
            } else if (producto instanceof Bebida && categoria.equals("Bebida")) {
                productosCategoria.add(producto);
            } else if (producto instanceof Snack && categoria.equals("Snack")) {
                productosCategoria.add(producto);
            }
        }
        return productosCategoria;
    }

    /**
     * Genera un informe de ventas que muestra el total de ventas, comisiones y categorías de productos.
     */
    public void generarInformeDeVentas() {
        double totalVentas = 0;
        double totalComision = 0;
        ArrayList<String> categorias = new ArrayList<>();

        for (Producto producto : productos) {
            totalVentas += producto.getPrecio() * producto.getCantidadVendidos();
            totalComision += producto.calcularComision();
            if (producto instanceof Fruta && !categorias.contains("Fruta")) {
                categorias.add("Fruta");
            } else if (producto instanceof Bebida && !categorias.contains("Bebida")) {
                categorias.add("Bebida");
            } else if (producto instanceof Snack && !categorias.contains("Snack")) {
                categorias.add("Snack");
            }
        }

        System.out.println("Total de ventas: " + totalVentas);
        System.out.println("Total de comisiones: " + totalComision);
        System.out.println("Categorías de productos: " + categorias);

        for (String categoria : categorias) {
            ArrayList<Producto> productosCategoria = listarProductosDeUnaCategoria(categoria);
            System.out.println("Productos en la categoría " + categoria + ":");
            for (Producto producto : productosCategoria) {
                System.out.println(producto.getId() + " - " + producto.getNombre());
            }
        }
    }
}
