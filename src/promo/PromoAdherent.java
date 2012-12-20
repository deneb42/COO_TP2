package promo;

import produit.Produit;

public class PromoAdherent extends Promotion {
	private Produit pdt;
	
	public PromoAdherent(String name, float red, Produit p) {
		super(name, red);
		pdt = p;
	}

	@Override
	public float calculerReduc() {
		return reduction * pdt.getPrix();
	}
	
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append(super.toString());
		msg.append("\n\tPromo Adhérent sur le produit : ");
		msg.append(pdt);
		msg.append("\n");
		return msg.toString();
	}
}
