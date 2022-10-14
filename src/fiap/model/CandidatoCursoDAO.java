package fiap.model;

/**Classe para a CRUD dos objetos do tipo CandidatoCurso no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CandidatoCursoDAO implements IDAO {

	private Connection con;
	private CandidatoCurso candidatoCurso;
	
	public CandidatoCursoDAO(Connection con) {
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
	
	public ArrayList<CandidatoCurso> listarUm(int id) {
		String sql = "SELECT * FROM T_CHALL_CANDIDATO_CURSO WHERE ID_CAND_CURSO = ?";
		ArrayList<CandidatoCurso> listaCandidatosCursos = new ArrayList<CandidatoCurso>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				CandidatoCurso cc = new CandidatoCurso();
				cc.setIdCandidatoCurso(rs.getInt(1));
				cc.setIdRegistroGeral(rs.getInt(2));
				cc.setIdCurso(rs.getInt(3));

				// Transformando a String de Data do Banco em LocalDate
				String aux = rs.getString(4);
				LocalDate dataInicio = LocalDate.parse(aux);
				
				cc.setDataInicio(dataInicio);
				
				aux = rs.getString(5);
				LocalDate dataFim = LocalDate.parse(aux);
				
				cc.setDataFim(dataFim);
				listaCandidatosCursos.add(cc);
				return listaCandidatosCursos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	public ArrayList<CandidatoCurso> listarTodos() {
		String sql = "SELECT * FROM T_CHALL_CANDIDATO_CURSO";
		ArrayList<CandidatoCurso> listaCandidatosCursos = new ArrayList<CandidatoCurso>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					CandidatoCurso cc = new CandidatoCurso();
					cc.setIdCandidatoCurso(rs.getInt(1));
					cc.setIdRegistroGeral(rs.getInt(2));
					cc.setIdCurso(rs.getInt(3));

					// Transformando a String de Data do Banco em LocalDate
					String aux = rs.getString(4);
					LocalDate dataInicio = LocalDate.parse(aux);
					
					cc.setDataInicio(dataInicio);
					
					aux = rs.getString(5);
					LocalDate dataFim = LocalDate.parse(aux);
					
					cc.setDataFim(dataFim);
					listaCandidatosCursos.add(cc);
				}
				return listaCandidatosCursos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}

}
