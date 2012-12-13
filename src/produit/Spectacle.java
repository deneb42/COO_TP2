package produit;

import java.util.Date;

public class Spectacle extends Produit {
	private Date date;
	private String lieu;
	
	public Spectacle(int id, String n, Date d, String l) {
		super(id, n);
		date = d;
		lieu=l;
	}
	
	public String toString() {
		return super.toString() + " (Spectacle), date: " + date.toString() + ", lieu: " + lieu;
	}
}
