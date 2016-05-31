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

public class F_InitialeDaoImpl implements IF_Initiale {

	
//	@PersistenceContext
//	private EntityManager em;
//	
//	public F_InitialeDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public F_Initiale ajouterF_Initiale(F_Initiale F_Initiale) {
//		em.getTransaction().begin();
//		em.persist(F_Initiale);
//		em.getTransaction().commit();
//		return F_Initiale;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(F_Initiale);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return F_Initiale;
	}

	public F_Initiale getF_InitialeById(Long idF_Initiale) {
		// TODO Auto-generated method stub
//		return em.find(F_Initiale.class, idF_Initiale);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		F_Initiale f_Initiale = new F_Initiale();
		try {
			f_Initiale = em.find(F_Initiale.class, idF_Initiale);
			} finally {
			  em.close();
			}
		return f_Initiale;
	}

	public List<F_Initiale> getAllF_Initiales() {
//		Query query = em.createQuery("select f from F_Initiale f");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<F_Initiale> f_Initiales;
		Query query;
		try {
			query = em.createQuery("select f from F_Initiale f");
			f_Initiales = query.getResultList();
			} finally {
			  em.close();
			}
		return f_Initiales;
	}

	public List<F_Initiale> getF_InitialeByIdSalarie(long idSalarie) {
//		Query query = em.createQuery("select f from F_Initiale f where f.salarie=" + idSalarie);
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<F_Initiale> f_Initiales;
		Query query;
		try {
			query = em.createQuery("select f from F_Initiale f where f.salarie=" + idSalarie);
			f_Initiales = query.getResultList();
			} finally {
			  em.close();
			}
		return f_Initiales;
	}

	public F_Initiale modifierF_Initiale(F_Initiale f_Initiale) {
//		em.getTransaction().begin();
//		em.merge(f_Initiale);
//		em.getTransaction().commit();
//		return f_Initiale;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(f_Initiale);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return f_Initiale;
	}

	public void supprimerF_Initiale(Long idF_Initiale) {
//		em.getTransaction().begin();
//		F_Initiale f = em.find(F_Initiale.class, idF_Initiale);
//		em.remove(f);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		F_Initiale f_Initiale = new F_Initiale();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  f_Initiale = em.find(F_Initiale.class, idF_Initiale);
				  em.remove(f_Initiale);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
}
