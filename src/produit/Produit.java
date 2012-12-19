package produit;

import promo.Promotion;

public abstract class Produit {
	private static int nbProduit=0;
	protected static Promotion promoCat;
	
	protected int idProduit;
	protected float prix;
	protected String nom;
	protected int nbFidelite;
	protected Promotion promoPdt;
	
	protected Produit() {}
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
	
	public float calculReduc() {
		float reduc=0;
		if(promoPdt!= null)
			reduc = promoPdt.calculerReduc();
		
		if(promoCat!=null && promoPdt.calculerReduc()>reduc)
			reduc = promoPdt.calculerReduc();
		
		return reduc;
	}
	
	public void setPromoPdt(Promotion p) { promoPdt = p; }
	public static void setPromoCat(Promotion p) { promoCat = p; }
	
	public int getIdProduit() { return idProduit; }
	public float getPrix() { return prix; }
	public String getNom() { return nom; }
	public int getNbFidelite() { return nbFidelite; }
	public Promotion getPromoPdt() { return promoPdt; }
	public static Promotion getPromoCat() { return promoCat; }
}
