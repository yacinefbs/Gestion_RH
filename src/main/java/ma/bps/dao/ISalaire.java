package ma.bps.dao;

import java.util.List;

import ma.bps.entities.Salaires;
import ma.bps.entities.Salaries;

public interface ISalaire {
	public Salaires ajouterSalaire(Salaires s);
	public Salaires getSalaireById(Long idSalaire);
	public List<Salaires> getAllSalaires();
	public Salaires modifierSalaire(Salaires s);
	public void supprimerSalaire(Long idSalaire);
	public Salaires getSalaireByIdSalarie(Long idSalarie);
}
