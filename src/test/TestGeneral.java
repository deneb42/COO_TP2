package test;

import java.util.ArrayList;
import java.util.HashMap;

import produit.*;

import courses.*;
import client.*;
import exceptions.ProduitNExistePasException;

public class TestGeneral {
	private HashMap<Client, Panier> listClient; //Client est unique donc peut être la clé de la hashmap
	private ArrayList<Produit> listProduit;
	
	
	/**
	 * Vérifie l'existence du produit dans la liste et le retourne s'il existe.
	 * @param p
	 * @return
	 * @throws ProduitNExistePasException
	 */
	public Produit getProduit(Produit p) throws ProduitNExistePasException{
		if(listProduit.contains(p)){
			return p;
		}
		else throw new ProduitNExistePasException(p.toString()+" n'existe pas");
	}
	
	
}
