package banque.exception;

/************************************************************
 * Cette exception est lev�e par la Classe AgenceBancaire lorsque un compte n'existe pas dans l'agence.<BR>
 * 
 * @author Andr� P�ninou.
 * @version 3.0
 *****************************/

public class ABCompteInexistantExceptionGenerique  extends Exception  {

	/**
	 * Constructeur par d�faut.<BR>
	 */
	public ABCompteInexistantExceptionGenerique() {
		this("Erreur sur un objet de la classe AgenceBancaire");
	}

	/**
	 * Constructeur param�tr�.<BR>
	 * 
	 * @param message
	 *            information qui sera affich�e si l'exception est affich�e �
	 *            l'�cran
	 */
	public ABCompteInexistantExceptionGenerique(String message) {
		super(message);
	}

}
