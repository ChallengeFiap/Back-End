package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import fiap.controller.CursosController;
import fiap.controller.LinkController;

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
				LinkController link = new LinkController();
				if (tfIdLink.getText().equals("") || tfIdRegistroGeral.getText().equals("")
						|| tfDsLink.getText().equals("") || tfTpLink.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdLink.getText());
					int idGeral = Integer.parseInt(tfIdRegistroGeral.getText());
					JOptionPane.showMessageDialog(null,
							link.insereLink(id, idGeral, tfDsLink.getText(), tfTpLink.getText()));
					tfIdLink.setText("");
					tfIdRegistroGeral.setText("");
					tfDsLink.setText("");
					tfTpLink.setText("");
				}
				
			}
		});
		
		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkController link = new LinkController();
				if (tfIdLink.getText().equals("") || tfIdRegistroGeral.getText().equals("")
						|| tfDsLink.getText().equals("") || tfTpLink.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdLink.getText());
					int idGeral = Integer.parseInt(tfIdRegistroGeral.getText());
					JOptionPane.showMessageDialog(null,
							link.alteraLink(id, idGeral, tfDsLink.getText(), tfTpLink.getText()));
					tfIdLink.setText("");
					tfIdRegistroGeral.setText("");
					tfDsLink.setText("");
					tfTpLink.setText("");
				}
				
			}
		});
		
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkController link = new LinkController();
				if (tfIdLink.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Link");
				} else {
					int id = Integer.parseInt(tfIdLink.getText());
					int idGeral = Integer.parseInt(tfIdRegistroGeral.getText());
					JOptionPane.showMessageDialog(null,
							link.excluiLink(id));
					tfIdLink.setText("");
					tfIdRegistroGeral.setText("");
					tfDsLink.setText("");
					tfTpLink.setText("");
				}
				
			}
		});
		
		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkController link = new LinkController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfIdLink.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Link");
					tfIdLink.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdLink.getText());
					dados = link.listaUmLink(id);
					if (dados != null) {
						tfIdRegistroGeral.setText(dados.get(1));
						tfDsLink.setText(dados.get(3));
						tfTpLink.setText(dados.get(2));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
					
				}
				
			}
		});
		
		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkController link = new LinkController();
				String dados = link.listaLinks();
				JOptionPane.showMessageDialog(null, dados);
				
			}
		});
		
	}
	
}
