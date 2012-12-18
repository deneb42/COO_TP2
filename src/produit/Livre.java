package produit;

public class Livre extends Produit {
	static final int nbFidelDef=5;
	private String auteur, resume;
	
	public Livre(int id, float p, String n, int nf, String a, String r) {
		super(id, p, n, nf);
		auteur=a;
		resume=r;
	}
	
	public Livre(int id, float p, String n, String a, String r) {
		this(id, p, n, nbFidelDef, a, r);
	}
	
	public String toString() {
		return super.toString() + " (Livre), auteur: " + auteur + ", résumé : " + resume;
	}
}
