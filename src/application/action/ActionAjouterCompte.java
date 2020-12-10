package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;
import banque.Compte;

public class ActionAjouterCompte implements Action {
	
	String message;
	String code;
			
	public ActionAjouterCompte(String message, String code) {
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
		String num = lect.next();
		
		System.out.print("Nom propriétaire -> ");
		
		lect = new Scanner (System.in);
		String nom = lect.next();
		
		Compte t = new Compte(num, nom);
		
		ag.addCompte(t);
		System.out.print("Le compte "+t.getNumCompte()+" a été ajouté à l'agence "+ag.getNomAgence()+" "+ag.getLocAgence() +".\n");
	}
}
