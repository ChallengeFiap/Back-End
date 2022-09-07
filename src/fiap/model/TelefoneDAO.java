package fiap.model;
/**Classe para a CRUD dos objetos do tipo Telefone no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */
import java.sql.*;

public class TelefoneDAO implements IDAO {

	private Connection con;
	private Telefone telefone;

	public TelefoneDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Object obj) {
		telefone = (Telefone) obj;
		String sql = "INSERT INTO T_CHALL_TELEFONE (ID_TELEFONE, ID_REGISTRO_GERAL, NR_DDI, NR_DDD, NR_TELEFONE, TP_TELEFONE, ST_TELEFONE) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, telefone.getIdTelefone());
			ps.setInt(2, telefone.getIdRegistroGeral());
			ps.setInt(3, telefone.getNumeroDDI());
			ps.setInt(4, telefone.getNumeroDDD());
			ps.setInt(5, telefone.getTelefone());
			ps.setString(6, telefone.getTipoTelefone());
			ps.setString(7, telefone.getStatusTelefone());
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
		telefone = (Telefone) obj;
		String sql = "UPDATE T_CHALL_TELEFONE SET ID_REGISTRO_GERAL = ?, NR_DDI = ?, NR_DDD = ?, NR_TELEFONE = ?, TP_TELEFONE = ?,"
				+ "ST_TELEFONE = ? WHERE ID_TELEFONE = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, telefone.getIdRegistroGeral());
			ps.setInt(2, telefone.getNumeroDDI());
			ps.setInt(3, telefone.getNumeroDDD());
			ps.setInt(4, telefone.getTelefone());
			ps.setString(5, telefone.getTipoTelefone());
			ps.setString(6, telefone.getStatusTelefone());
			ps.setInt(7, telefone.getIdTelefone());
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
		telefone = (Telefone) obj;
		String sql = "DELETE FROM T_CHALL_TELEFONE WHERE ID_TELEFONE = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, telefone.getIdTelefone());
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
		String sql = "SELECT * FROM T_CHALL_TELEFONE";
		String listaTelefone = "Lista dos Telefones\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaTelefone += "ID Telefone: " + rs.getInt(1) + "\n";
					listaTelefone += "ID Resgistro: " + rs.getInt(2) + "\n";
					listaTelefone += "Telefone: +" + rs.getInt(3) + " (" + rs.getInt(4) + ") " + rs.getInt(5) + "\n";
					listaTelefone += "Tipo Telefone: " + rs.getString(6) + "\n";
					listaTelefone += "Status Telefone: " + rs.getString(7) + "\n";
				}
				return listaTelefone;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	

}
