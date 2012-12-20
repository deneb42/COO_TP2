package client;

import java.util.ArrayList;

import produit.Produit;
import promo.PromoAdherent;

/**
 * Représente la catégorie client
 * @author jeanbadie
 *
 */

public class Adherents extends CatClient {
	private static int seuil = 100;
	private static float rabais = 20;
	private static int nbAdherent=0;
	private static ArrayList<PromoAdherent> sesPromos = new ArrayList<PromoAdherent>();;
	
	private int points;
	
	/**
	 * Constructeur
	 * @param nom
	 */
	private Adherents(String nom) {
		super(nom, "Personnes ayant adhérées au site, elles cumulent des points pour bénéficier de reductions.");
		points = 0;		
	}
	
	static public CatClient getCat() {
		return new Adherents("adherent n°" + nbAdherent++);
	}
	
	@Override
	public float calculReduc(Produit p) {
		int i=0;
			i = sesPromos.indexOf(p);
			if(i!=-1)
				return sesPromos.get(i).calculerReduc();
		return 0;
	}
	
	/**
	 * ajoute des points à l'adhérent
	 * @param points
	 */
	public void ajouterPoints(int points){ 
		this.points += points;
	}
	
	/**
	 * Consomme les points de l'adhérent
	 */
	public void consommerPoints(){
		this.points -= seuil;
	}
	
	/**
	 * Retourne la valeur du rabais obtenu par les points
	 * @return
	 */
	public float getRabaisActu() {return points>=seuil?rabais:0;}
	
	public String toString(){
		StringBuilder msg = new StringBuilder();
		msg.append(super.toString());
		msg.append("\nNombre de points cumulés : ");
		msg.append(points);
		msg.append("\n");
		
		return msg.toString();
	}
	
	/* ************************
	 * GETTER & SETTER
	 ************************ */
	public int getPoints(){return points;}
	public void setPoints(int points){this.points = points;}
	public int getSeuil() {return seuil;}
	
	public static void removePromo(PromoAdherent promo) { sesPromos.remove(promo); }
	public static void addPromo(PromoAdherent promo) { sesPromos.add(promo); }
	public static ArrayList<PromoAdherent> getPromos() { return sesPromos; }
}
