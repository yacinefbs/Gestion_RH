package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.Cotisations;
import ma.bps.entities.Organismes;

public class CotisationDaoImpl implements ICotisation {
	
//	@PersistenceContext
//	private EntityManager em;
//	
//	public CotisationDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public Cotisations ajouterCotisation(Cotisations c) {
//		em.getTransaction().begin();
//		em.persist(c);
//		em.getTransaction().commit();
//		return c;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(c);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return c;
	}

	public Cotisations getCotisationsById(Long idCotisation) {
		// TODO Auto-generated method stub
//		return em.find(Cotisations.class, idCotisation);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Cotisations cotisation = new Cotisations();
		try {
			cotisation =em.find(Cotisations.class, idCotisation);
			} finally {
			  em.close();
			}
		return cotisation;
	}

	public List<Cotisations> getAllCotisations() {
//		Query query = em.createQuery("select c from Cotisations c");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Cotisations> cotisations;
		Query query;
		try {
			query = em.createQuery("select c from Cotisations c");
			cotisations = query.getResultList();
			} finally {
			  em.close();
			}
		return cotisations;
	}

	public Cotisations modifierCotisation(Cotisations c) {
//		em.getTransaction().begin();
//		em.merge(c);
//		em.getTransaction().commit();
//		return c;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(c);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return c;
	}

	public void supprimerCotisation(Long idCotisation) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Cotisations c = em.find(Cotisations.class, idCotisation);
//		em.remove(c);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Cotisations cotisation = new Cotisations();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  cotisation = em.find(Cotisations.class, idCotisation);
				  em.remove(cotisation);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
}
