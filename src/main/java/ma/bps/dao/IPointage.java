package ma.bps.dao;

import java.util.Date;
import java.util.List;

import ma.bps.entities.PlanTravail;
import ma.bps.entities.Pointages;

public interface IPointage {
	
	public void ajouterPointage(Pointages p);
	public Pointages getPointageById(Long idPointage);
	public List<Pointages> getAllPointage();
	public Pointages modifierPointage(Pointages p);
	public void supprimerPointage(Long idPointage);
	public List<Pointages> getPointageUnSalarie(long idSalarie);
	
	public List<Pointages> chargerPointageSalarieUneDate(long idSalarie, Date dateVoulu);
	public List<Pointages> chargerPointageSalarieUneDateEtDateDemain(long idSalarie, Date dateVoulu);
	
	// chercher si un pointage existe bach ma yat3awdch
	public boolean chercherSiPointageExist(Date datePointage, String heurePointage, Long idSalarie);
	
}
