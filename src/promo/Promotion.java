package promo;

public class Promotion {
	private int id;
	private String nom;
	
	protected Promotion(String name, int id) {
		this.nom = name;
		this.id  = id;
	}
}
