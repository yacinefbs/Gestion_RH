package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.Societes;

public class SocieteDaoImpl implements ISociete {

//	@PersistenceContext
//	private EntityManager em;
//	
//	public SocieteDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		 em=emf.createEntityManager();
//	}

	public Societes ajouterSociete(Societes s) {
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

	public Societes getSocieteById(Long idSociete) {
		// TODO Auto-generated method stub
//		return em.find(Societes.class, idSociete);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Societes societe = new Societes();
		try {
			societe = em.find(Societes.class, idSociete);
			} finally {
			  em.close();
			}
		return societe;
	}

	public List<Societes> getAllSocietes() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select s from Societes s");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Societes> societes;
		Query query;
		try {
			query = em.createQuery("select s from Societes s");
			societes = query.getResultList();
			} finally {
			  em.close();
			}
		return societes;
	}

	public Societes modifierSociete(Societes s) {
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

	public void supprimerSociete(Long idSociete) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Societes s = em.find(Societes.class, idSociete);
//		em.remove(s);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Societes societe = new Societes();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  societe = em.find(Societes.class, idSociete);
				  em.remove(societe);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
}
