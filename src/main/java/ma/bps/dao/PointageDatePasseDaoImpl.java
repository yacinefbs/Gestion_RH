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
import ma.bps.entities.PlanTravail;
import ma.bps.entities.PointageDatePasse;

public class PointageDatePasseDaoImpl implements IPointageDatePasse {

	
//	@PersistenceContext
//	private EntityManager em;
//	
//	public PointageDatePasseDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		 em=emf.createEntityManager();
//	}

	public void ajouterPointageDatePasse(PointageDatePasse p) {

//		em.getTransaction().begin();
//		em.persist(p);
//		em.getTransaction().commit();
		
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
	}

	public PointageDatePasse getPointageDatePasseById(Long idPointage) {
		// TODO Auto-generated method stub
//		return em.find(PointageDatePasse.class, idPointage);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PointageDatePasse pointageDatePasse = new PointageDatePasse();
		try {
			pointageDatePasse = em.find(PointageDatePasse.class, idPointage);
			} finally {
			  em.close();
			}
		return pointageDatePasse;
	}

	public List<PointageDatePasse> getAllPointageDatePasse() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select p from PointageDatePasse p");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<PointageDatePasse> pointageDatePasses;
		Query query;
		try {
			query = em.createQuery("select p from PointageDatePasse p");
			pointageDatePasses = query.getResultList();
			} finally {
			  em.close();
			}
		return pointageDatePasses;
	}

	public PointageDatePasse modifierPointageDatePasse(PointageDatePasse p) {
		// TODO Auto-generated method stub
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

	public void supprimerPointageDatePasse(Long idPointage) {

//		em.getTransaction().begin();
//		PointageDatePasse t = em.find(PointageDatePasse.class, idPointage);
//		em.remove(t);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PointageDatePasse pointageDatePasse = new PointageDatePasse();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  pointageDatePasse = em.find(PointageDatePasse.class, idPointage);
				  em.remove(pointageDatePasse);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

	public boolean getPointageDatePasseByDate(Date datePointage) {
		// TODO Auto-generated method stub
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		
//		Query query = em.createQuery("select p from PointageDatePasse p where p.jour='" + formatter.format(datePointage) + "'");
//				
//		if (query.getResultList().size()==0) 
//		{
//			return false;			
//		} 
//		else 
//		{
//			return true;
//		}
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		PointageDatePasse pointageDatePasse = new PointageDatePasse();
		Query query;
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			query = em.createQuery("select p from PointageDatePasse p where p.jour='" + formatter.format(datePointage) + "'");
				if (query.getResultList().size()==0) 
				{
					return false;			
				} 
				else 
				{
					return true;
				}
			
			} finally {
			  em.close();
			}
	}

}
