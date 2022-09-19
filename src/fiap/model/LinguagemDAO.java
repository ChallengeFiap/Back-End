package fiap.model;
/**Classe para a CRUD dos objetos do tipo Linguagem no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 19/09/2022
 */

import java.sql.*;

public class LinguagemDAO implements IDAO{
	
	private Connection con;
	private Linguagem linguagem;
	
	public LinguagemDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		linguagem = (Linguagem) obj;
		String sql = "INSERT INTO T_CHALL_LINGUAGEM (ID_LINGUAGEM, TP_LINGUAGEM, FL_PROFICIENCIA) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, linguagem.getIdLinguagem());
			ps.setString(2, linguagem.getLinguagem());
			ps.setString(3, linguagem.getNivelProficiencia());
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
		linguagem = (Linguagem) obj;
		String sql = "UPDATE T_CHALL_LINGUAGEM SET TP_LINGUAGEM = ?, FL_PROFICIENCIA = ? WHERE ID_LINGUAGEM = ?";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setString(1, linguagem.getLinguagem());
			ps.setString(2, linguagem.getNivelProficiencia());
			ps.setInt(3, linguagem.getIdLinguagem());
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
		linguagem = (Linguagem) obj;
		String sql = "DELETE FROM T_CHALL_LINGUAGEM WHERE ID_LINGUAGEM = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, linguagem.getIdLinguagem());
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
		String sql = "SELECT * FROM T_CHALL_LINGUAGEM";
		String listaLinguagem = "Lista das Linguagens de Programação\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaLinguagem += "ID Linguagem: " + rs.getInt(1) + "\n";
					listaLinguagem += "Link: +" + rs.getString(2) +"\n";
					listaLinguagem += "Nome Link: " + rs.getString(3) + "\n";
				}
				return listaLinguagem;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
}
