

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Prototipo extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	
	public Prototipo() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 5, 890, 720);
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

		//JButton btnInicio = new JButton();
		//btnInicio.setBounds(160, 350, 410, 67);
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
		caixaUm.setBounds(150, 329, 76, 55);
		
		JLabel portaUmVerde = new JLabel();
		portaUmVerde.setIcon(new ImageIcon("img/portaUmVerde.png"));
		portaUmVerde.setBounds(343, 258, 12, 69);

		painel.add(steraParteUm);
		painel.add(steraParteDois);
		painel.add(steraParteTres);
		painel.add(caixaUm);
		painel.add(portaUmVerde);
		painel.add(fundoInicio);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Prototipo prototipo = new Prototipo();
	}
	
}
