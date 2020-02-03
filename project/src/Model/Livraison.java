package Model;

import java.sql.Date;

public class Livraison {

	private int id;
	private Livreur livreur;
	private Pizza pizza;
	private Vehicule vehicule;
	private Taille taille;
	private Client client;
	private Date date_commande;
	private Date date_livraison;
	
	public Livraison(Livreur livreur, Pizza pizza, Vehicule vehicule, Taille taille, Client client, 
			Date date_commande, Date date_livraison) {
		this.livreur = livreur;
		this.pizza = pizza;
		this.vehicule = vehicule;
		this.taille = taille;
		this.client = client;
		this.date_commande = date_commande;
		this.date_livraison = date_livraison;
	}
	
	public Livraison(int id, Livreur livreur, Pizza pizza, Vehicule vehicule, Taille taille, Client client, 
			Date date_commande, Date date_livraison) {
		this.id = id;
		this.livreur = livreur;
		this.pizza = pizza;
		this.vehicule = vehicule;
		this.taille = taille;
		this.client = client;
		this.date_commande = date_commande;
		this.date_livraison = date_livraison;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Pizza getPizza() {
		return pizza;
	}
	
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Taille getTaille() {
		return taille;
	}

	public void setTaille(Taille taille) {
		this.taille = taille;
	}
	
	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	public Date getDate_livraison() {
		return date_livraison;
	}

	public void setDate_livraison(Date date_livraison) {
		this.date_livraison = date_livraison;
	}
	
	public String toString(){
		return "Livraison n°" + this.getId() + " -> "+ "Livreur: " + this.livreur.getNom() + " " + this.livreur.getPrenom() + ". Pizza commandée: " + this.pizza.getNom() + ". Livrée avec véhicule type: " + this.vehicule.getModele();
	}
}
