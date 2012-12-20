package courses;

import java.util.Observable;
import java.util.Observer;

public class AlertesPrixPanier implements Observer{

	private float seuil;
	
	public AlertesPrixPanier(float s) {
		seuil=s;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		try {
			Panier p = (Panier)o;
			if(p.getMontantTotal() >= seuil) {
				System.out.println("Alerte: Un panier a plus de " + seuil + "euros (sans reduc: " + 
						p.getMontantSsReduc() + ", reduc: " + p.getTotalReducPanier() + ")");
			}
		}catch(ClassCastException e) {
			//System.err.println("L'objet observe n'est pas du bon type");
			o.deleteObserver(this); // si l'objet observé ne correspond pas au type attendu, on retire l'observeur de la liste des observeurs 
		}
	}
	
	public String toString() {
		return "Alerte de prix du panier, seuil: " + seuil;
	}
}
