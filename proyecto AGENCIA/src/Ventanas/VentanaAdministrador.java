package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Ventanas.VentanaPrincipal;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

/**
 * @author USUARIO VENTANA ADMINISTRADOR DESDE LA CUAL SE PODRÁN INSERTAR DATOS
 *         SOBRE EL VEHÍCULO Y VIAJES A LA BASE DE DATOS
 */
public class VentanaAdministrador extends JFrame implements ActionListener {

	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JFrame ventanaAnterior;
	private JLabel lblTitulo, lblNombre, lblCodigo;
	private JButton btnAniadir, btnVolver;
	private JTextField txtCodigoViaje;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private JTextField txtPrecio;
	private JTextField txtPlazas;
	private JTextField txtRuta;
	private JButton btnAadirViaje;
	private JButton btnAñadirCoche;
	private JLabel lblFechaSalida;
	private JTextField txtFechaSalida;
	private JLabel lblFechaDeRegreso;
	private JTextField txtFechaRegreso;

	/**
	 * Create the frame.
	 */
	public VentanaAdministrador(JFrame va) {
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		lblTitulo = new JLabel("VENTANA ADMINISTRADOR");
		lblTitulo.setForeground(new Color(128, 0, 128));
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 45));
		panelNorte.add(lblTitulo);

		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		btnVolver.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnVolver.addActionListener(this);

		btnAñadirCoche = new JButton("A\u00D1ADIR COCHE");
		btnAñadirCoche.setBackground(UIManager.getColor("Button.background"));
		btnAñadirCoche.setForeground(Color.BLACK);
		btnAñadirCoche.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnAñadirCoche.addActionListener(this);
		panelSur.add(btnAñadirCoche);
		panelSur.add(btnVolver);

		btnAadirViaje = new JButton("A\u00D1ADIR VIAJE");
		btnAadirViaje.setBackground(UIManager.getColor("Button.background"));
		btnAadirViaje.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnAadirViaje.addActionListener(this);
		panelSur.add(btnAadirViaje);

		panelCentro = new JPanel();
		panelCentro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(
				0, 0, 0), null));
		panelCentro.setBackground(new Color(70, 130, 180));
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		JLabel lblCdigoDelViaje = new JLabel("C\u00F3digo del viaje :");
		lblCdigoDelViaje.setFont(new Font("Franklin Gothic Demi", Font.PLAIN,
				30));
		lblCdigoDelViaje.setBackground(Color.WHITE);
		lblCdigoDelViaje.setBounds(157, 185, 237, 35);
		panelCentro.add(lblCdigoDelViaje);

		JLabel lblOrigen = new JLabel("Origen :");
		lblOrigen.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblOrigen.setBounds(157, 231, 164, 36);
		panelCentro.add(lblOrigen);

		JLabel lblDestino = new JLabel("Destino :");
		lblDestino.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblDestino.setBounds(157, 278, 126, 35);
		panelCentro.add(lblDestino);

		JLabel lblPrecio = new JLabel("Precio :");
		lblPrecio.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblPrecio.setBounds(157, 324, 109, 37);
		panelCentro.add(lblPrecio);

		JLabel lblNmeroDePlazas = new JLabel("N\u00FAmero de plazas :\r\n");
		lblNmeroDePlazas.setFont(new Font("Franklin Gothic Demi", Font.PLAIN,
				30));
		lblNmeroDePlazas.setBounds(157, 372, 254, 44);
		panelCentro.add(lblNmeroDePlazas);

		JLabel lblRutaDeLa = new JLabel("Ruta de la foto :");
		lblRutaDeLa.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblRutaDeLa.setBounds(157, 423, 254, 35);
		panelCentro.add(lblRutaDeLa);

		txtCodigoViaje = new JTextField();
		txtCodigoViaje.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCodigoViaje.setBounds(431, 194, 215, 22);
		panelCentro.add(txtCodigoViaje);
		txtCodigoViaje.setColumns(10);

		txtOrigen = new JTextField();
		txtOrigen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtOrigen.setBounds(431, 241, 215, 22);
		panelCentro.add(txtOrigen);
		txtOrigen.setColumns(10);

		txtDestino = new JTextField();
		txtDestino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDestino.setBounds(431, 285, 215, 22);
		panelCentro.add(txtDestino);
		txtDestino.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPrecio.setBounds(431, 334, 215, 22);
		panelCentro.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtPlazas = new JTextField();
		txtPlazas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPlazas.setBounds(431, 386, 215, 22);
		panelCentro.add(txtPlazas);
		txtPlazas.setColumns(10);

		txtRuta = new JTextField();
		txtRuta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRuta.setBounds(431, 430, 215, 27);
		panelCentro.add(txtRuta);
		txtRuta.setColumns(10);

		lblFechaSalida = new JLabel("Fecha salida :");
		lblFechaSalida
				.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblFechaSalida.setBounds(157, 469, 208, 28);
		panelCentro.add(lblFechaSalida);

		txtFechaSalida = new JTextField();
		txtFechaSalida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFechaSalida.setBounds(431, 475, 215, 22);
		panelCentro.add(txtFechaSalida);
		txtFechaSalida.setColumns(10);

		lblFechaDeRegreso = new JLabel("Fecha de regreso:");
		lblFechaDeRegreso.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblFechaDeRegreso.setBounds(159, 508, 252, 27);
		panelCentro.add(lblFechaDeRegreso);

		txtFechaRegreso = new JTextField();
		txtFechaRegreso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtFechaRegreso.setBounds(431, 513, 215, 22);
		panelCentro.add(txtFechaRegreso);
		txtFechaRegreso.setColumns(10);
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);

	}

	/**
	 * Método que limpia los campos una vez insertados en la base de datos
	 */
	private void limpiarCampos() {

		txtCodigoViaje.setText("");
		txtOrigen.setText("");
		txtDestino.setText("");
		txtPrecio.setText("");
		txtPlazas.setText("");
		txtRuta.setText("");
		txtFechaSalida.setText("");
		txtFechaRegreso.setText("");
	}

	/**
	 * Comprobar que los campos no estén vacíos
	 * 
	 * @return false si hay algún campo vacío o true si todos están rellenos
	 */
	private boolean comprabarCamposRellenos() {
		if (txtCodigoViaje.equals("") || txtOrigen.equals("")
				|| txtDestino.equals("") || txtPlazas.equals("")
				|| txtPrecio.equals("") || txtRuta.equals("")
				|| txtFechaSalida.equals("") || txtFechaRegreso.equals(""))
			return false;
		else
			return true;
	}

	/**
	 * Método que comprueba si un anio insertado por el administrador en la base
	 * de datos es bisiesto o no
	 * 
	 * @param anio
	 * @return true si el anio es bisiesto y false si no lo es
	 */
	public boolean esBisiesto(int anio) {
		return (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0);
	}

	/**
	 * Dado un mes devolver el número de días de ese
	 * 
	 * @param mes
	 * @param anio
	 * @return número de días de mes
	 */
	public int diasDelMes(int mes, int anio) {
		int dias = 0;
		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dias = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		case 2:
			if (esBisiesto(anio))
				dias = 29;
			else
				dias = 28;
		}

		return dias;
	}

	/**
	 * Método que comprueba los datos insertados del dia mes y anio son
	 * correctos
	 * 
	 * @param fecha
	 * @return true si los datos insertados son correctos y false lo contrario
	 */
	public boolean esFechaCorrecta(String fecha) {
		int dia = Integer.parseInt(fecha.substring(6));
		int mes = Integer.parseInt(fecha.substring(4, 6));
		int anio = Integer.parseInt(fecha.substring(0, 4));
		if (anio < 0 || mes < 1 || mes > 12 || dia < 1
				|| dia > diasDelMes(mes, anio))
			return false;
		else
			return true;
	}

	/**
	 * Método que comprueba si la fecha de salida es menor que la de regreso
	 * 
	 * @param fSalida
	 * @param fRegreso
	 * @return true si la dfecha de salida es menor que la de regreso y false
	 *         alrevés
	 */
	public boolean esFechaMenor(String fSalida, String fRegreso) {
		if (fSalida.compareTo(fRegreso) < 0)
			return true;
		else
			return false;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnVolver) {
			this.dispose();
			ventanaAnterior.setVisible(true);
		} else if (botonPulsado == btnAñadirCoche) {
			this.dispose();
			new VentanaAniadirVehiculo(this);

		}

		// al pulsar el botón aniadir viaje verificar si todas las fechas son
		// correctas
		else if (botonPulsado == btnAadirViaje) {
			if (!comprabarCamposRellenos())
				JOptionPane.showMessageDialog(null,
						"ERROR! Falta algún campo por rellenar", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			else {
				int cod = Integer.parseInt(txtCodigoViaje.getText());
				String origen = txtOrigen.getText();
				String destino = txtDestino.getText();
				float precio = Float.parseFloat(txtPrecio.getText());
				int numplazas = Integer.parseInt(txtPlazas.getText());
				String foto = txtRuta.getText();
				String fSalida = txtFechaSalida.getText();
				String fRegreso = txtFechaRegreso.getText();
				if (!esFechaCorrecta(fSalida))
					JOptionPane.showMessageDialog(null,
							"ERROR! La fecha de salida no es correcta",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				else if (!esFechaCorrecta(fRegreso))
					JOptionPane.showMessageDialog(null,
							"ERROR! La fecha de llegada no es correcta",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				else if (!esFechaMenor(fSalida, fRegreso))
					JOptionPane
							.showMessageDialog(
									null,
									"ERROR! La fecha de salida no es anterior a la de regreso",
									"ERROR", JOptionPane.ERROR_MESSAGE);
				else {
					boolean existe = VentanaPrincipal.bd.existeViaje(cod,
							origen, destino, precio, numplazas, foto);
					if (existe) {
						JOptionPane.showMessageDialog(null,
								"ERROR! Viaje repetido", "ERROR",
								JOptionPane.ERROR_MESSAGE);
						limpiarCampos();
					} else {

						VentanaPrincipal.bd.insertarViaje(cod, origen, destino,
								precio, numplazas, foto, fSalida, fRegreso);
						JOptionPane.showMessageDialog(null,
								"Viaje añadido correctamente", "CORRECTO",
								JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
					}
				}
			}
		}

	}
}
