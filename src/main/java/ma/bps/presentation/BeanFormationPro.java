package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.F_Initiale;
import ma.bps.entities.F_Professionnelles;
import ma.bps.entities.Salaries;
import ma.bps.metier.F_ProfessionnelleMetierImpl;
import ma.bps.metier.IF_ProfessionnelleMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.SalarieMetierImpl;

@ManagedBean
@SessionScoped
public class BeanFormationPro {
	private IF_ProfessionnelleMetier formationProMetier = new F_ProfessionnelleMetierImpl();
	private ISalarieMetier salarieMetier = new SalarieMetierImpl();
	private String msgSuccesFPro = null;
	private int modificationFPro = 0;
	private F_Professionnelles f_Professionnelles = new F_Professionnelles();
	public String getMsgSuccesFPro() {
		return msgSuccesFPro;
	}
	public void setMsgSuccesFPro(String msgSuccesFPro) {
		this.msgSuccesFPro = msgSuccesFPro;
	}
	public int getModificationFPro() {
		return modificationFPro;
	}
	public void setModificationFPro(int modificationFPro) {
		this.modificationFPro = modificationFPro;
	}
	public F_Professionnelles getF_Professionnelles() {
		return f_Professionnelles;
	}
	public void setF_Professionnelles(F_Professionnelles f_Professionnelles) {
		this.f_Professionnelles = f_Professionnelles;
	}
	
	public F_Professionnelles ajouterFormationPro(ActionEvent e){
		this.setMsgSuccesFPro("Cette formation a été ajouté avec succès !!!");
		F_Professionnelles f_Professionnelles = new F_Professionnelles();
		f_Professionnelles = formationProMetier.ajouterF_Pro(this.f_Professionnelles);
		this.f_Professionnelles = new F_Professionnelles();
		return f_Professionnelles;
	}
	
	public String editerFormationPro(F_Professionnelles FP){
		this.setMsgSuccesFPro(null);
		this.f_Professionnelles = FP;
		this.setModificationFPro(1);
		return "GestionFProfessionnelleGlobals?faces-redirect=true";
	}
	
	public String modifierFormationPro(){
		this.setMsgSuccesFPro("Cette formation été modifié avec succès !!!");
		this.f_Professionnelles = formationProMetier.modifierF_Professionnelles(this.f_Professionnelles);
		this.setModificationFPro(0);
		this.f_Professionnelles = new F_Professionnelles();
		return "GestionFProfessionnelleGlobals?faces-redirect=true";
	}
	
	public String supprimerFormationPro(F_Professionnelles FP){
		this.setMsgSuccesFPro("Cette formation a été supprimé avec succès !!!");
		formationProMetier.supprimerF_Professionnelles(FP.getIdFormation());
		this.setModificationFPro(0);
		return "GestionFProfessionnelleGlobals?faces-redirect=true";
	}
	
	public List<Salaries> getAllSalaries(){
		return salarieMetier.getAllSalaries();
	}
	
	public List<F_Professionnelles> getAllFormationsPros(){
		return formationProMetier.getAllF_Professionnelles();
	}
}
