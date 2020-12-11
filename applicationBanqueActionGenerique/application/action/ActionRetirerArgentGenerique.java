package application.action;

import java.util.Scanner;

import action.ActionGenerique;
import banque.AgenceBancaireGenerique;
import banque.CompteGenerique;
import banque.exception.CompteExceptionGenerique;

public class ActionRetirerArgentGenerique implements ActionGenerique {
	
	private String message;
	private String code;
	
	public ActionRetirerArgentGenerique(String message, String code) {
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
		Scanner lect = new Scanner (System.in );
		String numero = lect.next();
		System.out.print("Montant à retirer -> ");
		double montant = lect.nextDouble();
		
		CompteGenerique c = ((AgenceBancaireGenerique) e).getCompte(numero);
		
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant retrait : " + c.soldeCompte());
			try {
				c.retirer(montant);
				System.out.println("Montant retiré, solde : "+c.soldeCompte());
			} catch (CompteExceptionGenerique e1) {
				System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
				System.out.println(e1.getMessage());
			}
		}
		
	}

}
