package ma.bps.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_absence", discriminatorType=DiscriminatorType.STRING, length=5)
public class Absences {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAbsence;
	@Temporal(TemporalType.DATE)
	private Date dateAbsence;
	private String heureDebutAbsence;
	private String heureFinAbsence;
	private int duree;
	
	
	//Debut relations
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie;
	
	//Fin relations
	
	
	public Absences() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Absences(Date dateAbsence, String heureDebutAbsence,
			String heureFinAbsence, int duree) {
		super();
		this.dateAbsence = dateAbsence;
		this.heureDebutAbsence = heureDebutAbsence;
		this.heureFinAbsence = heureFinAbsence;
		this.duree = duree;
	}



	public Long getIdAbsence() {
		return idAbsence;
	}
	public void setIdAbsence(Long idAbsence) {
		this.idAbsence = idAbsence;
	}
	
	public Salaries getSalarie() {
		return salarie;
	}
	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}



	public Date getDateAbsence() {
		return dateAbsence;
	}



	public void setDateAbsence(Date dateAbsence) {
		this.dateAbsence = dateAbsence;
	}



	public String getHeureDebutAbsence() {
		return heureDebutAbsence;
	}



	public void setHeureDebutAbsence(String heureDebutAbsence) {
		this.heureDebutAbsence = heureDebutAbsence;
	}



	public String getHeureFinAbsence() {
		return heureFinAbsence;
	}



	public void setHeureFinAbsence(String heureFinAbsence) {
		this.heureFinAbsence = heureFinAbsence;
	}



	public int getDuree() {
		return duree;
	}



	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	
}
