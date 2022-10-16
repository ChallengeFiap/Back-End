package fiap.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fiap.controller.CursosController;

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
				CursosController cursos = new CursosController();
				if (tfIdCurso.getText().equals("") || tfNrCurso.getText().equals("")
						|| tfSgCurso.getText().equals("") || tfNmCurso.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdCurso.getText());
					int nrCurso = Integer.parseInt(tfNrCurso.getText());
					JOptionPane.showMessageDialog(null,
							cursos.insereCurso(id, nrCurso, tfSgCurso.getText(), tfNmCurso.getText()));
					tfIdCurso.setText("");
					tfNrCurso.setText("");
					tfSgCurso.setText("");
					tfNmCurso.setText("");
				}
				
			}
		});
		
		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CursosController cursos = new CursosController();
				if (tfIdCurso.getText().equals("") || tfNrCurso.getText().equals("")
						|| tfSgCurso.getText().equals("") || tfNmCurso.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdCurso.getText());
					int nrCurso = Integer.parseInt(tfNrCurso.getText());
					JOptionPane.showMessageDialog(null,
							cursos.alteraCurso(id, nrCurso, tfSgCurso.getText(), tfNmCurso.getText()));
					tfIdCurso.setText("");
					tfNrCurso.setText("");
					tfSgCurso.setText("");
					tfNmCurso.setText("");
				}
				
			}
		});
		
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CursosController cursos = new CursosController();
				if (tfIdCurso.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Curso");
				} else {
					int id = Integer.parseInt(tfIdCurso.getText());
					JOptionPane.showMessageDialog(null,
							cursos.excluiCurso(id));
					tfIdCurso.setText("");
					tfNrCurso.setText("");
					tfSgCurso.setText("");
					tfNmCurso.setText("");
				}
				
			}
		});
		
		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CursosController cursos = new CursosController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfIdCurso.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Curso");
					tfIdCurso.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdCurso.getText());
					dados = cursos.listaUmCurso(id);
					if (dados != null) {
						tfNrCurso.setText(dados.get(1));
						tfSgCurso.setText(dados.get(2));
						tfNmCurso.setText(dados.get(3));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
					
				}
				
			}
		});
		
		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CursosController cursos = new CursosController();
				String dados = cursos.listaCurso();
				JOptionPane.showMessageDialog(null, dados);
				
				
			}
		});
		
	}
}
