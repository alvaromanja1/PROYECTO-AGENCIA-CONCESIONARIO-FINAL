package TipoDeDatos;



/**
 * @author USUARIO
 *Clase servicio
 */
public class Servicio {
	protected  int cod;
	protected String foto;
	protected double precio;
	
	
	
   /**
    * Método que crea un servicio con los siguientes parámetros
 * @param cod
 * @param foto
 * @param precio
 */
public Servicio(int cod, String foto, double precio) {
		super();
		this.cod = cod;
		this.foto = foto;
		this.precio = precio;
	}

	/**
	 * Método que de devuelve el código del servicio
	 * @return cod
	 */
	public int getCod() {
		return cod;
	}
	
	/**
	 * Permite cambiar el código desde cualquier otra clase
	 * @param cod
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}
	/**
	 * Método que devuelve una foto
	 * @return foto
	 */
	public String getFoto() {
		return foto;
	}
	
	/**
	 * Método que permite cambiar la foto del servicio desde cualquier otra clase
	 * @param foto
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	/**
	 * método que obtiene el precio del servicio
	 * @return precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 *Método que permite cambiar el precio del servicio en cualquier otra clase
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Método toString 
	 */
	@Override
	public String toString() {
		return "Servicio [cod=" + cod + ", ruta=" + foto+ ", precio=" + precio
				+ "]";
	}
	
	
}
