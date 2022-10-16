package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

import fiap.controller.CandidatoController;
import fiap.controller.LinguagemCandidatoController;

@SuppressWarnings({ "serial", "unused" })
public class GUILinguagemCandidato extends JPanel{

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdLinguagemCandidato, lbIdLinguagemProg, lbIdRegistroGeral, lbDtInicio, lbFlProficiencia;
	private JTextField tfIdLinguagemCandidato, tfIdLinguagemProg, tfIdRegistroGeral, tfDtInicio, tfFlProficiencia;
	
	public GUILinguagemCandidato() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.orange);
		
		//Instanciando Bot�es 
		btInserir = new JButton("Inserir");
		btUpdate = new JButton("Atualizar");
		btExcluir = new JButton("Excluir");		
		btSelectById = new JButton("Select ID");
		btSelectAll = new JButton("SelectAll");
		
		//Instanciando Labels
		lbIdLinguagemCandidato = new JLabel("ID Linguagem Candidato:");
		lbIdLinguagemProg = new JLabel("ID Linguagem Programacao:");
		lbIdRegistroGeral = new JLabel("ID Geral: ");
		lbDtInicio = new JLabel("Data Inicio: ");
		lbFlProficiencia = new JLabel("Nivel de Conhecimento: ");
		
		//Instanciando Text Field
		tfIdLinguagemCandidato = new JTextField();
		tfIdLinguagemProg = new JTextField();
		tfIdRegistroGeral = new JTextField();
		tfDtInicio = new JTextField();
		tfFlProficiencia = new JTextField();
		
		//Set Bouds labels
		lbIdLinguagemCandidato.setBounds(25, 30, 150, 25);
		lbIdLinguagemProg.setBounds(25, 65, 170, 25);
		lbIdRegistroGeral.setBounds(25, 100, 150, 25);
		lbDtInicio.setBounds(25, 135, 150, 25);
		lbFlProficiencia.setBounds(25, 170, 150, 25);
		
		//set Bounds Text Fields
		tfIdLinguagemCandidato.setBounds(170, 30, 200, 25);
		tfIdLinguagemProg.setBounds(190, 65, 180, 25);
		tfIdRegistroGeral.setBounds(170, 100, 200, 25);
		tfDtInicio.setBounds(170, 135, 200, 25);
		tfFlProficiencia.setBounds(170, 170, 200, 25);
		
		//set Bounds Bot�es
		btInserir.setBounds(100, 460, 100, 25);
		btUpdate.setBounds(220, 460, 100, 25);
		btExcluir.setBounds(340, 460, 100, 25);
		btSelectById.setBounds(460, 460, 100, 25);
		btSelectAll.setBounds(580, 460, 100, 25);
		
		//Add os elementos
		add(btInserir);
		add(btUpdate);
		add(btExcluir);
		add(btSelectById);
		add(btSelectAll);
		
		add(lbIdLinguagemCandidato);
		add(lbIdLinguagemProg);
		add(lbIdRegistroGeral);
		add(lbDtInicio);
		add(lbFlProficiencia);
		
		add(tfIdLinguagemCandidato);
		add(tfIdLinguagemProg);
		add(tfIdRegistroGeral);
		add(tfDtInicio);
		add(tfFlProficiencia);
	}
	
	
	private void definirEventos() {

		btInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinguagemCandidatoController linCand = new LinguagemCandidatoController();
				if (tfIdLinguagemCandidato.getText().equals("") || 
						tfIdLinguagemProg.getText().equals("") || 
						tfIdRegistroGeral.getText().equals("") ||
						tfDtInicio.getText().equals("") ||
						tfFlProficiencia.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdLinguagemCandidato.getText());
					int idLingProg = Integer.parseInt(tfIdLinguagemProg.getText());
					int idRegistro = Integer.parseInt(tfIdRegistroGeral.getText());
					String aux = tfDtInicio.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataI = LocalDate.parse(data);
					JOptionPane.showMessageDialog(null, linCand.insereLinguagemCandidato(id, idLingProg, 
							idRegistro, dataI, tfFlProficiencia.getText()));
					tfIdLinguagemCandidato.setText("");
					tfIdLinguagemProg.setText("");
					tfIdRegistroGeral.setText("");
					tfDtInicio.setText("");
					tfFlProficiencia.setText("");
				}
				
			}
		});
		
		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinguagemCandidatoController linCand = new LinguagemCandidatoController();
				if (tfIdLinguagemCandidato.getText().equals("") || 
						tfIdLinguagemProg.getText().equals("") || 
						tfIdRegistroGeral.getText().equals("") ||
						tfDtInicio.getText().equals("") ||
						tfFlProficiencia.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdLinguagemCandidato.getText());
					int idLingProg = Integer.parseInt(tfIdLinguagemProg.getText());
					int idRegistro = Integer.parseInt(tfIdRegistroGeral.getText());
					String aux = tfDtInicio.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataI = LocalDate.parse(data);
					JOptionPane.showMessageDialog(null, linCand.alteraLinguagemCandidato(id, idLingProg, 
							idRegistro, dataI, tfFlProficiencia.getText()));
					tfIdLinguagemCandidato.setText("");
					tfIdLinguagemProg.setText("");
					tfIdRegistroGeral.setText("");
					tfDtInicio.setText("");
					tfFlProficiencia.setText("");
				}
				
			}
		});
		
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinguagemCandidatoController linCand = new LinguagemCandidatoController();
				if (tfIdLinguagemCandidato.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Linguagem do Candidato");
					tfIdLinguagemCandidato.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdLinguagemCandidato.getText());
					JOptionPane.showMessageDialog(null, linCand.excluiLinguagemCandidato(id));
					tfIdLinguagemCandidato.setText("");
					tfIdLinguagemProg.setText("");
					tfIdRegistroGeral.setText("");
					tfDtInicio.setText("");
					tfFlProficiencia.setText("");
				}
			}
		});
		
		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinguagemCandidatoController linCand = new LinguagemCandidatoController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfIdLinguagemCandidato.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Linguagem do Candidato");
					tfIdLinguagemCandidato.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdLinguagemCandidato.getText());
					dados = linCand.listaUmaLinguagemCandidato(id);
					if (dados != null) {
						tfIdLinguagemProg.setText(dados.get(1));
						tfIdRegistroGeral.setText(dados.get(2));
						
						String aux = dados.get(3);
						String data = aux.substring(8, 10) + "/";
						data += aux.substring(5, 7) + "/";
						data += aux.substring(0, 4);
						
						tfDtInicio.setText(data);
						tfFlProficiencia.setText(dados.get(4));
						
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
					
				}
				
			}
		});
		
		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinguagemCandidatoController linCand = new LinguagemCandidatoController();
				String dados = linCand.listaLinguagensCandidatos();
				JOptionPane.showMessageDialog(null, dados);
				
			}
		});
		
	}
}
