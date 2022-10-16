package fiap.model;

/**Classe para a CRUD dos objetos do tipo Formação Academica no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.1
 * @since 07/09/2022
 */

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FormacaoAcademicaDAO implements IDAO{

	private Connection con;
	private FormacaoAcademica formacaoAcademica;
	
	public FormacaoAcademicaDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		formacaoAcademica = (FormacaoAcademica) obj;
		String sql = "INSERT INTO T_CHALL_FORMACAO_ACADEMICA (ID_FORMACAO_ACADEMICA, ID_REGISTRO_GERAL, NM_INSTITUICAO, "
				+ "DS_ATV_EXTRA_CURRICULARES, DT_INICIO, DT_TERMINO, NM_CURSO, DS_STATUS_CURSO, DS_ESCOLARIDADE, DS_SEMESTRE, FL_CURSO) "
				+ "VALUES (?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), TO_DATE(?, 'DD/MM/YYYY'), ?, 'A', ?, ?, ?)";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = formacaoAcademica.getDataInicio().format(formatter);
			String dataTermino = formacaoAcademica.getDataTermino().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, formacaoAcademica.getIdFormacaoAcademica());
			ps.setInt(2, formacaoAcademica.getIdRegistroGeral());
			ps.setString(3, formacaoAcademica.getNomeInstituicao());
			ps.setString(4, formacaoAcademica.getAtividadeExtraCurricular());
			ps.setString(5, dataInicio);
			ps.setString(6, dataTermino);
			ps.setString(7, formacaoAcademica.getNomeCurso());
			ps.setString(8, formacaoAcademica.getEscolaridade());
			ps.setString(9, formacaoAcademica.getSemestre());
			ps.setString(10, formacaoAcademica.getNivelCurso());
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
		formacaoAcademica = (FormacaoAcademica) obj;
		String sql = "UPDATE T_CHALL_FORMACAO_ACADEMICA SET ID_REGISTRO_GERAL = ?, NM_INSTITUICAO = ?, DS_ATV_EXTRA_CURRICULARES = ?, "
				+ "DT_INICIO = TO_DATE(?, 'DD/MM/YYYY'), DT_TERMINO = TO_DATE(?, 'DD/MM/YYYY'), NM_CURSO = ?, DS_STATUS_CURSO = ?, "
				+ "DS_ESCOLARIDADE = ?,DS_SEMESTRE = ?, FL_CURSO = ? WHERE ID_FORMACAO_ACADEMICA = ?";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = formacaoAcademica.getDataInicio().format(formatter);
			String dataTermino = formacaoAcademica.getDataTermino().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, formacaoAcademica.getIdRegistroGeral());
			ps.setString(2, formacaoAcademica.getNomeInstituicao());
			ps.setString(3, formacaoAcademica.getAtividadeExtraCurricular());
			ps.setString(4, dataInicio);
			ps.setString(5, dataTermino);
			ps.setString(6, formacaoAcademica.getNomeCurso());
			ps.setString(7, formacaoAcademica.getStatusCurso());
			ps.setString(8, formacaoAcademica.getEscolaridade());
			ps.setString(9, formacaoAcademica.getSemestre());
			ps.setString(10, formacaoAcademica.getNivelCurso());
			ps.setInt(11, formacaoAcademica.getIdFormacaoAcademica());
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
		formacaoAcademica = (FormacaoAcademica) obj;
		String sql = "DELETE FROM T_CHALL_FORMACAO_ACADEMICA WHERE ID_FORMACAO_ACADEMICA = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, formacaoAcademica.getIdFormacaoAcademica());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso!";
			} else {
				return "Erro ao excluir!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<FormacaoAcademica> listarUm(int id) {
		String sql = "SELECT ID_FORMACAO_ACADEMICA, ID_REGISTRO_GERAL, NM_INSTITUICAO, DS_ATV_EXTRA_CURRICULARES, TO_CHAR(DT_INICIO, 'YYYY/MM/DD'), "
				+ "TO_CHAR(DT_TERMINO, 'YYYY/MM/DD'), NM_CURSO, DS_STATUS_CURSO, DS_ESCOLARIDADE, DS_SEMESTRE, FL_CURSO "
				+ "FROM T_CHALL_FORMACAO_ACADEMICA WHERE ID_FORMACAO_ACADEMICA = ?";
		ArrayList<FormacaoAcademica> listaFormacaoAcademicas = new ArrayList<FormacaoAcademica>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				FormacaoAcademica fa = new FormacaoAcademica();
				fa.setIdFormacaoAcademica(rs.getInt(1));
				fa.setIdRegistroGeral(rs.getInt(2));
				fa.setNomeInstituicao(rs.getString(3));
				fa.setAtividadeExtraCurricular(rs.getString(4));
				
				// Transformando o LocalDate em String para mandar para o Banco de Dados
				String aux = rs.getString(5);
				String data = aux.substring(0, 4) + "-";
				data += aux.substring(5, 7) + "-";
				data += aux.substring(8, 10);
				LocalDate dataInicio = LocalDate.parse(data);
				
				fa.setDataInicio(dataInicio);
				
				// Transformando o LocalDate em String para mandar para o Banco de Dados
				aux = rs.getString(6);
				data = aux.substring(0, 4) + "-";
				data += aux.substring(5, 7) + "-";
				data += aux.substring(8, 10);
				LocalDate dataFim = LocalDate.parse(data);
				
				fa.setDataTermino(dataFim);
				fa.setNomeCurso(rs.getString(7));
				fa.setStatusCurso(rs.getString(8));
				fa.setEscolaridade(rs.getString(9));
				fa.setNivelCurso(rs.getString(10));
				fa.setSemestre(rs.getString(11));
				listaFormacaoAcademicas.add(fa);
				return listaFormacaoAcademicas;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public ArrayList<FormacaoAcademica> listarTodos() {
		String sql = "SELECT ID_FORMACAO_ACADEMICA, ID_REGISTRO_GERAL, NM_INSTITUICAO, DS_ATV_EXTRA_CURRICULARES, TO_CHAR(DT_INICIO, 'YYYY/MM/DD'), "
				+ "TO_CHAR(DT_TERMINO, 'YYYY/MM/DD'), NM_CURSO, DS_STATUS_CURSO, DS_ESCOLARIDADE, DS_SEMESTRE, FL_CURSO "
				+ "FROM T_CHALL_FORMACAO_ACADEMICA ORDER BY ID_FORMACAO_ACADEMICA";
		ArrayList<FormacaoAcademica> listaFormacaoAcademicas = new ArrayList<FormacaoAcademica>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					FormacaoAcademica fa = new FormacaoAcademica();
					fa.setIdFormacaoAcademica(rs.getInt(1));
					fa.setIdRegistroGeral(rs.getInt(2));
					fa.setNomeInstituicao(rs.getString(3));
					fa.setAtividadeExtraCurricular(rs.getString(4));
					
					String aux = rs.getString(5);
					String data = aux.substring(0, 4) + "-";
					data += aux.substring(5, 7) + "-";
					data += aux.substring(8, 10);
					LocalDate dataInicio = LocalDate.parse(data);
					
					fa.setDataInicio(dataInicio);
					
					// Transformando o LocalDate em String para mandar para o Banco de Dados
					aux = rs.getString(6);
					data = aux.substring(0, 4) + "-";
					data += aux.substring(5, 7) + "-";
					data += aux.substring(8, 10);
					LocalDate dataFim = LocalDate.parse(data);
					
					fa.setDataTermino(dataFim);
					fa.setNomeCurso(rs.getString(7));
					fa.setStatusCurso(rs.getString(8));
					fa.setEscolaridade(rs.getString(9));
					fa.setNivelCurso(rs.getString(10));
					fa.setSemestre(rs.getString(11));
					listaFormacaoAcademicas.add(fa);
				}
				return listaFormacaoAcademicas;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}

}
