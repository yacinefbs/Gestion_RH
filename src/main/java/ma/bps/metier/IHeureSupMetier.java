package ma.bps.metier;

import java.util.List;

import ma.bps.entities.HeureSupplementaire;

public interface IHeureSupMetier {
	
	public void ajouterHeureSup(HeureSupplementaire h);
	public HeureSupplementaire getHeureSupById(Long idHeureSup);
	public List<HeureSupplementaire> getAllHeureSup();
	public HeureSupplementaire modifierHeureSup(HeureSupplementaire h);
	public void supprimerHeureSup(Long idHeureSup);


}
