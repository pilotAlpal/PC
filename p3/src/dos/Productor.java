package dos;

import java.util.concurrent.Semaphore;

public class Productor<P> extends Thread {
	MiAlmacen<P> miAlmacen;
	Semaphore miSem;
	public Productor(MiAlmacen<P> a,Semaphore s) {
		miAlmacen=a;
		miSem=s;
	}
	@Override
	public void run(){
		while(true){
			while(!miAlmacen.almacenVacio()){
			}
			//puedo evitar este casteo?
			P p = (P) new Integer(8);
			try {
				miSem.acquire();
			} catch (InterruptedException e) {
				System.err.println("Error solicitando semaforo el productor");
				e.printStackTrace();
			}
			miAlmacen.almacenar(p);
			miSem.release();
		}
	}
}