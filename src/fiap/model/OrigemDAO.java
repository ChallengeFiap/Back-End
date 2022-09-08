package fiap.model;

/**Classe para a CRUD dos objetos do tipo Origem no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;

public class OrigemDAO implements IDAO{
	
	private Connection con;
	private Origem origem;
	
	public OrigemDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		origem = (Origem) obj;
		String sql = "INSERT INTO T_CHALL_ORIGEM (ID_ORIGEM, ID_REGISTRO_GERAL, DS_ONDEVEIO) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, origem.getIdOrigem());
			ps.setInt(2, origem.getIdRegistroGeral());
			ps.setString(3, origem.getDescricaoOndeVeio());
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
		origem = (Origem) obj;
		String sql = "UPDATE T_CHALL_ORIGEM SET ID_REGISTRO_GERAL = ?, DS_ONDEVEIO = ? WHERE ID_ORIGEM = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, origem.getIdRegistroGeral());
			ps.setString(2, origem.getDescricaoOndeVeio());
			ps.setInt(3, origem.getIdOrigem());
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
		origem = (Origem) obj;
		String sql = "DELETE FROM T_CHALL_ORIGEM WHERE ID_ORIGEM = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, origem.getIdOrigem());
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
		String sql = "SELECT * FROM T_CHALL_ORIGEM";
		String listaHabilidade = "Lista das Origens\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaHabilidade += "ID Origem: " + rs.getInt(1) + "\n";
					listaHabilidade += "ID Registro Geral: " + rs.getInt(2) + "\n";
					listaHabilidade += "Onde Veio: +" + rs.getString(3) + "\n";
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
