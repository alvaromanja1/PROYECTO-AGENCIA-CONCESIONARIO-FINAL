package Ventanas;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import TipoDeDatos.Vehiculo;
import TipoDeDatos.Viajes;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

/**
 * @author USUARIO
 *
 *         Ventana en la cual se procede al pago del viaje introduciendo tus
 *         datos personales
 */
public class VentanaPago extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField textApellido;
	private JTextField txtCorreoElectrónico;
	private JTextField txtFechaNacimiento;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtTarjeta;
	private JButton btnVolver;
	private JFrame ventanaAnterior;
	private JLabel lblNombre, lblApellido, lblCorreoElectrnico,
			lblFechaDeNacimiento, lblDireccinh, lblTelfono, lblNmeroDeTarjeta;
	private JButton btnFinalizarCompra;
	// private JCheckBox chckbxContrareembolso,chckbxTarjetaDeCrdito;
	private Checkbox chckbxContrareembolso, chckbxTarjetaDeCrdito;

	/**
	 * @param va
	 *            Aquí creamos la ventana VentanaPago Creamos los botones los
	 *            Jtextfield.. para que se vean en la ventana
	 */
	public VentanaPago(JFrame va) {
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblNombre.setBounds(10, 31, 122, 29);
		contentPane.add(lblNombre);

		lblApellido = new JLabel("Apellido :");
		lblApellido.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblApellido.setBounds(10, 73, 122, 29);
		contentPane.add(lblApellido);

		lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico :");
		lblCorreoElectrnico.setFont(new Font("Franklin Gothic Demi",
				Font.PLAIN, 25));
		lblCorreoElectrnico.setBounds(10, 115, 236, 29);
		contentPane.add(lblCorreoElectrnico);

		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento :\r\n");
		lblFechaDeNacimiento.setFont(new Font("Franklin Gothic Demi",
				Font.PLAIN, 25));
		lblFechaDeNacimiento.setToolTipText("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(10, 157, 258, 29);
		contentPane.add(lblFechaDeNacimiento);

		lblDireccinh = new JLabel("Direcci\u00F3n/Helbidea :\r\n");
		lblDireccinh.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblDireccinh.setBounds(10, 199, 248, 23);
		contentPane.add(lblDireccinh);

		lblTelfono = new JLabel("Tel\u00E9fono :");
		lblTelfono.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 25));
		lblTelfono.setBounds(10, 235, 149, 23);
		contentPane.add(lblTelfono);

		CheckboxGroup cbg = new CheckboxGroup();
		chckbxContrareembolso = new Checkbox("Contrareembolso", cbg, true);
		chckbxContrareembolso.setFont(new Font("Franklin Gothic Demi",
				Font.PLAIN, 15));
		chckbxContrareembolso.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lblNmeroDeTarjeta.setVisible(false);
				txtTarjeta.setVisible(false);
			}
		});
		chckbxContrareembolso.setBounds(106, 281, 180, 23);
		chckbxTarjetaDeCrdito = new Checkbox("Tarjeta de Cr\u00E9dito", cbg,
				false);
		chckbxTarjetaDeCrdito.setFont(new Font("Franklin Gothic Demi",
				Font.PLAIN, 15));
		chckbxTarjetaDeCrdito.setBounds(334, 281, 180, 23);
		chckbxTarjetaDeCrdito.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lblNmeroDeTarjeta.setVisible(true);
				txtTarjeta.setVisible(true);
			}
		});
		getContentPane().add(chckbxContrareembolso);
		getContentPane().add(chckbxTarjetaDeCrdito);
		contentPane.add(chckbxContrareembolso);

		lblNmeroDeTarjeta = new JLabel(
				"N\u00FAmero de tarjeta de cr\u00E9dito :");
		lblNmeroDeTarjeta.setFont(new Font("Franklin Gothic Demi", Font.PLAIN,
				25));
		lblNmeroDeTarjeta.setBounds(10, 322, 348, 23);
		contentPane.add(lblNmeroDeTarjeta);
		lblNmeroDeTarjeta.setVisible(false);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombre.setBounds(286, 31, 204, 25);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textApellido.setBounds(286, 73, 204, 25);
		contentPane.add(textApellido);
		textApellido.setColumns(10);

		txtCorreoElectrónico = new JTextField();
		txtCorreoElectrónico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCorreoElectrónico.setBounds(286, 115, 204, 25);
		contentPane.add(txtCorreoElectrónico);
		txtCorreoElectrónico.setColumns(10);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFechaNacimiento.setBounds(286, 157, 204, 25);
		contentPane.add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDireccion.setBounds(286, 195, 204, 26);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTelefono.setBounds(286, 234, 204, 27);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtTarjeta = new JTextField();
		txtTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTarjeta.setBounds(349, 321, 204, 27);
		contentPane.add(txtTarjeta);
		txtTarjeta.setColumns(10);
		txtTarjeta.setVisible(false);

		btnFinalizarCompra = new JButton("FINALIZAR COMPRA");
		btnFinalizarCompra.setBackground(UIManager
				.getColor("Button.background"));
		btnFinalizarCompra
				.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnFinalizarCompra.setBounds(334, 393, 236, 35);
		contentPane.add(btnFinalizarCompra);
		btnFinalizarCompra.addActionListener(this);

		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		btnVolver.setBounds(200, 393, 122, 35);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(this);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnVolver) {
			this.dispose();
			ventanaAnterior.setVisible(true);
		} else if (botonPulsado == btnFinalizarCompra) {
			this.dispose();
			JOptionPane.showMessageDialog(null, "Compra realizada con éxito",
					"Muchas gracias por su compra",
					JOptionPane.INFORMATION_MESSAGE);
			for (int i = 0; i < VentanaInicioSesion.carrito.size(); i++) {
				Object o = VentanaInicioSesion.carrito.get(i);
				if (o instanceof Viajes) {
					VentanaPrincipal.bd
							.modificarPlazasLibresViaje(((Viajes) o).getCod(),
									VentanaDatosViajes.numPlazas);
					Viajes viaje = VentanaPrincipal.bd
							.obtenerViaje(((Viajes) o).getCod());
					if (viaje.getNumPlazas() == 0) {
						VentanaPrincipal.bd
								.eliminarViaje(((Viajes) o).getCod());
					}
				}

			}
			new VentanaPortada();
		}

	}

}
