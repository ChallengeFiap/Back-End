package fiap.model;

/**Classe para a CRUD dos objetos do tipo Registro Candiadto no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;
import java.time.format.DateTimeFormatter;

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
		String sql = "INSERT INTO T_CHALL_REGISTRO_CANDIDATO (ID_REGISTRO_GERAL, NM_NOME_COMPLETO, DS_EMAIL, DS_SENHA, TP_USUARIO, NR_CPF,"
				+ "NR_RG, DT_NASCIMENTO, FL_SEXO_BIOLOGICO, DS_ESCOLARIDADE, DS_ESTADO_CIVIL, DS_ORIGEM) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataNascimento = registroCandidato.getDataNascimento().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, registroCandidato.getIdRegistroGeral());
			ps.setString(2, registroCandidato.getNomeCompleto());
			ps.setString(3, registroCandidato.getEmail());
			ps.setString(4, registroCandidato.getSenha());
			ps.setString(5, registroCandidato.getTipoUsuario());
			ps.setInt(6, registroCandidato.getNumeroCPF());
			ps.setInt(7, registroCandidato.getNumeroRG());
			ps.setString(8, dataNascimento);
			ps.setString(9, registroCandidato.getSexo());
			ps.setString(10, registroCandidato.getEscolaridade());
			ps.setString(11, registroCandidato.getEstadoCivil());
			ps.setString(12, registroCandidato.getOrigem());
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
		String sql = "UPDATE T_CHALL_REGISTRO_CANDIDATO SET NM_NOME_COMPLETO = ?, DS_EMAIL = ?, DS_SENHA = ?, TP_USUARIO = ?, NR_CPF = ?, "
				+ "NR_RG = ?, DT_NASCIMENTO = ?, FL_SEXO_BIOLOGICO = ?, DS_ESCOLARIDADE = ?, DS_ESTADO_CIVIL = ?, DS_ORIGEM = ? "
				+ "WHERE ID_REGISTRO_GERAL = ?";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataNascimento = registroCandidato.getDataNascimento().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, registroCandidato.getNomeCompleto());
			ps.setString(2, registroCandidato.getEmail());
			ps.setString(3, registroCandidato.getSenha());
			ps.setString(4, registroCandidato.getTipoUsuario());
			ps.setInt(5, registroCandidato.getNumeroCPF());
			ps.setInt(6, registroCandidato.getNumeroRG());
			ps.setString(7, dataNascimento);
			ps.setString(8, registroCandidato.getSexo());
			ps.setString(9, registroCandidato.getEscolaridade());
			ps.setString(10, registroCandidato.getEstadoCivil());
			ps.setString(11, registroCandidato.getOrigem());
			ps.setInt(12, registroCandidato.getIdRegistroGeral());
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
					listaCandidatos += "Email: " + rs.getString(3) + "\n";
					//PULANDO O INDICE 4 PQ É A SENHA DO USUARIO
					listaCandidatos += "Tipo Usuario: " + rs.getString(5) + "\n";
					listaCandidatos += "CPF: " + rs.getInt(6) + "\n";
					listaCandidatos += "RG: " + rs.getInt(7) + "\n";
					listaCandidatos += "Data de Nascimento : " + rs.getString(8) + "\n";
					listaCandidatos += "Sexo : " + rs.getString(9) + "\n";
					listaCandidatos += "Escolaridade : " + rs.getString(10) + "\n";
					listaCandidatos += "Estado Civil : " + rs.getString(11) + "\n";
					listaCandidatos += "Origem : " + rs.getString(12) + "\n";
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
