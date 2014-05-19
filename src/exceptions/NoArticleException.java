package exceptions;

/**
 * Exception soulevé par la gestion des produits
 * @author BADIE & BLOIS
 *
 */
public class NoArticleException extends Exception {
	private static final long serialVersionUID = 8784909136732235883L;

	/**
	 * Constructeur
	 * @param message
	 */
	public NoArticleException(String message) {
		super(message);
	}
}
