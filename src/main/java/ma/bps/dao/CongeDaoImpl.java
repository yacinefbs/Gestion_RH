package ma.bps.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.bps.entities.Agences;
import ma.bps.entities.B_Conges;
import ma.bps.entities.Conges;
import ma.bps.entities.Salaries;
import ma.bps.metier.B_CongeMetierImpl;
import ma.bps.metier.ContratMetierImpl;
import ma.bps.metier.IB_CongeMetier;
import ma.bps.metier.IContratMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.SalarieMetierImpl;

public class CongeDaoImpl implements IConge {

//	@PersistenceContext
//	private EntityManager em;
//	
//	public CongeDaoImpl() {
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gestion_RH");
//		em=emf.createEntityManager();
//	}

	public Conges ajouterConge(Conges c) {
//		em.getTransaction().begin();
//		em.persist(c);
//		em.getTransaction().commit();
//		return c;
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.persist(c);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return c;
	}

	public Conges getCongeById(Long idConge) {
//		return em.find(Conges.class, idConge);
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Conges conges = new Conges();
		try {
			conges = em.find(Conges.class, idConge);
			} finally {
			  em.close();
			}
		return conges;
	}

	public List<Conges> getAllConges() {
//		Query query = em.createQuery("select c from Conges c");
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Conges> conges;
		Query query;
		try {
			query = em.createQuery("select c from Conges c");
			conges = query.getResultList();
			} finally {
			  em.close();
			}
		return conges;
	}

	public Conges modifierConge(Conges c) {
//		em.getTransaction().begin();
//		em.merge(c);
//		em.getTransaction().commit();
//		return c;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  em.merge(c);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return c;
	}

	public void supprimerConge(Long idConge) {
		// TODO Auto-generated method stub
//		em.getTransaction().begin();
//		Conges c = em.find(Conges.class, idConge);
//		em.remove(c);
//		em.getTransaction().commit();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		Conges c = new Conges();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  transaction.begin();  
				  c = em.find(Conges.class, idConge);
				  em.remove(c);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
	}

	public List<Conges> getAllCongesBySalarie(Long idSalarie) {
//		Query query = em.createQuery("select c from Conges c where c.salarie=" + idSalarie);
//		System.out.println("La taille de la liste congés by Salarié : " + query.getResultList().size());
//		return query.getResultList();
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Conges> conges;
		Query query;
		try {
			System.out.println("avant congé salarie");
			query = em.createQuery("select c from Conges c where c.salarie=" + idSalarie);
			System.out.println("milieu congé salarie");
			conges = query.getResultList();
			System.out.println("après congé salarie");
			} finally {
			  em.close();
			}
		return conges;
	}
	
	public double nbrJoursCongeRestant(Long idSalarie, Long idSociete){
		// TODO nbrJourCongesdisponible
		IContratMetier contratMetier = new ContratMetierImpl();
		IB_CongeMetier b_congeMetier = new B_CongeMetierImpl();
		double nbrJourCongeTotal = 0;
		List<B_Conges> listB_Conge = b_congeMetier.getBaremesCongesByIdSociete(idSociete);
		ISalarieMetier salarieMetier = new SalarieMetierImpl();
		Salaries salarie = new Salaries();
		salarie = salarieMetier.getSalarieById(idSalarie);
		//Nombre de mois des contrats : 
		Date dateSystem= new Date();
		System.out.println("date system entre " + dateSystem);
		Date dateDebutContrat = contratMetier.dateDebutContrat(idSalarie);
		if(dateDebutContrat != null){
		System.out.println("date systeme : " + dateSystem);
		System.out.println("date debut contrat : " + dateDebutContrat);
		
		 GregorianCalendar gc3 = new GregorianCalendar();
		 gc3.setTime(dateDebutContrat);
		 GregorianCalendar gc4 = new GregorianCalendar();
		 gc4.setTime(dateSystem);
		 float gap1=0;
	        gc3.add(GregorianCalendar.MONTH, 1);
	        while(gc3.compareTo(gc4)<=0) {
	            gap1++;
	            gc3.add(GregorianCalendar.MONTH, 1);
	        }
	        
//	        gap1=gap1*12;
	        System.out.println("Nombre année contrat (par mois) : " + gap1);
		
	        float nbrMoisTranche1=0;
	        float nbrMoisTranche2=0;
	        float tempTranche=0;
	        //0 ---> 0.5
	        
	        for (B_Conges b_Conges : listB_Conge) {
				System.out.println("bareme = " + b_Conges.getTranche1());
				nbrMoisTranche1 = (float) b_Conges.getTranche1() * 12;
				nbrMoisTranche2 = (float) b_Conges.getTranche2() * 12;

				System.out.println("********* |" + nbrMoisTranche1 + " |********************* | " + nbrMoisTranche2 + " | *****************************");
				System.out.println("gap1 : " + gap1);
				System.out.println("nbrMoisTranche1 : " + nbrMoisTranche1);
				System.out.println("nbrMoisTranche2 : " + nbrMoisTranche2);
				
				if(gap1>=nbrMoisTranche1){
					if(gap1>=nbrMoisTranche2){
						tempTranche = nbrMoisTranche2 - nbrMoisTranche1;
					}
					else{
						tempTranche = gap1 - nbrMoisTranche1;
					}
						
					System.out.println("tempTranche : " + tempTranche);
					System.out.println("tempTranche * jourParMois : " +tempTranche*b_Conges.getJoursParMois());
					System.out.println("tempTranche * jourSupp" + (Math.round(tempTranche)/12)*b_Conges.getJoursSupp());
					nbrJourCongeTotal = nbrJourCongeTotal + (tempTranche*b_Conges.getJoursParMois()) + ((Math.ceil(tempTranche/12))*b_Conges.getJoursSupp());
					System.out.println("nbrJourTotal : " + nbrJourCongeTotal);
				}
			}
	        
		//La variable jourSupp contient le nombre de jours supplémentaires du congé d'un salarié donnée.
		salarie = salarieMetier.getSalarieById(idSalarie);
		System.out.println("nbr de jours deja demande de congé : " + this.nbreJourCongeDemande(idSalarie));
//		System.out.println("nbr de jours congé disponible : " + nbrJourCongeTotal);
		System.out.println("Nombre de jour entre date debut contrat et date current " + nbrJourCongeTotal);
		nbrJourCongeTotal = (float) (nbrJourCongeTotal - this.nbreJourCongeDemande(idSalarie) - this.nbrJourDebutContratEtDateCurrent(idSalarie) + salarie.getNbrJourConge()); 
		}
		return nbrJourCongeTotal;
	}
	
	public double nbrJourDebutContratEtDateCurrent(Long idSalarie){
		// TODO nbrJourCongeDateEntreeEtDateCurrent
		IB_CongeMetier b_congeMetier = new B_CongeMetierImpl();
		List<B_Conges> listB_Conge = b_congeMetier.getBaremesCongesByIdSociete(1L);
		IContratMetier contratMetier = new ContratMetierImpl();
		double nbrJourCongeTotal=0;
		float gap1 = 0;
		ISalarieMetier salarieMetier = new SalarieMetierImpl();
		Salaries salarie = salarieMetier.getSalarieById(idSalarie);
		
		Date dateEntree= salarie.getDateEntreeConge(); //new Date();
		Date dateDebutContrat = contratMetier.dateDebutContrat(idSalarie); //salarie.getDateEntreeConge();
		if(dateDebutContrat != null){
		System.out.println("date systeme : " + dateEntree);
		System.out.println("date debut contrat : " + dateDebutContrat);
		
		 GregorianCalendar gc3 = new GregorianCalendar();
		 gc3.setTime(dateDebutContrat);
		 GregorianCalendar gc4 = new GregorianCalendar();
		 gc4.setTime(dateEntree);
		 gap1=0;
	        gc3.add(GregorianCalendar.MONTH, 1);
	        while(gc3.compareTo(gc4)<=0) {
	            gap1++;
	            gc3.add(GregorianCalendar.MONTH, 1);
	        }
	        
//	        gap1=gap1*12;
	        System.out.println("Nombre année contrat (par mois) : " + gap1);
		}
		
		
		
		float nbrMoisTranche1=0;
        float nbrMoisTranche2=0;
        float tempTranche=0;
        //0 ---> 0.5
        
        for (B_Conges b_Conges : listB_Conge) {
			System.out.println("bareme = " + b_Conges.getTranche1());
			nbrMoisTranche1 = (float) b_Conges.getTranche1() * 12;
			nbrMoisTranche2 = (float) b_Conges.getTranche2() * 12;

			System.out.println("********* |" + nbrMoisTranche1 + " |********************* | " + nbrMoisTranche2 + " | *****************************");
			System.out.println("gap1 : " + gap1);
			System.out.println("nbrMoisTranche1 : " + nbrMoisTranche1);
			System.out.println("nbrMoisTranche2 : " + nbrMoisTranche2);
			
			if(gap1>=nbrMoisTranche1){
				if(gap1>=nbrMoisTranche2){
					tempTranche = nbrMoisTranche2 - nbrMoisTranche1;
				}
				else{
					tempTranche = gap1 - nbrMoisTranche1;
				}
					
				System.out.println("tempTranche : " + tempTranche);
				System.out.println("tempTranche * jourParMois : " +tempTranche*b_Conges.getJoursParMois());
				System.out.println("tempTranche * jourSupp" + (Math.round(tempTranche)/12)*b_Conges.getJoursSupp());
				nbrJourCongeTotal = nbrJourCongeTotal + (tempTranche*b_Conges.getJoursParMois()) + ((Math.ceil(tempTranche/12))*b_Conges.getJoursSupp());
				System.out.println("nbrJourTotal : " + nbrJourCongeTotal);
			}
		}
        System.out.println("Nombre de jour entre date saisie et date current " + nbrJourCongeTotal);
		return nbrJourCongeTotal;
	}

	public double nbreJourCongeDemande(Long idSalarie) {
//		Query query = em.createQuery("select c from Conges c where nature='normal' and valide='validé' and c.salarie=" + idSalarie);
//		List<Conges> listConge = query.getResultList();
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Conges> listConge;
		Query query;
		try {
			query = em.createQuery("select c from Conges c where nature='normal' and valide='validé' and c.salarie=" + idSalarie);
			listConge = query.getResultList();
			} finally {
			  em.close();
		}
		
		
		Date dateDebut;
		Date dateFin;
		double gap = 0;
		for (Conges conge : listConge) {
			dateDebut = conge.getDateDebutC();
			dateFin = conge.getDateFinC();
			System.out.println("date debut : " + dateDebut);
			System.out.println("date fin : " + dateFin);
			
			//------------------------
			 GregorianCalendar gc1 = new GregorianCalendar();
			 gc1.setTime(dateDebut);
			 GregorianCalendar gc2 = new GregorianCalendar();
			 gc2.setTime(dateFin);
			 
		        gc1.add(GregorianCalendar.DAY_OF_WEEK, 1);
		        while(gc1.compareTo(gc2)<=0) {
		            gap++;
		            gc1.add(GregorianCalendar.DAY_OF_WEEK, 1);
		        }
		     System.out.println("difference 'Date debut' et 'date fin' :" + gap);
		}
		return gap;
	}

	public Conges accepterConge(Conges c) {
		// TODO Auto-generated method stub
//		c.setValide("validé");
//		em.getTransaction().begin();
//		em.merge(c);
//		em.getTransaction().commit();
//		return c;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  c.setValide("validé");
				  transaction.begin();  
				  em.merge(c);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return c;
	}
	
	public Conges refuserConge(Conges c) {
//		c.setValide("non validé");
//		em.getTransaction().begin();
//		em.merge(c);
//		em.getTransaction().commit();
//		return c;
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			  EntityTransaction transaction = em.getTransaction();
			  try {
				  c.setValide("non validé");
				  transaction.begin();  
				  em.merge(c);
				  transaction.commit();
			  } finally {
			    if (transaction.isActive()) transaction.rollback();
			  }
			} finally {
			  em.close();
			}
		return c;
	}
	
	public List<Conges> chargerCongesSalarieUneDate(Long idSalarie, Date dateVoulu) {
		// TODO Auto-generated method stub
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		
//		Query query = em.createQuery("select c from Conges c where '" + formatter.format(dateVoulu) + "' between c.dateDebutC and c.dateFinC");
//		return query.getResultList();	
		
		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		List<Conges> conges;
		Query query;
		try {
			System.out.println("avant congé salarie");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			query = em.createQuery("select c from Conges c where ('" + formatter.format(dateVoulu) + "' between c.dateDebutC and c.dateFinC) and c.valide='validé'");
			System.out.println("milieu congé salarie");
			conges = query.getResultList();
			System.out.println("après congé salarie");
			} finally {
			  em.close();
			}
		return conges;
		
	}
	
	
}
