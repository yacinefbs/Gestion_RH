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
public class HeureSupplementaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHeureSup;
	@Temporal(TemporalType.DATE)
	private Date dateHeureSup;
	private String heureDebut;
	private String heureFin;
	private int duree;
	private float taux;
	
	//Debut relations
	
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie;

	public HeureSupplementaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeureSupplementaire(Date dateHeureSup, String heureDebut, String heureFin, int duree, float taux) {
		super();
		this.dateHeureSup = dateHeureSup;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.duree = duree;
		this.taux = taux;
	}

	public Long getIdHeureSup() {
		return idHeureSup;
	}

	public void setIdHeureSup(Long idHeureSup) {
		this.idHeureSup = idHeureSup;
	}

	public Date getDateHeureSup() {
		return dateHeureSup;
	}

	public void setDateHeureSup(Date dateHeureSup) {
		this.dateHeureSup = dateHeureSup;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public Salaries getSalarie() {
		return salarie;
	}

	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}
	
	
	
	
	
}
