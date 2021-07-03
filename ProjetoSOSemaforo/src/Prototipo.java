

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
		steraParteUm.setBounds(20, 350, 410, 250);
		
		JLabel steraParteTres = new JLabel();
		steraParteTres.setIcon(new ImageIcon("img/ParteTres.png"));
		steraParteTres.setBounds(590, 350, 410, 250);

		JLabel steraParteDois = new JLabel();
		steraParteDois.setIcon(new ImageIcon("img/ParteDois.png"));
		steraParteDois.setBounds(300, 280, 700, 370);
		

		painel.add(steraParteUm);
		painel.add(steraParteDois);
		painel.add(steraParteTres);
		painel.add(fundoInicio);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Prototipo prototipo = new Prototipo();
	}
	
}
