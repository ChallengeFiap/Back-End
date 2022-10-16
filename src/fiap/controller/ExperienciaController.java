package fiap.controller;

/**Classe Controller para para chamar a Classe DAO do objeto, do tipo Experiencia
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
*/
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import fiap.model.*;


public class ExperienciaController {
	
	/**Metodo para inserir os dados do GUI e mandar para o DAO
	 * @author Luis Felipe
	 * @param idExperiencia, idCandidato, experiencia, DataInicio, dataTermino, status, senioridade
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String insereExperiencia(int idXp, int idRegistro, String experiencia, LocalDate dataInicio, LocalDate dataTermino, String status, String senioridade) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		ExperienciaDAO exdao = new ExperienciaDAO(con);
		Experiencia ex = new Experiencia();
		try {
			ex.setIdExperiencia(idXp);
			ex.setIdRegistroGeral(idRegistro);
			ex.setExperiencia(experiencia);
			ex.setDataInicio(dataInicio);
			ex.setDataFim(dataTermino);
			ex.setSenioridade(senioridade);
			ex.setStatusExperiencia(status);
			resultado = exdao.inserir(ex);
			Conexao.fecharConexao(con);
			if (resultado == "Inserido com sucesso.") {
				return "Cadastrado com sucesso!";
			} else {
				return "Erro ao cadastrar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para inserir os dados do GUI e altera no o DAO
	 * @author Luis Felipe
	 * @param idExperiencia, idCandidato, experiencia, DataInicio, dataTermino, status, senioridade
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String alteraExperiencia(int idXp, int idRegistro, String experiencia, LocalDate dataInicio, LocalDate dataTermino, String status, String senioridade) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		ExperienciaDAO exdao = new ExperienciaDAO(con);
		Experiencia ex = new Experiencia();
		try {
			ex.setIdExperiencia(idXp);
			ex.setIdRegistroGeral(idRegistro);
			ex.setExperiencia(experiencia);
			ex.setDataInicio(dataInicio);
			ex.setDataFim(dataTermino);
			ex.setSenioridade(senioridade);
			ex.setStatusExperiencia(status);
			resultado = exdao.alterar(ex);
			System.out.println(resultado);
			Conexao.fecharConexao(con);
			if (resultado == "Alterado com sucesso!") {
				return "Alteracao feita com sucesso!";
			} else {
				return "Erro ao alterar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para excluir os dados no DAO
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String excluiExperiencia(int idXp) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		ExperienciaDAO exdao = new ExperienciaDAO(con);
		Experiencia ex = new Experiencia();
		try {
			ex.setIdExperiencia(idXp);
			resultado = exdao.excluir(ex);
			Conexao.fecharConexao(con);
			if (resultado == "Excluido com sucesso!") {
				return "Exclusao feita com sucesso!";
			} else {
				return "Erro ao excluir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para trazer os dados de uma Experiencia no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public ArrayList<String> listaUmaExperiencia(int id) {
		Connection con = Conexao.abrirConexao();
		ExperienciaDAO exdao = new ExperienciaDAO(con);
		try {
			ArrayList<Experiencia> lista = exdao.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (Experiencia experiencia : lista) {
					dados.add("" + experiencia.getIdExperiencia());
					dados.add("" + experiencia.getIdRegistroGeral());
					dados.add(experiencia.getExperiencia());
					dados.add("" + experiencia.getDataInicio());
					dados.add("" + experiencia.getDataFim());
					dados.add(experiencia.getStatusExperiencia());
					dados.add(experiencia.getSenioridade());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	/**Metodo para trazer os dados de todas as Experiencias no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @return Mensagem com Sucesso ou Fracasso
	*/

	public String listaExperiencias() {
		Connection con = Conexao.abrirConexao();
		ExperienciaDAO exdao = new ExperienciaDAO(con);
		try {
			ArrayList<Experiencia> lista = exdao.listarTodos();
			String dados = "Lista de Experiencia:\n\n";
			if (lista != null) {
				for (Experiencia experiencia : lista) {
					dados += "ID Experiencia: " + experiencia.getIdExperiencia() + "\n";
					dados += "ID Registro: " + experiencia.getIdRegistroGeral() + "\n";
					dados += "Experiencia: " + experiencia.getExperiencia() + "\n";
					dados += "Data Inicio: " + experiencia.getDataInicio() + "\n";
					dados += "Data Termino: " + experiencia.getDataFim() + "\n";
					dados += "Status Experiencia: " + experiencia.getStatusExperiencia() + "\n";
					dados += "Senioridade: " + experiencia.getSenioridade() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	

}
