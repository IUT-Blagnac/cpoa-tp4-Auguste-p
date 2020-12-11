package application.action;

import java.util.Scanner;

import action.ActionGenerique;
import banque.AgenceBancaireGenerique;
import banque.CompteGenerique;

public class ActionVoirCompteNomGenerique implements ActionGenerique {

	String message;
	String code;
			
	public ActionVoirCompteNomGenerique(String message, String code) {
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
	public void execute(Object e) throws Exception {
		System.out.print("Propriétaire -> ");
		
		Scanner lect;
		lect = new Scanner (System.in);
		String nom = lect.next();
		CompteGenerique []  t; 
		
		t = ((AgenceBancaireGenerique) e).getComptesDe(nom);
		if (t.length == 0) {
			System.out.println("Pas de compte à ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour " + nom);
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
	}
}
