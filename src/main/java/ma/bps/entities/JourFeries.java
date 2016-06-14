package ma.bps.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class JourFeries {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idJourF;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private String description;

	
	//Fin relations
	
	public JourFeries() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public JourFeries(Long idJourF, Date dateDebut, Date dateFin, String description) {
		super();
		this.idJourF = idJourF;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
	}




	public Long getIdJourF() {
		return idJourF;
	}
	public void setIdJourF(Long idJourF) {
		this.idJourF = idJourF;
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




	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
