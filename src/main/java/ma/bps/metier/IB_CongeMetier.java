package ma.bps.metier;

import java.util.List;

import ma.bps.entities.B_Conges;

public interface IB_CongeMetier {
	public B_Conges ajouterB_Conge(B_Conges c);
	public B_Conges getB_CongeById(Long idB_Conge);
	public List<B_Conges> getAllB_Conges();
	public B_Conges modifierB_Conge(B_Conges c);
	public void supprimerB_Conge(Long idB_Conge);
	public List<B_Conges> getBaremesCongesByIdSociete(Long idSociete);
}
