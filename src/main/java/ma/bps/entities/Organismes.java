package ma.bps.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Organismes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrganisme;
	private String libelleOrganisme;
	private String ville;
	private String telephone;
	private String email;
	
	//Debut relations
	
	@OneToMany(mappedBy="organisme", fetch=FetchType.LAZY)
	private Collection<Cotisations> cotisations;
	
	@OneToMany(mappedBy="organisme", fetch=FetchType.LAZY)
	private Collection<Rubriques> rubriques;
	
	//Fin relations
	
	public Organismes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Organismes(String libelleOrganisme, String ville) {
		super();
		this.libelleOrganisme = libelleOrganisme;
		this.ville = ville;
	}
	public Long getIdOrganisme() {
		return idOrganisme;
	}
	public void setIdOrganisme(Long idOrganisme) {
		this.idOrganisme = idOrganisme;
	}
	public String getLibelleOrganisme() {
		return libelleOrganisme;
	}
	public void setLibelleOrganisme(String libelleOrganisme) {
		this.libelleOrganisme = libelleOrganisme;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Cotisations> getCotisations() {
		return cotisations;
	}
	public void setCotisations(Collection<Cotisations> cotisations) {
		this.cotisations = cotisations;
	}
}
