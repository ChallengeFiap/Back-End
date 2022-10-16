package fiap.model;
/**Classe para a CRUD dos objetos do tipo Idioma Candidato no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 23/09/2022
 */

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class IdiomaCandidatoDAO implements IDAO{
	
	private Connection con;
	private IdiomaCandidato idiomaCandidato;
	
	public IdiomaCandidatoDAO(Connection con) {
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
		String sql = "INSERT INTO T_CHALL_IDIOMA_CANDIDATO (ID_IDIOMA_CANDIDATO, ID_REGISTRO_GERAL, ID_IDIOMAS, DT_INICIO, FL_PROFICIENCIA) "
				+ "VALUES (?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?)";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = idiomaCandidato.getDataInicio().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, idiomaCandidato.getIdIdiomaCandidato());
			ps.setInt(2, idiomaCandidato.getIdRegistroGeral());
			ps.setInt(3, idiomaCandidato.getIdIdiomas());
			ps.setString(4, dataInicio);
			ps.setString(5, idiomaCandidato.getProficiencia());
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
		String sql = "UPDATE T_CHALL_IDIOMA_CANDIDATO SET ID_REGISTRO_GERAL = ?, ID_IDIOMAS = ?, DT_INICIO = TO_DATE(?, 'DD/MM/YYYY'), FL_PROFICIENCIA = ? "
				+ "WHERE ID_IDIOMA_CANDIDATO = ?";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = idiomaCandidato.getDataInicio().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, idiomaCandidato.getIdRegistroGeral());
			ps.setInt(2, idiomaCandidato.getIdIdiomas());
			ps.setString(3, dataInicio);
			ps.setString(4, idiomaCandidato.getProficiencia());
			ps.setInt(5, idiomaCandidato.getIdIdiomaCandidato());
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
		String sql = "DELETE FROM T_CHALL_IDIOMA_CANDIDATO WHERE ID_IDIOMA_CANDIDATO = ?";
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
	
	public ArrayList<IdiomaCandidato> listarUm(int id) {
		String sql = "SELECT ID_IDIOMA_CANDIDATO, ID_REGISTRO_GERAL, ID_IDIOMAS, TO_CHAR(DT_INICIO, 'YYYY/MM/DD'), "
				+ "FL_PROFICIENCIA FROM T_CHALL_IDIOMA_CANDIDATO WHERE ID_IDIOMA_CANDIDATO = ?";
		ArrayList<IdiomaCandidato> listaIdiomaCandidatos = new ArrayList<IdiomaCandidato>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				IdiomaCandidato ic = new IdiomaCandidato();
				ic.setIdIdiomaCandidato(rs.getInt(1));
				ic.setIdRegistroGeral(rs.getInt(2));
				ic.setIdIdiomas(rs.getInt(3));
				
				// Transformando o LocalDate em String para mandar para o Banco de Dados
				String aux = rs.getString(4);
				String data = aux.substring(0, 4) + "-";
				data += aux.substring(5, 7) + "-";
				data += aux.substring(8, 10);
				LocalDate dataInicio = LocalDate.parse(data);

				ic.setDataInicio(dataInicio);
				ic.setProficiencia(rs.getString(5));
				listaIdiomaCandidatos.add(ic);
				return listaIdiomaCandidatos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public ArrayList<IdiomaCandidato> listarTodos() {
		String sql = "SELECT ID_IDIOMA_CANDIDATO, ID_REGISTRO_GERAL, ID_IDIOMAS, TO_CHAR(DT_INICIO, 'YYYY/MM/DD'), FL_PROFICIENCIA FROM T_CHALL_IDIOMA_CANDIDATO "
				+ "ORDER BY ID_IDIOMA_CANDIDATO";
		ArrayList<IdiomaCandidato> listaIdiomaCandidatos = new ArrayList<IdiomaCandidato>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					IdiomaCandidato ic = new IdiomaCandidato();
					ic.setIdIdiomaCandidato(rs.getInt(1));
					ic.setIdRegistroGeral(rs.getInt(2));
					ic.setIdIdiomas(rs.getInt(3));
					
					// Transformando o LocalDate em String para mandar para o Banco de Dados
					String aux = rs.getString(4);
					String data = aux.substring(0, 4) + "-";
					data += aux.substring(5, 7) + "-";
					data += aux.substring(8, 10);
					LocalDate dataInicio = LocalDate.parse(data);

					ic.setDataInicio(dataInicio);
					ic.setProficiencia(rs.getString(5));
					listaIdiomaCandidatos.add(ic);
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
