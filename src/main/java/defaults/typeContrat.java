package defaults;

import java.util.Date;

public class typeContrat {
	private String type_contrat;
	
	public void setType_contrat(String type_contrat) {
		this.type_contrat = type_contrat;
	}
	private Long idContrat;
	private Date dateDebut;
	private Date dateFin;
	private String profil;
	public typeContrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdContrat() {
		return idContrat;
	}
	public void setIdContrat(Long idContrat) {
		this.idContrat = idContrat;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String getType_contrat() {
		return type_contrat;
	}
}
