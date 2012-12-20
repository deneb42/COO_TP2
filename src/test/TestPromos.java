package test;

import java.util.ArrayList;
import java.util.HashMap;

import produit.Produit;
import promo.GestionnairePromo;
import promo.PromoAdherent;
import promo.PromoFlash;
import promo.PromoPerso;
import promo.PromoProduit;

public class TestPromos {

	public static void creerPromos(ArrayList<Produit> produits){
		
		/* Creation de promos pour les adhérents */
		GestionnairePromo.ajouterPromoAdherent(new PromoAdherent("promoAd 1", 0.3f, produits.get(1)));
		GestionnairePromo.ajouterPromoAdherent(new PromoAdherent("promoAd 2", 0.4f, produits.get(3)));
		GestionnairePromo.ajouterPromoAdherent(new PromoAdherent("promoAd 3", 0.5f, produits.get(6)));
		
		/* Creation de promos pour le personnel */
		GestionnairePromo.ajouterPromoPerso(new PromoPerso("promoPerso 1", 0.2f, produits.get(5)));
		GestionnairePromo.ajouterPromoPerso(new PromoPerso("promoPerso 2", 0.4f, produits.get(1)));
		GestionnairePromo.ajouterPromoPerso(new PromoPerso("promoPerso 3", 0.6f, produits.get(3)));
		
		/* Creation de promos pour le produit */
		GestionnairePromo.ajouterPromoProduit(produits.get(6), new PromoProduit("PromoProd 1", 0.5f));
		GestionnairePromo.ajouterPromoProduit(produits.get(2), new PromoProduit("PromoProd 2", 0.3f));
		GestionnairePromo.ajouterPromoProduit(produits.get(7), new PromoProduit("PromoProd 3", 0.1f));
		
		GestionnairePromo.modifierPromoCat(produits.get(2), new PromoProduit("PromoCat1", 0.3f));
		
		/* Création de promos flash */
		HashMap<Produit, Integer> hashTmp = new HashMap<Produit, Integer>();
		hashTmp.put(produits.get(0), 1);
		hashTmp.put(produits.get(5), 1);
		GestionnairePromo.ajouterPromoFlash(new PromoFlash("promoFlash Lapointe", 0.2f, hashTmp));
		hashTmp.clear();
		hashTmp.put(produits.get(3), 3);
		GestionnairePromo.ajouterPromoFlash(new PromoFlash("promoFlash Tri Yann", 0.5f, hashTmp));
		
		
//	GestionnairePromo.affichePromos(produits);
	}
}
