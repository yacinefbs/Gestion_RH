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

public class AdresseProDaoImpl implements IAdressePro {

//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public AdresseProDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public AdressesPro ajouterAdressePro(AdressesPro a) {
		// TODO Auto-generated method stub
//				em.getTransaction().begin();
//				
//				em.persist(a);
//				em.getTransaction().commit();
//				return a;
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

	public AdressesPro getAdresseProById(Long idAdressePro) {
		// TODO Auto-generated method stub
//		return em.find(AdressesPro.class, idAdressePro);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AdressesPro adresse = new AdressesPro();
		Query query;
		List<TauxFraisPro> list;
		try {
			adresse = em.find(AdressesPro.class, idAdressePro);
			} finally {
			  em.close();
			}
		return adresse;
	}

	public AdressesPro getAdresseProBySalarie(Long idSalarie) {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select a from AdressesPro a where a.salarie=" + idSalarie);
//		if(query.getResultList().size() == 0){
//			return null;
//		}
//		return (AdressesPro) query.getResultList().get(0);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AdressesPro adresse = new AdressesPro();
		Query query;
		try {
			query = em.createQuery("select a from AdressesPro a where a.salarie=" + idSalarie);
			adresse = (AdressesPro) query.getResultList().get(0);
			} finally {
			  em.close();
			}
		return adresse;
	}

	public List<AdressesPro> getAllAdressesPro() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select a from AdressesPro a");
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<AdressesPro> adresses;
		Query query;
		try {
			query = em.createQuery("select a from AdressesPro a");
			adresses = query.getResultList();
			} finally {
			  em.close();
			}
		return adresses;
	}

	public AdressesPro modifierAdressePro(AdressesPro a) {
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

	public void supprimerAdressePro(Long idAdressePro) {
//		em.getTransaction().begin();
//		AdressesPro a = em.find(AdressesPro.class, idAdressePro);
//		em.remove(a);
//		em.getTransaction().commit();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AdressesPro adresse = new AdressesPro();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  adresse = em.find(AdressesPro.class, idAdressePro);
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
