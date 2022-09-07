package fiap.model;

/**Classe para objetos do tipo Experiencia
 * @author Luís Felipe
 * @version 1.0
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

	public String getStatusExperiencia() {
		return statusExperiencia;
	}

	public void setStatusExperiencia(String statusExperiencia) {
		try {
			if (statusExperiencia.length() == 1) {
				this.statusExperiencia = statusExperiencia;
			} else {
				throw new Exception ("Status Experiencia deve ter apenas 1 caracter sendo, (A)tivo e (I)nativo");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

	

}
