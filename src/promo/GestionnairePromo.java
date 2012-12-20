package promo;

import java.util.ArrayList;

import produit.Produit;
import client.Adherents;
import client.Personnel;
import courses.Panier;

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
	
	public static void modifierPromoCat(Produit prod, PromoProduit promo){
		prod.setPromoCat(promo);
	}
	
	public static void supprimerPromoCat(Produit prod){
		prod.setPromoCat(null);
	}
	
	public static void ajouterPromoFlash(PromoFlash promo){
		Panier.addPromoFlash(promo);
	}
	public static void SupprimerPromoFlash(PromoFlash promo){
		Panier.removePromoFlash(promo);
	}
		
	
	/* **********************************************
	 * Affichage des listes de promos
	 * ********************************************* */
	
	public static void affichePromos(ArrayList<Produit> produits){
		System.out.println("--- Listes des promotions ---");
		
		System.out.println(promosPersotoString());
		System.out.println(promosAdherenttoString());
		System.out.println(PromosProduits(produits));
//		System.out.println();
	}
	
	public static String promosPersotoString(){
		StringBuilder msg = new StringBuilder();
		msg.append("- Promos personnel -\n");
		for(PromoPerso p : Personnel.getPromos()){
			msg.append(p.toString());
			msg.append("\n");
		}
		
		return msg.toString();
	}
	public static String promosAdherenttoString(){
		StringBuilder msg = new StringBuilder();
		msg.append("- Promos adherent -\n");
		for(PromoAdherent p : Adherents.getPromos()){
			msg.append(p.toString());
			msg.append("\n");
		}
		return msg.toString();
		
	}
	
	public static String PromosProduits(ArrayList<Produit> produits){
		StringBuilder msg = new StringBuilder();
		msg.append("- Promos produits -\n");
		for(Produit prod : produits){
			if(prod.getPromoPdt() != null){
				msg.append(prod.getPromoPdt().toString());
				msg.append("\n");
			}
		}
		return msg.toString();
		
	}
			
}
