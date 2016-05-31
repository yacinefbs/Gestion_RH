package ma.bps.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FI")
public class F_Initiale extends Formations {
	
	
	private String categorieFormation;
	private String etablissement;
	private String matierePrincipale;
	private String diplome;
	
	public F_Initiale() {
		super();
		// TODO Auto-generated constructor stub
	}


	public F_Initiale(String categorieFormation, String etablissement, String matierePrincipale, String diplome) {
		super();
		this.categorieFormation = categorieFormation;
		this.etablissement = etablissement;
		this.matierePrincipale = matierePrincipale;
		this.diplome = diplome;
	}


	public String getCategorieFormation() {
		return categorieFormation;
	}

	public void setCategorieFormation(String categorieFormation) {
		this.categorieFormation = categorieFormation;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getMatierePrincipale() {
		return matierePrincipale;
	}

	public void setMatierePrincipale(String matierePrincipale) {
		this.matierePrincipale = matierePrincipale;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
}
