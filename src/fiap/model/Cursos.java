package fiap.model;

/**
 * Classe para objetos do tipo Cursos
 * 
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import javax.swing.JOptionPane;

public class Cursos {

	private int idCurso;
	private int numeroCurso;
	private String siglaCurso;
	private String nomeCurso;

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getNumeroCurso() {
		return numeroCurso;
	}

	public void setNumeroCurso(int numeroCurso) {
		this.numeroCurso = numeroCurso;
	}

	public String getSiglaCurso() {
		return siglaCurso;
	}

	public void setSiglaCurso(String siglaCurso) {
		try {
			if (siglaCurso.length() == 3) {
				this.siglaCurso = siglaCurso;
			} else {
				throw new Exception ("Sigla do Curso deve ter 3 caracter");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

}
