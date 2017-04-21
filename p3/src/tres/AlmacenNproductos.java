package tres;



import java.util.LinkedList;

import dos.Almacen;

public class AlmacenNproductos<Pr> implements Almacen<Pr> {
	private LinkedList<Pr> dCola;
	
	public AlmacenNproductos() {
			dCola=new LinkedList<Pr>();
	}
	
	@Override
	public void almacenar(Pr producto) {
		dCola.add(producto);
		
	}

	@Override
	public Pr extraer() {
		
		if(almacenVacio())
			System.err.println("Intentando extraer con el contenedor vacio");
		return dCola.pop();
	}

	@Override
	public boolean almacenVacio() {
		return dCola.isEmpty();
	}

}
