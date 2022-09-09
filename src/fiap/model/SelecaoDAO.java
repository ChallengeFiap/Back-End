package fiap.model;

/**Classe para a CRUD dos objetos do tipo Selecao no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class SelecaoDAO implements IDAO {
	
	private Connection con;
	private Selecao selecao;
	
	public SelecaoDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		selecao = (Selecao) obj;
		String sql = "INSERT INTO T_CHALL_SELECAO (ID_SELECAO, ST_APROVACAO, DT_ENTREVISTA) VALUES (?, ?, ?)";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataEntrevista = selecao.getDataSelecao().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, selecao.getIdSelecao());
			ps.setString(2, selecao.getStatusAprovacao());
			ps.setString(3, dataEntrevista);
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
		selecao = (Selecao) obj;
		String sql = "UPDATE T_CHALL_SELECAO SET ST_APROVACAO = ?, DT_ENTREVISTA = ? WHERE ID_SELECAO = ?";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataEntrevista = selecao.getDataSelecao().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, selecao.getStatusAprovacao());
			ps.setString(2, dataEntrevista);
			ps.setInt(3, selecao.getIdSelecao());
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
		selecao = (Selecao) obj;
		String sql = "DELETE FROM T_CHALL_SELECAO WHERE ID_SELECAO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, selecao.getIdSelecao());
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
		String sql = "SELECT * FROM T_CHALL_SELECAO";
		String listaSelecao = "Lista das Selecoes\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaSelecao += "ID Selecao: " + rs.getInt(1) + "\n";
					listaSelecao += "Status Aprovacao: " + rs.getString(2) + "\n";
					listaSelecao += "Data Entrevista: +" + rs.getString(3) + "\n";
				}
				return listaSelecao;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
