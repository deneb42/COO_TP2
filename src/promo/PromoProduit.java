package promo;

public class PromoProduit extends Promotion {

	protected int valeurReduc ;
	
	public PromoProduit(String name, int id, int reduc) {
		super(name, id);
		this.valeurReduc = reduc;
	}

	public int getValeurReduc() {
		return valeurReduc;
	}

	public void setValeurReduc(int valeurReduc) {
		this.valeurReduc = valeurReduc;
	}

	
	
}
