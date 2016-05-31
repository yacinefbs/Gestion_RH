package ma.bps.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("FP")
public class F_Professionnelles extends Formations {
	
	private String employeur;
	private String poste;
	private String remarques;
	
	public F_Professionnelles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public F_Professionnelles(String employeur, String poste, String remarques) {
		super();
		this.employeur = employeur;
		this.poste = poste;
		this.remarques = remarques;
	}

	public String getEmployeur() {
		return employeur;
	}

	public void setEmployeur(String employeur) {
		this.employeur = employeur;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}
}
