package fiap.controller;

/**Classe Controller para para chamar a Classe DAO do objeto, do tipo Recrutador 
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
*/
import java.sql.*;
import fiap.model.*;
import java.util.*;

public class RecrutadorController {

	/**Metodo para inserir os dados do GUI e mandar para o DAO
	 * @author Luis Felipe
	 * @param idRecrutador, nome, email, senha, tipoUsuario, cpf, nomeEmpresa, cargo
	 * @return Mensagem com Sucesso ou Fracasso
	*/
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
	 * @param idRecrutador, nome, email, senha, tipoUsuario, cpf, nomeEmpresa, cargo
	 * @return Mensagem com Sucesso ou Fracasso
	*/
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
				return "Alteracao feita com sucesso!";
			} else {
				return "Erro ao alterar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**Metodo para para excluir os dados no DAO
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/
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
				return "Exclusao feita com sucesso!";
			} else {
				return "Erro ao excluir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**Metodo para trazer os dados de um Recrutador no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @param id
	 * @return Mensagem com Sucesso ou Fracasso
	*/

	public ArrayList<String> listaRecrutador(int id) {
		Connection con = Conexao.abrirConexao();
		RegistroRecrutadorDAO rrd = new RegistroRecrutadorDAO(con);
		try {
			ArrayList<RegistroRecrutador> lista = rrd.listarUm(id);
			ArrayList<String> dados = new ArrayList<String>();
			if (lista != null) {
				for (RegistroRecrutador registroRecrutador : lista) {
					dados.add("" + registroRecrutador.getIdRegistroGeral());
					dados.add(registroRecrutador.getTipoUsuario());
					dados.add(registroRecrutador.getNomeCompleto());
					dados.add(registroRecrutador.getEmail());
					dados.add(registroRecrutador.getSenha());
					dados.add(registroRecrutador.getNumeroCPF());
					dados.add(registroRecrutador.getNomeEmpresa());
					dados.add(registroRecrutador.getCargoRecrutador());
				}
			}
			Conexao.fecharConexao(con);
			return dados;
		} catch (Exception e) {
			return null;
		}

	}

	/**Metodo para trazer os dados de todos os Recrutadores no DAO e mandar para o GUI
	 * @author Luis Felipe
	 * @return Mensagem com Sucesso ou Fracasso
	*/

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
