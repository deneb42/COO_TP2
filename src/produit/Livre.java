package produit;

public class Livre extends Produit {
	private String auteur, resume;
	
	public Livre(int id, String n, String a, String r) {
		super(id, n);
		auteur=a;
		resume=r;
	}
	
	public String toString() {
		return super.toString() + " (Livre), auteur: " + auteur + ", résumé : " + resume;
	}
}
