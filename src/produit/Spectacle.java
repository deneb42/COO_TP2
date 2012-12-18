package produit;

import java.util.Date;

public class Spectacle extends Produit {
	static final int nbFidelDef=10;
	private Date date;
	private String lieu;
	
	public Spectacle(int id, float p, String n, int nf, Date d, String l) {
		super(id, p, n, nf);
		date = d;
		lieu=l;
	}
	
	public Spectacle(int id, float p, String n, Date d, String l) {
		this(id, p, n, nbFidelDef, d, l);
	}
	
	public String toString() {
		return super.toString() + " (Spectacle), date: " + date.toString() + ", lieu: " + lieu;
	}
}
