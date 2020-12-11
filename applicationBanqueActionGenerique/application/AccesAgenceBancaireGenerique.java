package application;


import banque.AgenceBancaireGenerique;
import banque.CompteGenerique;
import banque.exception.ABCompteDejaExistantExceptionGenerique;
import banque.exception.ABCompteNullExceptionGenerique;

public class AccesAgenceBancaireGenerique {
	
	private AccesAgenceBancaireGenerique () {}
	
	public static AgenceBancaireGenerique getAgenceBancaire () {
		
		// To be done : load it from file
		// Not yet implemented, just a stub
		
		AgenceBancaireGenerique ag = new AgenceBancaireGenerique("CAISSE ECUREUIL", "PIBRAC");
		
		try {
			ag.addCompte(new CompteGenerique("010101", "Durand"));
			ag.addCompte(new CompteGenerique("010102", "Durand"));
			
			ag.addCompte(new CompteGenerique("050501", "Leon"));
			ag.addCompte(new CompteGenerique("050502", "Leon"));
			ag.addCompte(new CompteGenerique("050503", "Leon"));
			
			ag.addCompte(new CompteGenerique("090904", "Zeste"));
			ag.addCompte(new CompteGenerique("090905", "Zeste"));
			
		} catch (ABCompteNullExceptionGenerique | ABCompteDejaExistantExceptionGenerique e) {
			throw new RuntimeException();
		}
		return ag;
	}

	public static void saveAgenceBancaire (AgenceBancaireGenerique a) {
		
		// To be done : load it from file
		// Not yet implemented
		
		throw new UnsupportedOperationException();
	}
}
