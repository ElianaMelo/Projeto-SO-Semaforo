import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ThreadSemaforo extends Thread {
	private JLabel caixa;
	private JLabel portaUmVerde, portaUmVermelho;
	private JLabel portaDoisVerde, portaDoisVermelho;
	private JLabel legenda1, legenda2;

	private Semaphore semaforo;
	private JButton btnInicio;
	private static int aux;

	public ThreadSemaforo(JLabel caixa, JLabel portaUmVerde, JLabel portaUmVermelho, JLabel portaDoisVerde,
			JLabel portaDoisVermelho, Semaphore semaforo, JLabel legenda1, JLabel legenda2, JButton btnInicio) {

		this.caixa = caixa;
		this.portaUmVerde = portaUmVerde;
		this.portaUmVermelho = portaUmVermelho;
		this.portaDoisVerde = portaDoisVerde;
		this.portaDoisVermelho = portaDoisVermelho;
		this.semaforo = semaforo;
		this.legenda1 = legenda1;
		this.legenda2 = legenda2;
		this.btnInicio = btnInicio;
	}

	public void run() {
		executa();
		System.out.println("entrada metodo run, aux " + aux);
		if (aux == 2) {
			btnInicio.setVisible(true);
			aux = 0;
		}
		System.out.println("saida metodo run, aux " + aux);
	}

	public void executa() {
		try {
			System.out.println("metodo executa, semaforo.acquire aux " + aux);
			semaforo.acquire();
			acionaCaixa();

		} catch (InterruptedException e) {
			e.printStackTrace();

		} finally {
			semaforo.release();
		}
		aux++;
		System.out.println("metodo executa, aux " + aux);
	}

	public void acionaCaixa() {
		Rectangle posicao = caixa.getBounds();
		int aux = 0;
		Random random = new Random();
		System.out.println("metodo acionarCaixa, aux " + aux);

		legenda1.setVisible(false);
		legenda2.setVisible(false);
		portaUmVerde.setVisible(true);
		legenda1.setVisible(true);
		portaUmVermelho.setVisible(false);
		portaDoisVermelho.setVisible(true);
		portaDoisVerde.setVisible(false);

		while (aux < 2) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
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
				legenda1.setVisible(false);
				portaUmVermelho.setVisible(true);
				legenda2.setVisible(true);
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

			} // end if
			portaDoisVermelho.setVisible(false);
			portaDoisVerde.setVisible(true);
			portaUmVermelho.setVisible(false);
			portaUmVerde.setVisible(true);
			legenda2.setVisible(false);

		} // end while

		caixa.setVisible(true);
		caixa.setBounds(170, 329, 76, 55);

	}

}
