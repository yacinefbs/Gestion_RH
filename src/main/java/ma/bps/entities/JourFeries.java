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
	private Date dateF;
	private String description;
	
	//Debut relations
	@ManyToMany(mappedBy="jourFeries")
	private Collection<Salaries> salaries;
	
	//Fin relations
	
	public JourFeries() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JourFeries(Date dateF, String description) {
		super();
		this.dateF = dateF;
		this.description = description;
	}
	public Long getIdJourF() {
		return idJourF;
	}
	public void setIdJourF(Long idJourF) {
		this.idJourF = idJourF;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
