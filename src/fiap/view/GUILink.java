package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class GUILink extends JPanel{

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdLink, lbIdRegistroGeral, lbDsLink, lbTpLink;
	private JTextField tfIdLink, tfIdRegistroGeral, tfDsLink, tfTpLink;
	
	public GUILink() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.orange);

		
		//Instanciando Botões 
		btInserir = new JButton("Inserir");
		btUpdate = new JButton("Atualizar");
		btExcluir = new JButton("Excluir");		
		btSelectById = new JButton("Select ID");
		btSelectAll = new JButton("SelectAll");
		
		//Instanciando Labels
		lbIdLink = new JLabel("ID Link:");
		lbIdRegistroGeral = new JLabel("ID Geral:");
		lbDsLink = new JLabel("Link: ");
		lbTpLink = new JLabel("Tipo Link: ");
		
		//Instanciando Text Field
		tfIdLink = new JTextField();
		tfIdRegistroGeral = new JTextField();
		tfDsLink = new JTextField();
		tfTpLink = new JTextField();
		
		//Set Bouds labels
		lbIdLink.setBounds(25, 30, 100, 25);
		lbIdRegistroGeral.setBounds(25, 65, 100, 25);
		lbDsLink.setBounds(25, 100, 100, 25);
		lbTpLink.setBounds(25, 135, 100, 25);
		
		//set Bounds Text Fields
		tfIdLink.setBounds(100, 30, 200, 25);
		tfIdRegistroGeral.setBounds(100, 65, 200, 25);
		tfDsLink.setBounds(100, 100, 200, 25);
		tfTpLink.setBounds(100, 135, 200, 25);
		
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
		
		add(lbIdLink);
		add(lbIdRegistroGeral);
		add(lbDsLink);
		add(lbTpLink);
		
		add(tfIdLink);
		add(tfIdRegistroGeral);
		add(tfDsLink);
		add(tfTpLink);
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
