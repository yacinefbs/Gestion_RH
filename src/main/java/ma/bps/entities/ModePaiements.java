package ma.bps.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ModePaiements {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPaiement;
	private String libellePaiement;
	
	
	//Debut relations
//	@ManyToOne
//	@JoinColumn(name="idSalaire")
//	private Salaires salaire;
	
	@OneToMany(mappedBy="modePaiement", fetch=FetchType.LAZY)
	private List<Salaires> salaires;
	
	@OneToMany(mappedBy="modePaiement", fetch=FetchType.LAZY)
	private List<PrimesAvantages> primeAvantage;
	
	@OneToMany(mappedBy="modePaiement", fetch=FetchType.LAZY)
	private List<Avances> avances;
	
	
	
	//Fin relations
	
	
	
	public ModePaiements() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModePaiements(String libellePaiement) {
		super();
		this.libellePaiement = libellePaiement;
	}
	public Long getIdPaiement() {
		return idPaiement;
	}
	public void setIdPaiement(Long idPaiement) {
		this.idPaiement = idPaiement;
	}
	public String getLibellePaiement() {
		return libellePaiement;
	}
	public void setLibellePaiement(String libellePaiement) {
		this.libellePaiement = libellePaiement;
	}
	public List<Salaires> getSalaires() {
		return salaires;
	}
	public void setSalaires(List<Salaires> salaires) {
		this.salaires = salaires;
	}
	public List<Avances> getAvances() {
		return avances;
	}
	public void setAvances(List<Avances> avances) {
		this.avances = avances;
	}
	
}
