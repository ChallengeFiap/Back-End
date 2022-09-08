package fiap.model;
/**Classe para a CRUD dos objetos do tipo Estado no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;

public class EstadoDAO implements IDAO{
	
	private Connection con;
	private Estado estado;
	
	public EstadoDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		estado = (Estado) obj;
		String sql = "INSERT INTO T_CHALL_ESTADO (ID_ESTADO, SG_ESTADO, NM_ESTADO) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, estado.getIdEstado());
			ps.setString(2, estado.getSiglaEstado());
			ps.setString(3, estado.getNomeEstado());
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
		estado = (Estado) obj;
		String sql = "UPDATE T_CHALL_ESTADO SET SG_ESTADO = ?, NM_ESTADO = ? WHERE ID_ESTADO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, estado.getSiglaEstado());
			ps.setString(2, estado.getNomeEstado());
			ps.setInt(3, estado.getIdEstado());
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
		estado = (Estado) obj;
		String sql = "DELETE FROM T_CHALL_ESTADO WHERE ID_FAVORITO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, estado.getIdEstado());
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
		String sql = "SELECT * FROM T_CHALL_ESTADO";
		String listaEstados = "Lista dos Estados\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaEstados += "ID Estado: " + rs.getInt(1) + "\n";
					listaEstados += "Sigla Estado: " + rs.getString(2) + "\n";
					listaEstados += "Estado: +" + rs.getString(3) + "\n";
				}
				return listaEstados;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
