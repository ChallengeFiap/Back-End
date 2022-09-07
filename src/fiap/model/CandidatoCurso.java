package fiap.model;

/**
 * Classe para objetos do tipo CandidatoCurso
 * 
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class CandidatoCurso {

	private int idCandidatoCurso;
	private int idRegistroGeral;
	private int idCurso;
	private LocalDate dataInicio;
	private LocalDate dataFim;

	public int getIdCandidatoCurso() {
		return idCandidatoCurso;
	}

	public void setIdCandidatoCurso(int idCandidatoCurso) {
		this.idCandidatoCurso = idCandidatoCurso;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
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
			System.exit(0);
		}
	}

}
