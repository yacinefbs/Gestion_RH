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

public class BanqueDaoImpl implements IBanque {

//	@PersistenceContext
//	private EntityManager em;
//	
//	public BanqueDaoImpl() {
//	 EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//	 em=emf.createEntityManager();
//	}


	public Banques ajouterBanque(Banques b) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.persist(b);
//		em.getTransaction().commit();
//		return b;
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(b);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return b;
	}

	public Banques getBanqueById(Long idBanque) {
		// TODO Auto-generated method stub
//		return em.find(Banques.class, idBanque);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Banques banque = new Banques();
		try {
			banque = em.find(Banques.class, idBanque);
			} finally {
			  em.close();
			}
		return banque;
	}

	public List<Banques> getAllBanques() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select b from Banques b");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Banques> banques;
		Query query;
		try {
			query = em.createQuery("select b from Banques b");
			banques = query.getResultList();
			} finally {
			  em.close();
			}
		return banques;
	}

	public Banques modifierBanque(Banques b){
//		em.getTransaction().begin();
//		em.merge(b);
//		em.getTransaction().commit();
//		return b;
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(b);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return b;
		
	}

	public void supprimerBanque(Long idBanque) {
//		em.getTransaction().begin();
//		Banques b = em.find(Banques.class, idBanque);
//		em.remove(b);
//		em.getTransaction().commit();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Banques banque = new Banques();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  banque = em.find(Banques.class, idBanque);
				  em.remove(banque);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}


	public Banques getBanqueByAgence(Long idAgence) {
//		Query query = em.createQuery("select b from Banques b, Agences a where a.banque = b.idBanque and a.idAgence=" + idAgence);
//		return (Banques) query.getResultList().get(0);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Banques banque = new Banques();
		Query query;
		try {
			query = em.createQuery("select b from Banques b, Agences a where a.banque = b.idBanque and a.idAgence=" + idAgence);
			banque = (Banques) query.getResultList().get(0);
			} finally {
			  em.close();
		}
		return banque;
	}
}
