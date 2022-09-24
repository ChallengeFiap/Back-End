package fiap.model;
/**Classe para objetos do tipo Usuario Registro Geral (Classe Pai do Registro Candidato e Registro Recrutador) *Herança*
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

public class UsuarioRegistroGeral {

	private int idRegistroGeral;
	private String nomeCompleto;
	private String email;
	private String senha;
	private String tipoUsuario;
	private int numeroCPF;

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getNumeroCPF() {
		return numeroCPF;
	}

	public void setNumeroCPF(int numeroCPF) {
		this.numeroCPF = numeroCPF;
	}
	
	
	
	

}
