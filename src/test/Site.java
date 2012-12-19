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
		
		Client c1 = clients.get(0);
		System.out.println(c1.toString());
		System.out.println("ajout de p1");
		c1.getSonPanier().ajouterProduit(produits.get(1));
		System.out.println(c1.getSonPanier().toString());
		System.out.println("ajout de p2");
		c1.getSonPanier().ajouterProduit(produits.get(2));
		System.out.println(c1.getSonPanier().toString());
		System.out.println("ajout de p1 pour doubler quantité");
		c1.getSonPanier().ajouterProduit(produits.get(1));
		System.out.println(c1.getSonPanier().toString());
		
		System.out.println("suppression de p1");
		try {
			c1.getSonPanier().retirerProduit(produits.get(1));
		} catch (NoArticleException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(c1.getSonPanier().toString());
		
		/*System.out.println("suppression de p3 inexistant dans le panier");
		try {
			c1.getSonPanier().retirerProduit(produits.get(3));
		} catch (NoArticleException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(c1.getSonPanier().toString());*/
		
		System.out.println("Opérations sur un client");
		Client c2 = clients.get(3);
		System.out.println(c2.toString());
		System.out.println("changement de catégorie du client");
		c2.connexion(Adherents.getCat());
		System.out.println(c2.toString());
		
	}

}
