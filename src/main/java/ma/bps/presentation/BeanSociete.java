package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.Societes;
import ma.bps.metier.ISocieteMetier;
import ma.bps.metier.SocieteMetierImpl;

@ManagedBean
@SessionScoped
public class BeanSociete {
	
	private ISocieteMetier societeMetier = new SocieteMetierImpl();
	
	private Long idSociete;
	private String nomSociete;
	private String adresseSociete;
	private int modification=0;
	private Societes societe;
	
	
	
	public Long getIdSociete() {
		return idSociete;
	}
	public void setIdSociete(Long idSociete) {
		this.idSociete = idSociete;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	public String getAdresseSociete() {
		return adresseSociete;
	}
	public void setAdresseSociete(String adresseSociete) {
		this.adresseSociete = adresseSociete;
	}
	public int getModification() {
		return modification;
	}
	public void setModification(int modification) {
		this.modification = modification;
	}
	public Societes getSociete() {
		return societe;
	}
	public void setSociete(Societes societe) {
		this.societe = societe;
	}
	
	
	public Societes ajouterSociete(ActionEvent e){
		Societes s = new Societes();
		s.setNomSociete(this.getNomSociete());
		s.setAdresseSociete(this.getAdresseSociete());
		return societeMetier.ajouterSociete(s);
	}
	
	
	public List<Societes> getAllSocietes(){
		return societeMetier.getAllSocietes();
	}
	
	
	public String editerSociete(Societes s){
		this.setModification(1);
		this.setSociete(societeMetier.getSocieteById(s.getIdSociete()));
		System.out.println(societe.getIdSociete());
		System.out.println(societe.getNomSociete());
		System.out.println(societe.getAdresseSociete());
		return "gestionSocietes?faces-redirect=true";
	}
	
	public String modifierSociete(){
		Societes s = new Societes();
		s.setIdSociete(societe.getIdSociete());
		s.setNomSociete(societe.getNomSociete());
		s.setAdresseSociete(societe.getAdresseSociete());
		this.setModification(0);
		societeMetier.modifierSociete(s);
		this.setIdSociete(null);
		this.setNomSociete("");
		this.setAdresseSociete("");
		return "gestionSocietes?faces-redirect=true";
	}
	
	public void supprimerSociete(){
		System.out.println("id societe" + idSociete);
		societeMetier.supprimerSociete(idSociete);
		System.out.println("suppression avec succès !!!");
	}
}
