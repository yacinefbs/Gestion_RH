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
	private String heureNormalePointage;
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
	
	public Retards(Date dateRetardPointage, String heureNormalePointage, String heurePointageEnRetard, int duree) {
		super();
		this.dateRetardPointage = dateRetardPointage;
		this.heureNormalePointage = heureNormalePointage;
		this.heurePointageEnRetard = heurePointageEnRetard;
		this.duree = duree;
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
	public String getHeureNormalePointage() {
		return heureNormalePointage;
	}
	public void setHeureNormalePointage(String heureNormalePointage) {
		this.heureNormalePointage = heureNormalePointage;
	}
	public String getHeurePointageEnRetard() {
		return heurePointageEnRetard;
	}
	public void setHeurePointageEnRetard(String heurePointageEnRetard) {
		this.heurePointageEnRetard = heurePointageEnRetard;
	}
	
	
}
