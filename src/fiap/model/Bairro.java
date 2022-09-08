package fiap.model;

/**
 * Classe para objetos do tipo Bairro
 * 
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

public class Bairro {

	private int idBairro;
	private int idCidade;
	private String nomeBairro;
	private String nomeZonaBairro;

	public int getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(int idBairro) {
		this.idBairro = idBairro;
	}

	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public String getNomeZonaBairro() {
		return nomeZonaBairro;
	}

	public void setNomeZonaBairro(String nomeZonaBairro) {
		this.nomeZonaBairro = nomeZonaBairro;
	}

}
