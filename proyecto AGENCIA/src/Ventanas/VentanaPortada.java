package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

/**
 * @author USUARIO
 * 
 *         Ventana en la cual aparece una imagen como icono de la agencia.
 *         Siendo esta ventana una portada.
 *
 */
public class VentanaPortada extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnInicio;

	/**
	 * @param args
	 *            Es la primera ventana del proyecto, es por eso que ponemos el
	 *            main.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPortada frame = new VentanaPortada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Añadimos solo un boton inicio, que al clickarle nos llevará a otra
	 * ventana. En donde empezará la gestión del viaje.
	 */
	public VentanaPortada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		PanelImagen panelImagen = new PanelImagen();
		getContentPane().add(panelImagen);
		panelImagen.setLayout(null);

		btnInicio = new JButton("INICIO");
		btnInicio.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnInicio.setBackground(UIManager.getColor("Button.background"));
		btnInicio.setBounds(405, 695, 133, 35);
		btnInicio.addActionListener(this);
		panelImagen.add(btnInicio);
		setSize(300, 300);
		setVisible(true);
		this.setBounds(160, 100, 1000, 800);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnInicio) {
			this.dispose();
			new VentanaPrincipal(this);
		}
	}
}
