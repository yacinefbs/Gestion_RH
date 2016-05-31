package ma.bps.metier;

import java.util.Date;
import java.util.List;

import ma.bps.dao.IJoursFeries;
import ma.bps.dao.JoursFeriesDaoImpl;
import ma.bps.entities.JourFeries;

public class JoursFeriesMetierImpl implements IJoursFeriesMetier {
	
	IJoursFeries dao = new JoursFeriesDaoImpl();

	public void ajouterJourFeries(JourFeries j) {
		// TODO Auto-generated method stub
		dao.ajouterJourFeries(j);

	}

	public JourFeries getJourFeriesById(Long idJourFeries) {
		// TODO Auto-generated method stub
		return dao.getJourFeriesById(idJourFeries);
	}

	public List<JourFeries> getAllJourFeries() {
		// TODO Auto-generated method stub
		return dao.getAllJourFeries();
	}

	public JourFeries modifierJourFeries(JourFeries j) {
		// TODO Auto-generated method stub
		return dao.modifierJourFeries(j);
	}

	public void supprimerJourFeries(Long idJourFeries) {
		// TODO Auto-generated method stub
		dao.supprimerJourFeries(idJourFeries);

	}

	public boolean testerSiJourFerie(Date dateVoulu) {
		// TODO Auto-generated method stub
		return dao.testerSiJourFerie(dateVoulu);
	}

}
