package fiap.model;
/**Classe para objetos do tipo Estado
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import javax.swing.JOptionPane;

public class Estado {

	private int idEstado;
	private String siglaEstado;
	private String nomeEstado;

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		try {
			if (siglaEstado.length() == 2) {
				this.siglaEstado = siglaEstado;
			} else {
				throw new Exception ("Sigla do Estado deve ter 2 caracteres");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

}
