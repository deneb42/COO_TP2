package courses;

import java.util.Observable;
import java.util.Observer;

/**
 * Alertes sur le Prix d'un panier, affiche si le prix du panier dépasse une valeur donnée
 * @author BADIE & BLOIS
 *
 */
public class AlertesPrixPanier implements Observer{

	private float seuil;
	
	/**
	 * Construteur
	 * @param s
	 */
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
			o.deleteObserver(this); // si l'objet observé ne correspond pas au type attendu, on retire l'observeur de la liste des observeurs 
		}
	}
	
	public String toString() {
		return "Alerte de prix du panier, seuil: " + seuil;
	}
}
