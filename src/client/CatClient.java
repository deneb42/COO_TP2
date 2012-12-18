package client;

public abstract class CatClient {
	
	private String nomCat;
	protected String propCat;
	
	protected CatClient(String nom) {
		nomCat = nom;	
	}

	public abstract void connexion();
	public abstract int calculReduc();
	
	
	public String toString() {
		StringBuilder msg = new StringBuilder();
		//msg.append("Nom de la catégorie : ");
		msg.append(nomCat);
		msg.append("\nPropriétés de la catégorie : ");
		msg.append(propCat);
		
		return msg.toString();
	}
}
