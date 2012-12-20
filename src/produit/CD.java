package produit;

import promo.PromoProduit;
import promo.Promotion;

public class CD extends Produit {
	static final int nbFidelDef=2;
	protected static PromoProduit promoCat;
	
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
	
	public void setPromoCat(PromoProduit p) { promoCat = p; }
	public Promotion getPromoCat() { return promoCat; }
}
