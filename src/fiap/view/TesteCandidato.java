package fiap.view;

import java.time.LocalDate;

import javax.swing.JOptionPane;
import fiap.controller.*;

public class TesteCandidato {
	public static void main(String[] args) {
		
		CandidatoController candidato = new CandidatoController();
		
		// testando inserir dados
		//JOptionPane.showMessageDialog(null, candidato.insereCandidato(2, "Daniel", "zeus@gmail.com", "abc123", "C", 
		//		"35481584880", "565327777", LocalDate.parse("1998-05-01"), "H", "ENSINO MÉDIO COMPLETO", "S", "Front-End"));
		
		// Altera Candidato
		//JOptionPane.showMessageDialog(null, candidato.alteraCandidato(1, "Daniel", "zeus@gmail.com", "abc123", "C", 
		//		"35481584880", "565327777", LocalDate.parse("1998-05-01"), "H", "POS GRADUADO OU MESTRADO", "C", "Back-End"));
		
		// Excluir Candidato
		//JOptionPane.showMessageDialog(null, candidato.excluiCandidato(1));
		
		//JOptionPane.showMessageDialog(null, candidato.excluiCandidato(32));
		
		//JOptionPane.showMessageDialog(null, candidato.listaCandidato(1));
		
		//JOptionPane.showMessageDialog(null, candidato.listaCandidatos());
		
		
		
	}

}
