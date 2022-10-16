package fiap.controller;

/**Classe Controller para para chamar a Classe DAO do objeto, do tipo Estado
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
*/
import java.sql.*;
import java.util.ArrayList;

import fiap.model.*;


public class EstadoController {
	
	/**Metodo para inserir os dados do GUI e mandar para o DAO
	 * @author Luis Felipe
	 * @param idEstado, sigla, estado
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String insereEstado(int idEstado, String sigla, String estado) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		EstadoDAO ed = new EstadoDAO(con);
		Estado et = new Estado();
		try {
			et.setIdEstado(idEstado);
			et.setSiglaEstado(sigla);
			et.setNomeEstado(estado);
			resultado = ed.inserir(et);
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
	 * @param idEstado, sigla, estado
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String alteraEstado(int idEstado, String sigla, String estado) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		EstadoDAO ed = new EstadoDAO(con);
		Estado et = new Estado(); 
		try {
			et.setIdEstado(idEstado);
			et.setSiglaEstado(sigla);
			et.setNomeEstado(estado);
			resultado = ed.alterar(et);
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
	
	/**Metodo para excluir os dados no DAO
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String excluiEstado(int idEstado) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		EstadoDAO ed = new EstadoDAO(con);
		Estado et = new Estado(); 
		try {
			et.setIdEstado(idEstado);
			resultado = ed.excluir(et);
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
	
	/**Metodo para trazer os dados de um Estado no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public ArrayList<String> listaUmEstado(int id) {
		Connection con = Conexao.abrirConexao();
		EstadoDAO ed = new EstadoDAO(con);
		try {
			ArrayList<Estado> lista = ed.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (Estado estado : lista) {
					dados.add("" + estado.getIdEstado());
					dados.add(estado.getSiglaEstado());
					dados.add(estado.getNomeEstado());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	/**Metodo para trazer os dados de todos os Estados no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String listaEstados() {
		Connection con = Conexao.abrirConexao();
		EstadoDAO ed = new EstadoDAO(con);
		try {
			ArrayList<Estado> lista = ed.listarTodos();
			String dados = "Lista de Estado:\n\n";
			if (lista != null) {
				for (Estado estado : lista) {
					dados += "ID Estado: " + estado.getIdEstado() + "\n";
					dados += "Sigla: " + estado.getSiglaEstado() + "\n";
					dados += "Nome Estado: " + estado.getNomeEstado() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
