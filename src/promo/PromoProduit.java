package promo;

public class PromoProduit extends Promotion {

	protected float valeurReduc ;
	
	public PromoProduit(String name, int id, float reduc) {
		super(name, id, reduc);
		this.valeurReduc = reduc;
	}

	@Override
	public int calculerReduc() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*public int getValeurReduc() {
		return valeurReduc;
	}

	public void setValeurReduc(int valeurReduc) {
		this.valeurReduc = valeurReduc;
	}*/

	
	
}
