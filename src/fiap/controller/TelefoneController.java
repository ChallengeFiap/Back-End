package fiap.controller;

import java.sql.*;
import java.util.ArrayList;

import fiap.model.*;

public class TelefoneController {
	
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
				return "Exclusão feita com sucesso!";
			} else {
				return "Erro ao excluir";
			}

		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String listaUmTelefone(int id) {
		Connection con = Conexao.abrirConexao();
		TelefoneDAO td = new TelefoneDAO(con);
		try {
			ArrayList<Telefone> lista = td.listarUm(id);
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
