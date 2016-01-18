package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import BD.BD;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JButton;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import javax.swing.UIManager;

/**
 * @author USUARIO Ventana donde el usuario podrá aceder a la página o
 *         registrarse si aún no lo ha echo
 */
public class VentanaInicioSesion extends JFrame implements ActionListener {

	private JButton btnSalir, btnAceptar, btnRegistrarse;
	private JPanel contentPane;
	private JTextField txtDni;
	public static JTextField txtDni2;
	private JTextField txtNombre;
	private JTextField txtEdad;;
	private JLabel lblDni, lblNombre, lblDni2, lblEdad;
	private JPanel panelCentro, panelSur, panelNorte, panelEste, panelOeste;
	private JFrame ventanaAnterior;
	public static String dniCliente;
	public static LinkedList carrito;

	/**
	 * Método que lo pone invisible inicialmente(para que solo apareczca visible
	 * el label introduce el dni) los demás campos se convertirán en visibles si
	 * el usuario aun no se registró en nuestra página online
	 */
	private void ponerInvisible() {
		btnRegistrarse.setVisible(false);
		lblEdad.setVisible(false);
		lblDni2.setVisible(false);
		lblNombre.setVisible(false);
		txtDni2.setVisible(false);
		txtNombre.setVisible(false);
		txtEdad.setVisible(false);

	}

	/**
	 * Pone los campos visibles si el dni no estaba aun guardado en la base de
	 * datos
	 */
	private void ponerVisible() {
		btnRegistrarse.setVisible(true);
		lblEdad.setVisible(true);
		lblDni2.setVisible(true);
		lblNombre.setVisible(true);
		txtDni2.setVisible(true);
		txtNombre.setVisible(true);
		txtEdad.setVisible(true);

	}

	/**
	 * Create the frame. Crea la ventana
	 */
	public VentanaInicioSesion(JFrame va) {

		carrito = new LinkedList();
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(
				139, 0, 139), null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		panelSur = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSur.getLayout();
		flowLayout.setAlignOnBaseline(true);
		contentPane.add(panelSur, BorderLayout.SOUTH);

		btnSalir = new JButton("SALIR");
		btnSalir.setBackground(UIManager.getColor("Button.background"));
		btnSalir.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		/*
		 * btnSalir.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { System.exit(0); } });
		 */
		btnSalir.addActionListener(this);

		panelSur.add(btnSalir);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBackground(UIManager.getColor("Button.background"));
		btnAceptar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnAceptar.addActionListener(this);
		panelSur.add(btnAceptar);
		// Separamos nuestra ventana en distintos paneles para aniadir cada cosa
		// con un cierto orden
		panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);

		panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);

		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		lblDni = new JLabel("Introduce tu dni");
		lblDni.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 40));
		lblDni.setBounds(161, 203, 297, 34);
		panelCentro.add(lblDni);

		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtDni.setForeground(Color.BLACK);
		txtDni.setBackground(UIManager.getColor("TextPane.background"));
		txtDni.setBounds(475, 203, 242, 34);
		panelCentro.add(txtDni);
		txtDni.setColumns(10);

		btnRegistrarse = new JButton("REGISTRARSE\r\n");
		btnRegistrarse.setBackground(UIManager.getColor("Button.background"));
		btnRegistrarse.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnRegistrarse.addActionListener(this);

		btnRegistrarse.setBounds(706, 284, 179, 46);
		panelCentro.add(btnRegistrarse);

		lblDni2 = new JLabel("DNI : ");
		lblDni2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblDni2.setBounds(245, 313, 71, 27);
		panelCentro.add(lblDni2);

		txtDni2 = new JTextField();
		txtDni2.setBounds(427, 313, 151, 28);
		panelCentro.add(txtDni2);
		txtDni2.setColumns(10);

		lblNombre = new JLabel("NOMBRE : ");
		lblNombre.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblNombre.setBounds(245, 394, 151, 27);
		panelCentro.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBackground(UIManager.getColor("TextPane.background"));
		txtNombre.setBounds(427, 394, 151, 29);
		panelCentro.add(txtNombre);
		txtNombre.setColumns(10);

		lblEdad = new JLabel("EDAD :");
		lblEdad.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblEdad.setBounds(245, 472, 106, 27);
		panelCentro.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setBackground(UIManager.getColor("TextPane.background"));
		txtEdad.setBounds(427, 478, 151, 27);
		panelCentro.add(txtEdad);
		txtEdad.setColumns(10);

		JLabel lblNewLabel = new JLabel("INICIO SESI\u00D3N");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 45));
		lblNewLabel.setBounds(306, 44, 342, 80);
		panelCentro.add(lblNewLabel);
		ponerInvisible();
		this.setBounds(160, 100, 1000, 800);

		this.setVisible(true);
	}

	// Si boton pulsado es aceptar habrá que verificar que el dni existe y si no
	// existía que los datos insertados por
	// el usuario sean correctos
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();

		if (botonPulsado == btnSalir) {
			System.exit(0);
		}
		// Si lo que introducimos en el campo dni son tres * entonces
		// accederemos a la ventana Administrador
		else if (botonPulsado == btnAceptar) {
			String d = txtDni.getText();
			if (d.equals("***")) {
				new VentanaAdministrador(this);
				txtDni.setText("");
				this.dispose();
			} else {
				boolean existe = VentanaPrincipal.bd.existeCliente(d);
				if (existe) {
					dniCliente = txtDni.getText();
					txtDni.setText("");
					new VentanaFotosViaje(this, d);
					this.setVisible(false);
				} else {
					ponerVisible();

				}
			}

		}
		// algún campo insertado no es correcto
		else if (botonPulsado == btnRegistrarse) {
			if (txtDni2.getText().equals("") || txtNombre.getText().equals("")
					|| txtEdad.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"ERROR! Falta por rellenar algún campo", "ERROR",
						JOptionPane.ERROR_MESSAGE);

			} else if (!txtDni.getText().equals(txtDni2.getText())) {
				JOptionPane.showMessageDialog(null,
						"ERROR! El dni no es correcto", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
			// datos insertados por el usuario correctos
			else {
				String d = txtDni2.getText();
				String n = txtNombre.getText();
				int ed = Integer.parseInt(txtEdad.getText());
				VentanaPrincipal.bd.insertarCliente(d, n);
				JOptionPane.showMessageDialog(null,
						"Registro completado con exito", "REGISTRADO",
						JOptionPane.INFORMATION_MESSAGE);
				txtDni2.setText("");
				txtNombre.setText("");
				txtEdad.setText("");
				ponerInvisible();
			}

		}

	}

}
