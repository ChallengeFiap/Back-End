package fiap.model;
/**Classe para objetos do tipo Login
 * @author Luís Felipe
 * @version 1.0
 * @since 19/09/2022
 */

public class Login extends UsuarioRegistroGeral {

	String emailLogin;
	String senhaLogin;

	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public String getSenhaLogin() {
		return senhaLogin;
	}

	public void setSenhaLogin(String senhaLogin) {
		this.senhaLogin = senhaLogin;
	}

}
