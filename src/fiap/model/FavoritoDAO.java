package fiap.model;
/**Classe para a CRUD dos objetos do tipo Favorito no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.1
 * @since 23/09/2022
 */

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class FavoritoDAO implements IDAO{
	
	private Connection con;
	private Favorito favorito;
	
	public FavoritoDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		favorito = (Favorito) obj;
		String sql = "INSERT INTO T_CHALL_FAVORITO (ID_FAVORITO, ID_RECRUTADOR, ID_CANDIDATO, DT_FAVORITOU, ST_FAVORITOS) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataFavorito = favorito.getDataFavoritou().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, favorito.getIdFavorito());
			ps.setInt(2, favorito.getIdRecrutador());
			ps.setInt(3, favorito.getIdCandidato());
			ps.setString(4, dataFavorito);
			ps.setString(5, favorito.getStatusFavoritos());
			if(ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String alterar(Object obj) {
		favorito = (Favorito) obj;
		String sql = "UPDATE T_CHALL_FAVORITO SET ID_RECRUTADOR = ?, ID_CANDIDATO = ?, DT_FAVORITOU = ?, ST_FAVORITOS = ? "
				+ "WHERE ID_FAVORITO = ?";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataFavorito = favorito.getDataFavoritou().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, favorito.getIdRecrutador());
			ps.setInt(2, favorito.getIdCandidato());
			ps.setString(3, dataFavorito);
			ps.setString(4, favorito.getStatusFavoritos());
			ps.setInt(5, favorito.getIdFavorito());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso!";
			} else {
				return "Erro ao alterar!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String excluir(Object obj) {
		favorito = (Favorito) obj;
		String sql = "DELETE FROM T_CHALL_FAVORITO WHERE ID_FAVORITO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, favorito.getIdFavorito());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso!";
			} else {
				return "Erro ao excluir!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String listarTodos() {
		String sql = "SELECT * FROM T_CHALL_FAVORITO";
		String listaFavorito = "Lista das Favoritos\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaFavorito += "ID Favorito: " + rs.getInt(1) + "\n";
					listaFavorito += "ID Recrutador: " + rs.getInt(2) + "\n";
					listaFavorito += "ID Candidato: " + rs.getInt(3) + "\n";
					listaFavorito += "Data Favorito: " + rs.getString(4) + "\n";
					listaFavorito += "Status Favorito: " + rs.getInt(5) + "\n";
				}
				return listaFavorito;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
