package ma.bps.dao;

import java.util.List;

import ma.bps.entities.PlanTravail;

public interface IPlanTravail {


	public void ajouterPlanTravail(PlanTravail p);
	public PlanTravail getPlanTravailById(Long idPlan);
	public List<PlanTravail> getAllPlanTravail();
	public PlanTravail modifierPlanTravail(PlanTravail p);
	public void supprimerPlanTravail(Long idPlan);
	
	public List<PlanTravail> chercherPlanTravailAvecDesignation(String designation); // utiliser pour verifier si la designation existe au moment de l'ajout
	
	public List<PlanTravail> chercherPlanTravailAvecDesignationEtCodeDeffirent(Long idPlan, String designation); // utiliser pour verifier si la designation existe au moment de la modification
	
}
