package fiap.model;
/**Classe para a CRUD dos objetos do tipo Cidade no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;

public class CidadeDAO implements IDAO{
	
	private Connection con;
	private Cidade cidade;
	
	public CidadeDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		cidade = (Cidade) obj;
		String sql = "INSERT INTO T_CHALL_CIDADE (ID_CIDADE, ID_ESTADO, CD_IBGE, NM_CIDADE, NR_DDD) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, cidade.getIdCidade());
			ps.setInt(2, cidade.getIdEstado());
			ps.setInt(3, cidade.getCodigoIBGE());
			ps.setString(4, cidade.getNomeCidade());
			ps.setInt(5, cidade.getNumeroDDD());
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
		cidade = (Cidade) obj;
		String sql = "UPDATE T_CHALL_CIDADE SET ID_ESTADO = ?, CD_IBGE = ?, NM_CIDADE = ?, NR_DDD = ? WHERE ID_CIDADE = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cidade.getIdEstado());
			ps.setInt(2, cidade.getCodigoIBGE());
			ps.setString(3, cidade.getNomeCidade());
			ps.setInt(4, cidade.getNumeroDDD());
			ps.setInt(5, cidade.getIdCidade());
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
		cidade = (Cidade) obj;
		String sql = "DELETE FROM T_CHALL_CIDADE WHERE ID_CIDADE = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cidade.getIdCidade());
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
		String sql = "SELECT * FROM T_CHALL_CIDADE";
		String listaCidades = "Lista das Cidades\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaCidades += "ID Cidade: " + rs.getInt(1) + "\n";
					listaCidades += "ID Estado: " + rs.getInt(2) + "\n";
					listaCidades += "Codigo IBGE: +" + rs.getInt(3) + "\n";
					listaCidades += "Cidade: +" + rs.getString(4) + "\n";
					listaCidades += "DDD: +" + rs.getInt(5) + "\n";
				}
				return listaCidades;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
