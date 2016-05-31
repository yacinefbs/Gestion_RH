package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.A_Justifiee;
import ma.bps.entities.Banques;
import ma.bps.entities.Groupes;
import ma.bps.entities.Salaires;
import ma.bps.entities.Salaries;

public class GroupeDaoImpl implements IGroupe {

	
//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public GroupeDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public void ajouterGrouppe(Groupes g) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.persist(g);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(g);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		
	}

	public Groupes getGroupeById(Long idGroupe) {
		// TODO Auto-generated method stub
//		return em.find(Groupes.class, idGroupe);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Groupes groupe = new Groupes();
		try {
			groupe = em.find(Groupes.class, idGroupe);
			} finally {
			  em.close();
			}
		return groupe;
	}

	public List<Groupes> getAllGroupes() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select g from Groupes g");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Groupes> groupes;
		Query query;
		try {
			query = em.createQuery("select g from Groupes g");
			groupes = query.getResultList();
			} finally {
			  em.close();
			}
		return groupes;
	}

	public Groupes modifierGroupe(Groupes g) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.merge(g);
//		em.getTransaction().commit();
//		return g;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(g);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return g;
	}

	public void supprimerGroupe(Long idGroupe) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Groupes g = em.find(Groupes.class, idGroupe);
//		em.remove(g);
//		em.getTransaction().commit();	
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Groupes groupe = new Groupes();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  groupe = em.find(Groupes.class, idGroupe);
				  em.remove(groupe);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}
	
	public List<Salaires> getAllGroupeSalarie(Long idGroup){
		
//		Query query = em.createQuery("select s from Salaries s where s.groupe.idGroupe='" + idGroup + "'");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Salaires> salaires;
		Query query;
		try {
			query = em.createQuery("select s from Salaries s where s.groupe.idGroupe='" + idGroup + "'");
			salaires = query.getResultList();
			} finally {
			  em.close();
			}
		return salaires;
		
	}

	public void annulerPlanGroupe(long idPlan) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Query query = em.createQuery("update Groupes g set g.planTravail=null where g.planTravail.idPlan=" + idPlan);
//		query.executeUpdate();
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  Query query = em.createQuery("update Groupes g set g.planTravail=null where g.planTravail.idPlan=" + idPlan);
				  query.executeUpdate();
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public List<Groupes> chargerListeGroupeQuiNePossedePasDePlan() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select g from Groupes g where g.planTravail is null and g.idGroupe in (select s.groupe.idGroupe from Salaries s  )");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Groupes> groupes;
		Query query;
		try {
			query = em.createQuery("select g from Groupes g where g.planTravail is null and g.idGroupe in (select s.groupe.idGroupe from Salaries s  )");
			groupes = query.getResultList();
			} finally {
			  em.close();
			}
		return groupes;
	}

	public List<Salaries> chargerListeSalarieUnGroupe(Long idGroup) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Salaries> salaries;
		Query query;
		try {
			query = em.createQuery("select s from Salaries s where s.groupe.idGroupe='" + idGroup + "'");
			salaries = query.getResultList();
			} finally {
			  em.close();
			}
		return salaries;
		
	}
}
