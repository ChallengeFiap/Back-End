package fiap.view;

/**Classe de Interface GUI para mostrar as informacoes de Linguagem de Programacao
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import fiap.controller.LinguagemController;

@SuppressWarnings({ "serial" })
public class GUILinguagemProgramacao extends JPanel {

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdLinguagemProg, lbTpLinguagem;
	private JTextField tfIdLinguagemProg, tfTpLinguagem;

	public GUILinguagemProgramacao() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.CYAN);

		// Instanciando Bot�es
		btInserir = new JButton("Inserir");
		btUpdate = new JButton("Atualizar");
		btExcluir = new JButton("Excluir");
		btSelectById = new JButton("Select ID");
		btSelectAll = new JButton("SelectAll");

		// Instanciando Labels
		lbIdLinguagemProg = new JLabel("ID Linguagem Programacao:");
		lbTpLinguagem = new JLabel("Linguagem de Programacao:");

		// Instanciando Text Field
		tfIdLinguagemProg = new JTextField();
		tfTpLinguagem = new JTextField();

		// Set Bouds labels
		lbIdLinguagemProg.setBounds(25, 30, 170, 25);
		lbTpLinguagem.setBounds(25, 65, 170, 25);

		// set Bounds Text Fields
		tfIdLinguagemProg.setBounds(200, 30, 200, 25);
		tfTpLinguagem.setBounds(200, 65, 200, 25);

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

		add(lbIdLinguagemProg);
		add(lbTpLinguagem);

		add(tfIdLinguagemProg);
		add(tfTpLinguagem);

	}

	private void definirEventos() {

		btInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinguagemController linguagem = new LinguagemController();
				if (tfIdLinguagemProg.getText().equals("") || tfTpLinguagem.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdLinguagemProg.getText());
					JOptionPane.showMessageDialog(null, linguagem.insereLinguagem(id, tfTpLinguagem.getText()));
					tfIdLinguagemProg.setText("");
					tfTpLinguagem.setText("");
				}

			}
		});

		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinguagemController linguagem = new LinguagemController();
				if (tfIdLinguagemProg.getText().equals("") || tfTpLinguagem.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdLinguagemProg.getText());
					JOptionPane.showMessageDialog(null, linguagem.alteraLinguagem(id, tfTpLinguagem.getText()));
					tfIdLinguagemProg.setText("");
					tfTpLinguagem.setText("");
				}

			}
		});

		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinguagemController linguagem = new LinguagemController();
				if (tfIdLinguagemProg.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Linguagem");
					tfIdLinguagemProg.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdLinguagemProg.getText());
					JOptionPane.showMessageDialog(null, linguagem.excluiLinguagem(id));
					tfIdLinguagemProg.setText("");
					tfTpLinguagem.setText("");
				}

			}
		});

		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinguagemController linguagem = new LinguagemController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfIdLinguagemProg.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Linguagem");
					tfIdLinguagemProg.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdLinguagemProg.getText());
					dados = linguagem.listaUmaLinguagem(id);
					if (dados != null) {
						tfTpLinguagem.setText(dados.get(1));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
					
				}

			}
		});

		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinguagemController linguagem = new LinguagemController();
				String dados = linguagem.listaLinguagens();
				JOptionPane.showMessageDialog(null, dados);

			}
		});

	}
}
