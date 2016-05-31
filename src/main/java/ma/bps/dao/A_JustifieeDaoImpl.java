package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.A_Justifiee;
import ma.bps.entities.A_Non_Justifiee;
import ma.bps.entities.AdressesPrivee;
import ma.bps.entities.TauxFraisPro;

public class A_JustifieeDaoImpl implements IA_Justifiee {
	
//	@PersistenceContext
//	private EntityManager em;
//	
//
//	public A_JustifieeDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public void ajouterA_Justifiee(A_Justifiee a) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.persist(a);
//		em.getTransaction().commit();
		
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
	}

	public A_Justifiee getA_JustifieeById(Long idA_Justifiee) {
		// TODO Auto-generated method stub
//		return em.find(A_Justifiee.class, idA_Justifiee);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		A_Justifiee a_Justifiee = new A_Justifiee();
		try {
			a_Justifiee = em.find(A_Justifiee.class, idA_Justifiee);
			} finally {
			  em.close();
			}
		return a_Justifiee;
	}

	public List<A_Justifiee> getAllA_Justifiee() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select g from A_Justifiee g");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<A_Justifiee> a_Justifiees;
		Query query;
		try {
			query = em.createQuery("select g from A_Justifiee g");
			a_Justifiees = query.getResultList();
			} finally {
			  em.close();
			}
		return a_Justifiees;
	}

	public A_Justifiee modifierA_Justifiee(A_Justifiee a) {
		// TODO Auto-generated method stub
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

	public void supprimerA_Justifiee(Long idA_Justifiee) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		A_Justifiee g = em.find(A_Justifiee.class, idA_Justifiee);
//		em.remove(g);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		A_Justifiee a_Justifiee = new A_Justifiee();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  a_Justifiee = em.find(A_Justifiee.class, idA_Justifiee);
				  em.remove(a_Justifiee);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
}
