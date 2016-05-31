package ma.bps.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class PrimesAvantages {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPrime;
	private String valeur;
	private String typePrimeAvantage;
	
	
	
	//Debut relations
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie = new Salaries();
	
	@ManyToOne
	@JoinColumn(name="idModePaiement")
	private ModePaiements modePaiement = new ModePaiements();
	
	//Fin relations
	public PrimesAvantages() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PrimesAvantages(String valeur) {
		super();
		this.valeur = valeur;
	}
	public Long getIdPrime() {
		return idPrime;
	}
	public void setIdPrime(Long idPrime) {
		this.idPrime = idPrime;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public Salaries getSalarie() {
		return salarie;
	}
	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}
	public String getTypePrimeAvantage() {
		return typePrimeAvantage;
	}
	public void setTypePrimeAvantage(String typePrimeAvantage) {
		this.typePrimeAvantage = typePrimeAvantage;
	}
	public ModePaiements getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(ModePaiements modePaiement) {
		this.modePaiement = modePaiement;
	}
	
}
