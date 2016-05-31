package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.bps.entities.AutoFormation;
import ma.bps.entities.AutoFormationDocuments;
import ma.bps.entities.Message;

public class AutoFormationDaoImpl implements IAutoFormation {

	public AutoFormation ajouterAutoFormation(AutoFormation m) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(m);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		
		return m;
		
	}

	public AutoFormation getAutoFormationById(Long idAutoFormation) {
		// TODO Auto-generated method stub


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AutoFormation autoFormation = new AutoFormation();
		try {
			autoFormation = em.find(AutoFormation.class, idAutoFormation);
			} finally {
			  em.close();
			}
		return autoFormation;
		
	}

	public List<AutoFormation> getAllAutoFormation() {
		// TODO Auto-generated method stub


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<AutoFormation> autoFormation;
		Query query;
		try {
			query = em.createQuery("select g from AutoFormation g");
			autoFormation = query.getResultList();
			} finally {
			  em.close();
			}
		return autoFormation;
		
	}

	public AutoFormation modifierAutoFormation(AutoFormation m) {
		// TODO Auto-generated method stub


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(m);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return m;
		
	}

	public void supprimerAutoFormation(Long idAutoFormation) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AutoFormation autoFormation = new AutoFormation();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  autoFormation = em.find(AutoFormation.class, idAutoFormation);
				  em.remove(autoFormation);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		
	}

	public List<Object[]> chargerNombreDocumentFormation(Long idFormation) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from AutoFormationDocuments a where a.autoFormation.idAutoFormation=" + idFormation);
			return query.getResultList();
			} finally {
			  em.close();
			}
	}

	public List<AutoFormationDocuments> chargerLesDocumentUneFormation(Long idFormation) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from AutoFormationDocuments a where a.autoFormation.idAutoFormation=" + idFormation);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<AutoFormation> chargerListeAutoFormationUnTheme(long idTheme) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from AutoFormation a where a.themeAutoFormation.idAutoFormationTheme=" + idTheme);
			return query.getResultList();
			} finally {
			  em.close();
			}
		
		
	}

	public List<AutoFormation> chargerListeAutoFormationRechercheParSujet(String sujetChercher) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select a from AutoFormation a where a.sujet like '%" + sujetChercher + "%'");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

}
