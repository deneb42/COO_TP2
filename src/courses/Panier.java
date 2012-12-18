package courses;

import java.util.HashMap;

import produit.Produit;
import promo.Promotion;
import client.Client;
import exceptions.NoArticleException;

public class Panier {
	private Client sonClient;
	private HashMap<Produit, Integer> contenuPanier; //produit et quantité.
	private float montantTotal;
	private float totalReducPanier;
	
	public Panier(Client c) {
		sonClient = c;
		contenuPanier = new HashMap<Produit, Integer>();
		montantTotal = 0;
		totalReducPanier = 0;
	}
	public Panier (Client c, Produit p){
		this(c);
		ajouterProduit(p);
	}
	
	public void ajouterProduit(Produit p){
		if(contenuPanier.containsKey(p)){//l'article est déjà dans le panier
			int nbTmp = contenuPanier.get(p);
			nbTmp += 1; 						//on incrémente la quantité
			contenuPanier.put(p, nbTmp);
			montantTotal += p.getPrix();
		}
		else {//sinon on ajoute juste le produit, avec une quantité à 1
			
			contenuPanier.put(p, 1);
			montantTotal = p.getPrix();
		}
	}

	public void retirerProduit(Produit p) throws NoArticleException{
		if(contenuPanier.containsKey(p)){
			if(contenuPanier.get(p)>1){//on a plus de 2 fois le produit dans le panier, on en enlève une.
				int qtTmp = contenuPanier.get(p);
				qtTmp--;
				contenuPanier.put(p, qtTmp);
				montantTotal -= p.getPrix();
			}
			else {
				contenuPanier.remove(p);
				montantTotal -= p.getPrix();
			}
		}
		else throw new NoArticleException("le panier ne contient pas cet article");	
	}
	
	public String toString() {
		StringBuilder msg = new StringBuilder();
		
		msg.append("Contenu du panier : \n\n");
		
		for(Produit p : contenuPanier.keySet()){
			msg.append(p.toString());
			msg.append("   quantite : ");
			msg.append(contenuPanier.get(p));			
			msg.append("\n");
		}
		msg.append("\n-----\nMontant total du panier :");
		msg.append(montantTotal);
		msg.append("\nMontant des reductions : ");
		msg.append(totalReducPanier);
		msg.append("\n--------------------------------------------------\n");
			
		
		return msg.toString();
	}
	
	public void appliquerReduc(float valeur){
		montantTotal -= valeur;
		totalReducPanier += valeur;
	}
	
	public int calculGainPoint(){
		int totalPt = 0;
		for(Produit p : contenuPanier.keySet()){
			totalPt += p.getNbFidelite();
		}
		return totalPt;
	}
	
	public float calculReduc() {
		float reduc = sonClient.getCategorie().calculReduc(this); // calcul des promos liées a la catégorie du client (personnel, adhérent)
		
		for(Produit p:contenuPanier.keySet()) { // calcul des promos de produit
			for(Promotion promo: p.getPromos()) {
				reduc+=promo.calculerReduc();
			}
		}
		
		return reduc;
	}
	
	/* ******************************
	 * Getter et Setter
	 ****************************** */
	public void setContenuPanier(HashMap<Produit, Integer> contenuPanier) { this.contenuPanier = contenuPanier; }
	public void setMontantTotal(float montantTotal) { this.montantTotal = montantTotal; }
	public void setTotalReducPanier(float totalReducPanier) { this.totalReducPanier = totalReducPanier; }
	public HashMap<Produit, Integer> getContenuPanier() { return contenuPanier; }
	public float getMontantTotal() { return montantTotal; }
	public float getTotalReducPanier() { return totalReducPanier; }
}
