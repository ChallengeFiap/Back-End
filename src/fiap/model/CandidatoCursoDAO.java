package fiap.model;

/**Classe para a CRUD dos objetos do tipo CandidatoCurso no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class CandidatoCursoDAO implements IDAO {

	private Connection con;
	private CandidatoCurso candidatoCurso;
	
	public CandidatoCursoDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		candidatoCurso = (CandidatoCurso) obj;
		String sql = "INSERT INTO T_CHALL_CANDIDATO_CURSO (ID_CAND_CURSO, ID_REGISTRO_GERAL, ID_CURSO, DT_INICIO, DT_TERMINO) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = candidatoCurso.getDataInicio().format(formatter);
			String dataTermino = candidatoCurso.getDataFim().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, candidatoCurso.getIdCandidatoCurso());
			ps.setInt(2, candidatoCurso.getIdRegistroGeral());
			ps.setInt(3, candidatoCurso.getIdCurso());
			ps.setString(4, dataInicio);
			ps.setString(5, dataTermino);
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
		candidatoCurso = (CandidatoCurso) obj;
		String sql = "UPDATE T_CHALL_CANDIDATO_CURSO SET ID_REGISTRO_GERAL = ?, ID_CURSO = ?, DT_INICIO = ?, DT_TERMINO = ? "
				+ "WHERE ID_CAND_CURSO = ?";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = candidatoCurso.getDataInicio().format(formatter);
			String dataTermino = candidatoCurso.getDataFim().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, candidatoCurso.getIdRegistroGeral());
			ps.setInt(2, candidatoCurso.getIdCurso());
			ps.setString(3, dataInicio);
			ps.setString(4, dataTermino);
			ps.setInt(5, candidatoCurso.getIdCandidatoCurso());
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
		candidatoCurso = (CandidatoCurso) obj;
		String sql = "DELETE FROM T_CHALL_CANDIDATO_CURSO WHERE ID_CAND_CURSO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, candidatoCurso.getIdCandidatoCurso());
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
		String sql = "SELECT * FROM T_CHALL_CANDIDATO_CURSO";
		String listaCandidatoCurso = "Lista dos CandidatosCursos\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaCandidatoCurso += "ID Candidato Curso: " + rs.getInt(1) + "\n";
					listaCandidatoCurso += "ID Registro Geral: " + rs.getInt(2) + "\n";
					listaCandidatoCurso += "ID Curso: " + rs.getInt(3) + "\n";
					listaCandidatoCurso += "Data Inicio: " + rs.getString(4) + "\n";
					listaCandidatoCurso += "Data Termino: " + rs.getString(5) + "\n";
				}
				return listaCandidatoCurso;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
