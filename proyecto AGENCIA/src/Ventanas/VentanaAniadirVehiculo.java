package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import TipoDeDatos.Vehiculo;
import TipoDeDatos.Viajes;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

/**
 * @author USUARIO Ventana desde la cual podemos aniadir un vehículo a la base
 *         de datos
 */
public class VentanaAniadirVehiculo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtColor;
	private JTextField txtPrecio;
	private JTextField txtMatricula;
	private JTextField txtRuta;
	private JFrame ventanaAnterior;
	private JButton btnVolver, btnAniadirCoche;
	private String Marca;
	private LinkedList<Vehiculo> Marcas;

	/**
	 * Create the frame.
	 */
	public VentanaAniadirVehiculo(JFrame va) {

		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblAniadirNuevoCoche = new JLabel("A\u00D1ADIR NUEVO COCHE");
		lblAniadirNuevoCoche.setFont(new Font("Dialog", Font.BOLD, 45));
		panel.add(lblAniadirNuevoCoche);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		panel_1.add(btnVolver);
		btnVolver.addActionListener(this);

		btnAniadirCoche = new JButton("A\u00D1ADIR COCHE");
		btnAniadirCoche.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnAniadirCoche.setBackground(UIManager.getColor("Button.background"));
		panel_1.add(btnAniadirCoche);
		btnAniadirCoche.addActionListener(this);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel lblMarca = new JLabel("Marca :");
		lblMarca.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblMarca.setBounds(145, 59, 116, 32);
		panel_2.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo :");
		lblModelo.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblModelo.setBounds(145, 104, 141, 35);
		panel_2.add(lblModelo);

		JLabel lblColor = new JLabel("Color :");
		lblColor.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblColor.setBounds(145, 152, 119, 24);
		panel_2.add(lblColor);

		JLabel lblPrecio = new JLabel("Precio :");
		lblPrecio.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblPrecio.setBounds(145, 189, 109, 33);
		panel_2.add(lblPrecio);

		JLabel lblMatricula = new JLabel("Matricula :");
		lblMatricula.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblMatricula.setBounds(145, 226, 169, 32);
		panel_2.add(lblMatricula);

		JLabel lblRutaFoto = new JLabel("Ruta Foto :");
		lblRutaFoto.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblRutaFoto.setBounds(145, 272, 159, 23);
		panel_2.add(lblRutaFoto);

		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMarca.setBounds(323, 65, 149, 22);
		panel_2.add(txtMarca);
		txtMarca.setColumns(10);

		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtModelo.setBounds(323, 111, 149, 22);
		panel_2.add(txtModelo);
		txtModelo.setColumns(10);

		txtColor = new JTextField();
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtColor.setBounds(323, 154, 149, 22);
		panel_2.add(txtColor);
		txtColor.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPrecio.setBounds(323, 195, 149, 22);
		panel_2.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatricula.setBounds(323, 234, 149, 22);
		panel_2.add(txtMatricula);
		txtMatricula.setColumns(10);

		txtRuta = new JTextField();
		txtRuta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRuta.setBounds(323, 275, 149, 22);
		panel_2.add(txtRuta);
		txtRuta.setColumns(10);
		this.setVisible(true);
	}

	/**
	 * Método que limpia los campos una vez insertados en la base de datos
	 */
	private void limpiarCampos() {

		txtMarca.setText("");
		txtModelo.setText("");
		txtColor.setText("");
		txtPrecio.setText("");
		txtMatricula.setText("");
		txtRuta.setText("");
	}

	/**
	 * Comprobar que los campos no estén vacíos
	 * 
	 * @return false si hay algún campo vacío o true si todos están rellenos
	 */
	private boolean comprabarCamposRellenos() {
		if (txtMarca.equals("") || txtModelo.equals("") || txtColor.equals("")
				|| txtMatricula.equals("") || txtPrecio.equals("")
				|| txtRuta.equals(""))
			return false;
		else
			return true;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnVolver) {
			this.dispose();
			ventanaAnterior.setVisible(true);
		}

		// Si falta algún campo por rellenar saldra un JOptionPane avisándonoslo
		else if (botonPulsado == btnAniadirCoche) {
			if (!comprabarCamposRellenos())
				JOptionPane.showMessageDialog(null,
						"ERROR! Falta algún campo por rellenar", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			else {
				String color = txtColor.getText();
				Marca = txtMarca.getText();
				String modelo = txtModelo.getText();
				float precio = Float.parseFloat(txtPrecio.getText());
				String matricula = txtMatricula.getText();
				String foto = txtRuta.getText();

				// JOptionPane si hay algún vehículo repetido
				boolean existe = VentanaPrincipal.bd.existeVehiculos(color,
						Marca, modelo, precio, matricula, foto);
				if (existe) {
					JOptionPane.showMessageDialog(null,
							"ERROR! Vehiculo repetido", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					limpiarCampos();
				}
				// Si ninguna de las anteriores se aniade a la base de datos
				else {
					VentanaPrincipal.bd.insertarVehiculo(color, Marca, modelo,
							precio, matricula, foto);
					JOptionPane.showMessageDialog(null,
							"Vehiculo añadido correctamente", "CORRECTO",
							JOptionPane.INFORMATION_MESSAGE);
					limpiarCampos();
				}
			}
		}

	}
}
