package promo;

import java.util.HashMap;
import java.util.Map.Entry;

import produit.Produit;

/**
 * Promotion de type Flash s'applique en fonction du contenu du panier
 * @author BADIE & BLOIS
 *
 */
public class PromoFlash extends Promotion {
	private HashMap<Produit, Integer> pdtsCible;
	
	/**
	 * Constructeur
	 * @param name
	 * @param red
	 */
	public PromoFlash(String name, float red) {
		super(name, red);
		pdtsCible = new HashMap<Produit, Integer>();
	}
	
	/**
	 * Constructeur
	 * @param name
	 * @param red
	 * @param p
	 */
	public PromoFlash(String name, float red, HashMap<Produit, Integer> p) {
		super(name, red);
		pdtsCible = new HashMap<Produit, Integer>(p);
	}

	@Override
	public float calculerReduc() {
		return reduction;
	}

	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append(super.toString());
		msg.append("Promo Flash sur les produits : \n");
		
		for(Entry<Produit, Integer> e : pdtsCible.entrySet()){
			msg.append(e.getKey());
			msg.append(" x");
			msg.append(e.getValue());
			msg.append("\n");
		}
		msg.append("\n");		
		return msg.toString();
	}

	/**
	 * Calcul le nombre d'occurence des produits la promo dans le panier
	 * @param contenuPanier
	 * @return
	 */
	public int nbOcc(HashMap<Produit, Integer> contenuPanier) {
		int i=100000; // borne sup
		for(Entry<Produit, Integer> e:pdtsCible.entrySet()) {
			Integer tmp = contenuPanier.get(e.getKey()); 
			if(tmp==null || e.getValue()<tmp) // si le produit de la promo n'est pas dans le panier ou s'il n'est pas en quantité suffisante
				return 0;
			i= i>tmp/e.getValue()?tmp/e.getValue():i; // on prend le min du nombre d'occurences
		}
		return i;
	}
	
	/**
	 * Ajoute un produit à la promo
	 * @param p
	 * @param qte
	 */
	public void AddProduit(Produit p, int qte) { // si le produit est deja dans la table, sa quantité est maj
		pdtsCible.put(p, qte);
	}
	
	/**
	 * Supprime un produit de la promo
	 * @param p
	 */
	public void RemoveProduit(Produit p) {
		pdtsCible.remove(p);
	}
}
