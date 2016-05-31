package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.Cotisations;
import ma.bps.entities.Rubriques;
import ma.bps.metier.IOrganismesMetier;
import ma.bps.metier.IRubriquMetier;
import ma.bps.metier.OrganismesMetierImpl;
import ma.bps.metier.RubriqueMetierImpl;

@ManagedBean
@SessionScoped
public class BeanRubrique {
	private IRubriquMetier rubriqueMetier = new RubriqueMetierImpl();
	private Rubriques rubrique = new Rubriques();
	
	private String msgSuccesRubrique = null;
	private int modificationRubrique = 0;
	public Rubriques getRubrique() {
		return rubrique;
	}
	public void setRubrique(Rubriques rubrique) {
		this.rubrique = rubrique;
	}
	
	public String getMsgSuccesRubrique() {
		return msgSuccesRubrique;
	}
	public void setMsgSuccesRubrique(String msgSuccesRubrique) {
		this.msgSuccesRubrique = msgSuccesRubrique;
	}
	public int getModificationRubrique() {
		return modificationRubrique;
	}
	public void setModificationRubrique(int modificationRubrique) {
		this.modificationRubrique = modificationRubrique;
	}
	
	public void ajouterRubrique(ActionEvent e){
		this.setMsgSuccesRubrique("Cette rubrique a été ajouté avec succès !!!");
		this.rubrique.setOrganisme(null);
		rubriqueMetier.ajouterRubrique(this.rubrique);
		this.rubrique = new Rubriques();
	}
	
	
	public List<Rubriques> getAllRubriques(){
		return rubriqueMetier.getAllRubriques();
	}
	
	public String editerRubrique(Rubriques rubrique){
		this.setMsgSuccesRubrique(null);
		this.setModificationRubrique(1);
		this.rubrique = rubrique;
		return "gestionRubriques?faces-redirect=true";
	}
	
	public String modifierRubrique(){
		this.setModificationRubrique(0);
		this.setMsgSuccesRubrique("Cette rubrique a été ajouté avec succès !!!");
		this.rubrique = rubriqueMetier.modifierRubrique(this.rubrique);
		this.rubrique = new Rubriques();
		return "gestionRubriques?faces-redirect=true";
	}
	
	public String supprimerRubrique(Long idRubrique){
		this.setModificationRubrique(0);
		rubriqueMetier.supprimerRubrique(idRubrique);
		this.setMsgSuccesRubrique("Cette rubrique a été supprimé avec succès !!!");
		return "gestionRubriques?faces-redirect=true";
	}
	
}
