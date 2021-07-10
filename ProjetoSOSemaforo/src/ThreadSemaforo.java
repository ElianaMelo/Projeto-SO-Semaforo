import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JLabel;

public class ThreadSemaforo extends Thread {
	private JLabel caixa;
	private JLabel portaUmVerde, portaUmVermelho;
	private JLabel portaDoisVerde, portaDoisVermelho;
	private Semaphore semaforo;
	private int op;
	private static int aux;
	
	public ThreadSemaforo(JLabel caixa,JLabel portaUmVerde, JLabel portaUmVermelho,
			JLabel portaDoisVerde, JLabel portaDoisVermelho, Semaphore semaforo, int op) {
	
		this.caixa = caixa;
		this.portaUmVerde = portaUmVerde;
		this.portaUmVermelho = portaUmVermelho;
		this.portaDoisVerde = portaDoisVerde;
		this.portaDoisVermelho = portaDoisVermelho;
		this.semaforo = semaforo;
		this.op = op;
	}
	
	public void run() {
		executa();
		System.out.println("entrada metodo run, aux"+aux);
		if (aux == 2) {
			//fundoInicio.setVisible(true);
			//btnInicio.setVisible(true);
			aux = 0;
		}
		System.out.println("saida metodo run, aux"+aux);
	}
	
	public void executa() {
		try {
			System.out.println("metodo executa, semaforo.acquire aux"+aux);
			semaforo.acquire();
			acionaCaixa();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			semaforo.release();
		}
		aux++;
		System.out.println("metodo executa, aux"+aux);
	}
	
	public void acionaCaixa() {
		Rectangle posicao = caixa.getBounds();
		int aux = 0;
		Random random = new Random();
		System.out.println("metodo acionarCarro, aux"+aux);
		switch (op) {
		
		case 2:
			//portaUmVermelho.setVisible(false);
			//portaUmVerde.setVisible(true);
			//portaDoisVermelho.setVisible(true);
			//portaDoisVerde.setVisible(false);
			while (aux < 2) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (aux == 1) {
					posicao.y = (posicao.y) + (random.nextInt(2));
					if (posicao.y >= 46) {
						aux = 2;
					}
					System.out.println("Carro 1:se aux == 1 Posicao: X:"+ posicao.x+"   Y:"+posicao.y);
				}
				posicao.y = (posicao.y) + (random.nextInt(5));
				caixa.setBounds(posicao);
				System.out.println("Posicao: X:"+ posicao.x+"  Y:"+posicao.y);
				if (posicao.y >= 800) {
					posicao.y = -100;
					aux = 1;
					System.out.println("metodo acionaCarro, aux"+aux);
				}
			}
			//portaUmVermelho.setVisible(false);
			//portaUmVerde.setVisible(true);
			//portaDoisVermelho.setVisible(true);
			//portaDoisVerde.setVisible(false);

			break;
		case 1:
			portaUmVerde.setVisible(true);
			portaUmVermelho.setVisible(false);
			portaDoisVermelho.setVisible(true);
			portaDoisVerde.setVisible(false);
			while(aux<2) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if(aux == 1) {
					posicao.x = (posicao.x)+(random.nextInt(2));
					if(posicao.x >= 170) {
						aux = 2;
					}
					System.out.println("Carro 2: se aux == 1 Posicao: X:"+ posicao.x+"    Y:"+posicao.y);
				}
				posicao.x = (posicao.x)+(random.nextInt(5));
				caixa.setBounds(posicao);
				System.out.println("Posicao: X:"+ posicao.x+"  Y:"+posicao.y);
				
				if(posicao.x >= 355 && posicao.x <= 480) {
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
				
				portaDoisVermelho.setVisible(false);
				portaDoisVerde.setVisible(true);
				portaUmVermelho.setVisible(false);
				portaUmVerde.setVisible(true);
				
				//aux = 1;
				if(posicao.x >= 700) {
					posicao.x = -100;
					aux = 1;
					//System.out.println("metodo acionaCarro, aux"+aux);
				}
				
			}
			break;
			}
		}

}
