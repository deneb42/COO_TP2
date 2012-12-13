package client;

public class Adherents extends CatClient {

	private int points;
	private int seuil;
	private int rabais;
	
	public Adherents(String nom, int seuil, int rabais) {
		super(nom);
		points = 0;
		this.seuil = seuil;
		this.rabais = rabais;		
	}
	
	public void ajouterPoints(int points){ 
		this.points += points;
	}
	
	public void consommerPoints(int points){
		this.points -= points;
	}

	public int calculReduc() {
		if(points >= seuil){
			return rabais;
		}
		return 0;
	}

	@Override
	public void connexion() {
		// TODO Auto-generated method stub
		
	}
}
