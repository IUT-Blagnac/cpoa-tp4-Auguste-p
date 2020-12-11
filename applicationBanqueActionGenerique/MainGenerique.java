import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import action.ActionGenerique;
import application.AccesAgenceBancaireGenerique;
import application.action.ActionListeDesComptesGenerique;
import application.action.ActionVoirCompteNumeroGenerique;
import application.actionlist.ActionListAgenceBancaireGenerique;
import banque.AgenceBancaireGenerique;

public class MainGenerique {
	public static void main(String[] args) {
		AgenceBancaireGenerique ag = AccesAgenceBancaireGenerique.getAgenceBancaire();
		
		ActionGenerique liste = new ActionListeDesComptesGenerique("Liste des comptes de l'agence", "1");
		ActionGenerique compteNum = new ActionVoirCompteNumeroGenerique("Voir un compte (par son numéro)", "2");
		
		ArrayList<ActionGenerique> liste_des_actions = new ArrayList<ActionGenerique>();
		liste_des_actions.add(liste);
		liste_des_actions.add(compteNum);
		
		ActionListAgenceBancaireGenerique acliste = new ActionListAgenceBancaireGenerique("Création liste agence", "CLA", "Liste agence", liste_des_actions);
							
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
