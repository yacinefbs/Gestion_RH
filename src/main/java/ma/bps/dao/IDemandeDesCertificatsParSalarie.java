package ma.bps.dao;

import java.util.List;

import ma.bps.entities.DemandeDesCertificatsParSalarie;

public interface IDemandeDesCertificatsParSalarie {
	
	public DemandeDesCertificatsParSalarie ajouterDemandeDesCertificatsParSalarie(DemandeDesCertificatsParSalarie m);
	public DemandeDesCertificatsParSalarie getDemandeDesCertificatsParSalarieById(Long idDemandeDesCertificatsParSalarie);
	public List<DemandeDesCertificatsParSalarie> getAllDemandeDesCertificatsParSalarie();
	public DemandeDesCertificatsParSalarie modifierDemandeDesCertificatsParSalarie(DemandeDesCertificatsParSalarie m);
	public void supprimerDemandeDesCertificatsParSalarie(Long idDemandeDesCertificatsParSalarie);

}
