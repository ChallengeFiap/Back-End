package fiap.model;

/**Classe para objetos do tipo CandidatoHabilidade
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class CandidatoHabilidade {

	private int idCandidatoHabilidade;
	private int idHabilidade;
	private int idRegistroGeral;
	private LocalDate dataInicio;
	private LocalDate dataTermino;

	public int getIdCandidatoHabilidade() {
		return idCandidatoHabilidade;
	}

	public void setIdCandidatoHabilidade(int idCandidatoHabilidade) {
		this.idCandidatoHabilidade = idCandidatoHabilidade;
	}

	public int getIdHabilidade() {
		return idHabilidade;
	}

	public void setIdHabilidade(int idHabilidade) {
		this.idHabilidade = idHabilidade;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		LocalDate inicio = LocalDate.parse("1899-12-31");
		try {
			if (dataInicio.isAfter(inicio)) {
				this.dataInicio = dataInicio;
			} else {
				throw new Exception("Data fora do periodo permitido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		LocalDate inicio = LocalDate.parse("1899-12-31");
		try {
			if (dataInicio.isAfter(inicio)) {
				this.dataTermino = dataTermino;
			} else {
				throw new Exception("Data fora do periodo permitido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

}
