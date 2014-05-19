package produit;

import java.util.Date;

import promo.PromoProduit;
import promo.Promotion;

/**
 * Produit de type spectacle
 * @author BADIE & BLOIS
 *
 */
public class Spectacle extends Produit {
	private static final int nbFidelDef=10; // valeur par defaut de gain de point de fidelité
	protected static PromoProduit promoCat;
	
	private Date date;
	private String lieu;
	
	/**
	 * Constructeur
	 * @param p
	 * @param n
	 * @param nf
	 * @param d
	 * @param l
	 */
	public Spectacle(float p, String n, int nf, Date d, String l) {
		super(p, n, nf);
		date = d;
		lieu=l;
	}
	
	/**
	 * Constructeur
	 * @param p
	 * @param n
	 * @param d
	 * @param l
	 */
	public Spectacle(float p, String n, Date d, String l) {
		this(p, n, nbFidelDef, d, l);
	}
	
	/**
	 * Constructeur par défaut
	 * Utilisé pour appliquer des promotions de catégorie
	 */
	public Spectacle() {}
	
	@Override
	public String toString() {
		return super.toString() + " (Spectacle), date: " + date.toString() + ", lieu: " + lieu;
	}
	
	public void setPromoCat(PromoProduit p) { promoCat = p; }
	public Promotion getPromoCat() { return promoCat; }
}
