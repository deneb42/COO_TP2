package client;

import produit.Produit;

/**
 * 
 * @author BADIE & BLOIS
 * 
 * Classe représentant un client simple visiteur
 *
 */
public class Simple extends CatClient {
	private static Simple singleton;
	
	/**
	 * Constructeur
	 * @param nom
	 */
	private Simple(String nom) {
		super(nom, "Personne visitant le site exceptionnellement, ne bénéficient pas du cumul des points.");
	}
	
	/**
	 * Retourne la categorie
	 * @return
	 */
	public static CatClient getCat() {
		if(singleton==null)
			singleton = new Simple("Visiteur");
		
		return singleton;
	}

	/**
	 * Calcul la reduction spécifique à cette categorie
	 */
	@Override
	public float calculReduc(Produit p) {	
		return 0;
	}
}
