package application.actionlist;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import action.ActionGenerique;
import action.ActionListGenerique;
import banque.AgenceBancaireGenerique;

public class ActionListMenuGestGenerique implements ActionListGenerique {
	
	String message;
	String code;
	String title;
	ArrayList<ActionGenerique> liste_des_gestions;

	public ActionListMenuGestGenerique(String message, String code, String title, ArrayList<ActionGenerique> liste_des_gestions) {
		super();
		this.message = message;
		this.code = code;
		this.title = title;
		this.liste_des_gestions = liste_des_gestions;
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
			System.out.println("	" + liste_des_gestions.get(i).actionCode() + " - "+ liste_des_gestions.get(i).actionMessage());
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
		return liste_des_gestions.size();
	}
	
	@Override
	public void execute(Object e) throws Exception {
		while(true) {
			this.printMenu();
			int choice = this.readResponse();
			if(choice==-1) {
				System.out.println("Fin du menu gestion des comptes");
				break;
			}
			this.liste_des_gestions.get(choice).execute(e);			
		}
	}

	@Override
	public boolean addAction(ActionGenerique ac) {
		int length = this.size();
		
		for (int i=0; i<length; i++) {
			if (liste_des_gestions.get(i).equals(ac)) {
				return false;
			}
		}
		liste_des_gestions.add(ac);
		return true;
	}

}
