package pizzeria;

public class PizzaCalzone extends Pizza {

	public PizzaCalzone(double precio, int tiempoCoccion) {
		super((precio * 0.05) + precio, (tiempoCoccion));

	}

	@Override
	public String toString() {
		return "Pizza Calzone: " + super.toString();
	}

}
