package promo;

public class PromoProduit extends Promotion {

	protected float reduc ;
	
	public PromoProduit(String name, float r) {
		super(name, r);
		this.reduc = r;
	}

	@Override
	public float calculerReduc() {
		return reduc;
	}
	
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append(super.toString());
//		msg.append("\nPromo Produit");
		msg.append("\n");
		return msg.toString();
	}
}
