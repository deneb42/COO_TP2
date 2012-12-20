package produit;

import java.util.Date;

/**
 * Produit de type spectacle
 * @author BADIE & BLOIS
 *
 */
public class Spectacle extends Produit {
	static final int nbFidelDef=10;
	private Date date;
	private String lieu;
	
	/**
	 * Constructeur ar défaut
	 */
	public Spectacle() {}
	
	/**
	 * Constructeur
	 * @param p
	 * @param n
	 * @param nf
	 * @param d
	 * @param l
	 */
	public Spectacle(float p, String n, int nf, Date d, String l) {
		super(p, n, nf);
		date = d;
		lieu=l;
	}
	
	/**
	 * Constructeur
	 * @param p
	 * @param n
	 * @param d
	 * @param l
	 */
	public Spectacle(float p, String n, Date d, String l) {
		this(p, n, nbFidelDef, d, l);
	}
	
	public String toString() {
		return super.toString() + " (Spectacle), date: " + date.toString() + ", lieu: " + lieu;
	}
}
