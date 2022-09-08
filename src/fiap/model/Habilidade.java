package fiap.model;
/**Classe para objetos do tipo Habilidade
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

public class Habilidade {

	private int idHabilidade;
	private String habilidade;
	private String descricaoHabilidade;

	public int getIdHabilidade() {
		return idHabilidade;
	}

	public void setIdHabilidade(int idHabilidade) {
		this.idHabilidade = idHabilidade;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

	public String getDescricaoHabilidade() {
		return descricaoHabilidade;
	}

	public void setDescricaoHabilidade(String descricaoHabilidade) {
		this.descricaoHabilidade = descricaoHabilidade;
	}

}
