package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.A_Justifiee;
import ma.bps.entities.PlanTravail;

public class PlanTravailDaoImpl implements IPlanTravail {

//	@PersistenceContext
//	private EntityManager em;
//	
//	public PlanTravailDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		 em=emf.createEntityManager();
//	}

	public void ajouterPlanTravail(PlanTravail p) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.persist(p);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(p);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public PlanTravail getPlanTravailById(Long idPlan) {
		// TODO Auto-generated method stub
//		return em.find(PlanTravail.class, idPlan);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PlanTravail planTravail = new PlanTravail();
		try {
			planTravail = em.find(PlanTravail.class, idPlan);
			} finally {
			  em.close();
			}
		return planTravail;
	}

	public List<PlanTravail> getAllPlanTravail() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select p from PlanTravail p");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<PlanTravail> planTravails;
		Query query;
		try {
			query = em.createQuery("select p from PlanTravail p");
			planTravails = query.getResultList();
			} finally {
			  em.close();
			}
		return planTravails;
	}

	public PlanTravail modifierPlanTravail(PlanTravail p) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.merge(p);
//		em.getTransaction().commit();
//		return p;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(p);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return p;
	}

	public void supprimerPlanTravail(Long idPlan) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		PlanTravail t = em.find(PlanTravail.class, idPlan);
//		em.remove(t);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PlanTravail planTravail = new PlanTravail();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  planTravail = em.find(PlanTravail.class, idPlan);
				  em.remove(planTravail);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

	public List<PlanTravail> chercherPlanTravailAvecDesignationEtCodeDeffirent(Long idPlan, String designation) {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select p from PlanTravail p where p.idPlan<>" + idPlan +" and p.designation='" + designation + "'");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<PlanTravail> planTravails;
		Query query;
		try {
			query = em.createQuery("select p from PlanTravail p where p.idPlan<>" + idPlan +" and p.designation='" + designation + "'");
			planTravails = query.getResultList();
			} finally {
			  em.close();
			}
		return planTravails;
	}

	public List<PlanTravail> chercherPlanTravailAvecDesignation(String designation) {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select p from PlanTravail p where p.designation='" + designation + "'");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<PlanTravail> planTravails;
		Query query;
		try {
			query = em.createQuery("select p from PlanTravail p where p.designation='" + designation + "'");
			planTravails = query.getResultList();
			} finally {
			  em.close();
			}
		return planTravails;
	}
}
