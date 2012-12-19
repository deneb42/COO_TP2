package client;

public class Simple extends CatClient {

	public Simple(String nom) {
		super(nom);
		propCat = "Personne visitant le site exceptionnellement, ne bénéficient pas du cumul des points.";
	}


	@Override
	public int calculReduc() {	
		return 0;
	}
}
