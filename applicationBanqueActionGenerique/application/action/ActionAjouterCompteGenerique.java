package application.action;

import java.util.Scanner;

import action.ActionGenerique;
import banque.AgenceBancaireGenerique;
import banque.CompteGenerique;

public class ActionAjouterCompteGenerique implements ActionGenerique {
	
	String message;
	String code;
			
	public ActionAjouterCompteGenerique(String message, String code) {
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
		String num = lect.next();
		
		System.out.print("Nom propriétaire -> ");
		
		lect = new Scanner (System.in);
		String nom = lect.next();
		
		CompteGenerique t = new CompteGenerique(num, nom);
		
		((AgenceBancaireGenerique) e).addCompte(t);
		System.out.print("Le compte "+t.getNumCompte()+" a été ajouté à l'agence "+((AgenceBancaireGenerique) e).getNomAgence()+" "+((AgenceBancaireGenerique) e).getLocAgence()+".\n");
	}
}
