package ma.bps.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Qualifications {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idQualification;
	private String poste;
	
	@OneToMany(mappedBy="qualification", fetch=FetchType.LAZY)
	private Collection<Salaries> salaries;
	
	public Qualifications() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Qualifications(String poste) {
		super();
		this.poste = poste;
	}
	public Long getIdQualification() {
		return idQualification;
	}
	public void setIdQualification(Long idQualification) {
		this.idQualification = idQualification;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public Collection<Salaries> getSalaries() {
		return salaries;
	}
	public void setSalaries(Collection<Salaries> salaries) {
		this.salaries = salaries;
	}
}
