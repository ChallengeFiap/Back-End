package fiap.controller;

/**Classe Controller para para chamar a Classe DAO do objeto, do tipo Candidato
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
 */

import java.sql.*;
import java.time.LocalDate;
import java.util.*;


import fiap.model.*;

public class CandidatoController {
	
	/**Metodo para inserir os dados do GUI e mandar para o DAO
	 * @author Luis Felipe
	 * @param id, nome, email, senha, tipoUsuario, cpf, rg, dataNascimento, sexo, escolaridade, estadoCivil, Cargo
	 * @return Mensagem com Sucesso ou Fracasso
	 */
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
	
	/**Metodo para inserir os dados do GUI e altera no o DAO
	 * @author Luis Felipe
	 * @param id, nome, email, senha, tipoUsuario, cpf, rg, dataNascimento, sexo, escolaridade, estadoCivil, Cargo
	 * @return Mensagem com Sucesso ou Fracasso
	 */
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
				return "Alteracao feita com sucesso!";
			} else {
				return "Erro ao alterar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	/**Metodo para excluir os dados no DAO
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	 */
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
				return "Exclusao feita com sucesso!";
			} else {
				return "Erro ao excluir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para trazer os dados de um Candidato no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	 */
	public ArrayList<String> listaCandidato(int id) {
		Connection con = Conexao.abrirConexao();
		RegistroCandidatoDAO rcd = new RegistroCandidatoDAO(con);
		try {
			ArrayList<RegistroCandidato> lista = rcd.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (RegistroCandidato registroCandidato : lista) {
					dados.add("" + registroCandidato.getIdRegistroGeral());
					dados.add(registroCandidato.getTipoUsuario());
					dados.add(registroCandidato.getNomeCompleto());
					dados.add(registroCandidato.getEmail());
					dados.add(registroCandidato.getSenha());
					dados.add(registroCandidato.getNumeroCPF());
					dados.add(registroCandidato.getNumeroRG());
					dados.add("" + registroCandidato.getDataNascimento());
					dados.add(registroCandidato.getSexo());
					dados.add(registroCandidato.getEscolaridade());
					dados.add(registroCandidato.getEstadoCivil());
					dados.add(registroCandidato.getCargo());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**Metodo para trazer os dados de todos os Candidatos no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @return Mensagem com Sucesso ou Fracasso
	 */
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
