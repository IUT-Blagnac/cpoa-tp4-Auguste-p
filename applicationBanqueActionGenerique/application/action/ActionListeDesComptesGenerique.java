package application.action;

import action.ActionGenerique;
import banque.AgenceBancaire;
import banque.AgenceBancaireGenerique;

public class ActionListeDesComptesGenerique implements ActionGenerique {
	
	String message;
	String code;
			
	public ActionListeDesComptesGenerique(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}

	@Override
	public String actionMessage() {
		return message;
	}

	@Override
	public String actionCode() {
		return code;
	}

	@Override
	public void execute(Object e) throws Exception {
		((AgenceBancaireGenerique) e).afficher();
	}

}
