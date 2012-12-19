package client;

import promo.PromoPerso;

public class Personnel extends CatClient {

	private static Personnel singleton;
	private PromoPerso saPromo;
	
	private Personnel(String nom) {
		super(nom);
		//saPromo = new PromoPerso("perso", 1, 2.0f);
		propCat = "Personnes travaillant pour le site, elles bénéficient de réductions spécifiques sur les produits";
	}
	
	public static CatClient getCat() {
		if(singleton==null)
			singleton = new Personnel("Personnel");
		
		return singleton;
	}
	


	@Override
	public float calculReduc() {
		//Todo
		return 0;
	}

	public PromoPerso getSaPromo() {return saPromo;}
	public void setSaPromo(PromoPerso saPromo) {this.saPromo = saPromo;	}
}
