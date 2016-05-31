package ma.bps.metier;

import java.util.Date;
import java.util.List;

import ma.bps.dao.IPointage;
import ma.bps.dao.PointageDaoImpl;
import ma.bps.entities.Pointages;

public class PointageMetierImpl implements IPointageMetier {
	
	IPointage dao = new PointageDaoImpl();

	public void ajouterPointage(Pointages p) {
		// TODO Auto-generated method stub
		dao.ajouterPointage(p);

	}

	public Pointages getPointageById(Long idPointage) {
		// TODO Auto-generated method stub
		return dao.getPointageById(idPointage);
		
	}

	public List<Pointages> getAllPointage() {
		// TODO Auto-generated method stub
		return dao.getAllPointage();
	}

	public Pointages modifierPointage(Pointages p) {
		// TODO Auto-generated method stub
		return dao.modifierPointage(p);
	}

	public void supprimerPointage(Long idPointage) {
		// TODO Auto-generated method stub
		dao.supprimerPointage(idPointage);

	}

	public List<Pointages> getPointageUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getPointageUnSalarie(idSalarie);
	}

	public List<Pointages> chargerPointageSalarieUneDate(long idSalarie, Date dateVoulu) {

		return dao.chargerPointageSalarieUneDate(idSalarie, dateVoulu);
	}

	public List<Pointages> chargerPointageSalarieUneDateEtDateDemain(long idSalarie, Date dateVoulu) {
		// TODO Auto-generated method stub
		return dao.chargerPointageSalarieUneDateEtDateDemain(idSalarie, dateVoulu);
	}

	public boolean chercherSiPointageExist(Date datePointage, String heurePointage, Long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chercherSiPointageExist(datePointage, heurePointage, idSalarie);
	}

}
