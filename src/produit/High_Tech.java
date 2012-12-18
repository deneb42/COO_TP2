package produit;

public class High_Tech extends Produit {
	String specTechniques;
	
	
	public High_Tech(int id, float p, String n, String sp) {
		super(id, p, n);
		specTechniques = sp;
	}
	
	public String toString() {
		return super.toString() + " (High Tech), spécification : " + specTechniques;
	}
}
