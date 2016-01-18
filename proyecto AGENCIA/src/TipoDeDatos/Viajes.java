package TipoDeDatos;

import java.util.Date;


/**
 * @author USUARIO
 *Clase Viaje que hereda de la clase servicio
 */
public class Viajes extends Servicio {

	private int numPlazas;
	private String origen;
	private String destino;
	private String fechaSalida,fechaRegreso;
	
	
	
	/**
	 * Crea un nuevo viaje
	 * @param cod
	 * @param foto
	 * @param precio
	 * @param origen
	 * @param destino
	 * @param numPlazas
	 * @param fechaSalida
	 * @param fechaRegreso
	 */
	public Viajes(int cod, String foto, double precio,String origen, String destino, int numPlazas,String fechaSalida, String fechaRegreso) {
		super(cod, foto, precio);
		this.numPlazas = numPlazas;
		this.origen = origen;
		this.destino=destino;
		this.fechaSalida=fechaSalida;
		this.fechaRegreso=fechaRegreso;
	}



	/**
	 * Método que devuelve el número de plazas disponibles para un viaje determinado
	 * @return numPlazas
	 */
	public int getNumPlazas() {
		return numPlazas;
	}
	/**
	 * Permite cambiar el número de plazas desde cualquier otra clase
	 * @param numPlazas
	 */
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
	/**
	 * Devuelve el origen del viaje
	 * @return origen
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * Permite cambiar el origen del viaje
	 * @param origen
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * Método que devuelve el destino del viaje
	 * @return destino
	 */
	public String getDestino() {
		return destino;
	}
	/**
	 * Permite cambiar el destino del viaje
	 * @param destino
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	/**
	 * Método que devuelve la fecha de salida del viaje seleccionado
	 * @return fechaSalida
	 */
	public String getFechaSalida() {
		return fechaSalida;
	}
	/**
	 * Método que permite cambiar la fecha de salida
	 * @param fechaSalida
	 */
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	/**
	 * Método que devuelve la fecha de regreso
	 * @return fechaRegreso
	 */
	public String getFechaRegreso() {
		return fechaRegreso;
	}
	/**
	 * Permite cambiar la fecha de regreso del viaje
	 * @param fechaRegreso
	 */
	public void setFechaRegreso(String fechaRegreso) {
		this.fechaRegreso = fechaRegreso;
	}
	/* (non-Javadoc)
	 * @see TipoDeDatos.Servicio#toString()
	 * Método toString
	 */
	@Override
	public String toString() {
		return "Origen=" + origen + ", destino=" + destino + ", Precio=" + getPrecio();
	}
}