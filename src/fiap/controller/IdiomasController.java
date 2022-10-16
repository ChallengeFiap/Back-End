package fiap.controller;

import java.sql.*;
import java.util.ArrayList;

import fiap.model.*;

public class IdiomasController {

	public String insereIdioma(int idIdiomas, String idiomas) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		IdiomaDAO idao = new IdiomaDAO(con);
		Idioma idi = new Idioma();
		try {
			idi.setIdIdioma(idIdiomas);
			idi.setIdioma(idiomas);
			resultado = idao.inserir(idi);
			Conexao.fecharConexao(con);
			if (resultado == "Inserido com sucesso.") {
				return "Cadastrado com sucesso!";
			} else {
				return "Erro ao Cadatrar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String alteraIdioma(int idIdiomas, String idiomas) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		IdiomaDAO idao = new IdiomaDAO(con);
		Idioma idi = new Idioma();
		try {
			idi.setIdIdioma(idIdiomas);
			idi.setIdioma(idiomas);
			resultado = idao.alterar(idi);
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
	
	public String excluiIdioma(int idIdiomas) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		IdiomaDAO idao = new IdiomaDAO(con);
		Idioma idi = new Idioma();
		try {
			idi.setIdIdioma(idIdiomas);
			resultado = idao.excluir(idi);
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
	
	public ArrayList<String> listaUmIdioma(int id) {
		Connection con = Conexao.abrirConexao();
		IdiomaDAO idao = new IdiomaDAO(con);
		try {
			ArrayList<Idioma> lista = idao.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (Idioma idioma : lista) {
					dados.add("" + idioma.getIdIdioma());
					dados.add(idioma.getIdioma());

				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String listaIdiomas() {
		Connection con = Conexao.abrirConexao();
		IdiomaDAO idao = new IdiomaDAO(con);
		try {
			ArrayList<Idioma> lista = idao.listarTodos();
			String dados = "Lista de Idioma:\n\n";
			if (lista != null) {
				for (Idioma idioma : lista) {
					dados += "ID Idioma: " + idioma.getIdIdioma() + "\n";
					dados += "Idioma: " + idioma.getIdioma() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
