package produit;

import promo.Promotion;

public abstract class Produit {
	private static int nbProduit=0;
	protected int idProduit;
	protected float prix;
	protected String nom;
	protected int nbFidelite;
	protected Promotion promo;
	
	protected Produit(float p, String n, int nf) {
		idProduit=nbProduit++;
		prix = p;
		nom=n;
		nbFidelite=nf;
	}
	
	public String toString() {
		return "Produit n°" + idProduit + " " + nom;
	}
	
	public boolean equals(Object o) {
		if(o==null)
			return false;
		if(o==this)
			return true;
		try {
			Produit p = (Produit)o;
			return this.idProduit==p.idProduit;
		}
		catch (ClassCastException e) {
			return false;
		} 
	}
	
	public void setPromo(Promotion p) { promo = p; }
	
	public int getIdProduit() { return idProduit; }
	public float getPrix() { return prix; }
	public String getNom() { return nom; }
	public int getNbFidelite() { return nbFidelite; }
	public Promotion getPromo() { return promo; }
}
