package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.Rubriques;

public class RubriqueDaoImpl implements IRubriques {

//	@PersistenceContext
//	private EntityManager em;
//	
//	public RubriqueDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public Rubriques ajouterRubrique(Rubriques r) {
//		em.getTransaction().begin();
//		em.persist(r);
//		em.getTransaction().commit();
//		return r;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(r);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return r;
	}

	public Rubriques getRubriquesById(Long idRubrique) {
		// TODO Auto-generated method stub
//		return em.find(Rubriques.class, idRubrique);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Rubriques rubrique = new Rubriques();
		try {
			rubrique = em.find(Rubriques.class, idRubrique);
			} finally {
			  em.close();
			}
		return rubrique;
	}

	public List<Rubriques> getAllRubriques() {
//		Query query = em.createQuery("select r from Rubriques r");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Rubriques> rubriques;
		Query query;
		try {
			query = em.createQuery("select r from Rubriques r");
			rubriques = query.getResultList();
			} finally {
			  em.close();
			}
		return rubriques;
	}

	public Rubriques modifierRubrique(Rubriques r) {
//		em.getTransaction().begin();
//		em.merge(r);
//		em.getTransaction().commit();
//		return r;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(r);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return r;
	}

	public void supprimerRubrique(Long idRubrique) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Rubriques r = em.find(Rubriques.class, idRubrique);
//		em.remove(r);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Rubriques rubrique = new Rubriques();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  rubrique = em.find(Rubriques.class, idRubrique);
				  em.remove(rubrique);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
		}
	}
}
