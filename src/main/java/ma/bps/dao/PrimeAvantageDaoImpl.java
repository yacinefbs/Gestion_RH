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
import ma.bps.entities.PrimesAvantages;

public class PrimeAvantageDaoImpl implements IPrimeAvantage {

	
//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public PrimeAvantageDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public PrimesAvantages ajouterPrimesAvantage(PrimesAvantages p) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.persist(p);
//		em.getTransaction().commit();
//		return p;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(p);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return p;
		
	}

	public PrimesAvantages getPrimesAvantageById(Long idPrimesAvantage) {
		// TODO Auto-generated method stub
//		return em.find(PrimesAvantages.class, idPrimesAvantage);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PrimesAvantages primesAvantage = new PrimesAvantages();
		try {
			primesAvantage = em.find(PrimesAvantages.class, idPrimesAvantage);
			} finally {
			  em.close();
			}
		return primesAvantage;
	}

	public List<PrimesAvantages> getAllPrimesAvantages() {
//		Query query = em.createQuery("select b from PrimesAvantages b");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<PrimesAvantages> primesAvantages;
		Query query;
		try {
			query = em.createQuery("select b from PrimesAvantages b");
			primesAvantages = query.getResultList();
			} finally {
			  em.close();
			}
		return primesAvantages;
	}

	public PrimesAvantages modifierPrimesAvantage(PrimesAvantages p) {
//		em.getTransaction().begin();
//		em.merge(p);
//		em.getTransaction().commit();
//		return p;
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(p);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return p;
	}

	public void supprimerPrimesAvantages(Long idPrimesAvantage) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		PrimesAvantages p = em.find(PrimesAvantages.class, idPrimesAvantage);
//		em.remove(p);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PrimesAvantages primesAvantage = new PrimesAvantages();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  primesAvantage = em.find(PrimesAvantages.class, idPrimesAvantage);
				  em.remove(primesAvantage);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
	
	public PrimesAvantages getPrimeAvantageByIdSalarie(Long idSalarie) {
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PrimesAvantages primesAvantage = new PrimesAvantages();
		Query query;
		try {
			query = em.createQuery("select b from PrimesAvantages b, Salaries s where b.salarie=s.idSalarie and s.idSalarie=" + idSalarie);
			primesAvantage = (PrimesAvantages) query.getResultList().get(0);
			System.out.println("prime : " + primesAvantage.getValeur());
			} finally {
			  em.close();
			}
		return primesAvantage;
		}
}
