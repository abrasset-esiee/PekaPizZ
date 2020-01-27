package Model;

public class Client extends Personne {

	private int id;
    private double solde;
    Adresse adresse;
    
    public Client(int id, String nom, String prenom, double solde, Adresse adresse) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
		this.id = id;
		this.solde = solde;
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
}
