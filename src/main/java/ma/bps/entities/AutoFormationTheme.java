package ma.bps.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AutoFormationTheme {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAutoFormationTheme;
	private String designation;
	
	
	@OneToMany(mappedBy="themeAutoFormation",orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<AutoFormation> autoFormations;
	
	public AutoFormationTheme() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AutoFormationTheme(Long idAutoFormationTheme, String designation) {
		super();
		this.idAutoFormationTheme = idAutoFormationTheme;
		this.designation = designation;
	}


	public Long getIdAutoFormationTheme() {
		return idAutoFormationTheme;
	}


	public void setIdAutoFormationTheme(Long idAutoFormationTheme) {
		this.idAutoFormationTheme = idAutoFormationTheme;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	

}
