package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.F_Initiale;
import ma.bps.entities.Salaries;
import ma.bps.metier.F_InitialeMetierImpl;
import ma.bps.metier.IF_InitialeMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.SalarieMetierImpl;

@ManagedBean
@SessionScoped
public class BeanFormationInitiale {

	private IF_InitialeMetier formationInitialeMetier = new F_InitialeMetierImpl();
	private ISalarieMetier salarieMetier = new SalarieMetierImpl();
	private F_Initiale f_Initiale = new F_Initiale();
	private String msgSuccesFInitiale = null;
	private int modificationFInitiale = 0;
	public F_Initiale getF_Initiale() {
		return f_Initiale;
	}
	public void setF_Initiale(F_Initiale f_Initiale) {
		this.f_Initiale = f_Initiale;
	}
	
	public String getMsgSuccesFInitiale() {
		return msgSuccesFInitiale;
	}
	public void setMsgSuccesFInitiale(String msgSuccesFInitiale) {
		this.msgSuccesFInitiale = msgSuccesFInitiale;
	}
	public int getModificationFInitiale() {
		return modificationFInitiale;
	}
	public void setModificationFInitiale(int modificationFInitiale) {
		this.modificationFInitiale = modificationFInitiale;
	}
	
	
	public F_Initiale ajouterFormationInitiale(ActionEvent e){
		this.setMsgSuccesFInitiale("Cette formation a été ajouté avec succès !!!");
		F_Initiale FI = new F_Initiale();
		System.out.println("date debut : " + this.f_Initiale.getDateDebut());
		System.out.println("date fin : " + this.f_Initiale.getDateFin());
		System.out.println("categorie formation : " + this.f_Initiale.getCategorieFormation());
		System.out.println("etablissment : " + this.f_Initiale.getEtablissement());
		System.out.println("matiere : " + this.f_Initiale.getMatierePrincipale());
		System.out.println("diplome : " + this.f_Initiale.getDiplome());
		System.out.println("matricule : " + this.f_Initiale.getSalarie().getIdSalarie());
		FI = formationInitialeMetier.ajouterF_Initiale(this.f_Initiale);
		this.f_Initiale = new F_Initiale();
		return FI;
	}
	
	public String editerFormationInitiale(F_Initiale FI){
		this.setMsgSuccesFInitiale(null);
		this.f_Initiale = FI;
		this.setModificationFInitiale(1);
		return "GestionFInitialesGlobals?faces-redirect=true";
	}
	
	public String modifierFormationInitiale(){
		this.setMsgSuccesFInitiale("Cette formation été modifié avec succès !!!");
		this.formationInitialeMetier.modifierF_Initiale(this.f_Initiale);
		this.setModificationFInitiale(0);
		this.f_Initiale = new F_Initiale();
		return "GestionFInitialesGlobals?faces-redirect=true";
	}
	
	public String supprimerFormationInitiale(F_Initiale FI){
		this.setMsgSuccesFInitiale("Cette formation a été supprimé avec succès !!!");
		formationInitialeMetier.supprimerF_Initiale(FI.getIdFormation());
		this.setModificationFInitiale(0);
		return "GestionFInitialesGlobals?faces-redirect=true";
	}
	
	public List<Salaries> getAllSalaries(){
		return salarieMetier.getAllSalaries();
	}
	
	public List<F_Initiale> getAllFormationsInitiales(){
		return formationInitialeMetier.getAllF_Initiales();
	}
}
