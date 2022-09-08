package fiap.model;

/**
 * Classe para objetos do tipo Logradouro
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

public class Logradouro {

	private int idLogradouro;
	private int idBairro;
	private String nomeLogradouro;
	private int numeroCEP;

	public int getIdLogradouro() {
		return idLogradouro;
	}

	public void setIdLogradouro(int idLogradouro) {
		this.idLogradouro = idLogradouro;
	}

	public int getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(int idBairro) {
		this.idBairro = idBairro;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public int getNumeroCEP() {
		return numeroCEP;
	}

	public void setNumeroCEP(int numeroCEP) {
		this.numeroCEP = numeroCEP;
	}

}
