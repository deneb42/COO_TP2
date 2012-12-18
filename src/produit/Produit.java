package produit;

import java.util.ArrayList;

import promo.Promotion;

public abstract class Produit {
	protected int idProduit;
	protected float prix;
	protected String nom;
	protected int nbFidelite;
	protected ArrayList<Promotion> promos;
	
	protected Produit(int id, float p, String n, int nf) {
		idProduit=id;
		prix = p;
		nom=n;
		nbFidelite=nf;
	}
	
	public String toString() {
		return "Produit n°" + idProduit + " " + nom;
	}
	
	
	public void addPromo(Promotion p) { promos.add(p); }
	
	public int getIdProduit() { return idProduit; }
	public float getPrix() { return prix; }
	public String getNom() { return nom; }
	public int getNbFidelite() { return nbFidelite; }
	public ArrayList<Promotion> getPromos() { return promos; }
}
