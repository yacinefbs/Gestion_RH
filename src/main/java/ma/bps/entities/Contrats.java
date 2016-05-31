package ma.bps.entities;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="type_contrat", discriminatorType=DiscriminatorType.STRING, length=3)
public class Contrats {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idContrat;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.DATE)
	private Date dateDebutContrat;
	@Temporal(TemporalType.DATE)
	private Date dateFinContrat;
	private String profil;
	
	//Debut relations
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie = new Salaries();
	//Fin relations
	
	public Contrats() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contrats(Date date, Date dateDebutContrat, Date dateFinContrat, String profil) {
		super();
		this.date = date;
		this.dateDebutContrat = dateDebutContrat;
		this.dateFinContrat = dateFinContrat;
		this.profil = profil;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getIdContrat() {
		return idContrat;
	}
	public void setIdContrat(Long idContrat) {
		this.idContrat = idContrat;
	}
	public Date getDateDebutContrat() {
		return dateDebutContrat;
	}
	public void setDateDebutContrat(Date dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}
	public Date getDateFinContrat() {
		return dateFinContrat;
	}
	public void setDateFinContrat(Date dateFinContrat) {
		this.dateFinContrat = dateFinContrat;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public Salaries getSalarie() {
		return salarie;
	}
	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}
}
