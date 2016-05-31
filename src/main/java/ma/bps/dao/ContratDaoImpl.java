package ma.bps.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.validator.util.Contracts;

import defaults.typeContrat;
import ma.bps.entities.Conges;
//import ma.bps.entities.ANAPEC;
//import ma.bps.entities.CDD;
//import ma.bps.entities.CDI;
import ma.bps.entities.Contrats;
//import ma.bps.entities.Occasionnel;

public class ContratDaoImpl implements IContrat {

//	@PersistenceContext
//	private EntityManager em;
//	
//	public ContratDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public Contrats ajouterContrat(Contrats contrat) {
//		em.getTransaction().begin();
//		em.persist(contrat);
//		em.getTransaction().commit();
//		return contrat;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(contrat);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return contrat;
	}

	public Contrats getContratById(Long idContrat) {
//		return em.find(Contrats.class, idContrat);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Contrats contrat = new Contrats();
		try {
			contrat = em.find(Contrats.class, idContrat);
			} finally {
			  em.close();
			}
		return contrat;
	}

	public List<Contrats> getAllContrats() {
//		Query query = em.createQuery("select c from Contrats c");
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Contrats> contrats;
		Query query;
		try {
			query = em.createQuery("select c from Contrats c");
			contrats = query.getResultList();
			} finally {
			  em.close();
			}
		return contrats;
	}

	public List<Contrats> getContratByIdSalarie(Long idSalarie) {
//		Query query = em.createQuery("select c from Contrats c where c.salarie.idSalarie=" + idSalarie);
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Contrats> contrats;
		Query query;
		try {
			query = em.createQuery("select c from Contrats c where c.salarie.idSalarie=" + idSalarie);
			contrats = query.getResultList();
			} finally {
			  em.close();
			}
		return contrats;
	}

	public Contrats modifierContrat(Contrats Contrat) {
//		em.getTransaction().begin();
//		em.merge(Contrat);
//		em.getTransaction().commit();
//		return Contrat;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(Contrat);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return Contrat;
	}

	public void supprimerContrat(Long idContrat) {
//		em.getTransaction().begin();
//		Contrats c = em.find(Contrats.class, idContrat);
//		em.remove(c);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Contrats c = new Contrats();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  c = em.find(Contrats.class, idContrat);
				  em.remove(c);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public Date dateDebutContrat(Long idSalarie) {
//		Query query = em.createQuery("select MIN(c.dateDebutContrat) from Contrats c where c.salarie.idSalarie=" + idSalarie);
//		return (Date) query.getResultList().get(0);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Date date;
		try {
			Query query = em.createQuery("select MIN(c.dateDebutContrat) from Contrats c where c.salarie.idSalarie=" + idSalarie);
			date =  (Date) query.getResultList().get(0);
			} finally {
			  em.close();
			}
		return date;
	}
}
