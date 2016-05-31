package ma.bps.metier;

import java.util.List;

import ma.bps.dao.ISociete;
import ma.bps.dao.SocieteDaoImpl;
import ma.bps.entities.Societes;

public class SocieteMetierImpl implements ISocieteMetier {

	private ISociete dao = new SocieteDaoImpl();
	
	public Societes ajouterSociete(Societes s) {
		// TODO Auto-generated method stub
		return dao.ajouterSociete(s);
	}

	public Societes getSocieteById(Long idSociete) {
		// TODO Auto-generated method stub
		return dao.getSocieteById(idSociete);
	}

	public List<Societes> getAllSocietes() {
		// TODO Auto-generated method stub
		return dao.getAllSocietes();
	}

	public Societes modifierSociete(Societes s) {
		// TODO Auto-generated method stub
		return dao.modifierSociete(s);
	}

	public void supprimerSociete(Long idSociete) {
		// TODO Auto-generated method stub
		dao.supprimerSociete(idSociete);
	}
	
}
