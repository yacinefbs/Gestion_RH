package ma.bps.presentation;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import defaults.UploadFile;
import ma.bps.entities.AdressesPrivee;
import ma.bps.entities.AdressesPro;
import ma.bps.entities.Agences;
import ma.bps.entities.Avances;
import ma.bps.entities.Banques;
import ma.bps.entities.Conges;
import ma.bps.entities.Contrats;
import ma.bps.entities.F_Initiale;
import ma.bps.entities.F_Professionnelles;
import ma.bps.entities.Prets;
import ma.bps.entities.PrimesAvantages;
import ma.bps.entities.Qualifications;
import ma.bps.entities.Salaires;
import ma.bps.entities.Salaries;
import ma.bps.entities.Services;
import ma.bps.entities.Societes;
import ma.bps.entities.Utilisateurs;
import ma.bps.metier.AdressePriveeMetierImpl;
import ma.bps.metier.AdresseProMetierImpl;
import ma.bps.metier.AgenceMetierImpl;
import ma.bps.metier.AvanceMetierImpl;
import ma.bps.metier.BanqueMetierImpl;
import ma.bps.metier.CongeMetierImpl;
import ma.bps.metier.ContratMetierImpl;
import ma.bps.metier.F_InitialeMetierImpl;
import ma.bps.metier.F_ProfessionnelleMetierImpl;
import ma.bps.metier.GroupeMetierImpl;
import ma.bps.metier.IAdressePriveeMetier;
import ma.bps.metier.IAdresseProMetier;
import ma.bps.metier.IAgenceMetier;
import ma.bps.metier.IAvanceMetier;
import ma.bps.metier.IBanqueMetier;
//import ma.bps.metier.ICDDMetier;
//import ma.bps.metier.ICDIMetier;
import ma.bps.metier.ICongeMetier;
import ma.bps.metier.IContratMetier;
import ma.bps.metier.IF_InitialeMetier;
import ma.bps.metier.IF_ProfessionnelleMetier;
import ma.bps.metier.IGroupeMetier;
import ma.bps.metier.IModePaiementMetier;
//import ma.bps.metier.IOccasionnelMetier;
import ma.bps.metier.IPretsMetier;
import ma.bps.metier.IPrimeAvantageMetier;
import ma.bps.metier.IQualificationMetier;
import ma.bps.metier.ISalaireMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.IServiceMetier;
import ma.bps.metier.ISiteMetier;
import ma.bps.metier.IUtilisateurMetier;
import ma.bps.metier.ModePaiementMetierImpl;
//import ma.bps.metier.OccasionnelMetierImpl;
import ma.bps.metier.PretsMetierImpl;
import ma.bps.metier.PrimeAvantageMetierImpl;
import ma.bps.metier.QualificationMetierImpl;
import ma.bps.metier.SalaireMetierImpl;
import ma.bps.metier.SalarieMetierImpl;
import ma.bps.metier.ServiceMetierImpl;
import ma.bps.metier.SiteMetierImpl;
import ma.bps.metier.UtilisateurMetierImpl;

@ManagedBean
@SessionScoped
public class BeanSalarie {
	
	private ISalarieMetier salarieMetier = new SalarieMetierImpl();
	private IQualificationMetier qualificationMetier = new QualificationMetierImpl();
	private IServiceMetier serviveMetier = new ServiceMetierImpl();
	private ISiteMetier siteMetier = new SiteMetierImpl();
//	private ICDDMetier cddMetier = new CDDMetierImpl();
//	private ICDIMetier cdiMetier = new CDIMetierImpl();
//	private IANAPECMetier anapecMetier = new ANAPECMetierImpl();
//	private IOccasionnelMetier occasionnelMetier = new OccasionnelMetierImpl();
	private IBanqueMetier banqueMetier = new BanqueMetierImpl();
	private IContratMetier contratMetier = new ContratMetierImpl();
	private ICongeMetier congeMetier = new CongeMetierImpl();
	private IModePaiementMetier modePaiementMetier = new ModePaiementMetierImpl();
	private ISalaireMetier salaireMetier = new SalaireMetierImpl();
	private IAgenceMetier agenceMetier = new AgenceMetierImpl();
	private IAvanceMetier avanceMetier = new AvanceMetierImpl();
	private IAdressePriveeMetier adressePriveeMetier = new AdressePriveeMetierImpl();
	private IAdresseProMetier adresseProMetier = new AdresseProMetierImpl();
	private IPretsMetier pretMetier = new PretsMetierImpl();
	private IPrimeAvantageMetier primeAvantageMetier = new PrimeAvantageMetierImpl();
	private IF_InitialeMetier f_initialeMetier = new F_InitialeMetierImpl();
	private IF_ProfessionnelleMetier f_professionnelleMetier = new F_ProfessionnelleMetierImpl();
	private IUtilisateurMetier utilisateurMetier = new UtilisateurMetierImpl();
	private IGroupeMetier groupeMetier = new GroupeMetierImpl();
	
	private String dateNaissance;
	private String dateValiditePassport;
	private String dateEmissionPassport;

	private Date date;
	private int modification=0;
	private int modificationContrat=0;
	private int modificationConge=0;
	private int modificationPret = 0;
	private int modificationAvance = 0;
	private int modificationF_Initiale = 0;
	private int modificationF_Pro = 0; 
	private double nbrJoursCongeRestant=0;
	private String msgSucces=null;
	private String msgSuccesConge = null;
	private String msgSuccesContrat = null;
	private String msgSuccesPret = null;
	private String msgSuccesAvance = null;
	private String msgSuccesFInitiales = null;
	private String msgSuccesFPro = null;
	
	
	
	public int getModificationF_Pro() {
		return modificationF_Pro;
	}
	public void setModificationF_Pro(int modificationF_Pro) {
		this.modificationF_Pro = modificationF_Pro;
	}
	public String getMsgSuccesFPro() {
		return msgSuccesFPro;
	}
	public void setMsgSuccesFPro(String msgSuccesFPro) {
		this.msgSuccesFPro = msgSuccesFPro;
	}
	public int getModificationF_Initiale() {
		return modificationF_Initiale;
	}
	public void setModificationF_Initiale(int modificationF_Initiale) {
		this.modificationF_Initiale = modificationF_Initiale;
	}
	public String getMsgSuccesFInitiales() {
		return msgSuccesFInitiales;
	}
	public void setMsgSuccesFInitiales(String msgSuccesFInitiales) {
		this.msgSuccesFInitiales = msgSuccesFInitiales;
	}
	public int getModificationAvance() {
		return modificationAvance;
	}
	public void setModificationAvance(int modificationAvance) {
		this.modificationAvance = modificationAvance;
	}
	public String getMsgSuccesAvance() {
		return msgSuccesAvance;
	}
	public void setMsgSuccesAvance(String msgSuccesAvance) {
		this.msgSuccesAvance = msgSuccesAvance;
	}
	public String getMsgSuccesConge() {
		return msgSuccesConge;
	}
	public void setMsgSuccesConge(String msgSuccesConge) {
		this.msgSuccesConge = msgSuccesConge;
	}
	public int getModificationPret() {
		return modificationPret;
	}
	public void setModificationPret(int modificationPret) {
		this.modificationPret = modificationPret;
	}
	public String getMsgSuccesPret() {
		return msgSuccesPret;
	}
	public void setMsgSuccesPret(String msgSuccesPret) {
		this.msgSuccesPret = msgSuccesPret;
	}
	public int getModificationContrat() {
		return modificationContrat;
	}
	public void setModificationContrat(int modificationContrat) {
		this.modificationContrat = modificationContrat;
	}
	public String getMsgSuccesContrat() {
		return msgSuccesContrat;
	}
	public void setMsgSuccesContrat(String msgSuccesContrat) {
		this.msgSuccesContrat = msgSuccesContrat;
	}
	public String getMsgSucces() {
		return msgSucces;
	}
	public void setMsgSucces(String msgSucces) {
		this.msgSucces = msgSucces;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	//Contrat : 
	private String dateDebutContrat;
	private String dateFinContrat;
	private String profil;
	private String typeContrat;

	private List<Contrats> listContrats;
	
	//Congé : 
	private List<Conges> listConges;
	
	//Comptabilité financière :
	private Long modePaiementSalaireBase;
	private Long modePaiementAvantages;
	
	
	
	
	private UploadedFile photoSalarie;
	
	

	public UploadedFile getPhotoSalarie() {
		return photoSalarie;
	}
	public void setPhotoSalarie(UploadedFile photoSalarie) {
		this.photoSalarie = photoSalarie;
	}

	// TODO Les clés étrangères
	private Long idQualification;
	private Long idService;
	private Long idSite;
	private Long idBanque = 1L;
	private Long idAgence;
	private Long idGroupe;
	
	// TODO Les objets
	private Salaries salaries = new Salaries();
	private AdressesPro adressePro = new AdressesPro();
	private AdressesPrivee adressePrivee = new AdressesPrivee();
	private Avances avance = new Avances();
	private Salaires salaire = new Salaires();
	private Contrats contrat = new Contrats();
//	private CDD cdd = new CDD();
//	private CDI cdi = new CDI();
//	private ANAPEC anapec = new ANAPEC();
//	private Occasionnel occasionnel =new Occasionnel();
	private Conges conge = new Conges();
	private Banques banque = new Banques();
	private Qualifications qualification = new Qualifications();
	private Services service = new Services();
	private Agences agence = new Agences();
	private PrimesAvantages primeAvantage = new PrimesAvantages();
	private F_Initiale f_initiale = new F_Initiale();
	private F_Professionnelles f_professionnelle = new F_Professionnelles();
	//Les prets :
	private Prets pret = new Prets();
	private String dateDebutPret;
	private String dateFinPret;
	
	//imageeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
//	private Part image;
//	
//	public Part getImage() {
//		return image;
//	}
//	public void setImage(Part image) {
//		this.image = image;
//	}
	
	
	//imageeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
	
	public F_Initiale getF_initiale() {
		return f_initiale;
	}
	public Long getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}
	public void setF_initiale(F_Initiale f_initiale) {
		this.f_initiale = f_initiale;
	}
	public F_Professionnelles getF_professionnelle() {
		return f_professionnelle;
	}
	public void setF_professionnelle(F_Professionnelles f_professionnelle) {
		this.f_professionnelle = f_professionnelle;
	}
	public PrimesAvantages getPrimeAvantage() {
		return primeAvantage;
	}
	public void setPrimeAvantage(PrimesAvantages primeAvantage) {
		this.primeAvantage = primeAvantage;
	}
	public Qualifications getQualification() {
		return qualification;
	}
	public void setQualification(Qualifications qualification) {
		this.qualification = qualification;
	}
	public Services getService() {
		return service;
	}
	public void setService(Services service) {
		this.service = service;
	}
	public Agences getAgence() {
		return agence;
	}
	public void setAgence(Agences agence) {
		this.agence = agence;
	}
	public Banques getBanque() {
		return banque;
	}
	public void setBanque(Banques banque) {
		this.banque = banque;
	}
	public String getDateDebutPret() {
		return dateDebutPret;
	}
	public void setDateDebutPret(String dateDebutPret) {
		this.dateDebutPret = dateDebutPret;
	}
	public String getDateFinPret() {
		return dateFinPret;
	}
	public void setDateFinPret(String dateFinPret) {
		this.dateFinPret = dateFinPret;
	}
	public Prets getPret() {
		return pret;
	}
	public void setPret(Prets pret) {
		this.pret = pret;
	}
	public Salaries getSalaries() {
		return salaries;
	}
	
	public int getModificationConge() {
		return modificationConge;
	}
	public void setModificationConge(int modificationConge) {
		this.modificationConge = modificationConge;
	}
	public void setSalaries(Salaries salaries) {
		this.salaries = salaries;
	}
	
	public Avances getAvance() {
		return avance;
	}
	public void setAvance(Avances avance) {
		this.avance = avance;
	}
	public Salaires getSalaire() {
		return salaire;
	}
	public void setSalaire(Salaires salaire) {
		this.salaire = salaire;
	}
	public Contrats getContrat() {
		return contrat;
	}
	public void setContrat(Contrats contrat) {
		this.contrat = contrat;
	}
	
	public AdressesPro getAdressePro() {
		return adressePro;
	}
	public void setAdressePro(AdressesPro adressePro) {
		this.adressePro = adressePro;
	}
	public AdressesPrivee getAdressePrivee() {
		return adressePrivee;
	}
	public void setAdressePrivee(AdressesPrivee adressePrivee) {
		this.adressePrivee = adressePrivee;
	}
	public Long getIdAgence() {
		return idAgence;
	}
	public void setIdAgence(Long idAgence) {
		this.idAgence = idAgence;
	}
	public Long getModePaiementSalaireBase() {
		return modePaiementSalaireBase;
	}
	public void setModePaiementSalaireBase(Long modePaiementSalaireBase) {
		this.modePaiementSalaireBase = modePaiementSalaireBase;
	}
	public Long getModePaiementAvantages() {
		return modePaiementAvantages;
	}
	public void setModePaiementAvantages(Long modePaiementAvantages) {
		this.modePaiementAvantages = modePaiementAvantages;
	}
	public List<Contrats> getListContrats() {
		return listContrats;
	}
	public void setListContrats(List<Contrats> listContrats) {
		this.listContrats = listContrats;
	}
	public List<Conges> getListConges() {
		return listConges;
	}
	
	
	
	public double getNbrJoursCongeRestant() {
		return nbrJoursCongeRestant;
	}
	public void setNbrJoursCongeRestant(double nbrJoursCongeRestant) {
		this.nbrJoursCongeRestant = nbrJoursCongeRestant;
	}
	public void setListConges(List<Conges> listConges) {
		this.listConges = listConges;
	}
	public ISalarieMetier getSalarieMetier() {
		return salarieMetier;
	}
	public void setSalarieMetier(ISalarieMetier salarieMetier) {
		this.salarieMetier = salarieMetier;
	}
	
	public Long getIdQualification() {
		return idQualification;
	}
	public void setIdQualification(Long idQualification) {
		this.idQualification = idQualification;
	}
	
	public Conges getConge() {
		return conge;
	}
	public void setConge(Conges conge) {
		this.conge = conge;
	}
	public Long getIdService() {
		return idService;
	}
	public void setIdService(Long idService) {
		this.idService = idService;
	}
	
	public Long getIdBanque() {
		return idBanque;
	}
	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}
	
	public Long getIdSite() {
		return idSite;
	}
	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}
	

	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getDateValiditePassport() {
		return dateValiditePassport;
	}
	public void setDateValiditePassport(String dateValiditePassport) {
		this.dateValiditePassport = dateValiditePassport;
	}
	public String getDateEmissionPassport() {
		return dateEmissionPassport;
	}
	public void setDateEmissionPassport(String dateEmissionPassport) {
		this.dateEmissionPassport = dateEmissionPassport;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	
	
	public String getDateDebutContrat() {
		return dateDebutContrat;
	}
	public void setDateDebutContrat(String dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}
	public String getDateFinContrat() {
		return dateFinContrat;
	}
	public void setDateFinContrat(String dateFinContrat) {
		this.dateFinContrat = dateFinContrat;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public int getModification() {
		return modification;
	}
	public void setModification(int modification) {
		this.modification = modification;
	}
	public void ajouterSalarie(ActionEvent e) throws IOException{
		// TODO Ajouter Salarié
		System.out.println("ajout salarie");
//		ModePaiements modePaiementSal = new ModePaiements();
//		modePaiementSal = modePaiementMetier.getModePaiementById(this.salaries.getSalaire().getModePaiement().getIdPaiement());
//		this.salaire.setModePaiement(modePaiementSal);
		this.salaire = salaireMetier.ajouterSalaire(this.salaire);
		this.salaries.setSalaire(this.salaire);
		
		if(this.getIdQualification() != null){
			this.salaries.setQualification(qualificationMetier.getQualificationById(this.getIdQualification()));
		}
		if(this.getIdService() != null){
			this.salaries.setService(serviveMetier.getServiceById(this.getIdService()));
		}
//		this.salaries.setBanque(banqueMetier.getBanqueById(idBanque));
		if(this.idAgence != null){
			this.salaries.setAgence(agenceMetier.getAgenceById(idAgence));
		}
		if(this.idGroupe != null){
			this.salaries.setGroupe(groupeMetier.getGroupeById(this.getIdGroupe()));
		}
		Societes societe = new Societes();
		societe.setIdSociete(1L);
		this.salaries.setSociete(societe);
		System.out.println("La société du salarié : " + this.salaries.getSociete().getIdSociete());
		
		//Date saisie du congé
		this.salaries.setDateEntreeConge(new Date());
		
		this.salaries.setImage(this.uploadPhoto());
		
		this.salaries = salarieMetier.ajouterSalarie(this.salaries);
		
		//Creer un compte par defaut
		Utilisateurs utilisateur = new Utilisateurs();
		utilisateur.setLogin(this.salaries.getNom() + this.salaries.getPrenom());
		utilisateur.setPasse(this.getSalaries().getNom() + "123");
		utilisateur.setRole("salarié");
		utilisateur.setSalarie(this.salaries);
		utilisateurMetier.ajouterUtilisateur(utilisateur);
	
		//Partie Avance ou Avantage
//		if(!this.primeAvantage.getValeur().equals("")){
//			this.avance.setDateAvance(new Date());
//			ModePaiements modePaiementAvance = new ModePaiements();
//			modePaiementAvance = modePaiementMetier.getModePaiementById(this.modePaiementAvantages);
//			this.avance.setModePaiement(modePaiementAvance);
//			this.avance.setSalarie(this.salaries);
//			avance = avanceMetier.ajouterAvance(this.avance);
//			this.avance = new Avances();
			this.primeAvantage.setSalarie(this.salaries);
			this.primeAvantageMetier.ajouterPrimesAvantage(this.primeAvantage);
			this.primeAvantage = new PrimesAvantages();
//		}
		
		//Partie adresse professionnelle :
		//if(this.getAdressePro() != null){
//		if(!this.adressePro.getRue().equals("") || 
//		   !this.adressePro.getNumRue().equals("") ||
//		   !this.adressePro.getBatiments().equals("") ||
//		   !this.adressePro.getBat_etage_porte().equals("") ||
//		   !this.adressePro.getCodePostal().equals("") ||
//		   !this.adressePro.getVille().equals("") ||
//		   !this.adressePro.getDistincte().equals("") ||
//		   !this.adressePro.getEtat().equals("") ||
//		   !this.adressePro.getPays().equals("") 
//				){
			adressePro.setSalarie(this.salaries);
			adresseProMetier.ajouterAdressePro(this.adressePro);
			this.adressePro = new AdressesPro();
//		}
		//Partie adresse privée :
//		if(this.getAdressePrivee() != null){
//		if(!this.adressePrivee.getRue().equals("") || 
//		   !this.adressePrivee.getNumRue().equals("") ||
//		   !this.adressePrivee.getBatiments().equals("") ||
//		   !this.adressePrivee.getBat_etage_porte().equals("") ||
//		   !this.adressePrivee.getCodePostal().equals("") ||
//		   !this.adressePrivee.getVille().equals("") ||
//		   !this.adressePrivee.getDistincte().equals("") ||
//		   !this.adressePrivee.getEtat().equals("") ||
//		   !this.adressePrivee.getPays().equals("") 
//				){
			adressePrivee.setSalarie(this.salaries);
			adressePriveeMetier.ajouterAdressePrivee(adressePrivee);
			this.adressePrivee = new AdressesPrivee();
//		}
		
		//debut : Contrat
		System.out.println("date  : " + this.contrat.getDate());
		System.out.println("profil  : " + this.contrat.getProfil());
		System.out.println("date debut  : " + this.contrat.getDateDebutContrat());
		System.out.println("date fin  : " + this.contrat.getDateFinContrat());
		System.out.println("Matricule  : " + this.salaries.getIdSalarie());
		this.contrat.getSalarie().setIdSalarie(this.salaries.getIdSalarie());
		this.contrat = contratMetier.ajouterContrat(this.contrat);
		this.contrat = new Contrats();
		
		//Fin : Contrat		
		this.setDateValiditePassport(null);
		this.setDateEmissionPassport(null);
		this.setDateNaissance(null);
		this.msgSucces = "Ce salarié a été ajouté avec succès !!!";
//				 FacesContext.getCurrentInstance().addMessage(
//		                    null,
//		                    new FacesMessage(FacesMessage.SEVERITY_INFO,
//		                            "Login ou le mot de passe est incorrect",
//		                            "Login ou le mot de passe est incorrect"));

		// upload photo 
		


		
		
				this.salaries = new Salaries();
				this.salaire = new Salaires();
	}
	
	public String editerSalarie(){
		// TODO Editer un salarié
		System.out.println("editerSalarieByID -- Global");
		this.msgSucces = null;
		this.salaries = salarieMetier.getSalarieByMatricule(this.salaries.getIdSalarie());
		
		
		this.setIdQualification(this.salaries.getQualification().getIdQualification());
		this.setIdService(this.salaries.getService().getIdService());
		this.setIdAgence(idAgence);
		this.setIdBanque(banqueMetier.getBanqueByAgence(idAgence).getIdBanque());
		this.setIdAgence(this.salaries.getAgence().getIdAgence());
		//Partie "personnel" :
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		String date = simpleDateFormat.format(this.salaries.getDateNaissance());
		this.setDateNaissance(date);
		date = simpleDateFormat.format(this.salaries.getDateValiditePassport());
		this.setDateValiditePassport(date);
		date = simpleDateFormat.format(this.salaries.getDateEmissionPassport());
		this.setDateEmissionPassport(date);
		//Charger la liste des Congés
//		this.salaries.setConges(congeMetier.getAllCongesBySalarie(this.salaries.getIdSalarie()));
		System.out.println("------------> avant le nombre de jour congé : " + this.getNbrJoursCongeRestant());
		this.setNbrJoursCongeRestant(congeMetier.nbrJoursCongeRestant(this.salaries.getIdSalarie(), 1L));
		System.out.println("------------> avant le nombre de jour congé : " + this.getNbrJoursCongeRestant());
		//Charger l'adresse professionnelle
		if(adresseProMetier.getAdresseProBySalarie(this.salaries.getIdSalarie()) != null){
			this.adressePro = adresseProMetier.getAdresseProBySalarie(this.salaries.getIdSalarie());
		}
		//Charger l'adresse Privée
		if(adressePriveeMetier.getAdressesPriveeBySalarie(this.salaries.getIdSalarie()) != null){
			this.adressePrivee = adressePriveeMetier.getAdressesPriveeBySalarie(this.salaries.getIdSalarie());
		}
		//Partie comptabilité financière : 
		this.salaire.setSalaire_base(this.salaries.getSalaire().getSalaire_base());
		this.salaire.setTypeSalaire(this.salaries.getSalaire().getTypeSalaire());
		this.setModePaiementSalaireBase(modePaiementSalaireBase);
//			this.primeAvantage = (PrimesAvantages) this.salaries.getPrimesAvantages().iterator();
		
		this.primeAvantage.setValeur(this.salaries.getPrimesAvantages().iterator().next().getValeur());
		
		this.setModification(1);
		return "gestionSalaries?faces-redirect=true";
	}
	
	public void modifierSalarie() throws ParseException{
		// TODO ModifierSalarié
		System.out.println("ici 1 ");
		if(this.getIdQualification() != null){
			this.salaries.setQualification(qualificationMetier.getQualificationById(this.getIdQualification()));
		}
		if(this.getIdService() != null){
			this.salaries.setService(serviveMetier.getServiceById(this.getIdService()));
		}
//		this.salaries.setBanque(banqueMetier.getBanqueById(idBanque));
		if(this.idAgence != null){
			this.salaries.setAgence(agenceMetier.getAgenceById(idAgence));
		}
		if(this.idGroupe != null){
			this.salaries.setGroupe(groupeMetier.getGroupeById(this.getIdGroupe()));
		}
		
		System.out.println("ici 2 ");
		
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date date = simpleDateFormat.parse(this.getDateNaissance());
//		this.salaries.setDateNaissance(date);
//		date = simpleDateFormat.parse(this.getDateValiditePassport());
//		this.salaries.setDateValiditePassport(date);
//		date = simpleDateFormat.parse(this.getDateEmissionPassport());
//		this.salaries.setDateEmissionPassport(date);
		
		System.out.println("salaire avant  : " + this.salaries.getSalaire().getSalaire_base());
		this.salaries = this.salarieMetier.modifierSalarie(this.salaries);
		System.out.println("salaire après  : " + this.salaries.getSalaire().getSalaire_base());
		
//		this.salaries.setIdSalarie(this.salaries.getIdSalarie());
//		this.salaireMetier.modifierSalaire(this.salaire);

		//Modifier Salaire : 
		this.salaire = salaireMetier.modifierSalaire(this.salaire);
		//MOdifier avantage
		this.primeAvantage = primeAvantageMetier.modifierPrimesAvantage(this.primeAvantage);
		
		System.out.println("ici 3 ");
		
		if(this.adressePrivee != null){
			this.adressePrivee.setSalarie(this.salaries);
			adressePriveeMetier.modifierAdressePrivee(this.adressePrivee);
		}
		
		System.out.println("ici 4 ");
		
		if(this.adressePro != null){
			this.adressePro.setSalarie(this.salaries);
			adresseProMetier.modifierAdressePro(this.adressePro);
		}
		
		this.setModification(0);
		msgSucces = "Ce salarié a été modifié avec succès !!!";
		this.salaries = new Salaries();
		this.adressePrivee = new AdressesPrivee();
		this.adressePro = new AdressesPro();
		this.setDateValiditePassport(null);
		this.setDateEmissionPassport(null);
		this.setDateNaissance(null);
		System.out.println("ici 5 ");
	}
	
	public String editerSalarieByID(Long idSalarie){
		// TODO Editer un salarié
		System.out.println("editerSalarieByID");
		this.msgSucces = null;
		this.salaries = salarieMetier.getSalarieByMatricule(idSalarie);
		
		if(this.salaries.getQualification() != null){
			this.setIdQualification(this.salaries.getQualification().getIdQualification());
		}
		else{
			this.setIdQualification(0L);
		}
		if(this.salaries.getService() != null){
			this.setIdService(this.salaries.getService().getIdService());
		}
		else{
			this.setIdService(0L);
		}
//		this.setIdBanque(this.salaries.getBanque().getIdBanque());
		if(this.salaries.getAgence() != null){
			this.setIdAgence(this.salaries.getAgence().getIdAgence());
		}
		else{
			this.setIdAgence(0L);
		}
		if(this.salaries.getGroupe() != null){
			this.setIdGroupe(this.salaries.getGroupe().getIdGroupe());
		}
		else{
			this.setIdGroupe(0L);
		}
		//Partie "personnel" :
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
		 String date;
		 System.out.println("10/04/2016 : date de naissance : " + this.salaries.getDateNaissance());
		if(this.salaries.getDateNaissance() != null){
		 date = simpleDateFormat.format(this.salaries.getDateNaissance());
		 this.setDateNaissance(date);
		}
		else{
			this.setDateNaissance("");
		}
		
		if(this.salaries.getDateValiditePassport() != null){
		 date = simpleDateFormat.format(this.salaries.getDateValiditePassport());
		 this.setDateValiditePassport(date);
		}
		else{
			this.setDateValiditePassport("");
		}
		
		if(this.salaries.getDateEmissionPassport() != null){
		 date = simpleDateFormat.format(this.salaries.getDateEmissionPassport());
		 this.setDateEmissionPassport(date);
		}
		else{
			this.setDateEmissionPassport("");
		}
		
		//Charger la liste des Congés
		System.out.println("------------> avant le nombre de jour congé 1: " + this.getNbrJoursCongeRestant());
		this.setNbrJoursCongeRestant(congeMetier.nbrJoursCongeRestant(this.salaries.getIdSalarie(), 1L));
		System.out.println("------------> avant le nombre de jour congé 2: " + this.getNbrJoursCongeRestant());
		//Charger l'adresse professionnelle
		this.adressePro = adresseProMetier.getAdresseProBySalarie(this.salaries.getIdSalarie());
		
		//Charger l'adresse Privée
		this.adressePrivee = adressePriveeMetier.getAdressesPriveeBySalarie(this.salaries.getIdSalarie());
		
		//Partie comptabilité financière : 
//		this.salaire.setSalaire_base(this.salaries.getSalaire().getSalaire_base());
//		this.salaire.setTypeSalaire(this.salaries.getSalaire().getTypeSalaire());
//		this.setModePaiementSalaireBase(modePaiementSalaireBase);
//		this.primeAvantage = this.salaries.getPrimesAvantages().iterator().next();
		this.salaire = salaireMetier.getSalaireByIdSalarie(this.salaries.getIdSalarie());
//		this.primeAvantage.setValeur(this.salaries.getPrimesAvantages().iterator().next().getValeur());
		this.primeAvantage = primeAvantageMetier.getPrimeAvantageByIdSalarie(this.salaries.getIdSalarie());
				
//		while(this.salaries.getPrimesAvantages().iterator().hasNext()){
//			System.out.println("primes : " + this.salaries.getPrimesAvantages().iterator().next());
//		}
//		
//		System.out.println("la valeur du prime avantage : " + this.salaries.getPrimesAvantages().iterator().next().getValeur());
		
		
		this.setModification(1);
		return "gestionSalaries.xhtml?faces-redirect=true";
	}
	
	public void supprimerSalarie(){
		// TODO Supprimer salarié
		System.out.println("Le salarié qui a le matricule : " + this.salaries.getIdSalarie() + " a été supprimé avec succès !!!" );
		salarieMetier.supprimerSalarie(this.salaries.getIdSalarie());
		msgSucces = "Ce salarié a été supprimé avec succès !!!";
		this.salaries = new Salaries();
		this.salaire = new Salaires();
		this.adressePrivee = new AdressesPrivee();
		this.adressePro = new AdressesPro();
		this.setDateNaissance(null);
		this.setDateValiditePassport(null);
		this.setDateEmissionPassport(null);
		this.setModification(0);
	}
	
	public String supprimerSalarieByID(Long idSalarie){
		// TODO Supprimer salarié
		salarieMetier.supprimerSalarie(idSalarie);
		msgSucces = "Ce salarié a été supprimé avec succès !!!";
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msgSucces, null);
		msgSucces = null;
		this.salaries = new Salaries();
		this.salaire = new Salaires();
		this.adressePrivee = new AdressesPrivee();
		this.adressePro = new AdressesPro();
		this.setDateNaissance(null);
		this.setDateValiditePassport(null);
		this.setDateEmissionPassport(null);
		this.setModification(0);
		System.out.println("supp salarie list");
		return "gestionSalariesList?faces-redirect=true";
	}
	
	
	//Récuperer la liste de congés
	public List<Conges> getAllCongesBySalarie(){
		// TODO getAllCongéBySalarie
		System.out.println("congés");
		return congeMetier.getAllCongesBySalarie(this.salaries.getIdSalarie());
	}
	
	public String ajouterContratSalarie(ActionEvent e) throws ParseException{
		// TODO ajouterContratSalarie
		
		this.contrat.setSalarie(this.salaries);
		contratMetier.ajouterContrat(this.contrat);
		this.contrat = new Contrats();
		this.msgSuccesContrat = "Ce contrat a été ajouté avec succès !!!";
		return "gestionContrats?faces-redirect=true";
	}
	

	public String editerContrat(Contrats c){
		this.msgSuccesContrat = null;
		this.setModificationContrat(1);
		this.contrat = c;
		return "gestionContrats.xhtml?faces-redirect=true";
	}
	
	public String modifierContrat() throws ParseException{
		contratMetier.modifierContrat(this.contrat);
		this.setModificationContrat(0);
		this.contrat = new Contrats();
		return "gestionContrats";
	}
	
	public String supprimerContrat(Long idContrat){
		this.msgSuccesContrat = "Ce contrat a été supprimé avec succès !!!";
		contratMetier.supprimerContrat(idContrat);
		this.salaries.getContrats().remove(contratMetier.getContratById(idContrat));
		return "gestionContrats?faces-redirect=true";
	}
	
	
	public List<Contrats> getAllContratBySalarie(){
		List<Contrats> listContrat = contratMetier.getContratByIdSalarie(this.salaries.getIdSalarie());
		System.out.println("Le nombre de contrats du salarié : " +this.salaries.getNom() +" est : " +listContrat.size());
		return listContrat; 
	}
	public void supprimerSalarie(Long idSalarie){
		this.msgSucces = null;
		salarieMetier.supprimerSalarie(idSalarie);
		this.msgSucces = "Ce salarié a été supprimé avec succès !!!";
	}
	
	
	public List<Banques> getAllBanques(){
		return banqueMetier.getAllBanques();
	}
	public List<Agences> tousAgencesByBanque(Long idBanque){
		if(idBanque == null){
			return null;
		}
		System.out.println("tousAgencesByBanque : " + this.idBanque);
		List<Agences> listAgence = agenceMetier.getAllAgencesByBanque(this.idBanque);
		System.out.println("Nombre d'agence : " + listAgence.size());
		return listAgence;
	}
	
	public Prets ajouterPretForSalarie(ActionEvent e) throws ParseException{
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		Date DDP = formatter.parse(this.dateDebutPret);
//		this.pret.setDateDebutPret(DDP);
//		Date DFP = formatter.parse(this.dateFinPret);
//		this.pret.setDateFinPret(DFP);
		this.pret.setSalarie(this.salaries);
		this.setMsgSuccesPret("Ce prêt a été ajouté avec succès !!!");
		Prets p = new Prets();
		p = pretMetier.ajouterPret(this.pret);
		this.pret = new Prets();
		return p;
	}
	
	public List<Prets> getAllPretsSalarie(){
		// TODO getAllPretsSalarie
		System.out.println("getAllPretsSalarie");
		return pretMetier.getAllPretsBySalarie(this.salaries.getIdSalarie());
	}
	
	public String editerPretSalarie(Prets p){
		this.setMsgSuccesPret(null);
		this.setModificationPret(1);
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		String date = simpleDateFormat.format(p.getDateDebutPret());
//		this.dateDebutPret = date;
//		date = simpleDateFormat.format(p.getDateFinPret());
//		this.dateFinPret = date;
 		this.pret = p;
		return "gestionPrets?faces-redirect=true";
	}
	
	public String modifierPret() throws ParseException{
		// TODO Modifier pret
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		Date DDP = formatter.parse(this.dateDebutPret);
//		this.pret.setDateDebutPret(DDP);
//		DDP = formatter.parse(this.dateFinPret);
//		this.pret.setDateFinPret(DDP);
		pretMetier.modifierPrets(this.pret);
		this.pret = new Prets();
		this.setMsgSuccesPret("Ce prêt a été modifié avec succès !!!");
		this.setModificationPret(0);
		return "gestionPrets?faces-redirect=true";
	}
	
	public String supprimerPret(Long idPret){
		// TODO supprimerPret
		this.setModificationPret(0);
		pretMetier.supprimerPret(idPret);
		this.setMsgSuccesPret("Ce prêt a été supprimé avec succès !!!");
		return "gestionPrets?faces-redirect=true";
	}
	
	public Conges ajouterCongeBySalarie(ActionEvent e) throws ParseException {
		// TODO Ajouter un congé
		
		double nbrJourCongeRestant = congeMetier.nbrJoursCongeRestant(this.salaries.getIdSalarie(), 1L);
		Date dateDebut;
		Date dateFin;
		double gap = 0;
			dateDebut = this.conge.getDateDebutC();
			dateFin = this.conge.getDateFinC();
			System.out.println("date debut : " + dateDebut);
			System.out.println("date fin : " + dateFin);

			GregorianCalendar gc1 = new GregorianCalendar();
			 gc1.setTime(dateDebut);
			 GregorianCalendar gc2 = new GregorianCalendar();
			 gc2.setTime(dateFin);
			 
		        gc1.add(GregorianCalendar.DAY_OF_WEEK, 1);
		        while(gc1.compareTo(gc2)<=0) {
		            gap++;
		            gc1.add(GregorianCalendar.DAY_OF_WEEK, 1);
		        }
		gap = gap +1;
		
		if(this.conge.getNature().equals("normal")){
			if(gap>nbrJourCongeRestant){
				this.msgSuccesConge = "Vous avez dépassé le nombre de jours disponibles !!!";
				return null;
			}
		}
		
		
		this.msgSucces = "";
		this.conge.setSalarie(this.salaries);
		this.conge.setValide("pas encore");
		congeMetier.ajouterConge(this.conge);

		//Charger la liste des Congés
		this.salaries.setConges(congeMetier.getAllCongesBySalarie(this.salaries.getIdSalarie()));
		this.setNbrJoursCongeRestant(congeMetier.nbrJoursCongeRestant(this.salaries.getIdSalarie(), 1L));
		this.conge = new Conges();
		this.msgSucces = "Ce congé a été ajouté avec succès !!!";
		return this.conge;
	}
	
	public List<Conges> allCongeBySalarie(){
		//TODO allCongeBySalarie
		System.out.println("allCongeBySalarie : id salarie = " + this.salaries.getIdSalarie());
		return congeMetier.getAllCongesBySalarie(this.salaries.getIdSalarie());
	}
	
	public String editerCongeBySalarie(Conges c){
		this.msgSucces = null;
		System.out.println("editer congé : " + this.salaries.getConges().size());
		this.conge = congeMetier.getCongeById(c.getIdConge());
		this.setModificationConge(1);
		return "gestionConges.xhtml?faces-redirect=true";
	}
	
	public String modifierCongeBySalarie(){
		this.msgSucces = "Ce congé a été modifié avec succès !!!";
		this.congeMetier.modifierConge(this.conge);
		this.setModificationConge(0);
		this.conge = new Conges();
		return "gestionConges.xhtml?faces-redirect=true";
	}
	
	public String supprimerCongeBySalarie(){
		this.msgSucces = "Ce congé a été supprimé avec succès !!!";
		congeMetier.supprimerConge(this.conge.getIdConge());
		System.out.println("suppression avec succès du congé !!!" + this.conge.getIdConge());
		return "gestionConges.xhtml?faces-redirect=true";
	}
	
	public String accepterConge(Conges c){
		System.out.println("accepter congé");
		congeMetier.accepterConge(c);
		return "gestionConges.xhtml?faces-redirect=true";
	}
	
	public String refuserConge(Conges c){
		System.out.println("refuser congé");
		congeMetier.refuserConge(c);
		return "gestionConges.xhtml?faces-redirect=true";
	}
	
	public List<Salaries> getAllsalaries(){
		return salarieMetier.getAllSalaries();
	}
	
	//Gestion des avances
	public void ajouterAvance(ActionEvent e){
		this.avance.setDateAvance(new Date());
//		ModePaiements modePaiementAvance = new ModePaiements();
//		modePaiementAvance = modePaiementMetier.getModePaiementById(this.modePaiementAvantages);
//		this.avance.setModePaiement(modePaiementAvance);
		this.avance.setSalarie(this.salaries);
		avance = avanceMetier.ajouterAvance(this.avance);
		this.avance = new Avances();
		this.setMsgSuccesAvance("Cette avance a été ajouté avec succès !!!");
	}
	
	public List<Avances> getAllAvanceBySalarie(){
		List<Avances> list = avanceMetier.getAllAvanceBySalarie(this.salaries.getIdSalarie());
		for (Avances avances : list) {
			System.out.println("mode paiement avance : " + avances.getModePaiement().getLibellePaiement());
		}
		return list;
	}
	
	public String editerAvanceBySalarie(Avances avance){
		this.setMsgSucces(null);
		this.setModificationAvance(1);
		this.avance = avance;
		return "gestionAvances.xhtml?faces-redirect=true";
	}
	
	public String modifierAvanceBySalarie(){
		avanceMetier.modifierAvance(this.avance);
		this.setMsgSuccesAvance("Cette avance a été modifié avec succès !!!");
		this.setModificationAvance(0);
		this.avance = new Avances();
		return "gestionAvances.xhtml?faces-redirect=true";
	}
	
	public String supprimerAvanceBySalarie(Long idAvance){
		avanceMetier.supprimerAvance(idAvance);
		this.setMsgSuccesAvance("Cette avance a été supprimé avec succès !!!");
		this.setModificationAvance(0);
		return "gestionAvances.xhtml?faces-redirect=true";
	}
	
	//Gestion des formations initiale : 
	public List<F_Initiale> getAllFormationInitialeBySalarie(){
		return f_initialeMetier.getF_InitialeByIdSalarie(this.salaries.getIdSalarie());
	}
	
	public F_Initiale ajouterF_InitialeForSalarie(ActionEvent e){
		this.f_initiale.setSalarie(this.salaries);
		this.setMsgSuccesFInitiales("Cette formation a été ajouté avec succès !!!");
		F_Initiale f_I = f_initialeMetier.ajouterF_Initiale(this.f_initiale);
		this.f_initiale = new F_Initiale();
		return f_I;
	}
	
	public String editerFInitialeSalarie(F_Initiale f){
		this.setMsgSuccesFInitiales(null);
		this.setModificationF_Initiale(1);
		this.f_initiale = f;
		return "GestionFInitiales?faces-redirect=true";
	}

	public String modifierFInitiale(){
		f_initialeMetier.modifierF_Initiale(this.f_initiale);
		this.setModificationF_Initiale(0);
		this.setMsgSuccesFInitiales("Cette formation a été modifié avec succès !!!");
		this.f_initiale = new F_Initiale();
		return "GestionFInitiales?faces-redirect=true";
	}
	
	public String supprimerFInitiale(Long idFInitiale){
		this.setModificationF_Initiale(0);
		f_initialeMetier.supprimerF_Initiale(idFInitiale);
		this.setMsgSuccesFInitiales("Cette formation a été supprimé avec succès !!!");
		return "GestionFInitiales?faces-redirect=true";
	}
	
	//Gestion des formations professionnelles : 
	public List<F_Professionnelles> getAllF_ProfessionnelleSalarie(){
		return f_professionnelleMetier.getF_ProfessionnellesByIdSalarie(this.salaries.getIdSalarie());
	}
	
	public F_Professionnelles ajouterF_ProfessionneleForSalarie(ActionEvent e){
		this.f_professionnelle.setSalarie(this.salaries);
		this.setMsgSuccesPret("Cette formation a été ajouté avec succès !!!");
		F_Professionnelles f_P = f_professionnelleMetier.ajouterF_Pro(this.f_professionnelle);
		this.f_professionnelle = new F_Professionnelles();
		return f_P;
	}
	
	public String editerFProfessionnelleSalarie(F_Professionnelles f){
		this.setMsgSuccesFPro(null);
		this.setModificationF_Pro(1);
		this.f_professionnelle = f;
		return "GestionFProfessionnelle?faces-redirect=true";
	}
	
	public String modifierFProfessionnelle(){
		f_professionnelleMetier.modifierF_Professionnelles(this.f_professionnelle);
		this.setModificationF_Pro(0);
		this.setMsgSuccesFPro("Cette formation a été modifié avec succès !!!");
		this.f_professionnelle = new F_Professionnelles();
		return "GestionFProfessionnelle?faces-redirect=true";
	}
	
	public String supprimerFProfessionnelle(Long idF_Professionnelles){
		this.setModificationF_Initiale(0);
		this.f_professionnelleMetier.supprimerF_Professionnelles(idF_Professionnelles);
		this.setMsgSuccesFInitiales("Cette formation a été supprimé avec succès !!!");
		return "GestionFProfessionnelle?faces-redirect=true";
	}
	
	
	public String uploadPhoto() throws IOException{
		 
		System.out.println("je suis la ***************************************");
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
		String filePath="D:/ahmed/AHMED projet PFE/eclipseMars/mesProjets/Gestion_RH/src/main/webapp/fichierProjetPfeGrh/photoDesSalaries/";
      
        byte[] bytes=null;
        String chemin="";
            if (null!=this.photoSalarie) 
            {
            	
            	
                bytes = this.photoSalarie.getContents();
                String filename = FilenameUtils.getName(this.photoSalarie.getFileName());
                String extension = filename.substring(filename.lastIndexOf('.'), filename.length());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+formatter.format(new Date())+extension)));
                chemin = filePath+formatter.format(new Date())+extension;
                stream.write(bytes);
                stream.close();
            }
            
            return chemin;
 
//        FacesContext.getCurrentInstance().addMessage("messages",new FacesMessage(FacesMessage.SEVERITY_INFO,"Your Photo (File Name "+ this.photoSalarie.getFileName()+ " with size "+ this.photoSalarie.getSize()+ ")  Uploaded Successfully", ""));
    }
	
	
	
}