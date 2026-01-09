package estructuras;

public class Pila {
	
	private String[] array; //Array que sustenta la pila.
	private int tamanioInicial;//Tamaño inicial de array.
	private int fin;
		
	/**
	 * Constructor de una Pila
	 * @param tamanioInicial Espacio que tendrá el array que usaremos para
	 * implementar la pila inicialmente. Cuando la pila esté a punto de llenarse,
	 * se añadirán "tamanioInicial" posiciones extra al array; cuando decrezca,
	 * se redimensionará el array a "tamanioInicial" posiciones menos.
	 */
	public Pila(int tamanioInicial) {
		this.tamanioInicial=tamanioInicial;
		array=new String[tamanioInicial];
		fin=0; //Al crear una pila, esta está vacía, y su fin es =0.
	}
	
	/**
	 * Inserta en la pila un String
	 * @param s String a introducir.
	 */
	public void push(String s) {
		Depurador.imprimirTraza("Se añade "+s+" a la pila.");
		if(fin==array.length){
			String[] arrayMayor=new String[array.length+3];
			for(int i=0;i<array.length;i++) {
				arrayMayor[i]=array[i];
			}
			
			array=arrayMayor;
			array[fin]=s;
			System.out.println(toString(array));
		}else
		array[fin]=s;
		fin++; //Se incrementa el valor del puntero al final de la cola
		Depurador.imprimirTraza("Valor del puntero 'fin':"+fin);
		System.out.println(toString(array));
	}
	
	public String pop() {
		//Se decrementa el valor del puntero al final de la cola
		Depurador.imprimirTraza("Valor del puntero 'fin':"+fin);
		Depurador.imprimirTraza("Se saca un elemento de la pila.");
		String aSacar=array[fin];
		array[fin]=null;
		String[] arrayMenor=new String[array.length-3];
		if((array.length+1)-fin==3) {
			for(int i=0;i<arrayMenor.length-1;i++) {
				arrayMenor[i]=array[i];
				array=arrayMenor;
			}
		}
		fin--;
		return aSacar;
		
	}
	public String[] clonar (String[] origen,String[] destino) {
		int menorTamanio;
		if(origen.length<destino.length)
			menorTamanio=origen.length;
		else
			menorTamanio=destino.length;
		
		for(int i=0;i<menorTamanio;i++)
			destino[i]=origen[i];
		
		return destino;		
	}
	public String toString(String[] array) {
		String cadena="{";
		for(int i=0;i<array.length;i++) {
			cadena+=array[i];
			if(i<array.length-1)
				cadena+=",";
		}
		cadena+="}";
		return cadena;
	}
}
