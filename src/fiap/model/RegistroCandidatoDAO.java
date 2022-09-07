package fiap.model;

/**Classe para a CRUD dos objetos do tipo Registro Candiadto no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;

public class RegistroCandidatoDAO implements IDAO {

	private Connection con;
	private RegistroCandidato registroCandidato;

	public RegistroCandidatoDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		registroCandidato = (RegistroCandidato) obj;
		String sql = "INSERT INTO T_CHALL_REGISTRO_CANDIDATO (ID_REGISTRO_GERAL, NM_NOME_COMPLETO, DS_SENHA, NR_CPF, NR_RG, DT_NASCIMENTO, "
				+ "FL_SEXO_BIOLOGICO, DS_ESCOLARIDADE, DS_ESTADO_CIVIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, registroCandidato.getIdRegistroGeral());
			ps.setString(2, registroCandidato.getNomeCompleto());
			ps.setString(3, registroCandidato.getSenha());
			ps.setInt(4, registroCandidato.getNumeroCPF());
			ps.setInt(5, registroCandidato.getNumeroRG());
			ps.setDate(6, null);
			ps.setString(7, registroCandidato.getSexo());
			ps.setString(8, registroCandidato.getEscolaridade());
			ps.setString(9, registroCandidato.getEstadoCivil());
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
		registroCandidato = (RegistroCandidato) obj;
		String sql = "UPDATE T_CHALL_REGISTRO_CANDIDATO SET NM_NOME_COMPLETO = ?, DS_SENHA = ?, NR_CPF = ?, NR_RG = ?, DT_NASCIMENTO = ?, "
				+ "FL_SEXO_BIOLOGICO = ?, DS_ESCOLARIDADE = ?, DS_ESTADO_CIVIL = ? WHERE ID_REGISTRO_GERAL = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, registroCandidato.getNomeCompleto());
			ps.setString(2, registroCandidato.getSenha());
			ps.setInt(3, registroCandidato.getNumeroCPF());
			ps.setInt(4, registroCandidato.getNumeroRG());
			ps.setDate(5, null);
			ps.setString(6, registroCandidato.getSexo());
			ps.setString(7, registroCandidato.getEscolaridade());
			ps.setString(8, registroCandidato.getEstadoCivil());
			ps.setInt(9, registroCandidato.getIdRegistroGeral());
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
		registroCandidato = (RegistroCandidato) obj;
		String sql = "DELETE FROM T_CHALL_REGISTRO_CANDIDATO WHERE ID_REGISTRO_GERAL = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, registroCandidato.getIdRegistroGeral());
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
		String sql = "SELECT * FROM T_CHALL_REGISTRO_CANDIDATO";
		String listaCandidatos = "Lista dos Candidato\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaCandidatos += "ID Candidato: " + rs.getInt(1) + "\n";
					listaCandidatos += "Nome Completo: " + rs.getString(2) + "\n";
					//PULANDO O INDICE 3 PQ É A SENHA DO USUARIO
					listaCandidatos += "CPF: " + rs.getInt(4) + "\n";
					listaCandidatos += "RG: " + rs.getInt(5) + "\n";
					listaCandidatos += "Data de Nascimento : " + rs.getDate(6) + "\n";
					listaCandidatos += "Sexo : " + rs.getString(7) + "\n";
					listaCandidatos += "Escolaridade : " + rs.getString(8) + "\n";
					listaCandidatos += "Estado Civil : " + rs.getString(9) + "\n";
				}
				return listaCandidatos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	
	
}
