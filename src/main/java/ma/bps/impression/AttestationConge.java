package ma.bps.impression;

public class AttestationConge {
	
	private String nomSociete;
	private String nomPrenomSalarie;
	private String cin;
	private String poste;
	private String dateDebutConge;
	private String dateFinConge;
	
	public AttestationConge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttestationConge(String nomSociete, String nomPrenomSalarie, String cin, String poste, String dateDebutConge,
			String dateFinConge) {
		super();
		this.nomSociete = nomSociete;
		this.nomPrenomSalarie = nomPrenomSalarie;
		this.cin = cin;
		this.poste = poste;
		this.dateDebutConge = dateDebutConge;
		this.dateFinConge = dateFinConge;
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

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getDateDebutConge() {
		return dateDebutConge;
	}

	public void setDateDebutConge(String dateDebutConge) {
		this.dateDebutConge = dateDebutConge;
	}

	public String getDateFinConge() {
		return dateFinConge;
	}

	public void setDateFinConge(String dateFinConge) {
		this.dateFinConge = dateFinConge;
	}
	
	

}
