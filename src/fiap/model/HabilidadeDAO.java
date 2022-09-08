package fiap.model;

/**Classe para a CRUD dos objetos do tipo Habilidade no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */
import java.sql.*;

public class HabilidadeDAO implements IDAO {

	private Connection con;
	private Habilidade habilidade;
	
	public HabilidadeDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		habilidade = (Habilidade) obj;
		String sql = "INSERT INTO T_CHALL_HABILIDADE (ID_HABILIDADE, NM_HABILIDADE, DS_DESCRICAO) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, habilidade.getIdHabilidade());
			ps.setString(2, habilidade.getHabilidade());
			ps.setString(3, habilidade.getDescricaoHabilidade());
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
		habilidade = (Habilidade) obj;
		String sql = "UPDATE T_CHALL_HABILIDADE SET NM_HABILIDADE = ?, DS_DESCRICAO = ? WHERE ID_HABILIDADE = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, habilidade.getHabilidade());
			ps.setString(2, habilidade.getDescricaoHabilidade());
			ps.setInt(3, habilidade.getIdHabilidade());
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
		habilidade = (Habilidade) obj;
		String sql = "DELETE FROM T_CHALL_HABILIDADE WHERE ID_HABILIDADE = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, habilidade.getIdHabilidade());
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
		String sql = "SELECT * FROM T_CHALL_HABILIDADE";
		String listaHabilidade = "Lista das Habilidades\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaHabilidade += "ID Habilidade: " + rs.getInt(1) + "\n";
					listaHabilidade += "Habilidade: " + rs.getString(2) + "\n";
					listaHabilidade += "Descricao Habilidade: +" + rs.getString(3) + "\n";
				}
				return listaHabilidade;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
