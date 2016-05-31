package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.bps.entities.Groupes;
import ma.bps.entities.Utilisateurs;

public class UtilisateurDaoImpl implements IUtilisateur {

	public void ajouterUtilisateur(Utilisateurs u) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(u);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

	public Utilisateurs getUtilisateurById(Long idUtilisateur) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Utilisateurs utilisateur = new Utilisateurs();
		try {
			utilisateur = em.find(Utilisateurs.class, idUtilisateur);
			} finally {
			  em.close();
			}
		return utilisateur;
		
	}

	public List<Utilisateurs> getAllUtilisateurs() {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Utilisateurs> utilisateurs;
		Query query;
		try {
			query = em.createQuery("select u from Utilisateurs u");
			utilisateurs = query.getResultList();
			} finally {
			  em.close();
			}
		return utilisateurs;
		
	}

	public Utilisateurs modifierUtilisateur(Utilisateurs u) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(u);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return u;
		
	}

	public void supprimerUtilisateur(Long idUtilisateur) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Utilisateurs utilisateur = new Utilisateurs();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  utilisateur = em.find(Utilisateurs.class, idUtilisateur);
				  em.remove(utilisateur);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

	public List<Utilisateurs> chercherUtilisateurByLoginPasse(String login, String passe) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Utilisateurs> utilisateurs;
		Query query;
		try {
			query = em.createQuery("select u from Utilisateurs u where u.login='" + login + "' and u.passe='" + passe + "'");
			utilisateurs = query.getResultList();
			} finally {
			  em.close();
			}
		return utilisateurs;
	}

}
