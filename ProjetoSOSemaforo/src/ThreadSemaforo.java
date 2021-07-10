import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ThreadSemaforo extends Thread {
	private JLabel caixa;
	private JLabel portaUmVerde, portaUmVermelho;
	private JLabel portaDoisVerde, portaDoisVermelho;
	private Semaphore semaforo;
	private JButton btnInicio;
	private int op;
	private static int aux;

	public ThreadSemaforo(JLabel caixa, JLabel portaUmVerde, JLabel portaUmVermelho, JLabel portaDoisVerde,
			JLabel portaDoisVermelho, Semaphore semaforo, JButton btnInicio, int op) {

		this.caixa = caixa;
		this.portaUmVerde = portaUmVerde;
		this.portaUmVermelho = portaUmVermelho;
		this.portaDoisVerde = portaDoisVerde;
		this.portaDoisVermelho = portaDoisVermelho;
		this.semaforo = semaforo;
		this.btnInicio = btnInicio;
		this.op = op;
	}

	public void run() {
		executa();
		System.out.println("entrada metodo run, aux" + aux);
		if (aux == 2) {
			// fundoInicio.setVisible(true);
			btnInicio.setVisible(true);
			aux = 0;
		}
		System.out.println("saida metodo run, aux" + aux);
	}

	public void executa() {
		try {
			System.out.println("metodo executa, semaforo.acquire aux" + aux);
			semaforo.acquire();
			acionaCaixa();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			semaforo.release();
		}
		aux++;
		System.out.println("metodo executa, aux" + aux);
	}

	public void acionaCaixa() {
		Rectangle posicao = caixa.getBounds();
		int aux = 0;
		Random random = new Random();
		System.out.println("metodo acionarCaixa, aux" + aux);
		
		portaUmVerde.setVisible(true);
		portaUmVermelho.setVisible(false);
		portaDoisVermelho.setVisible(true);
		portaDoisVerde.setVisible(false);
		
		while (aux < 2) {
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (aux == 1) {
				posicao.x = (posicao.x) + (random.nextInt(2));
				if (posicao.x >= 170) {
					aux = 2;
				}
			}
			posicao.x = (posicao.x) + (random.nextInt(5));
			caixa.setBounds(posicao);

			if (posicao.x >= 355 && posicao.x <= 480) {
				portaUmVermelho.setVisible(true);
				portaUmVerde.setVisible(false);
				portaDoisVermelho.setVisible(true);
				portaDoisVerde.setVisible(false);

				try {
					Thread.sleep(90);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// aux = 1;
			if (posicao.x >= 700) {
				posicao.x = -100;
				aux = 2;
				caixa.setVisible(false);
				// System.out.println("metodo acionaCarro, aux"+aux);
				
			}// end if
			portaDoisVermelho.setVisible(false);
			portaDoisVerde.setVisible(true);
			portaUmVermelho.setVisible(false);
			portaUmVerde.setVisible(true);

		}//end while

		caixa.setVisible(true);
		caixa.setBounds(170, 329, 76, 55);
	}

}
