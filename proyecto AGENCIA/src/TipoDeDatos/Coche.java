package TipoDeDatos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import Interfaces.Vendible;
import Utilidades.Utilidades;




/** Clase coche.
 * De esta heredar�n la clase deportivo y familiar
 * @author alvaro
 */ 


public class Coche extends Vehiculo implements Comparable ,Vendible {

	protected int a�o;
	protected int numPuertas;
	public Coche(){
		super();	
	}

	/** Crea un nuevo veh�culo
	 * @param a	a�o del vehiculo
	 * @param n	numero de puertas del vehiculo
	 */
	
	public Coche(String M, String m, String c, float d,  String mat, int a, int n,String rf){
		super(M,m,c,d,mat,rf);
		a�o=a;
		numPuertas=n;
	}
	/** Devuelve el a�o del coche
	 * @return	a�o del coche
	 */
	public int getA�o() {
		return a�o;
	}
	/** Cambia el a�o del coche
	 * @param a�o  a�o del coche (siempre positivo)
	 */
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	/** Devuelve el numero de puertas del coche
	 * @return	numero de puertas del coche
	 */
	public int getNumPuertas() {
		return numPuertas;
	}
	/** Cambia el numero de puertas del cocche
	 * @param numpuertas numero de puertas del coche (numero positivo, o 2 o 4)
	 */
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}


	/** Metodo desde el cual se leer�n los datos insertados por el usuario
	 */
	public void leer(){
		super.leer();
		System.out.println("Introduzca el a�o del coche: ");
		a�o=Utilidades.leerEntero();
		System.out.println("Introduzca el numero de puertas del coche (3 � 5)");
		numPuertas=Utilidades.leerEntero();

	}
	/** Metodo desde el cual se mostrar�n los datos insertados por el usuario
	 */
	public void mostrar(){
		super.mostrar();
		System.out.println("A�o: "+a�o+ "numero de puertas: " +numPuertas);
	}
	public String toString(){
		return super.toString() + "a�o" +a�o+ "numero de puertas " +numPuertas;
	}

	/** M�todo compareTo, este m�todo compara dos marcas y as� devolver 1, -1 o 0.
	 * Devolver� 0 si: ambas marcas son iguales
	 * Devolver� 1 si: marca.compareTo(((Coche)obj).marca)>0
	 * Devolver� -1 si: marca.compareTo(((Coche)obj).marca)<0
	 * @param args
	 */
	@Override
	public int compareTo(Object obj) {
		//COMPARAR POR MARCA 
		// TODO Auto-generated method stub
		int resul=0;
		if (marca.compareTo(((Coche)obj).marca)<0)
			resul=-1;
		else if (marca.compareTo(((Coche)obj).marca)>0)
			resul=1;
		else 
			resul=0;
		return resul;
	}



	@Override
	public void vender() {
		// TODO Auto-generated method stub

	}


}
