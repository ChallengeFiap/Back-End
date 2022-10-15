package fiap.view;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import fiap.controller.*;
import fiap.model.Conexao;
import fiap.model.FormacaoAcademica;
import fiap.model.FormacaoAcademicaDAO;
import fiap.model.Telefone;
import fiap.model.TelefoneDAO;

public class TesteGeral {
	public static void main(String[] args) {
		
		
		// TELEFONE
		
		//TelefoneController tc = new TelefoneController();
		
		//JOptionPane.showMessageDialog(null, tc.insereTelefone(3, 3, 111, 974609181, "A"));
		
		//JOptionPane.showMessageDialog(null, tc.alteraTelefone(3, 3, 20, 974609488, "A"));
		
		//JOptionPane.showMessageDialog(null, tc.excluiTelefone(2));
		
		//JOptionPane.showMessageDialog(null, tc.listaUmTelefone(1));
		
		//JOptionPane.showMessageDialog(null, tc.listaTelefones());
		
		
		// ESTADO
		
		//EstadoController ec = new EstadoController();
		
		//JOptionPane.showMessageDialog(null, ec.insereEstado(3, "RJ", "Rio de Janeiro"));
		
		//JOptionPane.showMessageDialog(null, ec.alteraEstado(1, "MG", "Minas Gerais"));
		
		//JOptionPane.showMessageDialog(null, ec.excluiEstado(1));
		
		//JOptionPane.showMessageDialog(null, ec.listaUmEstado(1));
		
		//JOptionPane.showMessageDialog(null, ec.listaEstados());
		
		
		// CIDADE
		
		//CidadeController cc = new CidadeController();
		
		//JOptionPane.showMessageDialog(null, cc.insereCidade(2, 2, 1, "Carapicuiba"));
		
		//JOptionPane.showMessageDialog(null, cc.alteraCidade(1, 2, 1, "Barueri"));
		
		//JOptionPane.showMessageDialog(null, cc.excluiCidade(1));
		
		//JOptionPane.showMessageDialog(null, cc.listaUmaCidade(1));
		
		//JOptionPane.showMessageDialog(null, cc.listaCidades());
		
		
		// LINGUAGEM DE PROGRAMAÇÃO
		
		//LinguagemController lc = new LinguagemController();
		
		//JOptionPane.showMessageDialog(null, lc.insereLinguagem(2, "C#"));
		
		//JOptionPane.showMessageDialog(null, lc.alteraLinguagem(1, "Python"));
				
		//JOptionPane.showMessageDialog(null, lc.excluiLinguagem(2));
				
		//JOptionPane.showMessageDialog(null, lc.listaUmaLinguagem(1));
				
		//JOptionPane.showMessageDialog(null, lc.listaLinguagens());
		
		
		// LINGUAGEM DE PROGRAMAÇÃO
		
		//LinguagemCandidatoController lcc = new LinguagemCandidatoController();
				
		//JOptionPane.showMessageDialog(null, lcc.insereLinguagemCandidato(2, 1, 2, LocalDate.parse("2022-05-05"), "PI"));
				
		//JOptionPane.showMessageDialog(null, lcc.alteraLinguagemCandidato(1, 1, 2, LocalDate.parse("2010-10-08"), "PI"));
						
		//JOptionPane.showMessageDialog(null, lcc.excluiLinguagemCandidato(1));
						
		//JOptionPane.showMessageDialog(null, lcc.listaUmaLinguagemCandidato(1));
		
		//JOptionPane.showMessageDialog(null, lcc.listaLinguagensCandidatos());
						
		//JOptionPane.showMessageDialog(null, lc.listaLinguagens());
		
		
		// LINK
		
		//LinkController lkc = new LinkController();
		
		//JOptionPane.showMessageDialog(null, lkc.insereLink(1, 2, "https://github.com/LuisFelipe", "Microsoft"));
		
		//JOptionPane.showMessageDialog(null, lkc.alteraLink(1, 2, "https://github.com/LuisFelipeGM", "GitHub"));
		
		//JOptionPane.showMessageDialog(null, lkc.excluiLink(1));
		
		//JOptionPane.showMessageDialog(null, lkc.listaUmLink(1));
		
		//JOptionPane.showMessageDialog(null, lkc.listaLinks());
		
		
		// FORMACAO ACADEMICA
		
		//FormacaoAcademicaController fac = new FormacaoAcademicaController();
		
		//JOptionPane.showMessageDialog(null, fac.insereFormacaoAcademica(2, 2, "FIAP", "XP", LocalDate.parse("2022-03-05"), 
		//		LocalDate.parse("2023-12-12"), "Analise e Desenvolvimento de Sistemas", "A", "A", "H", "02"));
		
		//JOptionPane.showMessageDialog(null, fac.alteraFormacaoAcademica(1, 2, "Anhembi", "Mentoria com o ITAU", LocalDate.parse("2022-03-05"), 
		//		LocalDate.parse("2023-12-12"), "Sistemas", "A", "A", "H", "02"));
		
		//JOptionPane.showMessageDialog(null, fac.excluirFormacaoAcademica(2));
		
		//JOptionPane.showMessageDialog(null, fac.listaUmaFormacaoAcademica(1));
		
		//JOptionPane.showMessageDialog(null, fac.listaFormacoesAcademicas());
		
		
	}

}
