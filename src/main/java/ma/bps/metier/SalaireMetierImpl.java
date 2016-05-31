package ma.bps.metier;

import java.util.List;

import ma.bps.dao.ISalaire;
import ma.bps.dao.SalaireDaoImpl;
import ma.bps.entities.Salaires;
import ma.bps.entities.Salaries;

public class SalaireMetierImpl implements ISalaireMetier {

	
	private ISalaire dao = new SalaireDaoImpl();

	public Salaires ajouterSalaire(Salaires s) {
		// TODO Auto-generated method stub
		return dao.ajouterSalaire(s);
	}

	public Salaires getSalaireById(Long idSalaire) {
		// TODO Auto-generated method stub
		return dao.getSalaireById(idSalaire);
	}

	public List<Salaires> getAllSalaires() {
		// TODO Auto-generated method stub
		return dao.getAllSalaires();
	}

	public Salaires modifierSalaire(Salaires s) {
		// TODO Auto-generated method stub
		return dao.modifierSalaire(s);
	}

	public void supprimerSalaire(Long idSalaire) {
		// TODO Auto-generated method stub
		dao.supprimerSalaire(idSalaire);
	}
	public Salaires getSalaireByIdSalarie(Long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getSalaireByIdSalarie(idSalarie);
	}
	
}
