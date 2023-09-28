package pizzeria;

public abstract class Pizza {

	private static int id;
	private int tiempoCoccion;
	private double precio;

	static {
		id = 0;
	}

	public Pizza(double precio, int tiempoCoccion) {
		this.id++;
		this.tiempoCoccion = tiempoCoccion;
		this.precio = precio;
	}

	public static int getId() {
		return id;
	}

	public int getTiempoCoccion() {
		return tiempoCoccion;
	}

	public void setTiempoCoccion(int tiempoCoccion) {
		this.tiempoCoccion = tiempoCoccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "TiempoCoccion=" + tiempoCoccion + ", Precio=" + precio +", Código=" + id ;
	}

}
