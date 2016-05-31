package ma.bps.metier;

import java.util.List;

import ma.bps.dao.CotisationDaoImpl;
import ma.bps.dao.ICotisation;
import ma.bps.entities.Cotisations;

public class CotisationMetierImpl implements ICotisationMetier{

	private ICotisation dao = new CotisationDaoImpl();
	
	public Cotisations ajouterCotisation(Cotisations c) {
		// TODO Auto-generated method stub
		return dao.ajouterCotisation(c);
	}

	public Cotisations getCotisationsById(Long idCotisation) {
		// TODO Auto-generated method stub
		return dao.getCotisationsById(idCotisation);
	}

	public List<Cotisations> getAllCotisations() {
		// TODO Auto-generated method stub
		return dao.getAllCotisations();
	}

	public Cotisations modifierCotisation(Cotisations c) {
		// TODO Auto-generated method stub
		return dao.modifierCotisation(c);
	}

	public void supprimerCotisation(Long idCotisation) {
		// TODO Auto-generated method stub
		dao.supprimerCotisation(idCotisation);
	}
}
