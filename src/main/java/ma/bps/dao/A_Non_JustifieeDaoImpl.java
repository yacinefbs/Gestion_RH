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
import ma.bps.entities.Groupes;
import ma.bps.entities.TauxFraisPro;

public class A_Non_JustifieeDaoImpl implements IA_Non_Justifiee {
	
//	
//	@PersistenceContext
//	private EntityManager em;
//	
//
//	public A_Non_JustifieeDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public void ajouterA_Non_Justifiee(A_Non_Justifiee a) {
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

	public A_Non_Justifiee getA_Non_JustifieeById(Long idA_Non_Justifiee) {
		// TODO Auto-generated method stub
//		return em.find(A_Non_Justifiee.class, idA_Non_Justifiee);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		A_Non_Justifiee a_Non_Justifiee = new A_Non_Justifiee();
		Query query;
		try {
			a_Non_Justifiee = em.find(A_Non_Justifiee.class, idA_Non_Justifiee);
			} finally {
			  em.close();
			}
		return a_Non_Justifiee;
	}

	public List<A_Non_Justifiee> getAllA_Non_Justifiee() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select g from A_Non_Justifiee g");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<A_Non_Justifiee> a_Non_Justifiees;
		Query query;
		try {
			query = em.createQuery("select g from A_Non_Justifiee g");
			a_Non_Justifiees = query.getResultList();
			} finally {
			  em.close();
			}
		return a_Non_Justifiees;
	}

	public A_Non_Justifiee modifierA_Non_Justifiee(A_Non_Justifiee a) {
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

	public void supprimerA_Non_Justifiee(Long idA_Non_Justifiee) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		A_Non_Justifiee g = em.find(A_Non_Justifiee.class, idA_Non_Justifiee);
//		em.remove(g);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		A_Non_Justifiee a_Non_Justifiee = new A_Non_Justifiee();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  a_Non_Justifiee = em.find(A_Non_Justifiee.class, idA_Non_Justifiee);
				  em.remove(a_Non_Justifiee);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
		}
	}
}
