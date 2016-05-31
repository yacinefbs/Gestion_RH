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
import ma.bps.entities.B_Conges;
import ma.bps.entities.Banques;
import ma.bps.metier.ISocieteMetier;
import ma.bps.metier.SocieteMetierImpl;

public class B_AncienneteDaoImpl implements IB_Anciennete {

//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	
//	
//	public B_AncienneteDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public B_Anciennetes ajouterB_Anciennetes(B_Anciennetes b_anciennete) {
		ISocieteMetier societeMetier = new SocieteMetierImpl();
		b_anciennete.setSociete(societeMetier.getSocieteById(1L));
		b_anciennete.getSociete().setIdSociete(1L);
		
//		em.getTransaction().begin();
//		em.persist(b_anciennete);
//		em.getTransaction().commit();
//		return b_anciennete;
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(b_anciennete);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return b_anciennete;
	}

	public B_Anciennetes getB_AnciennetesById(Long idBAnciennete) {
		// TODO Auto-generated method stub
//		return em.find(B_Anciennetes.class, idBAnciennete);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		B_Anciennetes b_Anciennetes = new B_Anciennetes();
		try {
			b_Anciennetes = em.find(B_Anciennetes.class, idBAnciennete);
			} finally {
			  em.close();
			}
		return b_Anciennetes;
	}

	public List<B_Anciennetes> getAllB_Anciennetes() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select b from Baremes b where type_bareme='BA'");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<B_Anciennetes> b_Anciennetes;
		Query query;
		try {
			query = em.createQuery("select b from Baremes b where type_bareme='BA'");
			b_Anciennetes = query.getResultList();
			} finally {
			  em.close();
			}
		return b_Anciennetes;
	}

	public B_Anciennetes modifierB_Anciennete(B_Anciennetes BAnciennete) {
		// TODO Auto-generated method stub
//		BAnciennete.getSociete().setIdSociete(1L);
//		em.getTransaction().begin();
//		em.merge(BAnciennete);
//		em.getTransaction().commit();
//		return BAnciennete;
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(BAnciennete);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return BAnciennete;
	}

	public void supprimerB_Anciennetes(Long idB_anciennete) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		B_Anciennetes b = em.find(B_Anciennetes.class, idBanque);
//		em.remove(b);
//		em.getTransaction().commit();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		B_Anciennetes b_Anciennetes = new B_Anciennetes();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  b_Anciennetes = em.find(B_Anciennetes.class, idB_anciennete);
				  em.remove(b_Anciennetes);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
	public List<B_Anciennetes> getBaremesAnciennetesByIdSociete(Long idSociete) {
//		Query query = em.createQuery("select b from Baremes b where type_bareme='BA' and b.societe=" + idSociete + " order by b.tranche1 ASC");
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<B_Anciennetes> b_Anciennetes;
		Query query;
		try {
			query = em.createQuery("select b from Baremes b where type_bareme='BA' and b.societe=" + idSociete + " order by b.tranche1 ASC");
			b_Anciennetes = query.getResultList();
			} finally {
			  em.close();
			}
		return b_Anciennetes;
	}
}
