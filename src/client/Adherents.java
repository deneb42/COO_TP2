package client;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

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
		nbAdherent++;
		return new Adherents("adherent n°" + nbAdherent);
	}
	
	public void ajouterPoints(int points){ 
		this.points += points;
	}
	
	public void consommerPoints(int points){
		this.points -= points;
	}

	public float calculReduc() {
		//float reduc = 0;
		
		if(points >= seuil){
			return rabais;
		}
		return 0;
	}
	
	public String toString(){
		StringBuilder msg = new StringBuilder();
		msg.append(super.toString());
		msg.append("\nNombre de points cumulés : ");
		msg.append(points);
		msg.append("\n");
		
		return msg.toString();
	}

}
