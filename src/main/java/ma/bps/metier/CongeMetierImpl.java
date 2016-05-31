package ma.bps.metier;

import java.util.Date;
import java.util.List;

import ma.bps.dao.CongeDaoImpl;
import ma.bps.dao.IConge;
import ma.bps.entities.Conges;

public class CongeMetierImpl implements ICongeMetier {

	private IConge dao = new CongeDaoImpl();
	
	public Conges ajouterConge(Conges c) {
		// TODO Auto-generated method stub
		return dao.ajouterConge(c);
	}

	public Conges getCongeById(Long idConge) {
		// TODO Auto-generated method stub
		return dao.getCongeById(idConge);
	}

	public List<Conges> getAllConges() {
		// TODO Auto-generated method stub
		return dao.getAllConges();
	}

	public Conges modifierConge(Conges c) {
		// TODO Auto-generated method stub
		return dao.modifierConge(c);
	}

	public void supprimerConge(Long idConge) {
		// TODO Auto-generated method stub
		dao.supprimerConge(idConge);
	}

	public List<Conges> getAllCongesBySalarie(Long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getAllCongesBySalarie(idSalarie);
	}

	public double nbrJoursCongeRestant(Long idSalarie, Long idSociete) {
		// TODO Auto-generated method stub
		return dao.nbrJoursCongeRestant(idSalarie, idSociete);
	}

	public Conges accepterConge(Conges c) {
		// TODO Auto-generated method stub
		return dao.accepterConge(c);
	}
	public Conges refuserConge(Conges c) {
		// TODO Auto-generated method stub
		return dao.refuserConge(c);
	}
	
	public List<Conges> chargerCongesSalarieUneDate(Long idSalarie, Date dateVoulu) {
		// TODO Auto-generated method stub
		return dao.chargerCongesSalarieUneDate(idSalarie, dateVoulu);
	}
}
