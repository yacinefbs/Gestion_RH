package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.B_IGR;
import ma.bps.metier.B_IgrMetierImpl;
import ma.bps.metier.IB_IgrMetier;

@ManagedBean
@SessionScoped
public class BeanBIgr {

	IB_IgrMetier b_igrMetier = new B_IgrMetierImpl();
	B_IGR b_IGR = new B_IGR();
	private String msgSuccess = null;
	private int modification = 0;
	
	
	public B_IGR getB_IGR() {
		return b_IGR;
	}
	public void setB_IGR(B_IGR b_IGR) {
		this.b_IGR = b_IGR;
	}
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
	
	public void ajouterB_Igr(ActionEvent e){
		this.setMsgSuccess("Ce barème a été ajouté avec succès !!!");
		this.b_IGR = b_igrMetier.ajouterB_IGR(this.b_IGR);
		this.b_IGR = new B_IGR();
	}
	
	public List<B_IGR> getAllBIgr(){
		return b_igrMetier.getAllB_IGRs();
	}
	
	public String editerBIgr(Long idBIgr){
		this.setMsgSuccess(null);
		this.setModification(1);
		this.b_IGR = b_igrMetier.getB_IGRById(idBIgr);
		return "gestionBIgr?faces-redirect=true";
	}
	
	public String modifierBIgr(){
		this.setModification(0);
		b_igrMetier.modifierB_IGR(this.b_IGR);
		this.setMsgSuccess("Ce barème d'ancienneté a été modifié avec succès !!!");
		this.b_IGR = new B_IGR();
		return "gestionBIgr?faces-redirect=true";
	}
	
	public void supprimerBIgr(Long idB_Igr){
		b_igrMetier.supprimerB_IGR(idB_Igr);
		this.setModification(0);
		this.setMsgSuccess("Ce barème a été supprimé avec succès !!!");
	}
	
}
