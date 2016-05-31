package ma.bps.presentation;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import ma.bps.entities.Avances;
import ma.bps.entities.Banques;
import ma.bps.entities.ModePaiements;
import ma.bps.entities.Salaries;
import ma.bps.metier.AvanceMetierImpl;
import ma.bps.metier.IAvanceMetier;
import ma.bps.metier.IModePaiementMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.ModePaiementMetierImpl;
import ma.bps.metier.SalarieMetierImpl;


@ManagedBean
@SessionScoped
public class BeanAvance {
	private IAvanceMetier avanceMetier = new AvanceMetierImpl();
	private IModePaiementMetier modePaiementMetier  = new ModePaiementMetierImpl();
	private ISalarieMetier salarieMetier = new SalarieMetierImpl();
	
	
	private Avances avance = new Avances();
	private String msgSuccesAvance = null;
	private int modificationAvance = 0;
	
	
	
	public String getMsgSuccesAvance() {
		return msgSuccesAvance;
	}


	public void setMsgSuccesAvance(String msgSuccesAvance) {
		this.msgSuccesAvance = msgSuccesAvance;
	}


	public int getModificationAvance() {
		return modificationAvance;
	}


	public void setModificationAvance(int modificationAvance) {
		this.modificationAvance = modificationAvance;
	}


	public Avances getAvance() {
		return avance;
	}


	public void setAvance(Avances avance) {
		this.avance = avance;
	}


	public Avances ajouterAvance(ActionEvent e){
//		Avances a = new Avances();
//		Salaries s = new Salaries();
//		ModePaiements mode = new ModePaiements();
		
//		s.setIdEmploye(idSalarie);
//		IModePaiementMetier modePaiementMetier = new ModePaiementMetierImpl();
		
//		mode=modePaiementMetier.getModePaiementById(idModePaiement);
		
//		a.setModePaiement(mode);
//		a.setDateAvance(new Date());
//		a.setMontant(montant);
//		a.setSalarie(s);
//		a.setModePaiement(mode);
		this.avance.setDateAvance(new Date());
		Avances avance = new Avances();
		avance = avanceMetier.ajouterAvance(this.avance);
		this.avance = new Avances();
		this.setMsgSuccesAvance("Cette avance a été ajouté avec succès !!!");
		return avance;
	}
	
	
	public List<Avances> getAllAvances(){
		return avanceMetier.getAllAvances();
	}
	
	
	public String editerAvance(Avances a){
		//return "gestionAvances?faces-redirect=true&&mod=1&idAvence=" + a + "&nomBanque=" + b.getNomBanque();
		this.setMsgSuccesAvance(null);
		this.setModificationAvance(1);
		this.avance = a;
		return "gestionAvancesGlobals?faces-redirect=true";
	}
	
	
	public String modifierAvance(){
//		Avances a = new Avances();
//		Salaries s = new Salaries();
//		ModePaiements mode = new ModePaiements();
//		
//		s.setIdEmploye(idSalarie);
//		mode.setIdPaiement(idModePaiement);
//		
//		a.setModePaiement(mode);
//		a.setDateAvance(new Date());
//		a.setMontant(montant);
//		a.setSalarie(s);
//		a.setModePaiement(mode);
		avanceMetier.modifierAvance(this.avance);
		this.setMsgSuccesAvance("Cette avance a été modifié avec succès !!!");
		this.setModificationAvance(0);
		this.avance = new Avances();
		return "gestionAvancesGlobals?faces-redirect=true";
	}
	
	public void supprimerAvance(Long idAv){
		avanceMetier.supprimerAvance(idAv);
		this.setMsgSuccesAvance("Cette avance a été supprimé avec succès !!!");
		this.setModificationAvance(0);
		System.out.println("suppression avec succès!!!");
	}
	
	public List<ModePaiements> getAllModePaiement(){
		System.out.println("ici mode paiement");
		return modePaiementMetier.getAllModePaiement();
		
	}
	
	public List<Salaries> getAllSalaries(){
		return salarieMetier.getAllSalaries();
	}
}
