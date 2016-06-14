package ma.bps.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.A_Justifiee;
import ma.bps.entities.Groupes;
import ma.bps.entities.JourFeries;

public class JoursFeriesDaoImpl implements IJoursFeries {
	
	
	
//	@PersistenceContext
//	private EntityManager em;
//
//	public JoursFeriesDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public void ajouterJourFeries(JourFeries j) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.persist(j);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(j);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public JourFeries getJourFeriesById(Long idJourFeries) {
		// TODO Auto-generated method stub
//		return em.find(JourFeries.class, idJourFeries);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		JourFeries jourFerie = new JourFeries();
		try {
			jourFerie = em.find(JourFeries.class, idJourFeries);
			} finally {
			  em.close();
			}
		return jourFerie;
	}

	public List<JourFeries> getAllJourFeries() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select j from JourFeries j");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<JourFeries> jourFeries;
		Query query;
		try {
			query = em.createQuery("select j from JourFeries j");
			jourFeries = query.getResultList();
			} finally {
			  em.close();
			}
		return jourFeries;
	}

	public JourFeries modifierJourFeries(JourFeries j) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.merge(j);
//		em.getTransaction().commit();
//		return j;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(j);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return j;
	}

	public void supprimerJourFeries(Long idJourFeries) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		JourFeries g = em.find(JourFeries.class, idJourFeries);
//		em.remove(g);
//		em.getTransaction().commit();	
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		JourFeries jourFerie = new JourFeries();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  jourFerie = em.find(JourFeries.class, idJourFeries);
				  em.remove(jourFerie);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public boolean testerSiJourFerie(Date dateVoulu) {
		// TODO Auto-generated method stub
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");		
//		Query query = em.createQuery("select j from JourFeries j where j.dateF='" + formatter.format(dateVoulu) + "'");
//		if (query.getResultList().size()>0) 
//		{
//			return true;
//		} 
//		else 
//		{
//			return false;
//		}	
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");		
			Query query = em.createQuery("select j from JourFeries j where '" + formatter.format(dateVoulu) + "' between j.dateDebut and j.dateFin");
			if (query.getResultList().size()>0) 
			{
				return true;
			} 
			else 
			{
				return false;
			}	
			} finally {
			  em.close();
			}
	}
}
