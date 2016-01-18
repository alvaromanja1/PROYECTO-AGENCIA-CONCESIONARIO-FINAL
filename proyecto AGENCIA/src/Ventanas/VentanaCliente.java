package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Ventanas.VentanaPrincipal;
import Ventanas.VentanaFotosCoches;
import TipoDeDatos.Cliente;

import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;

import TipoDeDatos.Viajes;

/**
 * @author USUARIO Ventana Cliente desde donde se podrá pagar, ver la factura,
 *         comprar más viajes y más vehículos
 */
public class VentanaCliente extends JFrame implements ActionListener {

	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	private JFrame ventanaAnterior;
	private JButton btnComprarCoche, btnComprarViaje, btnPagar, btnVerCarrito,
			btnVolver;
	private JLabel lblBienvenido;
	private JLabel lblFotoCliente;
	private Cliente c;
	private String foto;
	public static JTextField lblNombre;

	/**
	 * Create the frame. Crea la ventana cliente aniadiendo distintos labels y
	 * botones
	 */
	public VentanaCliente(JFrame va) {
		ventanaAnterior = va;
		c = VentanaPrincipal.bd.obtenerCliente(VentanaInicioSesion.dniCliente);
		if (c != null)
			System.out.println("Ruta: " + c.getFoto());
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		btnVolver.addActionListener(this);
		panelSur.add(btnVolver);

		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		btnComprarCoche = new JButton("COMPRAR OTRO COCHE");
		btnComprarCoche.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnComprarCoche.setBackground(UIManager.getColor("Button.background"));
		btnComprarCoche.setBounds(370, 428, 301, 39);
		panelCentro.add(btnComprarCoche);
		btnComprarCoche.addActionListener(this);

		btnComprarViaje = new JButton("COMPRAR OTRO VIAJE");
		btnComprarViaje.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnComprarViaje.setBackground(UIManager.getColor("Button.background"));
		btnComprarViaje.setBounds(370, 378, 301, 37);
		panelCentro.add(btnComprarViaje);
		btnComprarViaje.addActionListener(this);

		btnPagar = new JButton("PAGAR");
		btnPagar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		btnPagar.setBackground(UIManager.getColor("Button.background"));
		btnPagar.setBounds(370, 330, 301, 35);
		panelCentro.add(btnPagar);
		btnPagar.addActionListener(this);
		// Inserta ala foto del cliente
		ImageIcon im = new ImageIcon(c.getFoto());
		lblFotoCliente = new JLabel(im);
		lblFotoCliente.setBounds(95, 242, 229, 317);
		panelCentro.add(lblFotoCliente);

		btnVerCarrito = new JButton("VER CARRITO");
		btnVerCarrito.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnVerCarrito.setBackground(UIManager.getColor("Button.background"));
		btnVerCarrito.setBounds(370, 278, 301, 35);
		panelCentro.add(btnVerCarrito);

		lblNombre = new JTextField();
		lblNombre.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setText("Cliente: " + c.getNom());
		lblNombre.setBounds(65, 174, 284, 35);
		panelCentro.add(lblNombre);
		lblNombre.setColumns(10);

		btnVerCarrito.addActionListener(this);
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);

	}

	// Acciones una vez dado a los distintos botones
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnVolver) {
			this.dispose();
			ventanaAnterior.setVisible(true);
			// Podemos ver el carrito
		} else if (botonPulsado == btnVerCarrito) {
			this.dispose();
			new VentanaCarritoViajes(this);
			// Boton para pagar
		} else if (botonPulsado == btnPagar) {
			this.dispose();
			new VentanaPago(this);
			// JOption pane en el cual escribiremos el vehículo que deseamos
			// alquilar
		} else if (botonPulsado == btnComprarCoche) {
			this.dispose();
			String marca = JOptionPane
					.showInputDialog("Selecciona la marca: (ferrari, reanult, honda (Moto)" /*
																							 * +
																							 * m
																							 */);
			String modelo = JOptionPane
					.showInputDialog("Selecciona la modelo: (enzo, laguna, cbr");
			new VentanaFotosCoches(this, marca, modelo);
		} else if (botonPulsado == btnComprarViaje) {
			this.dispose();
			String d = VentanaInicioSesion.txtDni2.getText();
			new VentanaFotosViaje(this, d);

		}

	}

}
