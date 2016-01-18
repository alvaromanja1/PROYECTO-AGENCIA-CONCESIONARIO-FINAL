package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import TipoDeDatos.*;

/**
 * @author USUARIO
 *Clase que crea la base de datos y sus respectivos métodos para las requeridas acciones en el proyecto
 */
/**
 * @author USUARIO
 *
 */
public class BD {
	private Connection connection;
	private Statement stmt;

	/**
	 * Conecta a la base de datos mediante método creado abajo
	 */
	public BD() {
		conectar();
	}

	/**
	 * Conectarse a la base de datos, si el método salta al catch se mostrará
	 * "No se ha podido conectar a la base de datos"
	 */
	public void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:Agencia.db");
			crearSentencia();
		} catch (Exception e) {
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}

	/**
	 * Método que desconecta de la base de datos o cierra la conexión
	 */
	public void desconectar() {
		try {
			cerrarSentencia();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que crea una sentencia
	 */
	public void crearSentencia() {
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Método que cierra la sentencia
	 */
	public void cerrarSentencia() {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que verifica en la base de datos si un cliente con un dni
	 * específico existe
	 * 
	 * @param d
	 * @return existe (true o false)
	 */
	public boolean existeCliente(String d) {

		boolean existe = false;

		String s = "SELECT * FROM cliente WHERE dni='" + d + "'";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(s);

			if (rs.next())
				existe = true;
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return existe;
	}

	/**
	 * Mñetodo que inserta en la base de datos un cliente con d(dni) y n(nombre)
	 * 
	 * @param d
	 * @param n
	 */
	public void insertarCliente(String d, String n) {
		String s = "INSERT INTO cliente(dni,nom,contrasenia) VALUES ('" + d
				+ "','" + n + "')";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Método que verifica si un viaje específico existe
	 * 
	 * @param cod
	 * @param origen
	 * @param destino
	 * @param precio
	 * @param numplazas
	 * @param foto
	 * @return resul
	 */
	public boolean existeViaje(int cod, String origen, String destino,
			float precio, int numplazas, String foto) {
		String s = "SELECT * FROM viaje WHERE cod=" + cod + " AND origen='"
				+ origen + "' AND destino='" + destino + "' AND precio="
				+ precio + " AND numplazas=" + numplazas + " AND foto='" + foto
				+ "'";
		ResultSet rs;
		boolean resul = false;
		try {
			rs = stmt.executeQuery(s);
			if (rs.next())
				resul = true;
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resul;
	}

	/**
	 * Método que verifica si existe un vehículo dependiendo de su color marca
	 * modelo precio matricula y foto
	 * 
	 * @param color
	 * @param marca
	 * @param modelo
	 * @param precio
	 * @param matricula
	 * @param foto
	 * @return resul true si en el resul set hay algo después
	 */
	public boolean existeVehiculos(String color, String marca, String modelo,
			float precio, String matricula, String foto) {
		String s = "SELECT * FROM vehiculo WHERE color='" + color
				+ "' AND marca='" + marca + "' AND modelo='" + modelo
				+ "' AND precio=" + precio + " AND matricula='" + matricula
				+ "' AND foto='" + foto + "'";
		ResultSet rs;
		boolean resul = false;
		try {
			rs = stmt.executeQuery(s);
			if (rs.next())
				resul = true;
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resul;
	}

	/**
	 * Método que por su dni obtiene un cliente de la base de datos
	 * 
	 * @param liente
	 *            c con los datos insertados
	 * @return c
	 */
	public Cliente obtenerCliente(String d) {
		Cliente c = null;

		String s = "SELECT * FROM Cliente WHERE dni='" + d + "'";

		try {
			ResultSet rs = stmt.executeQuery(s);
			if (rs.next()) {
				c = new Cliente(rs.getString("dni"), rs.getString("nom"),
						rs.getString("contrasenia"),/* rs.getInt("edad") */0,
						rs.getString("foto"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * Método que obtiene las rutas de los viajes y los guarda en una LinkedList
	 * llamada lFotos
	 * @return lFotos
	 */
	public LinkedList<String> obtenerRutasFotos() {
		String s = "SELECT DISTINCT(foto) FROM viaje";
		LinkedList<String> lFotos = new LinkedList<String>();
		try {
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				lFotos.add(rs.getString("foto"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lFotos;
	}

	/**
	 * Método que obtiene las rutas de las fotos de los vehículos cuya marca sea
	 * marca y modelo sea modelo. Las guarda en una linkedList llamada lFotos
	 * 
	 * @param marca
	 * @param modelo
	 * @return lFotos
	 */
	public LinkedList<String> obtenerRutasFotosVehiculo(String marca,
			String modelo) {
		String s = "SELECT foto FROM vehiculo WHERE marca='" + marca
				+ "' AND modelo='" + modelo + "'";
		LinkedList<String> lFotos = new LinkedList<String>();
		try {
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				lFotos.add(rs.getString("foto"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lFotos;
	}

	/**
	 * Método que obtiene los clientes cuyo dni sea *** (Administrador) y lo
	 * guarda en una LinkedList llamada lClientes
	 * 
	 * @return lClientes con esos datos insertados
	 */
	public LinkedList<Cliente> obtenerClientes() {
		String s = "SELECT * FROM cliente WHERE dni <> '***'";
		LinkedList<Cliente> lClientes = new LinkedList<Cliente>();

		try {
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				Cliente a = new Cliente(rs.getString("dni"),
						rs.getString("nom"), rs.getString("contrasenia"),
						rs.getInt("edad"), rs.getString("foto"));
				lClientes.add(a);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lClientes;
	}

	/**
	 * Método que obtiene clientes cuya ruta de foto sea foto y lo guarda en el
	 * cliente c
	 * 
	 * @param foto
	 * @return cliente c
	 */
	public Cliente obtenerClientes(String foto) {
		String s = "SELECT * FROM cliente WHERE foto='" + foto + "'";
		ResultSet rs;
		Cliente c = null;
		try {
			rs = stmt.executeQuery(s);
			c = new Cliente(rs.getString("dni"), rs.getString("nom"),
					rs.getString("contrasenia"), rs.getInt("edad"),
					rs.getString("foto"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	/**
	 * Método que verifica dado una matricula si un vehículo ya existe en la
	 * base de datos
	 * 
	 * @param matricula
	 * @return existe si en el resul set hay algo despúes.
	 */
	public boolean existeVehiculo(String matricula) {
		boolean existe = false;
		String s = "SELECT * FROM vehiculo WHERE matricula='" + matricula + "'";
		try {
			ResultSet rs = stmt.executeQuery(s);
			if (rs.next())
				existe = true;
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return existe;
	}

	/**
	 * Método que inserta en la base de datos un vehículo con todos sus
	 * atributos
	 * 
	 * @param color
	 * @param marca
	 * @param modelo
	 * @param precio
	 * @param matricula
	 * @param foto
	 */
	public void insertarVehiculo(String color, String marca, String modelo,
			float precio, String matricula, String foto) {

		String s = "INSERT INTO vehiculo(matricula,modelo,marca,color,precio,foto) VALUES('"
				+ matricula
				+ "','"
				+ modelo
				+ "','"
				+ marca
				+ "','"
				+ color
				+ "'," + precio + ",'" + foto + "')";

		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que inserta un viaje en la base de datos con todos sus atributos
	 * 
	 * @param cod
	 * @param origen
	 * @param destino
	 * @param precio
	 * @param numplazas
	 * @param foto
	 * @param fSalida
	 * @param fRegreso
	 */
	public void insertarViaje(int cod, String origen, String destino,
			double precio, int numplazas, String foto, String fSalida,
			String fRegreso) {

		String s = "INSERT INTO viaje (cod,origen,destino,precio,numplazas,foto,fechaSalida,fechaRegreso) VALUES ("
				+ cod
				+ ",'"
				+ origen
				+ "','"
				+ destino
				+ "',"
				+ precio
				+ ","
				+ numplazas
				+ ",'"
				+ foto
				+ "','"
				+ fSalida
				+ "','"
				+ fRegreso
				+ "')";

		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que a partir de una ruta obtiene su vehículo
	 * 
	 * @param foto
	 * @return vehiculo cuya ruta de foto sea foto
	 */
	public Vehiculo obtenerVehiculo(String foto) {
		String s = "SELECT * FROM vehiculo WHERE foto='" + foto + "'";
		ResultSet rs;
		Vehiculo l = null;
		try {
			rs = stmt.executeQuery(s);
			l = new Vehiculo(rs.getString("marca"), rs.getString("modelo"),
					rs.getString("color"), rs.getFloat("precio"),
					rs.getString("matricula"), rs.getString("foto"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	/**
	 * Método que obtiene todos los viajes y los guarda en una LinkedList
	 * llamada lViajes
	 * 
	 * @return lViajes linked list de viajes
	 */
	public LinkedList<Viajes> obtenerViajes() {
		LinkedList<Viajes> lViajes = new LinkedList<Viajes>();

		String s = "SELECT * FROM viaje";
		try {
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				int cod = rs.getInt("cod");
				String origen = rs.getString("origen");
				String destino = rs.getString("destino");
				double precio = rs.getDouble("precio");
				int numplazas = rs.getInt("numplazas");
				String foto = rs.getString("foto");
				String fechaIda = rs.getString("fechaSalida");
				String fechaVuelta = rs.getString("fechaRegreso");
				lViajes.add(new Viajes(cod, foto, precio, origen, destino,
						numplazas, fechaIda, fechaVuelta));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lViajes;
	}

	/**
	 * Método que obtiene las fehas de salida y regreso del código "cod"
	 * 
	 * @param cod
	 * @return fecha de salida y regreso de un viaje
	 */
	public LinkedList<String> obtenerFechas(int cod) {
		LinkedList<String> fechas = new LinkedList<String>();
		String s = "SELECT fechaSalida, fechaRegreso FROM viaje WHERE cod="
				+ cod;
		ResultSet rs;
		try {
			rs = stmt.executeQuery(s);
			while (rs.next()) {
				String fechaS = rs.getString("fechaSalida");
				String fechaR = rs.getString("fechaRegreso");
				fechas.add(fechaS);
				fechas.add(fechaR);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fechas;
	}

	/**
	 * Método que obtiene los viajes de la base de datos cuyo código es cod
	 * 
	 * @param cod
	 * @return viaje v cuyo código sea cod
	 */
	public Viajes obtenerViaje(int cod) {
		String s = "SELECT * FROM viaje WHERE cod=" + cod;
		ResultSet rs;
		Viajes v = null;
		try {
			rs = stmt.executeQuery(s);
			v = new Viajes(rs.getInt("cod"), rs.getString("foto"),
					rs.getFloat("precio"), rs.getString("origen"),
					rs.getString("destino"), rs.getInt("numplazas"),
					rs.getString("fechaSalida"), rs.getString("fechaRegreso"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return v;
	}

	/**
	 * Método que obtiene los viajes de lña base de datos cuya ruta de la foto
	 * sea "foto"
	 * 
	 * @param foto
	 * @return viaje que satisfaga todas las condiciones
	 */
	public Viajes obtenerViaje(String foto) {
		String s = "SELECT * FROM viaje WHERE foto='" + foto + "'";
		ResultSet rs;
		Viajes v = null;
		try {
			rs = stmt.executeQuery(s);
			v = new Viajes(rs.getInt("cod"), rs.getString("foto"),
					rs.getFloat("precio"), rs.getString("origen"),
					rs.getString("destino"), rs.getInt("numplazas"),
					rs.getString("fechaSalida"), rs.getString("fechaRegreso"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return v;
	}

	/**
	 * Método que elimina un determinado viaje de la base de datos
	 * 
	 * @param cod
	 */
	public void eliminarViaje(int cod) {
		String s = "DELETE FROM viaje WHERE cod=" + cod;
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que recorre el carrito y inserta en él los valores del dni,
	 * codigo, unidades y precio total
	 * 
	 * @param carrito
	 */
	public void insertarCompra(LinkedList<Compra> carrito) {

		for (int i = 0; i < carrito.size(); i++) {
			Compra c = carrito.get(i);
			String s = "INSERT INTO compra(dni,codigo,unidades,precioTotal) VALUES('"
					+ c.getDni()
					+ "','"
					+ c.getCodigo()
					+ "',"
					+ c.getUnidades() + "," + c.getPrecioTotal() + ")";
			try {
				stmt.executeUpdate(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método que obtiene todas las marcas (sin repetirse) de la tabla vehiculo
	 * de la base de datos
	 * 
	 * @return marcas de los vehiculos
	 */
	public LinkedList<String> obtenerMarcas() {
		String s = "SELECT DISTINCT(marca) FROM vehiculo";
		LinkedList<String> marcas = new LinkedList<String>();
		try {
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				String m = rs.getString("marca");
				marcas.add(m);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marcas;
	}

	/**
	 * Método que obtiene los modelos (sin repetirse) de los vehículos cuya
	 * marca es "marca"
	 * 
	 * @param marca
	 * @return modelos de los vehiculos
	 */
	public LinkedList<String> obtenerModelos(String marca) {
		String s = "SELECT DISTINCT(modelo) FROM vehiculo WHERE marca='"
				+ marca + "'";
		LinkedList<String> modelos = new LinkedList<String>();
		try {
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				String m = rs.getString("modelo");
				modelos.add(m);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelos;
	}

	/**
	 * Método que obtiene diferentes viajes de una determinada ruta y los guarda
	 * en la LinkedList llamada lViajes
	 * 
	 * @param ruta
	 * @return lViajes (linked List de viajes)
	 */
	public LinkedList<Viajes> obtenerViajesRuta(String ruta) {
		LinkedList<Viajes> lViajes = new LinkedList<Viajes>();
		String s = "SELECT * FROM viaje WHERE foto='" + ruta + "'";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(s);
			while (rs.next()) {
				Viajes v = new Viajes(rs.getInt("cod"), rs.getString("foto"),
						rs.getFloat("precio"), rs.getString("origen"),
						rs.getString("destino"), rs.getInt("numplazas"),
						rs.getString("fechaSalida"),
						rs.getString("fechaRegreso"));
				lViajes.add(v);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lViajes;
	}

	/**
	 * Método que modifica las plazas libres de un viaje, restándole a las
	 * plazas totales el número entero np
	 * 
	 * @param codigo
	 * @param np
	 */
	public void modificarPlazasLibresViaje(int codigo, int np) {
		String s = "UPDATE viaje SET numPlazas=numPlazas-" + np + " WHERE cod="
				+ codigo;
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	