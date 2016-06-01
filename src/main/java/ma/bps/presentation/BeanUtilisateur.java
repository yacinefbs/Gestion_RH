package ma.bps.presentation;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import ma.bps.entities.A_Justifiee;
import ma.bps.entities.A_Non_Justifiee;
import ma.bps.entities.AutoFormation;
import ma.bps.entities.AutoFormationDocuments;
import ma.bps.entities.AutoFormationTheme;
import ma.bps.entities.Avances;
import ma.bps.entities.Conges;
import ma.bps.entities.DemandeDesCertificatsParSalarie;
import ma.bps.entities.F_Initiale;
import ma.bps.entities.F_Professionnelles;
import ma.bps.entities.HeureSupplementaire;
import ma.bps.entities.PlanTravail;
import ma.bps.entities.Prets;
import ma.bps.entities.PrimesAvantages;
import ma.bps.entities.Retards;
import ma.bps.entities.Salaries;
import ma.bps.entities.Utilisateurs;
import ma.bps.metier.AutoFormationMetierImpl;
import ma.bps.metier.AutoFormationThemeMetierImpl;
import ma.bps.metier.DemandeDesCertificatsParSalarieMetierImpl;
import ma.bps.metier.IAutoFormationMetier;
import ma.bps.metier.IAutoFormationThemeMetier;
import ma.bps.metier.IDemandeDesCertificatsParSalarieMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.IUtilisateurMetier;
import ma.bps.metier.SalarieMetierImpl;
import ma.bps.metier.UtilisateurMetierImpl;

@ManagedBean
@SessionScoped
public class BeanUtilisateur {
	
	IUtilisateurMetier metierUtilisateur = new UtilisateurMetierImpl();
	ISalarieMetier metierSalarie = new SalarieMetierImpl();
	IAutoFormationThemeMetier metierAutoFormationTheme = new AutoFormationThemeMetierImpl();
	IAutoFormationMetier metierAutoFormation = new AutoFormationMetierImpl();
	IDemandeDesCertificatsParSalarieMetier metierDemande = new DemandeDesCertificatsParSalarieMetierImpl();
	
	
	// attributs authentification utilisateur
	private String login;
	private String passe;
	
	// les msg d'authentification erreu ou authentifier
	private String messageAuthentification;
	
	// si un salarie connecter nchargiwh
	public static Salaries salarieConnecte = new Salaries();
	
	// ce varriable bach nchoufo chno nbayno wach absence ola congé ola ....
	public String afficheKoi = "tout";
	
	// ce varriable est utiliser pour voir si on va charcher les auto formation ou afficher tout
	public String rechercheAutoFormation = "non";
	
	// verriable pour stocker le sujet chercher
	public String sujetEnRecherche;
	
	
	// les différente demande
	DemandeDesCertificatsParSalarie attestationTravail = new DemandeDesCertificatsParSalarie();
	DemandeDesCertificatsParSalarie bulletinPaie = new DemandeDesCertificatsParSalarie();
	DemandeDesCertificatsParSalarie attestationSalaire = new DemandeDesCertificatsParSalarie();
	DemandeDesCertificatsParSalarie attestationConge = new DemandeDesCertificatsParSalarie();
	
	
	
	// Getters & setters
	


	public IDemandeDesCertificatsParSalarieMetier getMetierDemande() {
		return metierDemande;
	}

	public void setMetierDemande(IDemandeDesCertificatsParSalarieMetier metierDemande) {
		this.metierDemande = metierDemande;
	}

	public DemandeDesCertificatsParSalarie getAttestationTravail() {
		return attestationTravail;
	}

	public void setAttestationTravail(DemandeDesCertificatsParSalarie attestationTravail) {
		this.attestationTravail = attestationTravail;
	}

	public DemandeDesCertificatsParSalarie getBulletinPaie() {
		return bulletinPaie;
	}

	public void setBulletinPaie(DemandeDesCertificatsParSalarie bulletinPaie) {
		this.bulletinPaie = bulletinPaie;
	}

	public DemandeDesCertificatsParSalarie getAttestationSalaire() {
		return attestationSalaire;
	}

	public void setAttestationSalaire(DemandeDesCertificatsParSalarie attestationSalaire) {
		this.attestationSalaire = attestationSalaire;
	}

	public DemandeDesCertificatsParSalarie getAttestationConge() {
		return attestationConge;
	}

	public void setAttestationConge(DemandeDesCertificatsParSalarie attestationConge) {
		this.attestationConge = attestationConge;
	}

	public String getSujetEnRecherche() {
		return sujetEnRecherche;
	}

	public void setSujetEnRecherche(String sujetEnRecherche) {
		this.sujetEnRecherche = sujetEnRecherche;
	}

	public IAutoFormationThemeMetier getMetierAutoFormationTheme() {
		return metierAutoFormationTheme;
	}

	public void setMetierAutoFormationTheme(IAutoFormationThemeMetier metierAutoFormationTheme) {
		this.metierAutoFormationTheme = metierAutoFormationTheme;
	}

	public IAutoFormationMetier getMetierAutoFormation() {
		return metierAutoFormation;
	}

	public void setMetierAutoFormation(IAutoFormationMetier metierAutoFormation) {
		this.metierAutoFormation = metierAutoFormation;
	}

	public String getRechercheAutoFormation() {
		return rechercheAutoFormation;
	}

	public void setRechercheAutoFormation(String rechercheAutoFormation) {
		this.rechercheAutoFormation = rechercheAutoFormation;
	}

	public String getAfficheKoi() {
		return afficheKoi;
	}

	public void setAfficheKoi(String afficheKoi) {
		this.afficheKoi = afficheKoi;
	}

	public BeanUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IUtilisateurMetier getMetierUtilisateur() {
		return metierUtilisateur;
	}






	public void setMetierUtilisateur(IUtilisateurMetier metierUtilisateur) {
		this.metierUtilisateur = metierUtilisateur;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPasse() {
		return passe;
	}



	public void setPasse(String passe) {
		this.passe = passe;
	}



	public String getMessageAuthentification() {
		return messageAuthentification;
	}



	public void setMessageAuthentification(String messageAuthentification) {
		this.messageAuthentification = messageAuthentification;
	}
	
	
	public Salaries getSalarieConnecte() {
		return salarieConnecte;
	}



	public void setSalarieConnecte(Salaries salarieConnecte) {
		this.salarieConnecte = salarieConnecte;
	}
	
	public ISalarieMetier getMetierSalarie() {
		return metierSalarie;
	}



	public void setMetierSalarie(ISalarieMetier metierSalarie) {
		this.metierSalarie = metierSalarie;
	}




	// methode authentification
	


	public String authentificationUtilisateur(){
		
		List<Utilisateurs> listeUtilisateur = metierUtilisateur.chercherUtilisateurByLoginPasse(login, passe);
		String resultat;
		
		if (listeUtilisateur.size()>0) 
		{
			Utilisateurs u = listeUtilisateur.get(0);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Utilisateur_Connecter", u);
			
			if (u.getRole().equals("admin")) 
			{
				resultat = "AcceuilAdmin?faces-redirect=true";
			} 
			else
			{
				resultat = "AcceuilSalarie?faces-redirect=true";
				salarieConnecte = metierSalarie.getSalarieById(u.getSalarie().getIdSalarie());
			}
			
			return resultat;
		}
		else
		{
			messageAuthentification = "Erreur d'authentification !! veuillez vérifiez votre login et passe.";
			return "Authentification?faces-redirect=true";
		}
		
	}
	
	
	// déconnexion
	
	public String deconnexionUtilisateur(){
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "Authentification?faces-redirect=true";
		
	}
	
	// vérifier si connecter
	public void verifierSiConnecter() throws IOException
	{
		
		
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Utilisateur_Connecter") == null)
		{
			messageAuthentification = "Vous devez d'abord vous connecter ...";
			FacesContext.getCurrentInstance().getExternalContext().redirect("Authentification.xhtml");//add your URL here, instead of list.do
	    
		}
		
		
	}
	
	
	
	
	// charger nombres absence salarie
	public List<Object[]> chargerLeNombreAbsenceSalarie(){
		return metierSalarie.chargerNombreAbsenceSalarie(salarieConnecte.getIdSalarie());
	}

	// charger nombres retard salarie
	public List<Object[]> chargerLeNombreRetardSalarie(){
		return metierSalarie.chargerNombreRetardSalarie(salarieConnecte.getIdSalarie());
	}
	
	// charger nombres Formation salarie
	public List<Object[]> chargerLeNombreFormationSalarie(){
		return metierSalarie.chargerNombreFormationSalarie(salarieConnecte.getIdSalarie());
	}	

	
	// charger nombres avances salarie
	public List<Object[]> chargerLeNombreAvanceSalarie(){
		return metierSalarie.chargerNombreAvanceSalarie(salarieConnecte.getIdSalarie());
	}
	
	// charger la liste des absences non justifier un salarie
	public List<A_Non_Justifiee> chargerAbsenceNonJustifieUnSalarie(){
		return metierSalarie.chargerAbsenceNonJustifieeUnSalarie(salarieConnecte.getIdSalarie());
	}
	
	// charger la liste des absences justifier un salarie
	public List<A_Justifiee> chargerAbsenceJustifieUnSalarie(){
		return metierSalarie.chargerAbsenceJustifieeUnSalarie(salarieConnecte.getIdSalarie());
	}	
	
	// charger la liste des retards un salarie
	public List<Retards> chargerRetardUnSalarie(){
		return metierSalarie.chargerRetardUnSalarie(salarieConnecte.getIdSalarie());
	}
	
	// charger la liste des formation initial un salarie
	public List<F_Initiale> chargerFormationInitialUnSalarie(){
		return metierSalarie.chargerFormationInitialUnSalarie(salarieConnecte.getIdSalarie());
	}
	
	// charger la liste des Formation professionelles un salarie
	public List<F_Professionnelles> chargerformationProfessionnelleUnSalarie(){
		return metierSalarie.chargerFormationProfessionneleUnSalarie(salarieConnecte.getIdSalarie());
	}
	
	// charger la liste des Avances un salarie
	public List<Avances> chargerAvanceUnSalarie(){
		return metierSalarie.chargerAvanceUnSalarie(salarieConnecte.getIdSalarie());
	}
	
	
	public List<Object[]> chargerNombreCongeSalarie() {
		// TODO Auto-generated method stub
		return metierSalarie.chargerNombreCongeSalarie(salarieConnecte.getIdSalarie());
	}

	public List<Object[]> chargerNombrePretSalarie() {
		// TODO Auto-generated method stub
		return metierSalarie.chargerNombrePretSalarie(salarieConnecte.getIdSalarie());
	}

	public List<Object[]> chargerNombreHeureSupplementaireSalarie() {
		// TODO Auto-generated method stub
		return metierSalarie.chargerNombreHeureSupplementaireSalarie(salarieConnecte.getIdSalarie());
	}

	public List<Object[]> chargerNombrePrimeAvantageSalarie() {
		// TODO Auto-generated method stub
		return metierSalarie.chargerNombrePrimeAvantageSalarie(salarieConnecte.getIdSalarie());
	}

	public List<Conges> chargerCongeValideUnSalarie() {
		// TODO Auto-generated method stub
		return metierSalarie.chargerCongeValideUnSalarie(salarieConnecte.getIdSalarie());
	}

	
	public List<Conges> chargerCongeNonValideUnSalarie() {
		// TODO Auto-generated method stub
		return metierSalarie.chargerCongeNonValideUnSalarie(salarieConnecte.getIdSalarie());
	}
	
	
	public List<Prets> chargerPretUnSalarie() {
		// TODO Auto-generated method stub
		return metierSalarie.chargerPretUnSalarie(salarieConnecte.getIdSalarie());
	}

	public List<HeureSupplementaire> chargerHeureSupplementaireUnSalarie() {
		// TODO Auto-generated method stub
		return metierSalarie.chargerHeureSupplementaireUnSalarie(salarieConnecte.getIdSalarie());
	}

	public List<PrimesAvantages> chargerPrimeAvantageUnSalarie() {
		// TODO Auto-generated method stub
		return metierSalarie.chargerPrimeAvantageUnSalarie(salarieConnecte.getIdSalarie());
	}

	public List<PlanTravail> chargerPlanTravailSiExisteUnSalarie() {
		// TODO Auto-generated method stub
		return metierSalarie.chargerPlanTravailSiExisteUnSalarie(salarieConnecte.getIdSalarie());
	}
	
	
	// methode pricise qoui a afficher
	public void koiAfficher(String koi) throws IOException{
		System.out.println("je suis f koi a afficher +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		this.afficheKoi = koi;
        // refraichement de la page
      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
	}
	
	// methode charger les difirente theme d'auto formation enregistrée
	public List<AutoFormationTheme> chargerListeDesThemeAutoFormation(){
		return metierAutoFormationTheme.chargerListeAutoFormationThemeAyantDesAutoFormation();
	}
	
	// charger les formation d'un theme
	public List<AutoFormation> chargerListeDesAutoFormationUnTheme(long idTheme){
		return metierAutoFormation.chargerListeAutoFormationUnTheme(idTheme);
	}
	
	// charger les documents d'une auto formation
	public List<AutoFormationDocuments> chargerListeDocumentUneAutoFormation(long idAutoFormation){
		return metierAutoFormation.chargerLesDocumentUneFormation(idAutoFormation);
	}
	
	// recherche des auto formation par sujet
	public List<AutoFormation> chercherListeAutoFormationParSujet(){
		this.afficheKoi = "autoformation";
		this.rechercheAutoFormation = "oui";		
		return metierAutoFormation.chargerListeAutoFormationRechercheParSujet(this.sujetEnRecherche);
	}
	

	// afficher toutes les auto formation sans recherche
	public void afficherToutesLesAutoFormationSansRecherche(){
		this.afficheKoi = "autoformation";
		this.rechercheAutoFormation = "non";
		this.sujetEnRecherche = "";
	}
	
	
	// demandes des certificats
	
	public void enregistrerDemandeAttestation(String typeCertificat){
		
		
		// attestation de travail
		if (typeCertificat.equals("attestationTravail")) 
		{
			this.attestationTravail.setCertificatDemander("Attestation de travail");
			this.attestationTravail.setDateDemande(new Date());
			this.attestationTravail.setSalarie(this.salarieConnecte);
			
			metierDemande.ajouterDemandeDesCertificatsParSalarie(this.attestationTravail);
			
			this.attestationTravail = new DemandeDesCertificatsParSalarie();
			this.afficheKoi = "administration";
		}
		
		
		// Bulletin de paie
		if (typeCertificat.equals("bulletinPaie")) 
		{
			this.bulletinPaie.setCertificatDemander("Bulletin de paie");
			this.bulletinPaie.setDateDemande(new Date());
			this.bulletinPaie.setSalarie(this.salarieConnecte);
			
			metierDemande.ajouterDemandeDesCertificatsParSalarie(this.bulletinPaie);
			
			this.bulletinPaie = new DemandeDesCertificatsParSalarie();
			this.afficheKoi = "administration";
		}
		
		
		
		// attestation de salaire
		if (typeCertificat.equals("attestationSalaire")) 
		{
			this.attestationSalaire.setCertificatDemander("Bulletin de salaire");
			this.attestationSalaire.setDateDemande(new Date());
			this.attestationSalaire.setSalarie(this.salarieConnecte);
			
			metierDemande.ajouterDemandeDesCertificatsParSalarie(this.attestationSalaire);
			
			this.attestationSalaire = new DemandeDesCertificatsParSalarie();
			this.afficheKoi = "administration";
		}
		

		
		
	}
	
	
	
	// demande attestion de congé hadi dartha bou7adha 7it les arguments dyalha makhtalfin khasha tjib m3aha l id d lcongé li talb lih attestation
	public void enregistrerAttestationDeConge(String typeAttestation, Long idConge)
	{
		if (typeAttestation.equals("attestationConge")) 
		{
			this.attestationConge.setCertificatDemander("Attestation de congé");
			this.attestationConge.setDateDemande(new Date());
			this.attestationConge.setSalarie(this.salarieConnecte);
			this.attestationConge.setIdCongeAdemanderSonAttestation(idConge);
			
			metierDemande.ajouterDemandeDesCertificatsParSalarie(this.attestationConge);
			
			this.attestationConge = new DemandeDesCertificatsParSalarie();
			this.afficheKoi = "administration";
		}
	}
	
	
	
	
	

}
