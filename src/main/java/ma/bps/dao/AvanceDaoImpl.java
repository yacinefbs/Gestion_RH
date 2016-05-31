package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.Avances;
import ma.bps.entities.Banques;

public class AvanceDaoImpl implements IAvance {

	
//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	
//	
//	public AvanceDaoImpl() {
//		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		 em=emf.createEntityManager();
//	}

	public Avances ajouterAvance(Avances a) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.persist(a);
//		em.getTransaction().commit();
//		return a;
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(a);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return a;
	}

	public Avances getAvanceById(Long idAvance) {
		// TODO Auto-generated method stub
//		return em.find(Avances.class, idAvance);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Avances avance = new Avances();
		try {
			avance = em.find(Avances.class, idAvance);
			} finally {
			  em.close();
			}
		return avance;
	}

	public List<Avances> getAllAvances() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select a from Avances a");
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Avances> avances;
		Query query;
		try {
			query = em.createQuery("select a from Avances a");
			avances = query.getResultList();
			} finally {
			  em.close();
			}
		return avances;
	}
	

	public Avances modifierAvance(Avances a) {
//		em.getTransaction().begin();
//		em.merge(a);
//		em.getTransaction().commit();
//		return a;
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(a);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return a;
	}

	public void supprimerAvance(Long idAvance) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Avances a = em.find(Avances.class, idAvance);
//		em.remove(a);
//		em.getTransaction().commit();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Avances avance = new Avances();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  avance = em.find(Avances.class, idAvance);
				  em.remove(avance);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public List<Avances> getAllAvanceBySalarie(Long idSalarie) {
//		Query query = em.createQuery("select a from Avances a where a.salarie=" + idSalarie);
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Avances> avances;
		Query query;
		try {
			query = em.createQuery("select a from Avances a where a.salarie=" + idSalarie);
			avances = query.getResultList();
			} finally {
			  em.close();
			}
		return avances;
	}
}
