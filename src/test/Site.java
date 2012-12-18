package test;

import java.util.ArrayList;

import produit.Produit;
import client.Adherents;
import client.Client;
import client.Personnel;
import client.Simple;
import exceptions.NoArticleException;

public class Site {

	/**
	 * @param args
	 * Classe de test du programme : va émuler le site.
	 */
	public static void main(String[] args) {
		Adherents ad = new Adherents("adherent", 30);
		Personnel perso = new Personnel("perso");
		Simple simple = new Simple("simple");	
		ArrayList<Produit> produits = TestProduit.populeProduits();
		ArrayList<Client> clients = TestClient.populeClient(ad, perso, simple);
		
		Client c1 = clients.get(0);
		
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
		
		System.out.println("suppression de p3 inexistant dans le panier");
		try {
			c1.getSonPanier().retirerProduit(produits.get(3));
		} catch (NoArticleException e) {
			System.err.println(e.getMessage());
		}
		System.out.println(c1.getSonPanier().toString());
	}

}
