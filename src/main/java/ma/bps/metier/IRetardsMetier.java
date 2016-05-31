package ma.bps.metier;

import java.util.List;

import ma.bps.entities.Retards;

public interface IRetardsMetier {
	
	public void ajouterRetard(Retards r);
	public Retards getRetardById(Long idRetard);
	public List<Retards> getAllRetards();
	public Retards modifierRetard(Retards r);
	public void supprimerRetards(Long idRetard);

}
