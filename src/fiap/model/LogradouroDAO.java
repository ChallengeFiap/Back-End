package fiap.model;

/**Classe para a CRUD dos objetos do tipo Logradouro no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;


public class LogradouroDAO implements IDAO {
	
	private Connection con;
	private Logradouro logradouro;
	
	public LogradouroDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		logradouro = (Logradouro) obj;
		String sql = "INSERT INTO T_CHALL_LOGRADOURO (ID_LOGRADOURO, ID_BAIRRO, NM_LOGRADOURO, NR_CEP) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, logradouro.getIdLogradouro());
			ps.setInt(2, logradouro.getIdBairro());
			ps.setString(3, logradouro.getNomeLogradouro());
			ps.setInt(4, logradouro.getNumeroCEP());
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
		logradouro = (Logradouro) obj;
		String sql = "UPDATE T_CHALL_LOGRADOURO SET ID_BAIRRO = ?, NM_LOGRADOURO = ?, NR_CEP = ? WHERE ID_LOGRADOURO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, logradouro.getIdBairro());
			ps.setString(2, logradouro.getNomeLogradouro());
			ps.setInt(3, logradouro.getNumeroCEP());
			ps.setInt(4, logradouro.getIdLogradouro());
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
		logradouro = (Logradouro) obj;
		String sql = "DELETE FROM T_CHALL_LOGRADOURO WHERE ID_LOGRADOURO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, logradouro.getIdLogradouro());
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
		String sql = "SELECT * FROM T_CHALL_LOGRADOURO";
		String listaLogradouros = "Lista dos Logradouros\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaLogradouros += "ID Logradouro: " + rs.getInt(1) + "\n";
					listaLogradouros += "ID Bairro: " + rs.getInt(2) + "\n";
					listaLogradouros += "Logradouro: +" + rs.getString(3) + "\n";
					listaLogradouros += "CEP: " + rs.getInt(4) + "\n";
				}
				return listaLogradouros;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
