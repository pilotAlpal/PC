package tres;

import java.util.concurrent.Semaphore;

public class ConsumidorN<T> extends Thread {

	private AlmacenNproductos<T> miAlmacen;
	private Semaphore miDatos,miMu;
	public ConsumidorN(AlmacenNproductos<T> almacen, Semaphore semaforo, Semaphore m) {
		miAlmacen=almacen;
		miDatos=semaforo;
		miMu=m;
		
	}
	@Override
	public void run(){
		while(true){
			try {
				miDatos.acquire();
			} catch (InterruptedException e) {
				System.err.println("consumidor.datos.acquire");
				e.printStackTrace();
			}
			try {
				miMu.acquire();
			} catch (InterruptedException e) {
				System.err.println("consumidor.miMu.acquire");
				e.printStackTrace();
			}
			T producto = miAlmacen.extraer();
			miMu.release();
			System.out.println("Consumido "+producto);
		}
	}

}
