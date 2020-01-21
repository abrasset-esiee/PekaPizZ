package project;

public class Pizza {

	private int id;
	private String nom;
	private double prix_base;
	
	public Pizza(int id, String nom, double prix_base) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nom = nom;
		this.prix_base = prix_base;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public double getPrix_base() {
		return prix_base;
	}

	public void setPrix_base(double prix_base) {
		this.prix_base = prix_base;
	}
		
}
