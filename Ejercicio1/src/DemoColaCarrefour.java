import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DemoColaCarrefour {
	public static void main(String[] args) {
		// TODO: creamos nuestra BloquingQueue
		
		BlockingQueue<Cliente> q = new ArrayBlockingQueue<Cliente>(1000);
		
		// TODO: Creamos y arrancamos el generador de clientes. Por ejemplo:
				// 30 clientes iniciales
				// 2 clientes nuevos por segundo
				// 100 segundos antes de cerrar las puertas del super...
		
		GeneradorClientes genClientes = new GeneradorClientes(30,2,100,q);
		new Thread(genClientes).start();
		
		// 3 cajeros para atender
		for(int i=0; i<3; i++) {
			// TODO: Creamos y arrancamos los cajeros en sus Threads
			Cajero cajero = new Cajero(i+1,2,100,q);
			new Thread(cajero).start();
			
		}
		
		
		
		// TODO: Imprimir cada 2segundos el tamaño de la cola
		
		// TODO: Esperamos a que se vayan los clientes y cajeros para cerrar el super
		// y imprimimos "SUPERMERCADO CERRADO."
		
		System.out.println("SUPERMERCADO CERRADO");
		
		
		
	}
}
