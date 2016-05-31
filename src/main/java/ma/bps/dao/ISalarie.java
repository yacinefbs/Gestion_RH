package ma.bps.dao;

import java.util.List;

import ma.bps.entities.A_Justifiee;
import ma.bps.entities.A_Non_Justifiee;
import ma.bps.entities.Avances;
import ma.bps.entities.Conges;
import ma.bps.entities.F_Initiale;
import ma.bps.entities.F_Professionnelles;
import ma.bps.entities.HeureSupplementaire;
import ma.bps.entities.PlanTravail;
import ma.bps.entities.Prets;
import ma.bps.entities.PrimesAvantages;
import ma.bps.entities.Retards;
import ma.bps.entities.Salaries;

public interface ISalarie {
	public Salaries ajouterSalarie(Salaries s);
	public Salaries getSalarieById(Long idSalarie);
	public List<Salaries> getAllSalaries();
	public Salaries getSalarieByMatricule(Long idSalarie);
	public Salaries modifierSalarie(Salaries s);
	public void supprimerSalarie(Long idSalarie);
	public boolean verifierExisteEmail(String email);
	public boolean verifierExisteMatricule(Long matricule);
	public int nbrSalarie();
	
	public List<Salaries> chargerListeSalariesNonAffecterAunGroupe(); // cette méthode est utiliser pour charger la liste des salaries non affecter a un groupe 
	public void annulerGroupeDesSalaries(long idGroupe); // cette methode est utiliser pour rendre idGroupe d'un salarie null ( pour que le groupe puise etre supprimer )
	public PlanTravail chargerPlanTravailUnSalarie(long idSalarie); // cette methode est utiliser pour charger le plan de travail d'un salarie
	
	
	// hado zadthom le 29/04/2016
	
	public List<Object[]> chargerNombreAbsenceSalarie(long idSalarie);
	public List<Object[]> chargerNombreRetardSalarie(long idSalarie);
	public List<Object[]> chargerNombreAvanceSalarie(long idSalarie);
	public List<Object[]> chargerNombreFormationSalarie(long idSalarie);
	public List<Object[]> chargerNombreCongeSalarie(long idSalarie);
	public List<Object[]> chargerNombrePretSalarie(long idSalarie);
	public List<Object[]> chargerNombreHeureSupplementaireSalarie(long idSalarie);
	public List<Object[]> chargerNombrePrimeAvantageSalarie(long idSalarie);
	
	public List<A_Non_Justifiee> chargerAbsenceNonJustifieeUnSalarie(long idSalarie);
	public List<A_Justifiee> chargerAbsenceJustifieeUnSalarie(long idSalarie);
	public List<Retards> chargerRetardUnSalarie(long idSalarie);
	public List<F_Initiale> chargerFormationInitialUnSalarie(long idSalarie);
	public List<F_Professionnelles> chargerFormationProfessionneleUnSalarie(long idSalarie);
	public List<Avances> chargerAvanceUnSalarie(long idSalarie);
	//public List<Conges> chargerCongeUnSalarie(long idSalarie);
	public List<Conges> chargerCongeValideUnSalarie(long idSalarie);
	public List<Conges> chargerCongeNonValideUnSalarie(long idSalarie);
	public List<Prets> chargerPretUnSalarie(long idSalarie);
	public List<HeureSupplementaire> chargerHeureSupplementaireUnSalarie(long idSalarie);
	public List<PrimesAvantages> chargerPrimeAvantageUnSalarie(long idSalarie);
	
	// hadi gha tjib linale plan de travail ilakan
	public List<PlanTravail> chargerPlanTravailSiExisteUnSalarie(long idSalarie);
	
	// pour auto complete nom destinataire
	public List<Object[]> ChargerNomPrenomSalarie();
	
}
