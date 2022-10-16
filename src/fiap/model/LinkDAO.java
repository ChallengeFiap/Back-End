package fiap.model;
/**Classe para a CRUD dos objetos do tipo Link no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 19/09/2022
 */

import java.sql.*;
import java.util.ArrayList;

public class LinkDAO implements IDAO{
	
	private Connection con;
	private Link link;
	
	public LinkDAO(Connection con) {
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
	
	public ArrayList<Link> listarUm(int id) {
		String sql = "SELECT * FROM T_CHALL_LINK WHERE ID_LINK = ?";
		ArrayList<Link> listaLinks = new ArrayList<Link>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Link lk = new Link();
				lk.setIdLink(rs.getInt(1));
				lk.setIdRegistroGeral(rs.getInt(2));
				lk.setLink(rs.getString(3));
				lk.setNomeLink(rs.getString(4));
				listaLinks.add(lk);
				return listaLinks;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public ArrayList<Link> listarTodos() {
		String sql = "SELECT * FROM T_CHALL_LINK ORDER BY ID_LINK";
		ArrayList<Link> listaLinks = new ArrayList<Link>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Link lk = new Link();
					lk.setIdLink(rs.getInt(1));
					lk.setIdRegistroGeral(rs.getInt(2));
					lk.setLink(rs.getString(3));
					lk.setNomeLink(rs.getString(4));
					listaLinks.add(lk);
				}
				return listaLinks;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
}
