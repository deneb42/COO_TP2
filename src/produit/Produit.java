package produit;

public abstract class Produit {
	protected int idProduit;
	protected float prix;
	protected String nom;
	protected int nbFidelite;
	
	protected Produit(int id, float p, String n, int nf) {
		idProduit=id;
		prix = p;
		nom=n;
		nbFidelite=nf;
	}
	
	public String toString() {
		return "Produit n°" + idProduit + " " + nom;
	}
	
	public int getIdProduit() { return idProduit; }
	public float getPrix() { return prix; }
	public String getNom() { return nom; }
}
