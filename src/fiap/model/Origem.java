package fiap.model;
/**Classe para objetos do tipo Origem
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

public class Origem {

	private int idOrigem;
	private int idRegistroGeral;
	private String descricaoOndeVeio;

	public int getIdOrigem() {
		return idOrigem;
	}

	public void setIdOrigem(int idOrigem) {
		this.idOrigem = idOrigem;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public String getDescricaoOndeVeio() {
		return descricaoOndeVeio;
	}

	public void setDescricaoOndeVeio(String descricaoOndeVeio) {
		this.descricaoOndeVeio = descricaoOndeVeio;
	}

}
