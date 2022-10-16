package fiap.model;

/**Classe para objetos do tipo LinguagemCandidato
 * @author Luis Felipe
 * @version 1.0
 * @since 19/09/2022
 */

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class LinguagemCandidato {

	private int idLinguagemCandidato;
	private int idLinguagem;
	private int idRegistroGeral;
	private LocalDate dataInicio;
	private String proficiencia;

	public int getIdLinguagemCandidato() {
		return idLinguagemCandidato;
	}

	public void setIdLinguagemCandidato(int idLinguagemCandidato) {
		this.idLinguagemCandidato = idLinguagemCandidato;
	}

	public int getIdLinguagem() {
		return idLinguagem;
	}

	public void setIdLinguagem(int idLinguagem) {
		this.idLinguagem = idLinguagem;
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
		LocalDate fim = LocalDate.now();
		try {
			if (dataInicio.isAfter(inicio) && dataInicio.isBefore(fim)) {
				this.dataInicio = dataInicio;
			} else {
				throw new Exception("Data fora do periodo permitido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}

	}

	public String getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(String proficiencia) {
		this.proficiencia = proficiencia;
	}

}
