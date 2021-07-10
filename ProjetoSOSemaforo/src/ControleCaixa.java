import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;

//import controller.PrototipoThreadSemaforo;

public class ControleCaixa implements ActionListener {
	
	private JLabel caixa1, caixa2;
	private JLabel portaUmVerde, portaUmVermelho;
	private JLabel portaDoisVerde, portaDoisVermelho;
	private JButton btnInicio;
	
	private Semaphore semaforo = new Semaphore(1);
	
	public ControleCaixa(JLabel caixa1, JLabel caixa2, JLabel portaUmVerde, JLabel portaUmVermelho,
			JLabel portaDoisVerde, JLabel portaDoisVermelho, JButton btnInicio) {
		this.caixa1 = caixa1;
		this.caixa2 = caixa2;
		
		this.portaUmVerde = portaUmVerde;
		this.portaUmVermelho = portaUmVermelho;
		
		this.portaDoisVerde = portaDoisVerde;
		this.portaDoisVermelho = portaDoisVermelho;
		
		this.btnInicio = btnInicio;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ThreadSemaforo ts1 = new ThreadSemaforo(caixa1, portaUmVerde, portaUmVermelho,
				portaDoisVerde, portaDoisVermelho, semaforo, btnInicio, 1);

		ThreadSemaforo ts2 = new ThreadSemaforo(caixa2, portaUmVerde, portaUmVermelho,
				portaDoisVerde, portaDoisVermelho, semaforo, btnInicio, 2);
		
		ts1.start();
		ts2.start();
	}

}
