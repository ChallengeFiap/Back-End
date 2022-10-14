package fiap.model;
/**Classe para objetos do tipo RegistroCandidato
 * @author Luís Felipe
 * @version 1.1
 * @since 07/09/2022
 */

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class RegistroCandidato extends UsuarioRegistroGeral {

	private String numeroRG;
	private LocalDate dataNascimento;
	private String sexo;
	private String escolaridade;
	private String estadoCivil;
	private String cargo;

	public String getNumeroRG() {
		return numeroRG;
	}

	public void setNumeroRG(String numeroRG) {
		this.numeroRG = numeroRG;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		LocalDate inicio = LocalDate.parse("1899-12-31");
		LocalDate fim = LocalDate.now();
		try {
			if (dataNascimento.isAfter(inicio) && dataNascimento.isBefore(fim)) {
				this.dataNascimento = dataNascimento;
			} else {
				throw new Exception("Data fora do periodo permitido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	
	

}
