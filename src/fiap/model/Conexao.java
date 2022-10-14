package fiap.model;
/**Classe para fazer a Conexão com o Banco de Dados no SQL Developer
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */
import java.sql.*;

public class Conexao {
	/**Método para abrir a conexão com o Banco de dados
	 * @author Luís Felipe
	 * @param null
	 * @return Connection - retorna a Conexão aberta 
	 */
	public static Connection abrirConexao() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			final String USER = "RM94615";
			final String PASS = "170504";
			con = DriverManager.getConnection(url,USER,PASS);
			System.out.println("Conexão Aberta!");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	/**Método para fechar a conexão com o Banco de dados
	 * @author Luís Felipe
	 * @param con - a conexão aberta com o metodo abrirConexao()
	 * @return null
	 */
	public static void fecharConexao(Connection con) {
		try {
			con.close();
			System.out.println("Conexão fechada!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}