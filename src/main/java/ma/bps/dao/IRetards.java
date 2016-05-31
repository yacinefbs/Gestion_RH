package ma.bps.dao;

import java.util.List;

import ma.bps.entities.Groupes;
import ma.bps.entities.Retards;

public interface IRetards {
	
	public void ajouterRetard(Retards r);
	public Retards getRetardById(Long idRetard);
	public List<Retards> getAllRetards();
	public Retards modifierRetard(Retards r);
	public void supprimerRetards(Long idRetard);

}
