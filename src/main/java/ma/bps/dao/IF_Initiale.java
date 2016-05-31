package ma.bps.dao;

import java.util.List;

import ma.bps.entities.F_Initiale;

public interface IF_Initiale {
	public F_Initiale ajouterF_Initiale(F_Initiale F_Initiale);
	public F_Initiale getF_InitialeById(Long idF_Initiale);
	public List<F_Initiale> getAllF_Initiales();
	public List<F_Initiale> getF_InitialeByIdSalarie(long idSalarie);
	public F_Initiale modifierF_Initiale(F_Initiale f_Initiale);
	public void supprimerF_Initiale(Long idF_Initiale);
}
