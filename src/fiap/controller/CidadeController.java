package fiap.controller;
/**Classe Controller para para chamar a Classe DAO do objeto, do tipo Cidade
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
*/
import java.sql.*;
import java.util.ArrayList;

import fiap.model.*;

public class CidadeController {
	/**Metodo para inserir os dados do GUI e mandar para o DAO
	 * @author Luis Felipe
	 * @param idCidade, idCandidato, idEstado, cidade
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String insereCidade(int idCidade, int idRegistro, int idEstado, String cidade) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CidadeDAO cdao = new CidadeDAO(con);
		Cidade cd = new Cidade();
		try {
			cd.setIdCidade(idCidade);
			cd.setIdRegistroGeral(idRegistro);
			cd.setIdEstado(idEstado);
			cd.setNomeCidade(cidade);
			resultado = cdao.inserir(cd);
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
	
	/**Metodo para inserir os dados do GUI e alterar para o DAO
	 * @author Luis Felipe
	 * @param idCidade, idCandidato, idEstado, cidade
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String alteraCidade(int idCidade, int idRegistro, int idEstado, String cidade) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CidadeDAO cdao = new CidadeDAO(con);
		Cidade cd = new Cidade();
		try {
			cd.setIdCidade(idCidade);
			cd.setIdRegistroGeral(idRegistro);
			cd.setIdEstado(idEstado);
			cd.setNomeCidade(cidade);
			resultado = cdao.alterar(cd);
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
	
	/**Metodo para trazer os dados do GUI e excluir no DAO
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String excluiCidade(int idCidade) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CidadeDAO cdao = new CidadeDAO(con);
		Cidade cd = new Cidade();
		try {
			cd.setIdCidade(idCidade);
			resultado = cdao.excluir(cd);
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
	
	
	/**Metodo para trazer os dados de um Candidato no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public ArrayList<String> listaUmaCidade(int id) {
		Connection con = Conexao.abrirConexao();
		CidadeDAO cdao = new CidadeDAO(con);
		try {
			ArrayList<Cidade> lista = cdao.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (Cidade cidade : lista) {
					dados.add("" + cidade.getIdCidade());
					dados.add("" + cidade.getIdRegistroGeral());
					dados.add("" + cidade.getIdEstado());
					dados.add(cidade.getNomeCidade());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**Metodo para trazer os dados de todas as Cidades no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String listaCidades() {
		Connection con = Conexao.abrirConexao();
		CidadeDAO cdao = new CidadeDAO(con);
		try {
			ArrayList<Cidade> lista = cdao.listarTodos();
			String dados = "Lista de Cidades:\n\n";
			if (lista != null) {
				for (Cidade cidade : lista) {
					dados += "ID Cidade: " + cidade.getIdCidade() + "\n";
					dados += "ID Registro: " + cidade.getIdRegistroGeral() + "\n";
					dados += "ID Estado: " + cidade.getIdEstado() + "\n";
					dados += "Nome Cidade: " + cidade.getNomeCidade() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	

}
