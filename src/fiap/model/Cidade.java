package fiap.model;
/**Classe para objetos do tipo Cidade
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

public class Cidade {

	private int idCidade;
	private int idEstado;
	private int codigoIBGE;
	private String nomeCidade;
	private int numeroDDD;

	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public int getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(int codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public int getNumeroDDD() {
		return numeroDDD;
	}

	public void setNumeroDDD(int numeroDDD) {
		this.numeroDDD = numeroDDD;
	}

}
