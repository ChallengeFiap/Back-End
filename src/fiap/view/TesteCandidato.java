package fiap.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;

import fiap.controller.*;
import fiap.model.*;

public class TesteCandidato {
	public static void main(String[] args) {
		
		CandidatoController candidato = new CandidatoController();
		
		// testando inserir dados
		//JOptionPane.showMessageDialog(null, candidato.insereCandidato(1, "Daniel", "zeus@gmail.com", "abc123", "C", 
		//		"35481584880", "565327777", LocalDate.parse("1998-05-01"), "H", "ENSINO MÉDIO COMPLETO", "S", "Front-End"));
		
		// Altera Candidato
		//JOptionPane.showMessageDialog(null, candidato.alteraCandidato(1, "Daniel", "zeus@gmail.com", "abc123", "C", 
		//		"35481584880", "565327777", LocalDate.parse("1998-05-01"), "H", "POS GRADUADO OU MESTRADO", "C", "Back-End"));
		
		// Excluir Candidato
		//JOptionPane.showMessageDialog(null, candidato.excluiCandidato(1));
		
		//JOptionPane.showMessageDialog(null, candidato.excluiCandidato(32));
		
		//JOptionPane.showMessageDialog(null, candidato.listaCandidato(1));
		
		JOptionPane.showMessageDialog(null, candidato.listaCandidatos());
		
		/*
		
		Connection con = Conexao.abrirConexao();
		RegistroCandidatoDAO rcd = new RegistroCandidatoDAO(con);
		RegistroCandidato rc = new RegistroCandidato();
		
		try {
			//JOptionPane.showMessageDialog(null, rcd.listar());
			
			rc.setIdRegistroGeral(30);
			rc.setNomeCompleto("Zeus");
			rc.setEmail("zeus.gamer@gmail.com");
			rc.setSenha("11aa");
			rc.setTipoUsuario("C");
			rc.setNumeroCPF("35481584900");
			rc.setNumeroRG("565389159");
			rc.setDataNascimento(LocalDate.parse("1985-09-08"));
			rc.setSexo("H");
			rc.setEscolaridade("SUPERIOR INCOMPLETO");
			rc.setEstadoCivil("C");
			rc.setCargo("Front-End");
			//System.out.println(rcd.alterarRegistro(rc));
			//System.out.println(rcd.alterarUsuario(rc));
			
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
			JOptionPane.showMessageDialog(null, dados);
			Conexao.fecharConexao(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		*/
		
	}

}
