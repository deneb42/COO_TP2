package produit;

import promo.PromoProduit;
import promo.Promotion;


/**
 * Classe représentant un livre
 * @author BADIE & BLOIS
 *
 */
public class Livre extends Produit {
	private static final int nbFidelDef=5; // valeur par defaut de gain de point de fidelité
	protected static PromoProduit promoCat;
	
	private String auteur, resume;
			
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
	
	/**
	 * Constructeur par défaut
	 * Utilisé pour appliquer des promotions de catégorie
	 */
	public Livre() {}
	
	@Override
	public String toString() {
		return super.toString() + " (Livre), auteur: " + auteur + ", résumé : " + resume;
	}
	
	public void setPromoCat(PromoProduit p) { promoCat = p; }
	public Promotion getPromoCat() { return promoCat; }
}
