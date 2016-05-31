package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.bps.entities.Groupes;
import ma.bps.entities.Message;
import ma.bps.entities.MessageFichierJoint;

public class MessageDaoImpl implements IMessage {

	public void ajouterMessage(Message m) {


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
		
	}

	public Message getMessageById(Long idMessage) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Message message = new Message();
		try {
			message = em.find(Message.class, idMessage);
			} finally {
			  em.close();
			}
		return message;
		
	}

	public List<Message> getAllMessages() {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Message> messages;
		Query query;
		try {
			query = em.createQuery("select g from Message g");
			messages = query.getResultList();
			} finally {
			  em.close();
			}
		return messages;
		
	}

	public Message modifierMessage(Message m) {


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

	public void supprimerMessagee(Long idMessage) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Message message = new Message();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  message = em.find(Message.class, idMessage);
				  em.remove(message);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		

	}

	public List<Object[]> chargerNombreMessageRecuNonLuSalarie(long idSalarie) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from Message m where m.destinataire.idSalarie=" + idSalarie + " and m.lu='non' and m.supprimerFacultatifParDestinataire='non' and m.supprimerDefinitifParDestinataire='non'");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Object[]> chargerNombreMessageRecuSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from Message m where m.destinataire.idSalarie=" + idSalarie + " and m.supprimerFacultatifParDestinataire='non' and m.supprimerDefinitifParDestinataire='non'");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Object[]> chargerNombreMessageEnvoyerSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from Message m where m.destinateur.idSalarie=" + idSalarie + " and m.supprimerFacultatifParDestinateur='non' and m.supprimerDefinitifParDestinateur='non'");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	
	public List<Object[]> chargerNombreMessageRecuSupprimerSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from Message m where m.destinataire.idSalarie=" + idSalarie + " and m.supprimerFacultatifParDestinataire='oui' and m.supprimerDefinitifParDestinataire='non'");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Object[]> chargerNombreMessageEnvoyerSupprimerSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select count(*) from Message m where m.destinateur.idSalarie=" + idSalarie + " and m.supprimerFacultatifParDestinateur='oui' and m.supprimerDefinitifParDestinateur='non'");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Message> chargerMessageRecuNonLuSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select m from Message m where m.destinataire.idSalarie=" + idSalarie + " and m.lu='non' and m.supprimerFacultatifParDestinataire='non' and m.supprimerDefinitifParDestinataire='non'");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Message> chargerMessageRecuLuSalarie(long idSalarie) {


		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select m from Message m where m.destinataire.idSalarie=" + idSalarie + " and m.lu='oui' and m.supprimerFacultatifParDestinataire='non' and m.supprimerDefinitifParDestinataire='non'");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<Message> chargerMessageEnvoyerSalarie(long idSalarie) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select m from Message m where m.destinateur.idSalarie=" + idSalarie + " and m.supprimerFacultatifParDestinateur='non' and m.supprimerDefinitifParDestinateur='non'");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}



	public List<Message> chargerMessageEnvoyerSupprimerSalarie(long idSalarie) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select m from Message m where m.destinateur.idSalarie=" + idSalarie + " and m.supprimerFacultatifParDestinateur='oui' and m.supprimerDefinitifParDestinateur='non'");
			return query.getResultList();
			} finally {
			  em.close();
			}
		
	}

	public List<MessageFichierJoint> chargerListeDesFichiersJointUnMessage(Long idMessage) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select m from MessageFichierJoint m where m.message.idMessage=" + idMessage);
			return query.getResultList();
			} finally {
			  em.close();
			}
	}

	public List<Message> chargerMessageRecuLuSupprimerSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select m from Message m where m.destinataire.idSalarie=" + idSalarie + " and m.supprimerFacultatifParDestinataire='oui' and m.supprimerDefinitifParDestinataire='non' and m.lu='oui' ");
			return query.getResultList();
			} finally {
			  em.close();
			}
	}

	public List<Message> chargerMessageRecuNonLuSupprimerSalarie(long idSalarie) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Query query;
		try {
			query = em.createQuery("select m from Message m where m.destinataire.idSalarie=" + idSalarie + " and m.supprimerFacultatifParDestinataire='oui' and m.supprimerDefinitifParDestinataire='non' and m.lu='oui' and m.lu='non' ");
			return query.getResultList();
			} finally {
			  em.close();
			}
	}
	

	

}
