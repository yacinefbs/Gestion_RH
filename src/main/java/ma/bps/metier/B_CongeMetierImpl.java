package ma.bps.metier;

import java.util.List;

import ma.bps.dao.B_CongeDaoImpl;
import ma.bps.dao.IB_Conge;
import ma.bps.entities.B_Conges;

public class B_CongeMetierImpl implements IB_CongeMetier {

	private IB_Conge dao = new B_CongeDaoImpl();
	
	public B_Conges ajouterB_Conge(B_Conges c) {
		// TODO Auto-generated method stub
		return dao.ajouterB_Conge(c);
	}

	public B_Conges getB_CongeById(Long idB_Conge) {
		// TODO Auto-generated method stub
		return dao.getB_CongeById(idB_Conge);
	}

	public List<B_Conges> getAllB_Conges() {
		// TODO Auto-generated method stub
		return dao.getAllB_Conges();
	}

	public B_Conges modifierB_Conge(B_Conges c) {
		// TODO Auto-generated method stub
		return dao.modifierB_Conge(c);
	}

	public void supprimerB_Conge(Long idB_Conge) {
		// TODO Auto-generated method stub
		dao.supprimerB_Conge(idB_Conge);
	}

	public List<B_Conges> getBaremesCongesByIdSociete(Long idSociete) {
		// TODO Auto-generated method stub
		return dao.getBaremesCongesByIdSociete(idSociete);
	}

}
