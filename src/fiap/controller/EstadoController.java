package fiap.controller;

import java.sql.*;
import java.util.ArrayList;

import fiap.model.*;


public class EstadoController {
	
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
				return "Exclusão feita com sucesso!";
			} else {
				return "Erro ao excluir";
			}

		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String listaUmEstado(int id) {
		Connection con = Conexao.abrirConexao();
		EstadoDAO ed = new EstadoDAO(con);
		try {
			ArrayList<Estado> lista = ed.listarUm(id);
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
