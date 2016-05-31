package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.SingleThreadModel;

import ma.bps.entities.Banques;
import ma.bps.entities.Sites;
import ma.bps.entities.Societes;
import ma.bps.metier.ISiteMetier;
import ma.bps.metier.SiteMetierImpl;


@ManagedBean
@SessionScoped
public class BeanSite {
	
	private ISiteMetier siteMetier = new SiteMetierImpl();
	
	private Long idSite;
	private String libelleSite;
	private int modification=0;
	private Societes societe;
	private Sites site;
	
	public Long getIdSite() {
		return idSite;
	}
	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}
	public String getLibelleSite() {
		return libelleSite;
	}
	public void setLibelleSite(String libelleSite) {
		this.libelleSite = libelleSite;
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
	
	
	public Sites getSite() {
		return site;
	}
	public void setSite(Sites site) {
		this.site = site;
	}
	
	public Sites ajouterSite(ActionEvent e){
		Sites s = new Sites();
		s.setLibelleSite(this.getLibelleSite());
		s.setSociete(societe);
		return siteMetier.ajouterSite(s);
	}
	
	
	public List<Sites> getAllSites(){
		return siteMetier.getAllSites();
	}
	
	
	public String editerSite(Sites s){
		this.setModification(1);
		site = siteMetier.getSiteById(s.getIdSite());
		System.out.println(site.getIdSite());
		System.out.println(site.getLibelleSite());
		return "gestionSocietes?faces-redirect=true";
	}
	
	public String modifierSite(){
		Sites s = new Sites();
		s.setIdSite(site.getIdSite());
		s.setLibelleSite(site.getLibelleSite());
		s.setSociete(societe);
		this.setModification(0);
		siteMetier.modifierSite(s);
		this.setIdSite(null);
		this.setLibelleSite("");
		this.setSociete(null);
		return "gestionSocietes?faces-redirect=true";
	}
	
	public void supprimerSite(){
		System.out.println("id site : " + idSite);
		siteMetier.supprimerSite(this.getIdSite());
		System.out.println("suppression avec succès!!!");
	}
	
	
	
}
