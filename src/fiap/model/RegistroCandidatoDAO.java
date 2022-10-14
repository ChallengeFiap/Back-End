package fiap.model;

/**Classe para a CRUD dos objetos do tipo Registro Candiadto no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.1
 * @since 07/09/2022
 */

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RegistroCandidatoDAO implements IDAOR{

	private Connection con;
	private RegistroCandidato registroCandidato;

	public RegistroCandidatoDAO(Connection con)  {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserirRegistro(Object obj) {
		registroCandidato = (RegistroCandidato) obj;
		String sql = "INSERT INTO T_CHALL_REGISTRO_GERAL (ID_REGISTRO_GERAL, NM_NOME_COMPLETO, DS_EMAIL, DS_SENHA, TP_USUARIO, NR_CPF) "
				+ "VALUES (?, ?, ?, ?, 'C', ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, registroCandidato.getIdRegistroGeral());
			ps.setString(2, registroCandidato.getNomeCompleto());
			ps.setString(3, registroCandidato.getEmail());
			ps.setString(4, registroCandidato.getSenha());
			ps.setString(5, registroCandidato.getNumeroCPF());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String inserirUsuario(Object obj) {
		registroCandidato = (RegistroCandidato) obj;
		String sql = "INSERT INTO T_CHALL_REGISTRO_CANDIDATO (ID_REGISTRO_GERAL, NR_RG, DT_NASCIMENTO, FL_SEXO_BIOLOGICO, TP_ESCOLARIDADE,"
				+ "DS_ESTADO_CIVIL, DS_CARGO) VALUES (?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?)";
		try {
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataNascimento = registroCandidato.getDataNascimento().format(formatter);

			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, registroCandidato.getIdRegistroGeral());
			ps.setString(2, registroCandidato.getNumeroRG());
			ps.setString(3, dataNascimento);
			ps.setString(4, registroCandidato.getSexo());
			ps.setString(5, registroCandidato.getEscolaridade());
			ps.setString(6, registroCandidato.getEstadoCivil());
			ps.setString(7, registroCandidato.getCargo());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterarRegistro(Object obj) {
		registroCandidato = (RegistroCandidato) obj;
		String sql = "UPDATE T_CHALL_REGISTRO_GERAL SET NM_NOME_COMPLETO = ?, DS_EMAIL = ?, DS_SENHA = ?, NR_CPF = ? "
				+ "WHERE ID_REGISTRO_GERAL = ? AND TP_USUARIO = 'C' ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, registroCandidato.getNomeCompleto());
			ps.setString(2, registroCandidato.getEmail());
			ps.setString(3, registroCandidato.getSenha());
			ps.setString(4, registroCandidato.getNumeroCPF());
			ps.setInt(5, registroCandidato.getIdRegistroGeral());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso!";
			} else {
				return "Erro ao alterar!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterarUsuario(Object obj) {
		registroCandidato = (RegistroCandidato) obj;
		String sql = "UPDATE T_CHALL_REGISTRO_CANDIDATO SET NR_RG = ?, DT_NASCIMENTO = ?, FL_SEXO_BIOLOGICO = ?, TP_ESCOLARIDADE = ?, "
				+ "DS_ESTADO_CIVIL = ?, DS_CARGO = ? WHERE ID_REGISTRO_GERAL = ? ";
		try {
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataNascimento = registroCandidato.getDataNascimento().format(formatter);

			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, registroCandidato.getNumeroRG());
			ps.setString(2, dataNascimento);
			ps.setString(3, registroCandidato.getSexo());
			ps.setString(4, registroCandidato.getEscolaridade());
			ps.setString(5, registroCandidato.getEstadoCivil());
			ps.setString(6, registroCandidato.getCargo());
			ps.setInt(7, registroCandidato.getIdRegistroGeral());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso!";
			} else {
				return "Erro ao alterar!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluirRegistro(Object obj) {
		registroCandidato = (RegistroCandidato) obj;
		String sql = "DELETE FROM T_CHALL_REGISTRO_GERAL WHERE ID_REGISTRO_GERAL = ?";
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

	public String excluirUsuario(Object obj) {
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

	public ArrayList<RegistroCandidato> listarUm(int id) {
		String sql = "SELECT RC.ID_REGISTRO_GERAL, RG.TP_USUARIO, RG.NM_NOME_COMPLETO, RG.DS_EMAIL, RG.DS_SENHA, RG.NR_CPF, "
				+ "RC.NR_RG, TO_CHAR(RC.DT_NASCIMENTO, 'YYYY/MM/DD'), RC.FL_SEXO_BIOLOGICO, RC.TP_ESCOLARIDADE, RC.DS_ESTADO_CIVIL, RC.DS_CARGO "
				+ "FROM T_CHALL_REGISTRO_GERAL RG INNER JOIN T_CHALL_REGISTRO_CANDIDATO RC "
				+ "ON(RG.ID_REGISTRO_GERAL = RC.ID_REGISTRO_GERAL) WHERE RC.ID_REGISTRO_GERAL = ? ";
		ArrayList<RegistroCandidato> listaCandidatos = new ArrayList<RegistroCandidato>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				RegistroCandidato rc = new RegistroCandidato();
				rc.setIdRegistroGeral(rs.getInt(1));
				rc.setTipoUsuario(rs.getString(2));
				rc.setNomeCompleto(rs.getString(3));
				rc.setEmail(rs.getString(4));
				rc.setSenha(rs.getString(5));
				rc.setNumeroCPF(rs.getString(6));
				rc.setNumeroRG(rs.getString(7));

				// Transformando o LocalDate em String para mandar para o Banco de Dados
				String aux = rs.getString(8);
				String data = aux.substring(0, 4) + "-";
				data += aux.substring(5, 7) + "-";
				data += aux.substring(8, 10);
				LocalDate dataNascimento = LocalDate.parse(data);

				rc.setDataNascimento(dataNascimento);
				rc.setSexo(rs.getString(9));
				rc.setEscolaridade(rs.getString(10));
				rc.setEstadoCivil(rs.getString(11));
				rc.setCargo(rs.getString(12));
				listaCandidatos.add(rc);

				return listaCandidatos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public ArrayList<RegistroCandidato> listarTodos() {
		String sql = "SELECT RC.ID_REGISTRO_GERAL, RG.TP_USUARIO, RG.NM_NOME_COMPLETO, RG.DS_EMAIL, RG.DS_SENHA, RG.NR_CPF, "
				+ "RC.NR_RG, TO_CHAR(RC.DT_NASCIMENTO, 'YYYY/MM/DD'), RC.FL_SEXO_BIOLOGICO, RC.TP_ESCOLARIDADE, RC.DS_ESTADO_CIVIL, RC.DS_CARGO "
				+ "FROM T_CHALL_REGISTRO_GERAL RG INNER JOIN T_CHALL_REGISTRO_CANDIDATO RC "
				+ "ON(RG.ID_REGISTRO_GERAL = RC.ID_REGISTRO_GERAL)";
		ArrayList<RegistroCandidato> listaCandidatos = new ArrayList<RegistroCandidato>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					RegistroCandidato rc = new RegistroCandidato();
					rc.setIdRegistroGeral(rs.getInt(1));
					rc.setTipoUsuario(rs.getString(2));
					rc.setNomeCompleto(rs.getString(3));
					rc.setEmail(rs.getString(4));
					rc.setSenha(rs.getString(5));
					rc.setNumeroCPF(rs.getString(6));
					rc.setNumeroRG(rs.getString(7));

					// Transformando o LocalDate em String para mandar para o Banco de Dados
					String aux = rs.getString(8);
					String data = aux.substring(0, 4) + "-";
					data += aux.substring(5, 7) + "-";
					data += aux.substring(8, 10);
					LocalDate dataNascimento = LocalDate.parse(data);

					rc.setDataNascimento(dataNascimento);
					rc.setSexo(rs.getString(9));
					rc.setEscolaridade(rs.getString(10));
					rc.setEstadoCivil(rs.getString(11));
					rc.setCargo(rs.getString(12));
					listaCandidatos.add(rc);
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
