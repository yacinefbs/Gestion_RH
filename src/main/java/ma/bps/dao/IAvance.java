package ma.bps.dao;

import java.util.List;

import ma.bps.entities.Avances;

public interface IAvance {
	public Avances ajouterAvance(Avances a);
	public Avances getAvanceById(Long idAvance);
	public List<Avances> getAllAvances();
	public Avances modifierAvance(Avances a);
	public void supprimerAvance(Long idAvance);
	public List<Avances> getAllAvanceBySalarie(Long idSalarie);
}