package ma.bps.metier;

import java.util.List;

import ma.bps.dao.IPrimeAvantage;
import ma.bps.dao.PrimeAvantageDaoImpl;
import ma.bps.entities.PrimesAvantages;

public class PrimeAvantageMetierImpl implements IPrimeAvantageMetier {

	private IPrimeAvantage dao = new PrimeAvantageDaoImpl();
	
	
	public PrimesAvantages ajouterPrimesAvantage(PrimesAvantages p) {
		// TODO Auto-generated method stub
		return dao.ajouterPrimesAvantage(p);
	}

	public PrimesAvantages getPrimesAvantageById(Long idPrimesAvantage) {
		// TODO Auto-generated method stub
		return dao.getPrimesAvantageById(idPrimesAvantage);
	}

	public List<PrimesAvantages> getAllPrimesAvantages() {
		// TODO Auto-generated method stub
		return dao.getAllPrimesAvantages();
	}

	public PrimesAvantages modifierPrimesAvantage(PrimesAvantages p) {
		// TODO Auto-generated method stub
		return dao.modifierPrimesAvantage(p);
	}

	public void supprimerPrimesAvantages(Long idPrimesAvantage) {
		// TODO Auto-generated method stub
		dao.supprimerPrimesAvantages(idPrimesAvantage);
	}
	public PrimesAvantages getPrimeAvantageByIdSalarie(Long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getPrimeAvantageByIdSalarie(idSalarie);
	}
}
