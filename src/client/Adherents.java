package client;

import produit.Produit;


public class Adherents extends CatClient {
	private static int seuil = 100;
	private static float rabais = 20;
	private static int nbAdherent=0;
	
	private int points;
	
	private Adherents(String nom) {
		super(nom);
		points = 0;
		propCat = "Personnes ayant adhérées au site, elles cumulent des points pour bénéficier de reductions.";
	}
	
	static public CatClient getCat() {
		return new Adherents("adherent n°" + nbAdherent++);
	}
	
	public void ajouterPoints(int points){ 
		this.points += points;
	}
	
	public void consommerPoints(int points){
		this.points -= points;
	}

	public float calculReduc(Produit p) {
		float reduc = 0;
		
		if(points >= seuil){
			reduc+= rabais;
		}
		
		return reduc;
	}
	
	/*public float calculReduc(Produit p) {
		float reduc = 0;
		
		if(points >= seuil){
			reduc+= rabais;
		}
		
		return reduc;
	}*/
	
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
}
