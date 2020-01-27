package Model;

import java.util.Date;

public class Livraison {

	private int id;
	Livreur livreur;
	Pizza pizza;
	Vehicule vehicule;
	Taille taille;
	Client client;
	private Date date_livraison;
	private Date date_reception;
	
	public Livraison(int id, Livreur livreur, Pizza pizza, Vehicule vehicule, Taille taille, Client client, 
			Date date_livraison, Date date_reception) {
		this.id = id;
		this.livreur = livreur;
		this.pizza = pizza;
		this.vehicule = vehicule;
		this.taille = taille;
		this.client = client;
		this.date_livraison = date_livraison;
		this.date_reception = date_reception;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_livraison() {
		return date_livraison;
	}

	public void setDate_livraison(Date date_livraison) {
		this.date_livraison = date_livraison;
	}

	public Date getDate_reception() {
		return date_reception;
	}

	public void setDate_reception(Date date_reception) {
		this.date_reception = date_reception;
	}
	 
	 
}
