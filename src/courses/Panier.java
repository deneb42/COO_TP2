package courses;

import java.util.HashMap;
import java.util.Map.Entry;

import produit.Produit;
import client.Adherents;
import client.Client;
import exceptions.NoArticleException;

public class Panier {
	private Client sonClient;
	private HashMap<Produit, Integer> contenuPanier; //produit et quantité.
	private float montantSsReduc;
	private float totalReducPanier;
	
	public Panier(Client c) {
		sonClient = c;
		contenuPanier = new HashMap<Produit, Integer>();
		montantSsReduc = 0;
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
			montantSsReduc += p.getPrix();
			this.calculReduc();
			
		}
		else {//sinon on ajoute juste le produit, avec une quantité à 1
			
			contenuPanier.put(p, 1);
			montantSsReduc += p.getPrix();
			this.calculReduc();

		}
	}

	public void retirerProduit(Produit p) throws NoArticleException{
		if(contenuPanier.containsKey(p)){
			if(contenuPanier.get(p)>1){//on a plus de 2 fois le produit dans le panier, on en enlève une.
				int qtTmp = contenuPanier.get(p);
				qtTmp--;
				contenuPanier.put(p, qtTmp);
				montantSsReduc -= p.getPrix();
				this.calculReduc();
			}
			else {
				contenuPanier.remove(p);
				montantSsReduc -= p.getPrix();
				this.calculReduc();
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
		msg.append(montantSsReduc);
		msg.append("\nMontant des reductions : ");
		msg.append(totalReducPanier);
		msg.append("\nMontant total apres reductions : ");
		msg.append(getMontantTotal());
		msg.append("\n--------------------------------------------------\n");
			
		
		return msg.toString();
	}
	
	public void appliquerReduc(float valeur){
		montantSsReduc -= valeur;
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
		
		for(Entry<Produit,Integer> e:contenuPanier.entrySet()) { // calcul des promos de produit
			if(e.getKey().getPromo()!=null) {
				reduc+=e.getKey().getPromo().calculerReduc()*e.getValue();
			}
		}
		totalReducPanier = reduc;
		return reduc;
	}
	
	public void payerPanier(){
		System.out.println("PAIEMENT DU PANIER\n" +
				"Envoi vers le module de paiement en ligne\n" +
				".................\n" +
				"Votre commande a bien été payée\n" +
				"Montant total débité : " + getMontantTotal());
		
		try {
			int points = this.calculGainPoint();
			((Adherents) sonClient.getCategorie()).consommerPoints( ((Adherents) sonClient.getCategorie()).getPoints() - ((Adherents) sonClient.getCategorie()).getSeuil());
			((Adherents) sonClient.getCategorie()).ajouterPoints(points);
			System.out.println("Cher adhérent aujourd'hui vous avez cumulé : " + points + " points.");
		} catch (ClassCastException e) {}
		viderPanier();
	}
	
	public void viderPanier(){
		this.contenuPanier.clear();
		this.montantSsReduc = 0;
		this.totalReducPanier = 0;
	}
	
	/* ******************************
	 * Getter et Setter
	 ****************************** */
	public void setContenuPanier(HashMap<Produit, Integer> contenuPanier) { this.contenuPanier = contenuPanier; }
	public void setMontantTotal(float montantTotal) { this.montantSsReduc = montantTotal; }
	public void setTotalReducPanier(float totalReducPanier) { this.totalReducPanier = totalReducPanier; }
	public HashMap<Produit, Integer> getContenuPanier() { return contenuPanier; }
	public float getMontantSsReduc() { return montantSsReduc; }
	public float getMontantTotal() { return montantSsReduc-totalReducPanier; }
	public float getTotalReducPanier() { return totalReducPanier; }
}
