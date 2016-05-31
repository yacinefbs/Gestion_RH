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
public class Prets {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPret;
	private double montant;
	private int nbrEcheances;
	private double montantEcheance;
	@Temporal(TemporalType.DATE)
	private Date dateDebutPret;
	@Temporal(TemporalType.DATE)
	private Date dateFinPret;
	
	//Debut relations
	
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie = new Salaries();
	
	//Fin relations
	
	public Prets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prets(double montant, int nbrEcheances, double montantEcheance, Date dateDebutPret, Date dateFinPret) {
		super();
		this.montant = montant;
		this.nbrEcheances = nbrEcheances;
		this.montantEcheance = montantEcheance;
		this.dateDebutPret = dateDebutPret;
		this.dateFinPret = dateFinPret;
	}
	public Long getIdPret() {
		return idPret;
	}
	public void setIdPret(Long idPret) {
		this.idPret = idPret;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public int getNbrEcheances() {
		return nbrEcheances;
	}
	public void setNbrEcheances(int nbrEcheances) {
		this.nbrEcheances = nbrEcheances;
	}
	public double getMontantEcheance() {
		return montantEcheance;
	}
	public void setMontantEcheance(double montantEcheance) {
		this.montantEcheance = montantEcheance;
	}
	public Date getDateDebutPret() {
		return dateDebutPret;
	}
	public void setDateDebutPret(Date dateDebutPret) {
		this.dateDebutPret = dateDebutPret;
	}
	public Date getDateFinPret() {
		return dateFinPret;
	}
	public void setDateFinPret(Date dateFinPret) {
		this.dateFinPret = dateFinPret;
	}
	public Salaries getSalarie() {
		return salarie;
	}
	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}
}
