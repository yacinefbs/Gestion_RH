package ma.bps.metier;

import java.util.Date;
import java.util.List;

import ma.bps.entities.Conges;

public interface ICongeMetier {
	public Conges ajouterConge(Conges c);
	public Conges getCongeById(Long idConge);
	public List<Conges> getAllConges();
	public List<Conges> getAllCongesBySalarie(Long idSalarie);
	public Conges modifierConge(Conges c);
	public void supprimerConge(Long idConge);
	public double nbrJoursCongeRestant(Long idSalarie, Long idSociete);
	public Conges accepterConge(Conges c);
	public Conges refuserConge(Conges c);
	
	//Ahmed
	public List<Conges> chargerCongesSalarieUneDate(Long idSalarie, Date dateVoulu); // pour charger le conges d'une date
}
