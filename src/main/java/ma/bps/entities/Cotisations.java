	package ma.bps.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Cotisations {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCotisation;
	private String libelleCotisation;
	private double taux;
	private double plafond;
	private String type;
	
	
	//Debut relations
	@ManyToMany(mappedBy="cotisations")
	private Collection<Salaries> salaries;
	
	
	@ManyToOne
	@JoinColumn(name="idOrganisme")
	private Organismes organisme = new Organismes();
	
	//Fin relations
	
	public Cotisations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cotisations(String libelleCotisation, double taux, double plafond, String type) {
		super();
		this.libelleCotisation = libelleCotisation;
		this.taux = taux;
		this.plafond = plafond;
		this.type = type;
	}
	public Long getIdCotisation() {
		return idCotisation;
	}
	public void setIdCotisation(Long idCotisation) {
		this.idCotisation = idCotisation;
	}
	public String getLibelleCotisation() {
		return libelleCotisation;
	}
	public void setLibelleCotisation(String libelleCotisation) {
		this.libelleCotisation = libelleCotisation;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public double getPlafond() {
		return plafond;
	}
	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Collection<Salaries> getSalaries() {
		return salaries;
	}
	public void setSalaries(Collection<Salaries> salaries) {
		this.salaries = salaries;
	}
	public Organismes getOrganisme() {
		return organisme;
	}
	public void setOrganisme(Organismes organisme) {
		this.organisme = organisme;
	}
}
