package fiap.controller;
/**Classe Controller para para chamar a Classe DAO do objeto, do tipo Favorito
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
*/
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import fiap.model.*;

public class FavoritoController {
	
	/**Metodo para inserir os dados do GUI e mandar para o DAO
	 * @author Luis Felipe
	 * @param idFavorito, idRecrutador, idCandidato, dataFavoritou, statusFavorito
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String insereFavorito(int idFavorito, int idRegistroRecrutador, int idRegistroCandidato, LocalDate dataFavoritou, String statusFavorito) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FavoritoDAO fvdao = new FavoritoDAO(con);
		Favorito fv = new Favorito();
		try {
			fv.setIdFavorito(idFavorito);
			fv.setIdRecrutador(idRegistroRecrutador);
			fv.setIdCandidato(idRegistroCandidato);
			fv.setDataFavoritou(dataFavoritou);
			fv.setStatusFavoritos(statusFavorito);
			resultado = fvdao.inserir(fv);
			System.out.println(resultado);
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
	 * @param idFavorito, idRecrutador, idCandidato, dataFavoritou, statusFavorito
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String alteraFavorito(int idFavorito, int idRegistroRecrutador, int idRegistroCandidato, LocalDate dataFavoritou, String statusFavorito) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FavoritoDAO fvdao = new FavoritoDAO(con);
		Favorito fv = new Favorito();
		try {
			fv.setIdFavorito(idFavorito);
			fv.setIdRecrutador(idRegistroRecrutador);
			fv.setIdCandidato(idRegistroCandidato);
			fv.setDataFavoritou(dataFavoritou);
			fv.setStatusFavoritos(statusFavorito);
			resultado = fvdao.alterar(fv);
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
	public String excluiFavorito(int idFavorito) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FavoritoDAO fvdao = new FavoritoDAO(con);
		Favorito fv = new Favorito();
		try {
			fv.setIdFavorito(idFavorito);
			resultado = fvdao.excluir(fv);
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
	
	/**Metodo para trazer os dados de um Favorito no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public ArrayList<String> listaFavorito(int id) {
		Connection con = Conexao.abrirConexao();
		FavoritoDAO fvdao = new FavoritoDAO(con);
		try {
			ArrayList<Favorito> lista = fvdao.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (Favorito favorito : lista) {
					dados.add("" + favorito.getIdFavorito());
					dados.add("" + favorito.getIdRecrutador());
					dados.add("" + favorito.getIdCandidato());
					dados.add("" + favorito.getDataFavoritou());
					dados.add(favorito.getStatusFavoritos());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**Metodo para trazer os dados de todos os Favoritos no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @return Mensagem com Sucesso ou Fracasso
	*/
	public String listaFavoritos() {
		Connection con = Conexao.abrirConexao();
		FavoritoDAO fvdao = new FavoritoDAO(con);
		try {
			ArrayList<Favorito> lista = fvdao.listarTodos();
			String dados = "Lista de Favoritos:\n\n";
			if (lista != null) {
				for (Favorito favorito : lista) {
					dados += "ID Favorito: " + favorito.getIdFavorito() + "\n";
					dados += "ID Registro Recrutador: " + favorito.getIdRecrutador() + "\n";
					dados += "ID Registro Candidato: " + favorito.getIdCandidato() + "\n";
					dados += "Data Favoritou: " + favorito.getDataFavoritou() + "\n";
					dados += "Status Favorito: " + favorito.getStatusFavoritos() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
