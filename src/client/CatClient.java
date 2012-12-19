package client;

import courses.Panier;

public abstract class CatClient {
	
	private String nomCat;
	protected String propCat;
	
	protected CatClient(String nom) {
		nomCat = nom;	
	}

	public abstract float calculReduc(Panier sonPanier);
	
	
	public String toString() {
		StringBuilder msg = new StringBuilder();
		//msg.append("Nom de la catégorie : ");
		msg.append(nomCat);
		msg.append("\nPropriétés de la catégorie : ");
		msg.append(propCat);
		
		return msg.toString();
	}
}
