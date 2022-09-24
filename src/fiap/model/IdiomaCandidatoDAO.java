package fiap.model;
/**Classe para a CRUD dos objetos do tipo Idioma Candidato no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 23/09/2022
 */

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class IdiomaCandidatoDAO implements IDAO{
	
	private Connection con;
	private IdiomaCandidato idiomaCandidato;
	
	public IdiomaCandidatoDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		idiomaCandidato = (IdiomaCandidato) obj;
		String sql = "INSERT INTO T_CHALL_IDIOMA_CANDIDATO (ID_IDOMA_CANDIDATO, ID_REGISTRO_GERAL, ID_IDIOMAS, DT_INICIO) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = idiomaCandidato.getDataInicio().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, idiomaCandidato.getIdIdiomaCandidato());
			ps.setInt(2, idiomaCandidato.getIdRegistroGeral());
			ps.setInt(3, idiomaCandidato.getIdIdiomas());
			ps.setString(4, dataInicio);
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
		idiomaCandidato = (IdiomaCandidato) obj;
		String sql = "UPDATE T_CHALL_IDIOMA_CANDIDATO SET ID_REGISTRO_GERAL = ?, ID_IDIOMAS = ?, DT_INICIO = ? WHERE ID_IDOMA_CANDIDATO = ?";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = idiomaCandidato.getDataInicio().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, idiomaCandidato.getIdRegistroGeral());
			ps.setInt(2, idiomaCandidato.getIdIdiomas());
			ps.setString(3, dataInicio);
			ps.setInt(4, idiomaCandidato.getIdIdiomaCandidato());
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
		idiomaCandidato = (IdiomaCandidato) obj;
		String sql = "DELETE FROM T_CHALL_IDIOMA_CANDIDATO WHERE ID_IDOMA_CANDIDATO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, idiomaCandidato.getIdIdiomaCandidato());
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
		String sql = "SELECT * FROM ID_IDOMA_CANDIDATO";
		String listaIdiomaCandidatos = "Lista dos Idioma Candidatos\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaIdiomaCandidatos += "ID Idioma Candidato: " + rs.getInt(1) + "\n";
					listaIdiomaCandidatos += "ID Registro Geral: " + rs.getInt(2) + "\n";
					listaIdiomaCandidatos += "ID Idioma: " + rs.getInt(3) + "\n";
					listaIdiomaCandidatos += "Data Inicio: " + rs.getString(4) + "\n";
				}
				return listaIdiomaCandidatos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
