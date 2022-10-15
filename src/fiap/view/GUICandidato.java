package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

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
		
		//Instanciando Botões 
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
		
		//set Bounds Botões
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
				// TODO Auto-generated method stub
				
			}
		});
		
		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
