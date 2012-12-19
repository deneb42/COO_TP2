package promo;

public class PromoProduit extends Promotion {

	protected float reduc ;
	
	public PromoProduit(String name, int id, float r) {
		super(name, id, r);
		this.reduc = r;
	}

	@Override
	public float calculerReduc() {
		return reduc;
	}
}
