/**
 * La clase Snack representa un tipo de producto que hereda de la clase Producto y agrega atributos específicos
 * para describir snacks, como gramos, sabor y tamaño.
 */
public class Snack extends Producto {
    private int gramos;         // Peso del snack en gramos
    private String sabor;       // Sabor del snack
    private String tamaño;      // Tamaño del snack

    /**
     * Constructor para la clase Snack.
     *
     * @param id                El identificador del snack.
     * @param nombre            El nombre del snack.
     * @param cantidadDisponible La cantidad disponible en el inventario.
     * @param cantidadVendidos   La cantidad de unidades vendidas.
     * @param estado            El estado del snack (activo o inactivo).
     * @param precio            El precio del snack.
     * @param gramos            El peso del snack en gramos.
     * @param sabor             El sabor del snack.
     * @param tamaño            El tamaño del snack.
     */
    public Snack(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean estado, double precio, int gramos, String sabor, String tamaño) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamaño = tamaño;
    }

    /**
     * Obtiene el peso del snack en gramos.
     *
     * @return El peso del snack en gramos.
     */
    public int getGramos() {
        return gramos;
    }

    /**
     * Establece el peso del snack en gramos.
     *
     * @param gramos El peso del snack en gramos a establecer.
     */
    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    /**
     * Obtiene el sabor del snack.
     *
     * @return El sabor del snack.
     */
    public String getSabor() {
        return sabor;
    }

    /**
     * Establece el sabor del snack.
     *
     * @param sabor El sabor del snack a establecer.
     */
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    /**
     * Obtiene el tamaño del snack.
     *
     * @return El tamaño del snack.
     */
    public String getTamaño() {
        return tamaño;
    }

    /**
     * Establece el tamaño del snack.
     *
     * @param tamaño El tamaño del snack a establecer.
     */
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * Calcula la comisión para el snack, que es un 20% del precio del snack.
     *
     * @return La comisión calculada.
     */
    @Override
    public double calcularComision() {
        return getPrecio() * 0.2;
    }  

    /**
     * Convierte el objeto Snack a una representación en cadena.
     *
     * @return Una cadena que representa el snack.
     */
    @Override
    public String toString() {
        return "Snack [id=" + id + ", nombre=" + nombre + ", cantidadDisponible=" + cantidadDisponible
                + ", cantidadVendidos=" + cantidadVendidos + ", estado=" + estado + ", precio=" + precio
                + ", gramos=" + gramos + ", sabor=" + sabor + ", tamaño=" + tamaño + "]";
    }

    /**
     * Convierte el objeto Snack a una representación en formato CSV.
     *
     * @return Una cadena en formato CSV que representa el snack.
     */
    public String toCSV() {
        return id + "|" + nombre + "|" + cantidadDisponible + "|" + cantidadVendidos + "|" + estado + "|" + precio
                + "|" + gramos + "|" + sabor + "|" + tamaño;
    }
}
