package promo;

import java.util.ArrayList;

import produit.Produit;
import client.Adherents;
import client.Personnel;

public class GestionnairePromo {
	
	public static void ajouterPromoAdherent(PromoAdherent promo){
		//ToDo
	}
	
	public static void retirerPromoAdherent(PromoAdherent promo){
		//ToDo
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
	
	public static void affichePromos(ArrayList<Produit> produits){
		for(PromoPerso p : Personnel.getPromos()){
			System.out.println(p.toString());
		}
		for(PromoAdherent p : Adherents.getPromos()){
			System.out.println(p.toString());
		}
		for(Produit prod : produits){
			System.out.println(prod.getPromoPdt().toString());
		}
		
		//ToDo promosFlash
		
	}
}
