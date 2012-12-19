package client;

import produit.Produit;

public class Simple extends CatClient {

	private static Simple singleton;
	
	private Simple(String nom) {
		super(nom);
		propCat = "Personne visitant le site exceptionnellement, ne bénéficient pas du cumul des points.";
	}
	
	public static CatClient getCat() {
		if(singleton==null)
			singleton = new Simple("Anonyme");
		
		return singleton;
	}

	@Override
	public float calculReduc(Produit p) {	
		return 0;
	}


}
