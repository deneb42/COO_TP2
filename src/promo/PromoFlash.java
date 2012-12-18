package promo;

import java.util.ArrayList;

import produit.Produit;

public class PromoFlash extends Promotion {

	ArrayList<Produit> pdtsCible;
	
	protected PromoFlash(String name, int id, float red, ArrayList<Produit> p) {
		super(name, id, red);
		pdtsCible = new ArrayList<Produit>(p);
	}

	@Override
	public float calculerReduc() {
		return reduction;
	}

	
	
	

}
