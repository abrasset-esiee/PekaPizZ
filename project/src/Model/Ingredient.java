package Model;

public class Ingredient {

	private int id;
	private String nom;
	private String provenance;
	
	public Ingredient(int id, String nom, String provenance) {
		this.id = id;
		this.nom = nom;
		this.provenance = provenance;
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
	
	public String getProvenance() {
		return provenance;
	}
	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}
	
	
}
