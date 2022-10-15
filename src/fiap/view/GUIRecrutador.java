package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class GUIRecrutador extends JPanel{

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbRegistroGeral, lbNomeCompleto, lbSenha, lbEmail, lbTpUsuario, lbNrCPF;
	private JLabel lbNomeEmpresa, lbDsCargo;
	private JTextField tfRegistroGeral, tfNomeCompleto, tfSenha, tfEmail, tfTpUsuario, tfNrCPF;
	private JTextField tfNomeEmpresa, tfDsCargo;
	
	public GUIRecrutador() {
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
		lbNomeEmpresa = new JLabel("Nome da Empresa: ");
		lbDsCargo = new JLabel("Cargo: ");
		
		//Instanciando Text Field
		tfRegistroGeral = new JTextField();
		tfNomeCompleto = new JTextField();
		tfSenha = new JTextField();
		tfEmail = new JTextField();
		tfTpUsuario = new JTextField();
		tfNrCPF = new JTextField();
		tfNomeEmpresa = new JTextField();
		tfDsCargo= new JTextField();
		
		
		
		//Set Bouds labels
		lbRegistroGeral.setBounds(25, 30, 100, 25);
		lbNomeCompleto.setBounds(25, 65, 100, 25);
		lbSenha.setBounds(25, 100, 100, 25);
		lbEmail.setBounds(25, 135, 100, 25);
		lbTpUsuario.setBounds(25, 170, 100, 25);
		lbNrCPF.setBounds(25, 205, 100, 25);
		lbNomeEmpresa.setBounds(25, 240, 120, 25);
		lbDsCargo.setBounds(25, 275, 100, 25);
		
		//set Bounds Text Fields
		tfRegistroGeral.setBounds(130, 30, 200, 25);
		tfNomeCompleto.setBounds(130, 65, 200, 25);
		tfSenha.setBounds(130, 100, 200, 25);
		tfEmail.setBounds(130, 135, 200, 25);
		tfTpUsuario.setBounds(130, 170, 200, 25);
		tfNrCPF.setBounds(130, 205, 200, 25);
		tfNomeEmpresa.setBounds(150, 240, 180, 25);
		tfDsCargo.setBounds(130, 275, 200, 25);
		
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
		add(lbNomeEmpresa);
		add(lbDsCargo);
		
		add(tfRegistroGeral);
		add(tfNomeCompleto);
		add(tfSenha);
		add(tfEmail);
		add(tfTpUsuario);
		add(tfNrCPF);
		add(tfNomeEmpresa);
		add(tfDsCargo);

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
