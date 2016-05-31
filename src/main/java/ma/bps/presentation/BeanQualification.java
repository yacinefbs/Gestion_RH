package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.Banques;
import ma.bps.entities.Qualifications;
import ma.bps.metier.IQualificationMetier;
import ma.bps.metier.QualificationMetierImpl;

@ManagedBean
@SessionScoped
public class BeanQualification {
	private IQualificationMetier qualificationMetier = new QualificationMetierImpl();
	
	private int modification;
	private Qualifications qualification = new Qualifications();
	private String msgQualification = null;
	
	
	public String getMsgQualification() {
		return msgQualification;
	}
	public void setMsgQualification(String msgQualification) {
		this.msgQualification = msgQualification;
	}
	
	public int getModification() {
		return modification;
	}
	public void setModification(int modification) {
		this.modification = modification;
	}
	public Qualifications getQualification() {
		return qualification;
	}
	public void setQualification(Qualifications qualification) {
		this.qualification = qualification;
	}
	
	
	public Qualifications ajouterQualification(ActionEvent e){
		Qualifications q = new Qualifications();
		q = qualificationMetier.ajouterQualification(this.qualification);
		this.qualification = new Qualifications();
		this.setMsgQualification("Cette qualification a été ajouté avec succès !!!");
 		return q;
	}
	
	
	public List<Qualifications> getAllQualifications(){
		return qualificationMetier.getAllQualifications();
	}
	
	
	public String editerQualification(Qualifications q){
		this.setMsgQualification(null);
		this.setModification(1);
		this.qualification = qualificationMetier.getQualificationById(q.getIdQualification());
		return "gestionQualifications?faces-redirect=true";  
	}
	
	
	public String modifierQualification(){
		this.setModification(0);
		qualificationMetier.modifierQualification(this.qualification);
		this.qualification = new Qualifications();
		this.setMsgQualification("Cette qualification a été modifié avec succès !!!");
		return "gestionQualifications?faces-redirect=true";
	}
	
	public void supprimerQualification(){
		qualificationMetier.supprimerQualification(this.qualification.getIdQualification());
		this.setMsgQualification("Cette qualification a été supprimé avec succès !!!");
		System.out.println("suppression avec succès!!!");
	}
	
}
