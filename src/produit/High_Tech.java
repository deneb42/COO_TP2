package produit;

import promo.PromoProduit;
import promo.Promotion;

/**
 *Classe representant la categorie de produits High Tech 
 * @author BADIE & BLOIS
 *
 */
public class High_Tech extends Produit {
	private static final int nbFidelDef=15; // valeur par defaut de gain de point de fidelité
	protected static PromoProduit promoCat;
	
	protected String specTechniques;
	
	/**
	 * Constructeur
	 * @param p
	 * @param n
	 * @param nf
	 * @param sp
	 */
	public High_Tech(float p, String n, int nf, String sp) {
		super(p, n, nf);
		specTechniques = sp;
	}
	
	/**
	 * Constructeu
	 * @param p
	 * @param n
	 * @param sp
	 */
	public High_Tech(float p, String n, String sp) {
		this(p, n, nbFidelDef, sp);
	}
	
	/**
	 * Constructeur par défaut
	 * Utilisé pour appliquer des promotions de catégorie
	 */
	public High_Tech() {}

	@Override
	public String toString() {
		return super.toString() + " (High Tech), spécification : " + specTechniques;
	}
	
	public void setPromoCat(PromoProduit p) { promoCat = p; }
	public Promotion getPromoCat() { return promoCat; }
}
