package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.Agences;
import ma.bps.entities.Banques;
import ma.bps.metier.AgenceMetierImpl;
import ma.bps.metier.BanqueMetierImpl;
import ma.bps.metier.IAgenceMetier;
import ma.bps.metier.IBanqueMetier;


@ManagedBean
@SessionScoped
public class BeanAgence {

	private IAgenceMetier agenceMetier = new AgenceMetierImpl();
	private IBanqueMetier banqueMetier = new BanqueMetierImpl();
	
	
	private Agences agence = new Agences();
	private String msgSuccesAgence = null;
	private int modificationAgence = 0;
	
	private Long idBanque;
	
	
	
	public IAgenceMetier getAgenceMetier() {
		return agenceMetier;
	}
	public void setAgenceMetier(IAgenceMetier agenceMetier) {
		this.agenceMetier = agenceMetier;
	}
	public IBanqueMetier getBanqueMetier() {
		return banqueMetier;
	}
	public void setBanqueMetier(IBanqueMetier banqueMetier) {
		this.banqueMetier = banqueMetier;
	}
	public Long getIdBanque() {
		return idBanque;
	}
	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}
	public Agences getAgence() {
		return agence;
	}
	public void setAgence(Agences agence) {
		this.agence = agence;
	}
	public String getMsgSuccesAgence() {
		return msgSuccesAgence;
	}
	public void setMsgSuccesAgence(String msgSuccesAgence) {
		this.msgSuccesAgence = msgSuccesAgence;
	}
	public int getModificationAgence() {
		return modificationAgence;
	}
	public void setModificationAgence(int modificationAgence) {
		this.modificationAgence = modificationAgence;
	}

	public List<Agences> tousAgencesByBanque(Long idBanque){
		System.out.println("tousAgencesByBanque : " + idBanque);
		return agenceMetier.getAllAgencesByBanque(idBanque);
	}
	
	
	public Agences ajouterAgence(ActionEvent e){
		this.setMsgSuccesAgence("Cette agence a été ajouté avec succès !!!");
		Agences a = new Agences();
		this.agence.setBanque(banqueMetier.getBanqueById(this.idBanque));
		a = agenceMetier.ajouterAgence(this.agence);
		this.agence = new Agences();
		this.idBanque=0L;
		return a;
	}
	
	public List<Agences> getAllAgences(){
		return agenceMetier.getAllAgences();
	}
	
	
	public String editerAgence(Agences a){
		this.setMsgSuccesAgence(null);
		this.setModificationAgence(1);
		this.agence = a;
		this.idBanque = agence.getBanque().getIdBanque();
		return "gestionAgences?faces-redirect=true";
	}
	
	public String modifierAgence(){
		this.setModificationAgence(0);
		this.agence.setBanque(banqueMetier.getBanqueById(this.idBanque));
		agenceMetier.modifierAgence(this.agence);
		this.setMsgSuccesAgence("Cette agence a été modifié avec succès !!!");
		this.agence = new Agences();
		this.idBanque=0L;
		return "gestionAgences?faces-redirect=true";
	}
	
	public void supprimerAgence(Long idAgence){
		agenceMetier.supprimerAgence(idAgence);
		this.setMsgSuccesAgence("Cette agence a été supprimé avec succès !!!");
	}
	
	public List<Banques> getAllBanques(){
		return banqueMetier.getAllBanques();
	}
}
