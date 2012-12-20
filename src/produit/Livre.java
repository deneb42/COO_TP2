package produit;

/**
 * Classe représentant un livre
 * @author BADIE & BLOIS
 *
 */
public class Livre extends Produit {
	static final int nbFidelDef=5;
	private String auteur, resume;
	
	/**
	 * Constructeur par défaut
	 */
	public Livre() {}
			
	/**
	 * Constructeur
	 * @param p
	 * @param n
	 * @param nf
	 * @param a
	 * @param r
	 */
	public Livre(float p, String n, int nf, String a, String r) {
		super(p, n, nf);
		auteur=a;
		resume=r;
	}
	
	/**
	 * Constructeur
	 * @param p
	 * @param n
	 * @param a
	 * @param r
	 */
	public Livre(float p, String n, String a, String r) {
		this(p, n, nbFidelDef, a, r);
	}
	
	public String toString() {
		return super.toString() + " (Livre), auteur: " + auteur + ", résumé : " + resume;
	}
}
