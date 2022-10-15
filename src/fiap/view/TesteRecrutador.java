package fiap.view;

import javax.swing.JOptionPane;
import fiap.controller.*;


public class TesteRecrutador {
	public static void main(String[] args) {

		RecrutadorController recrutador = new RecrutadorController();

		// testando inserir dados
		//JOptionPane.showMessageDialog(null, recrutador.insereRecrutador(3, "Valdir da Silva", "valdir@gmail.com",
		//		"123abc", "R", "354.815.848-80", "IBM", "Desenvolvedor"));
		
		// testando alterar dados
		//JOptionPane.showMessageDialog(null, recrutador.alteraRecrutador(1, "Valdir SM", "vava@gmail.com",
		//		"13abc", "R", "354.815.848-80", "FIAP", "Desenvolvedor"));
		
		// testando excluir dados
		//JOptionPane.showMessageDialog(null, recrutador.excluiRecrutador(1));
		
		// Listar
		//JOptionPane.showMessageDialog(null, recrutador.listaRecrutador(1));
		
		JOptionPane.showMessageDialog(null, recrutador.listaRecrutadores());
		
		/*
		  Connection con = Conexao.abrirConexao();
		  RegistroRecrutadorDAO rrd = new RegistroRecrutadorDAO(con);
		  RegistroRecrutador rr = new RegistroRecrutador();
		 
		  try {
				rr.setIdRegistroGeral(20);
				rr.setNomeCompleto("Valdir Menezes");
				rr.setEmail("vdsm@gmail.com");
				rr.setSenha("12354abc");
				rr.setTipoUsuario("R");
				rr.setNumeroCPF("354.815.848-19");
				rr.setNomeEmpresa("TalentLinks");
				rr.setCargoRecrutador("Desenvolvedor");
				//System.out.println(rrd.excluirUsuario(rr));
				//System.out.println(rrd.excluirRegistro(rr));
				//System.out.println(rrd.listarUm(rr.getIdRegistroGeral()));
				ArrayList<RegistroRecrutador> lista = rrd.listarTodos();
				String dados = "Lista de Recrutadores:\n\n";
				if(lista != null) {
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
					JOptionPane.showMessageDialog(null, dados);
				}
				
				Conexao.fecharConexao(con);

			} catch (Exception e) {
				 System.out.println(e.getMessage());
			}
		
		 */
		 
	}

}
