package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import TipoDeDatos.Coche;
import TipoDeDatos.Vehiculo;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

/**
 * Ventana que muestra las prestaciones del vehiculo seleccionado
 * 
 * @author alvaro
 *
 */
public class VentanaDatosCoche extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JFrame ventanaAnterior;
	private JButton btnVolver, btnComprar;
	private JLabel lblFoto, lblPrecio, lblCaballos, lblColor, lblModelo,
			lblMarca;
	private String ruta;
	private Vehiculo c;
	private JLabel lblModelo_1;
	private JLabel lblColor_1;
	private JLabel lblPrecio_1;

	/**
	 * Metodo que muestra la marca, modelo, color, caballos y precio del coche
	 * seleccionado (coche c)
	 * 
	 * @param va
	 * @param c
	 */
	public VentanaDatosCoche(JFrame va, String r) {
		ruta = r;
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblDatosDelCoche = new JLabel("DATOS DEL COCHE SELECCIONADO");
		lblDatosDelCoche.setFont(new Font("Dialog", Font.BOLD, 45));
		panel.add(lblDatosDelCoche);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnComprar = new JButton("COMPRAR");
		btnComprar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnComprar.setBackground(UIManager.getColor("Button.background"));
		panel_1.add(btnComprar);
		btnComprar.addActionListener(this);

		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		panel_1.add(btnVolver);
		btnVolver.addActionListener(this);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		c = VentanaPrincipal.bd.obtenerVehiculo(ruta);
		ImageIcon im = new ImageIcon(c.getRutaFoto());
		panel_2.setLayout(null);
		lblFoto = new JLabel(im);
		lblFoto.setForeground(Color.BLACK);
		lblFoto.setBackground(Color.WHITE);
		lblFoto.setBounds(54, 176, 468, 401);
		panel_2.add(lblFoto);

		// Asignamos los datos desde la base de datos para cada vehiculo
		// seleccionado
		JLabel lblMatricula = new JLabel("Marca :");
		lblMatricula.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblMatricula.setBounds(561, 194, 122, 24);
		panel_2.add(lblMatricula);

		JLabel lblModelo = new JLabel("Modelo :");
		lblModelo.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblModelo.setBounds(561, 275, 143, 36);
		panel_2.add(lblModelo);

		JLabel lblColor = new JLabel("Color :");
		lblColor.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblColor.setBounds(561, 367, 130, 29);
		panel_2.add(lblColor);

		JLabel lblPrecio = new JLabel("Precio :");
		lblPrecio.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblPrecio.setBounds(561, 457, 133, 26);
		panel_2.add(lblPrecio);

		lblMarca = new JLabel();
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarca.setBounds(718, 191, 128, 30);
		lblMarca.setText(c.getMarca());
		panel_2.add(lblMarca);

		lblModelo_1 = new JLabel();
		lblModelo_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModelo_1.setBounds(716, 280, 131, 31);
		lblModelo_1.setText(c.getModelo());
		panel_2.add(lblModelo_1);

		lblColor_1 = new JLabel();
		lblColor_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblColor_1.setBounds(715, 370, 115, 28);
		lblColor_1.setText(c.getColor());
		panel_2.add(lblColor_1);

		lblPrecio_1 = new JLabel();
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio_1.setText("");
		lblPrecio_1.setBounds(720, 463, 53, 20);
		lblPrecio_1.setText(String.valueOf(c.getPrecio()));
		panel_2.add(lblPrecio_1);
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);
	}

	/**
	 * Método que dependiendo del boton seleccionado hará una acción u otra. SI:
	 * seleccionamos volver volverá a la ventana anterior seleccionamos comprar
	 * iremos a la ventana de compra del coche
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnVolver) {
			this.dispose();
			ventanaAnterior.setVisible(true);

		} else if (botonPulsado == btnComprar) {
			Vehiculo v = VentanaPrincipal.bd.obtenerVehiculo(ruta);
			VentanaInicioSesion.carrito.add(v);
			JOptionPane.showMessageDialog(null,
					"Se ha añadido el coche al carrito",
					"COMPRA REALIZADA CON ÉXITO",
					JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
			new VentanaCliente(ventanaAnterior);
		}
	}

}