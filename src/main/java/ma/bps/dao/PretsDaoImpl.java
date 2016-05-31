package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.Banques;
import ma.bps.entities.Prets;

public class PretsDaoImpl implements IPrets {

	
//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public PretsDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public Prets ajouterPret(Prets p) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.persist(p);
//		em.getTransaction().commit();
//		
//		return p;
		
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
		return p;
	}

	public Prets getPretById(Long idPret) {
		// TODO Auto-generated method stub
//		return em.find(Prets.class, idPret);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Prets pret = new Prets();
		try {
			pret = em.find(Prets.class, idPret);
			} finally {
			  em.close();
			}
		return pret;
	}

	public List<Prets> getAllPrets() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select s from Prets p");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Prets> prets;
		Query query;
		try {
			query = em.createQuery("select p from Prets p");
			prets = query.getResultList();
			} finally {
			  em.close();
			}
		return prets;
		
	}

	public Prets modifierPrets(Prets p) {
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

	public void supprimerPret(Long idPret) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Prets p = em.find(Prets.class, idPret);
//		em.remove(p);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Prets prets = new Prets();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  prets = em.find(Prets.class, idPret);
				  em.remove(prets);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public List<Prets> getAllPretsBySalarie(Long idSalarie) {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select p from Prets p where p.salarie=" + idSalarie);
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Prets> prets;
		Query query;
		try {
			query = em.createQuery("select p from Prets p where p.salarie=" + idSalarie);
			prets = query.getResultList();
			} finally {
			  em.close();
			}
		return prets;
	}
}
