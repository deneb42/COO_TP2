package produit;

import promo.PromoProduit;
import promo.Promotion;

/**
 * Classe abstraite représentant un produit
 * @author BADIE & BLOIS
 *
 */
public abstract class Produit {
	private static int nbProduit=0; // valeur par defaut de gain de point de fidelité
	protected static PromoProduit promoCat;
	
	protected int idProduit;
	protected float prix;
	protected String nom;
	protected int nbFidelite;
	protected PromoProduit promoPdt;
	
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
	
	/**
	 * Constructeur par defaut
	 * Utilisé pour appliquer des promotions de catégorie
	 */
	protected Produit() {}
	
	@Override
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
	public abstract void setPromoCat(PromoProduit p);
	
	public int getIdProduit() { return idProduit; }
	public float getPrix() { return prix; }
	public String getNom() { return nom; }
	public int getNbFidelite() { return nbFidelite; }
	public Promotion getPromoPdt() { return promoPdt; }
	public abstract Promotion getPromoCat();
	
}
