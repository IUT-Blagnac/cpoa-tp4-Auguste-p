import java.util.ArrayList;

import action.ActionGenerique;
import application.AccesAgenceBancaireGenerique;
import application.action.ActionAjouterCompteGenerique;
import application.action.ActionDeposerArgentGenerique;
import application.action.ActionListeDesComptesGenerique;
import application.action.ActionRetirerArgentGenerique;
import application.action.ActionSupprimerCompteGenerique;
import application.action.ActionVoirCompteNomGenerique;
import application.action.ActionVoirCompteNumeroGenerique;
import application.actionlist.ActionListAgenceBancaireGenerique;
import application.actionlist.ActionListMenuGestGenerique;
import application.actionlist.ActionListMenuOpéGenerique;
import banque.AgenceBancaireGenerique;

public class Main2Generique {
	public static void main(String[] args) {
		AgenceBancaireGenerique ag = AccesAgenceBancaireGenerique.getAgenceBancaire();
		
		ArrayList<ActionGenerique> liste_des_actions = new ArrayList<ActionGenerique>();
		ArrayList<ActionGenerique> liste_des_opérations = new ArrayList<ActionGenerique>();
		ArrayList<ActionGenerique> liste_des_gestions = new ArrayList<ActionGenerique>();
		ActionListAgenceBancaireGenerique acliste = new ActionListAgenceBancaireGenerique("Création menu général", "MG", "Menu général", liste_des_actions);
		
		ActionGenerique liste = new ActionListeDesComptesGenerique("Liste des comptes de l'agence", "1");
		ActionGenerique compteNum = new ActionVoirCompteNumeroGenerique("Voir un compte (par son numéro)", "2");	
		ActionGenerique compteNom = new ActionVoirCompteNomGenerique("Voir les comptes d'un Propriétaire (par son nom)", "3");	
		ActionListMenuOpéGenerique opliste = new ActionListMenuOpéGenerique("Menu opérations sur comptes", "4", "Menu opérations sur comptes", liste_des_opérations);
		ActionListMenuGestGenerique gestliste = new ActionListMenuGestGenerique("Menu gestion des comptes", "5", "Menu gestion des comptes", liste_des_gestions);
		liste_des_actions.add(liste);
		liste_des_actions.add(compteNum);
		liste_des_actions.add(compteNom);
		liste_des_actions.add(opliste);
		liste_des_actions.add(gestliste);
		
		
		ActionGenerique depot = new ActionDeposerArgentGenerique("Déposer de l'argent sur un compte", "1");
		ActionGenerique retrait = new ActionRetirerArgentGenerique("Retirer de l'argent sur un compte", "2");
		liste_des_opérations.add(depot);
		liste_des_opérations.add(retrait);
		
		
		ActionGenerique ajoutCpt = new ActionAjouterCompteGenerique("Ajouter un compte", "1");
		ActionGenerique supprCpt = new ActionSupprimerCompteGenerique("Supprimer un compte", "2");
		liste_des_gestions.add(ajoutCpt);
		liste_des_gestions.add(supprCpt);
		
		
		try {
			acliste.execute(ag);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
}