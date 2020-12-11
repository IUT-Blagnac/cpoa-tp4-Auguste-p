package application.action;

import java.util.Scanner;

import action.ActionGenerique;
import banque.AgenceBancaireGenerique;
import banque.CompteGenerique;

public class ActionVoirCompteNumeroGenerique implements ActionGenerique {

	String message;
	String code;
			
	public ActionVoirCompteNumeroGenerique(String message, String code) {
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
		Scanner lect;
		lect = new Scanner (System.in);
		
		System.out.print("Num compte -> ");
		String numero = lect.next();
		CompteGenerique c = ((AgenceBancaireGenerique) e).getCompte(numero);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			c.afficher();
		}
	}

}
