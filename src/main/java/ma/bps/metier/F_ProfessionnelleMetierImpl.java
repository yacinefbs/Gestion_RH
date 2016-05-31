package ma.bps.metier;

import java.util.List;

import ma.bps.dao.F_ProfessionnelleDaoImpl;
import ma.bps.dao.IF_Professionnelle;
import ma.bps.entities.F_Professionnelles;

public class F_ProfessionnelleMetierImpl implements IF_ProfessionnelleMetier {

	private IF_Professionnelle dao = new F_ProfessionnelleDaoImpl();
	
	public F_Professionnelles ajouterF_Pro(F_Professionnelles F_Professionnelles) {
		// TODO Auto-generated method stub
		return dao.ajouterF_Pro(F_Professionnelles);
	}

	public F_Professionnelles getF_ProfessionnellesById(Long idF_Professionnelles) {
		// TODO Auto-generated method stub
		return dao.getF_ProfessionnellesById(idF_Professionnelles);
	}

	public List<F_Professionnelles> getAllF_Professionnelles() {
		// TODO Auto-generated method stub
		return dao.getAllF_Professionnelles();
	}

	public List<F_Professionnelles> getF_ProfessionnellesByIdSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getF_ProfessionnellesByIdSalarie(idSalarie);
	}

	public F_Professionnelles modifierF_Professionnelles(F_Professionnelles F_Professionnelles) {
		// TODO Auto-generated method stub
		return dao.modifierF_Professionnelles(F_Professionnelles);
	}

	public void supprimerF_Professionnelles(Long idF_Professionnelles) {
		// TODO Auto-generated method stub
		dao.supprimerF_Professionnelles(idF_Professionnelles);
	}
}
