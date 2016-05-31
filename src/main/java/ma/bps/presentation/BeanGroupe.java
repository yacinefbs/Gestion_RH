package ma.bps.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.Banques;
import ma.bps.entities.Groupes;
import ma.bps.entities.PlanTravail;
import ma.bps.entities.Salaires;
import ma.bps.entities.Salaries;
import ma.bps.metier.GroupeMetierImpl;
import ma.bps.metier.IGroupeMetier;
import ma.bps.metier.IPlanTravailMetier;
import ma.bps.metier.ISalaireMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.PlanTravailMetierImpl;
import ma.bps.metier.SalarieMetierImpl;

@ManagedBean
@SessionScoped
public class BeanGroupe {
	
	IGroupeMetier groupeMetier = new GroupeMetierImpl();
	ISalarieMetier salarieMetier = new SalarieMetierImpl();
	IPlanTravailMetier planTravailMetier = new PlanTravailMetierImpl();
	

	private int modification=0;
	private int afficheEmpGroupe=0; // utiliser pour spécifier ila bghina nchoufo la liste des employes d'un group ou nn
	private Groupes groupeAjouter = new Groupes();
	private Groupes groupeModifier =  new Groupes();
	private Groupes groupeAfficherCesEmp =  new Groupes();
	private Groupes groupeAjouterDesEmp =  new Groupes();
	
	private long inPlanTravailgroupe ;
	
	
	
	
	
	public Groupes getGroupeAjouterDesEmp() {
		return groupeAjouterDesEmp;
	}
	public void setGroupeAjouterDesEmp(Groupes groupeAjouterDesEmp) {
		this.groupeAjouterDesEmp = groupeAjouterDesEmp;
	}
	public ISalarieMetier getSalarieMetier() {
		return salarieMetier;
	}
	public void setSalarieMetier(ISalarieMetier salarieMetier) {
		this.salarieMetier = salarieMetier;
	}
	public IPlanTravailMetier getPlanTravailMetier() {
		return planTravailMetier;
	}
	public void setPlanTravailMetier(IPlanTravailMetier planTravailMetier) {
		this.planTravailMetier = planTravailMetier;
	}
	public long getInPlanTravailgroupe() {
		return inPlanTravailgroupe;
	}
	public void setInPlanTravailgroupe(long inPlanTravailgroupe) {
		this.inPlanTravailgroupe = inPlanTravailgroupe;
	}
	public Groupes getGroupeAfficherCesEmp() {
		return groupeAfficherCesEmp;
	}
	public void setGroupeAfficherCesEmp(Groupes groupeAfficherCesEmp) {
		this.groupeAfficherCesEmp = groupeAfficherCesEmp;
	}
	public int getModification() {
		return modification;
	}
	public void setModification(int modification) {
		this.modification = modification;
	}
	
	public IGroupeMetier getGroupeMetier() {
		return groupeMetier;
	}
	public void setGroupeMetier(IGroupeMetier groupeMetier) {
		this.groupeMetier = groupeMetier;
	}
	public Groupes getGroupeAjouter() {
		return groupeAjouter;
	}
	public void setGroupeAjouter(Groupes groupeAjouter) {
		this.groupeAjouter = groupeAjouter;
	}
	public Groupes getGroupeModifier() {
		return groupeModifier;
	}
	public void setGroupeModifier(Groupes groupeModifier) {
		this.groupeModifier = groupeModifier;
	}
	public int getAfficheEmpGroupe() {
		return afficheEmpGroupe;
	}
	public void setAfficheEmpGroupe(int afficheEmpGroupe) {
		this.afficheEmpGroupe = afficheEmpGroupe;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void ajouterGroupe(ActionEvent e){
		
		this.groupeAjouter.setPlanTravail(planTravailMetier.getPlanTravailById(this.inPlanTravailgroupe));
		groupeMetier.ajouterGrouppe(this.groupeAjouter);
		groupeAjouter = new Groupes();
		
	}
	
	
	public List<Groupes> getAllGroupes(){
		return groupeMetier.getAllGroupes();
	}
	
	
	public String editerGroupe(Groupes g){
		this.setModification(1);
		this.groupeModifier = g;
		if (g.getPlanTravail() != null) 
		{
			this.inPlanTravailgroupe = g.getPlanTravail().getIdPlan();
		}
		else
		{
			this.inPlanTravailgroupe = 0;
		}
		
		return "gestionGroupes?faces-redirect=true";
	}
	
	
	public String modifierGroupe(){
		
		this.setModification(0);
		this.groupeModifier.setPlanTravail(planTravailMetier.getPlanTravailById(this.inPlanTravailgroupe));
		groupeMetier.modifierGroupe(this.groupeModifier);
		this.groupeModifier= new Groupes();
		return "gestionGroupes?faces-redirect=true";
	}
	
	public String AnnulerModificationGroupe(){
		
		this.setModification(0);
		this.groupeModifier= new Groupes();
		return "gestionGroupes?faces-redirect=true";
	}
	
	public void supprimerGroupe(Long idGroupe){
		salarieMetier.annulerGroupeDesSalaries(idGroupe);		
		groupeMetier.supprimerGroupe(idGroupe);
		System.out.println("suppression avec succès!!!");
	}
	

	public void retourListeGroupe(){
		afficheEmpGroupe = 0;
		groupeAfficherCesEmp = new Groupes();
		groupeAjouterDesEmp = new Groupes();
	}
	
	
	// ancien nom de cette methode ajouterEmployeAuGroupe
	public void versListeSalariesUnGroupe(Long idGroup){
		
		afficheEmpGroupe = 1;
		groupeAfficherCesEmp = groupeMetier.getGroupeById(idGroup);
		
		
		
	}
	
	public void versAjoutEmployeAuGroupe(Long idGroup){
		
		afficheEmpGroupe = 2;
		groupeAjouterDesEmp = groupeMetier.getGroupeById(idGroup);
		
		
		
	}
	
	public void supprimerEmployeDuGroupe(Long idEmp){
		
		Salaries s = salarieMetier.getSalarieById(idEmp);
		s.setGroupe(null);
		salarieMetier.modifierSalarie(s);
		
//		Salaries salsupp = new Salaries();
//		for (Iterator iterator = groupeAfficherCesEmp.getSalaries().iterator(); iterator.hasNext();) {
//			Salaries salaries = (Salaries) iterator.next();
//			if(salaries.getIdSalarie()==idEmp){
//				salsupp = salaries;
//			}
//		}
//		
//		groupeAfficherCesEmp.getSalaries().remove(salsupp);
		
	}
	
	public void ajouterEmployeAuGroupe(Long idEmp){
		
		System.out.println("je suis la *********************************************");
		Salaries s = salarieMetier.getSalarieById(idEmp);
		s.setGroupe(this.groupeAjouterDesEmp);
		salarieMetier.modifierSalarie(s);
		
	
		//Collection<Salaries> col = new ArrayList<Salaries>();
//		groupeAjouterDesEmp.getSalaries().add(s);
		//col.add(s);
		
		//groupeAfficherCesEmp.setSalaries(col);

		
	}
	
	// charger la liste des salarie d'un groupe
	public List<Salaries> chargerListeSalarieUnGroupe(){
		
		return groupeMetier.chargerListeSalarieUnGroupe(this.groupeAfficherCesEmp.getIdGroupe());
		
	}
	
	
	public List<PlanTravail> chargerListePlanTravail(){
		return planTravailMetier.getAllPlanTravail();
	}
	
	
	public List<Salaries> chargerListeSalariesNonAffecterAunGroupe(){
		return salarieMetier.chargerListeSalariesNonAffecterAunGroupe();
		
	}
	
	
	
}
