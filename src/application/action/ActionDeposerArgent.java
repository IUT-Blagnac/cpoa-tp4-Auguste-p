package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.CompteException;

public class ActionDeposerArgent implements Action{
	
	private String message;
	private String code;
	
	public ActionDeposerArgent(String message, String code) {
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
		Scanner lect = new Scanner (System.in );
		String numero = lect.next();
		System.out.print("Montant à déposer -> ");
		double montant = lect.nextDouble();
		
		Compte c = ag.getCompte(numero);
		
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant dépot: "+c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant déposé, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
		
	}

}
