package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import fiap.model.*;

public class FavoritoController {
	
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
				return "Alteração feita com sucesso!";
			} else {
				return "Erro ao alterar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
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
				return "Exclusão feita com sucesso!";
			} else {
				return "Erro ao excluir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String listaFavorito(int id) {
		Connection con = Conexao.abrirConexao();
		FavoritoDAO fvdao = new FavoritoDAO(con);
		try {
			ArrayList<Favorito> lista = fvdao.listarUm(id);
			String dados = "Lista de Favorito:\n\n";
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
