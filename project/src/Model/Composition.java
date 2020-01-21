package project;

public class Composition {

	private int id; // tableau d'int ?
	Pizza pizza;
	
	public Composition(int id, Pizza pizza) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.pizza = pizza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
