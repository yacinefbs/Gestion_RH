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
public class BeanBanque {
	
	IBanqueMetier banqueMetier = new BanqueMetierImpl();
	
	
	
	private Long idBanque;
	private String nomBanque;
	private int modification=0;
	private Banques banque = new Banques();
	private String msgSucces = null;
	
	
	public String getMsgSucces() {
		return msgSucces;
	}

	public void setMsgSucces(String msgSucces) {
		this.msgSucces = msgSucces;
	}

	public Long getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}
	
	public int getModification() {
		return modification;
	}

	public Banques getBanque() {
		return banque;
	}

	public void setBanque(Banques banque) {
		this.banque = banque;
	}

	public void setModification(int modification) {
		this.modification = modification;
	}

	public Banques ajouterBanque(ActionEvent e){
		this.setMsgSucces("Cette banque a été ajouté avec succès !!!");
		Banques b = new Banques();
		b = banqueMetier.ajouterBanque(this.banque);
		this.banque = new Banques();
		return b;
	}
	
	public List<Banques> getAllBanques(){
		return banqueMetier.getAllBanques();
	}
	
	
	public String editerBanque(Banques b){
		this.setMsgSucces(null);
		modification=1;
		this.banque = banqueMetier.getBanqueById(b.getIdBanque());
		return "gestionBanques?faces-redirect=true";
	}
	
	public String modifierBanque(){
		modification=0;
		banqueMetier.modifierBanque(this.banque);
		this.setIdBanque(null);
		this.setNomBanque("");
		this.setMsgSucces("Cette banque a été modifié avec succès !!!");
		this.banque = new Banques();
		return "gestionBanques?faces-redirect=true";
	}
	
	public void supprimerBanque(Long idBanque){
		banqueMetier.supprimerBanque(idBanque);
		this.setMsgSucces("Cette banque a été supprimé avec succès !!!");
		System.out.println("suppression avec succès!!!");
	}
}
