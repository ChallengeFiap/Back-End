package fiap.model;

/**Classe para objetos do tipo Favorito
 * @author Luis Felipe
 * @version 1.1
 * @since 23/09/2022
 */

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Favorito {

	private int idFavorito;
	private int idRecrutador;
	private int idCandidato;
	private LocalDate dataFavoritou;
	private String statusFavoritos;

	public int getIdFavorito() {
		return idFavorito;
	}

	public void setIdFavorito(int idFavorito) {
		this.idFavorito = idFavorito;
	}

	public int getIdRecrutador() {
		return idRecrutador;
	}

	public void setIdRecrutador(int idRecrutador) {
		this.idRecrutador = idRecrutador;
	}

	public int getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	public LocalDate getDataFavoritou() {
		return dataFavoritou;
	}

	public void setDataFavoritou(LocalDate dataFavoritou) {
		this.dataFavoritou = dataFavoritou;
		LocalDate inicio = LocalDate.parse("1899-12-31");
		try {
			if (dataFavoritou.isAfter(inicio)) {
				this.dataFavoritou = dataFavoritou;
			} else {
				throw new Exception("Data fora do periodo permitido");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public String getStatusFavoritos() {
		return statusFavoritos;
	}

	public void setStatusFavoritos(String statusFavoritos) {
		this.statusFavoritos = statusFavoritos;
	}

}
