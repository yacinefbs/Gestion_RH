package ma.bps.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PointageDatePasse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idJourPointu;
	@Temporal(TemporalType.DATE)
	private Date jour;
	
	
	public PointageDatePasse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PointageDatePasse(Date jour) {
		super();
		this.jour = jour;
	}


	public Long getIdJourPointu() {
		return idJourPointu;
	}


	public void setIdJourPointu(Long idJourPointu) {
		this.idJourPointu = idJourPointu;
	}


	public Date getJour() {
		return jour;
	}


	public void setJour(Date jour) {
		this.jour = jour;
	}
	
	
	

}
