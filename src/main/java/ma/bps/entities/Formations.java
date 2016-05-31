package ma.bps.entities;

import java.util.Collection;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_formation", discriminatorType=DiscriminatorType.STRING, length=2)

public class Formations {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idFormation;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
//	@ManyToMany(mappedBy="formations")
//	private Collection<Salaries> salaries;
	
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie = new Salaries();
	
	
	public Formations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(long idFormation) {
		this.idFormation = idFormation;
	}

	public Salaries getSalarie() {
		return salarie;
	}

	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
}
