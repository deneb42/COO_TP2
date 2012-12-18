package promo;

import produit.*;

public class PromoPerso extends Promotion {
	Produit pdt;
	
	public PromoPerso(String name, int id, float red, Produit p) {
		super(name, id, red);
		pdt = p;
	}

	@Override
	public float calculerReduc() {
		reduction*pdt.getPrix();
		return 0;
	}

}
