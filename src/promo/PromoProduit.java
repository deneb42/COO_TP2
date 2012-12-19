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
}
