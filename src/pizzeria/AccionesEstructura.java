package pizzeria;

public interface AccionesEstructura<T> {

	// Recibe un elemento y devuelve true si lo mete y false si no.
	public boolean push(T elemento);

	// Devuelve el siguiente elemento que tiene que atender
	public T pop();

	// Devuelve true si la cola no tiene procesos y false en caso contrario
	public boolean esVacia();

	// Devuelve el número de procesos que hay en la estructura
	public int getNumElementos();
	
}