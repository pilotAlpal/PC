package uno;

public class Main {
	
	private static int a=0;
	private final static int N=10;
	private volatile static boolean libre=true,turnoSuma=false;
	//que hace realmente volatile?
	/*cuando se modifica su valor esta actualizado para todos los demas hilos*/
	private static class Resta extends Thread{
		@Override
		public void run(){
			while(!libre||turnoSuma)
			{}
			libre=false;
			for(int i=0;i<N;i++){
				a--;
			}
			libre=true;
			turnoSuma=true;
		}
	}
	
	private static class Suma extends Thread{
		@Override
		public void run(){
			while (!libre||!turnoSuma)
			{}
			libre=false;
			for(int i=0;i<N;i++){
				a++;
			}
			libre=true;
			turnoSuma=false;
		}
	}

	public static void main(String[] args) {
		
		Thread c= new Resta();
		Thread b = new Suma();
		c.start();
		b.start();
		try {
			c.join();b.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(a);
	}

}
