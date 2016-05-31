package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.A_Justifiee;
import ma.bps.entities.A_Non_Justifiee;
import ma.bps.entities.Agences;
import ma.bps.entities.Avances;
import ma.bps.entities.Banques;
import ma.bps.entities.Conges;
import ma.bps.entities.F_Initiale;
import ma.bps.entities.F_Professionnelles;
import ma.bps.entities.HeureSupplementaire;
import ma.bps.entities.PlanTravail;
import ma.bps.entities.Prets;
import ma.bps.entities.PrimesAvantages;
import ma.bps.entities.Retards;
import ma.bps.entities.Salaries;
import ma.bps.entities.Societes;

public class SalarieDaoImpl implements ISalarie {

	
//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public SalarieDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		 em=emf.createEntityManager();
//	}

	public Salaries ajouterSalarie(Salaries s) {
//		Societes societe =new Societes();
//		societe.setIdSociete(1L);
//		s.setSociete(societe);
//		em.getTransaction().begin();
//		em.persist(s);
//		em.getTransaction().commit();
//		return s;	
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  Societes societe =new Societes();
				  societe.setIdSociete(1L);
				  s.setSociete(societe);
				  transaction.begin();  
				  em.persist(s);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return s;
	}

	public Salaries getSalarieById(Long idSalarie) {
		// TODO Auto-generated method stub
//		return em.find(Salaries.class, idSalarie);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Salaries salarie = new Salaries();
		try {
			System.out.println("congé salarie");
			salarie = em.find(Salaries.class, idSalarie);
			} finally {
			  em.close();
			}
		System.out.println("nbr congé du salarie : " + salarie.getConges().size());
		return salarie;
	}

	public List<Salaries> getAllSalaries() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select s from Salaries s");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Salaries> salaries;
		Query query;
		try {
			query = em.createQuery("select s from Salaries s");
			salaries = query.getResultList();
			} finally {
			  em.close();
			}
		return salaries;
		
	}

	public Salaries getSalarieByMatricule(Long idSalarie) {
//		Query query = em.createQuery("select s from Salaries s where s.idSalarie="+ idSalarie);
//		return (Salaries) query.getResultList().get(0);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Salaries salarie = new Salaries();
		Query query;
		try {
			query = em.createQuery("select s from Salaries s where s.idSalarie="+ idSalarie);
			salarie = (Salaries) query.getResultList().get(0);
			} finally {
			  em.close();
			}
		return salarie;
	}
	
	public Salaries modifierSalarie(Salaries s) {
//		em.getTransaction().begin();
//		em.merge(s);
//		em.getTransaction().commit();
//		return s;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(s);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return s;
	}

	public void supprimerSalarie(Long idSalarie) {
//		em.getTransaction().begin();
//		Salaries s = em.find(Salaries.class, idSalarie);
//		em.remove(s);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Salaries salarie = new Salaries();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  salarie = em.find(Salaries.class, idSalarie);
				  em.remove(salarie);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public boolean verifierExisteEmail(String email) {
//		Query query = em.createQuery("select s from Salaries s where s.email='"+ email+"'");
//		if(query.getResultList()!=null){
//			return true;
//		}
//		else{
//			return false;
//		}
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
				Query query = em.createQuery("select s from Salaries s where s.email='"+ email+"'");
				if(query.getResultList()!=null){
					return true;
				}
				else{
					return false;
				}
			} finally {
			  em.close();
			}
	}

	public boolean verifierExisteMatricule(Long matricule) {
//		Query query = em.createQuery("select s from Salaries s where s.idSalarie=" + matricule);
//		if(query.getResultList().size()>0){
//			return true;
//		}
//		else{
//			return false;
//		}
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
				Query query = em.createQuery("select s from Salaries s where s.idSalarie=" + matricule);
				if(query.getResultList().size()>0){
					return true;
				}
				else{
					return false;
				}
			} finally {
			  em.close();
			}
	}
	
	
	
	public List<Salaries> chargerListeSalariesNonAffecterAunGroupe() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select s from Salaries s where s.groupe is null");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Salaries> salaries;
		Query query;
		try {
			query = em.createQuery("select s from Salaries s where s.groupe is null");
			salaries = query.getResultList();
			} finally {
			  em.close();
			}
		return salaries;
		
	}
	
	public int nbrSalarie() {
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		int nbrSalarie = 0;
		Query query;
		try {
			query = em.createQuery("select s from Salaries s");
			nbrSalarie = (Integer) query.getResultList().size();
			} finally {
			  em.close();
			}
		return nbrSalarie;
		}
	
	public void annulerGroupeDesSalaries(long idGroupe){
		
//		em.getTransaction().begin();
//		Query query = em.createQuery("update Salaries s set s.groupe=null where s.groupe.idGroupe=" + idGroupe);
//		query.executeUpdate();
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Salaries salarie = new Salaries();
		Query query;
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  query = em.createQuery("update Salaries s set s.groupe=null where s.groupe.idGroupe=" + idGroupe);
				  query.executeUpdate();
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		
	}

	public PlanTravail chargerPlanTravailUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub

		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select p from PlanTravail p,Salaries s,Groupes g where s.groupe.idGroupe=g.idGroupe and g.planTravail.idPlan=p.idPlan and s.idSalarie=" + idSalarie);
			if (query.getResultList().size()>0) 
				{
					return (PlanTravail) query.getResultList().get(0);
				}
				else
				{
					return new PlanTravail();
				}
			} finally {
			  em.close();
			}
		
	}
	
	
	
	

	// ajouter le 29/04/2016

	public List<Object[]> chargerNombreAbsenceSalarie(long idSalarie) {

		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from A_Non_Justifiee a where a.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
		
		
	}

	public List<Object[]> chargerNombreRetardSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from Retards r where r.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Object[]> chargerNombreAvanceSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from Avances a where a.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Object[]> chargerNombreFormationSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from F_Professionnelles f where f.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<A_Non_Justifiee> chargerAbsenceNonJustifieeUnSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from A_Non_Justifiee a where a.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<A_Justifiee> chargerAbsenceJustifieeUnSalarie(long idSalarie) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from A_Justifiee a where a.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Retards> chargerRetardUnSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from Retards a where a.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<F_Initiale> chargerFormationInitialUnSalarie(long idSalarie) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from F_Initiale a where a.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<F_Professionnelles> chargerFormationProfessionneleUnSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from F_Professionnelles a where a.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Avances> chargerAvanceUnSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from Avances a where a.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Object[]> ChargerNomPrenomSalarie() {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select s.idSalarie,concat(concat(s.nom,' '), s.prenom) from Salaries s");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Object[]> chargerNombreCongeSalarie(long idSalarie) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from Conges f where f.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Object[]> chargerNombrePretSalarie(long idSalarie) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from Prets f where f.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Object[]> chargerNombreHeureSupplementaireSalarie(long idSalarie) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from HeureSupplementaire f where f.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Object[]> chargerNombrePrimeAvantageSalarie(long idSalarie) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from PrimesAvantages f where f.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Conges> chargerCongeValideUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from Conges a where a.salarie.idSalarie=" + idSalarie + " and a.valide='validé'");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
		
	}
	
	

	public List<Conges> chargerCongeNonValideUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from Conges a where a.salarie.idSalarie=" + idSalarie + " and a.valide<>'validé'");
			return query.getResultList();
			} finally {
			  em.close();
			}
	}
	
	

	public List<Prets> chargerPretUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from Prets a where a.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
		
	}

	public List<HeureSupplementaire> chargerHeureSupplementaireUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from HeureSupplementaire a where a.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
		
	}

	public List<PrimesAvantages> chargerPrimeAvantageUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from PrimesAvantages a where a.salarie.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
		
	}

	public List<PlanTravail> chargerPlanTravailSiExisteUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select p from PlanTravail p,Salaries s,Groupes g where s.groupe.idGroupe=g.idGroupe and g.planTravail.idPlan=p.idPlan and s.idSalarie=" + idSalarie);
			return query.getResultList();
			} finally {
			  em.close();
			}
	}

	
	
	
	
}
