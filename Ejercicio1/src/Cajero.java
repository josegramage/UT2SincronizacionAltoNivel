import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Cajero implements Runnable {
	private int id;
	private int tiempoMaximoPorCliente;
	private int maximaEspera; // tiempo máximo que estaremos sin atender antes de cerrar caja.
	private BlockingQueue q;
	
	
	public Cajero(int id, int tiempoPorCliente, int maximaEspera, BlockingQueue q) {
		super();
		this.maximaEspera = maximaEspera;
		this.tiempoMaximoPorCliente = tiempoMaximoPorCliente;
		this.id = id;
		this.q = q;
	}

	@Override
	public void run() {
		
		
		Random rand = new Random();
		
		
		try {
		int tiempo_espera = Addition(rand.nextInt(1000), (rand.nextInt()*tiempoMaximoPorCliente));
		System.out.println("CAJERO "+id+" ATENDIENDO CLIENTE "+q.take());
		//	q.put(tiempo_espera);
			
		Thread.sleep(tiempo_espera);
			System.out.println("CAJERO "+id+" FINALIZA CON CLIENTE Y. ATENDIDO EN T SEGUNDOS");
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO: mientras hayan clientes...
	
		
		
	// sacamos un cliente de la cola, imprimimos "CAJERO X ATENDIENDO CLIENTE Y"
		// esperamos un tiempo aleatorio entre 1segundo y tiempoMaximoPorCliente
		// AYUDA: (int)(rnd.nextDouble() * tiempoMaximoPorCliente + 1);

		// esperamos y imprimimos "CAJERO X FINALIZA CON CLIENTE Y. ATENDIDO EN T SEGUNDOS"
		// donde T es el tiempo que ha tardado en esperar en la cola + ser atendido.	
		// Si estamos más de "maximaEspera" segundos sin que hayan clientes imprimimos "CAJERO X CERRANDO."
	}
	
	public int Addition(int a, int b){
		int resultado = a + b;
		return resultado;		
	}
	

}
