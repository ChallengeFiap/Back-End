package fiap.model;

/**Classe para a CRUD dos objetos do tipo Experiencia no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;

public class ExperienciaDAO implements IDAO {

	private Connection con;
	private Experiencia experiencia;
	
	
	public ExperienciaDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Object obj) {
		experiencia = (Experiencia) obj;
		String sql = "INSERT INTO T_CHALL_EXPERIENCIA (ID_EXPERIENCIA, ID_REGISTRO_GERAL, TP_EXPERIENCIA, DT_INICIO, DT_TERMINO, "
				+ "ST_STATUS) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, experiencia.getIdExperiencia());
			ps.setInt(2, experiencia.getIdRegistroGeral());
			ps.setString(3, experiencia.getExperiencia());
			ps.setDate(4, null);
			ps.setDate(5, null);
			ps.setString(6, experiencia.getStatusExperiencia());
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
		experiencia = (Experiencia) obj;
		String sql = "UPDATE T_CHALL_EXPERIENCIA SET ID_REGISTRO_GERAL = ?, TP_EXPERIENCIA = ?, DT_INICIO = ?, "
				+ "DT_TERMINO = ?, ST_STATUS = ? WHERE ID_EXPERIENCIA = ?";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, experiencia.getIdRegistroGeral());
			ps.setString(2, experiencia.getExperiencia());
			ps.setDate(3, null);
			ps.setDate(4, null);
			ps.setString(5, experiencia.getStatusExperiencia());
			ps.setInt(6, experiencia.getIdExperiencia());
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
		experiencia = (Experiencia) obj;
		String sql = "DELETE FROM T_CHALL_EXPERIENCIA WHERE ID_EXPERIENCIA = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, experiencia.getIdExperiencia());
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
		String sql = "SELECT * FROM T_CHALL_EXPERIENCIA";
		String listaExperiencias = "Lista das Experiencias\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaExperiencias += "ID Experiencia: " + rs.getInt(1) + "\n";
					listaExperiencias += "ID Registro: " + rs.getInt(2) + "\n";
					listaExperiencias += "Tipo Experiencia: " + rs.getString(3) + "\n";
					listaExperiencias += "Data Inicio: " + rs.getDate(4) + "\n";
					listaExperiencias += "Data Termino: " + rs.getDate(5) + "\n";
					listaExperiencias += "Status: " + rs.getString(6) + "\n";	
				}
				return listaExperiencias;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
