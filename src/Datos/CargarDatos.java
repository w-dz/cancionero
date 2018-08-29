
package Datos;



import Presentación.Interfaz;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


/**
 *
 * @author Wilson
 */
public class CargarDatos {	
	Interfaz in;
	
	private final String SQL_INSERT1 = "INSERT INTO `cancionero`.`artistas` (`cod_artista`,`nom_artista`, `gen_artista`) VALUES (?, ?, ?);";
	private final String SQL_INSERT2 = "INSERT INTO `cancionero`.`album` (`cod_album`, `nom_album`, `img_album`) VALUES (?, ?, ?);";
	private final String SQL_INSERT3 = "INSERT INTO `cancionero`.`canciones` (`nom_canciones`, `letra_canciones`, `cod_album`, `cod_artista`) VALUES (?, ?, ?, ?);";
	
	private PreparedStatement PS, PS2, PS3;
	private Conexion CN;			

	public CargarDatos() {
		PS = null;
		PS2 = null;
		PS3 = null;		
	}
		
	public int insertarDatos(Album al, Artista a, Cancion c){	
		CN = new Conexion();
		System.out.println("Conectado a la base de datos");
		try {
			//---1---
			PS = CN.getConnection().prepareStatement(SQL_INSERT1);
			PS.setString(1, a.cod_artista);
			PS.setString(2, a.nom_artista);
			PS.setString(3, a.gen_artista);
			int res = PS.executeUpdate();
			//---2---
			PS2 = CN.getConnection().prepareStatement(SQL_INSERT2);
			PS2.setString(1, al.cod_album);
			PS2.setString(2, al.nom_album);
			PS2.setBinaryStream(3, al.fis, al.longitudBytes);
			int res2 = PS2.executeUpdate();				
			//---3---
			PS3 = CN.getConnection().prepareStatement(SQL_INSERT3);
			PS3.setString(1, c.nom_canciones);
			PS3.setString(2, c.letra_canciones);
			PS3.setString(3, al.cod_album);
			PS3.setString(4, a.cod_artista);
			int res3 = PS3.executeUpdate();			
			if(res > 0 && res2 > 0 && res3 > 0){
				JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al guardar los datos " + e);
		}finally{
			CN.desconectar();
			System.out.println("Desconectado de la base de datos");
		}		
		return 0;
	}		
	
		
}
