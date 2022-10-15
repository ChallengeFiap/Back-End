package fiap.model;
/**Classe para a CRUD dos objetos do tipo Favorito no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.1
 * @since 23/09/2022
 */

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FavoritoDAO implements IDAO{
	
	private Connection con;
	private Favorito favorito;
	
	public FavoritoDAO(Connection con) {
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
		String sql = "INSERT INTO T_CHALL_FAVORITO (ID_FAVORITO, ID_REGISTRO_RECRUTADOR, ID_REGISTRO_CANDIDATO, DT_FAVORITOU, ST_FAVORITOS) "
				+ "VALUES (?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), 'A')";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataFavorito = favorito.getDataFavoritou().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, favorito.getIdFavorito());
			ps.setInt(2, favorito.getIdRecrutador());
			ps.setInt(3, favorito.getIdCandidato());
			ps.setString(4, dataFavorito);
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
		String sql = "UPDATE T_CHALL_FAVORITO SET ID_REGISTRO_RECRUTADOR = ?, ID_REGISTRO_CANDIDATO = ?,"
				+ " DT_FAVORITOU = TO_DATE(?, 'DD/MM/YYYY'), ST_FAVORITOS = ? WHERE ID_FAVORITO = ?";
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
	
	public ArrayList<Favorito> listarUm(int id) {
		String sql = "SELECT ID_FAVORITO, ID_REGISTRO_RECRUTADOR, ID_REGISTRO_CANDIDATO, TO_CHAR(DT_FAVORITOU, 'YYYY/MM/DD'), ST_FAVORITOS "
				+ "FROM T_CHALL_FAVORITO WHERE ID_FAVORITO = ?";
		ArrayList<Favorito> listaFavorito = new ArrayList<Favorito>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Favorito fa = new Favorito();
				fa.setIdFavorito(rs.getInt(1));
				fa.setIdRecrutador(rs.getInt(2));
				fa.setIdCandidato(rs.getInt(3));

				// Transformando o LocalDate em String para mandar para o Banco de Dados
				String aux = rs.getString(4);
				String data = aux.substring(0, 4) + "-";
				data += aux.substring(5, 7) + "-";
				data += aux.substring(8, 10);
				LocalDate dataFavoritou = LocalDate.parse(data);

				fa.setDataFavoritou(dataFavoritou);
				fa.setStatusFavoritos(rs.getString(5));
				listaFavorito.add(fa);
				return listaFavorito;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	public ArrayList<Favorito> listarTodos() {
		String sql = "SELECT ID_FAVORITO, ID_REGISTRO_RECRUTADOR, ID_REGISTRO_CANDIDATO, TO_CHAR(DT_FAVORITOU, 'YYYY/MM/DD'), ST_FAVORITOS FROM T_CHALL_FAVORITO";
		ArrayList<Favorito> listaFavoritos = new ArrayList<Favorito>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Favorito fa = new Favorito();
					fa.setIdFavorito(rs.getInt(1));
					fa.setIdRecrutador(rs.getInt(2));
					fa.setIdCandidato(rs.getInt(3));

					// Transformando o LocalDate em String para mandar para o Banco de Dados
					String aux = rs.getString(4);
					String data = aux.substring(0, 4) + "-";
					data += aux.substring(5, 7) + "-";
					data += aux.substring(8, 10);
					LocalDate dataFavoritou = LocalDate.parse(data);

					fa.setDataFavoritou(dataFavoritou);
					fa.setStatusFavoritos(rs.getString(5));
					listaFavoritos.add(fa);
				}
				return listaFavoritos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}

}
