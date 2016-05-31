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
public class Avances {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAvance;
	private double montant;
	private String typeAvance;
	@Temporal(TemporalType.DATE)
	private Date dateAvance;
	
	
	//Debut relations
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie = new Salaries();
	
	@ManyToOne
	@JoinColumn(name="idModePaiement")
	private ModePaiements modePaiement = new ModePaiements();
	//Fin : relations
	
	
	public Avances() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Avances(double montant,String typeAvance, Date dateAvance) {
		super();
		this.montant = montant;
		this.typeAvance=typeAvance;
		this.dateAvance = dateAvance;
	}
	public Long getIdAvance() {
		return idAvance;
	}
	public void setIdAvance(Long idAvance) {
		this.idAvance = idAvance;
	}
	
	public String getTypeAvance() {
		return typeAvance;
	}
	public void setTypeAvance(String typeAvance) {
		this.typeAvance = typeAvance;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDateAvance() {
		return dateAvance;
	}
	public void setDateAvance(Date dateAvance) {
		this.dateAvance = dateAvance;
	}
	public Salaries getSalarie() {
		return salarie;
	}
	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}
	public ModePaiements getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(ModePaiements modePaiement) {
		this.modePaiement = modePaiement;
	}
	
	
}