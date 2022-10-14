package fiap.controller;

import java.sql.*;
import fiap.model.*;
import java.util.*;

public class RecrutadorController {

	public String insereRecrutador(int id, String nome, String email, String senha, String tipoUsuario, String cpf,
			String nomeEmpresa, String cargo) {
		String resultado, resultado2;
		Connection con = Conexao.abrirConexao();
		RegistroRecrutadorDAO rrd = new RegistroRecrutadorDAO(con);
		RegistroRecrutador rr = new RegistroRecrutador();
		try {
			rr.setIdRegistroGeral(id);
			rr.setNomeCompleto(nome);
			rr.setEmail(email);
			rr.setSenha(senha);
			rr.setTipoUsuario(tipoUsuario);
			rr.setNumeroCPF(cpf);
			rr.setNomeEmpresa(nomeEmpresa);
			rr.setCargoRecrutador(cargo);
			resultado = rrd.inserirRegistro(rr);
			resultado2 = rrd.inserirUsuario(rr);
			Conexao.fecharConexao(con);
			if (resultado == "Inserido com sucesso" && resultado2 == "Inserido com sucesso") {
				return "Cadastrado com sucesso!";
			} else {
				return "Erro ao Cadatrar";
			}

		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alteraRecrutador(int id, String nome, String email, String senha, String tipoUsuario, String cpf,
			String nomeEmpresa, String cargo) {
		String resultado, resultado2;
		Connection con = Conexao.abrirConexao();
		RegistroRecrutadorDAO rrd = new RegistroRecrutadorDAO(con);
		RegistroRecrutador rr = new RegistroRecrutador();
		try {
			rr.setIdRegistroGeral(id);
			rr.setNomeCompleto(nome);
			rr.setEmail(email);
			rr.setSenha(senha);
			rr.setTipoUsuario(tipoUsuario);
			rr.setNumeroCPF(cpf);
			rr.setNomeEmpresa(nomeEmpresa);
			rr.setCargoRecrutador(cargo);
			resultado = rrd.alterarRegistro(rr);
			resultado2 = rrd.alterarUsuario(rr);
			Conexao.fecharConexao(con);
			if (resultado == "Alterado com sucesso!" && resultado2 == "Alterado com sucesso!") {
				return "Alteração feita com sucesso!";
			} else {
				return "Erro ao alterar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String excluiRecrutador(int id) {
		String resultado, resultado2;
		Connection con = Conexao.abrirConexao();
		RegistroRecrutadorDAO rrd = new RegistroRecrutadorDAO(con);
		RegistroRecrutador rr = new RegistroRecrutador();
		try {
			rr.setIdRegistroGeral(id);
			resultado = rrd.excluirUsuario(rr);
			resultado2 = rrd.excluirRegistro(rr);
			Conexao.fecharConexao(con);
			if (resultado == "Excluido com sucesso!" && resultado2 == "Excluido com sucesso!") {
				return "Exclusão feita com sucesso!";
			} else {
				return "Erro ao excluir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String listaRecrutador(int id) {
		Connection con = Conexao.abrirConexao();
		RegistroRecrutadorDAO rrd = new RegistroRecrutadorDAO(con);
		try {
			ArrayList<RegistroRecrutador> lista = rrd.listarUm(id);
			String dados = "Lista de Recrutadores:\n\n";
			if (lista != null) {
				for (RegistroRecrutador registroRecrutador : lista) {
					dados += "ID Registro Geral: " + registroRecrutador.getIdRegistroGeral() + "\n";
					dados += "Tipo Usuario: " + registroRecrutador.getTipoUsuario() + "\n";
					dados += "Nome Completo: " + registroRecrutador.getNomeCompleto() + "\n";
					dados += "Email: " + registroRecrutador.getEmail() + "\n";
					dados += "Senha: " + registroRecrutador.getSenha() + "\n";
					dados += "CPF: " + registroRecrutador.getNumeroCPF() + "\n";
					dados += "Nome Empresa: " + registroRecrutador.getNomeEmpresa() + "\n";
					dados += "Cargo: " + registroRecrutador.getCargoRecrutador() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String listaRecrutadores() {
		Connection con = Conexao.abrirConexao();
		RegistroRecrutadorDAO rrd = new RegistroRecrutadorDAO(con);
		try {
			ArrayList<RegistroRecrutador> lista = rrd.listarTodos();
			String dados = "Lista de Recrutadores:\n\n";
			if (lista != null) {
				for (RegistroRecrutador registroRecrutador : lista) {
					dados += "ID Registro Geral: " + registroRecrutador.getIdRegistroGeral() + "\n";
					dados += "Tipo Usuario: " + registroRecrutador.getTipoUsuario() + "\n";
					dados += "Nome Completo: " + registroRecrutador.getNomeCompleto() + "\n";
					dados += "Email: " + registroRecrutador.getEmail() + "\n";
					dados += "Senha: " + registroRecrutador.getSenha() + "\n";
					dados += "CPF: " + registroRecrutador.getNumeroCPF() + "\n";
					dados += "Nome Empresa: " + registroRecrutador.getNomeEmpresa() + "\n";
					dados += "Cargo: " + registroRecrutador.getCargoRecrutador() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

}
