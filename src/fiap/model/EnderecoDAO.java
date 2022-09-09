package fiap.model;

/**Classe para a CRUD dos objetos do tipo Endereco no Banco de Dados utilizando a classe Conexao
 * @author Luís Felipe
 * @version 1.0
 * @since 07/09/2022
 */

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class EnderecoDAO implements IDAO{
	
	private Connection con;
	private Endereco endereco;
	
	public EnderecoDAO() {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		endereco = (Endereco) obj;
		String sql = "INSERT INTO T_CHALL_ENDERECO (ID_ENDERECO, ID_REGISTRO_GERAL, ID_LOGRADOURO, NR_LOGRADOURO, DS_COMPLEMENTO_NUMERO, "
				+ "DS_PONTO_REFERENCIA, DT_INICIO, DT_FIM) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = endereco.getDataInicio().format(formatter);
			String dataFim = endereco.getDataFim().format(formatter);
			
			PreparedStatement ps =  getCon().prepareStatement(sql);
			ps.setInt(1, endereco.getIdEndereco());
			ps.setInt(2, endereco.getIdRegistroGeral());
			ps.setInt(3, endereco.getIdLogradouro());
			ps.setInt(4, endereco.getNumeroLogradouro());
			ps.setString(5, endereco.getComplementoNumero());
			ps.setString(6, endereco.getPontoReferencia());
			ps.setString(7, dataInicio);
			ps.setString(8, dataFim);
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
		endereco = (Endereco) obj;
		String sql = "UPDATE T_CHALL_ENDERECO SET ID_REGISTRO_GERAL = ?, ID_LOGRADOURO = ?, NR_LOGRADOURO = ?, DS_COMPLEMENTO_NUMERO = ?, "
				+ "DS_PONTO_REFERENCIA = ?, DT_INICIO = ?, DT_FIM = ? WHERE ID_ENDERECO = ?";
		try {
			//Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = endereco.getDataInicio().format(formatter);
			String dataFim = endereco.getDataFim().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, endereco.getIdRegistroGeral());
			ps.setInt(2, endereco.getIdLogradouro());
			ps.setInt(3, endereco.getNumeroLogradouro());
			ps.setString(4, endereco.getComplementoNumero());
			ps.setString(5, endereco.getPontoReferencia());
			ps.setString(6, dataInicio);
			ps.setString(7, dataFim);
			ps.setInt(8, endereco.getIdEndereco());
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
		endereco = (Endereco) obj;
		String sql = "DELETE FROM T_CHALL_ENDERECO WHERE ID_ENDERECO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, endereco.getIdEndereco());
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
		String sql = "SELECT * FROM T_CHALL_ENDERECO";
		String listaEnderecos = "Lista dos Enderecos\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaEnderecos += "ID Enderco: " + rs.getInt(1) + "\n";
					listaEnderecos += "ID Registro Geral: " + rs.getInt(2) + "\n";
					listaEnderecos += "ID Logradouro: " + rs.getInt(3) + "\n";
					listaEnderecos += "Numero Logradouro: " + rs.getInt(4) + "\n";
					listaEnderecos += "Complemento Numero: +" + rs.getString(5) + "\n";
					listaEnderecos += "Ponto de Referencia: +" + rs.getString(6) + "\n";
					listaEnderecos += "Data Inicio: " + rs.getString(7) + "\n";
					listaEnderecos += "Data Fim: " + rs.getString(8) + "\n";
				}
				return listaEnderecos;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
