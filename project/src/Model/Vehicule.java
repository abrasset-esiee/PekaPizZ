package project;

public class Vehicule {

	private char immatriculation;
	private boolean voiture;
	private String couleur;
	private String modele;
	private int annee;
	
	public Vehicule(char immatriculation, boolean voiture, String couleur, String modele, int annee) {
		// TODO Auto-generated constructor stub
		this.immatriculation = immatriculation;
		this.voiture = voiture;
		this.couleur = couleur;
		this.modele = modele;
		this.annee = annee;
	}

	public char getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(char immatriculation) {
		this.immatriculation = immatriculation;
	}

	public boolean isVoiture() {
		return voiture;
	}

	public void setVoiture(boolean voiture) {
		this.voiture = voiture;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
}
