package fiap.controller;

import java.sql.*;
import java.util.ArrayList;

import fiap.model.*;

public class LinguagemController {

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
				return "Alteração feita com sucesso!";
			} else {
				return "Erro ao alterar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
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
				return "Exclusão feita com sucesso!";
			} else {
				return "Erro ao excluir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String listaUmaLinguagem(int id) {
		Connection con = Conexao.abrirConexao();
		LinguagemDAO ldao = new LinguagemDAO(con);
		try {
			ArrayList<Linguagem> lista = ldao.listarUm(id);
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
