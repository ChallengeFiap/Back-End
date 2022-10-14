package fiap.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**Classe para a CRUD dos objetos do tipo LinguagemCandidato no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 19/09/2022
 */

public class LinguagemCandidatoDAO implements IDAO {
	
	private Connection con;
	private LinguagemCandidato linguagemCandidato;
	
	public LinguagemCandidatoDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		linguagemCandidato = (LinguagemCandidato) obj;
		String sql = "INSERT INTO T_CHALL_LINGUAGEM_CANDIDATO (ID_LINGUAGEM_CANDIDATO, ID_LINGUAGEM_PROG, ID_REGISTRO_GERAL, DT_INICIO, "
				+ "FL_PROFICIENCIA) VALUES (?, ?, ?, ?, ?)";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = linguagemCandidato.getDataInicio().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, linguagemCandidato.getIdLinguagemCandidato());
			ps.setInt(2, linguagemCandidato.getIdLinguagem());
			ps.setInt(3, linguagemCandidato.getIdRegistroGeral());
			ps.setString(4, dataInicio);
			ps.setString(5, linguagemCandidato.getProficiencia());
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
		linguagemCandidato = (LinguagemCandidato) obj;
		String sql = "UPDATE T_CHALL_LINGUAGEM_CANDIDATO SET ID_LINGUAGEM_PROG = ?, ID_REGISTRO_GERAL = ?,  DT_INICIO = ?, FL_PROFICIENCIA = ? "
				+ "WHERE ID_LINGUAGEM_CANDIDATO = ?";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = linguagemCandidato.getDataInicio().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, linguagemCandidato.getIdLinguagem());
			ps.setInt(2, linguagemCandidato.getIdRegistroGeral());
			ps.setString(3, dataInicio);
			ps.setString(4, linguagemCandidato.getProficiencia());
			ps.setInt(5, linguagemCandidato.getIdLinguagemCandidato());
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
		linguagemCandidato = (LinguagemCandidato) obj;
		String sql = "DELETE FROM T_CHALL_LINGUAGEM_CANDIDATO WHERE ID_LINGUAGEM_CANDIDATO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, linguagemCandidato.getIdLinguagemCandidato());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso!";
			} else {
				return "Erro ao excluir!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<LinguagemCandidato> listarUm(int id) {
		String sql = "SELECT * FROM T_CHALL_LINGUAGEM_CANDIDATO WHERE ID_LINGUAGEM_CANDIDATO = ?";
		ArrayList<LinguagemCandidato> listaLinguagemCandidatos = new ArrayList<LinguagemCandidato>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				LinguagemCandidato lc = new LinguagemCandidato();
				lc.setIdLinguagemCandidato(rs.getInt(1));
				lc.setIdLinguagem(rs.getInt(2));
				lc.setIdRegistroGeral(rs.getInt(3));
				
				// Transformando a String de Data do Banco em LocalDate
				String aux = rs.getString(4);
				LocalDate dataInicio = LocalDate.parse(aux);

				lc.setDataInicio(dataInicio);
				lc.setProficiencia(rs.getString(5));
				listaLinguagemCandidatos.add(lc);
				return listaLinguagemCandidatos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public ArrayList<LinguagemCandidato> listarTodos() {
		String sql = "SELECT * FROM T_CHALL_LINGUAGEM_CANDIDATO";
		ArrayList<LinguagemCandidato> listaLinguagemCandidatos = new ArrayList<LinguagemCandidato>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					LinguagemCandidato lc = new LinguagemCandidato();
					lc.setIdLinguagemCandidato(rs.getInt(1));
					lc.setIdLinguagem(rs.getInt(2));
					lc.setIdRegistroGeral(rs.getInt(3));
					
					// Transformando a String de Data do Banco em LocalDate
					String aux = rs.getString(4);
					LocalDate dataInicio = LocalDate.parse(aux);

					lc.setDataInicio(dataInicio);
					lc.setProficiencia(rs.getString(5));
					listaLinguagemCandidatos.add(lc);
				}
				return listaLinguagemCandidatos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}

}
