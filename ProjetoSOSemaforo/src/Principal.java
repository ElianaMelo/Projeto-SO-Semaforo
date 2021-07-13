import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

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
		setSize(900, 700);
		setLocationRelativeTo(null);
		setResizable(false);

		painel = new JPanel();

		// Color minhaCor = new Color(217, 228, 241);
		painel.setBackground(Color.white);

		setContentPane(painel);

		painel.setLayout(null);

		/* Fundo início */
		JLabel titulo = new JLabel("Linha de Produção com uso de Semáforo");
		titulo.setBounds(180, 50, 700, 80);
		titulo.setFont(new Font("Verdana", Font.BOLD, 25));
		// fundoInicio.setIcon(new ImageIcon("img/fundo_inicio.png"));

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
		caixaDois.setBounds(175, 329, 76, 55);

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

		JLabel legenda1 = new JLabel("DOWN");
		legenda1.setBounds(240, 250, 80, 80);
		legenda1.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel legenda2 = new JLabel("UP");
		legenda2.setBounds(590, 250, 80, 80);
		legenda2.setFont(new Font("Verdana", Font.BOLD, 20));		

		JButton btnInicio = new JButton("Iniciar");
		btnInicio.setBounds(380, 600, 140, 40);
		// btnInicio.setBackground(Color.white);

		painel.add(steraParteUm);
		painel.add(steraParteDois);
		painel.add(steraParteTres);
		painel.add(caixaUm);
		painel.add(caixaDois);
		painel.add(portaUmVerde);
		painel.add(portaUmVermelho);
		painel.add(portaDoisVerde);
		painel.add(portaDoisVermelho);

		painel.add(legenda1);
		painel.add(legenda2);

		painel.add(btnInicio);
		painel.add(titulo);

		this.setVisible(true);

		ControleCaixa cc = new ControleCaixa(caixaUm, caixaDois, portaUmVerde, portaUmVermelho, portaDoisVerde,
				portaDoisVermelho, legenda1, legenda2, btnInicio);

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
