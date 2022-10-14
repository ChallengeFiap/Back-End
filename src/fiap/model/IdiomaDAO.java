package fiap.model;
/**Classe para a CRUD dos objetos do tipo Idioma no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;
import java.util.ArrayList;

public class IdiomaDAO implements IDAO{
	
	private Connection con;
	private Idioma idioma;
	
	public IdiomaDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		idioma = (Idioma) obj;
		String sql = "INSERT INTO T_CHALL_IDIOMAS (ID_IDOMAS, TP_IDIOMAS) VALUES (?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, idioma.getIdIdioma());
			ps.setString(2, idioma.getIdioma());
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
		idioma = (Idioma) obj;
		String sql = "UPDATE T_CHALL_IDIOMAS SET TP_IDIOMAS = ? WHERE ID_IDOMAS = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, idioma.getIdioma());
			ps.setInt(2, idioma.getIdIdioma());
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
		idioma = (Idioma) obj;
		String sql = "DELETE FROM T_CHALL_IDIOMAS WHERE ID_IDOMAS = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, idioma.getIdIdioma());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso!";
			} else {
				return "Erro ao excluir!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Idioma> listarUm(int id) {
		String sql = "SELECT * FROM T_CHALL_IDIOMAS WHERE ID_FAVORITO = ?";
		ArrayList<Idioma> listaIdiomas = new ArrayList<Idioma>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Idioma idm = new Idioma();
				idm.setIdIdioma(rs.getInt(1));
				idm.setIdioma(rs.getString(2));
				listaIdiomas.add(idm);
				return listaIdiomas;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public ArrayList<Idioma> listarTodos() {
		String sql = "SELECT * FROM T_CHALL_IDIOMAS";
		ArrayList<Idioma> listaIdiomas = new ArrayList<Idioma>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Idioma id = new Idioma();
					id.setIdIdioma(rs.getInt(1));
					id.setIdioma(rs.getString(2));
					listaIdiomas.add(id);
				}
				return listaIdiomas;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	

}
