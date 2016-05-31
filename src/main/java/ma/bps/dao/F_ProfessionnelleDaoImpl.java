package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.F_Initiale;
import ma.bps.entities.F_Professionnelles;

public class F_ProfessionnelleDaoImpl implements IF_Professionnelle {

//	@PersistenceContext
//	private EntityManager em;
//	
//	public F_ProfessionnelleDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public F_Professionnelles ajouterF_Pro(F_Professionnelles F_Professionnelles) {
//		em.getTransaction().begin();
//		em.persist(F_Professionnelles);
//		em.getTransaction().commit();
//		return F_Professionnelles;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(F_Professionnelles);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return F_Professionnelles;
	}

	public F_Professionnelles getF_ProfessionnellesById(Long idF_Professionnelles) {
		// TODO Auto-generated method stub
//		return em.find(F_Professionnelles.class, idF_Professionnelles);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		F_Professionnelles f_Professionnelles = new F_Professionnelles();
		try {
			f_Professionnelles = em.find(F_Professionnelles.class, idF_Professionnelles);
			} finally {
			  em.close();
			}
		return f_Professionnelles;
	}

	public List<F_Professionnelles> getAllF_Professionnelles() {
//		Query query = em.createQuery("select f from F_Professionnelles f");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<F_Professionnelles> f_Professionnelles;
		Query query;
		try {
			query = em.createQuery("select f from F_Professionnelles f");
			f_Professionnelles = query.getResultList();
			} finally {
			  em.close();
			}
		return f_Professionnelles;
	}

	public List<F_Professionnelles> getF_ProfessionnellesByIdSalarie(long idSalarie) {
//		Query query = em.createQuery("select f from F_Professionnelles f where f.salarie=" + idSalarie);
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<F_Professionnelles> f_Professionnelles;
		Query query;
		try {
			query = em.createQuery("select f from F_Professionnelles f where f.salarie=" + idSalarie);
			f_Professionnelles = query.getResultList();
			} finally {
			  em.close();
			}
		return f_Professionnelles;
	}

	public F_Professionnelles modifierF_Professionnelles(F_Professionnelles F_Professionnelles) {
//		em.getTransaction().begin();
//		em.merge(F_Professionnelles);
//		em.getTransaction().commit();
//		return F_Professionnelles;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(F_Professionnelles);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return F_Professionnelles;
	}

	public void supprimerF_Professionnelles(Long idF_Professionnelles) {
//		em.getTransaction().begin();
//		F_Professionnelles f = em.find(F_Professionnelles.class, idF_Professionnelles);
//		em.remove(f);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		F_Professionnelles f_Professionnelles = new F_Professionnelles();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  f_Professionnelles = em.find(F_Professionnelles.class, idF_Professionnelles);
				  em.remove(f_Professionnelles);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
}
