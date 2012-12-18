package test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import produit.CD;
import produit.High_Tech;
import produit.Livre;
import produit.Produit;
import produit.Spectacle;

public class TestProduit {

	public static void main(String[] args) {
		ArrayList<Produit> p = new ArrayList<Produit>();
		
		p.add(new CD(1, "Bobby Lapointe Tour 88", "Bobby Lapointe"));
		p.add(new High_Tech(2, "MacBookAir", "Un gros paquet de spec de fou"));
		p.add(new Livre(3, "Bilbo le Hobbit", "J.R.R Tolkien", "L'histoire d'un hobbit bien loin de chez lui"));
		//p.add(new Produit(4, "test non concluant"));
		p.add(new Spectacle(5, "Tri Yann en concert", new GregorianCalendar(2012, 11, 21, 21,12).getTime(), "Paris"));
		p.add(new Livre(6, "Le livre de la jungle", "S carr", "un joli compte pour enfant"));
		
		for(Produit pitiP:p) {
			System.out.println(pitiP.toString());
		}
	}

}
