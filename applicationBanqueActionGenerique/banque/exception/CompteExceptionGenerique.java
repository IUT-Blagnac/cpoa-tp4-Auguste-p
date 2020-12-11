package banque.exception;

/************************************************************
 * Cette exception est lev�e par la Classe Compte lorsque un d�bit ou cr�dit
 * n'est pas possible. <BR>
 * 
 * @author Andr� P�ninou.
 * @version 3.0
 *****************************/

public class CompteExceptionGenerique extends Exception {

	/**
	 * Constructeur par d�faut.<BR>
	 */
	public CompteExceptionGenerique() {
		super("Erreur sur un objet de la classe Compte");
	}

	/**
	 * Constructeur param�tr�.<BR>
	 * 
	 * @param message
	 *            information qui sera affich�e si l'exception est affich�e �
	 *            l'�cran
	 */
	public CompteExceptionGenerique(String message) {
		super(message);
	}
}
