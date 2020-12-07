package application.action;

import java.util.Scanner;

import action.Action;
import application.AccesAgenceBancaire;
import banque.AgenceBancaire;
import banque.Compte;

public class ActionVoirCompteNumero implements Action {

	String message;
	String code;
			
	public ActionVoirCompteNumero(String message, String code) {
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

	@SuppressWarnings("resource")
	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		Scanner lect;
		lect = new Scanner (System.in);
		AgenceBancaire monAg = AccesAgenceBancaire.getAgenceBancaire();
		
		System.out.print("Num compte -> ");
		String numero = lect.next();
		Compte c = monAg.getCompte(numero);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			c.afficher();
		}
	}

}
