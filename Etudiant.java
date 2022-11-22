package jdbc;

public class Etudiant {
	
	private int id ; 
	private String nom, prenom ;
	
	
	public Etudiant(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}


	public Etudiant(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	} 
	
	
	
	
	

}
