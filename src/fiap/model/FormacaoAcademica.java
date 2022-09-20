package fiap.model;

/**Classe para objetos do tipo Formação Academica
 * @author Luís Felipe
 * @version 1.1
 * @since 07/09/2022
 */

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class FormacaoAcademica {
	private int idFormacaoAcademica;
	private int idRegistroGeral;
	private String nomeInstituicao;
	private String atividadeExtraCurricular;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private String nomeCurso;
	private String statusCurso;
	private String escolaridade;
	private String nivelCurso;

	public int getIdFormacaoAcademica() {
		return idFormacaoAcademica;
	}

	public void setIdFormacaoAcademica(int idFormacaoAcademica) {
		this.idFormacaoAcademica = idFormacaoAcademica;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}
	

	public String getAtividadeExtraCurricular() {
		return atividadeExtraCurricular;
	}

	public void setAtividadeExtraCurricular(String atividadeExtraCurricular) {
		this.atividadeExtraCurricular = atividadeExtraCurricular;
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

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getStatusCurso() {
		return statusCurso;
	}

	public void setStatusCurso(String statusCurso) {
		try {
			if (statusCurso.length() == 1) {
				this.statusCurso = statusCurso;
			} else {
				throw new Exception ("Status Curso deve ter apenas 1 caracter sendo, (A)tivo e (I)nativo");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		try {
			if (statusCurso.length() == 1) {
				this.escolaridade = escolaridade;
			} else {
				throw new Exception ("Status Escolaridade deve ter apenas 1 caracter sendo, (A)tivo e (I)nativo");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}

	public String getNivelCurso() {
		return nivelCurso;
	}

	public void setNivelCurso(String nivelCurso) {
		this.nivelCurso = nivelCurso;
	}

	

 }
