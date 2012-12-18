package produit;

public abstract class Produit {
	protected int idProduit;
	protected float prix;
	protected String nom;
	
	protected Produit(int id, String n) {
		idProduit=id;
		nom=n;
	}
	
	public String toString() {
		return "Produit n°" + idProduit + " " + nom;
	}
	
	public int getIdProduit() { return idProduit; }
	public float getPrix() { return prix; }
	public String getNom() { return nom; }
}
