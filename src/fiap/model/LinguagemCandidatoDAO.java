package fiap.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

/**Classe para a CRUD dos objetos do tipo LinguagemCandidato no Banco de Dados utilizando a classe Conexao
 * @author Lu�s Felipe
 * @version 1.0
 * @since 19/09/2022
 */

public class LinguagemCandidatoDAO implements IDAO {
	
	private Connection con;
	private LinguagemCandidato linguagemCandidato;
	
	public LinguagemCandidatoDAO() {
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
		String sql = "INSERT INTO T_CHALL_LINGUAGEM_CANDIDATO (ID_LINGUAGEM_CANDIDATO, ID_LINGUAGEM, ID_REGISTRO_GERAL, DT_INICIO) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = linguagemCandidato.getDataInicio().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, linguagemCandidato.getIdLinguagemCandidato());
			ps.setInt(2, linguagemCandidato.getIdLinguagem());
			ps.setInt(3, linguagemCandidato.getIdRegistroGeral());
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
		linguagemCandidato = (LinguagemCandidato) obj;
		String sql = "UPDATE T_CHALL_LINGUAGEM_CANDIDATO SET ID_LINGUAGEM = ?, ID_REGISTRO_GERAL = ?,  DT_INICIO = ? "
				+ "WHERE ID_LINGUAGEM_CANDIDATO = ?";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = linguagemCandidato.getDataInicio().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, linguagemCandidato.getIdLinguagem());
			ps.setInt(2, linguagemCandidato.getIdRegistroGeral());
			ps.setString(3, dataInicio);
			ps.setInt(1, linguagemCandidato.getIdLinguagemCandidato());
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
	
	public String listarTodos() {
		String sql = "SELECT * FROM T_CHALL_LINGUAGEM_CANDIDATO";
		String listaLinguagemCandidatos = "Lista das Linguagens de Programa��o dos Candidatos\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaLinguagemCandidatos += "ID Linguagem Candidato: " + rs.getInt(1) + "\n";
					listaLinguagemCandidatos += "ID Linguagem: +" + rs.getInt(2) +"\n";
					listaLinguagemCandidatos += "ID Registro: +" + rs.getInt(3) +"\n";
					listaLinguagemCandidatos += "Data Inicio: " + rs.getString(4) + "\n";
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
