package ma.bps.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.Qualifications;

public class QualificationDaoImpl implements IQualification {

//	@PersistenceContext
//	private EntityManager em;
//	
//	public QualificationDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		 em=emf.createEntityManager();
//	}

	public Qualifications ajouterQualification(Qualifications q) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.persist(q);
//		em.getTransaction().commit();
//		return q;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(q);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return q;
		
	}

	public Qualifications getQualificationById(Long idQualification) {
		// TODO Auto-generated method stub
//		return em.find(Qualifications.class, idQualification);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Qualifications qualification = new Qualifications();
		try {
			qualification = em.find(Qualifications.class, idQualification);
			} finally {
			  em.close();
		}
		return qualification;
	}

	public List<Qualifications> getAllQualifications() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select q from Qualifications q");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Qualifications> qualifications;
		Query query;
		try {
			query = em.createQuery("select q from Qualifications q");
			qualifications = query.getResultList();
			} finally {
			  em.close();
			}
		return qualifications;
	}

	public Qualifications modifierQualification(Qualifications q) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.merge(q);
//		em.getTransaction().commit();
//		return q;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(q);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return q;
	}

	public void supprimerQualification(Long idQualification) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Qualifications q = em.find(Qualifications.class, idQualification);
//		em.remove(q);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Qualifications qualifications = new Qualifications();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  qualifications = em.find(Qualifications.class, idQualification);
				  em.remove(qualifications);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
		}
	}
}
