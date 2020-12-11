package application.actionlist;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import action.ActionGenerique;
import action.ActionListGenerique;
import banque.AgenceBancaireGenerique;

public class ActionListAgenceBancaireGenerique implements ActionListGenerique {
	
	String message;
	String code;
	String title;
	ArrayList<ActionGenerique> liste_des_actions;

	public ActionListAgenceBancaireGenerique(String message, String code, String title, ArrayList<ActionGenerique> liste_des_actions) {
		super();
		this.message = message;
		this.code = code;
		this.title = title;
		this.liste_des_actions = liste_des_actions;
	}

	@Override
	public String actionMessage() {		
		return message;
	}

	@Override
	public String actionCode() {
		return code;
	}
	
	@SuppressWarnings({ "resource", "unused" })
	private int readResponse() {
		Scanner lect = new Scanner ( System.in );
		lect.useLocale(Locale.FRANCE);
		int choix = lect.nextInt();
		return choix-1;
	}

	public void printMenu() {
		System.out.println("--\r\n" + 
				"  Agence CAISSE ECUREUIL de PIBRAC\r\n" + 
				"  " + this.title + "\n" +
				"--\r\n" + 
				"  Choisir :"); 
		for (int i=0; i<this.size(); i++) {
			System.out.println("	" + liste_des_actions.get(i).actionCode() + " - "+ liste_des_actions.get(i).actionMessage());
		}
		System.out.println("\n	0 - Pour quitter ce menu");
		System.out.println("Votre choix ?");
	}

	@Override
	public String listTitle() {
		return title;
	}

	@Override
	public int size() {
		return liste_des_actions.size();
	}

	@Override
	public boolean addAction(ActionGenerique ac) {
		int length = this.size();
		
		for (int i=0; i<length; i++) {
			if (liste_des_actions.get(i).equals(ac)) {
				return false;
			}
		}
		liste_des_actions.add(ac);
		return true;
	}

	@Override
	public void execute(Object e) throws Exception {
		while(true) {
			this.printMenu();
			int choice = this.readResponse();
			if(choice==-1) {
				System.out.println("ByeBye");
				break;
			}
			this.liste_des_actions.get(choice).execute(e);			
		}
	}

}
