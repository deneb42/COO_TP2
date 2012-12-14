package client;

import promo.PromoPerso;

public class Personnel extends CatClient {

	private PromoPerso saPromo;
	
	public Personnel(String nom) {
		super(nom);
		saPromo = new PromoPerso("perso", 1);
	}
	

	@Override
	public void connexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calculReduc() {
		//Todo
		return 0;
	}

	public PromoPerso getSaPromo() {return saPromo;}
	public void setSaPromo(PromoPerso saPromo) {this.saPromo = saPromo;	}
}
