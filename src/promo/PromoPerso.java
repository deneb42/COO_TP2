package promo;

import produit.Produit;

public class PromoPerso extends Promotion {
	private Produit pdt;
	
	public PromoPerso(String name, float red, Produit p) {//ici reduction est un pourcentage et dooit donc etre inf à 1.
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
		msg.append("\n\tPromo Personnel sur le produit : ");
		msg.append(pdt);
		msg.append("\n");
		return msg.toString();
	}
}
