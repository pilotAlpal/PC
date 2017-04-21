package dos;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		
		MiAlmacen<Integer> almacen = new MiAlmacen<Integer>();
		Semaphore semaforo = new Semaphore(1);
		Consumidor<Integer> consumidor = new Consumidor<Integer>(almacen, semaforo);
		Productor<Integer> productor = new Productor<Integer>(almacen,semaforo);
		productor.start();
		consumidor.start();
		try {
			consumidor.join();
		} catch (InterruptedException e) {
			System.err.println("Error join del consumidor");
			e.printStackTrace();
		}
		try {
			productor.join();
		} catch (InterruptedException e) {
			System.err.println("Error join del productor");
			e.printStackTrace();
		}
	}

}
