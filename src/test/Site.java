package test;

import java.util.ArrayList;

import produit.Produit;
import client.Client;

/**
 * Classe de test du programme : va émuler le site, et appeler tous les cas de test
 * @author BADIE & BLOIS
 *
 */
public class Site {
	

	public static void main(String[] args) {	
		
		/* Création des produits, des promotions, et des clients */
		ArrayList<Produit> produits = TestProduit.populeProduits();
		TestPromos.creerPromos(produits);
		ArrayList<Client> clients = TestClient.populeClient();	
		TestAlerte.creerAlertes(produits, clients);
		/* *********************************** */
		
		
		EnsembleTest.ajoutPanierSimple(clients, produits); //Test des ajouts et suppression simple dans le panier.
		System.out.println("**********************************************************************");
		
		EnsembleTest.operationsClients(clients, produits); // Test des modifications simple de statut des clients.
		System.out.println("**********************************************************************");
		
		EnsembleTest.promoAdherents(clients, produits); //vérifie le fonctionnement des promos des adhérents
		System.out.println("**********************************************************************");
		
		EnsembleTest.promoPersonnel(clients, produits);//vérifie le fonctionnement des promos pour le personnel
		System.out.println("**********************************************************************");
		
		EnsembleTest.logAdherentAvecPanier(clients, produits); //test le passage d'un client simple à un adhérent 
															//en conservant panier et recalcul des promos.
		System.out.println("**********************************************************************");
		
		EnsembleTest.logPersonnelAvecPanier(clients, produits); //test le passage d'un client simple à un personnel 
																//en conservant panier et recalcul des promos.
		System.out.println("**********************************************************************");
		
		EnsembleTest.testCondPromoFlashReunies(clients, produits); //test avec les conditions d'une promo flash réunie.
		
	}

}
