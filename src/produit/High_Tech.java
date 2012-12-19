package produit;

public class High_Tech extends Produit {
	static final int nbFidelDef=15;
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
}
