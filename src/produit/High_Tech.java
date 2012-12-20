package produit;

/**
 *Classe representant la categorie de produits High Tech 
 * @author BADIE & BLOIS
 *
 */
public class High_Tech extends Produit {
	static final int nbFidelDef=15;
	String specTechniques;
	
	/**
	 * Constructeur
	 * @param p
	 * @param n
	 * @param nf
	 * @param sp
	 */
	public High_Tech(float p, String n, int nf, String sp) {
		super(p, n, nf);
		specTechniques = sp;
	}
	
	/**
	 * Constructeu
	 * @param p
	 * @param n
	 * @param sp
	 */
	public High_Tech(float p, String n, String sp) {
		this(p, n, nbFidelDef, sp);
	}
	
	/**
	 * Constructeur par défaut
	 */
	public High_Tech() {}

	public String toString() {
		return super.toString() + " (High Tech), spécification : " + specTechniques;
	}
}
