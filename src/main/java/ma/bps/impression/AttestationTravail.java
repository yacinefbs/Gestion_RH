package ma.bps.impression;

public class AttestationTravail {
	
	private String nomSociete;
	private String nomPrenomSalarie;
	private String cin;
	private String cnss;
	private String dateDebutContrat;
	private String poste;
	
	
	public AttestationTravail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AttestationTravail(String nomSociete, String nomPrenomSalarie, String cin, String cnss,
			String dateDebutContrat, String poste) {
		super();
		this.nomSociete = nomSociete;
		this.nomPrenomSalarie = nomPrenomSalarie;
		this.cin = cin;
		this.cnss = cnss;
		this.dateDebutContrat = dateDebutContrat;
		this.poste = poste;
	}


	public String getNomSociete() {
		return nomSociete;
	}


	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}


	public String getNomPrenomSalarie() {
		return nomPrenomSalarie;
	}


	public void setNomPrenomSalarie(String nomPrenomSalarie) {
		this.nomPrenomSalarie = nomPrenomSalarie;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getCnss() {
		return cnss;
	}


	public void setCnss(String cnss) {
		this.cnss = cnss;
	}


	public String getDateDebutContrat() {
		return dateDebutContrat;
	}


	public void setDateDebutContrat(String dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}


	public String getPoste() {
		return poste;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}
	
	

}
