package fiap.view;

/**Classe de Interface GUI para mostrar as informacoes de Idiomas Candidatos
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
 */
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

import fiap.controller.IdiomaCandidatoController;

@SuppressWarnings({ "serial", "unused" })
public class GUIIdiomaCandidato extends JPanel {

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdIdiomaCandidato, lbIdIomas, lbIdRegistroGeral, lbDtInicio, lbFlProficiencia;
	private JTextField tfIdIdiomaCandidato, tfIdIomas, tfIdRegistroGeral, tfDtInicio, tfFlProficiencia;

	public GUIIdiomaCandidato() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.orange);

		// Instanciando Bot�es
		btInserir = new JButton("Inserir");
		btUpdate = new JButton("Atualizar");
		btExcluir = new JButton("Excluir");
		btSelectById = new JButton("Select ID");
		btSelectAll = new JButton("SelectAll");

		// Instanciando Labels
		lbIdIdiomaCandidato = new JLabel("ID Idioma Candidato:");
		lbIdIomas = new JLabel("ID Idiomas:");
		lbIdRegistroGeral = new JLabel("ID Geral: ");
		lbDtInicio = new JLabel("Data Inicio: ");
		lbFlProficiencia = new JLabel("Nivel de Conhecimento: ");

		// Instanciando Text Field
		tfIdIdiomaCandidato = new JTextField();
		tfIdIomas = new JTextField();
		tfIdRegistroGeral = new JTextField();
		tfDtInicio = new JTextField();
		tfFlProficiencia = new JTextField();

		// Set Bouds labels
		lbIdIdiomaCandidato.setBounds(25, 30, 150, 25);
		lbIdIomas.setBounds(25, 65, 170, 25);
		lbIdRegistroGeral.setBounds(25, 100, 150, 25);
		lbDtInicio.setBounds(25, 135, 150, 25);
		lbFlProficiencia.setBounds(25, 170, 150, 25);

		// set Bounds Text Fields
		tfIdIdiomaCandidato.setBounds(170, 30, 200, 25);
		tfIdIomas.setBounds(170, 65, 200, 25);
		tfIdRegistroGeral.setBounds(170, 100, 200, 25);
		tfDtInicio.setBounds(170, 135, 200, 25);
		tfFlProficiencia.setBounds(170, 170, 200, 25);

		// set Bounds Bot�es
		btInserir.setBounds(100, 460, 100, 25);
		btUpdate.setBounds(220, 460, 100, 25);
		btExcluir.setBounds(340, 460, 100, 25);
		btSelectById.setBounds(460, 460, 100, 25);
		btSelectAll.setBounds(580, 460, 100, 25);

		// Add os elementos
		add(btInserir);
		add(btUpdate);
		add(btExcluir);
		add(btSelectById);
		add(btSelectAll);

		add(lbIdIdiomaCandidato);
		add(lbIdIomas);
		add(lbIdRegistroGeral);
		add(lbDtInicio);
		add(lbFlProficiencia);

		add(tfIdIdiomaCandidato);
		add(tfIdIomas);
		add(tfIdRegistroGeral);
		add(tfDtInicio);
		add(tfFlProficiencia);
	}

	private void definirEventos() {

		btInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdiomaCandidatoController icc = new IdiomaCandidatoController();
				if (tfIdIdiomaCandidato.getText().equals("") || tfIdIomas.getText().equals("")
						|| tfIdRegistroGeral.getText().equals("") || tfDtInicio.getText().equals("")
						|| tfFlProficiencia.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdIdiomaCandidato.getText());
					int idIdiomas = Integer.parseInt(tfIdIomas.getText());
					int idRegistro = Integer.parseInt(tfIdRegistroGeral.getText());
					String aux = tfDtInicio.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataI= LocalDate.parse(data);
					
					JOptionPane.showMessageDialog(null, icc.insereIdiomaCandidato(id, 
							idRegistro, idIdiomas, dataI, tfFlProficiencia.getText()));
					tfIdIdiomaCandidato.setText("");
					tfIdIomas.setText("");
					tfIdRegistroGeral.setText("");
					tfDtInicio.setText("");
					tfFlProficiencia.setText("");

				}

			}
		});

		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdiomaCandidatoController icc = new IdiomaCandidatoController();
				if (tfIdIdiomaCandidato.getText().equals("") || tfIdIomas.getText().equals("")
						|| tfIdRegistroGeral.getText().equals("") || tfDtInicio.getText().equals("")
						|| tfFlProficiencia.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdIdiomaCandidato.getText());
					int idIdiomas = Integer.parseInt(tfIdIomas.getText());
					int idRegistro = Integer.parseInt(tfIdRegistroGeral.getText());
					String aux = tfDtInicio.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataI= LocalDate.parse(data);
					
					JOptionPane.showMessageDialog(null, icc.alteraIdiomaCandidato(id, 
							idRegistro, idIdiomas, dataI, tfFlProficiencia.getText()));
					tfIdIdiomaCandidato.setText("");
					tfIdIomas.setText("");
					tfIdRegistroGeral.setText("");
					tfDtInicio.setText("");
					tfFlProficiencia.setText("");
				}

			}
		});

		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdiomaCandidatoController icc = new IdiomaCandidatoController();
				if (tfIdIdiomaCandidato.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Idioma Candidato");
					tfIdIdiomaCandidato.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdIdiomaCandidato.getText());
					JOptionPane.showMessageDialog(null, icc.excluiIdiomaCandidato(id));
					tfIdIdiomaCandidato.setText("");
					tfIdIomas.setText("");
					tfIdRegistroGeral.setText("");
					tfDtInicio.setText("");
					tfFlProficiencia.setText("");
				}

			}
		});

		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdiomaCandidatoController icc = new IdiomaCandidatoController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfIdIdiomaCandidato.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Idioma Candidato");
					tfIdIdiomaCandidato.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdIdiomaCandidato.getText());
					dados = icc.listaUmIdiomaCandidato(id);
					if (dados != null) {
						tfIdIomas.setText(dados.get(1));
						tfIdRegistroGeral.setText(dados.get(2));
						
						String aux = dados.get(3);
						String data = aux.substring(8, 10) + "/";
						data += aux.substring(5, 7) + "/";
						data += aux.substring(0, 4);
						
						tfDtInicio.setText(data);
						tfFlProficiencia.setText(dados.get(4));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
					
				}

			}
		});

		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdiomaCandidatoController icc = new IdiomaCandidatoController();
				String dados = icc.listaIdiomaCandidatos();
				JOptionPane.showMessageDialog(null, dados);

			}
		});

	}
}
