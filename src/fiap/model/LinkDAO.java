package fiap.model;
/**Classe para a CRUD dos objetos do tipo Link no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 19/09/2022
 */

import java.sql.*;

public class LinkDAO implements IDAO{
	
	private Connection con;
	private Link link;
	
	public LinkDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		link = (Link) obj;
		String sql = "INSERT INTO T_CHALL_LINK (ID_LINK, ID_REGISTRO_GERAL, DS_LINK, TP_LINK) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, link.getIdLink());
			ps.setInt(2, link.getIdRegistroGeral());
			ps.setString(3, link.getLink());
			ps.setString(4, link.getNomeLink());
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
		link = (Link) obj;
		String sql = "UPDATE T_CHALL_LINK SET ID_REGISTRO_GERAL = ?, DS_LINK = ?, TP_LINK = ? WHERE ID_LINK = ?";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, link.getIdRegistroGeral());
			ps.setString(2, link.getLink());
			ps.setString(3, link.getNomeLink());
			ps.setInt(4, link.getIdLink());
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
		link = (Link) obj;
		String sql = "DELETE FROM T_CHALL_LINK WHERE ID_LINK = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, link.getIdLink());
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
		String sql = "SELECT * FROM T_CHALL_LINK";
		String listaLink = "Lista dos Links\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaLink += "ID Link: " + rs.getInt(1) + "\n";
					listaLink += "ID Resgistro: " + rs.getInt(2) + "\n";
					listaLink += "Link: +" + rs.getString(3) +"\n";
					listaLink += "Nome Link: " + rs.getString(4) + "\n";
				}
				return listaLink;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
}
