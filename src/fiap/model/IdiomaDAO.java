package fiap.model;
/**Classe para a CRUD dos objetos do tipo Idioma no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;

public class IdiomaDAO implements IDAO{
	
	private Connection con;
	private Idioma idioma;
	
	public IdiomaDAO() {
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
		String sql = "INSERT INTO T_CHALL_IDIOMAS (ID_IDOMAS, TP_IDIOMAS, FL_PROFICIENCIA) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, idioma.getIdIdioma());
			ps.setString(2, idioma.getIdioma());
			ps.setString(3, idioma.getFluencia());
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
		String sql = "UPDATE T_CHALL_IDIOMAS SET TP_IDIOMAS = ?, FL_PROFICIENCIA = ? WHERE ID_IDOMAS = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, idioma.getIdioma());
			ps.setString(2, idioma.getFluencia());
			ps.setInt(3, idioma.getIdIdioma());
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
	
	public String listarTodos() {
		String sql = "SELECT * FROM T_CHALL_IDIOMAS";
		String listaIdiomas = "Lista dos Idiomas\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaIdiomas += "ID Idioma: " + rs.getInt(1) + "\n";
					listaIdiomas += "Idioma: " + rs.getString(2) + "\n";
					listaIdiomas += "Fluencia: +" + rs.getString(3) + "\n";
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
