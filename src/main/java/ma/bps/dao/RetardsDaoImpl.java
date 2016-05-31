package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.A_Justifiee;
import ma.bps.entities.Groupes;
import ma.bps.entities.Retards;

public class RetardsDaoImpl implements IRetards {
	
//	@PersistenceContext
//	private EntityManager em;
//	
//	public RetardsDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public void ajouterRetard(Retards r) {

//		em.getTransaction().begin();
//		em.persist(r);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(r);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

	public Retards getRetardById(Long idRetard) {
		// TODO Auto-generated method stub
//		return em.find(Retards.class, idRetard);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Retards retard = new Retards();
		try {
			retard = em.find(Retards.class, idRetard);
			} finally {
			  em.close();
			}
		return retard;
	}

	public List<Retards> getAllRetards() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select r from Retards r");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Retards> retards;
		Query query;
		try {
			query = em.createQuery("select r from Retards r");
			retards = query.getResultList();
			} finally {
			  em.close();
			}
		return retards;
	}

	public Retards modifierRetard(Retards r) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.merge(r);
//		em.getTransaction().commit();
//		return r;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(r);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return r;
	}

	public void supprimerRetards(Long idRetard) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Retards r = em.find(Retards.class, idRetard);
//		em.remove(r);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Retards retard = new Retards();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  retard = em.find(Retards.class, idRetard);
				  em.remove(retard);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
}
