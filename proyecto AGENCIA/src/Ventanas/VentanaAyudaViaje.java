package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

/**
 * @author USUARIO Clase ventanaAyuda en la cual nos ayudará si tenemos alguna
 *         duda con el procediemiento de la página al comprar un vaije
 */
public class VentanaAyudaViaje extends JFrame implements ActionListener {

	private JPanel contentPane, panelCentro, panelNorte, panelSur;
	private JFrame ventanaAnterior;
	private Clip audio;
	private JLabel lblTitulo;
	private JButton btnVolver;
	private JButton btnComprarViaje;
	private JLabel lblInstruccion1;
	private JLabel lblInstruccion2;
	private JLabel lblInstruccion3;

	/**
	 * Create the frame. Inserta el sonido de la operadora la cual nos ayudará a
	 * solucionar nuestras dudas
	 */
	public VentanaAyudaViaje(JFrame va) {

		try {
			audio = AudioSystem.getClip();
			audio.open(AudioSystem.getAudioInputStream(new File(
					"SONIDO/ayudaviaje.wav")));
			audio.start();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		lblTitulo = new JLabel("\u00BFC\u00D3MO COMPRAR UN NUEVO VIAJE?");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 25));
		panelNorte.add(lblTitulo);

		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		panelSur.add(btnVolver);
		btnVolver.addActionListener(this);

		btnComprarViaje = new JButton("PROCEDER A LA COMPRA");
		btnComprarViaje.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnComprarViaje.setBackground(UIManager.getColor("Button.background"));
		panelSur.add(btnComprarViaje);
		btnComprarViaje.addActionListener(this);

		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		lblInstruccion1 = new JLabel("1-Debe iniciar sesi\u00F3n");
		lblInstruccion1
				.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblInstruccion1.setBounds(78, 97, 252, 24);
		panelCentro.add(lblInstruccion1);

		lblInstruccion2 = new JLabel(
				"2-Seleccionar los viajes disponibles en las fechas libres");
		lblInstruccion2
				.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblInstruccion2.setBounds(78, 151, 637, 24);
		panelCentro.add(lblInstruccion2);

		lblInstruccion3 = new JLabel("3-Comprar el viaje");
		lblInstruccion3
				.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblInstruccion3.setBounds(78, 200, 243, 24);
		panelCentro.add(lblInstruccion3);

		this.setVisible(true);
	}

	// Si boton pulsado es volver se para el audio y se vuelve a la ventana
	// anterior y sino se irá a la página de inicio sesión
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnVolver) {
			this.dispose();
			audio.stop();
			ventanaAnterior.setVisible(true);
		} else if (botonPulsado == btnComprarViaje) {
			this.dispose();
			audio.stop();
			new VentanaInicioSesion(this);
		}
	}

}