package fiap.model;
/**Classe para a CRUD dos objetos do tipo Linguagem no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 19/09/2022
 */

import java.sql.*;
import java.util.ArrayList;

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
		String sql = "INSERT INTO T_CHALL_LINGUAGEM (ID_LINGUAGEM, TP_LINGUAGEM) VALUES (?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, linguagem.getIdLinguagem());
			ps.setString(2, linguagem.getLinguagem());
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
		String sql = "UPDATE T_CHALL_LINGUAGEM SET TP_LINGUAGEM = ? WHERE ID_LINGUAGEM = ?";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setString(1, linguagem.getLinguagem());
			ps.setInt(2, linguagem.getIdLinguagem());
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
	
	public ArrayList<Linguagem> listarUm(int id) {
		String sql = "SELECT * FROM T_CHALL_LINGUAGEM WHERE ID_LINGUAGEM = ?";
		ArrayList<Linguagem> listaLinguagens = new ArrayList<Linguagem>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Linguagem li = new Linguagem();
				li.setIdLinguagem(rs.getInt(1));
				li.setLinguagem(rs.getString(2));
				listaLinguagens.add(li);
				return listaLinguagens;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public ArrayList<Linguagem> listarTodos() {
		String sql = "SELECT * FROM T_CHALL_LINGUAGEM";
		ArrayList<Linguagem> listaLinguagens = new ArrayList<Linguagem>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Linguagem li = new Linguagem();
					li.setIdLinguagem(rs.getInt(1));
					li.setLinguagem(rs.getString(2));
					listaLinguagens.add(li);
				}
				return listaLinguagens;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
}
