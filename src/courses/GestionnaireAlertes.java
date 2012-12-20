package courses;

import java.util.Collection;
import java.util.Observer;

import client.Client;

public class GestionnaireAlertes {
	public static void ajouterObserveur(Observer o, Collection<Client> clients) {
		for(Client c:clients) {
			c.getSonPanier().addObserver(o);
			c.addObserver(o);
		}
	}
	
	public static void removeObserveur(Observer o, Collection<Client> clients) {
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
