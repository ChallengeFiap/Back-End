package fiap.model;

/**Classe para a CRUD dos objetos do tipo Candidato Habilidade no Banco de Dados utilizando a classe Conexao
 * @author Lu�s Felipe
 * @version 1.0
 * @since 07/09/2022
 */
import java.sql.*;
import java.time.format.DateTimeFormatter;

public class CandidatoHabilidadeDAO implements IDAO {

	private Connection con;
	private CandidatoHabilidade candidatoHabilidade;
	
	public CandidatoHabilidadeDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		candidatoHabilidade = (CandidatoHabilidade) obj;
		String sql = "INSERT INTO T_CHALL_CANDIDATO_HABILIDADE (ID_CAND_HABILIDADE, ID_HABILIDADE, ID_REGISTRO_GERAL, DT_INICIO, DT_TERMINO) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = candidatoHabilidade.getDataInicio().format(formatter);
			String dataTermino = candidatoHabilidade.getDataTermino().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, candidatoHabilidade.getIdCandidatoHabilidade());
			ps.setInt(2, candidatoHabilidade.getIdHabilidade());
			ps.setInt(3, candidatoHabilidade.getIdRegistroGeral());
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
		candidatoHabilidade = (CandidatoHabilidade) obj;
		String sql = "UPDATE T_CHALL_CANDIDATO_HABILIDADE SET ID_HABILIDADE = ?, ID_REGISTRO_GERAL = ?, DT_INICIO = ?, DT_TERMINO = ? "
				+ "WHERE ID_CAND_HABILIDADE = ?";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = candidatoHabilidade.getDataInicio().format(formatter);
			String dataTermino = candidatoHabilidade.getDataTermino().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, candidatoHabilidade.getIdHabilidade());
			ps.setInt(2, candidatoHabilidade.getIdRegistroGeral());
			ps.setString(3, dataInicio);
			ps.setString(4, dataTermino);
			ps.setInt(5, candidatoHabilidade.getIdCandidatoHabilidade());
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
		candidatoHabilidade = (CandidatoHabilidade) obj;
		String sql = "DELETE FROM T_CHALL_CANDIDATO_HABILIDADE WHERE ID_CAND_HABILIDADE = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, candidatoHabilidade.getIdCandidatoHabilidade());
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
		String sql = "SELECT * FROM T_CHALL_CANDIDATO_HABILIDADE";
		String listaCandidatoHabilidade = "Lista das Candidato Habilidade\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaCandidatoHabilidade += "ID Candidato Habilidade: " + rs.getInt(1) + "\n";
					listaCandidatoHabilidade += "ID Habilidade: " + rs.getInt(2) + "\n";
					listaCandidatoHabilidade += "ID Registro Geral: +" + rs.getInt(3) + "\n";
					listaCandidatoHabilidade += "Data Inicio: +" + rs.getString(4) + "\n";
					listaCandidatoHabilidade += "Data Termino: +" + rs.getString(5) + "\n";
				}
				return listaCandidatoHabilidade;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
