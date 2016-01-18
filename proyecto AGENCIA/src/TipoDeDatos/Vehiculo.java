package TipoDeDatos;

import java.io.Serializable;

import Utilidades.Utilidades;



/** Clase vehiculo.
 * De esta heredar�n la clase coche y moto
 * @author alvaro
 */ 

public class Vehiculo implements Serializable{
   
	
	protected float precio;
	protected String color;
	protected String modelo;
	protected String marca;
	protected String mat;
	protected String rutaFoto;
	public Vehiculo(){
		
	}
	/** Crea un nuevo veh�culo
	 * @param d	precio del vehiculo
	 * @param c	color del vehiculo
	 * @param m	modelo del vehiculo
	 * @param M	Marca del veh�culo
	 */
	public Vehiculo(String M,String m,String c, float d, String i, String rf){
		
		precio=d;
		color=c;
		modelo=m;
		marca=M;
		mat=i;
		rutaFoto=rf;
	}
	
	
	public String getRutaFoto() {
		return rutaFoto;
	}
	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}
	
	/** Devuelve el precio del coche
	 * @return	precio del coche
	 */
	public double getPrecio() {
		return precio;
	}
	
	/** Cambia el precio del coche
	 * @param precio	precio del coche (no se permiten valores negativos)
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/** Devuelve el color del coche
	 * @return	Color del coche
	 */
	public String getColor() {
		return color;
	}
	/** Cambia el color del coche
	 * @param color	color del coche
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/** Devuelve el modelo del coche
	 * @return	modelo del coche
	 */
	public String getModelo() {
		return modelo;
	}
	/** Cambia el modelo del coche
	 * @param modelo	modelo del coche
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/** Devuelve la marca del coche
	 * @return	marca del coche
	 */
	public String getMarca() {
		return marca;
	}
	/** Cambia la marca del coche
	 * @param marca  marca del coche
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	

	/**
	 * @return matricula del coche
	 */
	public String getMat() {
		return mat;
	}
	/**
	 * @param mat
	 */
	public void setMat(String mat) {
		this.mat = mat;
	}

	
	/** Metodo desde el cual se leer�n los datos insertados por el usuario
	 */public  void leer(){
		System.out.println("Inserta el precio que desee gastarse: ");
		precio=(float) Utilidades.leerReal();
		
		System.out.println("�Qu� marca de veh�culo desea?");
		marca=Utilidades.leerCadena();
		
		System.out.println("�Qu� color de veh�culo desea?");
		color=Utilidades.leerCadena();
		
		System.out.println("Inserta el modelo de veh�culo");
		modelo=Utilidades.leerCadena();
		
	}
	
	/** Metodo desde el cual se mostrar�n los datos insertados por el usuario
	 */
	public void mostrar(){
		System.out.println("Marca: " +marca+ "modelo: " +modelo+ ", color: " +color+ " , precio: " +precio+  " y matr�cula: " +mat);
	}
	
	public String toString(){
		return "Marca: " +marca+ ", modelo: " +modelo+ ", color: " +color+ ", precio: " +precio+" y matr�cula: " +mat;
	}
	}
