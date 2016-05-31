package ma.bps.metier;

import java.util.List;

import ma.bps.dao.AgenceDaoImpl;
import ma.bps.dao.IAgence;
import ma.bps.entities.Agences;

public class AgenceMetierImpl implements IAgenceMetier {

	private IAgence dao = new AgenceDaoImpl();
	
	
	public Agences ajouterAgence(Agences a) {
		// TODO Auto-generated method stub
		return dao.ajouterAgence(a);
	}

	public Agences getAgenceById(Long idAgence) {
		// TODO Auto-generated method stub
		return dao.getAgenceById(idAgence);
	}

	public List<Agences> getAllAgences() {
		// TODO Auto-generated method stub
		return dao.getAllAgences();
	}

	public List<Agences> getAllAgencesByBanque(Long idBanque) {
		// TODO Auto-generated method stub
		return dao.getAllAgencesByBanque(idBanque);
	}

	public Agences modifierAgence(Agences a) {
		// TODO Auto-generated method stub
		return dao.modifierAgence(a);
	}

	public void supprimerAgence(Long idAgence) {
		// TODO Auto-generated method stub
		dao.supprimerAgence(idAgence);
	}
}
