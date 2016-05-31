package ma.bps.dao;

import java.util.Date;
import java.util.List;

import ma.bps.entities.JourFeries;

public interface IJoursFeries {
	
	public void ajouterJourFeries(JourFeries j);
	public JourFeries getJourFeriesById(Long idJourFeries);
	public List<JourFeries> getAllJourFeries();
	public JourFeries modifierJourFeries(JourFeries j);
	public void supprimerJourFeries(Long idJourFeries);
	public boolean testerSiJourFerie(Date dateVoulu);

}
