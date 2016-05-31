package ma.bps.metier;

import java.util.List;

import ma.bps.entities.Salaires;

public interface ISalaireMetier {
	public Salaires ajouterSalaire(Salaires s);
	public Salaires getSalaireById(Long idSalaire);
	public List<Salaires> getAllSalaires();
	public Salaires modifierSalaire(Salaires s);
	public void supprimerSalaire(Long idSalaire);
	public Salaires getSalaireByIdSalarie(Long idSalarie);
}
