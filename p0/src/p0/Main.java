package p0;

public class Main {
	
	public static void main(String args[]){
		Thread a= new ThreadConHerencia("hiloUno");
		Thread b = new ThreadConHerencia("hiloDos");
		a.start();
		b.start();
		System.out.println("Final del main");
	}
}
