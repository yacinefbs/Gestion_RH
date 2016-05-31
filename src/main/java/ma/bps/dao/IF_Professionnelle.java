package ma.bps.dao;

import java.util.List;

import ma.bps.entities.F_Professionnelles;

public interface IF_Professionnelle {
	public F_Professionnelles ajouterF_Pro(F_Professionnelles F_Professionnelles);
	public F_Professionnelles getF_ProfessionnellesById(Long idF_Professionnelles);
	public List<F_Professionnelles> getAllF_Professionnelles();
	public List<F_Professionnelles> getF_ProfessionnellesByIdSalarie(long idSalarie);
	public F_Professionnelles modifierF_Professionnelles(F_Professionnelles F_Professionnelles);
	public void supprimerF_Professionnelles(Long idF_Professionnelles);
}
