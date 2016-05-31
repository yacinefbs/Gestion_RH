package ma.bps.metier;

import java.util.List;

import ma.bps.dao.HeureSupDaoImpl;
import ma.bps.dao.IHeureSup;
import ma.bps.entities.HeureSupplementaire;

public class HeureSupMetierImpl implements IHeureSupMetier {
	
	IHeureSup dao = new HeureSupDaoImpl();

	public void ajouterHeureSup(HeureSupplementaire h) {

		dao.ajouterHeureSup(h);
	}

	public HeureSupplementaire getHeureSupById(Long idHeureSup) {
		// TODO Auto-generated method stub
		return dao.getHeureSupById(idHeureSup);
	}

	public List<HeureSupplementaire> getAllHeureSup() {
		// TODO Auto-generated method stub
		return dao.getAllHeureSup();
	}

	public HeureSupplementaire modifierHeureSup(HeureSupplementaire h) {
		// TODO Auto-generated method stub
		return dao.modifierHeureSup(h);
	}

	public void supprimerHeureSup(Long idHeureSup) {
		// TODO Auto-generated method stub
		dao.supprimerHeureSup(idHeureSup);
	}

}
