package application.action;

import action.Action;
import application.AccesAgenceBancaire;
import banque.AgenceBancaire;

public class ActionListeDesComptes implements Action {
	
	String message;
	String code;
			
	public ActionListeDesComptes(String message, String code) {
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
	public void execute(AgenceBancaire ag) throws Exception {
		AgenceBancaire monAg = AccesAgenceBancaire.getAgenceBancaire();
		monAg.afficher();
	}

}
