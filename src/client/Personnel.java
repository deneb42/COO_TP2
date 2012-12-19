package client;

import promo.PromoPerso;

public class Personnel extends CatClient {

	private PromoPerso saPromo;
	
	public Personnel(String nom) {
		super(nom);
		//saPromo = new PromoPerso("perso", 1, 2.0f);
		
		propCat = "Personnes travaillant pour le site, elles bénéficient de réductions spécifiques sur les produits";
	}
	


	@Override
	public int calculReduc() {
		//Todo
		return 0;
	}

	public PromoPerso getSaPromo() {return saPromo;}
	public void setSaPromo(PromoPerso saPromo) {this.saPromo = saPromo;	}
}
