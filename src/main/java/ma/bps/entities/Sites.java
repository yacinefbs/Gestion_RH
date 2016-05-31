package ma.bps.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Sites {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSite;
	private String libelleSite;
	
	//Debut relations
	
	@ManyToOne
	@JoinColumn(name="idSociete")
	private Societes societe;
	
	//Fin relations
	
	
	public Sites() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sites(String libelleSite) {
		super();
		this.libelleSite = libelleSite;
	}
	public Long getIdSite() {
		return idSite;
	}
	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}
	public String getLibelleSite() {
		return libelleSite;
	}
	public void setLibelleSite(String libelleSite) {
		this.libelleSite = libelleSite;
	}
	public Societes getSociete() {
		return societe;
	}
	public void setSociete(Societes societe) {
		this.societe = societe;
	}
	
}
