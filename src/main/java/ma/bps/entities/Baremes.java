package ma.bps.entities;

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

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_bareme", discriminatorType=DiscriminatorType.STRING, length=2)
public class Baremes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBareme;
	private double tranche1;
	private double tranche2;
	
	
	
	//Debut relations
	
	@ManyToOne
	@JoinColumn(name="idSociete")
	private Societes societe;
	
	//Fin relations
	public Baremes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Baremes(double tranche1, double tranche2) {
		super();
		this.tranche1 = tranche1;
		this.tranche2 = tranche2;
	}
	public Long getIdBareme() {
		return idBareme;
	}
	public void setIdBareme(Long idBareme) {
		this.idBareme = idBareme;
	}
	public double getTranche1() {
		return tranche1;
	}
	public void setTranche1(double tranche1) {
		this.tranche1 = tranche1;
	}
	public double getTranche2() {
		return tranche2;
	}
	public void setTranche2(double tranche2) {
		this.tranche2 = tranche2;
	}
	public Societes getSociete() {
		return societe;
	}
	public void setSociete(Societes societe) {
		this.societe = societe;
	}
	
}
