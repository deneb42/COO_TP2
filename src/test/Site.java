package test;

import java.util.ArrayList;

import produit.Produit;
import client.Adherents;
import client.Client;
import exceptions.NoArticleException;

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
		
		/* Test sur un panier simple */
		Client c1 = clients.get(0);
		System.out.println(c1.toString()); // on affiche le client sélectionné
		System.out.println("ajout de p1");
		c1.getSonPanier().ajouterProduit(produits.get(1)); // on ajoute le premier produit
		System.out.println(c1.getSonPanier().toString());
		System.out.println("ajout de p2");
		c1.getSonPanier().ajouterProduit(produits.get(2)); // on ajoute le 2eme produit
		System.out.println(c1.getSonPanier().toString());
		System.out.println("ajout de p1 pour doubler quantité"); // test pour doubler une quantité
		c1.getSonPanier().ajouterProduit(produits.get(1));
		System.out.println(c1.getSonPanier().toString());
		System.out.println("suppression de p1");
		try {
			c1.getSonPanier().retirerProduit(produits.get(1)); //on supprime p1 présent dans le panier
		} catch (NoArticleException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(c1.getSonPanier().toString());
		
		System.out.println("suppression de p3 inexistant dans le panier");
		try {
			c1.getSonPanier().retirerProduit(produits.get(3)); //on supprime p3 qui n'existe pas dans le panier, il doit lever une exception
		} catch (NoArticleException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(c1.getSonPanier().toString());
		/* *********************************** */
		
		/* Test d'Opération sur les clients */
		System.out.println("------------------------------------");
		System.out.println("Opérations sur un client");
		Client c2 = clients.get(3);
		System.out.println(c2.toString());
		System.out.println("Connexion d'un client");
		c2.connexion(Adherents.getCat()); //le client est simple, il se connecte au systeme et deviens adhérent.
		System.out.println(c2.toString());
		System.out.println("Deconnexion d'un client");
		c2.deconnexion(); //le client est adherent, il se deconnecte au systeme et deviens simple.
		System.out.println(c2.toString());

		/* *********************************** */

		/* Test sur les promos d'adhérents */
		System.out.println("------------------------------------");
		System.out.println("Test promos adhérents : sélection d'un client adhérents sans points"); // on suppose qu'il s'est connecté avant
		Client c3 = clients.get(2);
		System.out.println(c3.toString());
		
		c3.getSonPanier().ajouterProduit(produits.get(0));
		c3.getSonPanier().ajouterProduit(produits.get(2));
		c3.getSonPanier().ajouterProduit(produits.get(3));
		System.out.println(c3.getSonPanier().toString());
		//System.out.println("paiement du panier");
		c3.getSonPanier().payerPanier();
		
		System.out.println("------------------------------------");
		System.out.println("Test promos adhérents : sélection d'un client adhérents avec assez de points pour bénéficier d'une promo"); // on suppose qu'il s'est connecté avant
		c3 = clients.get(2);
		((Adherents) c3.getCategorie()).ajouterPoints(200);
		System.out.println(c3.toString());
		
		c3.getSonPanier().ajouterProduit(produits.get(0));
		c3.getSonPanier().ajouterProduit(produits.get(2));
		c3.getSonPanier().ajouterProduit(produits.get(3));
		System.out.println(c3.getSonPanier().toString());
		//System.out.println("paiement du panier");
		c3.getSonPanier().payerPanier();
		
		
		
		
	}

}
