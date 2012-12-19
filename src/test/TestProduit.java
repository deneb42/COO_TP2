package test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import produit.CD;
import produit.High_Tech;
import produit.Livre;
import produit.Produit;
import produit.Spectacle;

public class TestProduit {

	public static void main(String args[]) {
		ArrayList<Produit> p = populeProduits();
		
		for(Produit pitiP:p) {
			System.out.println(pitiP.toString());
		}
	}
	
	public static ArrayList<Produit> populeProduits() {
		ArrayList<Produit> p = new ArrayList<Produit>();
		
		p.add(new CD(22.5f,"Bobby Lapointe Tour 88", "Bobby Lapointe"));
		p.add(new High_Tech(1099.00f,"MacBookAir", "Un gros paquet de spec de fou"));
		p.add(new Livre(32.20f, "Bilbo le Hobbit", "J.R.R Tolkien", "L'histoire d'un hobbit bien loin de chez lui"));
		p.add(new Spectacle(15.00f, "Tri Yann en concert", new GregorianCalendar(2012, 11, 21, 21,12).getTime(), "Paris"));
		p.add(new Livre(5.99f, "Le livre de la jungle", "S carr", "un joli compte pour enfant"));
		p.add(new CD(22.50f, "Bobby Lapointe Live", "Bobby Lapointe"));
		p.add(new High_Tech(1099.00f,"MacBook Pro 13", "intel Core 2 Duo, RAm : 8Go"));
		p.add(new Livre(19.99f, "L'informatique pour les nuls", "Les Nuls", "Vous ne comprenez rien à l'informatique ? Ce livre est fait pour vous."));
		

		
		return p;
	}

}
