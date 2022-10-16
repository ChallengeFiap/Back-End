package fiap.controller;

import java.sql.*;
import java.util.ArrayList;

import fiap.model.*;

public class CursosController {

	public String insereCurso(int idCurso, int nrCurso, String sgCurso, String nmCurso) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CursosDAO cudao = new CursosDAO(con);
		Cursos cu = new Cursos();
		try {
			cu.setIdCurso(idCurso);
			cu.setNumeroCurso(nrCurso);
			cu.setSiglaCurso(sgCurso);
			cu.setNomeCurso(nmCurso);
			resultado = cudao.inserir(cu);
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
	
	public String alteraCurso(int idCurso, int nrCurso, String sgCurso, String nmCurso) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CursosDAO cudao = new CursosDAO(con);
		Cursos cu = new Cursos();
		try {
			cu.setIdCurso(idCurso);
			cu.setNumeroCurso(nrCurso);
			cu.setSiglaCurso(sgCurso);
			cu.setNomeCurso(nmCurso);
			resultado = cudao.alterar(cu);
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
	
	public String excluiCurso(int idCurso) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CursosDAO cudao = new CursosDAO(con);
		Cursos cu = new Cursos();
		try {
			cu.setIdCurso(idCurso);
			resultado = cudao.excluir(cu);
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
	
	public ArrayList<String> listaUmCurso(int id) {
		Connection con = Conexao.abrirConexao();
		CursosDAO cudao = new CursosDAO(con);
		try {
			ArrayList<Cursos> lista = cudao.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (Cursos cursos : lista) {
					dados.add("" + cursos.getIdCurso());
					dados.add("" + cursos.getNumeroCurso());
					dados.add(cursos.getSiglaCurso());
					dados.add(cursos.getNomeCurso());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String listaCurso() {
		Connection con = Conexao.abrirConexao();
		CursosDAO cudao = new CursosDAO(con);
		try {
			ArrayList<Cursos> lista = cudao.listarTodos();
			String dados = "Lista de Cursos:\n\n";
			if (lista != null) {
				for (Cursos cursos : lista) {
					dados += "ID Curso: " + cursos.getIdCurso() + "\n";
					dados += "Numero do Curso: " + cursos.getNumeroCurso() + "\n";
					dados += "Sigla do Curso: " + cursos.getSiglaCurso() + "\n";
					dados += "Nome do Curso: " + cursos.getNomeCurso() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
