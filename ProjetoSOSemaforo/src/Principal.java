import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	
	public Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 5, 700, 720);
		setResizable(false);

		painel = new JPanel();

		setContentPane(painel);

		painel.setLayout(null);

		/* Fundo início */
		JLabel fundoInicio = new JLabel();
		fundoInicio.setBounds(0, 0, 700, 700);
		//fundoInicio.setIcon(new ImageIcon("img/fundo_inicio.png"));

		JButton btnInicio = new JButton();
		btnInicio.setBounds(160, 350, 410, 67);
		btnInicio.setBackground(Color.white);

		JLabel nomeBotao = new JLabel();
		nomeBotao.setIcon(new ImageIcon("img/start.png"));

		btnInicio.add(nomeBotao);

		painel.add(btnInicio);
		painel.add(fundoInicio);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal(); 
	}

}
