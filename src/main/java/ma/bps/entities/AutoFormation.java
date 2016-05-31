package ma.bps.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AutoFormation {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAutoFormation;
	private String sujet;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateLancelent;
	
	@OneToMany(mappedBy="autoFormation", fetch=FetchType.LAZY)
	private Collection<AutoFormationDocuments> documents;

	@ManyToOne
	@JoinColumn(name="idThemeAutoFormation")
	private AutoFormationTheme themeAutoFormation;
	
	public AutoFormation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AutoFormation(String sujet, String description, Date dateLancelent) {
		super();
		this.sujet = sujet;
		this.description = description;
		this.dateLancelent = dateLancelent;
	}

	public Long getIdAutoFormation() {
		return idAutoFormation;
	}

	public void setIdAutoFormation(Long idAutoFormation) {
		this.idAutoFormation = idAutoFormation;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateLancelent() {
		return dateLancelent;
	}

	public void setDateLancelent(Date dateLancelent) {
		this.dateLancelent = dateLancelent;
	}

	public Collection<AutoFormationDocuments> getDocuments() {
		return documents;
	}

	public void setDocuments(Collection<AutoFormationDocuments> documents) {
		this.documents = documents;
	}

	public AutoFormationTheme getThemeAutoFormation() {
		return themeAutoFormation;
	}

	public void setThemeAutoFormation(AutoFormationTheme themeAutoFormation) {
		this.themeAutoFormation = themeAutoFormation;
	}

	
	
	

}
