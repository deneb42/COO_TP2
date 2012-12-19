package client;

import java.util.ArrayList;
import java.util.Map.Entry;

import produit.Produit;
import promo.PromoPerso;
import courses.Panier;

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
	public float calculReduc(Panier sonPanier) {
		float reduc=0;
		int index=0;
		for(Entry<Produit, Integer> e:sonPanier.getContenuPanier().entrySet()) {
			index = sesPromos.indexOf(e.getKey());
			if(index!=-1) {
				reduc += sesPromos.get(index).calculerReduc()*e.getValue();
				// on ajoute la reduction pour le produit trouvé * le nombre de produits.
			}
		}
		return reduc;
	}

	public void removePromo(PromoPerso promo) { sesPromos.remove(promo); }
	public void addPromo(PromoPerso promo) {this.sesPromos.add(promo);	}

}
