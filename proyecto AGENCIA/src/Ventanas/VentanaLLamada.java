package Ventanas;

import java.awt.BorderLayout;
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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

/**
 * @author USUARIO
 * 
 *         Ventana en la aparece las opciones de ayuda que nos ofrece el
 *         servicio de atención al cliente
 *
 */
public class VentanaLLamada extends JFrame implements ActionListener {

	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	private JLabel lblFoto, lblTitulo;
	private JFrame ventanaanterior;
	private JButton btnVolver, btnColgar, btnAyudaViaje, btnAyudaCoche;
	private Clip audio;

	/**
	 * @param va
	 *            Aquí creamos los botones, labels.. para que se puedan ver en
	 *            la ventana
	 */
	public VentanaLLamada(JFrame va) {

		// Creamos un audio. Este audio es la voz la persona del servicio al
		// cliente explicandonos los servicios que puede
		// ofrecernos
		try {
			audio = AudioSystem.getClip();
			audio.open(AudioSystem.getAudioInputStream(new File(
					"SONIDO/atencionalcliente.wav")));
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

		ventanaanterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		lblTitulo = new JLabel("ATENCI\u00D3N AL CLIENTE");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 45));
		panelNorte.add(lblTitulo);

		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		btnVolver.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		panelSur.add(btnVolver);
		btnVolver.addActionListener(this);

		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		lblFoto = new JLabel("");
		ImageIcon i = new ImageIcon("FOTO/atencion-al-cliente.jpg");
		lblFoto.setIcon(i);
		lblFoto.setBounds(28, 163, 278, 283);
		panelCentro.add(lblFoto);

		btnColgar = new JButton("Colgar");
		btnColgar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		btnColgar.setBackground(UIManager.getColor("Button.background"));
		btnColgar.setBounds(359, 379, 518, 49);
		panelCentro.add(btnColgar);
		btnColgar.addActionListener(this);

		btnAyudaCoche = new JButton("\u00BFComo puedo comprar un coche ?");
		btnAyudaCoche.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		btnAyudaCoche.setBackground(UIManager.getColor("Button.background"));
		btnAyudaCoche.setBounds(359, 282, 518, 49);
		panelCentro.add(btnAyudaCoche);
		btnAyudaCoche.addActionListener(this);

		btnAyudaViaje = new JButton("\u00BFComo puedo comprar un viaje?");
		btnAyudaViaje.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		btnAyudaViaje.setBackground(UIManager.getColor("Button.background"));
		btnAyudaViaje.setBounds(359, 182, 518, 49);
		panelCentro.add(btnAyudaViaje);
		btnAyudaViaje.addActionListener(this);

		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnVolver) {
			this.dispose();
			audio.stop();
			ventanaanterior.setVisible(true);
		} else if (botonPulsado == btnColgar) {

			this.dispose();
			audio.stop();
			new VentanaPrincipal(this);

		} else if (botonPulsado == btnAyudaViaje) {
			this.dispose();
			audio.stop();
			new VentanaAyudaViaje(this);
		} else if (botonPulsado == btnAyudaCoche) {
			this.dispose();
			audio.stop();
			new VentanaAyudaCoche(this);
		}

	}

}