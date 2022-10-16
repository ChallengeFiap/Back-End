package fiap.controller;

/**Classe Controller para para chamar a Classe DAO do objeto, do tipo Linguagem Candidato
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
*/
import java.sql.*;
import java.util.ArrayList;

import fiap.model.*;

public class LinguagemController {

	/**Metodo para inserir os dados do GUI e mandar para o DAO
	 * @author Luis Felipe
	 * @param idLinguagem, linguagem
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String insereLinguagem(int idLinguagem, String linguagem) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		LinguagemDAO ldao = new LinguagemDAO(con);
		Linguagem li = new Linguagem();
		try {
			li.setIdLinguagem(idLinguagem);
			li.setLinguagem(linguagem);
			resultado = ldao.inserir(li);
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
	 * @param idLinguagem, linguagem
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String alteraLinguagem(int idLinguagem, String linguagem) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		LinguagemDAO ldao = new LinguagemDAO(con);
		Linguagem li = new Linguagem();
		try {
			li.setIdLinguagem(idLinguagem);
			li.setLinguagem(linguagem);
			resultado = ldao.alterar(li);
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
	public String excluiLinguagem(int idLinguagem) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		LinguagemDAO ldao = new LinguagemDAO(con);
		Linguagem li = new Linguagem();
		try {
			li.setIdLinguagem(idLinguagem);
			resultado = ldao.excluir(li);
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
	
	/**Metodo para trazer os dados de uma Linguagem no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/

	public ArrayList<String> listaUmaLinguagem(int id) {
		Connection con = Conexao.abrirConexao();
		LinguagemDAO ldao = new LinguagemDAO(con);
		try {
			ArrayList<Linguagem> lista = ldao.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (Linguagem linguagem : lista) {
					dados.add("" + linguagem.getIdLinguagem());
					dados.add(linguagem.getLinguagem());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**Metodo para trazer os dados de todas as Linguagens no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @return Mensagem com Sucesso ou Fracasso
	*/

	public String listaLinguagens() {
		Connection con = Conexao.abrirConexao();
		LinguagemDAO ldao = new LinguagemDAO(con);
		try {
			ArrayList<Linguagem> lista = ldao.listarTodos();
			String dados = "Lista de Linguagens:\n\n";
			if (lista != null) {
				for (Linguagem linguagem : lista) {
					dados += "ID Linguagem: " + linguagem.getIdLinguagem() + "\n";
					dados += "Linguagem: " + linguagem.getLinguagem() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
}
