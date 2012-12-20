package courses;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import client.Client;

public class AlerteConnection implements Observer {
	
	public AlerteConnection () {} // possibilité d'ajouter une contrainte d'heure
	
	@Override
	public void update(Observable o, Object arg) {
		try {
			Client c = (Client)o;
			System.out.println("Alerte: le client " + c.getId() + " (" + c.getPrenom() + " " + c.getNom() + ") s'est (de)connecte a " + new Date());
		}catch(ClassCastException e) {
			o.deleteObserver(this); // si l'objet observé ne correspond pas au type attendu, on retire l'observeur de la liste des observeurs 
			//System.err.println("L'objet observe n'est pas du bon type");
		}
	}
	
	public String toString() {
		return "Alerte de connection";
	}
}
	