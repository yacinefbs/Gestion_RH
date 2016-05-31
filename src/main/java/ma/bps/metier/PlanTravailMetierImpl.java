package ma.bps.metier;

import java.util.List;

import ma.bps.dao.IPlanTravail;
import ma.bps.dao.PlanTravailDaoImpl;
import ma.bps.entities.PlanTravail;

public class PlanTravailMetierImpl implements IPlanTravailMetier {

	private IPlanTravail dao = new PlanTravailDaoImpl();
	
	public void ajouterPlanTravail(PlanTravail p) {
		// TODO Auto-generated method stub
		dao.ajouterPlanTravail(p);
	}

	public PlanTravail getPlanTravailById(Long idPlan) {
		// TODO Auto-generated method stub
		return dao.getPlanTravailById(idPlan);
	}

	public List<PlanTravail> getAllPlanTravail() {
		// TODO Auto-generated method stub
		return dao.getAllPlanTravail();
	}

	public PlanTravail modifierPlanTravail(PlanTravail p) {
		// TODO Auto-generated method stub
		return dao.modifierPlanTravail(p);
	}

	public void supprimerPlanTravail(Long idPlan) {
		// TODO Auto-generated method stub
		dao.supprimerPlanTravail(idPlan);

	}

	public List<PlanTravail> chercherPlanTravailAvecDesignationEtCodeDeffirent(Long idPlan, String designation) {
		// TODO Auto-generated method stub
		return dao.chercherPlanTravailAvecDesignationEtCodeDeffirent(idPlan, designation);
	}

	public List<PlanTravail> chercherPlanTravailAvecDesignation(String designation) {
		// TODO Auto-generated method stub
		return dao.chercherPlanTravailAvecDesignation(designation);
	}

}
