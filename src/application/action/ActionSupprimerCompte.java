package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;

public class ActionSupprimerCompte implements Action {
	
	String message;
	String code;
			
	public ActionSupprimerCompte(String message, String code) {
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

		System.out.print("Num compte -> ");
		
		@SuppressWarnings("resource")
		Scanner lect = new Scanner (System.in);
		String t = lect.next();
		
		ag.removeCompte(t);
		System.out.print("Le compte "+t+" a été supprimé.\n");
	}
}
