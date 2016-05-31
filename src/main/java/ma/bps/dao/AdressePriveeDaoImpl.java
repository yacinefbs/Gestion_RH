package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.AdressesPrivee;
import ma.bps.entities.AdressesPro;
import ma.bps.entities.TauxFraisPro;

public class AdressePriveeDaoImpl implements IAdressePrivee {

//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public AdressePriveeDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public AdressesPrivee ajouterAdressePrivee(AdressesPrivee a) {
//		em.getTransaction().begin();
//		
//		em.persist(a);
//		em.getTransaction().commit();
//		return a;
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
		return a;
	}

	public AdressesPrivee getAdressePriveeById(Long idAdressePrivee) {
//		// TODO Auto-generated method stub
//		return em.find(AdressesPrivee.class, idAdressePrivee);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AdressesPrivee adresse = new AdressesPrivee();
		Query query;
		List<TauxFraisPro> list;
		try {
			adresse = em.find(AdressesPrivee.class, idAdressePrivee);
			} finally {
			  em.close();
			}
		return adresse;
	}

	public AdressesPrivee getAdressesPriveeBySalarie(Long idSalarie) {
//		Query query = em.createQuery("select a from AdressesPrivee a where a.salarie=" + idSalarie);
//		if(query.getResultList().size() == 0){
//			return null;
//		}
//		return (AdressesPrivee) query.getResultList().get(0);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AdressesPrivee adresse = new AdressesPrivee();
		Query query;
		try {
			query = em.createQuery("select a from AdressesPrivee a where a.salarie=" + idSalarie);
			adresse = (AdressesPrivee) query.getResultList().get(0);
			} finally {
			  em.close();
			}
		return adresse;
	}

	public List<AdressesPrivee> getAllAdressesPrivee() {
//		Query query = em.createQuery("select a from AdressesPrivee a");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<AdressesPrivee> adresses;
		Query query;
		try {
			query = em.createQuery("select a from AdressesPrivee a");
			adresses = query.getResultList();
			} finally {
			  em.close();
			}
		return adresses;
	}

	public AdressesPrivee modifierAdressePrivee(AdressesPrivee a) {
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

	public void supprimerAdressePrivee(Long idAdressePrivee) {
//		em.getTransaction().begin();
//		AdressesPrivee a = em.find(AdressesPrivee.class, idAdressePrivee);
//		em.remove(a);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AdressesPrivee adresse = new AdressesPrivee();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  adresse = em.find(AdressesPrivee.class, idAdressePrivee);
				  em.remove(adresse);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
}
