package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.bps.entities.AutoFormation;
import ma.bps.entities.AutoFormationDocuments;
import ma.bps.entities.MessageFichierJoint;

public class AutoFormationDocumentsDaoImpl implements IAutoFormationDocuments {

	public AutoFormationDocuments ajouterAutoFormationDocuments(AutoFormationDocuments m) {
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

	public AutoFormationDocuments getAutoAutoFormationDocumentsById(Long idAutoFormationDocuments) {
		// TODO Auto-generated method stub


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AutoFormationDocuments autoFormationdoc = new AutoFormationDocuments();
		try {
			autoFormationdoc = em.find(AutoFormationDocuments.class, idAutoFormationDocuments);
			} finally {
			  em.close();
			}
		return autoFormationdoc;
		
		
	}

	public List<AutoFormationDocuments> getAllAutoFormationDocuments() {
		// TODO Auto-generated method stub


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<AutoFormationDocuments> autoFormationdoc;
		Query query;
		try {
			query = em.createQuery("select g from AutoFormationDocuments g");
			autoFormationdoc = query.getResultList();
			} finally {
			  em.close();
			}
		return autoFormationdoc;
		
	}

	public AutoFormationDocuments modifierAutoFormationDocuments(AutoFormationDocuments m) {
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

	public void supprimerAutoFormationDocuments(Long idAutoFormationDocuments) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AutoFormationDocuments autoFormationdoc = new AutoFormationDocuments();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  autoFormationdoc = em.find(AutoFormationDocuments.class, idAutoFormationDocuments);
				  em.remove(autoFormationdoc);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

	public List<AutoFormationDocuments> chargerListDocumentAutoFormationNonAffecterAuneAutoFormation() {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<AutoFormationDocuments> fichier;
		Query query;
		try {
			query = em.createQuery("select g from AutoFormationDocuments g where g.autoFormation is null");
			fichier = query.getResultList();
			} finally {
			  em.close();
			}
		return fichier;
		
	}

}
