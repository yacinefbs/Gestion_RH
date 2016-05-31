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
public class HistoriquePaies {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numPaie;
	@Temporal(TemporalType.DATE)
	private Date datePaie;
	
	
	//Les relations : Début
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie;
	//Les relations : Fin
	
	
	
	public HistoriquePaies() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoriquePaies(Date datePaie) {
		super();
		this.datePaie = datePaie;
	}
	public Long getNumPaie() {
		return numPaie;
	}
	public void setNumPaie(Long numPaie) {
		this.numPaie = numPaie;
	}
	public Date getDatePaie() {
		return datePaie;
	}
	public void setDatePaie(Date datePaie) {
		this.datePaie = datePaie;
	}
	
}
