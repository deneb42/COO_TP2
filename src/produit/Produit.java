package produit;

import promo.PromoProduit;
import promo.Promotion;

/**
 * Classe abstraite représentant un produit
 * @author BADIE & BLOIS
 *
 */
public abstract class Produit {
	private static int nbProduit=0;
	protected static PromoProduit promoCat;
	
	protected int idProduit;
	protected float prix;
	protected String nom;
	protected int nbFidelite;
	protected PromoProduit promoPdt;
	
	/**
	 * Constructeur par defaut
	 */
	protected Produit() {}
	
	/**
	 * Constructeur
	 * @param p
	 * @param n
	 * @param nf
	 */
	protected Produit(float p, String n, int nf) {
		idProduit=nbProduit++;
		prix = p;
		nom=n;
		nbFidelite=nf;
	}
	
	public String toString() {
		return "Produit n°" + idProduit + " " + nom;
	}
	
	/**
	 * redéfinition de la methode equals
	 */
	@Override
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
	
	/**
	 * Calcule la reduction possible de promoProduit
	 * @return
	 */
	public float calculReduc() {
		float reduc=0;
		if(promoPdt!= null)
			reduc = promoPdt.calculerReduc();
		if(promoCat!=null){
			if(promoCat.calculerReduc()>reduc)
				reduc = promoCat.calculerReduc();
		}
		return reduc;
	}
	
	public void setPromoPdt(PromoProduit p) { promoPdt = p; }
	public void setPromoCat(PromoProduit p) { promoCat = p; }
	
	public int getIdProduit() { return idProduit; }
	public float getPrix() { return prix; }
	public String getNom() { return nom; }
	public int getNbFidelite() { return nbFidelite; }
	public Promotion getPromoPdt() { return promoPdt; }
	public static Promotion getPromoCat() { return promoCat; }
	
}
