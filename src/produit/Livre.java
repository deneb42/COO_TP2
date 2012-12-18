package produit;

public class Livre extends Produit {
	private String auteur, resume;
	
	public Livre(int id, float p, String n, String a, String r) {
		super(id, p, n);
		auteur=a;
		resume=r;
	}
	
	public String toString() {
		return super.toString() + " (Livre), auteur: " + auteur + ", résumé : " + resume;
	}
}
