package ma.bps.presentation;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.bps.entities.Conges;
import ma.bps.entities.Contrats;
import ma.bps.entities.Salaries;
import ma.bps.metier.CongeMetierImpl;
import ma.bps.metier.ICongeMetier;
import ma.bps.metier.ISalaireMetier;
import ma.bps.metier.ISalarieMetier;
import ma.bps.metier.SalarieMetierImpl;

@ManagedBean
@SessionScoped
public class BeanConge {
	private Conges conge = new Conges();
	
	private ICongeMetier congeMetier = new CongeMetierImpl();
	private ISalarieMetier salarieMetier = new SalarieMetierImpl();
	private String msgSuccesConge = null;
	private int modificationConge = 0;
	
	
	public String getMsgSuccesConge() {
		return msgSuccesConge;
	}

	public void setMsgSuccesConge(String msgSuccesConge) {
		this.msgSuccesConge = msgSuccesConge;
	}

	public int getModificationConge() {
		return modificationConge;
	}

	public void setModificationConge(int modificationConge) {
		this.modificationConge = modificationConge;
	}

	public Conges getConge() {
		return conge;
	}

	public void setConge(Conges conge) {
		this.conge = conge;
	}
	
//	public Contrats ajouterContrat(ActionEvent e){
//		this.setMsgSuccesContrat("Ce contrat a été ajouté avec succès !!!");
//		Contrats c = new Contrats();
//		System.out.println("date  : " + this.contrat.getDate());
//		System.out.println("profil  : " + this.contrat.getProfil());
//		System.out.println("date debut  : " + this.contrat.getDateDebutContrat());
//		System.out.println("date fin  : " + this.contrat.getDateFinContrat());
//		System.out.println("Matricule  : " + this.contrat.getSalarie().getIdSalarie());
//		c = contratMetier.ajouterContrat(this.contrat);
//		this.contrat = new Contrats();
//		return c;
//	}
	
	
	public Conges ajouterConge(ActionEvent e){
//		this.setMsgSuccesConge("Ce congé a été ajouté avec succès !!!");
//		Conges c = new Conges();
//		c = congeMetier.ajouterConge(this.conge);
//		this.conge = new Conges();
//		return c;

		double nbrJourCongeRestant = congeMetier.nbrJoursCongeRestant(this.conge.getSalarie().getIdSalarie(), 1L);
		Date dateDebut;
		Date dateFin;
		double gap = 0;
			dateDebut = this.conge.getDateDebutC();
			dateFin = this.conge.getDateFinC();
			System.out.println("date debut : " + dateDebut);
			System.out.println("date fin : " + dateFin);

			GregorianCalendar gc1 = new GregorianCalendar();
			 gc1.setTime(dateDebut);
			 GregorianCalendar gc2 = new GregorianCalendar();
			 gc2.setTime(dateFin);
			 
		        gc1.add(GregorianCalendar.DAY_OF_WEEK, 1);
		        while(gc1.compareTo(gc2)<=0) {
		            gap++;
		            gc1.add(GregorianCalendar.DAY_OF_WEEK, 1);
		        }
		gap = gap +1;
		
		if(this.conge.getNature().equals("normal")){
			System.out.println("gap : ************************************************************   " + gap);
			System.out.println("nbrJourConge : ***************************************************************  " + nbrJourCongeRestant);
			if(gap>nbrJourCongeRestant){
				this.msgSuccesConge = "Vous avez dépassé le nombre de jours disponibles !!!";
				return null;
			}
		}
		
		
		this.setMsgSuccesConge(null);
		this.conge.setValide("pas encore");
		congeMetier.ajouterConge(this.conge);

		//Charger la liste des Congés
		this.conge = new Conges();
		this.msgSuccesConge = "Ce congé a été ajouté avec succès !!!";
		return this.conge;
	}
	
	public String editerCongeBySalarie(Conges c){
		this.msgSuccesConge = null;
		this.conge = c;//congeMetier.getCongeById(c.getIdConge());
		this.setModificationConge(1);
		return "gestionCongesGlobals?faces-redirect=true";
	}
	
	public String modifierCongeBySalarie(){
		this.msgSuccesConge = "Ce congé a été modifié avec succès !!!";
		this.congeMetier.modifierConge(this.conge);
		this.setModificationConge(0);
		this.conge = new Conges();
		return "gestionCongesGlobals?faces-redirect=true";
	}
	
	public String supprimerCongeBySalarie(Conges c){
		this.msgSuccesConge = "Ce congé a été supprimé avec succès !!!";
		congeMetier.supprimerConge(c.getIdConge());
		System.out.println("suppression avec succès du congé !!!" + this.conge.getIdConge());
		return "gestionCongesGlobals?faces-redirect=true";
	}
	
	public String accepterConge(Conges c){
		System.out.println("accepter congé");
		congeMetier.accepterConge(c);
		return "gestionCongesGlobals?faces-redirect=true";
	}
	
	public String refuserConge(Conges c){
		System.out.println("refuser congé");
		congeMetier.refuserConge(c);
		return "gestionCongesGlobals?faces-redirect=true";
	}

	
	public List<Salaries> getAllSalaries(){
		return salarieMetier.getAllSalaries();
	}
	
	public List<Salaries> getAllSalarie(){
		return salarieMetier.getAllSalaries();
	}
	
	public List<Conges> getAllConge(){
		return congeMetier.getAllConges();
	}
	
}
