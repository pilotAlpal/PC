package tres;

import java.lang.Thread;
import java.util.concurrent.Semaphore;

public class ProductorN<T extends Number> extends Thread {
	
	private AlmacenNproductos<T> miAlmacen;
	private Semaphore miDatos,miMu;
	public ProductorN(AlmacenNproductos<T> almacen, Semaphore semaforo, Semaphore m) {
		miAlmacen=almacen;
		miDatos=semaforo;
		miMu=m;
	}
	@Override
	public void run(){
		while(true){
			T producto=(T) new Integer (3);
			try {
				miMu.acquire();
			} catch (InterruptedException e) {
				System.err.println("MiMu.acquire productor");
				e.printStackTrace();
			}
			miAlmacen.almacenar(producto);
			miMu.release();
			miDatos.release();
		}
	}

}
