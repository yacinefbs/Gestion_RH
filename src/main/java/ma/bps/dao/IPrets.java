package ma.bps.dao;

import java.util.List;

import ma.bps.entities.Prets;

public interface IPrets {
	public Prets ajouterPret(Prets p);
	public Prets getPretById(Long idPret);
	public List<Prets> getAllPrets();
	public List<Prets> getAllPretsBySalarie(Long idSalarie);
	public Prets modifierPrets(Prets p);
	public void supprimerPret(Long idPret);
}
