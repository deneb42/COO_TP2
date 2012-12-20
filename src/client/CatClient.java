package client;

import produit.Produit;

public abstract class CatClient {
	
	private String nomCat;
	private String propCat;
	
	protected CatClient(String nomCat, String propCat) {
		this.nomCat = nomCat;
		this.propCat = propCat;
	}

	public abstract float calculReduc(Produit p);
	
	
	public String toString() {
		StringBuilder msg = new StringBuilder();
		//msg.append("Nom de la catégorie : ");
		msg.append(nomCat);
		msg.append("\nPropriétés de la catégorie : ");
		msg.append(propCat);
		
		return msg.toString();
	}
}
