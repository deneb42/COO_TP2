package test;

import java.util.ArrayList;

import produit.Produit;
import promo.GestionnairePromo;
import client.Client;

public class Site {

	/* ********
	 * ToDoLIST
	 * 
	 * check promoCat
	 * 
	 */
	
	
	/**
	 * @param args
	 * Classe de test du programme : va émuler le site.
	 */
	public static void main(String[] args) {	
		
		/* Création des produits, des promotions, et des clients */
		ArrayList<Produit> produits = TestProduit.populeProduits();
		TestPromos.creerPromos(produits);
		ArrayList<Client> clients = TestClient.populeClient();	
		TestAlerte.creerAlertes(produits, clients);

		/* *********************************** */
		
		GestionnairePromo.affichePromos(produits);
		
//		EnsembleTest.ajoutPanierSimple(clients, produits); //Test des ajouts et suppression simple dans le panier.
		
//		EnsembleTest.operationsClients(clients, produits); // Test des modifications simple de statut des clients.
		
//		EnsembleTest.promoAdherents(clients, produits); //vérifie le fonctionnement des promos des adhérents
		
//		EnsembleTest.promoPersonnel(clients, produits);//vérifie le fonctionnement des promos pour le personnel
		
		
//		EnsembleTest.logAdherentAvecPanier(clients, produits); //test le passage d'un client simple à un adhérent 
															//en conservant panier et recalcul des promos.
		
//		EnsembleTest.logPersonnelAvecPanier(clients, produits); //test le passage d'un client simple à un personnel 
																//en conservant panier et recalcul des promos.
		
		EnsembleTest.testCondPromoFlashReunies(clients, produits); //test avec les conditions d'une promo flash réunie.
		
	}

}
