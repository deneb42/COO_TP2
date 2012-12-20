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
			System.out.println("Alerte: le client " + c.getId() + "(" + c.getPrenom() + " " + c.getNom() + ") s'est connecte a " + new Date());
		}catch(ClassCastException e) {
			System.err.println("L'objet observe n'est pas du bon type");
		}
	}
}
	