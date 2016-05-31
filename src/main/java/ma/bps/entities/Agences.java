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
public class Agences {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAgence;
	private String libelleAgence;
	private String adresseAgence;
	
	//Debut : relations 
//	@ManyToOne
//	@JoinColumn(name="idBanque")
//	private Banques banque;
	
	
	@OneToMany(mappedBy="agence", fetch=FetchType.LAZY)
	private Collection<Salaries> salaries;
	
	@ManyToOne
	@JoinColumn(name="idBanque")
	private Banques banque = new Banques();
	
	//Fin : relations
	
	
	public Agences() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agences(String libelleAgence, String adresseAgence) {
		super();
		this.libelleAgence = libelleAgence;
		this.adresseAgence = adresseAgence;
	}
	public Long getIdAgence() {
		return idAgence;
	}
	public void setIdAgence(Long idAgence) {
		this.idAgence = idAgence;
	}
	public String getLibelleAgence() {
		return libelleAgence;
	}
	public void setLibelleAgence(String libelleAgence) {
		this.libelleAgence = libelleAgence;
	}
	public String getAdresseAgence() {
		return adresseAgence;
	}
	public void setAdresseAgence(String adresseAgence) {
		this.adresseAgence = adresseAgence;
	}
	public Collection<Salaries> getSalaries() {
		return salaries;
	}
	public void setSalaries(Collection<Salaries> salaries) {
		this.salaries = salaries;
	}
	public Banques getBanque() {
		return banque;
	}
	public void setBanque(Banques banque) {
		this.banque = banque;
	}
	
}
