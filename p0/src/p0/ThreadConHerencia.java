package p0;

public class ThreadConHerencia extends Thread {
	private String palabra;

	public ThreadConHerencia(String p){
		palabra=p;
	}
	@Override
	public void run(){
		for (int i=0;i<10;i++){
			System.out.println(palabra);
		}
	}
}
