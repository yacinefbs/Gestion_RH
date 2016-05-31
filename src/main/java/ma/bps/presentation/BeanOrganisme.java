package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.F_Initiale;
import ma.bps.entities.Organismes;
import ma.bps.metier.IOrganismesMetier;
import ma.bps.metier.OrganismesMetierImpl;

@ManagedBean
@SessionScoped
public class BeanOrganisme {
	
	private IOrganismesMetier organismeMetier = new OrganismesMetierImpl();
	private Organismes organisme = new Organismes();
	private String msgSuccesOrganisme = null;
	private int modificationOrganisme = 0;
	
	public Organismes getOrganisme() {
		return organisme;
	}
	public void setOrganisme(Organismes organisme) {
		this.organisme = organisme;
	}
	public String getMsgSuccesOrganisme() {
		return msgSuccesOrganisme;
	}
	public void setMsgSuccesOrganisme(String msgSuccesOrganisme) {
		this.msgSuccesOrganisme = msgSuccesOrganisme;
	}
	public int getModificationOrganisme() {
		return modificationOrganisme;
	}
	public void setModificationOrganisme(int modificationOrganisme) {
		this.modificationOrganisme = modificationOrganisme;
	}
	
	
	public String ajouterOrganisme(ActionEvent e){
		this.setMsgSuccesOrganisme("Cet organisme a été ajouté avec succès !!!");
		organismeMetier.ajouterOrganisme(this.organisme);
		this.organisme = new Organismes();
		return "gestionOrganismes?faces-redirect=true";
	}
	
	public List<Organismes> getAllOrganismes(){
		return organismeMetier.getAllOrganismes();
	}
	
	public String editerOrganisme(Organismes o){
		this.setMsgSuccesOrganisme(null);
		this.setModificationOrganisme(1);
		this.organisme = o;
		return "gestionOrganismes?faces-redirect=true";
	}
	
	public String modifierOrganisme(){
		this.setModificationOrganisme(0);
		this.setMsgSuccesOrganisme("Cet organisme a été modifié avec succès !!!");
		this.organisme = organismeMetier.modifierOrganismes(this.organisme);
		this.organisme = new Organismes();
		return "gestionOrganismes?faces-redirect=true";
	}
	
	public String supprimerOrganisme(Long idOrganisme){
		this.setModificationOrganisme(0);
		organismeMetier.supprimerOrganisme(idOrganisme);
		this.setMsgSuccesOrganisme("Cet organisme a été supprimé avec succès !!!");
		return "gestionOrganismes?faces-redirect=true";
	}
	
}
