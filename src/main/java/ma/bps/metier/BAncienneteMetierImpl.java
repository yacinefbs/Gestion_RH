package ma.bps.metier;

import java.util.List;

import ma.bps.dao.B_AncienneteDaoImpl;
import ma.bps.dao.IB_Anciennete;
import ma.bps.entities.B_Anciennetes;

public class BAncienneteMetierImpl implements IBAncienneteMetier {

	private IB_Anciennete dao = new B_AncienneteDaoImpl();
	
	public B_Anciennetes ajouterB_Anciennetes(B_Anciennetes b_anciennete) {
		// TODO Auto-generated method stub
		return dao.ajouterB_Anciennetes(b_anciennete);
	}

	public B_Anciennetes getB_AnciennetesById(Long idBAnciennete) {
		// TODO Auto-generated method stub
		return dao.getB_AnciennetesById(idBAnciennete);
	}

	public List<B_Anciennetes> getAllB_Anciennetes() {
		// TODO Auto-generated method stub
		return dao.getAllB_Anciennetes();
	}

	public B_Anciennetes modifierB_Anciennete(B_Anciennetes BAnciennete) {
		// TODO Auto-generated method stub
		return dao.modifierB_Anciennete(BAnciennete);
	}

	public void supprimerB_Anciennetes(Long idBAnciennete) {
		// TODO Auto-generated method stub
		dao.supprimerB_Anciennetes(idBAnciennete);
	}

	public List<B_Anciennetes> getBaremesCongesByIdSociete(Long idSociete) {
		// TODO Auto-generated method stub
		return dao.getBaremesAnciennetesByIdSociete(idSociete);
	}
}
