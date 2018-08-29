
package Datos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
	
	public static Connection conn = null;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USUARIO = "root";
	private static final String PASS = "";
	private static final String URL = "jdbc:mysql://localhost/cancionero";

	public Conexion() {
		try {
			Class.forName(DRIVER);
			conn = (Connection) DriverManager.getConnection(URL, USUARIO, PASS);
			if(conn != null){
				System.out.println("Conexión a la base de datos establecida");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error al conectar a la base de datos" + e);
		}
	}
	
	public Connection getConnection(){
		return conn;
	}
	
	public void desconectar(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al tratar de desconectar " + e);
			}
		}
	}
}
