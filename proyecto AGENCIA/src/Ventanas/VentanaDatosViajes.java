package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Ventanas.VentanaFotosViaje;
import TipoDeDatos.Viajes;

import javax.swing.JTextField;

import Ventanas.VentanaPrincipal;

import java.awt.Font;
import java.awt.Color;

import javax.swing.UIManager;

/**
 * @author USUARIO Ventana donde aparecerán los datos del viaje seleccionado
 */
public class VentanaDatosViajes extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JFrame ventanaAnterior;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private JTextField txtPersonas;
	private JTextField txtPrecio;
	private JButton btnComprar, btnVolver;
	private String foto;
	private Viajes v;
	private JLabel lblOrigen, lblDestino, lblPrecio, lblOrigen_1, lblDestino_1,
			lblPersonas, lblPrecio_1, lblNumeroP;
	private JLabel lblFoto;
	private LinkedList<Viajes> ViajesSeleccionados;
	private JButton btnVerCalendario;
	public static String fechaIda, fechaVuelta;
	public static boolean fechaIdaSeleccionada = false,
			fechaVueltaSeleccionada = false;
	public static int numPlazas;
	private JLabel lblFehaMximaDe;
	private JLabel lblLblminimo;
	private JLabel lblLblmaximo;

	/**
	 * Create the frame. Crea la ventana
	 */
	public VentanaDatosViajes(JFrame va, String f) {
		foto = f;
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblDatosDelCoche = new JLabel("DATOS DEL VIAJE SELECCIONADO");
		lblDatosDelCoche.setFont(new Font("Dialog", Font.BOLD, 45));
		panel.add(lblDatosDelCoche);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnComprar = new JButton("COMPRAR VIAJE");
		btnComprar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnComprar.setBackground(UIManager.getColor("Button.background"));
		btnComprar.addActionListener(this);
		panel_1.add(btnComprar);

		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		btnVolver.addActionListener(this);

		btnVerCalendario = new JButton("VER CALENDARIO");
		btnVerCalendario.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnVerCalendario.setBackground(UIManager.getColor("Button.background"));
		panel_1.add(btnVerCalendario);
		panel_1.add(btnVolver);
		btnVerCalendario.addActionListener(this);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);

		v = VentanaPrincipal.bd.obtenerViaje(foto);
		ImageIcon im = new ImageIcon(v.getFoto());
		panel_2.setLayout(null);
		lblFoto = new JLabel(im);
		lblFoto.setBounds(33, 133, 352, 333);
		panel_2.add(lblFoto);

		// Asignamos a cada text field la informacion de los viajes
		// seleccionados

		lblOrigen = new JLabel(v.getOrigen());
		lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOrigen.setBounds(587, 177, 127, 27);
		panel_2.add(lblOrigen);

		lblDestino = new JLabel(v.getDestino());
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDestino.setBounds(587, 221, 119, 27);
		panel_2.add(lblDestino);

		lblPrecio = new JLabel(String.valueOf(v.getPrecio()));
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(592, 261, 56, 28);
		panel_2.add(lblPrecio);

		lblNumeroP = new JLabel(String.valueOf(v.getNumPlazas()));
		lblNumeroP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroP.setBounds(592, 302, 40, 27);
		panel_2.add(lblNumeroP);
		this.setVisible(true);

		lblOrigen_1 = new JLabel("Origen :");
		lblOrigen_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblOrigen_1.setBounds(397, 170, 129, 35);
		panel_2.add(lblOrigen_1);

		lblDestino_1 = new JLabel("Destino :");
		lblDestino_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblDestino_1.setBounds(397, 218, 144, 27);
		panel_2.add(lblDestino_1);

		lblPrecio_1 = new JLabel("Precio :");
		lblPrecio_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblPrecio_1.setBounds(397, 258, 129, 28);
		panel_2.add(lblPrecio_1);

		lblPersonas = new JLabel("Personas :");
		lblPersonas.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblPersonas.setBounds(397, 302, 157, 27);
		panel_2.add(lblPersonas);

		JLabel lblFechaMnimaDe = new JLabel("Fecha m\u00EDnima de salida :");
		lblFechaMnimaDe
				.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblFechaMnimaDe.setBounds(397, 342, 351, 35);
		panel_2.add(lblFechaMnimaDe);

		lblFehaMximaDe = new JLabel("Feha m\u00E1xima de salida :");
		lblFehaMximaDe
				.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 30));
		lblFehaMximaDe.setBounds(397, 390, 338, 27);
		panel_2.add(lblFehaMximaDe);

		lblLblminimo = new JLabel(v.getFechaSalida());
		lblLblminimo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLblminimo.setBounds(748, 342, 109, 28);
		panel_2.add(lblLblminimo);

		lblLblmaximo = new JLabel(v.getFechaRegreso());
		lblLblmaximo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLblmaximo.setBounds(747, 390, 109, 27);
		panel_2.add(lblLblmaximo);

		this.setBounds(160, 100, 1000, 800);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnVolver) {
			this.dispose();

			((VentanaFotosViaje) ventanaAnterior).cargarFotos();
			ventanaAnterior.setVisible(true);

		} else if (botonPulsado == btnComprar) {
			System.out.println("PLAZAS COMPRADAS: " + numPlazas);
			if (fechaIdaSeleccionada && fechaVueltaSeleccionada) {
				if (fechaIda.compareTo(fechaVuelta) > 0)
					JOptionPane
							.showMessageDialog(
									null,
									"La fecha de ida no puede ser mayor que la de vuelta",
									"ERROR EN LAS FECHAS",
									JOptionPane.ERROR_MESSAGE);
				else {
					// Guardamos en una LinkedList los viajes seleccionados
					LinkedList<Viajes> lViajes = VentanaPrincipal.bd
							.obtenerViajesRuta(foto);
					Viajes vi = null;
					boolean enc = false;
					int pos = 0;
					while (!enc && pos < lViajes.size()) {
						vi = lViajes.get(pos);
						if (vi.getFechaSalida().compareTo(fechaIda) <= 0
								&& vi.getFechaRegreso().compareTo(fechaVuelta) >= 0
								&& vi.getNumPlazas() >= numPlazas
								&& vi.getFoto().equals(foto))
							enc = true;
						else
							pos++;
					}
					if (!enc) // Si la fecha insertada no es la adecuada para
								// ese viaje
						JOptionPane
								.showMessageDialog(
										null,
										"Lo sentimos, no hay ningún viaje que se adapte a tus necesidades",
										"ERROR", JOptionPane.ERROR_MESSAGE);
					else { // Todo correcto se aniade al carrito
						v.setCod(vi.getCod());
						VentanaInicioSesion.carrito.add(v);
						System.out.println("Se ha añadido al carrito el viaje"
								+ v);
						JOptionPane.showMessageDialog(null,
								"Se ha añadido el viaje al carrito",
								"VIAJE AÑADIDO",
								JOptionPane.INFORMATION_MESSAGE);
						this.dispose();
						// new VentanaDeseaComprarCoche(this);
						if (JOptionPane.showConfirmDialog(null,
								"¿Desea alquilar un coche?") == JOptionPane.OK_OPTION) {
							LinkedList<String> marcas = VentanaPrincipal.bd
									.obtenerMarcas();
							// Si queremos alquilar un coche deberemos insertar
							// la marca y el modelo del coche
							String s = "Selecciona la marca: ";
							int i;
							for (i = 0; i < marcas.size() - 1; i++) {
								s = s + " " + marcas.get(i) + ",";
							}
							s = s + marcas.get(i);
							String marca = JOptionPane.showInputDialog(s);
							while (s.indexOf(marca) == -1) {
								marca = JOptionPane.showInputDialog(s);
							}
							LinkedList<String> modelos = VentanaPrincipal.bd
									.obtenerModelos(marca);
							s = "Selecciona el modelo: ";
							for (i = 0; i < modelos.size() - 1; i++) {
								s = s + " " + modelos.get(i) + ",";
							}
							s = s + modelos.get(i);
							String modelo = JOptionPane.showInputDialog(s);
							while (s.indexOf(modelo) == -1) {
								modelo = JOptionPane.showInputDialog(s);
							}

							new VentanaFotosCoches(this, marca, modelo);
						}
					}
				}
			} else
				JOptionPane
						.showMessageDialog(
								null,
								"Primero tienes que seleccionar las fechas de ida y vuelta en el calendario",
								"ERROR", JOptionPane.ERROR_MESSAGE);
		} else if (botonPulsado == btnVerCalendario) {
			this.dispose();
			new VentanaCalendario(this, foto);
		}
	}
}
