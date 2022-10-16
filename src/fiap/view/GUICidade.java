package fiap.view;

/**Classe de Interface GUI para mostrar as informacoes de Cidade
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import fiap.controller.CandidatoController;
import fiap.controller.CidadeController;

@SuppressWarnings({ "serial", "unused" })
public class GUICidade extends JPanel{

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdCidade, lbIdRegistroGeral, lbIdEstado, lbNmCidade;
	private JTextField tfIdCidade, tfIdRegistroGeral, tfIdEstado, tfNmCidade;
	
	public GUICidade() {
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
		lbIdCidade = new JLabel("ID Cidade:");
		lbIdRegistroGeral = new JLabel("ID Geral:");
		lbIdEstado = new JLabel("ID Estado: ");
		lbNmCidade = new JLabel("Nomde Cidade: ");

		
		//Instanciando Text Field
		tfIdCidade = new JTextField();
		tfIdRegistroGeral = new JTextField();
		tfIdEstado = new JTextField();
		tfNmCidade = new JTextField();

		
		//Set Bouds labels
		lbIdCidade.setBounds(25, 30, 100, 25);
		lbIdRegistroGeral.setBounds(25, 65, 100, 25);
		lbIdEstado.setBounds(25, 100, 100, 25);
		lbNmCidade.setBounds(25, 135, 100, 25);

		
		//set Bounds Text Fields
		tfIdCidade.setBounds(130, 30, 200, 25);
		tfIdRegistroGeral.setBounds(130, 65, 200, 25);
		tfIdEstado.setBounds(130, 100, 200, 25);
		tfNmCidade.setBounds(130, 135, 200, 25);

		
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
		
		add(lbIdCidade);
		add(lbIdRegistroGeral);
		add(lbIdEstado);
		add(lbNmCidade);

		
		add(tfIdCidade);
		add(tfIdRegistroGeral);
		add(tfIdEstado);
		add(tfNmCidade);

	}
	
	private void definirEventos() {

		btInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CidadeController cidade = new CidadeController();
				if (tfIdCidade.getText().equals("") || tfIdRegistroGeral.getText().equals("")
						|| tfIdEstado.getText().equals("") || tfNmCidade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdCidade.getText());
					int idGeral = Integer.parseInt(tfIdRegistroGeral.getText());
					int idEstado = Integer.parseInt(tfIdEstado.getText());
					JOptionPane.showMessageDialog(null,
							cidade.insereCidade(id, idGeral, idEstado,tfNmCidade.getText()));
					tfIdCidade.setText("");
					tfIdRegistroGeral.setText("");
					tfIdEstado.setText("");
					tfNmCidade.setText("");
				}
			}
		});
		
		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CidadeController cidade = new CidadeController();
				if (tfIdCidade.getText().equals("") || tfIdRegistroGeral.getText().equals("")
						|| tfIdEstado.getText().equals("") || tfNmCidade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdCidade.getText());
					int idGeral = Integer.parseInt(tfIdRegistroGeral.getText());
					int idEstado = Integer.parseInt(tfIdEstado.getText());
					JOptionPane.showMessageDialog(null,
							cidade.alteraCidade(id, idGeral, idEstado,tfNmCidade.getText()));
					tfIdCidade.setText("");
					tfIdRegistroGeral.setText("");
					tfIdEstado.setText("");
					tfNmCidade.setText("");
				}
			}
		});
		
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CidadeController cidade = new CidadeController();
				if (tfIdCidade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Cidade");
					tfIdCidade.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdCidade.getText());
					JOptionPane.showMessageDialog(null,
							cidade.excluiCidade(id));
					tfIdCidade.setText("");
					tfIdRegistroGeral.setText("");
					tfIdEstado.setText("");
					tfNmCidade.setText("");
				}
				
			}
		});
		
		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CidadeController cidade = new CidadeController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfIdCidade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Cidade");
					tfIdCidade.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdCidade.getText());
					dados = cidade.listaUmaCidade(id);
					if (dados != null) {
						tfIdRegistroGeral.setText(dados.get(1));
						tfIdEstado.setText(dados.get(2));
						tfNmCidade.setText(dados.get(3));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
					
				}
				
			}
		});
		
		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CidadeController cidade = new CidadeController();
				String dados = cidade.listaCidades();
				JOptionPane.showMessageDialog(null, dados);
				
			}
		});
		
	}
}
