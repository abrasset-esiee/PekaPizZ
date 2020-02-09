package Model;

public class Livreur extends Personne {

	private int id;
	
	public Livreur(String nom, String prenom) {
		super(nom, prenom);
	}
	
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
    
	public String toString(){
		return "["+this.getId()+"] "+ this.getNom() + " " + this.getPrenom();
	}
}
