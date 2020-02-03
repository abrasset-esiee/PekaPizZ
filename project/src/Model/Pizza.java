package Model;

import java.util.HashSet;

public class Pizza {

	private int id;
	private String nom;
	private double prix_base;
	private HashSet<Ingredient> ingredients;
	
	public Pizza(String nom, double prix_base) {
		this.nom = nom;
		this.prix_base = prix_base;
		this.ingredients = new HashSet<Ingredient>();
	}
	
	public Pizza(int id, String nom, double prix_base) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nom = nom;
		this.prix_base = prix_base;
		this.ingredients = new HashSet<Ingredient>();
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
	
	public void setIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
	
	public HashSet<Ingredient> getIngredients() {
		return this.ingredients;
	}
}
