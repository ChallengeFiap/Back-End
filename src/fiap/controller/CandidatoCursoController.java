package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import fiap.model.*;

public class CandidatoCursoController {

	public String insereCandidatoCurso(int idCandCurso, int idRegistro, int idCurso, LocalDate dataInicio, LocalDate dataTermino) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CandidatoCursoDAO ccdao = new CandidatoCursoDAO(con);
		CandidatoCurso cc = new CandidatoCurso();
		try {
			cc.setIdCandidatoCurso(idCandCurso);
			cc.setIdCurso(idCurso);
			cc.setIdRegistroGeral(idRegistro);
			cc.setDataInicio(dataInicio);
			cc.setDataFim(dataTermino);
			resultado = ccdao.inserir(cc);
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
	
	public String alteraCandidatoCurso(int idCandCurso, int idRegistro, int idCurso, LocalDate dataInicio, LocalDate dataTermino) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CandidatoCursoDAO ccdao = new CandidatoCursoDAO(con);
		CandidatoCurso cc = new CandidatoCurso();
		try {
			cc.setIdCandidatoCurso(idCandCurso);
			cc.setIdCurso(idCurso);
			cc.setIdRegistroGeral(idRegistro);
			cc.setDataInicio(dataInicio);
			cc.setDataFim(dataTermino);
			resultado = ccdao.alterar(cc);
			System.out.println(resultado);
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
	
	public String excluiCandidatoCurso(int idLingCand) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CandidatoCursoDAO ccdao = new CandidatoCursoDAO(con);
		CandidatoCurso cc = new CandidatoCurso();
		try {
			cc.setIdCandidatoCurso(idLingCand);
			resultado = ccdao.excluir(cc);
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
	
	public ArrayList<String> listaUmCandidatoCurso(int id) {
		Connection con = Conexao.abrirConexao();
		CandidatoCursoDAO ccdao = new CandidatoCursoDAO(con);
		try {
			ArrayList<CandidatoCurso> lista = ccdao.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (CandidatoCurso CandidatoCurso : lista) {
					dados.add("" + CandidatoCurso.getIdCandidatoCurso());
					dados.add("" + CandidatoCurso.getIdCurso());
					dados.add("" + CandidatoCurso.getIdRegistroGeral());
					dados.add("" + CandidatoCurso.getDataInicio());
					dados.add("" + CandidatoCurso.getDataFim());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String listaCandidatoCurso() {
		Connection con = Conexao.abrirConexao();
		CandidatoCursoDAO ccdao = new CandidatoCursoDAO(con);
		try {
			ArrayList<CandidatoCurso> lista = ccdao.listarTodos();
			String dados = "Lista de Linguagem Candidatos:\n\n";
			if (lista != null) {
				for (CandidatoCurso CandidatoCurso : lista) {
					dados += "ID Candidato Curso: " + CandidatoCurso.getIdCandidatoCurso() + "\n";
					dados += "ID Curso: " + CandidatoCurso.getIdCurso() + "\n";
					dados += "ID Registro: " + CandidatoCurso.getIdRegistroGeral() + "\n";
					dados += "Data Inicio: " + CandidatoCurso.getDataInicio() + "\n";
					dados += "Data Termino: " + CandidatoCurso.getDataFim() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
