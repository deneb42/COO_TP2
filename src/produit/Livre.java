package produit;

import promo.PromoProduit;
import promo.Promotion;


/**
 * Classe représentant un livre
 * @author BADIE & BLOIS
 *
 */
public class Livre extends Produit {
	static final int nbFidelDef=5;
	protected static PromoProduit promoCat;
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
	
	public void setPromoCat(PromoProduit p) { promoCat = p; }
	public Promotion getPromoCat() { return promoCat; }
}
