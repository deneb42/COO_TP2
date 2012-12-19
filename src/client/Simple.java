package client;

public class Simple extends CatClient {

	private static Simple singleton;
	
	private Simple(String nom) {
		super(nom);
		propCat = "Personne visitant le site exceptionnellement, ne bénéficient pas du cumul des points.";
	}
	
	public static CatClient getCat() {
		if(singleton==null)
			singleton = new Simple("Anonyme");
		
		return singleton;
	}

	@Override
	public void connexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calculReduc() {	
		return 0;
	}
}
