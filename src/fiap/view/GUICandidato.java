package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.*;

import fiap.controller.CandidatoController;

@SuppressWarnings({ "serial", "unused" })
public class GUICandidato extends JPanel{
	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbRegistroGeral, lbNomeCompleto, lbSenha, lbEmail, lbTpUsuario, lbNrCPF;
	private JLabel lbNrRG, lbDtNascimento, lbSexoBiologico, lbTpEscolaridade, lbEstadoCivil, lbCargo;
	private JTextField tfRegistroGeral, tfNomeCompleto, tfSenha, tfEmail, tfTpUsuario, tfNrCPF;
	private JTextField tfNrRG, tfDtNascimento, tfSexoBiologico, tfTpEscolaridade, tfEstadoCivicl, tfCargo;
	
	public GUICandidato() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		//Instanciando Bot�es 
		btInserir = new JButton("Inserir");
		btUpdate = new JButton("Atualizar");
		btExcluir = new JButton("Excluir");		
		btSelectById = new JButton("Select ID");
		btSelectAll = new JButton("SelectAll");
		
		//Instanciando Labels
		lbRegistroGeral = new JLabel("ID Registo Geral:");
		lbNomeCompleto = new JLabel("Nome Completo:");
		lbSenha = new JLabel("Senha: ");
		lbEmail = new JLabel("Email: ");
		lbTpUsuario = new JLabel("Tipo Usuario: ");
		lbNrCPF = new JLabel("CPF: ");
		lbNrRG = new JLabel("RG: ");
		lbDtNascimento = new JLabel("Data de Nascimento:");
		lbSexoBiologico = new JLabel("Sexo:");
		lbTpEscolaridade = new JLabel("Escolaridade:");
		lbEstadoCivil = new JLabel("Estado Civil:");
		lbCargo = new JLabel("Cargo:");	
		
		//Instanciando Text Field
		tfRegistroGeral = new JTextField();
		tfNomeCompleto = new JTextField();
		tfSenha = new JTextField();
		tfEmail = new JTextField();
		tfTpUsuario = new JTextField();
		tfNrCPF = new JTextField();
		tfNrRG = new JTextField();
		tfDtNascimento = new JTextField();
		tfSexoBiologico = new JTextField();
		tfTpEscolaridade = new JTextField();
		tfEstadoCivicl = new JTextField();
		tfCargo = new JTextField();
		
		//Set Bouds labels
		lbRegistroGeral.setBounds(25, 30, 100, 25);
		lbNomeCompleto.setBounds(25, 65, 100, 25);
		lbSenha.setBounds(25, 100, 100, 25);
		lbEmail.setBounds(25, 135, 100, 25);
		lbTpUsuario.setBounds(25, 170, 100, 25);
		lbNrCPF.setBounds(25, 205, 100, 25);
		lbNrRG.setBounds(25, 240, 100, 25);
		lbDtNascimento.setBounds(25, 275, 120, 25);
		lbSexoBiologico.setBounds(25, 310, 100, 25);
		lbTpEscolaridade.setBounds(25, 345, 100, 25);
		lbEstadoCivil.setBounds(25, 380, 100, 25);
		lbCargo.setBounds(25, 415, 100, 25);
		
		//set Bounds Text Fields
		tfRegistroGeral.setBounds(130, 30, 200, 25);
		tfNomeCompleto.setBounds(130, 65, 200, 25);
		tfSenha.setBounds(130, 100, 200, 25);
		tfEmail.setBounds(130, 135, 200, 25);
		tfTpUsuario.setBounds(130, 170, 200, 25);
		tfNrCPF.setBounds(130, 205, 200, 25);
		tfNrRG.setBounds(130, 240, 200, 25);
		tfDtNascimento.setBounds(150, 275, 180, 25);
		tfSexoBiologico.setBounds(130, 310, 200, 25);
		tfTpEscolaridade.setBounds(130, 345, 200, 25);
		tfEstadoCivicl.setBounds(130, 380, 200, 25);
		tfCargo.setBounds(130, 415, 200, 25);
		
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
		
		add(lbRegistroGeral);
		add(lbNomeCompleto);
		add(lbSenha);
		add(lbEmail);
		add(lbTpUsuario);
		add(lbNrCPF);
		add(lbNrRG);
		add(lbDtNascimento);
		add(lbSexoBiologico);
		add(lbSexoBiologico);
		add(lbTpEscolaridade);
		add(lbEstadoCivil);
		add(lbCargo);
		
		add(tfRegistroGeral);
		add(tfNomeCompleto);
		add(tfSenha);
		add(tfEmail);
		add(tfTpUsuario);
		add(tfNrCPF);
		add(tfNrRG);
		add(tfDtNascimento);
		add(tfSexoBiologico);
		add(tfTpEscolaridade);
		add(tfEstadoCivicl);
		add(tfCargo);
	}
	
	private void definirEventos() {

		btInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidatoController candidato = new CandidatoController();
				if (tfRegistroGeral.getText().equals("") || tfNomeCompleto.getText().equals("")
						|| tfSenha.getText().equals("") || tfEmail.getText().equals("")
						|| tfTpUsuario.getText().equals("") || tfNrCPF.getText().equals("")
						|| tfNrRG.getText().equals("") || tfDtNascimento.getText().equals("")
						|| tfSexoBiologico.getText().equals("") || tfTpEscolaridade.getText().equals("")
						|| tfEstadoCivicl.getText().equals("") || tfCargo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfRegistroGeral.getText());
					String aux = tfDtNascimento.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataN = LocalDate.parse(data);
					JOptionPane.showMessageDialog(null,
							candidato.insereCandidato(id, tfNomeCompleto.getText(), tfEmail.getText(), tfSenha.getText(),
									tfTpUsuario.getText(), tfNrCPF.getText(), tfNrRG.getText(),
									dataN, tfSexoBiologico.getText(), tfTpEscolaridade.getText(),
									tfEstadoCivicl.getText(), tfCargo.getText()));
					tfRegistroGeral.setText("");
					tfNomeCompleto.setText("");
					tfSenha.setText("");
					tfEmail.setText("");
					tfTpUsuario.setText("");
					tfNrCPF.setText("");
					tfNrRG.setText("");
					tfDtNascimento.setText("");
					tfSexoBiologico.setText("");
					tfTpEscolaridade.setText("");
					tfEstadoCivicl.setText("");
					tfCargo.setText("");
				}
				
			}
		});
		
		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidatoController candidato = new CandidatoController();
				if (tfRegistroGeral.getText().equals("") || tfNomeCompleto.getText().equals("")
						|| tfSenha.getText().equals("") || tfEmail.getText().equals("")
						|| tfTpUsuario.getText().equals("") || tfNrCPF.getText().equals("")
						|| tfNrRG.getText().equals("") || tfDtNascimento.getText().equals("")
						|| tfSexoBiologico.getText().equals("") || tfTpEscolaridade.getText().equals("")
						|| tfEstadoCivicl.getText().equals("") || tfCargo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfRegistroGeral.getText());
					String aux = tfDtNascimento.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataN = LocalDate.parse(data);
					JOptionPane.showMessageDialog(null,
							candidato.alteraCandidato(id, tfNomeCompleto.getText(), tfEmail.getText(), tfSenha.getText(),
									tfTpUsuario.getText(), tfNrCPF.getText(), tfNrRG.getText(),
									dataN, tfSexoBiologico.getText(), tfTpEscolaridade.getText(),
									tfEstadoCivicl.getText(), tfCargo.getText()));
					tfRegistroGeral.setText("");
					tfNomeCompleto.setText("");
					tfSenha.setText("");
					tfEmail.setText("");
					tfTpUsuario.setText("");
					tfNrCPF.setText("");
					tfNrRG.setText("");
					tfDtNascimento.setText("");
					tfSexoBiologico.setText("");
					tfTpEscolaridade.setText("");
					tfEstadoCivicl.setText("");
					tfCargo.setText("");
				}
				
			}
		});
		
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidatoController candidato = new CandidatoController();
				if (tfRegistroGeral.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Candidato");
					tfRegistroGeral.requestFocus();
				} else {
					int id = Integer.parseInt(tfRegistroGeral.getText());
					JOptionPane.showMessageDialog(null, candidato.excluiCandidato(id));
					tfRegistroGeral.setText("");
					tfNomeCompleto.setText("");
					tfSenha.setText("");
					tfEmail.setText("");
					tfTpUsuario.setText("");
					tfNrCPF.setText("");
					tfNrRG.setText("");
					tfDtNascimento.setText("");
					tfSexoBiologico.setText("");
					tfTpEscolaridade.setText("");
					tfEstadoCivicl.setText("");
					tfCargo.setText("");

				}
				
			}
		});
		
		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidatoController candidato = new CandidatoController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfRegistroGeral.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Candidato");
					tfRegistroGeral.requestFocus();
				} else {
					int id = Integer.parseInt(tfRegistroGeral.getText());
					dados = candidato.listaCandidato(id);
					if (dados != null) {
						tfNomeCompleto.setText(dados.get(2));
						tfSenha.setText(dados.get(4));
						tfEmail.setText(dados.get(3));
						tfTpUsuario.setText(dados.get(1));
						tfNrCPF.setText(dados.get(5));
						tfNrRG.setText(dados.get(6));
						
						String aux = dados.get(7);
						String data = aux.substring(8, 10) + "/";
						data += aux.substring(5, 7) + "/";
						data += aux.substring(0, 4);
						
						tfDtNascimento.setText(data);
						tfSexoBiologico.setText(dados.get(8));
						tfTpEscolaridade.setText(dados.get(9));
						tfEstadoCivicl.setText(dados.get(10));
						tfCargo.setText(dados.get(11));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
					
				}
			}
		});
		
		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidatoController candidato = new CandidatoController();
				String dados = candidato.listaCandidatos();
				JOptionPane.showMessageDialog(null, dados);
				
			}
		});
		
	}
}
