package tres;

import java.util.concurrent.Semaphore;

public class Main2 {

	public static void main(String[] args) {
		
		AlmacenNproductos<Integer> almacen = new AlmacenNproductos<Integer>();
		Semaphore datos = new Semaphore(0);
		Semaphore m = new Semaphore(1);
		//Mejor dos semaforos o un contador de productos que a su vez habria que proteger..?
		ConsumidorN<Integer> consumidor = new ConsumidorN<Integer>(almacen, datos,m);
		ProductorN<Integer> productor = new ProductorN<Integer>(almacen,datos,m);
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
