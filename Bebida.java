/**
 * La clase Bebida representa un tipo de producto que hereda de la clase Producto y agrega atributos específicos
 * para describir bebidas, como mililitros y tipo.
 */
public class Bebida extends Producto {
    private int mililitros;     // Volumen de la bebida en mililitros
    private String tipo;        // Tipo de bebida

    /**
     * Constructor para la clase Bebida.
     *
     * @param id                El identificador de la bebida.
     * @param nombre            El nombre de la bebida.
     * @param cantidadDisponible La cantidad disponible en el inventario.
     * @param cantidadVendidos   La cantidad de unidades vendidas.
     * @param estado            El estado de la bebida (activo o inactivo).
     * @param precio            El precio de la bebida.
     * @param mililitros        El volumen de la bebida en mililitros.
     * @param tipo              El tipo de bebida.
     */
    public Bebida(int id, String nombre, int cantidadDisponible, int cantidadVendidos, boolean estado, double precio, int mililitros, String tipo) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.mililitros = mililitros;
        this.tipo = tipo;
    }

    /**
     * Obtiene el volumen de la bebida en mililitros.
     *
     * @return El volumen de la bebida en mililitros.
     */
    public int getMililitros() {
        return mililitros;
    }

    /**
     * Establece el volumen de la bebida en mililitros.
     *
     * @param mililitros El volumen de la bebida en mililitros a establecer.
     */
    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }

    /**
     * Obtiene el tipo de bebida.
     *
     * @return El tipo de bebida.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de bebida.
     *
     * @param tipo El tipo de bebida a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Calcula la comisión para la bebida, que es un 20% del precio de la bebida.
     *
     * @return La comisión calculada.
     */
    @Override
    public double calcularComision() {
        return getPrecio() * 0.2;
    }

    /**
     * Convierte el objeto Bebida a una representación en cadena.
     *
     * @return Una cadena que representa la bebida.
     */
    @Override
    public String toString() {
        return "Bebida [id=" + id + ", nombre=" + nombre + ", cantidadDisponible=" + cantidadDisponible
                + ", cantidadVendidos=" + cantidadVendidos + ", estado=" + estado + ", precio=" + precio
                + ", mililitros=" + mililitros + ", tipo=" + tipo + "]";
    }

    /**
     * Convierte el objeto Bebida a una representación en formato CSV.
     *
     * @return Una cadena en formato CSV que representa la bebida.
     */
    public String toCSV() {
        return id + "|" + nombre + "|" + cantidadDisponible + "|" + cantidadVendidos + "|" + estado + "|" + precio
                + "|" + mililitros + "|" + tipo;
    }
}
