package fiap.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUICursos extends JPanel{

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdCurso, lbNrCurso, lbSgCurso, lbNmCurso;
	private JTextField tfIdCurso, tfNrCurso, tfSgCurso, tfNmCurso;
	
	public GUICursos() {
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
		lbIdCurso = new JLabel("ID Curso:");
		lbNrCurso = new JLabel("Numero do Curso:");
		lbSgCurso = new JLabel("Sigla Curso:");
		lbNmCurso = new JLabel("Nome do Curso:");
		
		//Instanciando Text Field
		tfIdCurso = new JTextField();
		tfNrCurso = new JTextField();
		tfSgCurso = new JTextField();
		tfNmCurso = new JTextField();
		
		//Set Bouds labels
		lbIdCurso.setBounds(25, 30, 100, 25);
		lbNrCurso.setBounds(25, 65, 120, 25);
		lbSgCurso.setBounds(25, 100, 100, 25);
		lbNmCurso.setBounds(25, 135, 100, 25);
		
		//set Bounds Text Fields
		tfIdCurso.setBounds(130, 30, 200, 25);
		tfNrCurso.setBounds(150, 65, 180, 25);
		tfSgCurso.setBounds(130, 100, 200, 25);
		tfNmCurso.setBounds(130, 135, 200, 25);
		
		
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
		
		add(lbIdCurso);
		add(lbNrCurso);
		add(lbSgCurso);
		add(lbNmCurso);

		
		add(tfIdCurso);
		add(tfNrCurso);
		add(tfSgCurso);
		add(tfNmCurso);

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
