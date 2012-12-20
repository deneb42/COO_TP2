package promo;

/**
 * Promotion appliqué à un produit
 * @author BADIE & BLOIS
 *
 */
public class PromoProduit extends Promotion {

	protected float reduc ;
	
	/**
	 * Constructeur
	 * @param name
	 * @param r
	 */
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
		msg.append("\n");
		return msg.toString();
	}
}
