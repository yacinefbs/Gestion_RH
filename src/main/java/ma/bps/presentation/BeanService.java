package ma.bps.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.Banques;
import ma.bps.entities.Services;
import ma.bps.metier.IServiceMetier;
import ma.bps.metier.ServiceMetierImpl;

@ManagedBean(name="beanService")
@SessionScoped
public class BeanService {
	IServiceMetier serviceMetier = new ServiceMetierImpl();
	
	private String msgSucces;
	private int modification=0;
	private Services service = new Services();
	
	
	public String getMsgSucces() {
		return msgSucces;
	}
	public void setMsgSucces(String msgSucces) {
		this.msgSucces = msgSucces;
	}
	
	public int getModification() {
		return modification;
	}
	public void setModification(int modification) {
		this.modification = modification;
	}
	public Services getService() {
		return service;
	}
	public void setService(Services service) {
		this.service = service;
	}
	
	
	public Services ajouterService(ActionEvent e){
		Services service = new Services();
		service = serviceMetier.ajouterService(this.service);
		msgSucces = "Ce service a été ajouté avec succès !!!";
		this.service = new Services();
		return service;
	}
	
	
	public List<Services> getAllService(){
		return serviceMetier.getAllServices();
	}
	
	public String editerService(Services s){
		this.setModification(1);
		this.msgSucces = null;
		this.service = serviceMetier.getServiceById(s.getIdService());
		return "gestionServices?faces-redirect=true"; //&&mod=1&idService=" + s.getIdService() + "&nomService=" + s.getLibelle();
	}
	
	
	public String modifierService(){
		this.setModification(0);
		this.service = serviceMetier.modifierService(this.service);
		this.msgSucces = "Ce service a été modifié avec succès !!!";
		this.service = new Services();
		return "gestionServices?faces-redirect=true";
	}
	
	public void supprimerService(){
		serviceMetier.supprimerService(this.service.getIdService());
		this.msgSucces = "Ce service a été supprimé avec succès !!!";
		System.out.println("suppression avec succès!!!");
	}
}
