package produit;

import java.util.ArrayList;

import promo.Promotion;

public abstract class Produit {
	private static int nbProduit=0;
	protected int idProduit;
	protected float prix;
	protected String nom;
	protected int nbFidelite;
	protected ArrayList<Promotion> promos;
	
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
	
	public void addPromo(Promotion p) { promos.add(p); }
	
	public int getIdProduit() { return idProduit; }
	public float getPrix() { return prix; }
	public String getNom() { return nom; }
	public int getNbFidelite() { return nbFidelite; }
	public ArrayList<Promotion> getPromos() { return promos; }
}
