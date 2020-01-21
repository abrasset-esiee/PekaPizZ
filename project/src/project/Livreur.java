package project;

public class Livreur extends Personne {

	private int id;
	
	public Livreur(int id, String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
}
