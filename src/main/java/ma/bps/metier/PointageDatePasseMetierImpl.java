package ma.bps.metier;

import java.util.Date;
import java.util.List;

import ma.bps.dao.IPointageDatePasse;
import ma.bps.dao.PointageDatePasseDaoImpl;
import ma.bps.entities.PointageDatePasse;

public class PointageDatePasseMetierImpl implements IPointageDatePasseMetier {
	
	
	IPointageDatePasse dao = new PointageDatePasseDaoImpl();

	public void ajouterPointageDatePasse(PointageDatePasse p) {
		// TODO Auto-generated method stub
		dao.ajouterPointageDatePasse(p);

	}

	public PointageDatePasse getPointageDatePasseById(Long idPointage) {
		// TODO Auto-generated method stub
		return dao.getPointageDatePasseById(idPointage);
	}

	public List<PointageDatePasse> getAllPointageDatePasse() {
		// TODO Auto-generated method stub
		return dao.getAllPointageDatePasse();
	}

	public PointageDatePasse modifierPointageDatePasse(PointageDatePasse p) {
		// TODO Auto-generated method stub
		return dao.modifierPointageDatePasse(p);
	}

	public void supprimerPointageDatePasse(Long idPointage) {
		// TODO Auto-generated method stub
		dao.supprimerPointageDatePasse(idPointage);
	}

	public boolean getPointageDatePasseByDate(Date datePointage) {
		// TODO Auto-generated method stub
		return dao.getPointageDatePasseByDate(datePointage);
	}

}
