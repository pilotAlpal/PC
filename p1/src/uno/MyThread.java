package uno;
public class MyThread extends Thread { 
	
	private int miId,sl;
	
	public MyThread(int n,int t){
		miId=n;
		sl=100*t;
	}
	@Override
	public void run(){
		System.out.println("miId : "+miId);
		try {
			sleep(sl);
		} catch (InterruptedException e) {
			System.err.println(miId+" interrumpido");
			e.printStackTrace();
		}
	}
}
