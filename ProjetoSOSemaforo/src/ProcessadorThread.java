import java.util.concurrent.Semaphore;

public class ProcessadorThread extends Thread{
	
	private int idThread;
	private Semaphore semaforo;
	
	public ProcessadorThread(int idThread,Semaphore semaforo) {

		this.idThread = idThread;
		this.semaforo = semaforo;
		
	}
	
	private void processar() {
		try {
			Thread.sleep((long) (Math.random() * 10000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	}
	
	private void entrarRegiaoNaoCritica() {
	    System.out.println("Thread #" + idThread + " em região não crítica");
	    processar();
	}
	
	private void entrarNaRegiaoCritica() {
		System.out.println("Thread #" + idThread + " entrando em região crítica");
		processar();
		System.out.println("Thread #" + idThread + " saindo da região crítica");
	}
	
	public void run() {
		entrarRegiaoNaoCritica();
		try {
			semaforo.acquire();
			System.out.println("entro!!!");
			entrarNaRegiaoCritica();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Saiu!!!");
			semaforo.release();
		}
	}
	
	public static void main(String[] args) {
	    int numeroDePermicoes = 1;
	    int numeroDeProcessos = 5;
	    Semaphore semaphore = new Semaphore(numeroDePermicoes);
	    ProcessadorThread[] processos = new ProcessadorThread[numeroDeProcessos];
	    for (int i = 0; i < numeroDeProcessos; i++) {
	        processos[i] = new ProcessadorThread(i, semaphore);
	        processos[i].start();
	    }
	}

}
