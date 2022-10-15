package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class GUIEstado extends JPanel{
	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdEstado, lbSgEstado, lbNmEstado;
	private JTextField tfIdEstado, tfSgEstado, tfNmEstado;
	
	public GUIEstado() {
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
		lbIdEstado = new JLabel("ID Estado:");
		lbSgEstado = new JLabel("Sigla Estado:");
		lbNmEstado = new JLabel("Nome Estado: ");

		
		//Instanciando Text Field
		tfIdEstado = new JTextField();
		tfSgEstado = new JTextField();
		tfNmEstado = new JTextField();

		
		//Set Bouds labels
		lbIdEstado.setBounds(25, 30, 100, 25);
		lbSgEstado.setBounds(25, 65, 100, 25);
		lbNmEstado.setBounds(25, 100, 100, 25);

		
		//set Bounds Text Fields
		tfIdEstado.setBounds(130, 30, 200, 25);
		tfSgEstado.setBounds(130, 65, 200, 25);
		tfNmEstado.setBounds(130, 100, 200, 25);

		
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
		
		add(lbIdEstado);
		add(lbSgEstado);
		add(lbNmEstado);
		
		add(tfIdEstado);
		add(tfSgEstado);
		add(tfNmEstado);

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
