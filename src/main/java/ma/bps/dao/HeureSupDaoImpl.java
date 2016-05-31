package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.bps.entities.Groupes;
import ma.bps.entities.HeureSupplementaire;

public class HeureSupDaoImpl implements IHeureSup {

	public void ajouterHeureSup(HeureSupplementaire h) {
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(h);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

	public HeureSupplementaire getHeureSupById(Long idHeureSup) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		HeureSupplementaire heure = new HeureSupplementaire();
		try {
			heure = em.find(HeureSupplementaire.class, idHeureSup);
			} finally {
			  em.close();
			}
		return heure;
		
	}

	public List<HeureSupplementaire> getAllHeureSup() {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<HeureSupplementaire> heure;
		Query query;
		try {
			query = em.createQuery("select g from HeureSupplementaire g");
			heure = query.getResultList();
			} finally {
			  em.close();
			}
		return heure;
		
	}

	public HeureSupplementaire modifierHeureSup(HeureSupplementaire h) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(h);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return h;
		
	}

	public void supprimerHeureSup(Long idHeureSup) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		HeureSupplementaire heure = new HeureSupplementaire();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  heure = em.find(HeureSupplementaire.class, idHeureSup);
				  em.remove(heure);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

}
