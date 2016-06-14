package ma.bps.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Retards {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRetard;
	@Temporal(TemporalType.DATE)
	private Date dateRetardPointage;
	private String heureDebutTranche;
	private String heureFinTranche;
	private String heurePointageEnRetard;
	private int duree;
	
	
	//Debut relations
	
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie;
	
	//Fin relations
	
	public Retards() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Retards(Date dateRetardPointage, String heureDebutTranche, String heureFinTranche,
			String heurePointageEnRetard, int duree, Salaries salarie) {
		super();
		this.dateRetardPointage = dateRetardPointage;
		this.heureDebutTranche = heureDebutTranche;
		this.heureFinTranche = heureFinTranche;
		this.heurePointageEnRetard = heurePointageEnRetard;
		this.duree = duree;
		this.salarie = salarie;
	}


	public Long getIdRetard() {
		return idRetard;
	}
	public void setIdRetard(Long idRetard) {
		this.idRetard = idRetard;
	}
	public Date getDateRetardPointage() {
		return dateRetardPointage;
	}
	public void setDateRetardPointage(Date dateRetardPointage) {
		this.dateRetardPointage = dateRetardPointage;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Salaries getSalarie() {
		return salarie;
	}
	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}


	
	public String getHeureDebutTranche() {
		return heureDebutTranche;
	}


	public void setHeureDebutTranche(String heureDebutTranche) {
		this.heureDebutTranche = heureDebutTranche;
	}


	public String getHeureFinTranche() {
		return heureFinTranche;
	}


	public void setHeureFinTranche(String heureFinTranche) {
		this.heureFinTranche = heureFinTranche;
	}


	public String getHeurePointageEnRetard() {
		return heurePointageEnRetard;
	}
	public void setHeurePointageEnRetard(String heurePointageEnRetard) {
		this.heurePointageEnRetard = heurePointageEnRetard;
	}
	
	
}
