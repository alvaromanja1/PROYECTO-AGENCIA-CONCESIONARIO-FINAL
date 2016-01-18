package TipoDeDatos;


/**
 * @author USUARIO
 *Clase compra
 */
public class Compra {

	private String dni;
	private String codigo;
	private int unidades;
	private float precioTotal;
	
	/**
	 * Crea una nueva compra
	 * @param dni
	 * @param codigo
	 * @param unidades
	 * @param precioTotal
	 */
	public Compra(String dni, String codigo, int unidades, float precioTotal) {
		super();
		this.dni = dni;
		this.codigo = codigo;
		this.unidades = unidades;
		this.precioTotal = precioTotal;
	}
	
	/**
	 * Devuelve el dni
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Método que permite cambiar un dni 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * Devuelve el código de compra
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * Permite cambiar el código de la compra
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * Método que devuelve el número de unidades de compra
	 * @return unidades
	 */
	public int getUnidades() {
		return unidades;
	}
	/**
	 * Permite camibiar las unidades desde otra clase
	 * @param unidades
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	/**
	 * Método que devuelve el precio total de comrpra
	 * @return precioTotal
	 */
	public float getPrecioTotal() {
		return precioTotal;
	}
	/**
	 * Método que permite cambiar el precio total desde cualquier otra ventana
	 * @param precioTotal
	 */
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
}