package test;

import java.util.ArrayList;

import produit.CD;
import produit.High_Tech;
import produit.Livre;
import produit.Produit;
import client.CatClient;
import client.Client;
import client.Simple;

public class TestPanier {

	public static void main(String[] args) {
		
		Client c1 = new Client("BADIE", "Jean", "jean.badie@gmail.com", "0607080910", 0, new Simple("simple"));
		ArrayList<Produit> listProduit = new ArrayList<Produit>();
		Produit p1 = new CD(1, "Bobby Lapointe Live", "Bobby Lapointe");
		Produit p2 = new High_Tech(2, "MacBook Pro 13", "intel Core 2 Duo, RAm : 8Go");
		Produit p3 = new Livre(3, "L'informatique pour les nuls", "Les Nuls", "Vous ne comprenez rien à l'informatique ? Ce livre est fait pour vous.");
		listProduit.add(p1);
		listProduit.add(p2);
		listProduit.add(p3);
		
		System.out.println("ajout de p1");
		c1.getSonPanier().ajouterProduit(p1);
		System.out.println(c1.getSonPanier().toString());
		System.out.println("ajout de p2");
		c1.getSonPanier().ajouterProduit(p2);
		System.out.println(c1.getSonPanier().toString());
		System.out.println("ajout de p1 pour doubler quantité");
		c1.getSonPanier().ajouterProduit(p1);
		System.out.println(c1.getSonPanier().toString());
		
	}
	
	
}
