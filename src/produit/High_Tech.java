package produit;

public class High_Tech extends Produit {
	static final int nbFidelDef=15;
	String specTechniques;
	
	public High_Tech(int id, float p, String n, int nf, String sp) {
		super(id, p, n, nf);
		specTechniques = sp;
	}
	
	public High_Tech(int id, float p, String n, String sp) {
		this(id, p, n, nbFidelDef, sp);
	}
	
	public String toString() {
		return super.toString() + " (High Tech), spécification : " + specTechniques;
	}
}
