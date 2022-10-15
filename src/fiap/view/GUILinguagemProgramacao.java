package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class GUILinguagemProgramacao extends JPanel{

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdLinguagemProg, lbTpLinguagem;
	private JTextField tfIdLinguagemProg, tfTpLinguagem;
	
	public GUILinguagemProgramacao() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.CYAN);

		
		//Instanciando Botões 
		btInserir = new JButton("Inserir");
		btUpdate = new JButton("Atualizar");
		btExcluir = new JButton("Excluir");		
		btSelectById = new JButton("Select ID");
		btSelectAll = new JButton("SelectAll");
		
		//Instanciando Labels
		lbIdLinguagemProg = new JLabel("ID Linguagem Programacao:");
		lbTpLinguagem = new JLabel("Linguagem de Programacao:");
		
		//Instanciando Text Field
		tfIdLinguagemProg = new JTextField();
		tfTpLinguagem = new JTextField();


		
		//Set Bouds labels
		lbIdLinguagemProg.setBounds(25, 30, 170, 25);
		lbTpLinguagem.setBounds(25, 65, 170, 25);

		
		//set Bounds Text Fields
		tfIdLinguagemProg.setBounds(200, 30, 200, 25);
		tfTpLinguagem.setBounds(200, 65, 200, 25);

		
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
		
		add(lbIdLinguagemProg);
		add(lbTpLinguagem);

		add(tfIdLinguagemProg);
		add(tfTpLinguagem);

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
