package produit;

public class CD extends Produit {
	static final int nbFidelDef=2;
	String artiste;
	
	public CD(float p, String n, int nf, String a) {
		super(p, n, nf);
		artiste=a;
	}
	
	public CD(float p, String n, String a) {
		this(p, n, nbFidelDef, a);
	}
	
	public CD() {}

	@Override
	public String toString() {
		return super.toString() + " (CD), Artiste: " + artiste;
	}

}
