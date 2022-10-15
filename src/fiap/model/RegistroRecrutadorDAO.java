package fiap.model;
/**Classe para a CRUD dos objetos do tipo Registro Recrutador no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;
import java.util.ArrayList;

public class RegistroRecrutadorDAO implements IDAOR {

	private Connection con;
	private RegistroRecrutador registroRecrutador;
	
	
	public RegistroRecrutadorDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserirRegistro(Object obj) {
		registroRecrutador = (RegistroRecrutador) obj;
		String sql = "INSERT INTO T_CHALL_REGISTRO_GERAL (ID_REGISTRO_GERAL, NM_NOME_COMPLETO, DS_EMAIL, DS_SENHA, TP_USUARIO, NR_CPF) "
				+ "VALUES (?, ?, ?, ?, 'R', ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, registroRecrutador.getIdRegistroGeral());
			ps.setString(2, registroRecrutador.getNomeCompleto());
			ps.setString(3, registroRecrutador.getEmail());
			ps.setString(4, registroRecrutador.getSenha());
			ps.setString(5, registroRecrutador.getNumeroCPF());
			if(ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String inserirUsuario(Object obj) {
		registroRecrutador = (RegistroRecrutador) obj;
		String sql = "INSERT INTO T_CHALL_REGISTRO_RECRUTADOR (ID_REGISTRO_GERAL, NM_EMPRESA, DS_CARGO) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, registroRecrutador.getIdRegistroGeral());
			ps.setString(2, registroRecrutador.getNomeEmpresa());
			ps.setString(3, registroRecrutador.getCargoRecrutador());
			if(ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String alterarRegistro(Object obj) {
		registroRecrutador = (RegistroRecrutador) obj;
		String sql = "UPDATE T_CHALL_REGISTRO_GERAL SET NM_NOME_COMPLETO = ?, DS_EMAIL = ?, DS_SENHA = ?, NR_CPF = ? "
				+ "WHERE ID_REGISTRO_GERAL = ? AND TP_USUARIO = 'R' ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, registroRecrutador.getNomeCompleto());
			ps.setString(2, registroRecrutador.getEmail());
			ps.setString(3, registroRecrutador.getSenha());
			ps.setString(4, registroRecrutador.getNumeroCPF());
			ps.setInt(5, registroRecrutador.getIdRegistroGeral());
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
		registroRecrutador = (RegistroRecrutador) obj;
		String sql = "UPDATE T_CHALL_REGISTRO_RECRUTADOR SET NM_EMPRESA = ?, DS_CARGO = ? WHERE ID_REGISTRO_GERAL = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, registroRecrutador.getNomeEmpresa());
			ps.setString(2, registroRecrutador.getCargoRecrutador());
			ps.setInt(3, registroRecrutador.getIdRegistroGeral());
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
		registroRecrutador = (RegistroRecrutador) obj;
		String sql = "DELETE FROM T_CHALL_REGISTRO_GERAL WHERE ID_REGISTRO_GERAL = ?";
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
	
	public String excluirUsuario(Object obj) {
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
	
	public ArrayList<RegistroRecrutador> listarUm(int id) {
		String sql = "SELECT RR.ID_REGISTRO_GERAL, RG.TP_USUARIO, RG.NM_NOME_COMPLETO, RG.DS_EMAIL, RG.DS_SENHA, RG.NR_CPF,"
				+ " RR.NM_EMPRESA, RR.DS_CARGO FROM T_CHALL_REGISTRO_GERAL RG INNER JOIN T_CHALL_REGISTRO_RECRUTADOR RR "
				+ "ON(RG.ID_REGISTRO_GERAL = RR.ID_REGISTRO_GERAL) WHERE RG.ID_REGISTRO_GERAL = ?";
		ArrayList<RegistroRecrutador> listaRecrutadores = new ArrayList<RegistroRecrutador>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
					RegistroRecrutador rr = new RegistroRecrutador();
					rr.setIdRegistroGeral(rs.getInt(1));
					rr.setTipoUsuario(rs.getString(2));
					rr.setNomeCompleto(rs.getString(3));
					rr.setEmail(rs.getString(4));
					rr.setSenha(rs.getString(5));
					rr.setNumeroCPF(rs.getString(6));
					rr.setNomeEmpresa(rs.getString(7));
					rr.setCargoRecrutador(rs.getString(8));
					listaRecrutadores.add(rr);
				return listaRecrutadores;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	public ArrayList<RegistroRecrutador> listarTodos() {
		String sql = "SELECT RR.ID_REGISTRO_GERAL, RG.TP_USUARIO, RG.NM_NOME_COMPLETO, RG.DS_EMAIL, RG.DS_SENHA, RG.NR_CPF,"
				+ " RR.NM_EMPRESA, RR.DS_CARGO FROM T_CHALL_REGISTRO_GERAL RG INNER JOIN T_CHALL_REGISTRO_RECRUTADOR RR "
				+ "ON(RG.ID_REGISTRO_GERAL = RR.ID_REGISTRO_GERAL)";
		ArrayList<RegistroRecrutador> listaRecrutadores = new ArrayList<RegistroRecrutador>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					RegistroRecrutador rr = new RegistroRecrutador();
					rr.setIdRegistroGeral(rs.getInt(1));
					rr.setTipoUsuario(rs.getString(2));
					rr.setNomeCompleto(rs.getString(3));
					rr.setEmail(rs.getString(4));
					rr.setSenha(rs.getString(5));
					rr.setNumeroCPF(rs.getString(6));
					rr.setNomeEmpresa(rs.getString(7));
					rr.setCargoRecrutador(rs.getString(8));
					listaRecrutadores.add(rr);
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
