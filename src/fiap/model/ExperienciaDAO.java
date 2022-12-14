package fiap.model;

/**Classe para a CRUD dos objetos do tipo Experiencia no Banco de Dados utilizando a classe Conexao
 * @author Luis Felipe
 * @version 1.1
 * @since 07/09/2022
 */

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ExperienciaDAO implements IDAO {

	private Connection con;
	private Experiencia experiencia;

	public ExperienciaDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Object obj) {
		experiencia = (Experiencia) obj;
		String sql = "INSERT INTO T_CHALL_EXPERIENCIA (ID_EXPERIENCIA, ID_REGISTRO_GERAL, TP_EXPERIENCIA, DT_INICIO, DT_TERMINO, ST_STATUS, DS_SENIORIDADE) "
				+ "VALUES (?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), TO_DATE(?, 'DD/MM/YYYY'), 'A', ?)";
		try {
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = experiencia.getDataInicio().format(formatter);
			String dataTermino = experiencia.getDataFim().format(formatter);

			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, experiencia.getIdExperiencia());
			ps.setInt(2, experiencia.getIdRegistroGeral());
			ps.setString(3, experiencia.getExperiencia());
			ps.setString(4, dataInicio);
			ps.setString(5, dataTermino);
			ps.setString(6, experiencia.getSenioridade());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(Object obj) {
		experiencia = (Experiencia) obj;
		String sql = "UPDATE T_CHALL_EXPERIENCIA SET ID_REGISTRO_GERAL = ?, TP_EXPERIENCIA = ?, DT_INICIO = TO_DATE(?, 'DD/MM/YYYY'), "
				+ "DT_TERMINO = TO_DATE(?, 'DD/MM/YYYY'), ST_STATUS = ?, DS_SENIORIDADE = ? WHERE ID_EXPERIENCIA = ?";
		try {
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = experiencia.getDataInicio().format(formatter);
			String dataTermino = experiencia.getDataFim().format(formatter);

			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, experiencia.getIdRegistroGeral());
			ps.setString(2, experiencia.getExperiencia());
			ps.setString(3, dataInicio);
			ps.setString(4, dataTermino);
			ps.setString(5, experiencia.getStatusExperiencia());
			ps.setString(6, experiencia.getSenioridade());
			ps.setInt(7, experiencia.getIdExperiencia());
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
		experiencia = (Experiencia) obj;
		String sql = "DELETE FROM T_CHALL_EXPERIENCIA WHERE ID_EXPERIENCIA = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, experiencia.getIdExperiencia());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso!";
			} else {
				return "Erro ao excluir!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public ArrayList<Experiencia> listarUm(int id) {
		String sql = "SELECT ID_EXPERIENCIA, ID_REGISTRO_GERAL, TP_EXPERIENCIA, TO_CHAR(DT_INICIO, 'YYYY/MM/DD'), TO_CHAR(DT_TERMINO, 'YYYY/MM/DD'), "
				+ "ST_STATUS, DS_SENIORIDADE FROM T_CHALL_EXPERIENCIA WHERE ID_EXPERIENCIA = ?";
		ArrayList<Experiencia> listaExperiencias = new ArrayList<Experiencia>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Experiencia ex = new Experiencia();
				ex.setIdExperiencia(rs.getInt(1));
				ex.setIdRegistroGeral(rs.getInt(2));
				ex.setExperiencia(rs.getString(3));

				/// Transformando o LocalDate em String para mandar para o Banco de Dados
				String aux = rs.getString(4);
				String data = aux.substring(0, 4) + "-";
				data += aux.substring(5, 7) + "-";
				data += aux.substring(8, 10);
				LocalDate dataInicio = LocalDate.parse(data);

				ex.setDataInicio(dataInicio);

				// Transformando o LocalDate em String para mandar para o Banco de Dados
				aux = rs.getString(5);
				data = aux.substring(0, 4) + "-";
				data += aux.substring(5, 7) + "-";
				data += aux.substring(8, 10);
				LocalDate dataFim = LocalDate.parse(data);

				ex.setDataFim(dataFim);
				ex.setStatusExperiencia(rs.getString(6));
				ex.setSenioridade(rs.getString(7));
				listaExperiencias.add(ex);
				return listaExperiencias;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	public ArrayList<Experiencia> listarTodos() {
		String sql = "SELECT ID_EXPERIENCIA, ID_REGISTRO_GERAL, TP_EXPERIENCIA, TO_CHAR(DT_INICIO, 'YYYY/MM/DD'), TO_CHAR(DT_TERMINO, 'YYYY/MM/DD'), "
				+ "ST_STATUS, DS_SENIORIDADE FROM T_CHALL_EXPERIENCIA ORDER BY ID_EXPERIENCIA";
		ArrayList<Experiencia> listaExperiencias = new ArrayList<Experiencia>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Experiencia ex = new Experiencia();
					ex.setIdExperiencia(rs.getInt(1));
					ex.setIdRegistroGeral(rs.getInt(2));
					ex.setExperiencia(rs.getString(3));

					// Transformando o LocalDate em String para mandar para o Banco de Dados
					String aux = rs.getString(4);
					String data = aux.substring(0, 4) + "-";
					data += aux.substring(5, 7) + "-";
					data += aux.substring(8, 10);
					LocalDate dataInicio = LocalDate.parse(data);

					ex.setDataInicio(dataInicio);

					// Transformando o LocalDate em String para mandar para o Banco de Dados
					aux = rs.getString(5);
				    data = aux.substring(0, 4) + "-";
					data += aux.substring(5, 7) + "-";
					data += aux.substring(8, 10);
					LocalDate dataFim = LocalDate.parse(data);

					ex.setDataFim(dataFim);
					ex.setStatusExperiencia(rs.getString(6));
					ex.setSenioridade(rs.getString(7));
					listaExperiencias.add(ex);
				}
				return listaExperiencias;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}

}
