package client;

public class Adherents extends CatClient {
	private static int seuil = 100;
	private static int nbAdherent=0;
	
	private int points;
	private int rabais;
	
	private Adherents(String nom) {//int rabais) {
		super(nom);
		points = 0;
		//this.rabais = rabais;	
		propCat = "Personnes ayant adhérées au site, elles cumulent des points pour bénéficier de reductions.";
	}
	
	static public CatClient getCat() {
		return new Adherents("adherent n°" + nbAdherent);
	}
	
	public void ajouterPoints(int points){ 
		this.points += points;
	}
	
	public void consommerPoints(int points){
		this.points -= points;
	}

	public int calculReduc() {
		//float reduc = 0;
		
		if(points >= seuil){
			return rabais;
		}
		return 0;
	}

	@Override
	public CatClient getCat() {
		// TODO Auto-generated method stub
		return null;
	}

}
