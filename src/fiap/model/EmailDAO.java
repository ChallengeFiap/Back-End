package fiap.model;
/**Classe para a CRUD dos objetos do tipo Email no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */
import java.sql.*;

public class EmailDAO implements IDAO {

	private Connection con;
	private Email email;

	public EmailDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		email = (Email) obj;
		String sql = "INSERT INTO T_CHALL_EMAIL(ID_EMAIL, ID_REGISTRO_GERAL, DS_EMAIL, TP_EMAIL, ST_EMAIL) VALUES "
				+ "(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, email.getIdEmail());
			ps.setInt(2, email.getIdRegistroGeral());
			ps.setString(3, email.getEmail());
			ps.setString(4, email.getTipoEmail());
			ps.setString(5, email.getStatusEmail());
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
		email = (Email) obj;
		String sql = "UPDATE T_CHALL_EMAIL SET ID_REGISTRO_GERAL = ?, DS_EMAIL = ?, TP_EMAIL = ?, ST_EMAIL = ? WHERE ID_EMAIL = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, email.getIdRegistroGeral());
			ps.setString(2, email.getEmail());
			ps.setString(3, email.getTipoEmail());
			ps.setString(4, email.getStatusEmail());
			ps.setInt(5, email.getIdEmail());
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
		email = (Email) obj;
		String sql = "DELETE FROM T_CHALL_EMAIL WHERE ID_EMAIL = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, email.getIdEmail());
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
		String sql = "SELECT * FROM T_CHALL_EMAIL";
		String listaEmail = "Lista dos Emails\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaEmail += "ID Email: " + rs.getInt(1) + "\n";
					listaEmail += "ID Resgistro: " + rs.getInt(2) + "\n";
					listaEmail += "Email: " + rs.getString(3) + "\n";
					listaEmail += "Tipo Email: " + rs.getString(4) + "\n";
					listaEmail += "Status Email: " + rs.getString(5) + "\n";
				}
				return listaEmail;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
