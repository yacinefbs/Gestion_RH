package ma.bps.metier;

import java.util.List;

import ma.bps.dao.ITranchePlanTravail;
import ma.bps.dao.TranchePlanTravailDaoImpl;
import ma.bps.entities.TranchePlanTravail;

public class TranchePlanTravailMetierImpl implements ITranchePlanTravailMetier {
	
	ITranchePlanTravail dao = new TranchePlanTravailDaoImpl();
	

	public void ajouterTranchePlanTravail(TranchePlanTravail p) {
		// TODO Auto-generated method stub
		dao.ajouterTranchePlanTravail(p);
		
	}

	public TranchePlanTravail getTranchePlanTravailById(Long idTranche) {
		// TODO Auto-generated method stub
		return dao.getTranchePlanTravailById(idTranche);
	}

	public List<TranchePlanTravail> getAllTranchePlanTravail() {
		// TODO Auto-generated method stub
		return dao.getAllTranchePlanTravail();
	}

	public TranchePlanTravail modifierTranchePlanTravail(TranchePlanTravail p) {
		// TODO Auto-generated method stub
		return dao.modifierTranchePlanTravail(p);
	}

	public void supprimerTranchePlanTravail(Long idTranche) {
		// TODO Auto-generated method stub
		dao.supprimerTranchePlanTravail(idTranche);

	}

	public List<TranchePlanTravail> getTranchePlanTravailByJour(String jour,Long idPlan) {
		// TODO Auto-generated method stub
		return dao.getTranchePlanTravailByJour(jour,idPlan);
	}

	public List<TranchePlanTravail> getDistinctTranchePlanTravail() {
		// TODO Auto-generated method stub
		return dao.getDistinctTranchePlanTravail();
	}

}
