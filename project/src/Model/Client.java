package Model;

public class Client extends Personne {

	private int id;
    private double solde;
    private Adresse adresse;
    
    public Client(String nom, String prenom, double solde, Adresse adresse) {
		super(nom, prenom);
		this.solde = solde;
		this.adresse = adresse;
	}
    
    public Client(int id, String nom, String prenom, double solde, Adresse adresse) {
		super(nom, prenom);
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

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public String toString(){
		return "["+this.getId()+"] "+ this.getNom() + " " + this.getPrenom() +" "+ solde + " " + this.adresse.getCode_postal();
	}
}
