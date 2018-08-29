package Control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Wilson
 */
public class Validaciones {
	

	public void validarSoloLetras(JTextField campo) {
		campo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				char c = e.getKeyChar();
				int k = (int)e.getKeyChar();
				if(Character.isDigit(c) || (k >= 33 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123)){
					e.consume();
				}
			}
		});
	}		
		
	//Ojo este es el del TextArea
	public void validarLetras(JTextArea campo) {
		campo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				char c = e.getKeyChar();				
				if(Character.isDigit(c)){
					e.consume();
				}
			}
		});
	}
	
	//Este es para evitar caracteres especiales en los campos CÓDIGO
	public void validarCaracteresEspeciales(JTextField campo) {
		campo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				int k = (int)e.getKeyChar();
				if((k >= 32 && k <= 47) || (k >= 58 && k <= 64) || (k >= 91 && k <= 96) || (k >= 123)){
					e.consume();
				}
			}
		});
	}
	
	//Convertir lo ingresado en mayúsculas (Funciona con el evento KeyTyped)
	public void toMayusculas(java.awt.event.KeyEvent evt){
		char c = evt.getKeyChar();
		if(Character.isLowerCase(c)){
			String cad = ("" + c).toUpperCase();
			c = cad.charAt(0);
			evt.setKeyChar(c);
		}
	}
	
}
