package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.Cotisations;
import ma.bps.entities.Organismes;
import ma.bps.metier.CotisationMetierImpl;
import ma.bps.metier.ICotisationMetier;
import ma.bps.metier.IOrganismesMetier;
import ma.bps.metier.OrganismesMetierImpl;

@ManagedBean
@SessionScoped
public class BeanCotisation {
	private ICotisationMetier cotisationMetier = new CotisationMetierImpl();
	private IOrganismesMetier organisme = new OrganismesMetierImpl();
	
	private int modificationCotisation = 0;
	private String msgSuccesCotisation = null;
	private Cotisations cotisation = new Cotisations();
	private Long idOrganisme;
	
	
	
	
	public Long getIdOrganisme() {
		return idOrganisme;
	}
	public void setIdOrganisme(Long idOrganisme) {
		this.idOrganisme = idOrganisme;
	}
	public int getModificationCotisation() {
		return modificationCotisation;
	}
	public void setModificationCotisation(int modificationCotisation) {
		this.modificationCotisation = modificationCotisation;
	}
	public String getMsgSuccesCotisation() {
		return msgSuccesCotisation;
	}
	public void setMsgSuccesCotisation(String msgSuccesCotisation) {
		this.msgSuccesCotisation = msgSuccesCotisation;
	}
	public Cotisations getCotisation() {
		return cotisation;
	}
	public void setCotisation(Cotisations cotisation) {
		this.cotisation = cotisation;
	}
	
	
	public Cotisations ajouterCotisation(ActionEvent e){
		this.setMsgSuccesCotisation("Cette cotisation a été ajouté avec succès !!!");
//		this.cotisation.getOrganisme().setIdOrganisme(this.idOrganisme);
		this.cotisation.setOrganisme(organisme.getOrganismeById(this.idOrganisme));
		Cotisations cts = cotisationMetier.ajouterCotisation(this.cotisation);
		this.cotisation = new Cotisations();
		return cts;
	}
	
	
	public List<Cotisations> getAllCotisation(){
		List<Cotisations> list = cotisationMetier.getAllCotisations();
//		for (Cotisations cotisations : list) {
//			System.out.println("organisme : " + cotisations.getOrganisme().getLibelleOrganisme());
//		}
		return list;
	}
	
	public String editerCotisation(Cotisations c){
		this.setMsgSuccesCotisation(null);
		this.setModificationCotisation(1);
		this.cotisation = c;
		return "gestionCotisations?faces-redirect=true";
	}
	
	public String modifierCotisation(){
		 this.setModificationCotisation(0);
		 this.setMsgSuccesCotisation("Cette cotisation a été modifié avec succès !!!");
		 System.out.println("id organisme : " + this.cotisation.getOrganisme().getIdOrganisme());
//		 this.cotisation.getOrganisme().setIdOrganisme(this.idOrganisme);
		 this.cotisation.setOrganisme(organisme.getOrganismeById(this.idOrganisme));
		 this.cotisation = cotisationMetier.modifierCotisation(this.cotisation);
		 this.cotisation = new Cotisations();
		 return "gestionCotisations?faces-redirect=true";
	 }
	
	public String supprimerCotisation(Long idCotisation){
		this.setModificationCotisation(0);
		cotisationMetier.supprimerCotisation(idCotisation);
		this.setMsgSuccesCotisation("Cette cotisation a été supprimé avec succès !!!");
		return "gestionCotisations?faces-redirect=true";
	}
	public List<Organismes> getAllOrganisme(){
		IOrganismesMetier organismeMetier = new OrganismesMetierImpl();
		return organismeMetier.getAllOrganismes();
	}
}
