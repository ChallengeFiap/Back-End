package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class GUIFormacaoAcademica extends JPanel{

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdFormacaoAcademica, lbIdRegistroGeral, lbNmInstituicao, lbDsAtvExtraCur, lbDtInicio, lbDtTermino;
	private JLabel lbNmCurso, lbDsStatusCurso, lbDsEscolaridade, lbDsSemestre, lbFlCurso;
	private JTextField tfIdFormacaoAcademica, tfIdRegistroGeral, tfNmInstituicao, tfDsAtvExtraCur, tfDtInicio, tfDtTermino;
	private JTextField tfNmCurso, tfDsStatusCurso, tfDsEscolaridade, tfDsSemestre, tfFlCurso;
	
	public GUIFormacaoAcademica() {
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
		lbIdFormacaoAcademica = new JLabel("ID Formacao Academica:");
		lbIdRegistroGeral = new JLabel("ID Geral:");
		lbNmInstituicao = new JLabel("Nome Instituicao: ");
		lbDsAtvExtraCur = new JLabel("Atividade Extra Curricular: ");
		lbDtInicio = new JLabel("Data Inicio: ");
		lbDtTermino = new JLabel("Data Termino: ");
		lbNmCurso = new JLabel("Nome Curso: ");
		lbDsStatusCurso = new JLabel("Status Curso:");
		lbDsEscolaridade = new JLabel("Escolaridade:");
		lbDsSemestre = new JLabel("Semestre:");
		lbFlCurso = new JLabel("Nivel de conhecimento:");
		
		//Instanciando Text Field
		tfIdFormacaoAcademica = new JTextField();
		tfIdRegistroGeral = new JTextField();
		tfNmInstituicao = new JTextField();
		tfDsAtvExtraCur = new JTextField();
		tfDtInicio = new JTextField();
		tfDtTermino = new JTextField();
		tfNmCurso = new JTextField();
		tfDsStatusCurso = new JTextField();
		tfDsEscolaridade = new JTextField();
		tfDsSemestre = new JTextField();
		tfFlCurso = new JTextField();
		
		//Set Bouds labels
		lbIdFormacaoAcademica.setBounds(25, 30, 150, 25);
		lbIdRegistroGeral.setBounds(25, 65, 100, 25);
		lbNmInstituicao.setBounds(25, 100, 150, 25);
		lbDsAtvExtraCur.setBounds(25, 135, 155, 25);
		lbDtInicio.setBounds(25, 170, 100, 25);
		lbDtTermino.setBounds(25, 205, 100, 25);
		lbNmCurso.setBounds(25, 240, 100, 25);
		lbDsStatusCurso.setBounds(25, 275, 120, 25);
		lbDsEscolaridade.setBounds(25, 310, 100, 25);
		lbDsSemestre.setBounds(25, 345, 100, 25);
		lbFlCurso.setBounds(25, 380, 150, 25);
		
		//set Bounds Text Fields
		tfIdFormacaoAcademica.setBounds(180, 30, 240, 25);
		tfIdRegistroGeral.setBounds(130, 65, 200, 25);
		tfNmInstituicao.setBounds(130, 100, 200, 25);
		tfDsAtvExtraCur.setBounds(180, 135, 240, 25);
		tfDtInicio.setBounds(130, 170, 200, 25);
		tfDtTermino.setBounds(130, 205, 200, 25);
		tfNmCurso.setBounds(130, 240, 200, 25);
		tfDsStatusCurso.setBounds(130, 275, 200, 25);
		tfDsEscolaridade.setBounds(130, 310, 200, 25);
		tfDsSemestre.setBounds(130, 345, 200, 25);
		tfFlCurso.setBounds(170, 380, 160, 25);
		
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
		
		add(lbIdFormacaoAcademica);
		add(lbIdRegistroGeral);
		add(lbNmInstituicao);
		add(lbDsAtvExtraCur);
		add(lbDtInicio);
		add(lbDtTermino);
		add(lbNmCurso);
		add(lbDsStatusCurso);
		add(lbDsEscolaridade);
		add(lbDsSemestre);
		add(lbFlCurso);
		
		add(tfIdFormacaoAcademica);
		add(tfIdRegistroGeral);
		add(tfNmInstituicao);
		add(tfDsAtvExtraCur);
		add(tfDtInicio);
		add(tfDtTermino);
		add(tfNmCurso);
		add(tfDsStatusCurso);
		add(tfDsEscolaridade);
		add(tfDsSemestre);
		add(tfFlCurso);
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
