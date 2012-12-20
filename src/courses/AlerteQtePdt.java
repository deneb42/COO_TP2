package courses;

import java.util.Observable;
import java.util.Observer;

import produit.Produit;

public class AlerteQtePdt implements Observer {
	private Produit pdt;
	private int nb;
	
	public AlerteQtePdt(Produit p, int qte) {
		pdt=p;
		nb=qte;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		try {
			Panier p = (Panier)o;
			if(p.getContenuPanier().get(pdt)>=nb)
				System.out.println("Alerte: plus de " + nb + " " + pdt.getNom() + "(" + pdt.getIdProduit() + ") dans un panier");
		}catch(ClassCastException e) {
			//System.err.println("L'objet observe n'est pas du bon type");
			o.deleteObserver(this); // si l'objet observé ne correspond pas au type attendu, on retire l'observeur de la liste des observeurs 
		}
	}
	
	public String toString() {
		return "Alerte de quantite sur " + pdt.getNom() + "(" + pdt.getIdProduit() + "), qte: " + nb;
	}
}
