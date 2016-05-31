package ma.bps.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.SelectEvent;

import ma.bps.entities.PlanTravail;
import ma.bps.entities.TranchePlanTravail;
import ma.bps.metier.GroupeMetierImpl;
import ma.bps.metier.IGroupeMetier;
import ma.bps.metier.IPlanTravailMetier;
import ma.bps.metier.ITranchePlanTravailMetier;
import ma.bps.metier.PlanTravailMetierImpl;
import ma.bps.metier.TranchePlanTravailMetierImpl;

@ManagedBean
@SessionScoped
public class BeanPlanTravail {
	
	
	private IPlanTravailMetier metierPlan = new PlanTravailMetierImpl();
	private ITranchePlanTravailMetier metierTranche = new TranchePlanTravailMetierImpl();
	private IGroupeMetier metierGroupe = new GroupeMetierImpl();
	private PlanTravail planTravailAajouter = new PlanTravail();
	private PlanTravail planTravailAplanifier = new PlanTravail();
	private PlanTravail planTravailAmodifier = new PlanTravail();
	private TranchePlanTravail trancheAajouterLundi = new TranchePlanTravail();
	private TranchePlanTravail trancheAajouterMardi = new TranchePlanTravail();
	private TranchePlanTravail trancheAajouterMercredi = new TranchePlanTravail();
	private TranchePlanTravail trancheAajouterVendredi = new TranchePlanTravail();
	private TranchePlanTravail trancheAajouterSamedi = new TranchePlanTravail();
	private TranchePlanTravail trancheAajouterDimanche = new TranchePlanTravail();
	private TranchePlanTravail trancheAajouterJeudi = new TranchePlanTravail();

	
	private int planificationPlan=0; // varriable utiliser pour savoir si l'utilisateur a cliquer sur un pla pour le planifier
	private int modificationPlan=0;  // varriable utiliser pour savoir si l'utilisateur a cliquer sur un pla pour le modifier
	
	
//	private List<TranchePlanTravail>  listeDesTrancheAimporter = metierTranche.getDistinctTranchePlanTravail();

	
//	private String[] listeDesTrancheAimporter;
	
	
	
	

	// Getters & Setters
	

	
	


	public IPlanTravailMetier getMetierPlan() {
		return metierPlan;
	}

	public int getModificationPlan() {
		return modificationPlan;
	}


	public void setModificationPlan(int modificationPlan) {
		this.modificationPlan = modificationPlan;
	}


	public IGroupeMetier getMetierGroupe() {
		return metierGroupe;
	}


	public void setMetierGroupe(IGroupeMetier metierGroupe) {
		this.metierGroupe = metierGroupe;
	}


	public PlanTravail getPlanTravailAmodifier() {
		return planTravailAmodifier;
	}


	public void setPlanTravailAmodifier(PlanTravail plantTravailAmodifier) {
		this.planTravailAmodifier = plantTravailAmodifier;
	}


	public void setMetierPlan(IPlanTravailMetier metierPlan) {
		this.metierPlan = metierPlan;
	}
	
	public PlanTravail getPlanTravailAajouter() {
		return planTravailAajouter;
	}

	public void setPlanTravailAajouter(PlanTravail planTravailAajouter) {
		this.planTravailAajouter = planTravailAajouter;
	}
	
	public ITranchePlanTravailMetier getMetierTranche() {
		return metierTranche;
	}

	public void setMetierTranche(ITranchePlanTravailMetier metierTranche) {
		this.metierTranche = metierTranche;
	}

	public TranchePlanTravail getTrancheAajouterLundi() {
		return trancheAajouterLundi;
	}

	public void setTrancheAajouterLundi(TranchePlanTravail trancheAajouterLundi) {
		this.trancheAajouterLundi = trancheAajouterLundi;
	}

	public TranchePlanTravail getTrancheAajouterMardi() {
		return trancheAajouterMardi;
	}

	public void setTrancheAajouterMardi(TranchePlanTravail trancheAajouterMardi) {
		this.trancheAajouterMardi = trancheAajouterMardi;
	}

	public TranchePlanTravail getTrancheAajouterMercredi() {
		return trancheAajouterMercredi;
	}

	public void setTrancheAajouterMercredi(TranchePlanTravail trancheAajouterMercredi) {
		this.trancheAajouterMercredi = trancheAajouterMercredi;
	}

	public TranchePlanTravail getTrancheAajouterVendredi() {
		return trancheAajouterVendredi;
	}

	public void setTrancheAajouterVendredi(TranchePlanTravail trancheAajouterVendredi) {
		this.trancheAajouterVendredi = trancheAajouterVendredi;
	}

	public TranchePlanTravail getTrancheAajouterSamedi() {
		return trancheAajouterSamedi;
	}

	public void setTrancheAajouterSamedi(TranchePlanTravail trancheAajouterSamedi) {
		this.trancheAajouterSamedi = trancheAajouterSamedi;
	}

	public TranchePlanTravail getTrancheAajouterDimanche() {
		return trancheAajouterDimanche;
	}

	public void setTrancheAajouterDimanche(TranchePlanTravail trancheAajouterDimanche) {
		this.trancheAajouterDimanche = trancheAajouterDimanche;
	}

	public TranchePlanTravail getTrancheAajouterJeudi() {
		return trancheAajouterJeudi;
	}

	public void setTrancheAajouterJeudi(TranchePlanTravail trancheAajouterJeudi) {
		this.trancheAajouterJeudi = trancheAajouterJeudi;
	}

	public int getPlanificationPlan() {
		return planificationPlan;
	}

	public void setPlanificationPlan(int planificationPlan) {
		this.planificationPlan = planificationPlan;
	}

	public PlanTravail getPlanTravailAplanifier() {
		return planTravailAplanifier;
	}

	public void setPlanTravailAplanifier(PlanTravail planTravailAplanifier) {
		this.planTravailAplanifier = planTravailAplanifier;
	}
	
	
	
	
	
	
	

	
	
	// Les Methodes
	
	
	
	// ajouter un plan travail
	public void ajouterPlanTravail(ActionEvent e) throws ParseException{
		
		metierPlan.ajouterPlanTravail(this.planTravailAajouter);
		System.out.println(this.planTravailAajouter.getDateDebut());
		planTravailAajouter = new PlanTravail();
		this.annulerplanificationPlanTravail();
		// just pour afficher le message que le plan est bien ajouter
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout Plan Travail", "plan de travail bien enregistré"));
		
		
	}
	
	// La liste de tout les plan
	public List<PlanTravail> getAllPlanTravail(){
		return metierPlan.getAllPlanTravail();
	}
	

	
	public void supprimerPlanTravail(Long idPlan){
		
		metierGroupe.annulerPlanGroupe(idPlan);
		metierPlan.supprimerPlanTravail(idPlan);
		
	}
	
	public void modifierPlanTravail(){
		
		metierPlan.modifierPlanTravail(this.planTravailAmodifier);
		this.planTravailAmodifier = new PlanTravail();
		modificationPlan = 0;
		// just pour afficher le message que le plan est bien ajouter
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modification Plan Travail", "plan de travail bien modifié"));
		
	}
	
	public void planifierPlanTravail(PlanTravail plan){
		
		this.planificationPlan=1;
		this.planTravailAplanifier = plan;
		
	}
	
	public void annulerplanificationPlanTravail(){
		
		this.planificationPlan=0;
		this.planTravailAplanifier = new PlanTravail();
		
	}
	
	
	public void preparationPlanTravailAmodifier(PlanTravail plan){
		
		this.modificationPlan=1;
		this.planTravailAmodifier = plan;
		
	}
	
	public void annulerModificationPlanTravail(){
		
		this.modificationPlan=0;
		this.planTravailAmodifier = new PlanTravail();
		
	}
	
	
	
	
	// Les Methodes des Tranche Annuel
	
	public void ajouterTranchePlanTravail(ActionEvent e, String jour){
		System.out.println("Ajout Tranche jours Annuelllllllllllllllllllllllllllllllll");
		if (jour.equals("lundi")) 
		{
			this.trancheAajouterLundi.setJour(jour);
			this.trancheAajouterLundi.setPlanTravail(this.planTravailAplanifier);
			metierTranche.ajouterTranchePlanTravail(this.trancheAajouterLundi);
			this.trancheAajouterLundi = new TranchePlanTravail();
		}
		
		if (jour.equals("mardi")) 
		{
			this.trancheAajouterMardi.setJour(jour);
			this.trancheAajouterMardi.setPlanTravail(this.planTravailAplanifier);
			metierTranche.ajouterTranchePlanTravail(this.trancheAajouterMardi);
			this.trancheAajouterMardi = new TranchePlanTravail();
		}
		
		if (jour.equals("mercredi")) 
		{
			this.trancheAajouterMercredi.setJour(jour);
			this.trancheAajouterMercredi.setPlanTravail(this.planTravailAplanifier);
			metierTranche.ajouterTranchePlanTravail(this.trancheAajouterMercredi);
			this.trancheAajouterMercredi = new TranchePlanTravail();
		}
		
		if (jour.equals("jeudi")) 
		{
			this.trancheAajouterJeudi.setJour(jour);
			this.trancheAajouterJeudi.setPlanTravail(this.planTravailAplanifier);
			metierTranche.ajouterTranchePlanTravail(this.trancheAajouterJeudi);
			this.trancheAajouterJeudi = new TranchePlanTravail();
		}
		
		if (jour.equals("vendredi")) 
		{
			this.trancheAajouterVendredi.setJour(jour);
			this.trancheAajouterVendredi.setPlanTravail(this.planTravailAplanifier);
			metierTranche.ajouterTranchePlanTravail(this.trancheAajouterVendredi);
			this.trancheAajouterVendredi = new TranchePlanTravail();
		}
		
		if (jour.equals("samedi")) 
		{
			this.trancheAajouterSamedi.setJour(jour);
			this.trancheAajouterSamedi.setPlanTravail(this.planTravailAplanifier);
			metierTranche.ajouterTranchePlanTravail(this.trancheAajouterSamedi);
			this.trancheAajouterSamedi = new TranchePlanTravail();
		}
		
		if (jour.equals("dimanche")) 
		{
			this.trancheAajouterDimanche.setJour(jour);
			this.trancheAajouterDimanche.setPlanTravail(this.planTravailAplanifier);
			metierTranche.ajouterTranchePlanTravail(this.trancheAajouterDimanche);
			this.trancheAajouterDimanche = new TranchePlanTravail();
		}
		
		
		
	}
	
	
	// methode qui charger les tranche pour les importer
	public List<TranchePlanTravail> chargerLesTranchePourLesImporter(){
		return metierTranche.getDistinctTranchePlanTravail();
	}
	
	// methode importer la tranche
	public void importerUneTranche(TranchePlanTravail tranche, String jour){
		TranchePlanTravail t = new TranchePlanTravail();
		t.setHeureDebut(tranche.getHeureDebut());
		t.setHeureFin(tranche.getHeureFin());
		t.setCode(tranche.getCode());
		t.setTaux(tranche.getTaux());
		t.setDeuxJour(tranche.isDeuxJour());
		t.setJour(jour);
		t.setPlanTravail(this.planTravailAplanifier);
		metierTranche.ajouterTranchePlanTravail(t);
		
	}
	
	
	
//	// teste plusieur case a cocher
//	public void testCheckBox(){
//		
//		for (int i = 0; i < this.listeDesTrancheAimporter.length; i++) {
//			System.out.println(listeDesTrancheAimporter[i]);
//		}
//		
//	}
	
	
	
	
	public List<TranchePlanTravail> getAllTranchePlanTravail(){
		return metierTranche.getAllTranchePlanTravail();
	}
	
	public List<TranchePlanTravail> getAllTranchePlanTravailByJour(String jour){
		return metierTranche.getTranchePlanTravailByJour(jour,this.planTravailAplanifier.getIdPlan());
	}
	
	public void supprimerTranchePlanTravail(Long idTranche){
		System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
		metierTranche.supprimerTranchePlanTravail(idTranche);
		
	}
	
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Sélectionnée", format.format(event.getObject())));
    }
	
	
	
	
	
	
	
	
	
	
	/*
	public List<PlanTravail> getAllPlanTravail(){
		return metier.getAllPlanTravail();
	}
	
	// editer plan preparrer le plan a modifier
	public String editerPlanTravail(PlanTravail p){
		this.modification=1;
		this.plan = p;
		return "gestionPlanTravail?faces-redirect=true";
	}
	
	// supprimer PlanTravail
	public String supprimerPlanTravail(Long idPlan){
		metier.supprimerPlanTravail(idPlan);
		return "gestionPlanTravail?faces-redirect=true";
	}
	
	// modifier Plan travail
	public String modifierPlanTravail(){
		metier.modifierPlanTravail(this.plan);
		this.plan= new PlanTravail();
		this.modification=0;
		return "gestionPlanTravail?faces-redirect=true";
	}
	
	// modifier Plan travail
		public String annulerModificationPlanTravail(){
			this.plan= new PlanTravail();
			this.modification=0;
			return "gestionPlanTravail?faces-redirect=true";
		}
		
		*/
	
	
	public void cocher(ValueChangeEvent event){
		
		System.out.println("*****************************************************");
		String [] check = (String[]) event.getNewValue();
		System.out.println("***************************************************** lenght   " + check.length);
		for (int i = 0; i < check.length; i++) {
			//checkPersona.add(Integer.valueOf(check[i]));
			System.out.println(check[i]);
		}
	}
	
	

}
