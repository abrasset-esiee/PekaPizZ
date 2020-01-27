package Model;

public class Adresse {

	private int id;
	private String numero_rue;
	private String nom_rue;
	private char code_postal;
	private String ville;
	
	public Adresse(int id, String numero_rue, String nom_rue, char code_postal, String ville) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.numero_rue = numero_rue;
		this.nom_rue = nom_rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero_rue() {
		return numero_rue;
	}

	public void setNumero_rue(String numero_rue) {
		this.numero_rue = numero_rue;
	}

	public String getNom_rue() {
		return nom_rue;
	}

	public void setNom_rue(String nom_rue) {
		this.nom_rue = nom_rue;
	}

	public char getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(char code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
}
