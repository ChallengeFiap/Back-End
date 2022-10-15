package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class GUICursoCandidato extends JPanel{

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdCandCurso, lbIdCurso, lbIdRegistroGeral, lbDtInicio, lbDtTermino;
	private JTextField tfIdCandCurso, tfIdCurso, tfIdRegistroGeral, tfDtInicio, tfDtTermino;
	
	public GUICursoCandidato() {
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
		lbIdCandCurso = new JLabel("ID Candidato Curso:");
		lbIdCurso = new JLabel("ID Curso:");
		lbIdRegistroGeral = new JLabel("ID Geral: ");
		lbDtInicio = new JLabel("Data Inicio: ");
		lbDtTermino = new JLabel("Data Termino: ");
		
		//Instanciando Text Field
		tfIdCandCurso = new JTextField();
		tfIdCurso = new JTextField();
		tfIdRegistroGeral = new JTextField();
		tfDtInicio = new JTextField();
		tfDtTermino = new JTextField();
		
		//Set Bouds labels
		lbIdCandCurso.setBounds(25, 30, 150, 25);
		lbIdCurso.setBounds(25, 65, 170, 25);
		lbIdRegistroGeral.setBounds(25, 100, 150, 25);
		lbDtInicio.setBounds(25, 135, 150, 25);
		lbDtTermino.setBounds(25, 170, 150, 25);
		
		//set Bounds Text Fields
		tfIdCandCurso.setBounds(170, 30, 200, 25);
		tfIdCurso.setBounds(170, 65, 200, 25);
		tfIdRegistroGeral.setBounds(170, 100, 200, 25);
		tfDtInicio.setBounds(170, 135, 200, 25);
		tfDtTermino.setBounds(170, 170, 200, 25);
		
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
		
		add(lbIdCandCurso);
		add(lbIdCurso);
		add(lbIdRegistroGeral);
		add(lbDtInicio);
		add(lbDtTermino);
		
		add(tfIdCandCurso);
		add(tfIdCurso);
		add(tfIdRegistroGeral);
		add(tfDtInicio);
		add(tfDtTermino);
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
