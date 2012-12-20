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

	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append(super.toString());
		msg.append("\nPromo Flash sur les produits : ");
		
		for(Produit p : pdtsCible){
			msg.append(p);
			msg.append("\n");	
		}
		msg.append("\n");		
		return msg.toString();
	}
	
	

}
