import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import controller.ControleCaixa;


public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	
	public Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 5, 700, 720);
		setResizable(false);

		painel = new JPanel();

		//Color minhaCor = new Color(217, 228, 241);
		painel.setBackground(Color.white);
		
		setContentPane(painel);

		painel.setLayout(null);

		/* Fundo início */
		JLabel fundoInicio = new JLabel();
		fundoInicio.setBounds(0, 0, 700, 700);
		//fundoInicio.setIcon(new ImageIcon("img/fundo_inicio.png"));

		JButton btnInicio = new JButton("Iniciar");
		btnInicio.setBounds(100, 100, 410, 67);
		//btnInicio.setBackground(Color.white);

		JLabel steraParteUm = new JLabel();
		steraParteUm.setIcon(new ImageIcon("img/ParteUm.png"));
		steraParteUm.setBounds(106, 354, 410, 250);
		
		JLabel steraParteDois = new JLabel();
		steraParteDois.setIcon(new ImageIcon("img/ParteDois.png"));
		steraParteDois.setBounds(355, 205, 700, 370);
		
		JLabel steraParteTres = new JLabel();
		steraParteTres.setIcon(new ImageIcon("img/ParteTres.png"));
		steraParteTres.setBounds(546, 351, 410, 250);

		JLabel caixaUm = new JLabel();
		caixaUm.setIcon(new ImageIcon("img/caixaUm.png"));
		caixaUm.setBounds(170, 329, 76, 55);
		
		JLabel caixaDois = new JLabel();
		caixaDois.setIcon(new ImageIcon("img/caixaDois.png"));
		caixaDois.setBounds(180, 329, 76, 55);
		
		JLabel portaUmVerde = new JLabel();
		portaUmVerde.setIcon(new ImageIcon("img/portaUmVerde.png"));
		portaUmVerde.setBounds(343, 258, 12, 69);
		
		JLabel portaUmVermelho = new JLabel();
		portaUmVermelho.setIcon(new ImageIcon("img/portaUmVermelha.png"));
		portaUmVermelho.setBounds(343, 330, 12, 69);

		JLabel portaDoisVerde = new JLabel();
		portaDoisVerde.setIcon(new ImageIcon("img/portaDoisVerde.png"));
		portaDoisVerde.setBounds(548, 258, 12, 69);
		
		JLabel portaDoisVermelho = new JLabel();
		portaDoisVermelho.setIcon(new ImageIcon("img/portaDoisVermelha.png"));
		portaDoisVermelho.setBounds(548, 330, 12, 69);
		
		painel.add(steraParteUm);
		painel.add(steraParteDois);
		painel.add(steraParteTres);
		painel.add(caixaUm);
		painel.add(caixaDois);
		painel.add(portaUmVerde);
		painel.add(portaUmVermelho);
		painel.add(portaDoisVerde);
		painel.add(portaDoisVermelho);
		
		painel.add(btnInicio);
		painel.add(fundoInicio);
		
		this.setVisible(true);
		
		ControleCaixa cc = new ControleCaixa(caixaUm, caixaDois, portaUmVerde, portaUmVermelho, portaDoisVerde, portaDoisVermelho);

		btnInicio.addActionListener(cc);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

}
