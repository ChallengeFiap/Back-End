package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import fiap.model.*;

public class LinguagemCandidatoController {
	
	public String insereLinguagemCandidato(int idLingCand, int idLingProg, int idRegistro, LocalDate dataInicio, String proficiencia) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		LinguagemCandidatoDAO lcdao = new LinguagemCandidatoDAO(con);
		LinguagemCandidato lc = new LinguagemCandidato();
		try {
			lc.setIdLinguagemCandidato(idLingCand);
			lc.setIdLinguagem(idLingProg);
			lc.setIdRegistroGeral(idRegistro);
			lc.setDataInicio(dataInicio);
			lc.setProficiencia(proficiencia);
			resultado = lcdao.inserir(lc);
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
	
	public String alteraLinguagemCandidato(int idLingCand, int idLingProg, int idRegistro, LocalDate dataInicio, String proficiencia) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		LinguagemCandidatoDAO lcdao = new LinguagemCandidatoDAO(con);
		LinguagemCandidato lc = new LinguagemCandidato();
		try {
			lc.setIdLinguagemCandidato(idLingCand);
			lc.setIdLinguagem(idLingProg);
			lc.setIdRegistroGeral(idRegistro);
			lc.setDataInicio(dataInicio);
			lc.setProficiencia(proficiencia);
			resultado = lcdao.alterar(lc);
			Conexao.fecharConexao(con);
			if (resultado == "Alterado com sucesso!") {
				return "Altera��o feita com sucesso!";
			} else {
				return "Erro ao alterar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String excluiLinguagemCandidato(int idLingCand) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		LinguagemCandidatoDAO lcdao = new LinguagemCandidatoDAO(con);
		LinguagemCandidato lc = new LinguagemCandidato();
		try {
			lc.setIdLinguagemCandidato(idLingCand);
			resultado = lcdao.excluir(lc);
			Conexao.fecharConexao(con);
			if (resultado == "Excluido com sucesso!") {
				return "Exclus�o feita com sucesso!";
			} else {
				return "Erro ao excluir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<String> listaUmaLinguagemCandidato(int id) {
		Connection con = Conexao.abrirConexao();
		LinguagemCandidatoDAO lcdao = new LinguagemCandidatoDAO(con);
		try {
			ArrayList<LinguagemCandidato> lista = lcdao.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (LinguagemCandidato linguagemCandidato : lista) {
					dados.add("" + linguagemCandidato.getIdLinguagemCandidato());
					dados.add("" + linguagemCandidato.getIdLinguagem());
					dados.add("" + linguagemCandidato.getIdRegistroGeral());
					dados.add("" + linguagemCandidato.getDataInicio());
					dados.add(linguagemCandidato.getProficiencia());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String listaLinguagensCandidatos() {
		Connection con = Conexao.abrirConexao();
		LinguagemCandidatoDAO lcdao = new LinguagemCandidatoDAO(con);
		try {
			ArrayList<LinguagemCandidato> lista = lcdao.listarTodos();
			String dados = "Lista de Linguagem Candidatos:\n\n";
			if (lista != null) {
				for (LinguagemCandidato linguagemCandidato : lista) {
					dados += "ID Linguagem Candidato: " + linguagemCandidato.getIdLinguagemCandidato() + "\n";
					dados += "ID Linguagem Programa��o: " + linguagemCandidato.getIdLinguagem() + "\n";
					dados += "ID Registro: " + linguagemCandidato.getIdRegistroGeral() + "\n";
					dados += "Data Inicio: " + linguagemCandidato.getDataInicio() + "\n";
					dados += "Proficiencia: " + linguagemCandidato.getProficiencia() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	

}
