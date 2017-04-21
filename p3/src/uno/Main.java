package uno;

import java.util.concurrent.Semaphore;

public class Main {

	private static Semaphore s=new Semaphore(1);
	private static int shared = 0;
	private final static int N = 10;
	
	private static class Sumador extends Thread
	{
		
		@Override 
		public void run(){
			try {
				s.acquire();
				shared++;
				s.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	}
	private static class Restador extends Thread{
		
		@Override	
		public void run(){
			try {
				s.acquire();
			} catch (InterruptedException e) {
				System.err.println("Error solicitando el semaforo");
				e.printStackTrace();
			}
			shared--;
			s.release();
		}
	}
	public static void main(String[] args) {
		
		Thread hilos[]=new Thread[2*N];
		for(int i=0;i<2*N;i=i+2){
			hilos[i]=new Sumador();
			hilos[i+1]=new Restador();
			hilos[i].start();
			hilos[i+1].start();
			try {
				hilos[i].join();
				hilos[i+1].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(shared);
		
	}

}
