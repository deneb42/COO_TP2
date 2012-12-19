package promo;

import java.util.ArrayList;

import produit.Produit;
import client.Adherents;
import client.Personnel;

public class GestionnairePromo {
	
	public static void ajouterPromoAdherent(PromoAdherent promo){
		Adherents.addPromo(promo);
	}
	
	public static void retirerPromoAdherent(PromoAdherent promo){
		Adherents.removePromo(promo);
	}

	public static void ajouterPromoPerso(PromoPerso promo){
		Personnel.addPromo(promo);
	}
	
	public static void retirerPromoPerso(PromoPerso promo){
		Personnel.removePromo(promo);
	}
	
	public static void ajouterPromoProduit(Produit prod, PromoProduit promo){
		prod.setPromoPdt(promo);
	}
	public static void SupprimerPromoProduit(Produit prod){
		prod.setPromoPdt(null);
	}
	
	/*public static void modifierPromoCat( <? super Produit> c, PromoProduit promo){
		c.setPromoCat(promo);
	}*/
	
	//todo promoCat et promoFlash
		
	
	/* **********************************************
	 * Affichage des listes de promos
	 * ********************************************* */
	
	public static void affichePromos(ArrayList<Produit> produits){
		System.out.println("--- Listes des promotions ---");
		
		System.out.println(promosPersotoString());
		System.out.println(promosAdherenttoString());
		System.out.println(PromosProduits(produits));
	}
	
	public static String promosPersotoString(){
		StringBuilder msg = new StringBuilder();
		msg.append("- Promos personnel -");
		for(PromoPerso p : Personnel.getPromos()){
			msg.append(p.toString());
			msg.append("\n");
		}
		
		return msg.toString();
	}
	public static String promosAdherenttoString(){
		StringBuilder msg = new StringBuilder();
		msg.append("- Promos adherent -");
		for(PromoAdherent p : Adherents.getPromos()){
			msg.append(p.toString());
			msg.append("\n");
		}
		return msg.toString();
		
	}
	
	public static String PromosProduits(ArrayList<Produit> produits){
		StringBuilder msg = new StringBuilder();
		msg.append("- Promos produits -");
		for(Produit prod : produits){
			msg.append(prod.getPromoPdt().toString());
			msg.append("\n");
		}
		return msg.toString();
		
	}
			
}
