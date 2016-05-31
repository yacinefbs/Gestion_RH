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
import ma.bps.entities.Services;

public class ServiceDaoImpl implements IService {

//	@PersistenceContext
//	private EntityManager em;
//	
//	public ServiceDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}



	public Services ajouterService(Services s) {
		// TODO Auto-generated method stub
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



	public Services getServiceById(Long idService) {
		// TODO Auto-generated method stub
//		return em.find(Services.class, idService);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Services service = new Services();
		try {
			service = em.find(Services.class, idService);
			} finally {
			  em.close();
			}
		return service;
	}



	public List<Services> getAllServices() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select s from Services s");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Services> services;
		Query query;
		try {
			query = em.createQuery("select s from Services s");
			services = query.getResultList();
			} finally {
			  em.close();
			}
		return services;
	}



	public Services modifierService(Services s) {
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



	public void supprimerService(Long idService) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Services b = em.find(Services.class, idService);
//		em.remove(b);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Services service = new Services();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  service = em.find(Services.class, idService);
				  em.remove(service);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
}
