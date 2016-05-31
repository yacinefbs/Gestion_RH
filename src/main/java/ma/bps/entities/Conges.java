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
public class Conges {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idConge;
	@Temporal(TemporalType.DATE)
	private Date dateDebutC;
	@Temporal(TemporalType.DATE)
	private Date dateFinC;
	private String nature;
	private String valide;
	private Long supHierarchique;
	private String telephone;
	
	//Début relations
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie = new Salaries();
	
	//Fin relations
	
	public Conges() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conges(Date dateDebutC, Date dateFinC, String nature, String valide, Long supHierarchique,
			String telephone) {
		super();
		this.dateDebutC = dateDebutC;
		this.dateFinC = dateFinC;
		this.nature = nature;
		this.valide = valide;
		this.supHierarchique = supHierarchique;
		this.telephone = telephone;
	}
	public Long getIdConge() {
		return idConge;
	}
	public void setIdConge(Long idConge) {
		this.idConge = idConge;
	}
	public Date getDateDebutC() {
		return dateDebutC;
	}
	public void setDateDebutC(Date dateDebutC) {
		this.dateDebutC = dateDebutC;
	}
	public Date getDateFinC() {
		return dateFinC;
	}
	public void setDateFinC(Date dateFinC) {
		this.dateFinC = dateFinC;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getValide() {
		return valide;
	}
	public void setValide(String valide) {
		this.valide = valide;
	}
	public Long getSupHierarchique() {
		return supHierarchique;
	}
	public void setSupHierarchique(Long supHierarchique) {
		this.supHierarchique = supHierarchique;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Salaries getSalarie() {
		return salarie;
	}
	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}
	
}
