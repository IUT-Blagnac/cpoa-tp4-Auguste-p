package application.action;

import java.util.Scanner;

import action.ActionGenerique;
import banque.AgenceBancaireGenerique;

public class ActionSupprimerCompteGenerique implements ActionGenerique {
	
	String message;
	String code;
			
	public ActionSupprimerCompteGenerique(String message, String code) {
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

		System.out.print("Num compte -> ");
		
		@SuppressWarnings("resource")
		Scanner lect = new Scanner (System.in);
		String t = lect.next();
		
		((AgenceBancaireGenerique) e).removeCompte(t);
		System.out.print("Le compte "+t+" a été supprimé.\n");
	}
}
