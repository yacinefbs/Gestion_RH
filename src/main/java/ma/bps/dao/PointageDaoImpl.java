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
import ma.bps.entities.Pointages;

public class PointageDaoImpl implements IPointage {
	
//	@PersistenceContext
//	private EntityManager em;
//	
//
//	public PointageDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		 em=emf.createEntityManager();
//	}

	public void ajouterPointage(Pointages p) {
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

	public Pointages getPointageById(Long idPointage) {
		// TODO Auto-generated method stub
//		return em.find(Pointages.class, idPointage);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Pointages pointage = new Pointages();
		try {
			pointage = em.find(Pointages.class, idPointage);
			} finally {
			  em.close();
			}
		return pointage;
	}

	public List<Pointages> getAllPointage() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select p from Pointages p");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Pointages> pointages;
		Query query;
		try {
			query = em.createQuery("select p from Pointages p");
			pointages = query.getResultList();
			} finally {
			  em.close();
			}
		return pointages;
	}

	public Pointages modifierPointage(Pointages p) {
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

	public void supprimerPointage(Long idPointage) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Pointages t = em.find(Pointages.class, idPointage);
//		em.remove(t);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Pointages pointage = new Pointages();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  pointage = em.find(Pointages.class, idPointage);
				  em.remove(pointage);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

	public List<Pointages> getPointageUnSalarie(long idSalarie) {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select p from Pointages p where p.salarie.idSalarie=" + idSalarie);
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Pointages> pointages;
		Query query;
		try {
			query = em.createQuery("select p from Pointages p where p.salarie.idSalarie=" + idSalarie);
			pointages = query.getResultList();
			} finally {
			  em.close();
			}
		return pointages;
	}

	public List<Pointages> chargerPointageSalarieUneDate(long idSalarie, Date dateVoulu) {

//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Query query = em.createQuery("select p from Pointages p where p.salarie.idSalarie=" + idSalarie + " and p.datePointage='" + formatter.format(dateVoulu) + "'");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Pointages> pointages;
		Query query;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			query = em.createQuery("select p from Pointages p where p.salarie.idSalarie=" + idSalarie + " and p.datePointage='" + formatter.format(dateVoulu) + "'");
			pointages = query.getResultList();
			} finally {
			  em.close();
			}
		return pointages;
	}

	public List<Pointages> chargerPointageSalarieUneDateEtDateDemain(long idSalarie, Date dateVoulu) {

//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date dateDemain = (Date) dateVoulu.clone();
//		dateDemain.setDate(dateDemain.getDate()+1);
//		
//		Query query = em.createQuery("select p from Pointages p where p.salarie.idSalarie=" + idSalarie + " and  (p.datePointage='" + formatter.format(dateVoulu) + "' or p.datePointage='" + formatter.format(dateDemain) + "')");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Pointages> pointages;
		Query query;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateDemain = (Date) dateVoulu.clone();
			dateDemain.setDate(dateDemain.getDate()+1);
			
			query = em.createQuery("select p from Pointages p where p.salarie.idSalarie=" + idSalarie + " and  (p.datePointage='" + formatter.format(dateVoulu) + "' or p.datePointage='" + formatter.format(dateDemain) + "')");
			pointages = query.getResultList();
			} finally {
			  em.close();
			}
		return pointages;
	}

	public boolean chercherSiPointageExist(Date datePointage, String heurePointage, Long idSalarie) {
		// TODO Auto-generated method stub
		
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Query query = em.createQuery("select p from Pointages p where p.salarie.idSalarie=" + idSalarie + " and p.datePointage='" + formatter.format(datePointage) + "' and p.heurePointage='" + heurePointage + "'");
//		List<Pointages> ls =  query.getResultList();
//		
//		if (ls.size()>0) 
//		{
//			return true;
//		} 
//		else 
//		{
//			return false;
//		}
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			query = em.createQuery("select p from Pointages p where p.salarie.idSalarie=" + idSalarie + " and p.datePointage='" + formatter.format(datePointage) + "' and p.heurePointage='" + heurePointage + "'");
			List<Pointages> ls =  query.getResultList();
			
			if (ls.size()>0) 
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
