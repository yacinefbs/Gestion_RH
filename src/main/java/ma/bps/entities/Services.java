package ma.bps.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;


@Entity
public class Services {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idService;
	private String libelle;
	
	
	//Debut : les relations
	@OneToMany(mappedBy="service", fetch=FetchType.LAZY)
	private Collection<Salaries> salaries;
	//Fin : les relations
	
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Services(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Long getIdService() {
		return idService;
	}

	public void setIdService(Long idService) {
		this.idService = idService;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
