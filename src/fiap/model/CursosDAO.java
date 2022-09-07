package fiap.model;

/**Classe para a CRUD dos objetos do tipo Cursos no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;

public class CursosDAO implements IDAO{

	private Connection con;
	private Cursos cursos;

	public CursosDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		cursos = (Cursos) obj;
		String sql = "INSERT INTO T_CHALL_CURSOS (ID_CURSO, NR_CURSO, SG_CURSO, NM_CURSO) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, cursos.getIdCurso());
			ps.setInt(2, cursos.getNumeroCurso());
			ps.setNString(3, cursos.getSiglaCurso());
			ps.setString(4, cursos.getNomeCurso());
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
		cursos = (Cursos) obj;
		String sql = "UPDATE T_CHALL_CURSOS SET NR_CURSO = ?, SG_CURSO = ?, NM_CURSO = ? WHERE ID_CURSO = ?";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, cursos.getNumeroCurso());
			ps.setNString(2, cursos.getSiglaCurso());
			ps.setString(3, cursos.getNomeCurso());
			ps.setInt(4, cursos.getIdCurso());
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
		cursos = (Cursos) obj;
		String sql = "DELETE FROM T_CHALL_CURSOS WHERE ID_CURSO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cursos.getIdCurso());
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
		String sql = "SELECT * FROM T_CHALL_CURSOS";
		String listaCursos = "Lista dos Cursos\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaCursos += "ID Curso: " + rs.getInt(1) + "\n";
					listaCursos += "Numero Curso: " + rs.getInt(2) + "\n";
					listaCursos += "Sigla Curso: " + rs.getString(3) + "\n";
					listaCursos += "Nome Curso: " + rs.getString(4) + "\n";
				}
				return listaCursos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
