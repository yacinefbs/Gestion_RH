package ma.bps.metier;

import java.util.List;
import ma.bps.dao.B_IgrDaoImpl;
import ma.bps.dao.IB_IGR;
import ma.bps.entities.B_IGR;

public class B_IgrMetierImpl implements IB_IgrMetier {

	private IB_IGR dao = new B_IgrDaoImpl();
	
	public B_IGR ajouterB_IGR(B_IGR b_IGR) {
		// TODO Auto-generated method stub
		return dao.ajouterB_IGR(b_IGR);
	}

	public B_IGR getB_IGRById(Long idB_IGR) {
		// TODO Auto-generated method stub
		return dao.getB_IGRById(idB_IGR);
	}

	public List<B_IGR> getAllB_IGRs() {
		// TODO Auto-generated method stub
		return dao.getAllB_IGRs();
	}

	public B_IGR modifierB_IGR(B_IGR b_IGR) {
		// TODO Auto-generated method stub
		return dao.modifierB_IGR(b_IGR);
	}

	public void supprimerB_IGR(Long idB_Conge) {
		// TODO Auto-generated method stub
		dao.supprimerB_IGR(idB_Conge);
	}

	public List<B_IGR> getBaremesIgrsByIdSociete(Long idSociete) {
		// TODO Auto-generated method stub
		return dao.getBaremesIgrsByIdSociete(idSociete);
	}
}
