package fiap.model;

import javax.swing.JOptionPane;

public class Telefone {

	private int idTelefone;
	private int idRegistroGeral;
	private int numeroDDI;
	private int numeroDDD;
	private int telefone;
	private String tipoTelefone;
	private String statusTelefone;

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public int getIdRegistroGeral() {
		return idRegistroGeral;
	}

	public void setIdRegistroGeral(int idRegistroGeral) {
		this.idRegistroGeral = idRegistroGeral;
	}

	public int getNumeroDDI() {
		return numeroDDI;
	}

	public void setNumeroDDI(int numeroDDI) {
		this.numeroDDI = numeroDDI;
	}

	public int getNumeroDDD() {
		return numeroDDD;
	}

	public void setNumeroDDD(int numeroDDD) {
		this.numeroDDD = numeroDDD;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getStatusTelefone() {
		return statusTelefone;
	}

	public void setStatusTelefone(String statusTelefone) {
		try {
			if (statusTelefone.length() == 1) {
				this.statusTelefone = statusTelefone;
			} else {
				throw new Exception ("Status Telefone deve ter apenas 1 caracter sendo, (A)tivo e (I)nativo");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
		
	}

}
