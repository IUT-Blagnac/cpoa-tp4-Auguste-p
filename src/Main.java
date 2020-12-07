import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import action.Action;
import application.AccesAgenceBancaire;
import application.action.ActionListeDesComptes;
import application.action.ActionVoirCompteNumero;
import application.actionlist.ActionListAgenceBancaire;
import banque.AgenceBancaire;
import banque.Compte;

public class Main {
	public static void main(String[] args) {
		AgenceBancaire ag = AccesAgenceBancaire.getAgenceBancaire();
		
		Action liste = new ActionListeDesComptes("Liste des comptes de l'agence", "1");
		Action compteNum = new ActionVoirCompteNumero("Voir un compte (par son numéro)", "2");
		
		ArrayList<Action> liste_des_actions = new ArrayList<Action>();
		liste_des_actions.add(liste);
		liste_des_actions.add(compteNum);
		
		ActionListAgenceBancaire acliste = new ActionListAgenceBancaire("Afficher la liste des comptes", "LC", null, liste_des_actions);
		
		acliste.addAction(liste);
		acliste.addAction(compteNum);
					
		String choix = null;

		@SuppressWarnings("resource")
		Scanner lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		AgenceBancaire monAg ;
		
		monAg = AccesAgenceBancaire.getAgenceBancaire();
		
		boolean continuer = true;
		while (continuer) {
			System.out.println("--\r\n" + 
					"  Agence CAISSE ECUREUIL de PIBRAC\r\n" + 
					"  Menu Général\r\n" + 
					"--\r\n" + 
					"  Choisir :\r\n"); 
			try {
				acliste.execute(monAg);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			choix = lect.next();
			switch (choix) {
				case "0" :
					System.out.println("ByeBye");
					continuer = false;
					break;
				case "1" :
					try {
						liste.execute(ag);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;	
				case "2" :
					try {
						compteNum.execute(ag);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
//				case "p" :
//					System.out.print("Propri�taire -> ");
//					nom = lect.next();
//					ApplicationAgenceBancaire.comptesDUnPropretaire (monAg, nom);
//					ApplicationAgenceBancaire.tempo();
//					break;		
//				case "d" :
//					System.out.print("Num compte -> ");
//					numero = lect.next();
//					System.out.print("Montant � d�poser -> ");
//					montant = lect.nextDouble();
//					ApplicationAgenceBancaire.deposerSurUnCompte(monAg, numero, montant);
//					ApplicationAgenceBancaire.tempo();
//					break;
//				case "r" :
//					System.out.print("Num compte -> ");
//					numero = lect.next();
//					System.out.print("Montant � retirer -> ");
//					montant = lect.nextDouble();
//					ApplicationAgenceBancaire.retirerSurUnCompte(monAg, numero, montant);
//					ApplicationAgenceBancaire.tempo();
//					break;
				default :
					System.out.println("Erreur de saisie ...");
					ApplicationAgenceBancaire.tempo();
					break;
			}
		}		
	}
}
