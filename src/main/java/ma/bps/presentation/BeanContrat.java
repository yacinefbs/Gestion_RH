package ma.bps.presentation;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import defaults.typeContrat;
import ma.bps.entities.Agences;
//import ma.bps.entities.ANAPEC;
//import ma.bps.entities.CDD;
//import ma.bps.entities.CDI;
import ma.bps.entities.Contrats;
//import ma.bps.entities.Occasionnel;
import ma.bps.entities.Organismes;
import ma.bps.entities.Salaries;
import ma.bps.metier.ContratMetierImpl;
import ma.bps.metier.IContratMetier;
import ma.bps.metier.IOrganismesMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.OrganismesMetierImpl;
import ma.bps.metier.SalaireMetierImpl;
import ma.bps.metier.SalarieMetierImpl;

@ManagedBean(name="beanContrat")
@SessionScoped
public class BeanContrat {
	
	private IContratMetier contratMetier = new ContratMetierImpl();
	private ISalarieMetier salarieMetier = new SalarieMetierImpl();
	private Contrats contrat = new Contrats();
	private String msgSuccesContrat = null;
	private int modificationContrat = 0;

	public Contrats getContrat() {
		return contrat;
	}

	public void setContrat(Contrats contrat) {
		this.contrat = contrat;
	}
	
	public String getMsgSuccesContrat() {
		return msgSuccesContrat;
	}

	public void setMsgSuccesContrat(String msgSuccesContrat) {
		this.msgSuccesContrat = msgSuccesContrat;
	}

	public int getModificationContrat() {
		return modificationContrat;
	}

	public void setModificationContrat(int modificationContrat) {
		this.modificationContrat = modificationContrat;
	}

	public List<Salaries> getAllSalarie(){
		return salarieMetier.getAllSalaries();
	}
	
	public Contrats ajouterContrat(ActionEvent e){
		this.setMsgSuccesContrat("Ce contrat a été ajouté avec succès !!!");
		Contrats c = new Contrats();
		System.out.println("date  : " + this.contrat.getDate());
		System.out.println("profil  : " + this.contrat.getProfil());
		System.out.println("date debut  : " + this.contrat.getDateDebutContrat());
		System.out.println("date fin  : " + this.contrat.getDateFinContrat());
		System.out.println("Matricule  : " + this.contrat.getSalarie().getIdSalarie());
		c = contratMetier.ajouterContrat(this.contrat);
		this.contrat = new Contrats();
		return c;
	}

	public List<Contrats> getAllContrat(){
		return contratMetier.getAllContrats();
	}
	
	public String editerContrat(Contrats c){
		this.setMsgSuccesContrat(null);
		this.setModificationContrat(1);
		this.contrat = c;
		return "gestionContratsGlobals?faces-redirect=true";
	}
	
	public String modifierContrat(){
		this.setModificationContrat(0);
		contratMetier.modifierContrat(this.contrat);
		this.setMsgSuccesContrat("Ce contrat a été modifié avec succès !!!");
		this.contrat = new Contrats();
		return "gestionContratsGlobals?faces-redirect=true";
	}
	
	public void supprimerContrat(Long idContrat){
		contratMetier.supprimerContrat(idContrat);
		this.setMsgSuccesContrat("Ce contrat a été supprimé avec succès !!!");
	}
}
