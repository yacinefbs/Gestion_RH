package ma.bps.entities;

import java.util.Collection;

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

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="nature_salaire", discriminatorType=DiscriminatorType.STRING, length=2)
public class Salaires {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idSalaire;
	
	private double salaire_base;
	private String typeSalaire;
	@OneToMany(mappedBy="salaire",orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<Salaries> salaries; 
	
	
	
//	@OneToMany(mappedBy="salaire", fetch=FetchType.LAZY)
//	private Collection<ModePaiements> modePaiement;
	
	@ManyToOne
	@JoinColumn(name="idModePaiement")
	private ModePaiements modePaiement = new ModePaiements();
	
	
	public long getIdSalaire() {
		return idSalaire;
	}

	public void setIdSalaire(long idSalaire) {
		this.idSalaire = idSalaire;
	}

	public Collection<Salaries> getSalaries() {
		return salaries;
	}

	public void setSalaries(Collection<Salaries> salaries) {
		this.salaries = salaries;
	}

	public ModePaiements getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiements modePaiement) {
		this.modePaiement = modePaiement;
	}

	public double getSalaire_base() {
		return salaire_base;
	}

	public void setSalaire_base(double salaire_base) {
		this.salaire_base = salaire_base;
	}

	public String getTypeSalaire() {
		return typeSalaire;
	}

	public void setTypeSalaire(String typeSalaire) {
		this.typeSalaire = typeSalaire;
	}
}
