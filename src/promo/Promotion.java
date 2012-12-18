package promo;

public abstract class Promotion {
	protected int id;
	protected String nom;
	protected float reduction;
	
	protected Promotion(String name, int id, float red) {
		this.nom = name;
		this.id  = id;
		this.reduction = red;
		
	}
	
	public abstract int calculerReduc();
}
