package Ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;

import BD.BD;
import Threads.MiThread;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

/**
 * @author USUARIO Ventana Principal en la cual aparecen los viajes programados
 *         que están disponibles. A los lados aperecen dos threads, en la que se
 *         visualizan constantemente imagenes de esos viajes. En el medio
 *         aparecen también esos viajes. Y arriba hay un botón en la que podemos
 *         llamar o utilizar el servicio de atención al cliente.
 *
 */
public class VentanaPrincipal extends JFrame implements ActionListener,
		MouseListener {

	private JPanel contentPane, panelFotos, panelDcho;
	private JScrollPane scrollFotos;
	private String destino;
	private JButton btnSalir;
	private JButton btnIniciarSesion;
	public static BD bd;
	public static LinkedList<String> aRutasViajes;
	public JPanel panelIzdo;
	private Thread t;
	private JButton btnLLamar;
	private LinkedList<String> rutasIzda, rutasDcha;
	private JFrame ventanaAnterior;

	/**
	 * Carga las fotos que estén en la bd
	 * 
	 */
	public void cargarFotos() {

		panelFotos.removeAll();
		// Guarda en aRutasViajes las fotos que se encuentran en la bd
		aRutasViajes = bd.obtenerRutasFotos();
		// Recorre todas las que haya
		for (int j = 0; j < aRutasViajes.size(); j++) {
			// Guardamos por cada fot una ruta
			String ruta = (String) aRutasViajes.get(j);
			System.out.println(ruta);
			JLabel l = new JLabel();
			ImageIcon i = new ImageIcon(ruta);
			i.setDescription(ruta);// Metemos en el ImagenIcon una ruta.
			l.setIcon(i);
			panelFotos.add(l);
		}
		// Actualizamos el panel
		panelFotos.repaint();

	}

	/**
	 * @param rutas
	 * @param ruta
	 * @return
	 * 
	 *         Método con el que podemos ver si hay una foto repetida
	 */
	private boolean estaRepetida(LinkedList<String> rutas, String ruta) {
		boolean enc = false;
		int pos = 0;
		while (!enc && pos < rutas.size()) {
			String ru = (String) rutas.get(pos);
			if (ru.equals(ruta))
				enc = true;
			else
				pos++;
		}

		return enc;

	}

	/**
	 * @param rutas
	 * 
	 *            Método con el que eliminamos la ruta de la lista Eliminamos la
	 *            primera ruta que se encuentre en el LinkedList de rutas
	 */
	private void eliminarRutasLista(LinkedList<String> rutas) {
		while (rutas.size() > 0)
			rutas.removeFirst();
	}

	/**
	 * Método con el que cargamos fotos al panel izquierdo
	 */
	public void cargarFotosPanelIzdo() {
		panelIzdo.removeAll();
		eliminarRutasLista(rutasIzda);
		// Creamos un objeto Random
		Random r = new Random();
		// 3 porque solo pueden aparecer como máximo 3 fotos
		for (int i = 0; i < 3; i++) {
			boolean enc;
			String ruta;
			do {
				int n = r.nextInt(aRutasViajes.size());
				ruta = (String) aRutasViajes.get(n);
				System.out.println(ruta);
				enc = estaRepetida(rutasIzda, ruta);
				if (!enc)
					rutasIzda.add(ruta);
				else
					System.out.println("No se carga pq está repetida");
			} while (enc);

		}
		for (int i = 0; i < 3; i++) {
			String ruta = rutasIzda.get(i);
			JLabel l = new JLabel();
			ImageIcon im = new ImageIcon(ruta);
			im.setDescription(ruta);
			l.setIcon(im);
			panelIzdo.add(l);
		}
		panelIzdo.updateUI();
	}

	/**
	 * Método con el que cargamos fotos al panel derecho
	 */
	public void cargarFotosPanelDcho() {
		panelDcho.removeAll();
		Random r = new Random();
		eliminarRutasLista(rutasDcha);
		for (int i = 0; i < 3; i++) {
			boolean encI, encD;
			String ruta;
			do {
				int n = r.nextInt(aRutasViajes.size());
				ruta = (String) aRutasViajes.get(n);
				encD = estaRepetida(rutasDcha, ruta);
				encI = estaRepetida(rutasIzda, ruta);
				if (!encD && !encI)
					rutasDcha.add(ruta);
			} while (encD || encI);

		}

		for (int i = 0; i < 3; i++) {
			String ruta = rutasDcha.get(i);
			JLabel l = new JLabel();
			ImageIcon im = new ImageIcon(ruta);
			im.setDescription(ruta);
			l.setIcon(im);
			panelDcho.add(l);
		}

		panelDcho.updateUI();
	}

	/**
	 * @param va
	 * 
	 *            Crea la Ventana Principal añadiendole los lasbels y botones
	 *            correspondientes
	 */
	public VentanaPrincipal(JFrame va) {

		bd = new BD();

		ventanaAnterior = va;
		rutasIzda = new LinkedList<String>();
		rutasDcha = new LinkedList<String>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.setBackground(UIManager.getColor("Button.background"));
		btnIniciarSesion.setForeground(Color.BLACK);
		btnIniciarSesion.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		panel.add(btnIniciarSesion);
		btnIniciarSesion.addActionListener(this);

		JLabel lblEstosSonLos = new JLabel("902 305 452");
		lblEstosSonLos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		panel.add(lblEstosSonLos);

		btnLLamar = new JButton("");
		btnLLamar.setBackground(UIManager.getColor("Button.background"));
		ImageIcon i = new ImageIcon("FOTO/llamada-telefonica.jpg");
		btnLLamar.setIcon(i);
		panel.add(btnLLamar);
		btnLLamar.addActionListener(this);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		btnSalir = new JButton("SALIR");
		btnSalir.setBackground(UIManager.getColor("Button.background"));
		btnSalir.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		panel_1.add(btnSalir);
		btnSalir.addActionListener(this);

		panelIzdo = new JPanel();
		contentPane.add(panelIzdo, BorderLayout.WEST);
		panelIzdo.setLayout(new GridLayout(3, 1, 0, 0));
		panelDcho = new JPanel();
		contentPane.add(panelDcho, BorderLayout.EAST);
		panelDcho.setLayout(new GridLayout(3, 1, 0, 0));

		panelFotos = new JPanel();
		scrollFotos = new JScrollPane(panelFotos,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelFotos.setLayout(new GridLayout(3, 2, 0, 0));
		scrollFotos.addMouseListener(this);
		cargarFotos();
		contentPane.add(scrollFotos, BorderLayout.CENTER);
		setVisible(true);
		this.setBounds(0, 100, 1500, 800);

		Runnable r = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					cargarFotosPanelIzdo();
					cargarFotosPanelDcho();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t = new Thread(r);
		t.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();
		if (botonPulsado == btnSalir) {
			System.exit(0);
		} else if (botonPulsado == btnIniciarSesion) {
			this.dispose();
			t.stop();
			new VentanaInicioSesion(this);

		} else if (botonPulsado == btnLLamar) {

			MiThread mt = new MiThread(this);
			mt.start();
			this.dispose();

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
