package produit;

import promo.PromoProduit;
import promo.Promotion;

public class High_Tech extends Produit {
	static final int nbFidelDef=15;
	protected static PromoProduit promoCat;
	String specTechniques;
	
	public High_Tech(float p, String n, int nf, String sp) {
		super(p, n, nf);
		specTechniques = sp;
	}
	
	public High_Tech(float p, String n, String sp) {
		this(p, n, nbFidelDef, sp);
	}
	
	public High_Tech() {}

	public String toString() {
		return super.toString() + " (High Tech), spécification : " + specTechniques;
	}
	
	public void setPromoCat(PromoProduit p) { promoCat = p; }
	public Promotion getPromoCat() { return promoCat; }
}
