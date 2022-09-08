package fiap.model;

/**
 * Classe para objetos do tipo Endereco
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Endereco {

	private int idEndereco;
	private int idRegistroGeral;
	private int idLogradouro;
	private int numeroLogradouro;
	private String complementoNumero;
	private String pontoReferencia;
	private LocalDate dataInicio;
	private LocalDate dataFim;

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public int getIdLogradouro() {
		return idLogradouro;
	}

	public void setIdLogradouro(int idLogradouro) {
		this.idLogradouro = idLogradouro;
	}

	public int getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(int numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getComplementoNumero() {
		return complementoNumero;
	}

	public void setComplementoNumero(String complementoNumero) {
		this.complementoNumero = complementoNumero;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
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
