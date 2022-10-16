package fiap.controller;

/**Classe Controller para para chamar a Classe DAO do objeto, do tipo Idioma Candidato
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
*/
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import fiap.model.*;

public class IdiomaCandidatoController {
	
	/**Metodo para inserir os dados do GUI e mandar para o DAO
	 * @author Luis Felipe
	 * @param idIdiomaCandidato, IdCandidato, IdIdiomas, dataInicio, proficiencia
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String insereIdiomaCandidato(int idIdiomaCandidato, int IdRegistro, int IdIdiomas, LocalDate dataInicio, String proficiencia) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		IdiomaCandidatoDAO icdao = new IdiomaCandidatoDAO(con);
		IdiomaCandidato ic = new IdiomaCandidato();
		try {
			ic.setIdIdiomaCandidato(idIdiomaCandidato);
			ic.setIdRegistroGeral(IdRegistro);
			ic.setIdIdiomas(IdIdiomas);
			ic.setDataInicio(dataInicio);
			ic.setProficiencia(proficiencia);
			resultado = icdao.inserir(ic);
			System.out.println(resultado);
			Conexao.fecharConexao(con);
			if (resultado == "Inserido com sucesso.") {
				return "Cadastrado com sucesso!";
			} else {
				return "Erro ao Cadastrar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para inserir os dados do GUI e altera no o DAO
	 * @author Luis Felipe
	 * @param idIdiomaCandidato, IdCandidato, IdIdiomas, dataInicio, proficiencia
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String alteraIdiomaCandidato(int idIdiomaCandidato, int IdRegistro, int IdIdiomas, LocalDate dataInicio, String proficiencia) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		IdiomaCandidatoDAO icdao = new IdiomaCandidatoDAO(con);
		IdiomaCandidato ic = new IdiomaCandidato();
		try {
			ic.setIdIdiomaCandidato(idIdiomaCandidato);
			ic.setIdRegistroGeral(IdRegistro);
			ic.setIdIdiomas(IdIdiomas);
			ic.setDataInicio(dataInicio);
			ic.setProficiencia(proficiencia);
			resultado = icdao.alterar(ic);
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
	
	/**Metodo para para excluir os dados no DAO
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String excluiIdiomaCandidato(int idIdiomaCandidato) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		IdiomaCandidatoDAO icdao = new IdiomaCandidatoDAO(con);
		IdiomaCandidato ic = new IdiomaCandidato();
		try {
			ic.setIdIdiomaCandidato(idIdiomaCandidato);
			resultado = icdao.excluir(ic);
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
	
	/**Metodo para trazer os dados de um IdiomaCandidato no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public ArrayList<String> listaUmIdiomaCandidato(int id) {
		Connection con = Conexao.abrirConexao();
		IdiomaCandidatoDAO icdao = new IdiomaCandidatoDAO(con);
		try {
			ArrayList<IdiomaCandidato> lista = icdao.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (IdiomaCandidato idiomaCandidato : lista) {
					dados.add("" + idiomaCandidato.getIdIdiomaCandidato());
					dados.add("" + idiomaCandidato.getIdIdiomas());
					dados.add("" + idiomaCandidato.getIdRegistroGeral());
					dados.add("" + idiomaCandidato.getDataInicio());
					dados.add(idiomaCandidato.getProficiencia());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**Metodo para trazer os dados de todos os IdiomasCandidatos no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String listaIdiomaCandidatos() {
		Connection con = Conexao.abrirConexao();
		IdiomaCandidatoDAO icdao = new IdiomaCandidatoDAO(con);
		try {
			ArrayList<IdiomaCandidato> lista = icdao.listarTodos();
			String dados = "Lista de Idioma Candidato:\n\n";
			if (lista != null) {
				for (IdiomaCandidato idiomaCandidato : lista) {
					dados += "ID Idioma Candidato: " + idiomaCandidato.getIdIdiomaCandidato() + "\n";
					dados += "ID Idioma: " + idiomaCandidato.getIdIdiomas() + "\n";
					dados += "ID Registro: " + idiomaCandidato.getIdRegistroGeral() + "\n";
					dados += "Data Inicio: " + idiomaCandidato.getDataInicio() + "\n";
					dados += "Proficiencia: " + idiomaCandidato.getProficiencia() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
	
}
