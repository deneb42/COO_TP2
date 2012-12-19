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
}
