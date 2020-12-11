
import java.util.Locale;
import java.util.Scanner;

import application.AccesAgenceBancaireGenerique;
import banque.AgenceBancaireGenerique;
import banque.CompteGenerique;
import banque.exception.CompteExceptionGenerique;

public class OLD_ApplicationAgenceBancaire {
	
	/**
	 * Affichage du menu de l'application
	 * @param ag	AgenceBancaire pour r�cup�rer le nom et la localisation
	 */
	public static void afficherMenu(AgenceBancaireGenerique ag) {
		System.out.println("Menu de " + ag.getNomAgence() + " (" + ag.getLocAgence() + ")");
		System.out.println("l - Liste des comptes de l'agence");
		System.out.println("v - Voir un compte (par son numéro)");
		System.out.println("p - Voir les comptes d'un Propriétaire (par son nom)");
		System.out.println("d - Déposer de l'argent sur un compte");
		System.out.println("r - Retirer de l'argent sur un compte");
		System.out.println("q - Quitter");
		System.out.print("Choix -> ");
	}
	
	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caract�re.
	 */
	@SuppressWarnings("resource")
	public static void tempo () {
		Scanner lect ;
		
		lect = new Scanner (System.in );
		
		System.out.print("Tapper un car + return pour continuer ... ");
		lect.next(); // Inutile � stocker mais ... 
	}

	@SuppressWarnings("resource")
	public static void main(String argv[]) {
		
		String choix;

		boolean continuer ;
		Scanner lect;
		AgenceBancaireGenerique monAg ;
		
		String nom, numero;		
		CompteGenerique c;
		double montant;
		
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		
		monAg = AccesAgenceBancaireGenerique.getAgenceBancaire();
		
		continuer = true;
		while (continuer) {
			OLD_ApplicationAgenceBancaireGenerique.afficherMenu(monAg);
			choix = lect.next();
			choix = choix.toLowerCase();
			switch (choix) {
				case "q" :
					System.out.println("ByeBye");
					OLD_ApplicationAgenceBancaireGenerique.tempo();
					continuer = false;
					break;
				case "l" :
					monAg.afficher();
					OLD_ApplicationAgenceBancaireGenerique.tempo();
					break;	
				case "v" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					c = monAg.getCompte(numero);
					if (c==null) {
						System.out.println("Compte inexistant ...");
					} else {
						c.afficher();
					}
					OLD_ApplicationAgenceBancaireGenerique.tempo();
					break;
				case "p" :
					System.out.print("Propriétaire -> ");
					nom = lect.next();
					OLD_ApplicationAgenceBancaireGenerique.comptesDUnPropretaire (monAg, nom);
					OLD_ApplicationAgenceBancaireGenerique.tempo();
					break;		
				case "d" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					System.out.print("Montant à déposer -> ");
					montant = lect.nextDouble();
					OLD_ApplicationAgenceBancaireGenerique.deposerSurUnCompte(monAg, numero, montant);
					OLD_ApplicationAgenceBancaireGenerique.tempo();
					break;
				case "r" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					System.out.print("Montant à retirer -> ");
					montant = lect.nextDouble();
					OLD_ApplicationAgenceBancaireGenerique.retirerSurUnCompte(monAg, numero, montant);
					OLD_ApplicationAgenceBancaireGenerique.tempo();
					break;
				default :
					System.out.println("Erreur de saisie ...");
					OLD_ApplicationAgenceBancaireGenerique.tempo();
					break;
			}
		}
		
	}
	
	public static void comptesDUnPropretaire (AgenceBancaireGenerique ag, String nomProprietaire) {
		CompteGenerique []  t; 
		
		t = ag.getComptesDe(nomProprietaire);
		if (t.length == 0) {
			System.out.println("pas de compte � ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour " + nomProprietaire);
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
	}

	public static void deposerSurUnCompte (AgenceBancaireGenerique ag, String numeroCompte, double montant) {
		CompteGenerique c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant d�p�t: "+c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant d�pos�, solde : "+c.soldeCompte());
			} catch (CompteExceptionGenerique e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void retirerSurUnCompte (AgenceBancaireGenerique ag, String numeroCompte, double montant) {
		CompteGenerique c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant retrait : " + c.soldeCompte());
			try {
				c.retirer(montant);
				System.out.println("Montant retir�, solde : "+c.soldeCompte());
			} catch (CompteExceptionGenerique e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}

	}
}
