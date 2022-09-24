package fiap.model;
/**Classe para a CRUD dos objetos do tipo Registro Recrutador no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;

public class RegistroRecrutadorDAO implements IDAO {

	private Connection con;
	private RegistroRecrutador registroRecrutador;
	
	
	public RegistroRecrutadorDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		registroRecrutador = (RegistroRecrutador) obj;
		String sql = "INSERT INTO T_CHALL_REGISTRO_RECRUTADOR (ID_REGISTRO_GERAL, NM_NOME_COMPLETO, DS_EMAIL, DS_SENHA, TP_USUARIO, NR_CPF,"
				+ "NM_EMPRESA, DS_CARGO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, registroRecrutador.getIdRegistroGeral());
			ps.setString(2, registroRecrutador.getNomeCompleto());
			ps.setString(3, registroRecrutador.getEmail());
			ps.setString(4, registroRecrutador.getSenha());
			ps.setString(5, registroRecrutador.getTipoUsuario());
			ps.setInt(6, registroRecrutador.getNumeroCPF());
			ps.setString(7, registroRecrutador.getNomeEmpresa());
			ps.setString(8, registroRecrutador.getCargoRecrutador());
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
		registroRecrutador = (RegistroRecrutador) obj;
		String sql = "UPDATE T_CHALL_REGISTRO_RECRUTADOR SET NM_NOME_COMPLETO = ?, DS_EMAIL = ?, DS_SENHA = ?, TP_USUARIO, NR_CPF = ?,"
				+ "NM_EMPRESA = ?,DS_CARGO = ? WHERE ID_REGISTRO_GERAL = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, registroRecrutador.getNomeCompleto());
			ps.setString(2, registroRecrutador.getEmail());
			ps.setString(3, registroRecrutador.getSenha());
			ps.setString(4, registroRecrutador.getTipoUsuario());
			ps.setInt(5, registroRecrutador.getNumeroCPF());
			ps.setString(6, registroRecrutador.getNomeEmpresa());
			ps.setString(7, registroRecrutador.getCargoRecrutador());
			ps.setInt(8, registroRecrutador.getIdRegistroGeral());
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
		registroRecrutador = (RegistroRecrutador) obj;
		String sql = "DELETE FROM T_CHALL_REGISTRO_RECRUTADOR WHERE ID_REGISTRO_GERAL = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, registroRecrutador.getIdRegistroGeral());
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
		String sql = "SELECT * FROM T_CHALL_REGISTRO_RECRUTADOR";
		String listaRecrutadores = "Lista dos Recrutadores\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaRecrutadores += "ID Recrutador: " + rs.getInt(1) + "\n";
					listaRecrutadores += "Nome Completo: " + rs.getString(2) + "\n";
					listaRecrutadores += "Email: " + rs.getString(3) + "\n";
					//PULANDO O INDICE 4 PQ É A SENHA DO USUARIO
					listaRecrutadores += "Tipo Usuario: " + rs.getString(5) + "\n";
					listaRecrutadores += "CPF: " + rs.getInt(6) + "\n";
					listaRecrutadores += "Nome Empresa: " + rs.getString(7) + "\n";
					listaRecrutadores += "Cargo : " + rs.getString(8) + "\n";
				}
				return listaRecrutadores;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	

}
