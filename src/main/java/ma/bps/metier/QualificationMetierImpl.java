package ma.bps.metier;

import java.util.List;

import ma.bps.dao.IQualification;
import ma.bps.dao.QualificationDaoImpl;
import ma.bps.entities.Qualifications;

public class QualificationMetierImpl implements IQualificationMetier {

	private IQualification dao = new QualificationDaoImpl();
	
	public Qualifications ajouterQualification(Qualifications q) {
		// TODO Auto-generated method stub
		return dao.ajouterQualification(q);
	}

	public Qualifications getQualificationById(Long idQualification) {
		// TODO Auto-generated method stub
		return dao.getQualificationById(idQualification);
	}

	public List<Qualifications> getAllQualifications() {
		// TODO Auto-generated method stub
		return dao.getAllQualifications();
	}

	public Qualifications modifierQualification(Qualifications q) {
		// TODO Auto-generated method stub
		return dao.modifierQualification(q);
	}

	public void supprimerQualification(Long idQualification) {
		// TODO Auto-generated method stub
		dao.supprimerQualification(idQualification);
	}

}
