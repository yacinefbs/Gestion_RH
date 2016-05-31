package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.ModePaiements;

public class ModePaiementDaoImpl implements IModePaiement {

//	@PersistenceContext
//	private EntityManager em;
//	
//	public ModePaiementDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		 em=emf.createEntityManager();
//	}



	public List<ModePaiements> getAllModePaiement() {
//		Query query = em.createQuery("select m from ModePaiements m");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<ModePaiements> modePaiements;
		Query query;
		try {
			query = em.createQuery("select m from ModePaiements m");
			modePaiements = query.getResultList();
			} finally {
			  em.close();
			}
		return modePaiements;
	}

	
	public ModePaiements getModePaiementById(Long idMode) {
		// TODO Auto-generated method stub
//		ModePaiements mode = em.find(ModePaiements.class, idMode);
//		return mode;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		ModePaiements modePaiement = new ModePaiements();
		try {
			modePaiement = em.find(ModePaiements.class, idMode);
			} finally {
			  em.close();
			}
		return modePaiement;
	}



	public ModePaiements ajouterModePaiment(ModePaiements mode) {
//		em.getTransaction().begin();
//		em.persist(mode);
//		em.getTransaction().commit();
//		return mode;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(mode);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return mode;
	}
}
