package fiap.model;
/**Classe para objetos do tipo Selecao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Selecao {

	private int idSelecao;
	private String statusAprovacao;
	private LocalDate dataSelecao;

	public int getIdSelecao() {
		return idSelecao;
	}

	public void setIdSelecao(int idSelecao) {
		this.idSelecao = idSelecao;
	}

	public String getStatusAprovacao() {
		return statusAprovacao;
	}

	public void setStatusAprovacao(String statusAprovacao) {
		try {
			if (statusAprovacao.length() == 1) {
				this.statusAprovacao = statusAprovacao;
			} else {
				throw new Exception ("Status Aprovacao deve ter apenas 1 caracter sendo, (A)tivo e (I)nativo");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

	public LocalDate getDataSelecao() {
		return dataSelecao;
	}

	public void setDataSelecao(LocalDate dataSelecao) {
		LocalDate inicio = LocalDate.parse("1899-12-31");
		LocalDate fim = LocalDate.now();
		try {
			if (dataSelecao.isAfter(inicio) && dataSelecao.isBefore(fim)) {
				this.dataSelecao = dataSelecao;
			} else {
				throw new Exception("Data fora do periodo permitido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
			
		}
	}

}
