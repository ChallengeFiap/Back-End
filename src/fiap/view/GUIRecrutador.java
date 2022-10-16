package fiap.view;

/**Classe de Interface GUI para mostrar as informacoes do Recrutador
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import fiap.controller.RecrutadorController;
import fiap.controller.TelefoneController;

@SuppressWarnings({ "serial", "unused" })
public class GUIRecrutador extends JPanel {

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbRegistroGeral, lbNomeCompleto, lbSenha, lbEmail, lbTpUsuario, lbNrCPF;
	private JLabel lbNomeEmpresa, lbDsCargo;
	private JTextField tfRegistroGeral, tfNomeCompleto, tfSenha, tfEmail, tfTpUsuario, tfNrCPF;
	private JTextField tfNomeEmpresa, tfDsCargo;

	public GUIRecrutador() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);

		// Instanciando Botões
		btInserir = new JButton("Inserir");
		btUpdate = new JButton("Atualizar");
		btExcluir = new JButton("Excluir");
		btSelectById = new JButton("Select ID");
		btSelectAll = new JButton("SelectAll");

		// Instanciando Labels
		lbRegistroGeral = new JLabel("ID Registo Geral:");
		lbNomeCompleto = new JLabel("Nome Completo:");
		lbSenha = new JLabel("Senha: ");
		lbEmail = new JLabel("Email: ");
		lbTpUsuario = new JLabel("Tipo Usuario: ");
		lbNrCPF = new JLabel("CPF: ");
		lbNomeEmpresa = new JLabel("Nome da Empresa: ");
		lbDsCargo = new JLabel("Cargo: ");

		// Instanciando Text Field
		tfRegistroGeral = new JTextField();
		tfNomeCompleto = new JTextField();
		tfSenha = new JTextField();
		tfEmail = new JTextField();
		tfTpUsuario = new JTextField();
		tfNrCPF = new JTextField();
		tfNomeEmpresa = new JTextField();
		tfDsCargo = new JTextField();

		// Set Bouds labels
		lbRegistroGeral.setBounds(25, 30, 100, 25);
		lbNomeCompleto.setBounds(25, 65, 100, 25);
		lbSenha.setBounds(25, 100, 100, 25);
		lbEmail.setBounds(25, 135, 100, 25);
		lbTpUsuario.setBounds(25, 170, 100, 25);
		lbNrCPF.setBounds(25, 205, 100, 25);
		lbNomeEmpresa.setBounds(25, 240, 120, 25);
		lbDsCargo.setBounds(25, 275, 100, 25);

		// set Bounds Text Fields
		tfRegistroGeral.setBounds(130, 30, 200, 25);
		tfNomeCompleto.setBounds(130, 65, 200, 25);
		tfSenha.setBounds(130, 100, 200, 25);
		tfEmail.setBounds(130, 135, 200, 25);
		tfTpUsuario.setBounds(130, 170, 200, 25);
		tfNrCPF.setBounds(130, 205, 200, 25);
		tfNomeEmpresa.setBounds(150, 240, 180, 25);
		tfDsCargo.setBounds(130, 275, 200, 25);

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

		add(lbRegistroGeral);
		add(lbNomeCompleto);
		add(lbSenha);
		add(lbEmail);
		add(lbTpUsuario);
		add(lbNrCPF);
		add(lbNomeEmpresa);
		add(lbDsCargo);

		add(tfRegistroGeral);
		add(tfNomeCompleto);
		add(tfSenha);
		add(tfEmail);
		add(tfTpUsuario);
		add(tfNrCPF);
		add(tfNomeEmpresa);
		add(tfDsCargo);

	}

	private void definirEventos() {
		btInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecrutadorController recrutador = new RecrutadorController();
				if (tfRegistroGeral.getText().equals("") || tfNomeCompleto.getText().equals("")
						|| tfSenha.getText().equals("") || tfEmail.getText().equals("")
						|| tfTpUsuario.getText().equals("") || tfNrCPF.getText().equals("")
						|| tfNomeEmpresa.getText().equals("") || tfDsCargo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfRegistroGeral.getText());
					JOptionPane.showMessageDialog(null,
							recrutador.insereRecrutador(id, tfNomeCompleto.getText(), tfSenha.getText(), tfEmail.getText(),
									tfTpUsuario.getText(), tfNrCPF.getText(), tfNomeEmpresa.getText(),
									tfDsCargo.getText()));
					tfRegistroGeral.setText("");
					tfNomeCompleto.setText("");
					tfSenha.setText("");
					tfEmail.setText("");
					tfTpUsuario.setText("");
					tfNrCPF.setText("");
					tfNomeEmpresa.setText("");
					tfDsCargo.setText("");
				}

			}
		});

		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecrutadorController recrutador = new RecrutadorController();
				if (tfRegistroGeral.getText().equals("") || tfNomeCompleto.getText().equals("")
						|| tfSenha.getText().equals("") || tfEmail.getText().equals("")
						|| tfTpUsuario.getText().equals("") || tfNrCPF.getText().equals("")
						|| tfNomeEmpresa.getText().equals("") || tfDsCargo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfRegistroGeral.getText());
					JOptionPane.showMessageDialog(null,
							recrutador.alteraRecrutador(id, tfNomeCompleto.getText(), tfSenha.getText(), tfEmail.getText(),
									tfTpUsuario.getText(), tfNrCPF.getText(), tfNomeEmpresa.getText(),
									tfDsCargo.getText()));
					tfRegistroGeral.setText("");
					tfNomeCompleto.setText("");
					tfSenha.setText("");
					tfEmail.setText("");
					tfTpUsuario.setText("");
					tfNrCPF.setText("");
					tfNomeEmpresa.setText("");
					tfDsCargo.setText("");
				}

			}
		});

		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecrutadorController recrutador = new RecrutadorController();
				if (tfRegistroGeral.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Recrutador");
				} else {
					int id = Integer.parseInt(tfRegistroGeral.getText());
					JOptionPane.showMessageDialog(null,
							recrutador.excluiRecrutador(id));
					tfRegistroGeral.setText("");
					tfNomeCompleto.setText("");
					tfSenha.setText("");
					tfEmail.setText("");
					tfTpUsuario.setText("");
					tfNrCPF.setText("");
					tfNomeEmpresa.setText("");
					tfDsCargo.setText("");
				}

			}
		});

		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecrutadorController recrutador = new RecrutadorController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfRegistroGeral.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Recrutador");
					tfRegistroGeral.requestFocus();
				} else {
					int id = Integer.parseInt(tfRegistroGeral.getText());
					dados = recrutador.listaRecrutador(id);
					if (dados != null) {
						tfNomeCompleto.setText(dados.get(2));
						tfEmail.setText(dados.get(3));
						tfSenha.setText(dados.get(4));
						tfTpUsuario.setText(dados.get(1));
						tfNrCPF.setText(dados.get(5));
						tfNomeEmpresa.setText(dados.get(6));
						tfDsCargo.setText(dados.get(7));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
					
				}

			}
		});

		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecrutadorController recrutador = new RecrutadorController();
				String dados = recrutador.listaRecrutadores();
				JOptionPane.showMessageDialog(null, dados);

			}
		});

	}
}
