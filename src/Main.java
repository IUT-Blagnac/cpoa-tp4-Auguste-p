import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import action.Action;
import application.AccesAgenceBancaire;
import application.action.ActionListeDesComptes;
import application.action.ActionVoirCompteNumero;
import application.actionlist.ActionListAgenceBancaire;
import banque.AgenceBancaire;

public class Main {
	public static void main(String[] args) {
		AgenceBancaire ag = AccesAgenceBancaire.getAgenceBancaire();
		
		Action liste = new ActionListeDesComptes("Liste des comptes de l'agence", "1");
		Action compteNum = new ActionVoirCompteNumero("Voir un compte (par son numéro)", "2");
		
		ArrayList<Action> liste_des_actions = new ArrayList<Action>();
		liste_des_actions.add(liste);
		liste_des_actions.add(compteNum);
		
		ActionListAgenceBancaire acliste = new ActionListAgenceBancaire("Création menu général", "MG", "Menu général", liste_des_actions);
							
		@SuppressWarnings("resource")
		Scanner lect = new Scanner ( System.in );
		lect.useLocale(Locale.FRANCE);
		
			try {
				acliste.execute(ag);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
