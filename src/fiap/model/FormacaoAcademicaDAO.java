package fiap.model;

/**Classe para a CRUD dos objetos do tipo Formação Academica no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class FormacaoAcademicaDAO implements IDAO{

	private Connection con;
	private FormacaoAcademica formacaoAcademica;
	
	public FormacaoAcademicaDAO() {
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
				+ "DS_ATIVIDADE_EXTRA_CURRICULARES, DT_INICIO, DT_TERMINO, NM_CURSO, DS_STATUS_CURSO, DS_ESCOLARIDADE, FL_CURSO) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			ps.setString(8, formacaoAcademica.getStatusCurso());
			ps.setString(9, formacaoAcademica.getEscolaridade());
			ps.setString(10, formacaoAcademica.getFiltroCurso());
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
		String sql = "UPDATE T_CHALL_FORMACAO_ACADEMICA SET ID_REGISTRO_GERAL = ?, NM_INSTITUICAO = ?, DS_ATIVIDADE_EXTRA_CURRICULARES = ?, "
				+ "DT_INICIO = ?, DT_TERMINO = ?, NM_CURSO = ?, DS_STATUS_CURSO = ?, DS_ESCOLARIDADE = ?, FL_CURSO = ? WHERE "
				+ "ID_FORMACAO_ACADEMICA = ?";
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
			ps.setString(9, formacaoAcademica.getFiltroCurso());
			ps.setInt(10, formacaoAcademica.getIdFormacaoAcademica());
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
	
	public String listarTodos() {
		String sql = "SELECT * FROM T_CHALL_FORMACAO_ACADEMICA";
		String listaFormacaoAcademica = "Lista das Formações Academicas\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaFormacaoAcademica += "ID Formação Academica: " + rs.getInt(1) + "\n";
					listaFormacaoAcademica += "ID Registro Geral: " + rs.getInt(2) + "\n";
					listaFormacaoAcademica += "Nome Instituicao: +" + rs.getString(3) + "\n";
					listaFormacaoAcademica += "Atividade Extra Curricular: +" + rs.getString(4) + "\n";
					listaFormacaoAcademica += "Data Inicio: +" + rs.getString(5) + "\n";
					listaFormacaoAcademica += "Data Termino: +" + rs.getString(6) + "\n";
					listaFormacaoAcademica += "Nome Curso: +" + rs.getString(7) + "\n";
					listaFormacaoAcademica += "Status Curso: +" + rs.getString(8) + "\n";
					listaFormacaoAcademica += "Escolaridade: +" + rs.getString(9) + "\n";
					listaFormacaoAcademica += "Filtro Curso: +" + rs.getString(10) + "\n";
				}
				return listaFormacaoAcademica;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
