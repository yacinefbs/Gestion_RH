package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.Banques;
import ma.bps.entities.Sites;

public class SiteDaoImpl implements ISite {

//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public SiteDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		 em=emf.createEntityManager();
//	}

	public Sites ajouterSite(Sites s) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.persist(s);
//		em.getTransaction().commit();
//		return s;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
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

	public Sites getSiteById(Long idSite) {
		// TODO Auto-generated method stub
//		return em.find(Sites.class, idSite);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Sites site = new Sites();
		try {
			site = em.find(Sites.class, idSite);
			} finally {
			  em.close();
			}
		return site;
	}

	public List<Sites> getAllSites() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select s from Sites s");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Sites> sites;
		Query query;
		try {
			query = em.createQuery("select s from Sites s");
			sites = query.getResultList();
			} finally {
			  em.close();
			}
		return sites;
	}

	public Sites modifierSite(Sites s) {
		// TODO Auto-generated method stub
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

	public void supprimerSite(Long idSite) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Sites s = em.find(Sites.class, idSite);
//		em.remove(s);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Sites site = new Sites();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  site = em.find(Sites.class, idSite);
				  em.remove(site);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
}
