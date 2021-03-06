package dos;

import java.util.concurrent.Semaphore;

public class Consumidor<C> extends Thread {
	private MiAlmacen<C> miAlmacen;
	private Semaphore miS;
	
	public Consumidor(MiAlmacen<C> mA,Semaphore mS) {
		miAlmacen=mA;
		miS=mS;
	}
	
	@Override
	public void run(){
		while(true){
			while(miAlmacen.almacenVacio()){
			}
			try {
				miS.acquire();
			} catch (InterruptedException e) {
				System.err.println("Error cerrando el semaforo el consumidor");
				e.printStackTrace();
			}
			C producto = miAlmacen.extraer();
			miS.release();
			System.out.println("Consumido "+producto);
		}
	}
}