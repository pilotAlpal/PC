package dos;

public class MiAlmacen<T> implements Almacen<T> {

	private boolean lleno;
	private T contenedor;
	
	public MiAlmacen(){
		lleno=false;
	}
	@Override
	public boolean almacenVacio(){
		return !lleno;
	}

	@Override
	public T extraer() {
		if(almacenVacio())
			System.err.println("Intentando extraer con el contenedor vacio");
		else
			lleno=false;
		
		return contenedor;
		
	}

	@Override
	public void almacenar(T producto) {
		if (!almacenVacio())
			System.err.println("Intentando llenar con el contenedor lleno");
		else{
			lleno=true;
			contenedor=producto;
		}
		
	}

}
