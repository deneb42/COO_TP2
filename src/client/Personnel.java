package client;

import java.util.ArrayList;

import produit.Produit;
import promo.PromoPerso;

public class Personnel extends CatClient {

	private static Personnel singleton;
	private ArrayList<PromoPerso> sesPromos;
	
	private Personnel(String nom) {
		super(nom);
		//saPromo = new PromoPerso("perso", 1, 2.0f);
		propCat = "Personnes travaillant pour le site, elles bénéficient de réductions spécifiques sur les produits";
		sesPromos = new ArrayList<PromoPerso>();
	}
	
	public static CatClient getCat() {
		if(singleton==null)
			singleton = new Personnel("Personnel");
		
		return singleton;
	}

	@Override
	public float calculReduc(Produit p) {
		int i=0;
			i = sesPromos.indexOf(p);
			if(i!=-1)
				return sesPromos.get(i).calculerReduc();
		return 0;
	}

	public void removePromo(PromoPerso promo) { sesPromos.remove(promo); }
	public void addPromo(PromoPerso promo) {this.sesPromos.add(promo);	}

}
