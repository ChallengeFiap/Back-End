package fiap.model;
/**Classe para a CRUD dos objetos do tipo Bairro no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;

public class BairroDAO implements IDAO {
	
	private Connection con;
	private Bairro bairro;
	
	public BairroDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		bairro = (Bairro) obj;
		String sql = "INSERT INTO T_CHALL_BAIRRO (ID_BAIRRO, ID_CIDADE, NM_BAIRRO, NM_ZONA_BAIRRO) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, bairro.getIdBairro());
			ps.setInt(2, bairro.getIdCidade());
			ps.setString(3, bairro.getNomeBairro());
			ps.setString(4, bairro.getNomeZonaBairro());
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
		bairro = (Bairro) obj;
		String sql = "UPDATE T_CHALL_BAIRRO SET ID_CIDADE = ?, NM_BAIRRO = ?, NM_ZONA_BAIRRO = ? WHERE ID_BAIRRO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, bairro.getIdCidade());
			ps.setString(2, bairro.getNomeBairro());
			ps.setString(3, bairro.getNomeZonaBairro());
			ps.setInt(4, bairro.getIdBairro());
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
		bairro = (Bairro) obj;
		String sql = "DELETE FROM T_CHALL_BAIRRO WHERE ID_BAIRRO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, bairro.getIdBairro());
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
		String sql = "SELECT * FROM T_CHALL_BAIRRO";
		String listaBairros = "Lista dos Bairros\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaBairros += "ID Bairro: " + rs.getInt(1) + "\n";
					listaBairros += "ID Cidade: " + rs.getInt(2) + "\n";
					listaBairros += "Bairro: " + rs.getString(3) + "\n";
					listaBairros += "Zona Bairro: +" + rs.getString(4) + "\n";
				}
				return listaBairros;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
