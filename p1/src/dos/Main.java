package dos;

public class Main {
	
	static int a=0;
	static final int N=20;
	private static Thread hilos [];
	
	
	
	private static class HiloRestador extends Thread{
		
		@Override
		public void run(){
			a--;
		}
	}
	private static class HiloSumador extends Thread{	
		@Override
		public void run(){
			a++;
		}
	}
	
	public static void main(String[] args) {
		hilos=new Thread[2*N];
		for (int i=0;i<2*N;i=i+2){
			hilos[i]= new HiloRestador();
			hilos[i+1]=new HiloSumador();
			hilos[i].start();
			hilos[i+1].start();
/*			try {
 * 			meter el join en otro for para forzar la ejecucion 
				hilos[i+1].join();
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//Por que garantiza el join espera activa?
		}
		System.out.println(a);

	}

}
