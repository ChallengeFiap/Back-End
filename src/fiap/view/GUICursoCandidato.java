package fiap.view;

/**Classe de Interface GUI para mostrar as informacoes do Curso Candidato
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
 */
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

import fiap.controller.CandidatoCursoController;

@SuppressWarnings({ "serial" })
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

		
		//Instanciando Bot�es 
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
		
		//set Bounds Bot�es
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
				CandidatoCursoController candCurso = new CandidatoCursoController();
				if (tfIdCandCurso.getText().equals("") || tfIdCurso.getText().equals("")
						|| tfIdRegistroGeral.getText().equals("") || tfDtInicio.getText().equals("")
						|| tfDtTermino.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdCandCurso.getText());
					int idCurso = Integer.parseInt(tfIdCurso.getText());
					int idRegistro = Integer.parseInt(tfIdCurso.getText());
					
					String aux = tfDtInicio.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataI = LocalDate.parse(data);
					
					aux = tfDtInicio.getText();
					data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataT = LocalDate.parse(data);
					
					JOptionPane.showMessageDialog(null,
							candCurso.insereCandidatoCurso(id, idRegistro, idCurso, dataI, dataT));
					tfIdCandCurso.setText("");
					tfIdCurso.setText("");
					tfIdRegistroGeral.setText("");
					tfDtInicio.setText("");
					tfDtTermino.setText("");
				}
				
			}
		});
		
		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidatoCursoController candCurso = new CandidatoCursoController();
				if (tfIdCandCurso.getText().equals("") || tfIdCurso.getText().equals("")
						|| tfIdRegistroGeral.getText().equals("") || tfDtInicio.getText().equals("")
						|| tfDtTermino.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdCandCurso.getText());
					int idCurso = Integer.parseInt(tfIdCurso.getText());
					int idRegistro = Integer.parseInt(tfIdCurso.getText());
					
					String aux = tfDtInicio.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataI = LocalDate.parse(data);
					
					aux = tfDtInicio.getText();
					data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataT = LocalDate.parse(data);
					
					JOptionPane.showMessageDialog(null,
							candCurso.alteraCandidatoCurso(id, idRegistro, idCurso, dataI, dataT));
					tfIdCandCurso.setText("");
					tfIdCurso.setText("");
					tfIdRegistroGeral.setText("");
					tfDtInicio.setText("");
					tfDtTermino.setText("");
				}
				
			}
		});
		
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidatoCursoController candCurso = new CandidatoCursoController();
				if (tfIdCandCurso.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Curso Candidato");
				} else {
					int id = Integer.parseInt(tfIdCandCurso.getText());
					
					JOptionPane.showMessageDialog(null,
							candCurso.excluiCandidatoCurso(id));
					tfIdCandCurso.setText("");
					tfIdCurso.setText("");
					tfIdRegistroGeral.setText("");
					tfDtInicio.setText("");
					tfDtTermino.setText("");
				}
				
			}
		});
		
		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidatoCursoController candCurso = new CandidatoCursoController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfIdCandCurso.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Curso Candidato");
					tfIdCandCurso.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdCandCurso.getText());
					dados = candCurso.listaUmCandidatoCurso(id);
					if (dados != null) {
						tfIdCurso.setText(dados.get(1));
						tfIdRegistroGeral.setText(dados.get(2));
						
						String aux = dados.get(3);
						String data = aux.substring(8, 10) + "/";
						data += aux.substring(5, 7) + "/";
						data += aux.substring(0, 4);
						
						tfDtInicio.setText(data);
						
						aux = dados.get(4);
						data = aux.substring(8, 10) + "/";
						data += aux.substring(5, 7) + "/";
						data += aux.substring(0, 4);
						
						tfDtTermino.setText(data);

					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
					
				}
				
			}
		});
		
		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidatoCursoController candCurso = new CandidatoCursoController();
				String dados = candCurso.listaCandidatoCurso();
				JOptionPane.showMessageDialog(null, dados);
				
			}
		});
		
	}
}
