package produit;

import promo.PromoProduit;
import promo.Promotion;

/**
 * Classe représentant la categorie de produit CD
 * @author BADIE & BLOIS
 *
 */
public class CD extends Produit {
	private static final int nbFidelDef=2; // valeur par defaut de gain de point de fidelité
	protected static PromoProduit promoCat;
	
	protected String artiste;
	
	/**
	 * Constructeur
	 * @param p
	 * @param n
	 * @param nf
	 * @param a
	 */
	public CD(float p, String n, int nf, String a) {
		super(p, n, nf);
		artiste=a;
	}
	
	/**
	 * Constructeur
	 * @param p
	 * @param n
	 * @param a
	 */
	public CD(float p, String n, String a) {
		this(p, n, nbFidelDef, a);
	}
	
	/**
	 * Constructeur par défaut
	 * Utilisé pour appliquer des promotions de catégorie
	 */
	public CD() {}

	@Override
	public String toString() {
		return super.toString() + " (CD), Artiste: " + artiste;
	}
	
	public void setPromoCat(PromoProduit p) { promoCat = p; }
	public Promotion getPromoCat() { return promoCat; }
}
