package promo;

import java.util.ArrayList;

import produit.Produit;

public class PromoFlash extends Promotion {

	ArrayList<Produit> pdtsCible;
	
	protected PromoFlash(String name, float red, ArrayList<Produit> p) {
		super(name, red);
		pdtsCible = new ArrayList<Produit>(p);
	}

	@Override
	public float calculerReduc() {
		return reduction;
	}

	
	
	

}
