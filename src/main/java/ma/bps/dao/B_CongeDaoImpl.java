package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.B_Conges;
import ma.bps.entities.Banques;
import ma.bps.entities.Societes;
import ma.bps.metier.ISocieteMetier;
import ma.bps.metier.SocieteMetierImpl;

public class B_CongeDaoImpl implements IB_Conge {

//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public B_CongeDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public B_Conges ajouterB_Conge(B_Conges c) {
//		c.getSociete().setIdSociete(1L);
		ISocieteMetier societeMetier = new SocieteMetierImpl();
		c.setSociete(societeMetier.getSocieteById(1L));
		
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

	public B_Conges getB_CongeById(Long idB_Conge) {
		// TODO Auto-generated method stub
//		return em.find(B_Conges.class, idB_Conge);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		B_Conges b_Conges = new B_Conges();
		try {
			b_Conges = em.find(B_Conges.class, idB_Conge);
			} finally {
			  em.close();
			}
		return b_Conges;
	}

	public List<B_Conges> getAllB_Conges() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select b from Baremes b where type_bareme='BC'");
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<B_Conges> b_Conges;
		Query query;
		try {
			query = em.createQuery("select b from Baremes b where type_bareme='BC'");
			b_Conges = query.getResultList();
			} finally {
			  em.close();
			}
		return b_Conges;
	}

	public B_Conges modifierB_Conge(B_Conges c) {
		c.getSociete().setIdSociete(1L);
		
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

	public void supprimerB_Conge(Long idB_Conge) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		B_Conges c = em.find(B_Conges.class, idB_Conge);
//		em.remove(c);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		B_Conges b_Conges = new B_Conges();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  b_Conges = em.find(B_Conges.class, idB_Conge);
				  em.remove(b_Conges);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public List<B_Conges> getBaremesCongesByIdSociete(Long idSociete) {
//		Query query = em.createQuery("select b from Baremes b where type_bareme='BC' and b.societe=" + idSociete + " order by b.tranche1 ASC");
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<B_Conges> b_Conges;
		Query query;
		try {
			query = em.createQuery("select b from Baremes b where type_bareme='BC' and b.societe=" + idSociete + " order by b.tranche1 ASC");
			b_Conges = query.getResultList();
			} finally {
			  em.close();
			}
		return b_Conges;
	}

}
