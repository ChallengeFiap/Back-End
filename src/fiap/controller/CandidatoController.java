package fiap.controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;


import fiap.model.*;

public class CandidatoController {
	
	public String insereCandidato(int id, String nome, String email, String senha, String tipoUsuario, String cpf,
			String rg, LocalDate dataNascimento, String sexo, String escolaridade, String estadoCivil, String Cargo) {
		String resultado, resultado2;
		Connection con = Conexao.abrirConexao();
		RegistroCandidatoDAO rcd = new RegistroCandidatoDAO(con);
		RegistroCandidato rc = new RegistroCandidato();
		try {
			rc.setIdRegistroGeral(id);
			rc.setNomeCompleto(nome);
			rc.setEmail(email);
			rc.setSenha(senha);
			rc.setTipoUsuario(tipoUsuario);
			rc.setNumeroCPF(cpf);
			rc.setNumeroRG(rg);
			rc.setDataNascimento(dataNascimento);
			rc.setSexo(sexo);
			rc.setEscolaridade(escolaridade);
			rc.setEstadoCivil(estadoCivil);
			rc.setCargo(Cargo);
			resultado = rcd.inserirRegistro(rc);
			resultado2 = rcd.inserirUsuario(rc);
			System.out.println(resultado);
			System.out.println(resultado2);
			Conexao.fecharConexao(con);
			if (resultado == "Inserido com sucesso." && resultado2 == "Inserido com sucesso.") {
				return "Cadastrado com sucesso!";
			} else {
				return "Erro ao Cadatrar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String alteraCandidato(int id, String nome, String email, String senha, String tipoUsuario, String cpf,
			String rg, LocalDate dataNascimento, String sexo, String escolaridade, String estadoCivil, String Cargo) {
		String resultado, resultado2;
		Connection con = Conexao.abrirConexao();
		RegistroCandidatoDAO rcd = new RegistroCandidatoDAO(con);
		RegistroCandidato rc = new RegistroCandidato();
		try {
			rc.setIdRegistroGeral(id);
			rc.setNomeCompleto(nome);
			rc.setEmail(email);
			rc.setSenha(senha);
			rc.setTipoUsuario(tipoUsuario);
			rc.setNumeroCPF(cpf);
			rc.setNumeroRG(rg);
			rc.setDataNascimento(dataNascimento);
			rc.setSexo(sexo);
			rc.setEscolaridade(escolaridade);
			rc.setEstadoCivil(estadoCivil);
			rc.setCargo(Cargo);
			resultado = rcd.alterarRegistro(rc);
			resultado2 = rcd.alterarUsuario(rc);
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
	
	public String excluiCandidato(int id) {
		String resultado, resultado2;
		Connection con = Conexao.abrirConexao();
		RegistroCandidatoDAO rcd = new RegistroCandidatoDAO(con);
		RegistroCandidato rc = new RegistroCandidato();
		try {
			rc.setIdRegistroGeral(id);
			resultado = rcd.excluirUsuario(rc);
			resultado2 = rcd.excluirRegistro(rc);
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
	
	public String listaCandidato(int id) {
		Connection con = Conexao.abrirConexao();
		RegistroCandidatoDAO rcd = new RegistroCandidatoDAO(con);
		try {
			ArrayList<RegistroCandidato> lista = rcd.listarUm(id);
			String dados = "Lista de Candidatos:\n\n";
			if (lista != null) {
				for (RegistroCandidato registroCandidato : lista) {
					dados += "ID Registro Geral: " + registroCandidato.getIdRegistroGeral() + "\n";
					dados += "Tipo Usuario: " + registroCandidato.getTipoUsuario() + "\n";
					dados += "Nome Completo: " + registroCandidato.getNomeCompleto() + "\n";
					dados += "Email: " + registroCandidato.getEmail() + "\n";
					dados += "Senha: " + registroCandidato.getSenha() + "\n";
					dados += "CPF: " + registroCandidato.getNumeroCPF() + "\n";
					dados += "RG: " + registroCandidato.getNumeroRG() + "\n";
					dados += "Data Nascimento: " + registroCandidato.getDataNascimento() + "\n";
					dados += "Sexo: " + registroCandidato.getSexo() + "\n";
					dados += "Escolaridade: " + registroCandidato.getEscolaridade() + "\n";
					dados += "Estado Civil: " + registroCandidato.getEstadoCivil() + "\n";
					dados += "Cargo: " + registroCandidato.getCargo() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
	public String listaCandidatos() {
		Connection con = Conexao.abrirConexao();
		RegistroCandidatoDAO rcd = new RegistroCandidatoDAO(con);
		try {
			ArrayList<RegistroCandidato> lista = rcd.listarTodos();
			String dados = "Lista de Candidatos:\n\n";
			if (lista != null) {
				for (RegistroCandidato registroCandidato : lista) {
					dados += "ID Registro Geral: " + registroCandidato.getIdRegistroGeral() + "\n";
					dados += "Tipo Usuario: " + registroCandidato.getTipoUsuario() + "\n";
					dados += "Nome Completo: " + registroCandidato.getNomeCompleto() + "\n";
					dados += "Email: " + registroCandidato.getEmail() + "\n";
					dados += "Senha: " + registroCandidato.getSenha() + "\n";
					dados += "CPF: " + registroCandidato.getNumeroCPF() + "\n";
					dados += "RG: " + registroCandidato.getNumeroRG() + "\n";
					dados += "Data Nascimento: " + registroCandidato.getDataNascimento() + "\n";
					dados += "Sexo: " + registroCandidato.getSexo() + "\n";
					dados += "Escolaridade: " + registroCandidato.getEscolaridade() + "\n";
					dados += "Estado Civil: " + registroCandidato.getEstadoCivil() + "\n";
					dados += "Cargo: " + registroCandidato.getCargo() + "\n\n";
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	

}
