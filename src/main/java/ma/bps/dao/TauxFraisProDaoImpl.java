package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Banques;
import ma.bps.entities.TauxFraisPro;

public class TauxFraisProDaoImpl implements ITauxFraisPro {

//	@PersistenceContext
//	EntityManager em;
//	public TauxFraisProDaoImpl() {
//		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//	}

	public TauxFraisPro ajouterTauxFraisPro(TauxFraisPro t) {
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(t);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return t;
	}

	public TauxFraisPro getTauxFraisProById(Long idTauxFraisPro) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		TauxFraisPro tfp = new TauxFraisPro();
		Query query;
		List<TauxFraisPro> list;
		try {
			tfp = em.find(TauxFraisPro.class, idTauxFraisPro);
			} finally {
			  em.close();
			}
		return tfp;
	}

	public List<TauxFraisPro> getAllTauxFraisPros() {
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		List<TauxFraisPro> list;
		try {
			query = em.createQuery("select t from TauxFraisPro t");
			System.out.println("taille : " + query.getResultList().size());
			list = query.getResultList();
			} finally {
			  em.close();
			}
		return list;
	}

	public TauxFraisPro modifierTauxFraisPro(TauxFraisPro t) {
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(t);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return t;
	}

	public void supprimerTauxFraisPro(Long idTauxFraisPro) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		TauxFraisPro tfp = new TauxFraisPro();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  tfp = em.find(TauxFraisPro.class, idTauxFraisPro);
				  em.remove(tfp);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

}
