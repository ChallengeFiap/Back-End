package fiap.model;

/**Classe para objetos do tipo Experiencia
 * @author Luis Felipe
 * @version 1.1
 * @since 07/09/2022
 */
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Experiencia {

	private int idExperiencia;
	private int idRegistroGeral;
	private String experiencia;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String statusExperiencia;
	private String senioridade;

	public int getIdExperiencia() {
		return idExperiencia;
	}

	public void setIdExperiencia(int idExperiencia) {
		this.idExperiencia = idExperiencia;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
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

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		LocalDate inicio = LocalDate.parse("1899-12-31");
		try {
			if (dataInicio.isAfter(inicio)) {
				this.dataFim = dataFim;
			} else {
				throw new Exception("Data fora do periodo permitido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public String getStatusExperiencia() {
		return statusExperiencia;
	}

	public void setStatusExperiencia(String statusExperiencia) {
		this.statusExperiencia = statusExperiencia;
	}

	public String getSenioridade() {
		return senioridade;
	}

	public void setSenioridade(String senioridade) {
		this.senioridade = senioridade;
	}
	
	

	

}
