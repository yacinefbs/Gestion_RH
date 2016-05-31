package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.Rubriques;
import ma.bps.entities.TauxFraisPro;
import ma.bps.metier.ITauxFraisProMetier;
import ma.bps.metier.TauxFraisProMetierImpl;

@ManagedBean
@SessionScoped
public class BeanTauxFraisPro {
	private TauxFraisPro tauxFraisPro = new TauxFraisPro();
	private ITauxFraisProMetier tauxFraisProMetier = new TauxFraisProMetierImpl();
	
	private String msgSuccesTauxFraisPro = null;
	private int modificationTauxFraisPro = 0;
	public TauxFraisPro getTauxFraisPro() {
		return tauxFraisPro;
	}
	public void setTauxFraisPro(TauxFraisPro tauxFraisPro) {
		this.tauxFraisPro = tauxFraisPro;
	}
	public String getMsgSuccesTauxFraisPro() {
		return msgSuccesTauxFraisPro;
	}
	public void setMsgSuccesTauxFraisPro(String msgSuccesTauxFraisPro) {
		this.msgSuccesTauxFraisPro = msgSuccesTauxFraisPro;
	}
	public int getModificationTauxFraisPro() {
		return modificationTauxFraisPro;
	}
	public void setModificationTauxFraisPro(int modificationTauxFraisPro) {
		this.modificationTauxFraisPro = modificationTauxFraisPro;
	}
	
	public void ajouterTauxFraisPro(ActionEvent e){
		this.setModificationTauxFraisPro(0);
		System.out.println("libelle : " + this.tauxFraisPro.getLibelle());
		System.out.println("taux : " + this.tauxFraisPro.getTaux());
		System.out.println("plafond : " + this.tauxFraisPro.getPlafond());
		this.tauxFraisPro = tauxFraisProMetier.ajouterTauxFraisPro(this.tauxFraisPro);
		this.setMsgSuccesTauxFraisPro("Ce taux a été ajouté avec succès !!!");
		this.tauxFraisPro = new TauxFraisPro();
	}
	
	public List<TauxFraisPro> getAllTauxFraisPro(){
		return tauxFraisProMetier.getAllTauxFraisPros();
	}
	
	public String editerTauxFraisPro(TauxFraisPro tfp) {
		this.setMsgSuccesTauxFraisPro(null);
		this.setModificationTauxFraisPro(1);
		this.tauxFraisPro = tfp;
		return "gestionTauxFraisPro?faces-redirect=true";
	}
	
	public String modifierTauxFraisPro(){
		this.setModificationTauxFraisPro(0);
		this.tauxFraisPro = tauxFraisProMetier.modifierTauxFraisPro(this.tauxFraisPro);
		this.tauxFraisPro = new TauxFraisPro();
		this.setMsgSuccesTauxFraisPro("Ce taux de frais professionnel a été modifié avec succès !!!");
		return "gestionTauxFraisPro?faces-redirect=true";
	}
	
	public String supprimerTauxFraisPro(Long idTauxFraisPro){
		this.setModificationTauxFraisPro(0);
		tauxFraisProMetier.supprimerTauxFraisPro(idTauxFraisPro);
		this.setMsgSuccesTauxFraisPro("Ce taux de frais professionnel a été supprimé avec succès !!!");
		return "gestionTauxFraisPro?faces-redirect=true";
	}
}
