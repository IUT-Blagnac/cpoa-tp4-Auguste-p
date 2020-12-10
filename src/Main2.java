import java.util.ArrayList;

import action.Action;
import application.AccesAgenceBancaire;
import application.action.ActionAjouterCompte;
import application.action.ActionDeposerArgent;
import application.action.ActionListeDesComptes;
import application.action.ActionRetirerArgent;
import application.action.ActionSupprimerCompte;
import application.action.ActionVoirCompteNom;
import application.action.ActionVoirCompteNumero;
import application.actionlist.ActionListAgenceBancaire;
import application.actionlist.ActionListMenuGest;
import application.actionlist.ActionListMenuOpé;
import banque.AgenceBancaire;

public class Main2 {
	public static void main(String[] args) {
		AgenceBancaire ag = AccesAgenceBancaire.getAgenceBancaire();
		
		ArrayList<Action> liste_des_actions = new ArrayList<Action>();
		ArrayList<Action> liste_des_opérations = new ArrayList<Action>();
		ArrayList<Action> liste_des_gestions = new ArrayList<Action>();
		ActionListAgenceBancaire acliste = new ActionListAgenceBancaire("Création menu général", "MG", "Menu général", liste_des_actions);
		
		Action liste = new ActionListeDesComptes("Liste des comptes de l'agence", "1");
		Action compteNum = new ActionVoirCompteNumero("Voir un compte (par son numéro)", "2");	
		Action compteNom = new ActionVoirCompteNom("Voir les comptes d'un Propriétaire (par son nom)", "3");	
		ActionListMenuOpé opliste = new ActionListMenuOpé("Menu opérations sur comptes", "4", "Menu opérations sur comptes", liste_des_opérations);
		ActionListMenuGest gestliste = new ActionListMenuGest("Menu gestion des comptes", "5", "Menu gestion des comptes", liste_des_gestions);
		liste_des_actions.add(liste);
		liste_des_actions.add(compteNum);
		liste_des_actions.add(compteNom);
		liste_des_actions.add(opliste);
		liste_des_actions.add(gestliste);
		
		
		Action depot = new ActionDeposerArgent("Déposer de l'argent sur un compte", "1");
		Action retrait = new ActionRetirerArgent("Retirer de l'argent sur un compte", "2");
		liste_des_opérations.add(depot);
		liste_des_opérations.add(retrait);
		
		
		Action ajoutCpt = new ActionAjouterCompte("Ajouter un compte", "1");
		Action supprCpt = new ActionSupprimerCompte("Supprimer un compte", "2");
		liste_des_gestions.add(ajoutCpt);
		liste_des_gestions.add(supprCpt);
		
		
		try {
			acliste.execute(ag);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
}