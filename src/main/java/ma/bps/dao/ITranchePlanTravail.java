package ma.bps.dao;

import java.util.List;

import ma.bps.entities.TranchePlanTravail;

public interface ITranchePlanTravail {
	
	public void ajouterTranchePlanTravail(TranchePlanTravail p);
	public TranchePlanTravail getTranchePlanTravailById(Long idTranche);
	public List<TranchePlanTravail> getAllTranchePlanTravail();
	public TranchePlanTravail modifierTranchePlanTravail(TranchePlanTravail p);
	public void supprimerTranchePlanTravail(Long idTranche);
	public List<TranchePlanTravail> getTranchePlanTravailByJour(String jour, Long idPlan);
	
	public List<TranchePlanTravail> getDistinctTranchePlanTravail(); // charge les tranches li makhtalfin f heure debut w heur fin

}
