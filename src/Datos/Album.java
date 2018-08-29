
package Datos;

import java.io.FileInputStream;

/**
 *
 * @author Wilson
 */
public class Album {
	String cod_album;
	String nom_album;
	String foto_album;	
	int longitudBytes;
	FileInputStream fis;

	public Album() {		
		
	}

	public String getCod_album() {
		return cod_album;
	}

	public void setCod_album(String cod_album) {
		this.cod_album = cod_album;
	}

	public String getNom_album() {
		return nom_album;
	}

	public void setNom_album(String nom_album) {
		this.nom_album = nom_album;
	}

	public String getFoto_album() {
		return foto_album;
	}

	public void setFoto_album(String foto_album) {
		this.foto_album = foto_album;
	}	

	public int getLongitudBytes() {
		return longitudBytes;
	}

	public void setLongitudBytes(int longitudBytes) {
		this.longitudBytes = longitudBytes;
	}

	public FileInputStream getFis() {
		return fis;
	}

	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}
	
}
