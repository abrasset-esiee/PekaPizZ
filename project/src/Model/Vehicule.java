package Model;

public class Vehicule {

	private String immatriculation;
	private boolean voiture;
	private String couleur;
	private String modele;
	private int annee;
	
	public Vehicule(String immatriculation, boolean voiture, String couleur, String modele, int annee) {
		// TODO Auto-generated constructor stub
		this.immatriculation = immatriculation;
		this.voiture = voiture;
		this.couleur = couleur;
		this.modele = modele;
		this.annee = annee;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
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
