package courses;

import java.util.Observer;
import java.util.Set;

import client.Client;

public class GestionnaireAlertes {
	public static void ajouterObserveurPanier(Observer o, Set<Client> clients) {
		for(Client c:clients) {
			c.getSonPanier().addObserver(o);
			c.addObserver(o);
		}
	}
	
	public static void removeObserveurPanier(Observer o, Set<Client> clients) {
		for(Client c:clients) {
			c.getSonPanier().deleteObserver(o);
			c.deleteObserver(o);
		}
	}
	/*
	public static void afficheObserveurPanier(Set<Client> clients) {
		for(Client c:clients) {
			System.out.println("client " + c.getId()  + " (" + c.getPrenom() + " " + c.getNom() + ")";
			for(c.)
		}
	}*/
}
