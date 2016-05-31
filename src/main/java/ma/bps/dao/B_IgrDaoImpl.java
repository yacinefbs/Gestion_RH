package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.B_Anciennetes;
import ma.bps.entities.B_IGR;
import ma.bps.metier.ISocieteMetier;
import ma.bps.metier.SocieteMetierImpl;

public class B_IgrDaoImpl implements IB_IGR {

//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	
//	public B_IgrDaoImpl() {
//		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		 em=emf.createEntityManager();
//	}

	public B_IGR ajouterB_IGR(B_IGR b_IGR) {
		ISocieteMetier societeMetier = new SocieteMetierImpl();
		b_IGR.setSociete(societeMetier.getSocieteById(1L));
		
//		em.getTransaction().begin();
//		em.persist(b_IGR);
//		em.getTransaction().commit();
//		return b_IGR;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(b_IGR);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return b_IGR;
	}

	public B_IGR getB_IGRById(Long idB_IGR) {
		// TODO Auto-generated method stub
//		return em.find(B_IGR.class, idB_IGR);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		B_IGR b_IGR = new B_IGR();
		try {
			b_IGR = em.find(B_IGR.class, idB_IGR);
			} finally {
			  em.close();
			}
		return b_IGR;
	}

	public List<B_IGR> getAllB_IGRs() {
//		Query query = em.createQuery("select b from Baremes b where type_bareme='BI'");
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<B_IGR> b_IGR;
		Query query;
		try {
			query = em.createQuery("select b from Baremes b where type_bareme='BI'");
			b_IGR = query.getResultList();
			} finally {
			  em.close();
			}
		return b_IGR;
	}

	public B_IGR modifierB_IGR(B_IGR b_IGR) {
		b_IGR.getSociete().setIdSociete(1L);
		
//		em.getTransaction().begin();
//		em.merge(b_IGR);
//		em.getTransaction().commit();
//		return b_IGR;
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(b_IGR);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return b_IGR;
		
	}

	public void supprimerB_IGR(Long idB_Conge) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		B_IGR b = em.find(B_IGR.class, idB_Conge);
//		em.remove(b);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		B_IGR b_IGR = new B_IGR();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  b_IGR = em.find(B_IGR.class, idB_Conge);
				  em.remove(b_IGR);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public List<B_IGR> getBaremesIgrsByIdSociete(Long idSociete) {
//		Query query = em.createQuery("select b from Baremes b where type_bareme='BI' and b.societe=" + idSociete + " order by b.tranche1 ASC");
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<B_IGR> b_IGR;
		Query query;
		try {
			query = em.createQuery("select b from Baremes b where type_bareme='BI' and b.societe=" + idSociete + " order by b.tranche1 ASC");
			b_IGR = query.getResultList();
			} finally {
			  em.close();
			}
		return b_IGR;
	}
}
