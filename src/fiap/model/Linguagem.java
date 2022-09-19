package fiap.model;
/**Classe para objetos do tipo Linguagem
 * @author Luís Felipe
 * @version 1.0
 * @since 19/09/2022
 */

public class Linguagem {

	private int idLinguagem;
	private String Linguagem;
	private String nivelProficiencia;

	public int getIdLinguagem() {
		return idLinguagem;
	}

	public void setIdLinguagem(int idLinguagem) {
		this.idLinguagem = idLinguagem;
	}

	public String getLinguagem() {
		return Linguagem;
	}

	public void setLinguagem(String linguagem) {
		Linguagem = linguagem;
	}

	public String getNivelProficiencia() {
		return nivelProficiencia;
	}

	public void setNivelProficiencia(String nivelProficiencia) {
		this.nivelProficiencia = nivelProficiencia;
	}

}
