package fiap.model;

/**
 * Classe para objetos do tipo Cidade
 * 
 * @author Luis Felipe
 * @version 1.0
 * @since 07/09/2022
 */

public class Cidade {

	private int idCidade;
	private int idRegistroGeral;
	private int idEstado;
	private String nomeCidade;

	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

}
