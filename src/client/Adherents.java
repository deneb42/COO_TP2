package client;

public class Adherents extends CatClient {
	static private int seuil = 100;
	
	private int points;
	private int rabais;
	
	public Adherents(String nom,int rabais) {
		super(nom);
		points = 0;
		this.rabais = rabais;	
		propCat = "Personnes ayant adhérées au site, elles cumulent des points pour bénéficier de reductions.";
	}
	
	public void ajouterPoints(int points){ 
		this.points += points;
	}
	
	public void consommerPoints(int points){
		this.points -= points;
	}

	public int calculReduc() {
		float reduc = 0;
		
		if(points >= seuil){
			return rabais;
		}
		return 0;
	}

}
