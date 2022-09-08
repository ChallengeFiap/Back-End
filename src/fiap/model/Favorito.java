package fiap.model;
/**Classe para objetos do tipo Favorito
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

public class Favorito {

	private int idFavorito;
	private int idSelecao;
	private int idRegistroGeral;

	public int getIdFavorito() {
		return idFavorito;
	}

	public void setIdFavorito(int idFavorito) {
		this.idFavorito = idFavorito;
	}

	public int getIdSelecao() {
		return idSelecao;
	}

	public void setIdSelecao(int idSelecao) {
		this.idSelecao = idSelecao;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

}
