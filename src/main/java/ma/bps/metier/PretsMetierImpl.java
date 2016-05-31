package ma.bps.metier;

import java.util.List;

import ma.bps.dao.IPrets;
import ma.bps.dao.PretsDaoImpl;
import ma.bps.entities.Prets;

public class PretsMetierImpl implements IPretsMetier {

	private IPrets dao = new PretsDaoImpl();
	
	
	public Prets ajouterPret(Prets p) {
		// TODO Auto-generated method stub
		return dao.ajouterPret(p);
	}

	public Prets getPretById(Long idPret) {
		// TODO Auto-generated method stub
		return dao.getPretById(idPret);
	}

	public List<Prets> getAllPrets() {
		// TODO Auto-generated method stub
		return dao.getAllPrets();
	}

	public Prets modifierPrets(Prets p) {
		// TODO Auto-generated method stub
		return dao.modifierPrets(p);
	}

	public void supprimerPret(Long idPret) {
		// TODO Auto-generated method stub
		dao.supprimerPret(idPret);
	}

	public List<Prets> getAllPretsBySalarie(Long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getAllPretsBySalarie(idSalarie);
	}
}
