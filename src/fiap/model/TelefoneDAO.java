package fiap.model;
/**Classe para a CRUD dos objetos do tipo Telefone no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */
import java.sql.*;
import java.util.ArrayList;

public class TelefoneDAO implements IDAO {

	private Connection con;
	private Telefone telefone;

	public TelefoneDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Object obj) {
		telefone = (Telefone) obj;
		String sql = "INSERT INTO T_CHALL_TELEFONE (ID_TELEFONE, ID_REGISTRO_GERAL, NR_DDD, NR_TELEFONE, ST_TELEFONE) "
				+ "VALUES (?, ?, ?, ?, ?, ?, 'A')";
		try {
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, telefone.getIdTelefone());
			ps.setInt(2, telefone.getIdRegistroGeral());
			ps.setInt(4, telefone.getNumeroDDD());
			ps.setInt(4, telefone.getTelefone());
			ps.setString(5, telefone.getStatusTelefone());
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
		telefone = (Telefone) obj;
		String sql = "UPDATE T_CHALL_TELEFONE SET ID_REGISTRO_GERAL = ?, NR_DDD = ?, NR_TELEFONE = ?, ST_TELEFONE = ? "
				+ "WHERE ID_TELEFONE = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, telefone.getIdRegistroGeral());
			ps.setInt(2, telefone.getNumeroDDD());
			ps.setInt(3, telefone.getTelefone());
			ps.setString(4, telefone.getStatusTelefone());
			ps.setInt(5, telefone.getIdTelefone());
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
		telefone = (Telefone) obj;
		String sql = "DELETE FROM T_CHALL_TELEFONE WHERE ID_TELEFONE = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, telefone.getIdTelefone());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso!";
			} else {
				return "Erro ao excluir!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Telefone> listarUm(int id) {
		String sql = "SELECT * FROM T_CHALL_TELEFONE WHERE ID_TELEFONE = ?";
		ArrayList<Telefone> listaTelefones = new ArrayList<Telefone>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Telefone tl = new Telefone();
				tl.setIdTelefone(rs.getInt(1));
				tl.setIdRegistroGeral(rs.getInt(2));
				tl.setNumeroDDD(rs.getInt(3));
				tl.setTelefone(rs.getInt(4));
				tl.setStatusTelefone(rs.getString(5));
				listaTelefones.add(tl);
				return listaTelefones;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public ArrayList<Telefone> listarTodos() {
		String sql = "SELECT * FROM T_CHALL_TELEFONE";
		ArrayList<Telefone> listaLinguagens = new ArrayList<Telefone>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Telefone tl = new Telefone();
					tl.setIdTelefone(rs.getInt(1));
					tl.setIdRegistroGeral(rs.getInt(2));
					tl.setNumeroDDD(rs.getInt(3));
					tl.setTelefone(rs.getInt(4));
					tl.setStatusTelefone(rs.getString(5));
					listaLinguagens.add(tl);
				}
				return listaLinguagens;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	

}
