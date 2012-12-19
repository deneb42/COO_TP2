package client;

public class Simple extends CatClient {

	private Simple singleton;
	
	private Simple(String nom) {
		super(nom);
		propCat = "Personne visitant le site exceptionnellement, ne bénéficient pas du cumul des points.";
	}
	
	@Override
	public CatClient getCat() {
		if(singleton==null)
			return new Singleton("Inconnu");
		return null;
	}


	@Override
	public int calculReduc() {	
		return 0;
	}
}
