package promo;


public abstract class Promotion {
	protected static int nbPromo=0;
	
	protected int id;
	protected String nom;
	protected float reduction;
	
	protected Promotion(String name, float red) {
		this.nom = name;
		this.id  = nbPromo++;
		this.reduction = red;
		
	}
	
	public boolean equals(Object o) {
		if(o==null)
			return false;
		if(o==this)
			return true;
		try {
			Promotion p = (Promotion)o;
			return this.id==p.id;
		}
		catch (ClassCastException e) {
			return false;
		} 
	}
	
	public abstract float calculerReduc();
	
	public String toString(){
		StringBuilder msg = new StringBuilder();
		msg.append("Promotion N° ");
		msg.append(id);
		msg.append(", nom : ");
		msg.append(nom);
		msg.append(", reduction : ");
		msg.append(reduction);
		msg.append("\n");
		
		return msg.toString();
		
	}
}
