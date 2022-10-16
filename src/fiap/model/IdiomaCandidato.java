package fiap.model;
/**Classe para objetos do tipo IdiomaCandidato
 * @author Luis Felipe
 * @version 1.0
 * @since 23/09/2022
 */

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class IdiomaCandidato {

	private int idIdiomaCandidato;
	private int idRegistroGeral;
	private int idIdiomas;
	private LocalDate dataInicio;
	private String proficiencia;

	public int getIdIdiomaCandidato() {
		return idIdiomaCandidato;
	}

	public void setIdIdiomaCandidato(int idIdiomaCandidato) {
		this.idIdiomaCandidato = idIdiomaCandidato;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public int getIdIdiomas() {
		return idIdiomas;
	}

	public void setIdIdiomas(int idIdiomas) {
		this.idIdiomas = idIdiomas;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		LocalDate inicio = LocalDate.parse("1899-12-31");
		LocalDate dataAtual = LocalDate.now();
		try {
			if (dataInicio.isAfter(inicio) && dataInicio.isBefore(dataAtual)) {
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
