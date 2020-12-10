package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;
import banque.Compte;

public class ActionVoirCompteNom implements Action {

	String message;
	String code;
			
	public ActionVoirCompteNom(String message, String code) {
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
		System.out.print("Propriétaire -> ");
		
		Scanner lect;
		lect = new Scanner (System.in);
		String nom = lect.next();
		Compte []  t; 
		
		t = ag.getComptesDe(nom);
		if (t.length == 0) {
			System.out.println("Pas de compte à ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour " + nom);
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
	}
}
