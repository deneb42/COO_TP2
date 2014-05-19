package courses;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import client.Client;

/**
 * Emet une alerte si une personne se connecte
 * @author BADIE & BLOIS
 *
 */
public class AlerteConnection implements Observer {
	
	/**
	 * Constructeur
	 */
	public AlerteConnection () {} // possibilité d'ajouter une contrainte d'heure
	
	@Override
	public void update(Observable o, Object arg) {
		try {
			Client c = (Client)o;
			System.out.println("Alerte: le client " + c.getId() + " (" + c.getPrenom() + " " + c.getNom() + ") s'est (de)connecte a " + new Date());
		}catch(ClassCastException e) {
			o.deleteObserver(this); // si l'objet observé ne correspond pas au type attendu, on retire l'observeur de la liste des observeurs
		}
	}
	
	public String toString() {
		return "Alerte de connection";
	}
}
	