package pizzeria;

import javax.swing.JOptionPane;

public class Main {

		public static Pizza crearPizza() {
	        String cadena;
	        double precio;
	        int segundosHorno;
	        boolean correcto = false;

	        precio = Integer.parseInt(JOptionPane.showInputDialog("¿Cuánto vale la pizza?"));
	        segundosHorno = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos segundos tarda en hacerse la pizza?"));
	        do {
	            cadena = (JOptionPane.showInputDialog("¿Qué tipo de pizza quieres (Clasica/Calzzone)"));
	            if (cadena.equalsIgnoreCase("Normal")) {
	                cadena = (JOptionPane.showInputDialog("¿La pizza lleva borde de queso (Sí/No)?"));
	                if (cadena.equalsIgnoreCase("Si")) {
	                    return new PizzaClasica(precio, segundosHorno, true);
	                } else {
	                    return new PizzaClasica(precio, segundosHorno, false);
	                }
	            } else if (cadena.equalsIgnoreCase("Calzone")) {
	                return new PizzaCalzone(precio, segundosHorno);
	            }
	        } while (!correcto);
	        return null;
	    }

	    public static int menu() {

	        int opcion = 0;

	        do {
	            System.out.println(" -- MENU --");
	            System.out.println("1. Insertar Pizza");
	            System.out.println("2. Cantidad Porcentual de Pizzas clasicas con borde relleno de queso");
	            System.out.println("3. Encender el horno");
	            System.out.println("4. Salir");
	            opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Introduzca una opción?"));
	        } while ((opcion < 1) || (opcion > 4));

	        return opcion;
	    }

	    public static void main(String[] args) {
	        int longitudCola;
	        longitudCola = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el tamaño de la cola de pizzas"));

	        Cola Horno1 = new Cola(longitudCola);

	        int opcion = 0;

	        do {
	            opcion = menu();

	            switch (opcion) {
	                case 1 -> {
	                    Pizza pizza = crearPizza();
	                    if (Horno1.push(pizza)) {
	                        System.out.println("Pizza introducida con exito");
	                    } else {
	                        System.out.println("No se ha podido introducir la pizza");
	                    }
	                }
	                case 2 -> {
	                    double porcentaje;
	                    int numQueso = 0;
	                    for (int i = 0; i < Horno1.getNumElementos(); i++) {
	                        Pizza pizza = Horno1.pop();
	                        if (pizza instanceof PizzaClasica) {
	                            boolean queso = ((PizzaClasica) pizza).tieneQueso();
	                            if (queso) {
	                                numQueso++;
	                            }
	                        }
	                        Horno1.push(pizza);
	                    }
	                    porcentaje = (100 * numQueso) / Horno1.getNumElementos();
	                    System.out.println("El porcentaje de pizas con el borde de queso es el: " + porcentaje + "%");
	                }
	                case 3 -> {
	                    int numVUeltas = Horno1.getNumElementos();
	                    try {
	                        for (int i = 0; i < numVUeltas; i++) {
	                            Pizza hornoPizza = Horno1.pop();
	                            if (hornoPizza instanceof PizzaClasica) {
	                                Horno1.push(hornoPizza);
	                            } else if (hornoPizza instanceof PizzaCalzone) {
	                                System.out.println(hornoPizza);
	                                Thread.sleep((hornoPizza.getTiempoCoccion() * 1000));
	                            }
	                        }
	                        for (int i = 0; i <= Horno1.getNumElementos(); i++) {
	                            Pizza hornoPizza = Horno1.pop();
	                            if (hornoPizza instanceof PizzaClasica) {
	                                System.out.println(hornoPizza);
	                                Thread.sleep((hornoPizza.getTiempoCoccion() * 1000));
	                            }
	                        }
	                        }catch (Exception e) {
	                        System.out.println(e);
	                        }
	                    }
	                
	            
	            case 4 -> {
	                    System.out.println("Saliendo de la aplicacion");
	                }
	            }
	        } while (opcion != 4);

	        }

	    }
