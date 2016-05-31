package ma.bps.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DemandeDesCertificatsParSalarie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDemande;
	@Temporal(TemporalType.DATE)
	private Date dateDemande;
	@Temporal(TemporalType.DATE)
	private Date dateReponse;
	private String certificatDemander;
	private String repondu; // hadi katoun fiha oui ou non ya3na wach demanda 3liha responsable ou mazal
	private Long idCongeAdemanderSonAttestation; // cette attribut pour stocker l'id du congé a demander son attestation
	private int anneeBultinPaieDemander; // hadi pour stocker l'année du bulletin paie demander
	private int moisBultinPaieDemander; // hadi pour stocker le mois du bulletin paie demander
	
	
	//Debut relations
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Salaries salarie;

	public DemandeDesCertificatsParSalarie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandeDesCertificatsParSalarie(Date dateDemande, Date dateReponse, String certificatDemander,
			String repondu, Long idCongeAdemanderSonAttestation, int anneeBultinPaieDemander,
			int moisBultinPaieDemander) {
		super();
		this.dateDemande = dateDemande;
		this.dateReponse = dateReponse;
		this.certificatDemander = certificatDemander;
		this.repondu = repondu;
		this.idCongeAdemanderSonAttestation = idCongeAdemanderSonAttestation;
		this.anneeBultinPaieDemander = anneeBultinPaieDemander;
		this.moisBultinPaieDemander = moisBultinPaieDemander;
	}

	public Long getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(Long idDemande) {
		this.idDemande = idDemande;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public Date getDateReponse() {
		return dateReponse;
	}

	public void setDateReponse(Date dateReponse) {
		this.dateReponse = dateReponse;
	}

	public String getCertificatDemander() {
		return certificatDemander;
	}

	public void setCertificatDemander(String certificatDemander) {
		this.certificatDemander = certificatDemander;
	}

	public String getRepondu() {
		return repondu;
	}

	public void setRepondu(String repondu) {
		this.repondu = repondu;
	}

	public Long getIdCongeAdemanderSonAttestation() {
		return idCongeAdemanderSonAttestation;
	}

	public void setIdCongeAdemanderSonAttestation(Long idCongeAdemanderSonAttestation) {
		this.idCongeAdemanderSonAttestation = idCongeAdemanderSonAttestation;
	}

	public int getAnneeBultinPaieDemander() {
		return anneeBultinPaieDemander;
	}

	public void setAnneeBultinPaieDemander(int anneeBultinPaieDemander) {
		this.anneeBultinPaieDemander = anneeBultinPaieDemander;
	}

	public int getMoisBultinPaieDemander() {
		return moisBultinPaieDemander;
	}

	public void setMoisBultinPaieDemander(int moisBultinPaieDemander) {
		this.moisBultinPaieDemander = moisBultinPaieDemander;
	}

	public Salaries getSalarie() {
		return salarie;
	}

	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}

	

	
	
	
	

}
