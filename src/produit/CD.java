package produit;

public class CD extends Produit {
	String artiste;
	
	public CD(int id, String n, String a) {
		super(id, n);
		artiste=a;
	}
	
	@Override
	public String toString() {
		return super.toString() + " (CD), Artiste: " + artiste;
	}

}
