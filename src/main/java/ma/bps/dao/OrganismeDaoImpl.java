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
import ma.bps.entities.Organismes;

public class OrganismeDaoImpl implements IOrganisme {

//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public OrganismeDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public Organismes ajouterOrganisme(Organismes o) {
//		em.getTransaction().begin();
//		em.persist(o);
//		em.getTransaction().commit();
//		return o;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(o);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return o;
	}

	public Organismes getOrganismeById(Long idOrganisme) {
		// TODO Auto-generated method stub
//		return em.find(Organismes.class, idOrganisme);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Organismes organisme = new Organismes();
		try {
			organisme = em.find(Organismes.class, idOrganisme);
			} finally {
			  em.close();
			}
		return organisme;
	}

	public List<Organismes> getAllOrganismes() {
//		Query query = em.createQuery("select o from Organismes o");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Organismes> organismes;
		Query query;
		try {
			query = em.createQuery("select o from Organismes o");
			organismes = query.getResultList();
			} finally {
			  em.close();
			}
		return organismes;
	}

	public Organismes modifierOrganismes(Organismes o) {
//		em.getTransaction().begin();
//		em.merge(o);
//		em.getTransaction().commit();
//		return o;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(o);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return o;
	}

	public void supprimerOrganisme(Long idOrganisme) {
//		em.getTransaction().begin();
//		Organismes o = em.find(Organismes.class, idOrganisme);
//		em.remove(o);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Organismes organisme = new Organismes();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  organisme = em.find(Organismes.class, idOrganisme);
				  em.remove(organisme);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
		}
	}
}
