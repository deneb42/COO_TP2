package promo;

import produit.*;

public class PromoPerso extends Promotion {
	Produit pdt;
	
	public PromoPerso(String name, float red, Produit p) {//ici reduction est un pourcentage et dooit donc etre inf à 1.
		super(name, red);
		pdt = p;
	}

	@Override
	public float calculerReduc() {
		return reduction * pdt.getPrix();
	}

}
