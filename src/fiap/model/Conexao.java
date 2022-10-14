package fiap.model;
/**Classe para fazer a Conex�o com o Banco de Dados no SQL Developer
 * @author Lu�s Felipe
 * @version 1.0
 * @since 07/09/2022
 */
import java.sql.*;

public class Conexao {
	/**M�todo para abrir a conex�o com o Banco de dados
	 * @author Lu�s Felipe
	 * @param null
	 * @return Connection - retorna a Conex�o aberta 
	 */
	public static Connection abrirConexao() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			final String USER = "RM94615";
			final String PASS = "170504";
			con = DriverManager.getConnection(url,USER,PASS);
			System.out.println("Conex�o Aberta!");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	/**M�todo para fechar a conex�o com o Banco de dados
	 * @author Lu�s Felipe
	 * @param con - a conex�o aberta com o metodo abrirConexao()
	 * @return null
	 */
	public static void fecharConexao(Connection con) {
		try {
			con.close();
			System.out.println("Conex�o fechada!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}