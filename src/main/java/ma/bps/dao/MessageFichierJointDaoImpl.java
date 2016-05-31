package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.bps.entities.Groupes;
import ma.bps.entities.Message;
import ma.bps.entities.MessageFichierJoint;

public class MessageFichierJointDaoImpl implements IMessageFichierJoint {

	public void ajouterMessageFichierJoint(MessageFichierJoint f) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(f);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

	public MessageFichierJoint getMessageFichierJointById(Long idMessageFichierJoint) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		MessageFichierJoint fichier = new MessageFichierJoint();
		try {
			fichier = em.find(MessageFichierJoint.class, idMessageFichierJoint);
			} finally {
			  em.close();
			}
		return fichier;
		
	}

	public List<MessageFichierJoint> getAllMessageFichierJoint() {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<MessageFichierJoint> fichier;
		Query query;
		try {
			query = em.createQuery("select g from MessageFichierJoint g");
			fichier = query.getResultList();
			} finally {
			  em.close();
			}
		return fichier;
		
	}

	public MessageFichierJoint modifierMessageFichierJoint(MessageFichierJoint f) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(f);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return f;
		
	}

	public void supprimerMessageFichierJoint(Long idMessageFichierJoint) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		MessageFichierJoint fichier = new MessageFichierJoint();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  fichier = em.find(MessageFichierJoint.class, idMessageFichierJoint);
				  em.remove(fichier);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		
	}

	public List<MessageFichierJoint> chargerListFichierNonAffecterAunMessage() {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<MessageFichierJoint> fichier;
		Query query;
		try {
			query = em.createQuery("select g from MessageFichierJoint g where g.message is null");
			fichier = query.getResultList();
			} finally {
			  em.close();
			}
		return fichier;
	}

	public void affecterDesFichierAunMessage(Message message) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<MessageFichierJoint> fichier;
		Query query;
		try {
			query = em.createQuery("update MessageFichierJoint m set m.message=" + message + " where m.message=null");
			fichier = query.getResultList();
			} finally {
			  em.close();
			}
		
		
	}

}
