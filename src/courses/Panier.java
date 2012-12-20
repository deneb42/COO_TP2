package courses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;

import produit.Produit;
import promo.PromoFlash;
import client.Adherents;
import client.Client;
import exceptions.NoArticleException;

/**
 * Modelise le panier du client
 * @author BADIE & BLOIS
 *
 */

public class Panier extends Observable {
	private static ArrayList<PromoFlash> pFlash = new ArrayList<PromoFlash>();
	private Client sonClient;
	private HashMap<Produit, Integer> contenuPanier; //produit et quantité.
	private float montantSsReduc;
	private float totalReducPanier;
	
	/**
	 * Constructeur
	 * @param c
	 */
	public Panier(Client c) {
		sonClient = c;
		contenuPanier = new HashMap<Produit, Integer>();
		montantSsReduc = 0;
		totalReducPanier = 0;
	}
	
	/**
	 * Constructeur avec ajout immédiat d'un produit
	 * @param c
	 * @param p
	 */
	public Panier (Client c, Produit p){
		this(c);
		ajouterProduit(p);
	}
	
	/**
	 * Ajout d'un produit au panier puis appelle le calcul des reduction
	 * @param p
	 */
	public void ajouterProduit(Produit p){
		if(contenuPanier.containsKey(p)){//l'article est déjà dans le panier
			int nbTmp = contenuPanier.get(p);
			nbTmp += 1; 						//on incrémente la quantité
			contenuPanier.put(p, nbTmp);
		}
		else {//sinon on ajoute juste le produit, avec une quantité à 1
			contenuPanier.put(p, 1);
		}
		montantSsReduc += p.getPrix();
		this.calculReduc();
		setChanged();
		notifyObservers();
	}

	/**
	 * Retire un produit au panier puis appelle le calcul des reduction
	 * @param p
	 * @throws NoArticleException
	 */
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
		setChanged();
		notifyObservers();
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

	/**
	 * Calcul le gain des points sur l'ensemble du panier
	 * @return
	 */
	public int calculGainPoint(){
		int totalPt = 0;
		for(Produit p : contenuPanier.keySet()){
			totalPt += p.getNbFidelite();
		}
		return totalPt;
	}
	
	/**
	 * Pour tous les produits du paniers et toutes les reductions, calcul les reduction possible
	 * @return
	 */
	public float calculReduc() {
		float tmp=0; 
		totalReducPanier = 0;
		for(int i=0;i<pFlash.size();i++) {
			totalReducPanier+=pFlash.get(i).calculerReduc()*pFlash.get(i).nbOcc(contenuPanier);
			// si pas de reduc, nb=0 donc non prise en compte de la reduc.
		}
		for(Entry<Produit,Integer> e:contenuPanier.entrySet()) { // calcul des promos de produit
			tmp = sonClient.getCategorie().calculReduc(e.getKey()); // récupère une eventuelle promo de compte sur ce produit
			if(tmp==0) { // si on n'a pas trouvé de promo (priorité des promos)
				tmp+=e.getKey().calculReduc();
			}
			totalReducPanier+=tmp;
		}
		try{
			totalReducPanier += ((Adherents)sonClient.getCategorie()).getRabaisActu();
		}catch(ClassCastException e) {}
	
		return totalReducPanier;
	}
	
	/**
	 * Modélise le paiement du panier, consomme les points, ajoute les points obtenu et réinitialise le panier
	 */
	public void payerPanier(){
		System.out.println("PAIEMENT DU PANIER\n" +
				"Envoi vers le module de paiement en ligne\n" +
				".................\n" +
				"Votre commande a bien été payée\n" +
				"Montant total débité : " + getMontantTotal());
		
		try {
			int points = this.calculGainPoint();
			((Adherents) sonClient.getCategorie()).consommerPoints();
			((Adherents) sonClient.getCategorie()).ajouterPoints(points);
			System.out.println("Cher adhérent aujourd'hui vous avez cumulé : " + points + " points.");
		} catch (ClassCastException e) {}
		viderPanier();
	}
	
	/**
	 * 
	 */
	public void viderPanier(){
		this.contenuPanier.clear();
		this.montantSsReduc = 0;
		this.totalReducPanier = 0;
	}
	
	/* ******************************
	 * Getter et Setter
	 ****************************** */
	public static void addPromoFlash(PromoFlash pf) { pFlash.add(pf); }
	public static void removePromoFlash(PromoFlash pf) { pFlash.remove(pf); }
	
	public void setContenuPanier(HashMap<Produit, Integer> contenuPanier) { this.contenuPanier = contenuPanier; }
	public void setMontantTotal(float montantTotal) { this.montantSsReduc = montantTotal; }
	public void setTotalReducPanier(float totalReducPanier) { this.totalReducPanier = totalReducPanier; }
	public HashMap<Produit, Integer> getContenuPanier() { return contenuPanier; }
	public float getMontantSsReduc() { return montantSsReduc; }
	public float getMontantTotal() { return montantSsReduc-totalReducPanier<0?0:montantSsReduc-totalReducPanier; }
	public float getTotalReducPanier() { return totalReducPanier; }
	public static ArrayList<PromoFlash> getPromoFlash() { return pFlash; }
}
