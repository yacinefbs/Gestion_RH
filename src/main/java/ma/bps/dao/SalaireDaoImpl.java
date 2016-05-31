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
import ma.bps.entities.Salaires;
import ma.bps.entities.Salaries;

public class SalaireDaoImpl implements ISalaire {

	
//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public SalaireDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public Salaires ajouterSalaire(Salaires s) {
//		em.getTransaction().begin();
//		em.persist(s);
//		em.getTransaction().commit();
//		return s;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(s);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return s;
	}

	public Salaires getSalaireById(Long idSalaire) {
//		return em.find(Salaires.class, idSalaire);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Salaires salaire = new Salaires();
		try {
			salaire = em.find(Salaires.class, idSalaire);
			} finally {
			  em.close();
			}
		return salaire;
	}

	public List<Salaires> getAllSalaires() {
//		Query query = em.createQuery("select s from Salaires s");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Salaires> salaires;
		Query query;
		try {
			query = em.createQuery("select s from Salaires s");
			salaires = query.getResultList();
			} finally {
			  em.close();
			}
		return salaires;
	}
	public Salaires modifierSalaire(Salaires s) {
//		em.getTransaction().begin();
//		em.merge(s);
//		em.getTransaction().commit();
//		return s;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(s);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return s;
	}
	
	
	public void supprimerSalaire(Long idSalaire) {
//		em.getTransaction().begin();
//		Salaires s = em.find(Salaires.class, idSalaire);
//		em.remove(s);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Salaires salaires = new Salaires();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  salaires = em.find(Salaires.class, idSalaire);
				  em.remove(salaires);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
	
	public Salaires getSalaireByIdSalarie(Long idSalarie) {
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Salaires salaire = new Salaires();
		Query query;
		try {
			query = em.createQuery("select s from Salaires s, Salaries sal where sal.salaire = s.idSalaire and sal.idSalarie=" + idSalarie);
			salaire = (Salaires) query.getResultList().get(0);
			} finally {
			  em.close();
			}
		return salaire;
		}
}
