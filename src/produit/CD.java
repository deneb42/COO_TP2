package produit;

public class CD extends Produit {
	static final int nbFidelDef=2;
	String artiste;
	
	public CD(int id, float p, String n, int nf, String a) {
		super(id, p, n, nf);
		artiste=a;
	}
	
	public CD(int id, float p, String n, String a) {
		this(id, p, n, nbFidelDef, a);
	}
	
	@Override
	public String toString() {
		return super.toString() + " (CD), Artiste: " + artiste;
	}

}
