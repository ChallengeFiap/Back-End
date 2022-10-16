package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import fiap.controller.CursosController;
import fiap.controller.TelefoneController;

@SuppressWarnings({ "serial", "unused" })
public class GUITelefone extends JPanel {

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdTelefone, lbIdRegistroGeral, lbNrDDD, lbNrTelefone, lbStTelefone;
	private JTextField tfIdTelefone, tfIdRegistroGeral, tfNrDDD, tfNrTelefone, tfStTelefone;

	public GUITelefone() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.orange);

		// Instanciando Botões
		btInserir = new JButton("Inserir");
		btUpdate = new JButton("Atualizar");
		btExcluir = new JButton("Excluir");
		btSelectById = new JButton("Select ID");
		btSelectAll = new JButton("SelectAll");

		// Instanciando Labels
		lbIdTelefone = new JLabel("ID Telefone:");
		lbIdRegistroGeral = new JLabel("ID Geral:");
		lbNrDDD = new JLabel("Numero DDD: ");
		lbNrTelefone = new JLabel("Telefone: ");
		lbStTelefone = new JLabel("Status Telefone: ");

		// Instanciando Text Field
		tfIdTelefone = new JTextField();
		tfIdRegistroGeral = new JTextField();
		tfNrDDD = new JTextField();
		tfNrTelefone = new JTextField();
		tfStTelefone = new JTextField();

		// Set Bouds labels
		lbIdTelefone.setBounds(25, 30, 100, 25);
		lbIdRegistroGeral.setBounds(25, 65, 100, 25);
		lbNrDDD.setBounds(25, 100, 100, 25);
		lbNrTelefone.setBounds(25, 135, 100, 25);
		lbStTelefone.setBounds(25, 170, 100, 25);

		// set Bounds Text Fields
		tfIdTelefone.setBounds(130, 30, 200, 25);
		tfIdRegistroGeral.setBounds(130, 65, 200, 25);
		tfNrDDD.setBounds(130, 100, 200, 25);
		tfNrTelefone.setBounds(130, 135, 200, 25);
		tfStTelefone.setBounds(130, 170, 200, 25);

		// set Bounds Botões
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

		add(lbIdTelefone);
		add(lbIdRegistroGeral);
		add(lbNrDDD);
		add(lbNrTelefone);
		add(lbStTelefone);

		add(tfIdTelefone);
		add(tfIdRegistroGeral);
		add(tfNrDDD);
		add(tfNrTelefone);
		add(tfStTelefone);

	}

	private void definirEventos() {

		btInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController telefone = new TelefoneController();
				if (tfIdTelefone.getText().equals("") || tfIdRegistroGeral.getText().equals("")
						|| tfNrDDD.getText().equals("") || tfNrTelefone.getText().equals("")
						|| tfStTelefone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdTelefone.getText());
					int idGeral = Integer.parseInt(tfIdRegistroGeral.getText());
					int nrDDD = Integer.parseInt(tfNrDDD.getText());
					int nrTelefone = Integer.parseInt(tfNrTelefone.getText());
					JOptionPane.showMessageDialog(null,
							telefone.insereTelefone(id, idGeral, nrDDD, nrTelefone, tfStTelefone.getText()));
					tfIdTelefone.setText("");
					tfIdRegistroGeral.setText("");
					tfNrDDD.setText("");
					tfNrTelefone.setText("");
					tfStTelefone.setText("");
				}

			}
		});

		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController telefone = new TelefoneController();
				if (tfIdTelefone.getText().equals("") || tfIdRegistroGeral.getText().equals("")
						|| tfNrDDD.getText().equals("") || tfNrTelefone.getText().equals("")
						|| tfStTelefone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdTelefone.getText());
					int idGeral = Integer.parseInt(tfIdRegistroGeral.getText());
					int nrDDD = Integer.parseInt(tfNrDDD.getText());
					int nrTelefone = Integer.parseInt(tfNrTelefone.getText());
					JOptionPane.showMessageDialog(null,
							telefone.alteraTelefone(id, idGeral, nrDDD, nrTelefone, tfStTelefone.getText()));
					tfIdTelefone.setText("");
					tfIdRegistroGeral.setText("");
					tfNrDDD.setText("");
					tfNrTelefone.setText("");
					tfStTelefone.setText("");
				}

			}
		});

		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController telefone = new TelefoneController();
				if (tfIdTelefone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Telefone");
				} else {
					int id = Integer.parseInt(tfIdTelefone.getText());
					JOptionPane.showMessageDialog(null, telefone.excluiTelefone(id));
					tfIdTelefone.setText("");
					tfIdRegistroGeral.setText("");
					tfNrDDD.setText("");
					tfNrTelefone.setText("");
					tfStTelefone.setText("");
				}

			}
		});

		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController telefone = new TelefoneController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfIdTelefone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Telefone");
					tfIdTelefone.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdTelefone.getText());
					dados = telefone.listaUmTelefone(id);
					if (dados != null) {
						tfIdRegistroGeral.setText(dados.get(1));
						tfNrDDD.setText(dados.get(2));
						tfNrTelefone.setText(dados.get(3));
						tfStTelefone.setText(dados.get(4));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}

				}

			}
		});

		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController telefone = new TelefoneController();
				String dados = telefone.listaTelefones();
				JOptionPane.showMessageDialog(null, dados);

			}
		});

	}
}
