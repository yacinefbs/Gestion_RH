package ma.bps.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;

import ma.bps.entities.Prets;
import ma.bps.entities.Salaries;
import ma.bps.metier.IPretsMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.PretsMetierImpl;
import ma.bps.metier.SalaireMetierImpl;
import ma.bps.metier.SalarieMetierImpl;

@ManagedBean
@SessionScoped
public class BeanPret {
	
	private IPretsMetier pretMetier = new PretsMetierImpl();
	private ISalarieMetier salarieMetier = new SalarieMetierImpl();
	private Prets pret = new Prets();
	private UIInput m = null;
	
	private String msgSuccesPret = null;
	private int modificationPret = 0;
	
	
	

	public String getMsgSuccesPret() {
		return msgSuccesPret;
	}

	public void setMsgSuccesPret(String msgSuccesPret) {
		this.msgSuccesPret = msgSuccesPret;
	}

	public int getModificationPret() {
		return modificationPret;
	}

	public void setModificationPret(int modificationPret) {
		this.modificationPret = modificationPret;
	}

	
	
	public Prets getPret() {
		return pret;
	}

	public void setPret(Prets pret) {
		this.pret = pret;
	}

	public List<Prets> allPretBySalarie(Long idSalarie){
		return pretMetier.getAllPretsBySalarie(idSalarie);
	}

	public UIInput getM() {
		return m;
	}

	public void setM(UIInput m) {
		this.m = m;
	}
	
	
	public Prets ajouterPretForSalarie(ActionEvent e){
		Prets p = new Prets();
		p = pretMetier.ajouterPret(this.pret);
		this.pret = new Prets();
		this.setMsgSuccesPret("Ce prêt a été ajouté avec succès !!!");
		this.setModificationPret(0);
		return p;
	}
	
	public List<Prets> getAllPrets(){
		return pretMetier.getAllPrets();
	}
	
	public String editerPretSalarie(Prets p){
		System.out.println("editer pret");
		this.setMsgSuccesPret(null);
		this.setModificationPret(1);
 		this.pret = p;
		return "gestionPretsGlobals?faces-redirect=true";
	}
	
	public String modifierPret(){
		pretMetier.modifierPrets(this.pret);
		this.pret = new Prets();
		this.setMsgSuccesPret("Ce prêt a été modifié avec succès !!!");
		this.setModificationPret(0);
		return "gestionPretsGlobals?faces-redirect=true";
	}
	
	public String supprimerPret(Long idPret){
		this.setModificationPret(0);
		pretMetier.supprimerPret(idPret);
		this.setMsgSuccesPret("Ce prêt a été supprimé avec succès !!!");
		return "gestionPretsGlobals?faces-redirect=true";
	}
	
	public List<Salaries> getAllSalaries(){
		return salarieMetier.getAllSalaries();
	}
}
