package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.bps.entities.AutoFormation;
import ma.bps.entities.AutoFormationTheme;

public class AutoFormationThemeDaoImpl implements IAutoFormationTheme {

	public AutoFormationTheme ajouterAutoFormationTheme(AutoFormationTheme m) {
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

	public AutoFormationTheme getAutoFormationThemeById(Long idAutoFormationTheme) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AutoFormationTheme autoFormationTheme = new AutoFormationTheme();
		try {
			autoFormationTheme = em.find(AutoFormationTheme.class, idAutoFormationTheme);
			} finally {
			  em.close();
			}
		return autoFormationTheme;
	}

	public List<AutoFormationTheme> getAllAutoFormationTheme() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<AutoFormationTheme> autoFormationTheme;
		Query query;
		try {
			query = em.createQuery("select g from AutoFormationTheme g");
			autoFormationTheme = query.getResultList();
			} finally {
			  em.close();
			}
		return autoFormationTheme;
	}

	public AutoFormationTheme modifierAutoFormationTheme(AutoFormationTheme m) {
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

	public void supprimerAutoFormationTheme(Long idAutoFormationTheme) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		AutoFormationTheme autoFormationTheme = new AutoFormationTheme();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  autoFormationTheme = em.find(AutoFormationTheme.class, idAutoFormationTheme);
				  em.remove(autoFormationTheme);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

	public List<AutoFormationTheme> chargerListeAutoFormationThemeAyantDesAutoFormation() {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<AutoFormationTheme> autoFormationTheme;
		Query query;
		try {
			query = em.createQuery("select g from AutoFormationTheme g where g.idAutoFormationTheme in (select a.themeAutoFormation.idAutoFormationTheme from AutoFormation a)");
			autoFormationTheme = query.getResultList();
			} finally {
			  em.close();
			}
		return autoFormationTheme;
		
	}

}
