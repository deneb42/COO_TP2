package promo;

import produit.Produit;

/**
 * Promo pour les adherents du site
 * @author BADIE & BLOIS
 *
 */
public class PromoAdherent extends Promotion {
	private Produit pdt;
	
	/**
	 * Constructeur
	 * @param name
	 * @param red
	 * @param p
	 */
	public PromoAdherent(String name, float red, Produit p) {
		super(name, red);
		pdt = p;
	}

	@Override
	public float calculerReduc() {
		return reduction * pdt.getPrix();
	}
	
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append(super.toString());
		msg.append("\n\tPromo Adhérent sur le produit : ");
		msg.append(pdt);
		msg.append("\n");
		return msg.toString();
	}
}
