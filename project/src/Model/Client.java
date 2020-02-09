package Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Client extends Personne {

	private IntegerProperty id;
    private DoubleProperty solde;
    private Adresse adresse;

    public Client(Client client){
        this(client.getNom(),client.getPrenom(),client.getSolde(),client.getAdresse());

    }
    public Client(String nom, String prenom, double solde, Adresse adresse) {
		super(nom, prenom);
		this.solde = new SimpleDoubleProperty(solde);
		this.adresse = adresse;
	}
    
    public Client(int id, String nom, String prenom, double solde, Adresse adresse) {
		super(nom, prenom);
		this.id = new SimpleIntegerProperty(id);
		this.solde = new SimpleDoubleProperty(solde);
		this.adresse = adresse;
	}

	public int getId() {
		return id.get();
	}

	public IntegerProperty idProperty(){
    	return id;
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public double getSolde() {
		return solde.get();
	}

	public DoubleProperty soldeProperty(){
		return solde;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setSolde(double solde) {
		this.solde.set(solde);
	}
	
	public String toString(){
		return "["+this.getId()+"] "+ this.getNom() + " " + this.getPrenom() +" "+ solde + " " + this.adresse.getCode_postal();
	}


    public boolean equals(Object c){
	    if(this.id == ((Client)c).id)
	        return true;
	    else
	        return false;


    }
}
