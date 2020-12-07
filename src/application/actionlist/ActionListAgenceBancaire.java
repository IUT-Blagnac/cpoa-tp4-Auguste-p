package application.actionlist;

import java.util.ArrayList;
import java.util.Scanner;

import action.Action;
import action.ActionList;
import banque.AgenceBancaire;

public class ActionListAgenceBancaire implements ActionList {
	
	String message;
	String code;
	String title;
	ArrayList<Action> liste_des_actions;

	public ActionListAgenceBancaire(String message, String code, String title, ArrayList<Action> liste_des_actions) {
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

	@Override
	public void execute(AgenceBancaire ag) throws Exception {		
		for (int i=0; i<this.size(); i++) {
			System.out.println("	" + liste_des_actions.get(i).actionCode() + " - "+ liste_des_actions.get(i).actionMessage());
		}
		System.out.println("\n	0 - Pour quitter ce menu\r\n" + "Votre choix ?");
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
	public boolean addAction(Action ac) {
		int length = this.size();
		
		for (int i=0; i<length; i++) {
			if (liste_des_actions.get(i).equals(ac)) {
				return false;
			}
		}
		liste_des_actions.add(ac);
		return true;
	}

}
