package promo;

public class Promotion {
	private int id;
	private String nom;
	private float reduction;
	
	protected Promotion(String name, int id, float red) {
		this.nom = name;
		this.id  = id;
		this.reduction = red;
		
	}
	
	public int calculerReduc(){
		//ToDo
		
		return 0;
	}
}
