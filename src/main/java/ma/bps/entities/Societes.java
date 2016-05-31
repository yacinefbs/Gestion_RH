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
import javax.persistence.OneToMany;

@Entity
public class Societes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSociete;
	private String nomSociete;
	private String adresseSociete;
	
	
	//Debut relations
	
	@OneToMany(mappedBy="societe", fetch=FetchType.LAZY)
	private Collection<Salaries> salaries;
	
	@OneToMany(mappedBy="societe", fetch=FetchType.LAZY)
	private Collection<Baremes> baremes;
	
	
	@OneToMany(mappedBy="societe", fetch=FetchType.LAZY)
	private Collection<Sites> sites;
	
	//Fin relations
	
	public Societes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Societes(String nomSociete, String adresseSociete) {
		super();
		this.nomSociete = nomSociete;
		this.adresseSociete = adresseSociete;
	}
	public Long getIdSociete() {
		return idSociete;
	}
	public void setIdSociete(Long idSociete) {
		this.idSociete = idSociete;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	public String getAdresseSociete() {
		return adresseSociete;
	}
	public void setAdresseSociete(String adresseSociete) {
		this.adresseSociete = adresseSociete;
	}
	public Collection<Salaries> getSalaries() {
		return salaries;
	}
	public void setSalaries(Collection<Salaries> salaries) {
		this.salaries = salaries;
	}
	public Collection<Baremes> getBaremes() {
		return baremes;
	}
	public void setBaremes(Collection<Baremes> baremes) {
		this.baremes = baremes;
	}
}
