import java.util.concurrent.BlockingQueue;

public class GeneradorClientes implements Runnable {
	private int clientesIniciales;
	private int clientesPorSegundo;
	private long tiempoMaximo;
	private BlockingQueue q;
	private int id;
	
	public GeneradorClientes(int clientesIniciales, int clientesPorSegundo, long tiempoMaximo, BlockingQueue q) {
		super();
		this.clientesIniciales = clientesIniciales;
		this.clientesPorSegundo = clientesPorSegundo;
		this.tiempoMaximo = tiempoMaximo;
		this.q = q;
	}
	
	@Override
	public void run() {
		long tiempoInicial = System.nanoTime();
		// TODO: generamos "clientesIniciales" y los encolamos
		
		for(int i=0; i < clientesIniciales; i++){
			Cliente cliente = new Cliente(id);
			id = id +1;
			try {
				q.put(cliente);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// mientras no nos pasemos del tiempoMaximo 
		while ((System.nanoTime() - tiempoInicial) < tiempoMaximo) {
			// TODO: esperar y generar cliente según "clientesPorSegundo".
			
			try {
				Thread.sleep(1000);
				
				for(int i=0; i < clientesPorSegundo; i++){
					Cliente cliente = new Cliente(id);
					id = id +1;
					try {
						q.put(cliente);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// TODO: Imprimir "Cerrando supermercado, ya no entran más clientes."
		System.out.println("Cerrando supermercado, ya no entran m�s clientes.");
	}

}

