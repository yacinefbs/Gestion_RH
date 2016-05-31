package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.B_Anciennetes;
import ma.bps.metier.BAncienneteMetierImpl;
import ma.bps.metier.IBAncienneteMetier;

@ManagedBean
@SessionScoped
public class BeanBAnciennete {
	
	IBAncienneteMetier ancienneteMetier = new BAncienneteMetierImpl();
	B_Anciennetes b_anciennete = new B_Anciennetes();
	private String msgSuccess = null;
	private int modification = 0;
	
	
	public String getMsgSuccess() {
		return msgSuccess;
	}
	public void setMsgSuccess(String msgSuccess) {
		this.msgSuccess = msgSuccess;
	}
	public int getModification() {
		return modification;
	}
	public void setModification(int modification) {
		this.modification = modification;
	}
	public B_Anciennetes getB_anciennete() {
		return b_anciennete;
	}
	public void setB_anciennete(B_Anciennetes b_anciennete) {
		this.b_anciennete = b_anciennete;
	}
	
	public void ajouterB_Anciennete(ActionEvent e){
		this.setMsgSuccess("Ce barème a été ajouté avec succès !!!");
		this.b_anciennete = ancienneteMetier.ajouterB_Anciennetes(this.b_anciennete);
		this.b_anciennete = new B_Anciennetes();
	}
	
	public List<B_Anciennetes> getAllBAnciennete(){
		return ancienneteMetier.getAllB_Anciennetes();
	}
	
	public String editerBAnciennete(Long idB_anciennete){
		this.setMsgSuccess(null);
		this.setModification(1);
		this.b_anciennete = ancienneteMetier.getB_AnciennetesById(idB_anciennete);
		return "gestionBAnc?faces-redirect=true";
	}
	
	public String modifierBAnciennete(){
		this.setModification(0);
		ancienneteMetier.modifierB_Anciennete(this.b_anciennete);
		this.setMsgSuccess("Ce barème d'ancienneté a été modifié avec succès !!!");
		this.b_anciennete = new B_Anciennetes();
		return "gestionBAnc?faces-redirect=true";
	}
	
	public void supprimerBAnciennete(Long idBAnciennete){
		ancienneteMetier.supprimerB_Anciennetes(idBAnciennete);
		this.setModification(0);
		this.setMsgSuccess("Ce barème a été supprimé avec succès !!!");
	}
}
