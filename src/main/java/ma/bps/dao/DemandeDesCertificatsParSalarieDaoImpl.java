package ma.bps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ma.bps.entities.AutoFormation;
import ma.bps.entities.DemandeDesCertificatsParSalarie;

public class DemandeDesCertificatsParSalarieDaoImpl implements IDemandeDesCertificatsParSalarie {

	public DemandeDesCertificatsParSalarie ajouterDemandeDesCertificatsParSalarie(DemandeDesCertificatsParSalarie m) {
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

	public DemandeDesCertificatsParSalarie getDemandeDesCertificatsParSalarieById(
			Long idDemandeDesCertificatsParSalarie) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		DemandeDesCertificatsParSalarie demande = new DemandeDesCertificatsParSalarie();
		try {
			demande = em.find(DemandeDesCertificatsParSalarie.class, idDemandeDesCertificatsParSalarie);
			} finally {
			  em.close();
			}
		return demande;
		
		
	}

	public List<DemandeDesCertificatsParSalarie> getAllDemandeDesCertificatsParSalarie() {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<DemandeDesCertificatsParSalarie> demande;
		Query query;
		try {
			query = em.createQuery("select g from DemandeDesCertificatsParSalarie g");
			demande = query.getResultList();
			} finally {
			  em.close();
			}
		return demande;
		
	}

	public DemandeDesCertificatsParSalarie modifierDemandeDesCertificatsParSalarie(DemandeDesCertificatsParSalarie m) {
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

	public void supprimerDemandeDesCertificatsParSalarie(Long idDemandeDesCertificatsParSalarie) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		DemandeDesCertificatsParSalarie demande = new DemandeDesCertificatsParSalarie();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  demande = em.find(DemandeDesCertificatsParSalarie.class, idDemandeDesCertificatsParSalarie);
				  em.remove(demande);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

}
