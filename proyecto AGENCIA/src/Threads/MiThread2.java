package Threads;

import Ventanas.*;


/**
 * @author USUARIO
 *M�todo que mediante un thread hace que una label se visualize durante 4 segundos y despu�s sea invisibnle, as� bucle infinito
 */
public class MiThread2 extends Thread {
	
	public MiThread2(){
		super();
	}
	
	public void run(){
		
		while(true){
			VentanaCliente.lblNombre.setVisible(false);
			try {
				sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			VentanaCliente.lblNombre.setVisible(true);
			try {
				sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}


