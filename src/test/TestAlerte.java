package test;

import java.util.ArrayList;

import produit.Produit;
import client.Client;
import courses.AlerteConnection;
import courses.AlertePrixPanier;
import courses.AlerteQtePdt;
import courses.GestionnaireAlertes;

/**
 * Classe de création des alertes
 * @author BADIE & BLOIS
 *
 */
public class TestAlerte {
	
	/**
	 * Initialisation des Alertes
	 * @param produits
	 * @param clients
	 */
	public static void creerAlertes(ArrayList<Produit> produits, ArrayList<Client> clients){
		
		/* Creation de l'alerte Connection sur tous les clients*/
		GestionnaireAlertes.ajouterObserveur(new AlerteConnection(), clients);
		
		/* creation d'une alerte qte pdt */
		GestionnaireAlertes.ajouterObserveur(new AlerteQtePdt(produits.get(1), 2), clients);
		
		/* creation d'une alerte surveillance montant panier */
		GestionnaireAlertes.ajouterObserveur(new AlertePrixPanier(1000f), clients);
	}
}
