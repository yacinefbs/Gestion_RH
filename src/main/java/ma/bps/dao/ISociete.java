package ma.bps.dao;

import java.util.List;
import ma.bps.entities.Societes;

public interface ISociete {
	public Societes ajouterSociete(Societes s);
	public Societes getSocieteById(Long idSociete);
	public List<Societes> getAllSocietes();
	public Societes modifierSociete(Societes s);
	public void supprimerSociete(Long idSociete);
}
