package courses;

import java.util.Collection;
import java.util.Observer;

import client.Client;

/**
 * Permet de gérer les alertes
 * @author BADIE & BLOIS
 *
 */
public class GestionnaireAlertes {
	
	/**
	 * Permet d'ajouter des Observer
	 * @param o
	 * @param clients
	 */
	public static void ajouterObserveur(Observer o, Collection<Client> clients) {
		for(Client c:clients) {
			c.getSonPanier().addObserver(o);
			c.addObserver(o);
		}
	}
	
	/**
	 * Permet de retirer des observer
	 * @param o
	 * @param clients
	 */
	public static void removeObserveur(Observer o, Collection<Client> clients) {
		for(Client c:clients) {
			c.getSonPanier().deleteObserver(o);
			c.deleteObserver(o);
		}
	}
}
