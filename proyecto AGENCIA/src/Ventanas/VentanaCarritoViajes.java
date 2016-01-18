package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import TipoDeDatos.Viajes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import TipoDeDatos.Vehiculo;

import javax.swing.JTextArea;
import Ventanas.VentanaDatosViajes;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

/**
 * @author USUARIO Ventana carrito de los viajes donde saldra el precio total de
 *         compra
 */
public class VentanaCarritoViajes extends JFrame implements ActionListener,
		MouseListener {

	private JPanel contentPane, PanelCentro;
	private JScrollPane scrollfotos;
	private JButton btnVolver, btnPagar;
	private JFrame ventanaAnterior;
	private JTextArea textArea;

	/**
	 * Método que sirve para cargar el texto de los viajes y vehículos comprados
	 */
	public void cargarTexto() {
		String texto = "";
		double total = 0;
		for (int i = 0; i < VentanaInicioSesion.carrito.size(); i++) {
			Object o = VentanaInicioSesion.carrito.get(i);
			texto = texto + o.toString() + "\n";
			if (o instanceof Viajes)
				total = total + ((Viajes) o).getPrecio()
						* ((VentanaDatosViajes.numPlazas));
			else if (o instanceof Vehiculo)
				total = total + ((Vehiculo) o).getPrecio();

		}

		texto = texto + "\n\n TOTAL COMPRA: " + total + " €";
		textArea.setText(texto);
	}

	/**
	 * Create the frame.
	 */
	public VentanaCarritoViajes(JFrame va) {
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		JLabel lblCarritoDeViajes = new JLabel("CARRITO DE VIAJES");
		lblCarritoDeViajes.setFont(new Font("Dialog", Font.BOLD, 45));
		panelNorte.add(lblCarritoDeViajes);

		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		panelSur.add(btnVolver);
		btnVolver.addActionListener(this);

		btnPagar = new JButton("PAGAR");
		btnPagar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnPagar.setBackground(UIManager.getColor("Button.background"));
		panelSur.add(btnPagar);
		btnPagar.addActionListener(this);

		PanelCentro = new JPanel();
		scrollfotos = new JScrollPane(PanelCentro);
		PanelCentro.setLayout(null);

		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textArea.setBounds(12, 13, 950, 615);
		PanelCentro.add(textArea);
		scrollfotos.addMouseListener(this);
		PanelCentro.addMouseListener(this);
		cargarTexto();
		contentPane.add(scrollfotos, BorderLayout.CENTER);
		setVisible(true);
		this.setBounds(160, 100, 1000, 800);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnVolver) {
			this.dispose();
			ventanaAnterior.setVisible(true);
		} else if (botonPulsado == btnPagar) {
			this.dispose();
			new VentanaPago(this);
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
