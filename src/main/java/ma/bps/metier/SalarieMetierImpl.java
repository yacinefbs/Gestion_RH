package ma.bps.metier;

import java.util.List;

import ma.bps.dao.ISalarie;
import ma.bps.dao.SalarieDaoImpl;
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

public class SalarieMetierImpl implements ISalarieMetier {

	
	private ISalarie dao = new SalarieDaoImpl();
	
	public Salaries ajouterSalarie(Salaries s) {
		// TODO Auto-generated method stub
		return dao.ajouterSalarie(s);
	}

	public Salaries getSalarieById(Long idSalarie) {
		// TODO Auto-generated method stub
		return dao.getSalarieById(idSalarie);
	}

	public List<Salaries> getAllSalaries() {
		// TODO Auto-generated method stub
		return dao.getAllSalaries();
	}
	
	public Salaries getSalarieByMatricule(Long idSalarie) {
		return dao.getSalarieByMatricule(idSalarie);
	}

	public Salaries modifierSalarie(Salaries s) {
		// TODO Auto-generated method stub
		return dao.modifierSalarie(s);
	}

	public void supprimerSalarie(Long idSalarie) {
		// TODO Auto-generated method stub
		dao.supprimerSalarie(idSalarie);
	}

	public boolean verifierExisteEmail(String email) {
		// TODO Auto-generated method stub
		return dao.verifierExisteEmail(email);
	}

	public boolean verifierExisteMatricule(Long matricule) {
		// TODO Auto-generated method stub
		return dao.verifierExisteMatricule(matricule);
	}
	public int nbrSalarie() {
		// TODO Auto-generated method stub
		return dao.nbrSalarie();
	}
	public List<Salaries> chargerListeSalariesNonAffecterAunGroupe() {
		// TODO Auto-generated method stub
		return dao.chargerListeSalariesNonAffecterAunGroupe();
	}

	public void annulerGroupeDesSalaries(long idGroupe) {
		// TODO Auto-generated method stub
		dao.annulerGroupeDesSalaries(idGroupe);
				
	}
	public PlanTravail chargerPlanTravailUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerPlanTravailUnSalarie(idSalarie);
	}
	
	
	// ajouter le 29/04/2016
	
	
	public List<Object[]> chargerNombreAbsenceSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombreAbsenceSalarie(idSalarie);
	}

	public List<Object[]> chargerNombreRetardSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombreRetardSalarie(idSalarie);
	}

	public List<Object[]> chargerNombreAvanceSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombreAvanceSalarie(idSalarie);
	}

	public List<Object[]> chargerNombreFormationSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombreFormationSalarie(idSalarie);
	}

	public List<A_Non_Justifiee> chargerAbsenceNonJustifieeUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerAbsenceNonJustifieeUnSalarie(idSalarie);
	}

	public List<A_Justifiee> chargerAbsenceJustifieeUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerAbsenceJustifieeUnSalarie(idSalarie);
	}

	public List<Retards> chargerRetardUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerRetardUnSalarie(idSalarie);
	}

	public List<F_Initiale> chargerFormationInitialUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerFormationInitialUnSalarie(idSalarie);
	}

	public List<F_Professionnelles> chargerFormationProfessionneleUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerFormationProfessionneleUnSalarie(idSalarie);
	}

	public List<Avances> chargerAvanceUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerAvanceUnSalarie(idSalarie);
	}

	public List<Object[]> ChargerNomPrenomSalarie() {
		// TODO Auto-generated method stub
		return dao.ChargerNomPrenomSalarie();
	}

	public List<Object[]> chargerNombreCongeSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombreCongeSalarie(idSalarie);
	}

	public List<Object[]> chargerNombrePretSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombrePretSalarie(idSalarie);
	}

	public List<Object[]> chargerNombreHeureSupplementaireSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombreHeureSupplementaireSalarie(idSalarie);
	}

	public List<Object[]> chargerNombrePrimeAvantageSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerNombrePrimeAvantageSalarie(idSalarie);
	}

	public List<Conges> chargerCongeValideUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerCongeValideUnSalarie(idSalarie);
	}

	
	public List<Conges> chargerCongeNonValideUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerCongeNonValideUnSalarie(idSalarie);
	}
	
	
	public List<Prets> chargerPretUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerPretUnSalarie(idSalarie);
	}

	public List<HeureSupplementaire> chargerHeureSupplementaireUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerHeureSupplementaireUnSalarie(idSalarie);
	}

	public List<PrimesAvantages> chargerPrimeAvantageUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerPrimeAvantageUnSalarie(idSalarie);
	}

	public List<PlanTravail> chargerPlanTravailSiExisteUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		return dao.chargerPlanTravailSiExisteUnSalarie(idSalarie);
	}
	
}
