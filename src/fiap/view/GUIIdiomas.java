package fiap.view;

/**Classe de Interface GUI para mostrar as informacoes de Idiomas
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import fiap.controller.EstadoController;
import fiap.controller.IdiomaCandidatoController;
import fiap.controller.IdiomasController;

@SuppressWarnings({ "serial", "unused" })
public class GUIIdiomas extends JPanel{

	private JButton btInserir, btUpdate, btExcluir, btSelectById, btSelectAll;
	private JLabel lbIdIdiomas, lbTpIdiomas;
	private JTextField tfIdIdiomas, tfTpIdiomas;
	
	public GUIIdiomas() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.CYAN);

		
		//Instanciando Bot�es 
		btInserir = new JButton("Inserir");
		btUpdate = new JButton("Atualizar");
		btExcluir = new JButton("Excluir");
		btSelectById = new JButton("Select ID");
		btSelectAll = new JButton("SelectAll");
		
		//Instanciando Labels
		lbIdIdiomas = new JLabel("ID Idioma:");
		lbTpIdiomas = new JLabel("Idioma:");
	
		
		//Instanciando Text Field
		tfIdIdiomas = new JTextField();
		tfTpIdiomas = new JTextField();

		
		//Set Bouds labels
		lbIdIdiomas.setBounds(25, 30, 100, 25);
		lbTpIdiomas.setBounds(25, 65, 100, 25);

		
		//set Bounds Text Fields
		tfIdIdiomas.setBounds(130, 30, 200, 25);
		tfTpIdiomas.setBounds(130, 65, 200, 25);

		
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
		
		add(lbIdIdiomas);
		add(lbTpIdiomas);

		
		add(tfIdIdiomas);
		add(tfTpIdiomas);

	}
	
	private void definirEventos() {

		btInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdiomasController idioma = new IdiomasController();
				if (tfIdIdiomas.getText().equals("") || tfTpIdiomas.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdIdiomas.getText());
					JOptionPane.showMessageDialog(null, idioma.insereIdioma(id, tfTpIdiomas.getText()));
					tfIdIdiomas.setText("");
					tfTpIdiomas.setText("");
					
				}
				
			}
		});
		
		btUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdiomasController idioma = new IdiomasController();
				if (tfIdIdiomas.getText().equals("") || tfTpIdiomas.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdIdiomas.getText());
					JOptionPane.showMessageDialog(null, idioma.alteraIdioma(id, tfTpIdiomas.getText()));
					tfIdIdiomas.setText("");
					tfTpIdiomas.setText("");
					
				}
				
			}
		});
		
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdiomasController idioma = new IdiomasController();
				if (tfIdIdiomas.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Idioma");
				} else {
					int id = Integer.parseInt(tfIdIdiomas.getText());
					JOptionPane.showMessageDialog(null, idioma.excluiIdioma(id));
					tfIdIdiomas.setText("");
					tfTpIdiomas.setText("");
					
				}
				
			}
		});
		
		btSelectById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdiomasController idioma = new IdiomasController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfIdIdiomas.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Idioma");
					tfIdIdiomas.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdIdiomas.getText());
					dados = idioma.listaUmIdioma(id);
					if (dados != null) {
						tfTpIdiomas.setText(dados.get(1));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
					
				}
				
			}
		});
		
		btSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdiomasController idioma = new IdiomasController();
				String dados = idioma.listaIdiomas();
				JOptionPane.showMessageDialog(null, dados);
				
			}
		});
		
	}
}
