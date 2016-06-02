package ma.bps.presentation;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.UploadedFile;

import ma.bps.dao.IA_Non_Justifiee;
import ma.bps.entities.A_Non_Justifiee;
import ma.bps.entities.Groupes;
import ma.bps.entities.PlanTravail;
import ma.bps.entities.PointageDatePasse;
import ma.bps.entities.Pointages;
import ma.bps.entities.Retards;
import ma.bps.entities.Salaries;
import ma.bps.entities.TranchePlanTravail;
import ma.bps.metier.A_JustifieeMetierImpl;
import ma.bps.metier.A_Non_JustifieeMetierImpl;
import ma.bps.metier.CongeMetierImpl;
import ma.bps.metier.GroupeMetierImpl;
import ma.bps.metier.IA_JustifieeMetier;
import ma.bps.metier.IA_Non_JustifieeMetier;
import ma.bps.metier.ICongeMetier;
import ma.bps.metier.IGroupeMetier;
import ma.bps.metier.IJoursFeriesMetier;
import ma.bps.metier.IPointageDatePasseMetier;
import ma.bps.metier.IPointageMetier;
import ma.bps.metier.IRetardsMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.ITranchePlanTravailMetier;
import ma.bps.metier.JoursFeriesMetierImpl;
import ma.bps.metier.PointageDatePasseMetierImpl;
import ma.bps.metier.PointageMetierImpl;
import ma.bps.metier.RetardsMetierImpl;
import ma.bps.metier.SalarieMetierImpl;
import ma.bps.metier.TranchePlanTravailMetierImpl;

@ManagedBean
@SessionScoped
public class BeanPointage implements Serializable {
	
//	private Part file;
	
	private UploadedFile fichierDePointage;
	
	
	public UploadedFile getFichierDePointage() {
		return fichierDePointage;
	}

	public void setFichierDePointage(UploadedFile fichierDePointage) {
		this.fichierDePointage = fichierDePointage;
	}


	private String fileContent;
	
	private IPointageMetier metierPointage = new PointageMetierImpl();
	private ISalarieMetier metierSalarie = new SalarieMetierImpl();
	private IPointageDatePasseMetier metierPointageDatePasse = new PointageDatePasseMetierImpl();
	private ITranchePlanTravailMetier metierTranche = new TranchePlanTravailMetierImpl();
	private IRetardsMetier metierRetard = new RetardsMetierImpl();
	private IA_Non_JustifieeMetier metierA_Non_Justifiee = new A_Non_JustifieeMetierImpl();
	private IA_JustifieeMetier metierA_Justifiee = new A_JustifieeMetierImpl();
	private ICongeMetier metierConges = new CongeMetierImpl();
	private IJoursFeriesMetier metierJourFerie = new JoursFeriesMetierImpl();
	private IGroupeMetier metierGroupe = new GroupeMetierImpl();
	
	
	private Pointages pointageAjouter = new Pointages();
	
	
	// had la varriable bach nchoufo wach kolchi mrigal pour pointer
	// ga3 ls salaries m affectin l des group
	// kola groupe 3ando plan valide
	// ...
	private int siTousEstReglerPourPointage = 0;
	
	// ila kant == 1 ya3ni ta kaynin
	private int siKayninDesSalarieMa3andhomchGroupe = 0;
	
	// ila kant == 1 ya3ni ta kaynin
	private int siKayninDesGroupeMa3andhomchPlan = 0;
	
	private String msgQuelqueSalarieNonAffecterAgroupe = "";
	private String msgQuelqueGroupePossedePasDePlan = "";
	
	
	
	// attributs shedule view 
	private ScheduleModel eventModel;    
    private ScheduleModel lazyEventModel; 
    private ScheduleEvent event = new DefaultScheduleEvent();
	
	
	
	// getters and setters
    
    

	 
	public IGroupeMetier getMetierGroupe() {
		return metierGroupe;
	}

	public void setMetierGroupe(IGroupeMetier metierGroupe) {
		this.metierGroupe = metierGroupe;
	}

	public String getMsgQuelqueSalarieNonAffecterAgroupe() {
		return msgQuelqueSalarieNonAffecterAgroupe;
	}

	public void setMsgQuelqueSalarieNonAffecterAgroupe(String msgQuelqueSalarieNonAffecterAgroupe) {
		this.msgQuelqueSalarieNonAffecterAgroupe = msgQuelqueSalarieNonAffecterAgroupe;
	}

	public String getMsgQuelqueGroupePossedePasDePlan() {
		return msgQuelqueGroupePossedePasDePlan;
	}

	public void setMsgQuelqueGroupePossedePasDePlan(String msgQuelqueGroupePossedePasDePlan) {
		this.msgQuelqueGroupePossedePasDePlan = msgQuelqueGroupePossedePasDePlan;
	}

	public IPointageDatePasseMetier getMetierPointageDatePasse() {
		return metierPointageDatePasse;
	}

	public void setMetierPointageDatePasse(IPointageDatePasseMetier metierPointageDatePasse) {
		this.metierPointageDatePasse = metierPointageDatePasse;
	}

	public ITranchePlanTravailMetier getMetierTranche() {
		return metierTranche;
	}

	public void setMetierTranche(ITranchePlanTravailMetier metierTranche) {
		this.metierTranche = metierTranche;
	}

	public IRetardsMetier getMetierRetard() {
		return metierRetard;
	}

	public void setMetierRetard(IRetardsMetier metierRetard) {
		this.metierRetard = metierRetard;
	}

	public IA_Non_JustifieeMetier getMetierA_Non_Justifiee() {
		return metierA_Non_Justifiee;
	}

	public void setMetierA_Non_Justifiee(IA_Non_JustifieeMetier metierA_Non_Justifiee) {
		this.metierA_Non_Justifiee = metierA_Non_Justifiee;
	}

	public IA_JustifieeMetier getMetierA_Justifiee() {
		return metierA_Justifiee;
	}

	public void setMetierA_Justifiee(IA_JustifieeMetier metierA_Justifiee) {
		this.metierA_Justifiee = metierA_Justifiee;
	}

	public ICongeMetier getMetierConges() {
		return metierConges;
	}

	public void setMetierConges(ICongeMetier metierConges) {
		this.metierConges = metierConges;
	}

	public IJoursFeriesMetier getMetierJourFerie() {
		return metierJourFerie;
	}

	public void setMetierJourFerie(IJoursFeriesMetier metierJourFerie) {
		this.metierJourFerie = metierJourFerie;
	}

	public int getSiTousEstReglerPourPointage() {
		return siTousEstReglerPourPointage;
	}

	public void setSiTousEstReglerPourPointage(int siTousEstReglerPourPointage) {
		this.siTousEstReglerPourPointage = siTousEstReglerPourPointage;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public void setLazyEventModel(ScheduleModel lazyEventModel) {
		this.lazyEventModel = lazyEventModel;
	}


	
	
	public UploadedFile getFichierPointage() {
		return fichierDePointage;
	}

	public void setFichierPointage(UploadedFile fichierPointage) {
		this.fichierDePointage = fichierPointage;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public IPointageMetier getMetierPointage() {
		return metierPointage;
	}

	public void setMetierPointage(IPointageMetier metierPointage) {
		this.metierPointage = metierPointage;
	}

	public Pointages getPointageAjouter() {
		return pointageAjouter;
	}

	public void setPointageAjouter(Pointages pointageAjouter) {
		this.pointageAjouter = pointageAjouter;
	}
	
	public ISalarieMetier getMetierSalarie() {
		return metierSalarie;
	}

	public void setMetierSalarie(ISalarieMetier metierSalarie) {
		this.metierSalarie = metierSalarie;
	}


	public int getSiKayninDesSalarieMa3andhomchGroupe() {
		return siKayninDesSalarieMa3andhomchGroupe;
	}

	public void setSiKayninDesSalarieMa3andhomchGroupe(int siKayninDesSalarieMa3andhomchGroupe) {
		this.siKayninDesSalarieMa3andhomchGroupe = siKayninDesSalarieMa3andhomchGroupe;
	}

	public int getSiKayninDesGroupeMa3andhomchPlan() {
		return siKayninDesGroupeMa3andhomchPlan;
	}

	public void setSiKayninDesGroupeMa3andhomchPlan(int siKayninDesGroupeMa3andhomchPlan) {
		this.siKayninDesGroupeMa3andhomchPlan = siKayninDesGroupeMa3andhomchPlan;
	}

	
	
	// les methodes
	 
	
	// methode pour verifier si tous est regler
	// in serat appeler dans la méthode init() pour qu'il s'execute au chagement de la page
	public void verifierSiTousEstReglerPourEffectuerLePointage(){
		
		if (metierSalarie.chargerListeSalariesNonAffecterAunGroupe().size()>0) 
		{
			msgQuelqueSalarieNonAffecterAgroupe = "Il exist des salaries qui ne sont affecté a aucun groupe !! Merci de les affectés avant d'éffectuer le pointage.";
			this.siTousEstReglerPourPointage = 1;
			this.siKayninDesSalarieMa3andhomchGroupe=1;
		}
//		else
//		{
//			this.siTousEstReglerPourPointage = 0;
//			this.siKayninDesSalarieMa3andhomchGroupe=0;
//		}
//		
		if (metierGroupe.chargerListeGroupeQuiNePossedePasDePlan().size()>0) 
		{
			msgQuelqueGroupePossedePasDePlan = "Il exist des groupes qui ne posséde aucun plan de travail !! Merci de leurs affectés un plan de travail avant d'éffectuer le pointage.";
			this.siTousEstReglerPourPointage = 1;
			this.siKayninDesGroupeMa3andhomchPlan=1;
		}
//		else
//		{
//			this.siTousEstReglerPourPointage = 0;
//			this.siKayninDesGroupeMa3andhomchPlan=0;
//		}
//		
		
		
	}
	
	// charger liste des salarie non affecter a un groupe
	public List<Salaries> chargerListeSalariesNonAffecterAunGroupe(){
		return metierSalarie.chargerListeSalariesNonAffecterAunGroupe();
		
	}
	
	// charger liste des salarie non affecter a un groupe
		public List<Groupes> chargerlisteGroupeQuiNePossedePasDePlan(){
			return metierGroupe.chargerListeGroupeQuiNePossedePasDePlan();
			
		}
	
	
	
	// pour enregistrer le fichier pointage dans la base
	public void enregistrerFichierPointageDansLaBase() throws ParseException, IOException {
		
	    try {
		    		    	
		     // fileContent = new Scanner(file.getInputStream()).useDelimiter("\\A").next();
		    	
	    	fileContent = new Scanner(fichierDePointage.getInputstream()).useDelimiter("\\A").next();
		      
   	
//   	System.out.println(fileContent);
		      
		      
//		      System.out.println(fileContent);
		      
		      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				
		      String[] strs = fileContent.split("[ \n]");
		      
		      for (int i = 0; i < strs.length; i+=3) {
		    	System.out.println(i + "************");
				System.out.println(strs[i]);
				
				// ta nchoufo dak pointage wach ma kaynch déja 3an nzidouh
				if (!metierPointage.chercherSiPointageExist(formatter.parse(strs[i+1]), strs[i+2], Long.parseLong(strs[i],10))) 
				{
					
					pointageAjouter.setSalarie(metierSalarie.getSalarieById(Long.parseLong(strs[i],10)));
					pointageAjouter.setDatePointage(formatter.parse(strs[i+1]));
					pointageAjouter.setHeurePointage(strs[i+2]);
					metierPointage.ajouterPointage(this.pointageAjouter);
					this.pointageAjouter = new Pointages();
					
				}
				
				
			}
		      
		      
		    } catch (IOException e) {
		      System.out.println("Erreur Lecture fichier");
		    }
		
		
		
		
		
		
		
		// upload du fichier sur le serveur
		
		System.out.println("je suis la **************** Upload sur serveur ***********************");
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
		String filePath="C:/Users/NAOUI/workspaceMars/Gestion_RH/src/main/webapp/fichierProjetPfeGrh/fichiersDePointage/";
      
        byte[] bytes=null;
        String chemin="";
            if (null!=this.fichierDePointage) 
            {
            	
            	
                bytes = this.fichierDePointage.getContents();
                String filename = FilenameUtils.getName(this.fichierDePointage.getFileName());
                String extension = filename.substring(filename.lastIndexOf('.'), filename.length());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+formatter.format(new Date())+extension)));
                chemin = filePath+formatter.format(new Date())+extension;
                stream.write(bytes);
                stream.close();
            }
            

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	// Méthode schedule view
	

	
	
	// cette methode n'admit pas throws ParseException donc gha ndirha bou7adha
		
	@PostConstruct
    public void init() {
       
		// appeler la methode qui verifier si tous est regler
		this.verifierSiTousEstReglerPourEffectuerLePointage();
		
		eventModel = new DefaultScheduleModel();
        try 
        {
          SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
          Date dateDebutDesPointage = formatter.parse("01/04/2016");
          
          List<PointageDatePasse> ls = metierPointageDatePasse.getAllPointageDatePasse();
          for (PointageDatePasse pointageDatePasse : ls) 
          {
			Date dateTemp = formatter.parse(formatter.format(pointageDatePasse.getJour()));
			dateTemp.setHours(dateTemp.getHours()+10);
    		System.out.println("Aprés ajou 10 heures : " + dateTemp);
    		eventModel.addEvent(new DefaultScheduleEvent("Pointage Effectué", dateTemp, dateTemp));
          }
          
          
          
		} 
        catch (ParseException e) 
	    {
			
			e.printStackTrace();
		}

    
    }
	

	     
	    public ScheduleModel getEventModel() {
	        return eventModel;
	    }
	     
	    public ScheduleModel getLazyEventModel() {
	        return lazyEventModel;
	    }  
	     
	    public ScheduleEvent getEvent() {
	        return event;
	    }
	 
	    public void setEvent(ScheduleEvent event) {
	        this.event = event;
	    }
	     
	   // Ajouter un pointage 
	    public void addEvent(ActionEvent actionEvent) {
	    	
	    	System.out.println(event.getStartDate());
	    	
	    	if (metierPointageDatePasse.getPointageDatePasseByDate(event.getStartDate())) 
	    	{
				System.out.println("pointage déja effectuer pour ce jour");
			}
	    	else
	    	{
	    		
	    		// éffectuer le pointage de tous les salaries
	    		List<Salaries> listTousLesSalaries = metierSalarie.getAllSalaries();
	    		for (Salaries salarie : listTousLesSalaries) 
	    		{
					
	    			try 
	    			{
						this.pointageUnSalarieDansUnJour(salarie.getIdSalarie(), event.getStartDate());
					} 
	    			catch (ParseException e) 
	    			{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			
	    			
				}
	    		
	    		
	    		
	    		
	    		
	    		// inseret la date dans la table des date des pointage passe
	    		PointageDatePasse p = new PointageDatePasse();
	    		p.setJour(event.getStartDate());
	    		System.out.println(p.getJour());
	    		System.out.println(p.getIdJourPointu());
	    		metierPointageDatePasse.ajouterPointageDatePasse(p);
	    		
	    		// ajouter l'event pour q'il se affiche sur le <p:schedule
				try 
				{
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date dateTemp = formatter.parse(formatter.format(event.getStartDate()));
					dateTemp.setHours(dateTemp.getHours()+10);
		    		System.out.println("Aprés ajou 10 heures : " + dateTemp);
		    		eventModel.addEvent(new DefaultScheduleEvent("Pointage Effectué", dateTemp, dateTemp));
				} 
				catch (ParseException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	    	}
	    	
//	        if(event.getId() == null)
//	        {
////	            eventModel.addEvent(event);
//	        }
//	        else
//	        {
////	            eventModel.updateEvent(event);
//	        }
//	         
//	        event = new DefaultScheduleEvent();
	    }
	    
	    
	    public void pointageUnSalarieDansUnJour(long idSalarie, Date datePointage) throws ParseException
	    {
	    	PlanTravail p = metierSalarie.chargerPlanTravailUnSalarie(idSalarie);
	    	
	    	
	    
			
			GregorianCalendar calendar =new GregorianCalendar();
			calendar.setTime(datePointage);
			int today =calendar.get(calendar.DAY_OF_WEEK);
		 
			switch (today) {
			case GregorianCalendar.MONDAY:
				System.out.println("Lundi");
				
				
				List<TranchePlanTravail> listTrancheLundi = metierTranche.getTranchePlanTravailByJour("lundi",p.getIdPlan());
								
				// ila kano des tranche 3ad ndiro le pointage
				if (listTrancheLundi.size()>0) 
				{
					for (TranchePlanTravail tranche : listTrancheLundi) 
					{
						// tester si la tranche est normale // khas salarie ikoun pointa fiha
						if (tranche.getCode().equals("Normale")) 
						{
							
							// tester si la tranche est sur deux jours
							// hna la tranche sur un seule jour
							if (!tranche.isDeuxJour()) 
							{
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDate(idSalarie, datePointage);
								
								// ya3ni ma 3ando 7ta pointage 
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										System.out.println("Ma 3ando ta pointage fhad nhar********************************** id salarie" + idSalarie);
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								}
								// hna 3ando des pointages
								else
								{
									/////////////////////////////////////
									boolean wach_kayn_pointage = false;
									Pointages pointageDyalDikTranche = new Pointages();
									// ghadi nchouf wach kayn un pointage fdik la tranche ou nn
									for (Pointages pointage : listPointageSalarie)
									{
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0)
										{
											wach_kayn_pointage = true;
											pointageDyalDikTranche = pointage;
										}
									}
									////////////////////////////////////
									
									if (wach_kayn_pointage) 
									{
										// kayn pointage ya3ni inseret le retard
										Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										
										// khasni n inseret retard ila kan
										//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
										Retards r = new Retards();
										r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
										r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
										r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
										r.setDuree((int)diffMinutePointageHeureDebut);
										r.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierRetard.ajouterRetard(r);
										r = new Retards();
										
									} 
									else 
									{
										// ma kaynch pointage inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											System.out.println("Insertion absence o kayn pointage********************************** id salarie" + idSalarie);
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}

									}
									
									
								}
															

							}
							// hna la tranche sur deux jour
							else
							{
								
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								heureFinTranche.setDate(heureFinTranche.getDate()+1);
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDateEtDateDemain(idSalarie, datePointage);
								
								// hna ma 3ando 7ta pointages
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								} 
								// hna 3ando des pointages
								else 
								{
									
									//////////////////////////////////////////////////////////////////////
									// khasni nchouf wach 3ando un pointage fdik la tranche ou nn
									boolean wach_kayn_pointage = false;
									boolean wach_pointa_9bal_12_dlil = false;
									Pointages pointageDyalDikTranche = new Pointages();
									for (Pointages pointage : listPointageSalarie) 
									{
										// hna khasni na3raf l'heure de pointage wach 9bal 00:00 ola man ba3dha bach nchouf wach nzid nhar ou nn
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										
										SimpleDateFormat formatterHeureSeule = new SimpleDateFormat("HH");
										int heureSeulePointage = Integer.parseInt(formatterHeureSeule.format(heurePointage));
										int heureDebutTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureDebutTranche));
										int heureFinTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureFinTranche));
										
										// hna rah pointi 9bal 00:00
										if (heureSeulePointage >= heureDebutTrancheSeule && heureSeulePointage <=23) 
										{
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = true;
											}
											
											
										}
										// hna rah pointi man ba3d 00:00
										else if ( heureSeulePointage >=0 && heureSeulePointage <= heureFinTrancheSeule)
										{
											
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = false;
											}
											
										}
										
									}
									///////////////////////////////////////////////////////////////////////
									
									
									/////////////////////////////////////////////////////////////////////////////
									// aprés had traitement gha nchoufo wach kan chi pointage ou nn
									
									if (wach_kayn_pointage) 
									{
										// wach 9bal oloa ba3d 12 dlil
										if (wach_pointa_9bal_12_dlil) 
										{
											// 9bal 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
										else
										{
											// ba3d 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
									}
									else
									{
										
										// ma 3andoch pointage fdik tranche inseret lih absence
										// khasni n inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}
										
										
									}
									
									/////////////////////////////////////////////////////////////////////////////
									
								}
								
					
							}
							
						}
					}
				}
				
				
				break;
			case GregorianCalendar.TUESDAY:
				System.out.println("Mardi");
				
				
				List<TranchePlanTravail> listTrancheMardi = metierTranche.getTranchePlanTravailByJour("mardi",p.getIdPlan());
				
				// ila kano des tranche 3ad ndiro le pointage
				if (listTrancheMardi.size()>0) 
				{
					for (TranchePlanTravail tranche : listTrancheMardi) 
					{
						// tester si la tranche est normale // khas salarie ikoun pointa fiha
						if (tranche.getCode().equals("Normale")) 
						{
							
							// tester si la tranche est sur deux jours
							// hna la tranche sur un seule jour
							if (!tranche.isDeuxJour()) 
							{
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDate(idSalarie, datePointage);
								
								// ya3ni ma 3ando 7ta pointage 
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										System.out.println("Ma 3ando ta pointage fhad nhar********************************** id salarie" + idSalarie);
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								}
								// hna 3ando des pointages
								else
								{
									/////////////////////////////////////
									boolean wach_kayn_pointage = false;
									Pointages pointageDyalDikTranche = new Pointages();
									// ghadi nchouf wach kayn un pointage fdik la tranche ou nn
									for (Pointages pointage : listPointageSalarie)
									{
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0)
										{
											wach_kayn_pointage = true;
											pointageDyalDikTranche = pointage;
										}
									}
									////////////////////////////////////
									
									if (wach_kayn_pointage) 
									{
										// kayn pointage ya3ni inseret le retard
										Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										
										// khasni n inseret retard ila kan
										//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
										Retards r = new Retards();
										r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
										r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
										r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
										r.setDuree((int)diffMinutePointageHeureDebut);
										r.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierRetard.ajouterRetard(r);
										r = new Retards();
										
									} 
									else 
									{
										// ma kaynch pointage inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											System.out.println("Insertion absence o kayn pointage********************************** id salarie" + idSalarie);
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}

									}
									
									
								}
															

							}
							// hna la tranche sur deux jour
							else
							{
								
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								heureFinTranche.setDate(heureFinTranche.getDate()+1);
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDateEtDateDemain(idSalarie, datePointage);
								
								// hna ma 3ando 7ta pointages
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								} 
								// hna 3ando des pointages
								else 
								{
									
									//////////////////////////////////////////////////////////////////////
									// khasni nchouf wach 3ando un pointage fdik la tranche ou nn
									boolean wach_kayn_pointage = false;
									boolean wach_pointa_9bal_12_dlil = false;
									Pointages pointageDyalDikTranche = new Pointages();
									for (Pointages pointage : listPointageSalarie) 
									{
										// hna khasni na3raf l'heure de pointage wach 9bal 00:00 ola man ba3dha bach nchouf wach nzid nhar ou nn
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										
										SimpleDateFormat formatterHeureSeule = new SimpleDateFormat("HH");
										int heureSeulePointage = Integer.parseInt(formatterHeureSeule.format(heurePointage));
										int heureDebutTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureDebutTranche));
										int heureFinTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureFinTranche));
										
										// hna rah pointi 9bal 00:00
										if (heureSeulePointage >= heureDebutTrancheSeule && heureSeulePointage <=23) 
										{
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = true;
											}
											
											
										}
										// hna rah pointi man ba3d 00:00
										else if ( heureSeulePointage >=0 && heureSeulePointage <= heureFinTrancheSeule)
										{
											
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = false;
											}
											
										}
										
									}
									///////////////////////////////////////////////////////////////////////
									
									
									/////////////////////////////////////////////////////////////////////////////
									// aprés had traitement gha nchoufo wach kan chi pointage ou nn
									
									if (wach_kayn_pointage) 
									{
										// wach 9bal oloa ba3d 12 dlil
										if (wach_pointa_9bal_12_dlil) 
										{
											// 9bal 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
										else
										{
											// ba3d 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
									}
									else
									{
										
										// ma 3andoch pointage fdik tranche inseret lih absence
										// khasni n inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}
										
										
									}
									
									/////////////////////////////////////////////////////////////////////////////
									
								}
								
					
							}
							
						}
					}
				}
				
				
				break;
		 
			case GregorianCalendar.WEDNESDAY:
				System.out.println("Mercredi");
				
				
				List<TranchePlanTravail> listTrancheMercredi = metierTranche.getTranchePlanTravailByJour("mercredi",p.getIdPlan());
				
				// ila kano des tranche 3ad ndiro le pointage
				if (listTrancheMercredi.size()>0) 
				{
					for (TranchePlanTravail tranche : listTrancheMercredi) 
					{
						// tester si la tranche est normale // khas salarie ikoun pointa fiha
						if (tranche.getCode().equals("Normale")) 
						{
							
							// tester si la tranche est sur deux jours
							// hna la tranche sur un seule jour
							if (!tranche.isDeuxJour()) 
							{
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDate(idSalarie, datePointage);
								
								// ya3ni ma 3ando 7ta pointage 
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										System.out.println("Ma 3ando ta pointage fhad nhar********************************** id salarie" + idSalarie);
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								}
								// hna 3ando des pointages
								else
								{
									/////////////////////////////////////
									boolean wach_kayn_pointage = false;
									Pointages pointageDyalDikTranche = new Pointages();
									// ghadi nchouf wach kayn un pointage fdik la tranche ou nn
									for (Pointages pointage : listPointageSalarie)
									{
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0)
										{
											wach_kayn_pointage = true;
											pointageDyalDikTranche = pointage;
										}
									}
									////////////////////////////////////
									
									if (wach_kayn_pointage) 
									{
										// kayn pointage ya3ni inseret le retard
										Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										
										// khasni n inseret retard ila kan
										//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
										Retards r = new Retards();
										r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
										r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
										r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
										r.setDuree((int)diffMinutePointageHeureDebut);
										r.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierRetard.ajouterRetard(r);
										r = new Retards();
										
									} 
									else 
									{
										// ma kaynch pointage inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											System.out.println("Insertion absence o kayn pointage********************************** id salarie" + idSalarie);
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}

									}
									
									
								}
															

							}
							// hna la tranche sur deux jour
							else
							{
								
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								heureFinTranche.setDate(heureFinTranche.getDate()+1);
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDateEtDateDemain(idSalarie, datePointage);
								
								// hna ma 3ando 7ta pointages
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								} 
								// hna 3ando des pointages
								else 
								{
									
									//////////////////////////////////////////////////////////////////////
									// khasni nchouf wach 3ando un pointage fdik la tranche ou nn
									boolean wach_kayn_pointage = false;
									boolean wach_pointa_9bal_12_dlil = false;
									Pointages pointageDyalDikTranche = new Pointages();
									for (Pointages pointage : listPointageSalarie) 
									{
										// hna khasni na3raf l'heure de pointage wach 9bal 00:00 ola man ba3dha bach nchouf wach nzid nhar ou nn
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										
										SimpleDateFormat formatterHeureSeule = new SimpleDateFormat("HH");
										int heureSeulePointage = Integer.parseInt(formatterHeureSeule.format(heurePointage));
										int heureDebutTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureDebutTranche));
										int heureFinTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureFinTranche));
										
										// hna rah pointi 9bal 00:00
										if (heureSeulePointage >= heureDebutTrancheSeule && heureSeulePointage <=23) 
										{
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = true;
											}
											
											
										}
										// hna rah pointi man ba3d 00:00
										else if ( heureSeulePointage >=0 && heureSeulePointage <= heureFinTrancheSeule)
										{
											
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = false;
											}
											
										}
										
									}
									///////////////////////////////////////////////////////////////////////
									
									
									/////////////////////////////////////////////////////////////////////////////
									// aprés had traitement gha nchoufo wach kan chi pointage ou nn
									
									if (wach_kayn_pointage) 
									{
										// wach 9bal oloa ba3d 12 dlil
										if (wach_pointa_9bal_12_dlil) 
										{
											// 9bal 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
										else
										{
											// ba3d 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
									}
									else
									{
										
										// ma 3andoch pointage fdik tranche inseret lih absence
										// khasni n inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}
										
										
									}
									
									/////////////////////////////////////////////////////////////////////////////
									
								}
								
					
							}
							
						}
					}
				}
				
				break;
				
			case GregorianCalendar.THURSDAY:
				System.out.println("Jeudi");
				
				
				
				List<TranchePlanTravail> listTrancheJeudi = metierTranche.getTranchePlanTravailByJour("jeudi",p.getIdPlan());
				
				// ila kano des tranche 3ad ndiro le pointage
				if (listTrancheJeudi.size()>0) 
				{
					for (TranchePlanTravail tranche : listTrancheJeudi) 
					{
						// tester si la tranche est normale // khas salarie ikoun pointa fiha
						if (tranche.getCode().equals("Normale")) 
						{
							
							// tester si la tranche est sur deux jours
							// hna la tranche sur un seule jour
							if (!tranche.isDeuxJour()) 
							{
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDate(idSalarie, datePointage);
								
								// ya3ni ma 3ando 7ta pointage 
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										System.out.println("Ma 3ando ta pointage fhad nhar********************************** id salarie" + idSalarie);
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								}
								// hna 3ando des pointages
								else
								{
									/////////////////////////////////////
									boolean wach_kayn_pointage = false;
									Pointages pointageDyalDikTranche = new Pointages();
									// ghadi nchouf wach kayn un pointage fdik la tranche ou nn
									for (Pointages pointage : listPointageSalarie)
									{
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0)
										{
											wach_kayn_pointage = true;
											pointageDyalDikTranche = pointage;
										}
									}
									////////////////////////////////////
									
									if (wach_kayn_pointage) 
									{
										// kayn pointage ya3ni inseret le retard
										Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										
										// khasni n inseret retard ila kan
										//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
										Retards r = new Retards();
										r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
										r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
										r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
										r.setDuree((int)diffMinutePointageHeureDebut);
										r.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierRetard.ajouterRetard(r);
										r = new Retards();
										
									} 
									else 
									{
										// ma kaynch pointage inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											System.out.println("Insertion absence o kayn pointage********************************** id salarie" + idSalarie);
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}

									}
									
									
								}
															

							}
							// hna la tranche sur deux jour
							else
							{
								
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								heureFinTranche.setDate(heureFinTranche.getDate()+1);
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDateEtDateDemain(idSalarie, datePointage);
								
								// hna ma 3ando 7ta pointages
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								} 
								// hna 3ando des pointages
								else 
								{
									
									//////////////////////////////////////////////////////////////////////
									// khasni nchouf wach 3ando un pointage fdik la tranche ou nn
									boolean wach_kayn_pointage = false;
									boolean wach_pointa_9bal_12_dlil = false;
									Pointages pointageDyalDikTranche = new Pointages();
									for (Pointages pointage : listPointageSalarie) 
									{
										// hna khasni na3raf l'heure de pointage wach 9bal 00:00 ola man ba3dha bach nchouf wach nzid nhar ou nn
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										
										SimpleDateFormat formatterHeureSeule = new SimpleDateFormat("HH");
										int heureSeulePointage = Integer.parseInt(formatterHeureSeule.format(heurePointage));
										int heureDebutTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureDebutTranche));
										int heureFinTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureFinTranche));
										
										// hna rah pointi 9bal 00:00
										if (heureSeulePointage >= heureDebutTrancheSeule && heureSeulePointage <=23) 
										{
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = true;
											}
											
											
										}
										// hna rah pointi man ba3d 00:00
										else if ( heureSeulePointage >=0 && heureSeulePointage <= heureFinTrancheSeule)
										{
											
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = false;
											}
											
										}
										
									}
									///////////////////////////////////////////////////////////////////////
									
									
									/////////////////////////////////////////////////////////////////////////////
									// aprés had traitement gha nchoufo wach kan chi pointage ou nn
									
									if (wach_kayn_pointage) 
									{
										// wach 9bal oloa ba3d 12 dlil
										if (wach_pointa_9bal_12_dlil) 
										{
											// 9bal 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
										else
										{
											// ba3d 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
									}
									else
									{
										
										// ma 3andoch pointage fdik tranche inseret lih absence
										// khasni n inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}
										
										
									}
									
									/////////////////////////////////////////////////////////////////////////////
									
								}
								
					
							}
							
						}
					}
				}
				
				break;
				
			case GregorianCalendar.FRIDAY:
				System.out.println("Vendredi");
				
				
				
				List<TranchePlanTravail> listTrancheVendredi = metierTranche.getTranchePlanTravailByJour("vendredi",p.getIdPlan());
				
				// ila kano des tranche 3ad ndiro le pointage
				if (listTrancheVendredi.size()>0) 
				{
					for (TranchePlanTravail tranche : listTrancheVendredi) 
					{
						// tester si la tranche est normale // khas salarie ikoun pointa fiha
						if (tranche.getCode().equals("Normale")) 
						{
							
							// tester si la tranche est sur deux jours
							// hna la tranche sur un seule jour
							if (!tranche.isDeuxJour()) 
							{
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDate(idSalarie, datePointage);
								
								// ya3ni ma 3ando 7ta pointage 
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										System.out.println("Ma 3ando ta pointage fhad nhar********************************** id salarie" + idSalarie);
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								}
								// hna 3ando des pointages
								else
								{
									/////////////////////////////////////
									boolean wach_kayn_pointage = false;
									Pointages pointageDyalDikTranche = new Pointages();
									// ghadi nchouf wach kayn un pointage fdik la tranche ou nn
									for (Pointages pointage : listPointageSalarie)
									{
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0)
										{
											wach_kayn_pointage = true;
											pointageDyalDikTranche = pointage;
										}
									}
									////////////////////////////////////
									
									if (wach_kayn_pointage) 
									{
										// kayn pointage ya3ni inseret le retard
										Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										
										// khasni n inseret retard ila kan
										//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
										Retards r = new Retards();
										r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
										r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
										r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
										r.setDuree((int)diffMinutePointageHeureDebut);
										r.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierRetard.ajouterRetard(r);
										r = new Retards();
										
									} 
									else 
									{
										// ma kaynch pointage inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											System.out.println("Insertion absence o kayn pointage********************************** id salarie" + idSalarie);
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}

									}
									
									
								}
															

							}
							// hna la tranche sur deux jour
							else
							{
								
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								heureFinTranche.setDate(heureFinTranche.getDate()+1);
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDateEtDateDemain(idSalarie, datePointage);
								
								// hna ma 3ando 7ta pointages
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								} 
								// hna 3ando des pointages
								else 
								{
									
									//////////////////////////////////////////////////////////////////////
									// khasni nchouf wach 3ando un pointage fdik la tranche ou nn
									boolean wach_kayn_pointage = false;
									boolean wach_pointa_9bal_12_dlil = false;
									Pointages pointageDyalDikTranche = new Pointages();
									for (Pointages pointage : listPointageSalarie) 
									{
										// hna khasni na3raf l'heure de pointage wach 9bal 00:00 ola man ba3dha bach nchouf wach nzid nhar ou nn
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										
										SimpleDateFormat formatterHeureSeule = new SimpleDateFormat("HH");
										int heureSeulePointage = Integer.parseInt(formatterHeureSeule.format(heurePointage));
										int heureDebutTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureDebutTranche));
										int heureFinTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureFinTranche));
										
										// hna rah pointi 9bal 00:00
										if (heureSeulePointage >= heureDebutTrancheSeule && heureSeulePointage <=23) 
										{
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = true;
											}
											
											
										}
										// hna rah pointi man ba3d 00:00
										else if ( heureSeulePointage >=0 && heureSeulePointage <= heureFinTrancheSeule)
										{
											
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = false;
											}
											
										}
										
									}
									///////////////////////////////////////////////////////////////////////
									
									
									/////////////////////////////////////////////////////////////////////////////
									// aprés had traitement gha nchoufo wach kan chi pointage ou nn
									
									if (wach_kayn_pointage) 
									{
										// wach 9bal oloa ba3d 12 dlil
										if (wach_pointa_9bal_12_dlil) 
										{
											// 9bal 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
										else
										{
											// ba3d 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
									}
									else
									{
										
										// ma 3andoch pointage fdik tranche inseret lih absence
										// khasni n inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}
										
										
									}
									
									/////////////////////////////////////////////////////////////////////////////
									
								}
								
					
							}
							
						}
					}
				}
				
				
				break;
				
			case GregorianCalendar.SATURDAY:
				System.out.println("Samedi");
				
				
				List<TranchePlanTravail> listTrancheSamedi = metierTranche.getTranchePlanTravailByJour("samedi",p.getIdPlan());
				
				// ila kano des tranche 3ad ndiro le pointage
				if (listTrancheSamedi.size()>0) 
				{
					for (TranchePlanTravail tranche : listTrancheSamedi) 
					{
						// tester si la tranche est normale // khas salarie ikoun pointa fiha
						if (tranche.getCode().equals("Normale")) 
						{
							
							// tester si la tranche est sur deux jours
							// hna la tranche sur un seule jour
							if (!tranche.isDeuxJour()) 
							{
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDate(idSalarie, datePointage);
								
								// ya3ni ma 3ando 7ta pointage 
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										System.out.println("Ma 3ando ta pointage fhad nhar********************************** id salarie" + idSalarie);
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								}
								// hna 3ando des pointages
								else
								{
									/////////////////////////////////////
									boolean wach_kayn_pointage = false;
									Pointages pointageDyalDikTranche = new Pointages();
									// ghadi nchouf wach kayn un pointage fdik la tranche ou nn
									for (Pointages pointage : listPointageSalarie)
									{
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0)
										{
											wach_kayn_pointage = true;
											pointageDyalDikTranche = pointage;
										}
									}
									////////////////////////////////////
									
									if (wach_kayn_pointage) 
									{
										// kayn pointage ya3ni inseret le retard
										Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										
										// khasni n inseret retard ila kan
										//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
										Retards r = new Retards();
										r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
										r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
										r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
										r.setDuree((int)diffMinutePointageHeureDebut);
										r.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierRetard.ajouterRetard(r);
										r = new Retards();
										
									} 
									else 
									{
										// ma kaynch pointage inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											System.out.println("Insertion absence o kayn pointage********************************** id salarie" + idSalarie);
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}

									}
									
									
								}
															

							}
							// hna la tranche sur deux jour
							else
							{
								
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								heureFinTranche.setDate(heureFinTranche.getDate()+1);
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDateEtDateDemain(idSalarie, datePointage);
								
								// hna ma 3ando 7ta pointages
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								} 
								// hna 3ando des pointages
								else 
								{
									
									//////////////////////////////////////////////////////////////////////
									// khasni nchouf wach 3ando un pointage fdik la tranche ou nn
									boolean wach_kayn_pointage = false;
									boolean wach_pointa_9bal_12_dlil = false;
									Pointages pointageDyalDikTranche = new Pointages();
									for (Pointages pointage : listPointageSalarie) 
									{
										// hna khasni na3raf l'heure de pointage wach 9bal 00:00 ola man ba3dha bach nchouf wach nzid nhar ou nn
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										
										SimpleDateFormat formatterHeureSeule = new SimpleDateFormat("HH");
										int heureSeulePointage = Integer.parseInt(formatterHeureSeule.format(heurePointage));
										int heureDebutTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureDebutTranche));
										int heureFinTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureFinTranche));
										
										// hna rah pointi 9bal 00:00
										if (heureSeulePointage >= heureDebutTrancheSeule && heureSeulePointage <=23) 
										{
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = true;
											}
											
											
										}
										// hna rah pointi man ba3d 00:00
										else if ( heureSeulePointage >=0 && heureSeulePointage <= heureFinTrancheSeule)
										{
											
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = false;
											}
											
										}
										
									}
									///////////////////////////////////////////////////////////////////////
									
									
									/////////////////////////////////////////////////////////////////////////////
									// aprés had traitement gha nchoufo wach kan chi pointage ou nn
									
									if (wach_kayn_pointage) 
									{
										// wach 9bal oloa ba3d 12 dlil
										if (wach_pointa_9bal_12_dlil) 
										{
											// 9bal 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
										else
										{
											// ba3d 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
									}
									else
									{
										
										// ma 3andoch pointage fdik tranche inseret lih absence
										// khasni n inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}
										
										
									}
									
									/////////////////////////////////////////////////////////////////////////////
									
								}
								
					
							}
							
						}
					}
				}
				
				break;
				
			case GregorianCalendar.SUNDAY:
				System.out.println("Dimanche");
				
				
				List<TranchePlanTravail> listTrancheDimanche = metierTranche.getTranchePlanTravailByJour("dimanche",p.getIdPlan());
				
				// ila kano des tranche 3ad ndiro le pointage
				if (listTrancheDimanche.size()>0) 
				{
					for (TranchePlanTravail tranche : listTrancheDimanche) 
					{
						// tester si la tranche est normale // khas salarie ikoun pointa fiha
						if (tranche.getCode().equals("Normale")) 
						{
							
							// tester si la tranche est sur deux jours
							// hna la tranche sur un seule jour
							if (!tranche.isDeuxJour()) 
							{
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDate(idSalarie, datePointage);
								
								// ya3ni ma 3ando 7ta pointage 
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										System.out.println("Ma 3ando ta pointage fhad nhar********************************** id salarie" + idSalarie);
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								}
								// hna 3ando des pointages
								else
								{
									/////////////////////////////////////
									boolean wach_kayn_pointage = false;
									Pointages pointageDyalDikTranche = new Pointages();
									// ghadi nchouf wach kayn un pointage fdik la tranche ou nn
									for (Pointages pointage : listPointageSalarie)
									{
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0)
										{
											wach_kayn_pointage = true;
											pointageDyalDikTranche = pointage;
										}
									}
									////////////////////////////////////
									
									if (wach_kayn_pointage) 
									{
										// kayn pointage ya3ni inseret le retard
										Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
										long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
										long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
										
										// khasni n inseret retard ila kan
										//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
										Retards r = new Retards();
										r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
										r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
										r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
										r.setDuree((int)diffMinutePointageHeureDebut);
										r.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierRetard.ajouterRetard(r);
										r = new Retards();
										
									} 
									else 
									{
										// ma kaynch pointage inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											System.out.println("Insertion absence o kayn pointage********************************** id salarie" + idSalarie);
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}

									}
									
									
								}
															

							}
							// hna la tranche sur deux jour
							else
							{
								
								Date heureDebutTranche = tranche.getHeureDebut();
								Date heureFinTranche = tranche.getHeureFin();
								heureFinTranche.setDate(heureFinTranche.getDate()+1);
								long diffMinuteTranche = (heureFinTranche.getTime() - heureDebutTranche.getTime()) / 60000l;
								SimpleDateFormat formatterHeure = new SimpleDateFormat("HH:mm:ss");
								
								List<Pointages> listPointageSalarie = metierPointage.chargerPointageSalarieUneDateEtDateDemain(idSalarie, datePointage);
								
								// hna ma 3ando 7ta pointages
								if (listPointageSalarie.size()<=0) 
								{
									
									// khasni n inseret absence
									// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
									if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
									{
										A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
										a_non_justifiee.setDateAbsence(datePointage);
										a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
										a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
										a_non_justifiee.setDuree((int)diffMinuteTranche);
										a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
										metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
										a_non_justifiee = new A_Non_Justifiee();
										
									}
									
								} 
								// hna 3ando des pointages
								else 
								{
									
									//////////////////////////////////////////////////////////////////////
									// khasni nchouf wach 3ando un pointage fdik la tranche ou nn
									boolean wach_kayn_pointage = false;
									boolean wach_pointa_9bal_12_dlil = false;
									Pointages pointageDyalDikTranche = new Pointages();
									for (Pointages pointage : listPointageSalarie) 
									{
										// hna khasni na3raf l'heure de pointage wach 9bal 00:00 ola man ba3dha bach nchouf wach nzid nhar ou nn
										Date heurePointage = formatterHeure.parse(pointage.getHeurePointage());
										
										SimpleDateFormat formatterHeureSeule = new SimpleDateFormat("HH");
										int heureSeulePointage = Integer.parseInt(formatterHeureSeule.format(heurePointage));
										int heureDebutTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureDebutTranche));
										int heureFinTrancheSeule = Integer.parseInt(formatterHeureSeule.format(heureFinTranche));
										
										// hna rah pointi 9bal 00:00
										if (heureSeulePointage >= heureDebutTrancheSeule && heureSeulePointage <=23) 
										{
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = true;
											}
											
											
										}
										// hna rah pointi man ba3d 00:00
										else if ( heureSeulePointage >=0 && heureSeulePointage <= heureFinTrancheSeule)
										{
											
											heurePointage = formatterHeure.parse(pointage.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											if (diffMinutePointageHeureDebut>=0 && diffMinutePointageHeureFin>=0) 
											{
												wach_kayn_pointage = true;
												pointageDyalDikTranche = pointage;
												wach_pointa_9bal_12_dlil = false;
											}
											
										}
										
									}
									///////////////////////////////////////////////////////////////////////
									
									
									/////////////////////////////////////////////////////////////////////////////
									// aprés had traitement gha nchoufo wach kan chi pointage ou nn
									
									if (wach_kayn_pointage) 
									{
										// wach 9bal oloa ba3d 12 dlil
										if (wach_pointa_9bal_12_dlil) 
										{
											// 9bal 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
										else
										{
											// ba3d 00:00
											Date heurePointage = formatterHeure.parse(pointageDyalDikTranche.getHeurePointage());
											heurePointage.setDate(heurePointage.getDate()+1);
											
											long diffMinutePointageHeureDebut = (heurePointage.getTime() - heureDebutTranche.getTime()) / 60000l;
											long diffMinutePointageHeureFin = (heureFinTranche.getTime() - heurePointage.getTime()) / 60000l;
											
											// khasni n inseret retard ila kan
											//SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
											Retards r = new Retards();
											r.setDateRetardPointage(pointageDyalDikTranche.getDatePointage());
											r.setHeureNormalePointage(formatterHeure.format(tranche.getHeureDebut()));
											r.setHeurePointageEnRetard(pointageDyalDikTranche.getHeurePointage());
											r.setDuree((int)diffMinutePointageHeureDebut);
											r.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierRetard.ajouterRetard(r);
											r = new Retards();
											
										}
									}
									else
									{
										
										// ma 3andoch pointage fdik tranche inseret lih absence
										// khasni n inseret absence
										// avant d'inseret l'absence il faut verifier yakma 3ando conger ola jours ferier
										if (!metierJourFerie.testerSiJourFerie(datePointage) || metierConges.chargerCongesSalarieUneDate(idSalarie, datePointage).size()<=0) 
										{
											A_Non_Justifiee a_non_justifiee = new A_Non_Justifiee();
											a_non_justifiee.setDateAbsence(datePointage);
											a_non_justifiee.setHeureDebutAbsence(formatterHeure.format(tranche.getHeureDebut()));
											a_non_justifiee.setHeureFinAbsence(formatterHeure.format(tranche.getHeureFin()));
											a_non_justifiee.setDuree((int)diffMinuteTranche);
											a_non_justifiee.setSalarie(metierSalarie.getSalarieById(idSalarie));
											metierA_Non_Justifiee.ajouterA_Non_Justifiee(a_non_justifiee);
											a_non_justifiee = new A_Non_Justifiee();
											
										}
										
										
									}
									
									/////////////////////////////////////////////////////////////////////////////
									
								}
								
					
							}
							
						}
					}
				}
				
				break;
		 
			default:
				//ça devrait pas erreur
				break;
			}
	    	
	    	
	    }
	    
	    
	     
	    public void onEventSelect(SelectEvent selectEvent) {
	        event = (ScheduleEvent) selectEvent.getObject();
	    }
	     
	    public void onDateSelect(SelectEvent selectEvent) {
	        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	    }
	     
	    public void onEventMove(ScheduleEntryMoveEvent event) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
	         
	        addMessage(message);
	    }
	     
	    public void onEventResize(ScheduleEntryResizeEvent event) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
	         
	        addMessage(message);
	    }
	     
	    private void addMessage(FacesMessage message) {
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
	
	
	
	

}
