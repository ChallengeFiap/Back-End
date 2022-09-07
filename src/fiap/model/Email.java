package fiap.model;
/**Classe para objetos do tipo Email
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Email {

	private int idEmail;
	private int idRegistroGeral;
	private String email;
	private String tipoEmail;
	private String statusEmail;

	public int getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(int idEmail) {
		this.idEmail = idEmail;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		try {
			if (email != null && email.length() > 0) {
				String validacao = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	            Pattern pattern = Pattern.compile(validacao, Pattern.CASE_INSENSITIVE);
	            Matcher matcher = pattern.matcher(email);
	            if (matcher.matches()) {
	            	this.email = email;
	            }else {
	            	throw new Exception ("E-mail Invalido, coloque um E-mail valido para continuar o cadastro");
	            }
			}else {
				throw new Exception ("E-mail Nulo, coloque um E-mail para continuar o cadastro");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

	public String getTipoEmail() {
		return tipoEmail;
	}

	public void setTipoEmail(String tipoEmail) {
		this.tipoEmail = tipoEmail;
	}

	public String getStatusEmail() {
		return statusEmail;
	}

	public void setStatusEmail(String statusEmail) {
		try {
			if (statusEmail.length() == 1) {
				this.statusEmail = statusEmail;
			} else {
				throw new Exception ("Status Email deve ter apenas 1 caracter sendo, (A)tivo e (I)nativo");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

}
