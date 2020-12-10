package application.actionlist;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import action.Action;
import action.ActionList;
import banque.AgenceBancaire;

public class ActionListMenuOpé implements ActionList {
	
	String message;
	String code;
	String title;
	ArrayList<Action> liste_des_opérations;

	public ActionListMenuOpé(String message, String code, String title, ArrayList<Action> liste_des_opérations) {
		super();
		this.message = message;
		this.code = code;
		this.title = title;
		this.liste_des_opérations = liste_des_opérations;
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
		while(true) {
			this.printMenu();
			int choice = this.readResponse();
			if(choice==-1) {
				System.out.println("Fin du menu opérations sur comptes");
				break;
			}				
			try {
				this.liste_des_opérations.get(choice).execute(ag);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}		
	}
	
	@SuppressWarnings({ "resource" })
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
			System.out.println("	" + liste_des_opérations.get(i).actionCode() + " - "+ liste_des_opérations.get(i).actionMessage());
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
		return liste_des_opérations.size();
	}

	@Override
	public boolean addAction(Action ac) {
		int length = this.size();
		
		for (int i=0; i<length; i++) {
			if (liste_des_opérations.get(i).equals(ac)) {
				return false;
			}
		}
		liste_des_opérations.add(ac);
		return true;
	}

}
