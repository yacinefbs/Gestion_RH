package ma.bps.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AdressesPro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdresse;
	private String typeAdresse;
	private String rue;
	private String numRue;
	private String batiments;
	private String bat_etage_porte;
	private String codePostal;
	private String ville;
	private String distincte;
	private String etat;
	private String pays;
	
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie = new Salaries();;
	
	
	public Salaries getSalarie() {
		return salarie;
	}
	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}
	
	public Long getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getTypeAdresse() {
		return typeAdresse;
	}
	public void setTypeAdresse(String typeAdresse) {
		this.typeAdresse = typeAdresse;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	public String getNumRue() {
		return numRue;
	}
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}
	public String getBatiments() {
		return batiments;
	}
	public void setBatiments(String batiments) {
		this.batiments = batiments;
	}
	public String getBat_etage_porte() {
		return bat_etage_porte;
	}
	public void setBat_etage_porte(String bat_etage_porte) {
		this.bat_etage_porte = bat_etage_porte;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDistincte() {
		return distincte;
	}
	public void setDistincte(String distincte) {
		this.distincte = distincte;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
	
}
