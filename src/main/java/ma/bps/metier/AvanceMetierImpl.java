package ma.bps.metier;

import java.util.List;

import ma.bps.dao.AvanceDaoImpl;
import ma.bps.dao.IAvance;
import ma.bps.entities.Avances;

public class AvanceMetierImpl implements IAvanceMetier {

	
	private IAvance dao = new AvanceDaoImpl();
	public Avances ajouterAvance(Avances a) {
		// TODO Auto-generated method stub
		return dao.ajouterAvance(a);
	}

	public Avances getAvanceById(Long idAvance) {
		// TODO Auto-generated method stub
		return dao.getAvanceById(idAvance);
	}

	public List<Avances> getAllAvances() {
		// TODO Auto-generated method stub
		return dao.getAllAvances();
	}

	public Avances modifierAvance(Avances a) {
		// TODO Auto-generated method stub
		return dao.modifierAvance(a);
	}

	public void supprimerAvance(Long idAvance) {
		// TODO Auto-generated method stub
		dao.supprimerAvance(idAvance);
	}

	public List<Avances> getAllAvanceBySalarie(Long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getAllAvanceBySalarie(idSalarie);
	}

}
