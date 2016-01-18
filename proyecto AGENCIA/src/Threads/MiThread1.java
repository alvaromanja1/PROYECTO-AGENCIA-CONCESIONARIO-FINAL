package Threads;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import Ventanas.VentanaLLamada;
import Ventanas.VentanaThread;


/**
 * @author USUARIO
 *Thread de sonido que se aplicar� a distintas ventanas
 */
public class MiThread1 extends Thread {
    JFrame va;
	public MiThread1(JFrame va){
		super();
		this.va=va;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		
		VentanaThread vt1 = new VentanaThread();

		int EXTERNAL_BUFFER_SIZE = 524288;

		String filename = "./SONIDO/llamadatelefono.wav";

		 

		File soundFile = new File(filename);

		if (!soundFile.exists()) { 

			System.err.println("Wave file not found: " + filename);

			return;

		} 

		AudioInputStream audioInputStream = null;

		try { 

			audioInputStream = AudioSystem.getAudioInputStream(soundFile);

		} catch (UnsupportedAudioFileException e1) { 

			e1.printStackTrace();

			return;

		} catch (IOException e1) { 

			e1.printStackTrace();

			return;

		} 

		AudioFormat format = audioInputStream.getFormat();

		SourceDataLine auline = null;

		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try { 

			auline = (SourceDataLine) AudioSystem.getLine(info);

			auline.open(format);

		} catch (LineUnavailableException e) { 

			e.printStackTrace();

			return;

		} catch (Exception e) { 

			e.printStackTrace();

			return;

		} 

		if (auline.isControlSupported(FloatControl.Type.PAN)) { 

			FloatControl pan = (FloatControl) auline

					.getControl(FloatControl.Type.PAN);

			
		auline.start();

		int nBytesRead = 0;

		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

		try { 

			while (nBytesRead != -1) { 

				nBytesRead = audioInputStream.read(abData, 0, abData.length);

				if (nBytesRead >= 0) 

					auline.write(abData, 0, nBytesRead);

			} 

		} catch (IOException e) { 

			e.printStackTrace();

			return;

		} finally { 

			auline.drain();

			auline.close();

		}
		}
        
		vt1.dispose();
		new VentanaLLamada(va);
	
	}
}


	




