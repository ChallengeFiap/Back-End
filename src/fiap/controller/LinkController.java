package fiap.controller;

/**Classe Controller para para chamar a Classe DAO do objeto, do tipo Link
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
*/
import java.sql.*;
import java.util.ArrayList;

import fiap.model.*;

public class LinkController {

	/**Metodo para inserir os dados do GUI e mandar para o DAO
	 * @author Luis Felipe
	 * @param idLink, idRegistro, link, dataInicio, tipoLink
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String insereLink(int idLink, int idRegistro, String link, String tipoLink) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		LinkDAO lkdao = new LinkDAO(con);
		Link lk = new Link();
		try {
			lk.setIdLink(idLink);
			lk.setIdRegistroGeral(idRegistro);
			lk.setLink(link);
			lk.setNomeLink(tipoLink);
			resultado = lkdao.inserir(lk);
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
	 * @param idLink, idRegistro, link, dataInicio, tipoLink
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String alteraLink(int idLink, int idRegistro, String link, String tipoLink) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		LinkDAO lkdao = new LinkDAO(con);
		Link lk = new Link();
		try {
			lk.setIdLink(idLink);
			lk.setIdRegistroGeral(idRegistro);
			lk.setLink(link);
			lk.setNomeLink(tipoLink);
			resultado = lkdao.alterar(lk);
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
	public String excluiLink(int idLink) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		LinkDAO lkdao = new LinkDAO(con);
		Link lk = new Link();
		try {
			lk.setIdLink(idLink);
			resultado = lkdao.excluir(lk);
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

	/**Metodo para trazer os dados de um Link no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public ArrayList<String> listaUmLink(int id) {
		Connection con = Conexao.abrirConexao();
		LinkDAO lk = new LinkDAO(con);
		try {
			ArrayList<Link> lista = lk.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (Link link : lista) {
					dados.add("" + link.getIdLink());
					dados.add("" + link.getIdRegistroGeral());
					dados.add(link.getNomeLink());
					dados.add(link.getLink());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}

	/**Metodo para trazer os dados de todos os Links no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String listaLinks() {
		Connection con = Conexao.abrirConexao();
		LinkDAO lk = new LinkDAO(con);
		try {
			ArrayList<Link> lista = lk.listarTodos();
			String dados = "Lista de Links:\n\n";
			if (lista != null) {
				for (Link link : lista) {
					dados += "ID Link: " + link.getIdLink() + "\n";
					dados += "ID Registro: " + link.getIdRegistroGeral() + "\n";
					dados += "Nome Link: " + link.getNomeLink() + "\n";
					dados += "Link: " + link.getLink() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
