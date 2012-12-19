package client;

import java.util.ArrayList;

import produit.Produit;
import promo.PromoAdherent;


public class Adherents extends CatClient {
	private static int seuil = 100;
	private static float rabais = 20;
	private static int nbAdherent=0;
	private static ArrayList<PromoAdherent> sesPromos;
	
	private int points;
	
	private Adherents(String nom) {
		super(nom);
		points = 0;
		propCat = "Personnes ayant adhérées au site, elles cumulent des points pour bénéficier de reductions.";
	}
	
	static public CatClient getCat() {
		return new Adherents("adherent n°" + nbAdherent++);
	}
	
	public float calculReduc(Produit p) {
		int i=0;
			i = sesPromos.indexOf(p);
			if(i!=-1)
				return sesPromos.get(i).calculerReduc();
		return 0;
	}
	/*public float calculReduc(Produit p) {
		float reduc = 0;
		
		if(points >= seuil){
			reduc+= rabais;
		}
		
		return reduc;
	}*/
	
	public void ajouterPoints(int points){ 
		this.points += points;
	}
	public void consommerPoints(){
		this.points -= seuil;
	}
	
	public String toString(){
		StringBuilder msg = new StringBuilder();
		msg.append(super.toString());
		msg.append("\nNombre de points cumulés : ");
		msg.append(points);
		msg.append("\n");
		
		return msg.toString();
	}
	public int getPoints(){return points;}
	public int getSeuil() {return seuil;}
	public float getRabaisActu() {return points>seuil?rabais:0;}
	
	
	public static void removePromo(PromoAdherent promo) { sesPromos.remove(promo); }
	public static void addPromo(PromoAdherent promo) { sesPromos.add(promo); }
	public static ArrayList<PromoAdherent> getPromos() { return sesPromos; }
}
