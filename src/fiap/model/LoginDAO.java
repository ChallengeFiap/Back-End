package fiap.model;
/**Classe para efetuar o Login no Sistema utilizando a classe Conexao
 * @author Lu�s Felipe
 * @version 1.0
 * @since 19/09/2022
 */

import java.sql.*;

public class LoginDAO {
	
	private Connection con;
	
	public LoginDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String consulta(Login login) {
		String sql = "SELECT * FROM FROM T_CHALL_REGISTRO_GERAL WHERE DS_EMAIL = ? AND DS_SENHA = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, login.getEmailLogin());
			ps.setString(2, login.getSenhaLogin());
			if(ps.executeUpdate() > 0) {
				return "Logado com sucesso.";
			} else {
				return "Erro ao logar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

}
