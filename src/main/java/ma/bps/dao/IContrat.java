package ma.bps.dao;

import java.util.Date;
import java.util.List;

import defaults.typeContrat;
import ma.bps.entities.Contrats;

public interface IContrat {
	public Contrats ajouterContrat(Contrats contrat);
	public Contrats getContratById(Long idContrat);
	public List<Contrats> getAllContrats();
	public List<Contrats> getContratByIdSalarie(Long idSalarie);
	public Contrats modifierContrat(Contrats Contrat);
	public void supprimerContrat(Long idContrat);
	public Date dateDebutContrat(Long idSalarie);
}
