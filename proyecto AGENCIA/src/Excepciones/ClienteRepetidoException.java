package Excepciones;

/**
 * 
 * Este m�todo lanza una excepci�n por cada usuario que est� repetido
 * @author alvaro
 *
 */
public class ClienteRepetidoException extends Exception{
	private String mensaje;
public ClienteRepetidoException (String m){
	super();
	mensaje=m;
	
}
public String toString (){
	return mensaje;
}
}


