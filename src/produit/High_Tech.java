package produit;

public class High_Tech extends Produit {
	String specTechniques;
	
	
	public High_Tech(int id, String n, String sp) {
		super(id, n);
		specTechniques = sp;
	}
	
	public String toString() {
		return super.toString() + specTechniques;
	}
}
