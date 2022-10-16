package fiap.model;

/**Classe para a CRUD dos objetos do tipo Cidade no Banco de Dados utilizando a classe Conexao
 * @author Luis Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;
import java.util.ArrayList;

public class CidadeDAO implements IDAO {

	private Connection con;
	private Cidade cidade;

	public CidadeDAO(Connection con) {
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
		String sql = "INSERT INTO T_CHALL_CIDADE (ID_CIDADE, ID_REGISTRO_GERAL, ID_ESTADO, NM_CIDADE) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cidade.getIdCidade());
			ps.setInt(2, cidade.getIdRegistroGeral());
			ps.setInt(3, cidade.getIdEstado());
			ps.setString(4, cidade.getNomeCidade());
			if (ps.executeUpdate() > 0) {
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
		String sql = "UPDATE T_CHALL_CIDADE SET ID_ESTADO = ?,  ID_REGISTRO_GERAL = ?, NM_CIDADE = ? WHERE ID_CIDADE = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cidade.getIdEstado());
			ps.setInt(2, cidade.getIdRegistroGeral());
			ps.setString(3, cidade.getNomeCidade());
			ps.setInt(4, cidade.getIdCidade());
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

	public ArrayList<Cidade> listarUm(int id) {
		String sql = "SELECT * FROM T_CHALL_CIDADE WHERE ID_CIDADE = ?";
		ArrayList<Cidade> listaCidades = new ArrayList<Cidade>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Cidade ci = new Cidade();
				ci.setIdCidade(rs.getInt(1));
				ci.setIdRegistroGeral(rs.getInt(2));
				ci.setIdEstado(rs.getInt(3));
				ci.setNomeCidade(rs.getString(4));
				listaCidades.add(ci);
				return listaCidades;

			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public ArrayList<Cidade> listarTodos() {
		String sql = "SELECT * FROM T_CHALL_CIDADE ORDER BY ID_CIDADE";
		ArrayList<Cidade> listaCidades = new ArrayList<Cidade>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Cidade ci = new Cidade();
					ci.setIdCidade(rs.getInt(1));
					ci.setIdRegistroGeral(rs.getInt(2));
					ci.setIdEstado(rs.getInt(3));
					ci.setNomeCidade(rs.getString(4));
					listaCidades.add(ci);
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
