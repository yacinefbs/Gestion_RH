package ma.bps.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Groupes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGroupe;
	private String libelleGroupe;
	
	
	//Debut relations
	@OneToMany(mappedBy="groupe", fetch=FetchType.LAZY)
	private Collection<Salaries> salaries;
	
	//Debut relations 
	
	@ManyToOne
	@JoinColumn(name="idPlanTravail")
	private PlanTravail planTravail = new PlanTravail();
	
	
	//Fin relations
	
	
	public Groupes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groupes(String libelleGroupe) {
		super();
		this.libelleGroupe = libelleGroupe;
	}
	public Long getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}
	public String getLibelleGroupe() {
		return libelleGroupe;
	}
	public void setLibelleGroupe(String libelleGroupe) {
		this.libelleGroupe = libelleGroupe;
	}
	public Collection<Salaries> getSalaries() {
		return salaries;
	}
	public void setSalaries(Collection<Salaries> salaries) {
		this.salaries = salaries;
	}
	public PlanTravail getPlanTravail() {
		return planTravail;
	}
	public void setPlanTravail(PlanTravail planTravail) {
		this.planTravail = planTravail;
	}
	
	
	
}
