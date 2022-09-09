package fiap.model;
/**Classe para objetos do tipo RegistroCandidato
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class RegistroCandidato extends UsuarioRegistroGeral {

	private int numeroCPF;
	private int numeroRG;
	private LocalDate dataNascimento;
	private String sexo;
	private String escolaridade;
	private String estadoCivil;
	private String origem;

	public int getNumeroCPF() {
		return numeroCPF;
	}

	public void setNumeroCPF(int numeroCPF) {
		this.numeroCPF = numeroCPF;
	}

	public int getNumeroRG() {
		return numeroRG;
	}

	public void setNumeroRG(int numeroRG) {
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
			System.exit(0);
			
		}
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		try {
			if (sexo.length() == 1) {
				this.sexo = sexo;
			} else {
				throw new Exception ("O sexo deve ter apenas 1 caracter sendo, (M)asculino e (F)eninimo");
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
		this.escolaridade = escolaridade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	

}
