package ma.bps.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.A_Justifiee;
import ma.bps.entities.TranchePlanTravail;

public class TranchePlanTravailDaoImpl implements ITranchePlanTravail {

//	@PersistenceContext
//	private EntityManager em;
//	
//	
//	public TranchePlanTravailDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public void ajouterTranchePlanTravail(TranchePlanTravail p) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.persist(p);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(p);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public TranchePlanTravail getTranchePlanTravailById(Long idTranche) {
		// TODO Auto-generated method stub
//		return em.find(TranchePlanTravail.class, idTranche);
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		TranchePlanTravail tranchePlanTravail = new TranchePlanTravail();
		try {
			tranchePlanTravail = em.find(TranchePlanTravail.class, idTranche);
			} finally {
			  em.close();
			}
		return tranchePlanTravail;
	}

	public List<TranchePlanTravail> getAllTranchePlanTravail() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select p from TranchePlanTravail p");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<TranchePlanTravail> tranchePlanTravails;
		Query query;
		try {
			query = em.createQuery("select p from TranchePlanTravail p");
			tranchePlanTravails = query.getResultList();
			} finally {
			  em.close();
			}
		return tranchePlanTravails;
	}

	public TranchePlanTravail modifierTranchePlanTravail(TranchePlanTravail p) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		em.merge(p);
//		em.getTransaction().commit();
//		return p;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(p);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return p;
	}

	public void supprimerTranchePlanTravail(Long idTranche) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		TranchePlanTravail t = em.find(TranchePlanTravail.class, idTranche);
//		em.remove(t);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		TranchePlanTravail tranchePlanTravail = new TranchePlanTravail();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  tranchePlanTravail = em.find(TranchePlanTravail.class, idTranche);
				  em.remove(tranchePlanTravail);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}

	}

	public List<TranchePlanTravail> getTranchePlanTravailByJour(String jour, Long idPlan) {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select p from TranchePlanTravail p where p.PlanTravail.idPlan="+ idPlan +" and p.jour='" + jour + "'");
//		return query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<TranchePlanTravail> tranchePlanTravails;
		Query query;
		try {
			query = em.createQuery("select p from TranchePlanTravail p where p.PlanTravail.idPlan="+ idPlan +" and p.jour='" + jour + "'");
			tranchePlanTravails = query.getResultList();
			} finally {
			  em.close();
			}
		return tranchePlanTravails;
	}

	public List<TranchePlanTravail> getDistinctTranchePlanTravail() {
		// TODO Auto-generated method stub
//		Query query = em.createQuery("select distinct t from TranchePlanTravail t");
//		
//		List<TranchePlanTravail> listeTousLesTranches = query.getResultList();
//		List<TranchePlanTravail> lsAretourner = new ArrayList<TranchePlanTravail>();
////		FOR (TRANCHEPLANTRAVAIL TRANCHE : LSARETOURNER) {
////			
////			SYSTEM.OUT.PRINTLN(TRANCHE.GETIDTRANCHE() + "  " + TRANCHE.GETHEUREDEBUT() + "  " + TRANCHE.GETHEUREFIN() + "  " + TRANCHE.GETJOUR() + "  " + TRANCHE.GETCODE() + "  " + TRANCHE.GETTAUX() + "  " + TRANCHE.ISDEUXJOUR() );
////			
////		}
//		SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm");
//		
//		if (listeTousLesTranches.size()>0) 
//		{
//			for (TranchePlanTravail tranche : listeTousLesTranches) 
//			{
//				boolean exist = false;		
//			// ila kanat chi 7aja fdik la list li ghadi nretourniw 
//				if (lsAretourner.size()>0) 
//				{
//					// on fait une boucle sur la liste des tranche a retourner bach ma t3awd ta wa7da
//					for (TranchePlanTravail trancheAretourner : lsAretourner) 
//					{
//						// ndiro test yakma dik tranxche déja kayna
//						if ( formatterHeure.format(tranche.getHeureDebut()).equals(formatterHeure.format(trancheAretourner.getHeureDebut())) && formatterHeure.format(tranche.getHeureFin()).equals(formatterHeure.format(trancheAretourner.getHeureFin())) && tranche.isDeuxJour() == trancheAretourner.isDeuxJour() && tranche.getCode().equals(trancheAretourner.getCode()) && tranche.getTaux() == trancheAretourner.getTaux()) 
//						{
//							exist = true;
//						}
//					}
//					
//					if (!exist) 
//					{
//						lsAretourner.add(tranche);
//					}
//					
//				}
//				// ila ma kan walo
//				else
//				{
//					lsAretourner.add(tranche);
//				}
//			}
//			
//		}
//		
//		return lsAretourner;
		
		
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<TranchePlanTravail> tranchePlanTravails;
		Query query;
		try {
			query = em.createQuery("select distinct t from TranchePlanTravail t");
			
			List<TranchePlanTravail> listeTousLesTranches = query.getResultList();
			List<TranchePlanTravail> lsAretourner = new ArrayList<TranchePlanTravail>();
//			FOR (TRANCHEPLANTRAVAIL TRANCHE : LSARETOURNER) {
//				
//				SYSTEM.OUT.PRINTLN(TRANCHE.GETIDTRANCHE() + "  " + TRANCHE.GETHEUREDEBUT() + "  " + TRANCHE.GETHEUREFIN() + "  " + TRANCHE.GETJOUR() + "  " + TRANCHE.GETCODE() + "  " + TRANCHE.GETTAUX() + "  " + TRANCHE.ISDEUXJOUR() );
//				
//			}
			SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm");
			
			if (listeTousLesTranches.size()>0) 
			{
				for (TranchePlanTravail tranche : listeTousLesTranches) 
				{
					boolean exist = false;		
				// ila kanat chi 7aja fdik la list li ghadi nretourniw 
					if (lsAretourner.size()>0) 
					{
						// on fait une boucle sur la liste des tranche a retourner bach ma t3awd ta wa7da
						for (TranchePlanTravail trancheAretourner : lsAretourner) 
						{
							// ndiro test yakma dik tranxche déja kayna
							if ( formatterHeure.format(tranche.getHeureDebut()).equals(formatterHeure.format(trancheAretourner.getHeureDebut())) && formatterHeure.format(tranche.getHeureFin()).equals(formatterHeure.format(trancheAretourner.getHeureFin())) && tranche.isDeuxJour() == trancheAretourner.isDeuxJour() && tranche.getCode().equals(trancheAretourner.getCode()) && tranche.getTaux() == trancheAretourner.getTaux()) 
							{
								exist = true;
							}
						}
						
						if (!exist) 
						{
							lsAretourner.add(tranche);
						}
						
					}
					// ila ma kan walo
					else
					{
						lsAretourner.add(tranche);
					}
				}
				
			}
			return lsAretourner;
			} finally {
			  em.close();
			}
	}
}
