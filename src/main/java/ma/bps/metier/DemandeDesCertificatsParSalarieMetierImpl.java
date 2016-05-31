package ma.bps.metier;

import java.util.List;

import ma.bps.dao.DemandeDesCertificatsParSalarieDaoImpl;
import ma.bps.dao.IDemandeDesCertificatsParSalarie;
import ma.bps.entities.DemandeDesCertificatsParSalarie;

public class DemandeDesCertificatsParSalarieMetierImpl implements IDemandeDesCertificatsParSalarieMetier {
	
	IDemandeDesCertificatsParSalarie dao = new DemandeDesCertificatsParSalarieDaoImpl();

	public DemandeDesCertificatsParSalarie ajouterDemandeDesCertificatsParSalarie(DemandeDesCertificatsParSalarie m) {
		// TODO Auto-generated method stub
		return dao.ajouterDemandeDesCertificatsParSalarie(m);
	}

	public DemandeDesCertificatsParSalarie getDemandeDesCertificatsParSalarieById(
			Long idDemandeDesCertificatsParSalarie) {
		// TODO Auto-generated method stub
		return dao.getDemandeDesCertificatsParSalarieById(idDemandeDesCertificatsParSalarie);
	}

	public List<DemandeDesCertificatsParSalarie> getAllDemandeDesCertificatsParSalarie() {
		// TODO Auto-generated method stub
		return dao.getAllDemandeDesCertificatsParSalarie();
	}

	public DemandeDesCertificatsParSalarie modifierDemandeDesCertificatsParSalarie(DemandeDesCertificatsParSalarie m) {
		// TODO Auto-generated method stub
		return dao.modifierDemandeDesCertificatsParSalarie(m);
	}

	public void supprimerDemandeDesCertificatsParSalarie(Long idDemandeDesCertificatsParSalarie) {
		// TODO Auto-generated method stub
		dao.supprimerDemandeDesCertificatsParSalarie(idDemandeDesCertificatsParSalarie);
	}

}
