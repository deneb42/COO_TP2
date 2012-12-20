package client;

import produit.Produit;
/**
 * 
 * @author BADIE & BLOIS
 *
 */
public class Simple extends CatClient {

	private static Simple singleton;
	
	private Simple(String nom) {
		super(nom, "Personne visitant le site exceptionnellement, ne bénéficient pas du cumul des points.");
	}
	
	public static CatClient getCat() {
		if(singleton==null)
			singleton = new Simple("Visiteur");
		
		return singleton;
	}

	@Override
	public float calculReduc(Produit p) {	
		return 0;
	}


}
