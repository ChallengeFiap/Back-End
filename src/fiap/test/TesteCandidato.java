package fiap.test;
/**Classe para testar o Controller do Candidato
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
 */
import java.time.LocalDate;

import javax.swing.JOptionPane;
import fiap.controller.*;

public class TesteCandidato {
	public static void main(String[] args) {
		
		CandidatoController candidato = new CandidatoController();
		
		// testando inserir dados
		//JOptionPane.showMessageDialog(null, candidato.insereCandidato(4, "Ola", "zeus@gmail.com", "abc123", "C", 
		//		"35481584893", "565327756", LocalDate.parse("1998-05-01"), "H", "ENSINO M�DIO COMPLETO", "S", "Front-End"));
		
		// Altera Candidato
		//JOptionPane.showMessageDialog(null, candidato.alteraCandidato(4, "Daniel", "zeus@gmail.com", "abc123", "C", 
		//		"35481584880", "565327777", LocalDate.parse("1998-05-08"), "H", "POS GRADUADO OU MESTRADO", "C", "Back-End"));
		
		// Excluir Candidato
		//JOptionPane.showMessageDialog(null, candidato.excluiCandidato(1));
		
		//JOptionPane.showMessageDialog(null, candidato.excluiCandidato(32));
		
		//JOptionPane.showMessageDialog(null, candidato.listaCandidato(4));
		
		//JOptionPane.showMessageDialog(null, candidato.listaCandidatos());
		
		
		
	}

}
