package TipoDeDatos;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private String dni;
	private String nom;
	private String contrasenia;
	
	/** Crea un nuevo cliente
	 * @param dni	dni del cliente
	 * @param nom	nombre del cliente
	 * @param contrasenia contrase�a del cliente
	 */
	public Usuario(String dni, String nom, String contrasenia ) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.contrasenia = contrasenia;
		
	}
	/** Devuelve el dni del cliente
	 * @return	dni 
	 */
	public String getDni() {
		return dni;
	}
	/** Cambia el dni del cliente
	 * @param dni 
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/** Devuelve el nombre del cliente
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	/** Cambia el nombre del cliente
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Devuelve la contrase�a del cliente
	 * @return	contrase�a
	 */
	public String getContrasenia() {
		return contrasenia;
	}
	/** Cambia la contrase�a del cliente
	 * @param contrase�a
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
}
