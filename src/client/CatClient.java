package client;

import produit.Produit;

/**
 * Classe abstraite représentant une catégorie de client.
 * @author BADIÉ & BLOIS
 */

public abstract class CatClient {
	
	private String nomCat;
	private String propCat;
	
	/**
	 * Constructeur
	 * @param nomCat
	 * @param propCat
	 */
	protected CatClient(String nomCat, String propCat) {
		this.nomCat = nomCat;
		this.propCat = propCat;
	}
	/**
	 * Permet de calculer les reductions en fonction de la categorie
	 * @param p
	 * @return
	 */
	public abstract float calculReduc(Produit p);
	

	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append(nomCat);
		msg.append("\nPropriétés de la catégorie : ");
		msg.append(propCat);
		
		return msg.toString();
	}
}
