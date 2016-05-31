package ma.bps.dao;

import java.util.List;

import ma.bps.entities.B_Anciennetes;
import ma.bps.entities.B_Conges;

public interface IB_Anciennete {
	public B_Anciennetes ajouterB_Anciennetes(B_Anciennetes b_anciennete);
	public B_Anciennetes getB_AnciennetesById(Long idBAnciennete);
	public List<B_Anciennetes> getAllB_Anciennetes();
	public B_Anciennetes modifierB_Anciennete(B_Anciennetes BAnciennete);
	public void supprimerB_Anciennetes(Long idBAnciennete);
	public List<B_Anciennetes> getBaremesAnciennetesByIdSociete(Long idSociete);
}
