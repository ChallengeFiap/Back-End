package fiap.model;
/**Classe para objetos do tipo Telefone
 * @author Luis Felipe
 * @version 1.0
 * @since 07/09/2022
 */


public class Telefone {

	private int idTelefone;
	private int idRegistroGeral;
	private int numeroDDD;
	private int telefone;
	private String statusTelefone;

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}


	public int getNumeroDDD() {
		return numeroDDD;
	}

	public void setNumeroDDD(int numeroDDD) {
		this.numeroDDD = numeroDDD;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}


	public String getStatusTelefone() {
		return statusTelefone;
	}

	public void setStatusTelefone(String statusTelefone) {
		this.statusTelefone = statusTelefone;
	}

}
