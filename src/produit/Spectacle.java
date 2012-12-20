package produit;

import java.util.Date;

import promo.PromoProduit;
import promo.Promotion;

public class Spectacle extends Produit {
	static final int nbFidelDef=10;
	protected static PromoProduit promoCat;
	private Date date;
	private String lieu;
	
	public Spectacle() {}
	
	public Spectacle(float p, String n, int nf, Date d, String l) {
		super(p, n, nf);
		date = d;
		lieu=l;
	}
	
	public Spectacle(float p, String n, Date d, String l) {
		this(p, n, nbFidelDef, d, l);
	}
	
	public String toString() {
		return super.toString() + " (Spectacle), date: " + date.toString() + ", lieu: " + lieu;
	}
	
	public void setPromoCat(PromoProduit p) { promoCat = p; }
	public Promotion getPromoCat() { return promoCat; }
}
