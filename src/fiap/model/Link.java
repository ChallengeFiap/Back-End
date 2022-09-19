package fiap.model;
/**Classe para objetos do tipo Link
 * @author Luís Felipe
 * @version 1.0
 * @since 19/09/2022
 */

public class Link {

	private int idLink;
	private int idRegistroGeral;
	private String link;
	private String nomeLink;

	public int getIdLink() {
		return idLink;
	}

	public void setIdLink(int idLink) {
		this.idLink = idLink;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNomeLink() {
		return nomeLink;
	}

	public void setNomeLink(String nomeLink) {
		this.nomeLink = nomeLink;
	}

}
