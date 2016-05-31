package ma.bps.metier;

import java.util.List;

import ma.bps.entities.B_Conges;
import ma.bps.entities.B_IGR;

public interface IB_IgrMetier {
	public B_IGR ajouterB_IGR(B_IGR b_IGR);
	public B_IGR getB_IGRById(Long idB_IGR);
	public List<B_IGR> getAllB_IGRs();
	public B_IGR modifierB_IGR(B_IGR b_IGR);
	public void supprimerB_IGR(Long idB_Conge);
	public List<B_IGR> getBaremesIgrsByIdSociete(Long idSociete);
}
