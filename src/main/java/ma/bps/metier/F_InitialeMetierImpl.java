package ma.bps.metier;

import java.util.List;

import ma.bps.dao.F_InitialeDaoImpl;
import ma.bps.dao.IF_Initiale;
import ma.bps.entities.F_Initiale;

public class F_InitialeMetierImpl implements IF_InitialeMetier {

	private IF_Initiale dao = new F_InitialeDaoImpl();
	
	public F_Initiale ajouterF_Initiale(F_Initiale F_Initiale) {
		// TODO Auto-generated method stub
		return dao.ajouterF_Initiale(F_Initiale);
	}

	public F_Initiale getF_InitialeById(Long idF_Initiale) {
		// TODO Auto-generated method stub
		return dao.getF_InitialeById(idF_Initiale);
	}

	public List<F_Initiale> getAllF_Initiales() {
		// TODO Auto-generated method stub
		return dao.getAllF_Initiales();
	}

	public List<F_Initiale> getF_InitialeByIdSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getF_InitialeByIdSalarie(idSalarie);
	}

	public F_Initiale modifierF_Initiale(F_Initiale f_Initiale) {
		// TODO Auto-generated method stub
		return dao.modifierF_Initiale(f_Initiale);
	}

	public void supprimerF_Initiale(Long idF_Initiale) {
		// TODO Auto-generated method stub
		dao.supprimerF_Initiale(idF_Initiale);
	}
}
