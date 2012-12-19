package test;

import java.util.ArrayList;

import produit.Produit;
import client.Client;

public class Site {

	/**
	 * @param args
	 * Classe de test du programme : va émuler le site.
	 */
	public static void main(String[] args) {	
		
		/* Création des clients et des produits */
		ArrayList<Produit> produits = TestProduit.populeProduits();
		ArrayList<Client> clients = TestClient.populeClient();
		/* *********************************** */
		ensembleTest casTest = new ensembleTest();
		
//		casTest.ajoutPanierSimple(clients, produits); //Test des ajouts et suppression simple dans le panier.
		
		casTest.operationsClients(clients, produits); // Test des modifications simple de statut des clients.
		
//		casTest.promoAdherents(clients, produits); //vérifie le fonctionnement des promos des adhérents
		
//		casTest.promoPersonnel(clients, produits);//vérifie le fonctionnement des promos pour le personnel
		
//		casTest.logAdherentAvecPanier(clients, produits); //test le passage d'un client simple à un adhérent 
															//en conservant panier et recalcul des promos.
		
		
		
	}

}
