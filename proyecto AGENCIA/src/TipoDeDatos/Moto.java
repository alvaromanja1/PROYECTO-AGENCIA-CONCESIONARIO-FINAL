package TipoDeDatos;

import java.util.ArrayList;

import Utilidades.Utilidades;



/** Clase moto
 * @author alvaro
 */ 


public class Moto extends Vehiculo implements Comparable {

	private int a�o;
	private int cilindrada;
	private int numTubosEscape;


public Moto(){
	super();	
}
/** Crea un nuevo veh�culo
 * @param a	a�o de la moto 
 * @param T	numeros de tubos de escape de la moto 
 * @param ci cilindrada de la moto

 */
public Moto(String M, String m, String c, float d, String mat,int a,int ci, int T, String rf){
	super(M,m,c,d,mat,rf);
	a�o=a;
	numTubosEscape=T;
	cilindrada=ci;
	
}
/** Devuelve el a�o de la moto
 * @return	a�o del moto
 */
public int getA�o() {
	return a�o;
}
/** Cambia el a�o de la moto 
 * @param a�o	a�o de la moto (no se permiten valores negativos)
 */
public void setA�o(int a�o) {
	this.a�o = a�o;
}
/** Devuelve la cilindrada de la moto
 * @return	cilindrada de la moto
 */
public int getCilindrada() {
	return cilindrada;
}
/** Cambia la cilindrada de la moto
 * @param cilindrada	cilindrada de la moto (no se permiten valores negativos, solo 100, 150, 200, 250, 500)
 */
public void setCilindrada(int cilindrada) {
	this.cilindrada = cilindrada;
}
/** Devuelve el numero de tubos de escape de la moto
 * @return	numero de tubos de escape de la moto
 */
public int getNumTubosEscape() {
	return numTubosEscape;
}
/** Cambia el numero de tubos de escape de la moto
 * @param numTubosEscape numero de tubos de escape de la moto (1 o 2)
 */
public void setNumTubosEscape(int numTubosEscape) {
	this.numTubosEscape = numTubosEscape;
}

/** Metodo desde el cual se leer�n los datos insertados por el usuario
 */
public void leer(){
	super.leer();
	System.out.println("�Introduzca el a�o de la motocicleta: ");
	a�o=Utilidades.leerEntero();
	System.out.println("Introduzca la cilindrada que desee de la moto (125, 200, 250, 500, 750, 900, 1000, 1200 o 2000 ");
	cilindrada=Utilidades.leerEntero();
	System.out.println("Introduzca el n�mero de tubos de escape que desea para su motocicleta");
	numTubosEscape=Utilidades.leerEntero();
	
}
/** Metodo desde el cual se mostrar�n los datos insertados por el usuario
 */
public void mostrar(){
	super.mostrar();
	System.out.println("A�o: "+a�o+ ", cilindrada: " +cilindrada+ " y tubos de escape " +numTubosEscape);
}
public String toString(){
	return super.toString() + "a�o" +a�o+ "cilindrada " +cilindrada+ "tubos de escape" +numTubosEscape;
}

/** M�todo de prueba
	 * @param args
	 */

@Override
public int compareTo(Object obj) {
		//COMPARAR POR MARCA 
		// TODO Auto-generated method stub
		int resul=0;
		if (marca.compareTo(((Moto)obj).marca)<0)
		resul=-1;
		else if (marca.compareTo(((Moto)obj).marca)>0)
		resul=1;
		else 
		resul=0;
			return resul;
	}
public void mostrarMotos(ArrayList <Moto> aMotos){
	for (int i=0; i<aMotos.size(); i++){
		Moto m=aMotos.get(i);
		System.out.println(m);
	}
}


public String getMatricula() {
	// TODO Auto-generated method stub
	return getMat();
}
	
}
