package Ventanas;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import TipoDeDatos.Viajes;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import java.awt.Font;

import javax.swing.UIManager;

import java.awt.GridLayout;
import javax.swing.border.BevelBorder;

/**
 * @author USUARIO Ventana en la cual se visualizará un calendario y una Jtable
 *         para que el cliente elija las fechas que desee el cliente
 */
public class VentanaCalendario extends JFrame implements ActionListener {

	private JPanel contentPane, PanelCentro;
	private JCalendar calendario;
	private JButton btnIda, btnVolver, btnRegreso;
	private JFrame ventanaAnterior;
	private int dia, dia1, mes, mes1, anio, anio1;
	private JPanel panelArriba, panelAbajo;
	private JTable tabla;
	private DefaultTableModel dtm;
	private LinkedList<Viajes> lViajes;
	private String foto;
	private JScrollPane scrolltabla;

	/**
	 * Crea un renderer para la JTbable el cual le cambiará el color del texto
	 * fechaSalida a azul
	 */
	private static DefaultTableCellRenderer rendererFechaSalida = new DefaultTableCellRenderer();
	static {
		rendererFechaSalida.setHorizontalAlignment(JLabel.CENTER);
		rendererFechaSalida.setForeground(Color.blue);
	}
	/**
	 * Crea un renderer para la JTbable el cual le cambiará el color del texto
	 * fechaRegreso a verde
	 */
	private static DefaultTableCellRenderer rendererFechaRegreso = new DefaultTableCellRenderer();
	static {
		rendererFechaRegreso.setHorizontalAlignment(JLabel.CENTER);
		rendererFechaRegreso.setForeground(Color.green);
	}

	/**
	 * Crea la ventana calendario aniadiendo botones...
	 * 
	 * @param va
	 * @param foto
	 */
	public VentanaCalendario(JFrame va, String foto) {
		this.foto = foto;
		ventanaAnterior = va;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblCalendario = new JLabel("CALENDARIO");
		lblCalendario.setFont(new Font("Dialog", Font.BOLD, 45));
		panel.add(lblCalendario);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(UIManager.getColor("Button.background"));
		btnVolver.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		panel_1.add(btnVolver);
		btnVolver.addActionListener(this);

		PanelCentro = new JPanel();
		contentPane.add(PanelCentro, BorderLayout.CENTER);
		PanelCentro.setLayout(new GridLayout(0, 1, 0, 0));
		panelArriba = new JPanel();

		// Creamos la Jtable creando un string de titulos y lo recorremos
		// aniadiendolo a un default table model
		tabla = new JTable(new DefaultTableModel());
		dtm = (DefaultTableModel) tabla.getModel();
		String titulos[] = { "CODIGO", "ORIGEN", "DESTINO", "PLAZAS LIBRES",
				"FECHA DE SALIDA", "FECHA DE REGRESO" };
		for (int i = 0; i < titulos.length; i++)
			dtm.addColumn(titulos[i]);
		lViajes = VentanaPrincipal.bd.obtenerViajesRuta(foto);
		for (int i = 0; i < lViajes.size(); i++) {
			Viajes v = lViajes.get(i);
			String fila[] = { String.valueOf(v.getCod()), v.getOrigen(),
					v.getDestino(), String.valueOf(v.getNumPlazas()),
					v.getFechaSalida(), v.getFechaRegreso() };
			dtm.addRow(fila);
		}
		// Aplica el renderer a la fechaSlida y fechaRegreso
		tabla.setModel(dtm);
		tabla.setEnabled(false);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla.getColumn("FECHA DE SALIDA").setCellRenderer(rendererFechaSalida);
		tabla.getColumn("FECHA DE REGRESO").setCellRenderer(
				rendererFechaRegreso);
		TableColumnModel columnModel = tabla.getColumnModel();
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setPreferredWidth(138);
		}
		panelArriba.setLayout(null);
		scrolltabla = new JScrollPane(tabla);
		scrolltabla.setBounds(61, 44, 832, 215);
		panelArriba.add(scrolltabla);
		PanelCentro.add(panelArriba);
		panelAbajo = new JPanel();
		PanelCentro.add(panelAbajo);
		panelAbajo.setLayout(null);

		// Aniadir el JCalendar al panel inferior
		calendario = new JCalendar();
		calendario.setBounds(66, 25, 602, 265);
		panelAbajo.add(calendario);

		btnIda = new JButton("SALIDA");
		btnIda.setBounds(776, 58, 131, 35);
		btnIda.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		btnIda.setBackground(UIManager.getColor("Button.background"));
		panelAbajo.add(btnIda);
		btnIda.addActionListener(new ActionListener() {
			// Asigna la fecha de salida seleccionadas en el calendario
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dia = calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
				mes = calendario.getCalendar().get(Calendar.MONTH) + 1;
				anio = calendario.getCalendar().get(Calendar.YEAR);
				VentanaDatosViajes.fechaIda = String.valueOf(anio);
				if (mes < 10)
					VentanaDatosViajes.fechaIda = VentanaDatosViajes.fechaIda
							+ "0";
				VentanaDatosViajes.fechaIda = VentanaDatosViajes.fechaIda
						+ String.valueOf(mes);
				if (dia < 10)
					VentanaDatosViajes.fechaIda = VentanaDatosViajes.fechaIda
							+ "0";
				VentanaDatosViajes.fechaIda = VentanaDatosViajes.fechaIda
						+ String.valueOf(dia);
				System.out.println("Fecha de ida: " + dia + "/" + mes + "/"
						+ anio);
				VentanaDatosViajes.fechaIdaSeleccionada = true;

			}

		});

		btnRegreso = new JButton("REGRESO");
		btnRegreso.setBounds(773, 185, 134, 35);
		btnRegreso.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		btnRegreso.setBackground(UIManager.getColor("Button.background"));
		panelAbajo.add(btnRegreso);
		btnRegreso.addActionListener(new ActionListener() {
			// Asigna la fecha de regreso seleccionadas en el calendario
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				dia1 = calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
				mes1 = calendario.getCalendar().get(Calendar.MONTH);
				anio1 = calendario.getCalendar().get(Calendar.YEAR);
				VentanaDatosViajes.fechaVuelta = String.valueOf(anio);
				if (mes < 10)
					VentanaDatosViajes.fechaVuelta = VentanaDatosViajes.fechaVuelta
							+ "0";
				VentanaDatosViajes.fechaVuelta = VentanaDatosViajes.fechaVuelta
						+ String.valueOf(mes);
				if (dia < 10)
					VentanaDatosViajes.fechaVuelta = VentanaDatosViajes.fechaVuelta
							+ "0";
				VentanaDatosViajes.fechaVuelta = VentanaDatosViajes.fechaVuelta
						+ String.valueOf(dia);

				System.out.println("Fecha de vuelta: " + dia1 + "/" + mes1
						+ "/" + anio1);
				VentanaDatosViajes.fechaVueltaSeleccionada = true;

				panelAbajo = calendario.getDayChooser().getDayPanel();
				Component component[] = panelAbajo.getComponents();

				// Sumamos mas 7 porque empiea a contar desde el elemento lunes
				// for (int i = dia+7; i <dia1+8; i++) {
				// System.out.println(component[i].getClass().getSuperclass());
				// System.out.println(((JButton)component[i]).getText());
				// component[i].setBackground(Color.red);
				// }
				for (Component c : component) {
					try {
						int diaDePanel = Integer.parseInt(((JButton) c)
								.getText());
						if (diaDePanel >= dia && diaDePanel <= dia1) {
							c.setBackground(Color.red);
						}
					} catch (Exception e2) {
					}
				}
			}

		});
		this.setVisible(true);
		this.setBounds(160, 100, 1000, 800);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnVolver) {
			VentanaDatosViajes.numPlazas = Integer
					.parseInt(JOptionPane
							.showInputDialog("Introducce el número de plazas que deseas: "));
			System.out.println("PLAZAS COMPRADAS: "
					+ VentanaDatosViajes.numPlazas);
			this.dispose();
			ventanaAnterior.setVisible(true);
		}
	}
}
