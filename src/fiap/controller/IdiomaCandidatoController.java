package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import fiap.model.*;

public class IdiomaCandidatoController {
	
	public String insereIdiomaCandidato(int idIdiomaCandidato, int IdRegistro, int IdIdiomas, LocalDate dataInicio, String proficiencia) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		IdiomaCandidatoDAO icdao = new IdiomaCandidatoDAO(con);
		IdiomaCandidato ic = new IdiomaCandidato();
		try {
			ic.setIdIdiomaCandidato(idIdiomaCandidato);
			ic.setIdRegistroGeral(IdRegistro);
			ic.setIdIdiomas(IdIdiomas);
			ic.setDataInicio(dataInicio);
			ic.setProficiencia(proficiencia);
			resultado = icdao.inserir(ic);
			System.out.println(resultado);
			Conexao.fecharConexao(con);
			if (resultado == "Inserido com sucesso.") {
				return "Cadastrado com sucesso!";
			} else {
				return "Erro ao Cadastrar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String alteraIdiomaCandidato(int idIdiomaCandidato, int IdRegistro, int IdIdiomas, LocalDate dataInicio, String proficiencia) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		IdiomaCandidatoDAO icdao = new IdiomaCandidatoDAO(con);
		IdiomaCandidato ic = new IdiomaCandidato();
		try {
			ic.setIdIdiomaCandidato(idIdiomaCandidato);
			ic.setIdRegistroGeral(IdRegistro);
			ic.setIdIdiomas(IdIdiomas);
			ic.setDataInicio(dataInicio);
			ic.setProficiencia(proficiencia);
			resultado = icdao.alterar(ic);
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
	
	public String excluiIdiomaCandidato(int idIdiomaCandidato) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		IdiomaCandidatoDAO icdao = new IdiomaCandidatoDAO(con);
		IdiomaCandidato ic = new IdiomaCandidato();
		try {
			ic.setIdIdiomaCandidato(idIdiomaCandidato);
			resultado = icdao.excluir(ic);
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
	
	public String listaUmIdiomaCandidato(int id) {
		Connection con = Conexao.abrirConexao();
		IdiomaCandidatoDAO icdao = new IdiomaCandidatoDAO(con);
		try {
			ArrayList<IdiomaCandidato> lista = icdao.listarUm(id);
			String dados = "Lista de Idioma Candidato:\n\n";
			if (lista != null) {
				for (IdiomaCandidato idiomaCandidato : lista) {
					dados += "ID Idioma Candidato: " + idiomaCandidato.getIdIdiomaCandidato() + "\n";
					dados += "ID Idioma: " + idiomaCandidato.getIdIdiomas() + "\n";
					dados += "ID Registro: " + idiomaCandidato.getIdRegistroGeral() + "\n";
					dados += "Data Inicio: " + idiomaCandidato.getDataInicio() + "\n";
					dados += "Proficiencia: " + idiomaCandidato.getProficiencia() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String listaIdiomaCandidatos() {
		Connection con = Conexao.abrirConexao();
		IdiomaCandidatoDAO icdao = new IdiomaCandidatoDAO(con);
		try {
			ArrayList<IdiomaCandidato> lista = icdao.listarTodos();
			String dados = "Lista de Idioma Candidato:\n\n";
			if (lista != null) {
				for (IdiomaCandidato idiomaCandidato : lista) {
					dados += "ID Idioma Candidato: " + idiomaCandidato.getIdIdiomaCandidato() + "\n";
					dados += "ID Idioma: " + idiomaCandidato.getIdIdiomas() + "\n";
					dados += "ID Registro: " + idiomaCandidato.getIdRegistroGeral() + "\n";
					dados += "Data Inicio: " + idiomaCandidato.getDataInicio() + "\n";
					dados += "Proficiencia: " + idiomaCandidato.getProficiencia() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
	
}
