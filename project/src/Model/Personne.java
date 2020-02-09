package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne {
	
	private StringProperty nom;
    private StringProperty prenom;
    
    public Personne(String nom, String prenom) {
		// TODO Auto-generated constructor stub
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
	}


	public StringProperty nomProperty() {
		return nom;
	}

	public StringProperty prenomProperty() {
		return prenom;
	}

	public String getNom() {
		return nom.get();
	}

	public void setNom(String nom) {
		this.nom.set(nom);
	}

	public String getPrenom() {
		return prenom.get();
	}

	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}
}
