package fiap.controller;

/**Classe Controller para para chamar a Classe DAO do objeto, do tipo Telefone
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
*/
import java.sql.*;
import java.util.ArrayList;

import fiap.model.*;

public class TelefoneController {
	
	/**Metodo para inserir os dados do GUI e mandar para o DAO
	 * @author Luis Felipe
	 * @param idTelefone, idRegistro, numeroDDD, telefone, statusT
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String insereTelefone(int idTelefone, int idRegistro, int numeroDDD, int telefone, String statusT ) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		TelefoneDAO td = new TelefoneDAO(con);
		Telefone tl = new Telefone();
		try {
			tl.setIdTelefone(idTelefone);
			tl.setIdRegistroGeral(idRegistro);
			tl.setNumeroDDD(numeroDDD);
			tl.setTelefone(telefone);
			tl.setStatusTelefone(statusT);
			resultado = td.inserir(tl);
			Conexao.fecharConexao(con);
			if (resultado == "Inserido com sucesso.") {
				return "Cadastrado com sucesso!";
			} else {
				return resultado;
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para inserir os dados do GUI e altera no o DAO
	 * @author Luis Felipe
	 * @param idTelefone, idRegistro, numeroDDD, telefone, statusT
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String alteraTelefone(int idTelefone, int idRegistro, int numeroDDD, int telefone, String statusT ) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		TelefoneDAO td = new TelefoneDAO(con);
		Telefone tl = new Telefone();
		try {
			tl.setIdTelefone(idTelefone);
			tl.setIdRegistroGeral(idRegistro);
			tl.setNumeroDDD(numeroDDD);
			tl.setTelefone(telefone);
			tl.setStatusTelefone(statusT);
			resultado = td.alterar(tl);
			Conexao.fecharConexao(con);
			if (resultado == "Alterado com sucesso!") {
				return "Alterado com sucesso!";
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
	public String excluiTelefone(int idTelefone) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		TelefoneDAO td = new TelefoneDAO(con);
		Telefone tl = new Telefone();
		try {
			tl.setIdTelefone(idTelefone);
			resultado = td.excluir(tl);
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
	
	/**Metodo para trazer os dados de um Telefone no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public ArrayList<String> listaUmTelefone(int id) {
		Connection con = Conexao.abrirConexao();
		TelefoneDAO td = new TelefoneDAO(con);
		try {
			ArrayList<Telefone> lista = td.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (Telefone telefone : lista) {
					dados.add("" + telefone.getIdTelefone());
					dados.add("" + telefone.getIdRegistroGeral());
					dados.add("" + telefone.getNumeroDDD());
					dados.add("" + telefone.getTelefone());
					dados.add(telefone.getStatusTelefone());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**Metodo para trazer os dados de todos os Telefones no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String listaTelefones() {
		Connection con = Conexao.abrirConexao();
		TelefoneDAO td = new TelefoneDAO(con);
		try {
			ArrayList<Telefone> lista = td.listarTodos();
			String dados = "Lista de Telefone:\n\n";
			if (lista != null) {
				for (Telefone telefone : lista) {
					dados += "ID Telefone: " + telefone.getIdTelefone() + "\n";
					dados += "ID Registro: " + telefone.getIdRegistroGeral() + "\n";
					dados += "DDD: " + telefone.getNumeroDDD() + "\n";
					dados += "Telefone: " + telefone.getTelefone() + "\n";
					dados += "Status: " + telefone.getStatusTelefone() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
	
	
	
}
