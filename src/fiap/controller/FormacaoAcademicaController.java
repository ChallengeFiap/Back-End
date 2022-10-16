package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import fiap.model.*;

public class FormacaoAcademicaController {
	
	public String insereFormacaoAcademica(int idFormacao, int idRegistro, String nomeInstituicao, String atividadeExtra, LocalDate dataInicio, LocalDate dataTermino,
			String nomeCurso, String statusCurso, String escolaridade, String xpCurso, String Semestre) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FormacaoAcademicaDAO fcdao = new FormacaoAcademicaDAO(con);
		FormacaoAcademica fa = new FormacaoAcademica();
		try {
			fa.setIdFormacaoAcademica(idFormacao);
			fa.setIdRegistroGeral(idRegistro);
			fa.setNomeInstituicao(nomeInstituicao);
			fa.setAtividadeExtraCurricular(atividadeExtra);
			fa.setDataInicio(dataInicio);
			fa.setDataTermino(dataTermino);
			fa.setNomeCurso(nomeCurso);
			fa.setStatusCurso(statusCurso);
			fa.setEscolaridade(escolaridade);
			fa.setNivelCurso(xpCurso);
			fa.setSemestre(Semestre);
			resultado = fcdao.inserir(fa);
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
	
	public String alteraFormacaoAcademica(int idFormacao, int idRegistro, String nomeInstituicao, String atividadeExtra, LocalDate dataInicio, LocalDate dataTermino,
			String nomeCurso, String statusCurso, String escolaridade, String xpCurso, String Semestre) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FormacaoAcademicaDAO fcdao = new FormacaoAcademicaDAO(con);
		FormacaoAcademica fa = new FormacaoAcademica();
		try {
			fa.setIdFormacaoAcademica(idFormacao);
			fa.setIdRegistroGeral(idRegistro);
			fa.setNomeInstituicao(nomeInstituicao);
			fa.setAtividadeExtraCurricular(atividadeExtra);
			fa.setDataInicio(dataInicio);
			fa.setDataTermino(dataTermino);
			fa.setNomeCurso(nomeCurso);
			fa.setStatusCurso(statusCurso);
			fa.setEscolaridade(escolaridade);
			fa.setNivelCurso(xpCurso);
			fa.setSemestre(Semestre);
			resultado = fcdao.alterar(fa);
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
	
	
	public String excluirFormacaoAcademica(int idFormacao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FormacaoAcademicaDAO fcdao = new FormacaoAcademicaDAO(con);
		FormacaoAcademica fa = new FormacaoAcademica();
		try {
			fa.setIdFormacaoAcademica(idFormacao);
			resultado = fcdao.excluir(fa);
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
	
	public ArrayList<String> listaUmaFormacaoAcademica(int id) {
		Connection con = Conexao.abrirConexao();
		FormacaoAcademicaDAO fcdao = new FormacaoAcademicaDAO(con);
		try {
			ArrayList<FormacaoAcademica> lista = fcdao.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (FormacaoAcademica formacaoAcademica : lista) {
					dados.add("" + formacaoAcademica.getIdFormacaoAcademica());
					dados.add("" + formacaoAcademica.getIdRegistroGeral());
					dados.add(formacaoAcademica.getNomeInstituicao());
					dados.add(formacaoAcademica.getAtividadeExtraCurricular());
					dados.add("" + formacaoAcademica.getDataInicio());
					dados.add("" + formacaoAcademica.getDataTermino());
					dados.add(formacaoAcademica.getNomeCurso());
					dados.add(formacaoAcademica.getStatusCurso());
					dados.add(formacaoAcademica.getEscolaridade());
					dados.add(formacaoAcademica.getNivelCurso());
					dados.add(formacaoAcademica.getSemestre());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String listaFormacoesAcademicas() {
		Connection con = Conexao.abrirConexao();
		FormacaoAcademicaDAO fcdao = new FormacaoAcademicaDAO(con);
		try {
			ArrayList<FormacaoAcademica> lista = fcdao.listarTodos();
			String dados = "Lista de Formacao Academica:\n\n";
			if (lista != null) {
				for (FormacaoAcademica formacaoAcademica : lista) {
					dados += "ID Formacao Academica: " + formacaoAcademica.getIdFormacaoAcademica() + "\n";
					dados += "ID Registro: " + formacaoAcademica.getIdRegistroGeral() + "\n";
					dados += "Nome Instituicao: " + formacaoAcademica.getNomeInstituicao() + "\n";
					dados += "Atividade Extras Cur.: " + formacaoAcademica.getAtividadeExtraCurricular() + "\n";
					dados += "Data Inicio: " + formacaoAcademica.getDataInicio() + "\n";
					dados += "Data Termino: " + formacaoAcademica.getDataTermino() + "\n";
					dados += "Nome Curso: " + formacaoAcademica.getNomeCurso() + "\n";
					dados += "Status Curso: " + formacaoAcademica.getStatusCurso() + "\n";
					dados += "Escolaridade: " + formacaoAcademica.getEscolaridade() + "\n";
					dados += "Nivel Curso: " + formacaoAcademica.getNivelCurso() + "\n";
					dados += "Semestre: " + formacaoAcademica.getSemestre() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
