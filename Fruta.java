/**
 * La clase Fruta representa un tipo de producto que hereda de la clase Producto y agrega atributos específicos
 * para describir frutas, como libras y estado de madurez.
 */
public class Fruta extends Producto {
    private int libras;         // Peso de la fruta en libras
    private String madurez;     // Estado de madurez de la fruta

    /**
     * Constructor para la clase Fruta.
     *
     * @param id                El identificador de la fruta.
     * @param nombre            El nombre de la fruta.
     * @param cantidadDisponible La cantidad disponible en el inventario.
     * @param cantidadVendidos   La cantidad de unidades vendidas.
     * @param estado            El estado de la fruta (activo o inactivo).
     * @param precio            El precio de la fruta.
     * @param libras            El peso de la fruta en libras.
     * @param madurez           El estado de madurez de la fruta.
     */
    public Fruta(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean estado, double precio, int libras, String madurez) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.libras = libras;
        this.madurez = madurez;
    }

    /**
     * Obtiene el peso de la fruta en libras.
     *
     * @return El peso de la fruta en libras.
     */
    public int getLibras() {
        return libras;
    }

    /**
     * Establece el peso de la fruta en libras.
     *
     * @param libras El peso de la fruta en libras a establecer.
     */
    public void setLibras(int libras) {
        this.libras = libras;
    }

    /**
     * Obtiene el estado de madurez de la fruta.
     *
     * @return El estado de madurez de la fruta.
     */
    public String getMadurez() {
        return madurez;
    }

    /**
     * Establece el estado de madurez de la fruta.
     *
     * @param madurez El estado de madurez de la fruta a establecer.
     */
    public void setMadurez(String madurez) {
        this.madurez = madurez;
    }

    /**
     * Calcula la comisión para la fruta, que es un 20% del precio de la fruta.
     *
     * @return La comisión calculada.
     */
    @Override
    public double calcularComision() {
        return getPrecio() * 0.2;
    }

    /**
     * Convierte el objeto Fruta a una representación en cadena.
     *
     * @return Una cadena que representa la fruta.
     */
    @Override
    public String toString() {
        return "Fruta [id=" + id + ", nombre=" + nombre + ", cantidadDisponible=" + cantidadDisponible
                + ", cantidadVendidos=" + cantidadVendidos + ", estado=" + estado + ", precio=" + precio
                + ", libras=" + libras + ", madurez=" + madurez + "]";
    }

    /**
     * Convierte el objeto Fruta a una representación en formato CSV.
     *
     * @return Una cadena en formato CSV que representa la fruta.
     */
    public String toCSV() {
        return id + "|" + nombre + "|" + cantidadDisponible + "|" + cantidadVendidos + "|" + estado + "|" + precio
                + "|" + libras + "|" + madurez;
    }
}
