package ma.bps.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TranchePlanTravail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTranche;
	private String jour;
	private Date heureDebut;
	private Date heureFin;
	private String code;
	private float taux;
	private boolean deuxJour;
	
	//Debut : relations 
	@ManyToOne
	@JoinColumn(name="idPlanTravail")
	private PlanTravail PlanTravail;

	
	
	public TranchePlanTravail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TranchePlanTravail(Date heureDebut, Date heureFin, String code, float taux) {
		super();
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.code = code;
		this.taux = taux;
	}

	public Long getIdTranche() {
		return idTranche;
	}

	public void setIdTranche(Long idTranche) {
		this.idTranche = idTranche;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public PlanTravail getPlanTravail() {
		return PlanTravail;
	}

	public void setPlanTravail(PlanTravail planTravail) {
		PlanTravail = planTravail;
	}

	public boolean isDeuxJour() {
		return deuxJour;
	}

	public void setDeuxJour(boolean deuxJour) {
		this.deuxJour = deuxJour;
	}
	
	

	

	
	
	
	
}
