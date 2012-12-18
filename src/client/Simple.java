package client;

public class Simple extends CatClient {

	public Simple(String nom) {
		super(nom);
		propCat = "Personne visitant le site exceptionnellement, ne bénéficient pas du cumul des points.";
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
