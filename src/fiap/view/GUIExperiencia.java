package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

import fiap.controller.CursosController;
import fiap.controller.ExperienciaController;

@SuppressWarnings({ "serial", "unused" })
public class GUIExperiencia extends JPanel {

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdExperiencia, lbIdRegistroGeral, lbTpExperiencia, lbdtInicio, lbDtTermino, lbStStatus,
			lbDsSenioridade;
	private JTextField tfIdExperiencia, tfIdRegistroGeral, tfTpExperiencia, tfdtInicio, tfDtTermino, tfStStatus,
			tfDsSenioridade;

	public GUIExperiencia() {
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
		lbIdExperiencia = new JLabel("ID Experiencia:");
		lbIdRegistroGeral = new JLabel("ID Geral:");
		lbTpExperiencia = new JLabel("Tipo Experiencia: ");
		lbdtInicio = new JLabel("Data Inicio: ");
		lbDtTermino = new JLabel("Data Termino: ");
		lbStStatus = new JLabel("Status: ");
		lbDsSenioridade = new JLabel("Senioridade: ");

		// Instanciando Text Field
		tfIdExperiencia = new JTextField();
		tfIdRegistroGeral = new JTextField();
		tfTpExperiencia = new JTextField();
		tfdtInicio = new JTextField();
		tfDtTermino = new JTextField();
		tfStStatus = new JTextField();
		tfDsSenioridade = new JTextField();

		// Set Bouds labels
		lbIdExperiencia.setBounds(25, 30, 100, 25);
		lbIdRegistroGeral.setBounds(25, 65, 100, 25);
		lbTpExperiencia.setBounds(25, 100, 100, 25);
		lbdtInicio.setBounds(25, 135, 100, 25);
		lbDtTermino.setBounds(25, 170, 100, 25);
		lbStStatus.setBounds(25, 205, 100, 25);
		lbDsSenioridade.setBounds(25, 240, 100, 25);

		// set Bounds Text Fields
		tfIdExperiencia.setBounds(130, 30, 200, 25);
		tfIdRegistroGeral.setBounds(130, 65, 200, 25);
		tfTpExperiencia.setBounds(130, 100, 200, 25);
		tfdtInicio.setBounds(130, 135, 200, 25);
		tfDtTermino.setBounds(130, 170, 200, 25);
		tfStStatus.setBounds(130, 205, 200, 25);
		tfDsSenioridade.setBounds(130, 240, 200, 25);

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

		add(lbIdExperiencia);
		add(lbIdRegistroGeral);
		add(lbTpExperiencia);
		add(lbdtInicio);
		add(lbDtTermino);
		add(lbStStatus);
		add(lbDsSenioridade);

		add(tfIdExperiencia);
		add(tfIdRegistroGeral);
		add(tfTpExperiencia);
		add(tfdtInicio);
		add(tfDtTermino);
		add(tfStStatus);
		add(tfDsSenioridade);
	}

	private void definirEventos() {

		btInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExperienciaController experiencia = new ExperienciaController();
				if (tfIdExperiencia.getText().equals("") || tfIdRegistroGeral.getText().equals("")
						|| tfTpExperiencia.getText().equals("") || tfdtInicio.getText().equals("")
						|| tfDtTermino.getText().equals("") || tfStStatus.getText().equals("")
						|| tfDsSenioridade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdExperiencia.getText());
					int idGeral = Integer.parseInt(tfIdRegistroGeral.getText());
					
					String aux = tfdtInicio.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataI = LocalDate.parse(data);
					
					aux = tfdtInicio.getText();
					data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataT = LocalDate.parse(data);
					
					JOptionPane.showMessageDialog(null, experiencia.insereExperiencia(id, idGeral, tfTpExperiencia.getText(),
							dataI, dataT, tfStStatus.getText(), tfDsSenioridade.getText()));
					tfIdExperiencia.setText("");
					tfIdRegistroGeral.setText("");
					tfTpExperiencia.setText("");
					tfdtInicio.setText("");
					tfDtTermino.setText("");
					tfStStatus.setText("");
					tfDsSenioridade.setText("");
				}
			}
		});

		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExperienciaController experiencia = new ExperienciaController();
				if (tfIdExperiencia.getText().equals("") || tfIdRegistroGeral.getText().equals("")
						|| tfTpExperiencia.getText().equals("") || tfdtInicio.getText().equals("")
						|| tfDtTermino.getText().equals("") || tfStStatus.getText().equals("")
						|| tfDsSenioridade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdExperiencia.getText());
					int idGeral = Integer.parseInt(tfIdRegistroGeral.getText());
					
					String aux = tfdtInicio.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataI = LocalDate.parse(data);
					
					aux = tfdtInicio.getText();
					data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataT = LocalDate.parse(data);
					
					JOptionPane.showMessageDialog(null, experiencia.alteraExperiencia(id, idGeral, tfTpExperiencia.getText(),
							dataI, dataT, tfStStatus.getText(), tfDsSenioridade.getText()));
					tfIdExperiencia.setText("");
					tfIdRegistroGeral.setText("");
					tfTpExperiencia.setText("");
					tfdtInicio.setText("");
					tfDtTermino.setText("");
					tfStStatus.setText("");
					tfDsSenioridade.setText("");
				}

			}
		});

		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExperienciaController experiencia = new ExperienciaController();
				if (tfIdExperiencia.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Experiencia");
				} else {
					int id = Integer.parseInt(tfIdExperiencia.getText());
					int idGeral = Integer.parseInt(tfIdRegistroGeral.getText());
					JOptionPane.showMessageDialog(null, experiencia.excluiExperiencia(id));
					tfIdExperiencia.setText("");
					tfIdRegistroGeral.setText("");
					tfTpExperiencia.setText("");
					tfdtInicio.setText("");
					tfDtTermino.setText("");
					tfStStatus.setText("");
					tfDsSenioridade.setText("");
				}

			}
		});

		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExperienciaController experiencia = new ExperienciaController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfIdExperiencia.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Experiencia");
					tfIdExperiencia.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdExperiencia.getText());
					dados = experiencia.listaUmaExperiencia(id);
					if (dados != null) {
						tfIdRegistroGeral.setText(dados.get(1));
						tfTpExperiencia.setText(dados.get(2));
						
						String aux = dados.get(3);
						String data = aux.substring(8, 10) + "/";
						data += aux.substring(5, 7) + "/";
						data += aux.substring(0, 4);
						
						tfdtInicio.setText(data);
						
						aux = dados.get(4);
						data = aux.substring(8, 10) + "/";
						data += aux.substring(5, 7) + "/";
						data += aux.substring(0, 4);
						
						tfDtTermino.setText(data);
						tfStStatus.setText(dados.get(5));
						tfDsSenioridade.setText(dados.get(6));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
					
				}

			}
		});

		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExperienciaController experiencia = new ExperienciaController();
				String dados = experiencia.listaExperiencias();
				JOptionPane.showMessageDialog(null, dados);

			}
		});

	}
}
