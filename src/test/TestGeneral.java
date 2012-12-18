package test;

import java.util.ArrayList;

import produit.*;
import exceptions.ProduitNExistePasException;

public class TestGeneral {
	//private static HashMap<Client, Panier> listClient; //Client est unique donc peut être la clé de la hashmap
	private static ArrayList<Produit> listProduit;
	
	
	/**
	 * Vérifie l'existence du produit dans la liste et le retourne s'il existe.
	 * @param p
	 * @return
	 * @throws ProduitNExistePasException
	 */
	public static Produit getProduit(String nom) throws ProduitNExistePasException{
		
		for(Produit p : listProduit){
			if (p.getNom().equals(nom)) return p; 
		}
		
		throw new ProduitNExistePasException(nom+" n'existe pas");
	}
	
	public static void main(String[] args){
		//listClient = new HashMap<Client, Panier>();
		listProduit = new ArrayList<Produit>();
		
		listProduit.add(new CD(1, "Bobby Lapointe Live", "Bobby Lapointe"));
		listProduit.add(new High_Tech(2, "MacBook Pro 13", "intel Core 2 Duo, RAm : 8Go"));
		listProduit.add(new Livre(3, "L'informatique pour les nuls", "Les Nuls", "Vous ne comprenez rien à l'informatique ? Ce livre est fait pour vous."));
		
		try{
			Produit produit = TestGeneral.getProduit("toto");
			System.out.println(produit.toString());
		} catch (ProduitNExistePasException e) {
				System.err.println(e.getMessage());
		}
		try{
			Produit produit = TestGeneral.getProduit("Bobby Lapointe Live");
			System.out.println(produit.toString());
		} catch (ProduitNExistePasException e) {
				System.err.println(e.getMessage());
		}
		
	}
}
