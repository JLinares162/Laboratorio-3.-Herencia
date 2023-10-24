/**
 * La clase abstracta Producto representa un producto genérico con atributos como ID, nombre, cantidad disponible,
 * cantidad vendida, estado y precio. Esta clase es la base para otros tipos de productos y define comportamientos
 * comunes.
 */
public abstract class Producto {
    protected int id;                 // Identificador del producto
    protected String nombre;           // Nombre del producto
    protected int cantidadDisponible;  // Cantidad disponible en el inventario
    protected int cantidadVendidos;    // Cantidad de unidades vendidas
    protected boolean estado;         // Estado del producto (activo o inactivo)
    protected double precio;          // Precio del producto

    /**
     * Constructor para la clase Producto.
     *
     * @param id                El identificador del producto.
     * @param nombre            El nombre del producto.
     * @param cantidadDisponible La cantidad disponible en el inventario.
     * @param cantidadVendidos   La cantidad de unidades vendidas.
     * @param estado            El estado del producto (activo o inactivo).
     * @param precio            El precio del producto.
     */
    public Producto(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean estado, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendidos = cantidadVendidos;
        this.estado = estado;
        this.precio = precio;
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return El ID del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la cantidad disponible en el inventario.
     *
     * @return La cantidad disponible en el inventario.
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Obtiene la cantidad de unidades vendidas.
     *
     * @return La cantidad de unidades vendidas.
     */
    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    /**
     * Verifica el estado del producto.
     *
     * @return `true` si el producto está activo, `false` si está inactivo.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Método abstracto que debe ser implementado por las subclases para calcular la comisión del producto.
     *
     * @return La comisión calculada.
     */
    public abstract double calcularComision();

    /**
     * Convierte el objeto Producto a una representación en cadena.
     *
     * @return Una cadena que representa el producto.
     */
    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", cantidadDisponible=" + cantidadDisponible
                + ", cantidadVendidos=" + cantidadVendidos + ", estado=" + estado + ", precio=" + precio + "]";
    }

    /**
     * Convierte el objeto Producto a una representación en formato CSV.
     *
     * @return Una cadena en formato CSV que representa el producto.
     */
    public String toCSV() {
        return id + "|" + nombre + "|" + cantidadDisponible + "|" + cantidadVendidos + "|" + estado + "|" + precio;
    }
}
