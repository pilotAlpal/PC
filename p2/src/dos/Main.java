package dos;

public class Main {

	private static int shared = 0,turno=0;
	private final static int N = 10;
	
	private static class Sumador extends Thread
	{
		private int turn;
		public Sumador(int tu) {
			turn=tu;
		}
		@Override 
		public void run(){
			while(turno!=turn){}
			shared++;
			turno++;
		}
	}
	private static class Restador extends Thread{
		private int turn;
		public Restador(int t) {
			turn=t;
		}
		@Override	
		public void run(){
			while(turno!=turn){}
			shared--;
			turno++;
		}
	}
	public static void main(String[] args) {
		Thread hilos[]=new Thread[2*N];
		for(int i=0;i<2*N;i=i+2){
			hilos[i]=new Sumador(i);
			hilos[i+1]=new Restador(i+1);
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
