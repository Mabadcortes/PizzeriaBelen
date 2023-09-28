package pizzeria;

public class PizzaClasica extends Pizza {

	private boolean bordeQueso;

	public PizzaClasica(double precio, int tiempoCoccion, boolean bordeQueso) {
		super(precio, tiempoCoccion);
		this.bordeQueso = bordeQueso;

	}

	public boolean tieneQueso() {
		return bordeQueso;
	}

	public boolean isBordeQueso() {
		return bordeQueso;
	}

	public void setBordeQueso(boolean bordeQueso) {
		this.bordeQueso = bordeQueso;
	}

	@Override
	public String toString() {
		return "Pizza Clásica: " + super.toString() + ", Borde con Queso=" + this.bordeQueso;
	}

}
