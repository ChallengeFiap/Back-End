package fiap.model;
/**Classe para a CRUD dos objetos do tipo Favorito no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;

public class FavoritoDAO {
	
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
		String sql = "INSERT INTO T_CHALL_FAVORITO (ID_FAVORITO, ID_SELECAO, ID_REGISTRO_GERAL) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, favorito.getIdFavorito());
			ps.setInt(2, favorito.getIdSelecao());
			ps.setInt(3, favorito.getIdRegistroGeral());
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
		String sql = "UPDATE T_CHALL_FAVORITO SET ID_SELECAO = ?, ID_REGISTRO_GERAL = ? WHERE ID_FAVORITO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, favorito.getIdSelecao());
			ps.setInt(2, favorito.getIdRegistroGeral());
			ps.setInt(3, favorito.getIdFavorito());
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
		String sql = "SELECT * FROM T_CHALL_SELECAO";
		String listaFavorito = "Lista das Favoritos\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaFavorito += "ID Favorito: " + rs.getInt(1) + "\n";
					listaFavorito += "ID Selecao: " + rs.getInt(2) + "\n";
					listaFavorito += "ID Registro Geral: +" + rs.getInt(3) + "\n";
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
