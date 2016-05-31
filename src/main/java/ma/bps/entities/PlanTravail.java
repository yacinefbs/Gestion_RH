package ma.bps.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class PlanTravail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPlan;
	private String designation;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private String typePlan;
	
	
	@OneToMany(mappedBy="planTravail", fetch=FetchType.LAZY)
	private Collection<Groupes> groupes;
		
	@OneToMany(mappedBy="PlanTravail",orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<TranchePlanTravail> tranchePlanAnnuel;
	
	//Fin relations
	
	
	public PlanTravail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlanTravail(String designation) {
		super();
		this.designation = designation;
	}
	public Long getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(Long idPlanJ) {
		this.idPlan = idPlanJ;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public String getTypePlan() {
		return typePlan;
	}
	public void setTypePlan(String typePlan) {
		this.typePlan = typePlan;
	}
	
	
}
