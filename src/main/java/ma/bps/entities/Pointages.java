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
public class Pointages {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPointage;
	@Temporal(TemporalType.DATE)
	private Date datePointage;
	private String heurePointage;
//	private String verifier;
//	private String courant; // hada bach na3raf wach pointage ra khadam 3lih f un fichier courant
	
	
	//Debut relations
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie;
	
	//Fin relations
	public Pointages() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pointages(Date datePointage) {
		super();
		this.datePointage = datePointage;
	}
	public Long getIdPointage() {
		return idPointage;
	}
	public void setIdPointage(Long idPointage) {
		this.idPointage = idPointage;
	}
	public Date getDatePointage() {
		return datePointage;
	}
	public void setDatePointage(Date datePointage) {
		this.datePointage = datePointage;
	}
	public Salaries getSalarie() {
		return salarie;
	}
	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}
	public String getHeurePointage() {
		return heurePointage;
	}
	public void setHeurePointage(String heurePointage) {
		this.heurePointage = heurePointage;
	}
	
	
	
	
	
}
