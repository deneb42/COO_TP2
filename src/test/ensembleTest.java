package test;

import java.util.ArrayList;

import produit.Produit;
import client.Adherents;
import client.Client;
import exceptions.NoArticleException;

public class ensembleTest {
	
	public ensembleTest() {
	
	}
	
	/* Test sur un panier simple */
	public static void ajoutPanierSimple(ArrayList<Client> clients, ArrayList<Produit> produits){
		
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
		
	}
	
	/* Test d'Opération sur les clients */
	
	public static void operationsClients(ArrayList<Client> clients, ArrayList<Produit> produits){
		System.out.println("------------------------------------");
		System.out.println("Opérations sur un client");
		Client c2 = clients.get(3);
		System.out.println(c2.toString());
		System.out.println("Connexion d'un client");
		c2.connexion(Adherents.getCat()); //le client est simple, il se connecte au systeme et deviens adhérent.
		System.out.println(c2.toString());
		System.out.println("Deconnexion d'un client");
		c2.deconnexion(); //le client est adherent, il se deconnecte du systeme et deviens simple.
		System.out.println(c2.toString());
	}
	

	/* Test sur les promos d'adhérents */
	
	public static void promoAdherents(ArrayList<Client> clients, ArrayList<Produit> produits){
		
		System.out.println("------------------------------------");
		System.out.println("Test promos adhérents : sélection d'un client adhérents sans points"); // on suppose qu'il s'est connecté avant
		Client c3 = clients.get(2);
		System.out.println(c3.toString());
		
		c3.getSonPanier().ajouterProduit(produits.get(0));
		c3.getSonPanier().ajouterProduit(produits.get(2));
		c3.getSonPanier().ajouterProduit(produits.get(3));
		System.out.println(c3.getSonPanier().toString());
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
		c3.getSonPanier().payerPanier();
		System.out.println(c3.toString());
	}
	
	
	/* Test sur les promos Personnel */
	public static void promoPersonnel(ArrayList<Client> clients, ArrayList<Produit> produits){
		System.out.println("------------------------------------");
		System.out.println("Test promos personnel : sélection d'un membre du personnel"); // on suppose qu'il s'est connecté avant
		Client c4 = clients.get(0);
		System.out.println(c4.toString());
		
		c4.getSonPanier().ajouterProduit(produits.get(4));
		c4.getSonPanier().ajouterProduit(produits.get(7));
		c4.getSonPanier().ajouterProduit(produits.get(5));
		c4.getSonPanier().ajouterProduit(produits.get(3));
		System.out.println(c4.getSonPanier().toString());
		c4.getSonPanier().payerPanier();
	}
	

	
	/* Test le passage d'un client anonyme à un adhérent en conservant le panier => calcul de nouvelle réduc */
	
	public static void logAdherentAvecPanier(ArrayList<Client> clients, ArrayList<Produit> produits){
		System.out.println("------------------------------------");
		System.out.println("Test log et conservation du panier"); // on suppose qu'il s'est connecté avant
		Client c5= clients.get(3);
		System.out.println(c5.toString());
		
		c5.getSonPanier().ajouterProduit(produits.get(4));
		c5.getSonPanier().ajouterProduit(produits.get(7));
		c5.getSonPanier().ajouterProduit(produits.get(5));
		c5.getSonPanier().ajouterProduit(produits.get(2));
		System.out.println(c5.getSonPanier().toString());
		
		c5.connexion(Adherents.getCat()); //connexion et on suppose que le client à déjà des points de cumulé
		((Adherents) c5.getCategorie()).ajouterPoints(100);
		System.out.println(c5.toString());
		System.out.println(c5.getSonPanier().toString());
		
		c5.getSonPanier().payerPanier();
	}
	
}
