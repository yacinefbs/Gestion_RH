package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.AdressesPro;
import ma.bps.entities.Agences;
import ma.bps.entities.Banques;
import ma.bps.entities.TauxFraisPro;

public class AgenceDaoImpl implements IAgence {

//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public AgenceDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		 em=emf.createEntityManager();
//	}

	public Agences ajouterAgence(Agences a) {
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

	public Agences getAgenceById(Long idAgence) {
		// TODO Auto-generated method stub
//		return em.find(Agences.class, idAgence);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Agences agence = new Agences();
		try {
			agence = em.find(Agences.class, idAgence);
			} finally {
			  em.close();
			}
		return agence;
	}

	public List<Agences> getAllAgences() {
//		Query query = em.createQuery("select a from Agences a");
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Agences> agences;
		Query query;
		try {
			query = em.createQuery("select a from Agences a");
			agences = query.getResultList();
			} finally {
			  em.close();
			}
		return agences;
	}

	public Agences modifierAgence(Agences a) {
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

	public void supprimerAgence(Long idAgence) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Agences a = em.find(Agences.class, idAgence);
//		em.remove(a);
//		em.getTransaction().commit();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Agences agence = new Agences();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  agence = em.find(Agences.class, idAgence);
				  em.remove(agence);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
	public List<Agences> getAllAgencesByBanque(Long idBanque) {
//		Query query = em.createQuery("select a from Agences a where a.banque=" + idBanque);
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Agences> agences;
		Query query;
		try {
			query = em.createQuery("select a from Agences a where a.banque=" + idBanque);
			agences = query.getResultList();
			} finally {
			  em.close();
			}
		return agences;
	}
}
