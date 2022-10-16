package fiap.view;

/**Classe de Interface GUI Principal
 * @author Luis Felipe
 * @version 1.0
 * @since 16/10/2022
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame {
	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnUsuarios, mnPreCadastro, mnInfoExtras;
	private JMenuItem miSair, miCandidato, miRecrutador, miEstado, miLinguagemProgramacao, miIdiomas, miCursos;
	private JMenuItem miTelefone, miCidade, miLinguagemProgCandidato, miFormacaoAcademica, miLink, miIdiomaCandidato, miCursoCandidato, miExperiencia;
	
	public GUIPrincipal() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setTitle("Janela Principal");
		setBounds(0, 0, 800, 600);
		contentPane = getContentPane();
		
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnUsuarios= new JMenu("Usuarios");
		mnUsuarios.setMnemonic('U');
		mnPreCadastro = new JMenu("Info Pre-Cadastro");
		mnPreCadastro.setMnemonic('P');
		mnInfoExtras = new JMenu("Cadastro Extra Candidato");
		mnInfoExtras.setMnemonic('I');
		
		
		miSair = new JMenuItem("Sair");
		miCandidato = new JMenuItem("Candidato");
		miRecrutador = new JMenuItem("Recrutador");
		miEstado = new JMenuItem("Estado");
		miLinguagemProgramacao = new JMenuItem("Linguagem De Programacao");
		miIdiomas = new JMenuItem("Idiomas");
		miCursos = new JMenuItem("Cursos");
		miTelefone = new JMenuItem("Telefone");
		miCidade = new JMenuItem("Cidade");
		miLinguagemProgCandidato = new JMenuItem("Linguagem Programacao Candidato");
		miFormacaoAcademica = new JMenuItem("Formcao Academica");
		miLink = new JMenuItem("Link");
		miIdiomaCandidato = new JMenuItem("Idioma");
		miCursoCandidato = new JMenuItem("Curso Candidato");
		miExperiencia = new JMenuItem("Experiencia");
		miIdiomaCandidato = new JMenuItem("Idioma Candidato");
		
		setJMenuBar(mnBarra);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnUsuarios);
		mnBarra.add(mnPreCadastro);
		mnBarra.add(mnInfoExtras);
		mnArquivo.add(miSair);
		
		mnUsuarios.add(miCandidato);
		mnUsuarios.add(miRecrutador);
		
		mnPreCadastro.add(miEstado);
		mnPreCadastro.add(miLinguagemProgramacao);
		mnPreCadastro.add(miIdiomas);
		mnPreCadastro.add(miCursos);
		
		mnInfoExtras.add(miTelefone);
		mnInfoExtras.add(miCidade);
		mnInfoExtras.add(miLinguagemProgCandidato);
		mnInfoExtras.add(miFormacaoAcademica);
		mnInfoExtras.add(miLink);
		mnInfoExtras.add(miIdiomaCandidato);
		mnInfoExtras.add(miCursoCandidato);
		mnInfoExtras.add(miExperiencia);
		
	}
	
	private void definirEventos() {
		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		miCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICandidato candidato = new GUICandidato();
				contentPane.removeAll();
				contentPane.add(candidato);
				contentPane.validate();
			}
		});
		
		miRecrutador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIRecrutador recrutador = new GUIRecrutador();
				contentPane.removeAll();
				contentPane.add(recrutador);
				contentPane.validate();
			}
		});
		
		miEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIEstado es = new GUIEstado();
				contentPane.removeAll();
				contentPane.add(es);
				contentPane.validate();
			}
		});
		
		miLinguagemProgramacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUILinguagemProgramacao lp = new GUILinguagemProgramacao();
				contentPane.removeAll();
				contentPane.add(lp);
				contentPane.validate();
			}
		});
		
		miIdiomas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIIdiomas Idomas = new GUIIdiomas();
				contentPane.removeAll();
				contentPane.add(Idomas);
				contentPane.validate();
			}
		});
		
		miCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICursos cu = new GUICursos();
				contentPane.removeAll();
				contentPane.add(cu);
				contentPane.validate();
			}
		});
		
		miTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUITelefone tel = new GUITelefone();
				contentPane.removeAll();
				contentPane.add(tel);
				contentPane.validate();
			}
		});
		miCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICidade ci = new GUICidade();
				contentPane.removeAll();
				contentPane.add(ci);
				contentPane.validate();
			}
		});
		miLinguagemProgCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUILinguagemCandidato lpc = new GUILinguagemCandidato();
				contentPane.removeAll();
				contentPane.add(lpc);
				contentPane.validate();
			}
		});
		miFormacaoAcademica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIFormacaoAcademica fa = new GUIFormacaoAcademica();
				contentPane.removeAll();
				contentPane.add(fa);
				contentPane.validate();
			}
		});
		miLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUILink li = new GUILink();
				contentPane.removeAll();
				contentPane.add(li);
				contentPane.validate();
			}
		});
		miIdiomaCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIIdiomaCandidato ic = new GUIIdiomaCandidato();
				contentPane.removeAll();
				contentPane.add(ic);
				contentPane.validate();
			}
		});
		miCursoCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICursoCandidato cc = new GUICursoCandidato();
				contentPane.removeAll();
				contentPane.add(cc);
				contentPane.validate();
			}
		});
		miExperiencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIExperiencia exp = new GUIExperiencia();
				contentPane.removeAll();
				contentPane.add(exp);
				contentPane.validate();
			}
		});
		
	}
	
	public static void main(String[] args) {
		GUIPrincipal frame = new GUIPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2,
				(tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}
