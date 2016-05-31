package ma.bps.entities;

import java.io.File;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.primefaces.model.UploadedFile;

@Entity
public class Salaries {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSalarie;
	@NotNull(message="Veuillez saisir le nom !!!")
	private String nom;
	@NotNull(message="Veuillez saisir le prénom")
	private String prenom;
	private String CIN;
	private String telephone_pro;
	private String telephone_portable;
	private String telecopie;
	private String email;
	private String situationFamiliale;
	private int nbEnfants;
	private String ribSalaire;
	private String sexe;
	private String cnss;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String paysNaissance;
	private String nationalite;
	private String numPassport;
	@Temporal(TemporalType.DATE)
	private Date dateValiditePassport;
	@Temporal(TemporalType.DATE)
	private Date dateEmissionPassport;
	private String emetteurPassport;
	
	@Temporal(TemporalType.DATE)
	private Date dateEntreeConge;
	private double nbrJourConge;
	
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	//Les relations : Début
	@OneToMany(mappedBy="salarie", orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<HistoriquePaies> historiquePaies;
	
	@OneToMany(mappedBy="salarie",orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<Utilisateurs> utilisateurs;
	
//	@ManyToMany
//	@JoinTable(name="salaries_formations")
//	private Collection<Formations> formations;
	
//	@ManyToOne
//	@JoinColumn(name="idFormation")
//	private Formations formation;
	
	@OneToMany(mappedBy="salarie", orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<Formations> formations;
	
	@ManyToOne
	@JoinColumn(name="idService")
	private Services service = new Services();
	
	@ManyToOne
	@JoinColumn(name="idQualification")
	private Qualifications qualification = new Qualifications();
	
//	@ManyToOne
//	@JoinColumn(name="idBanque")
//	private Banques banque;
	
	@ManyToOne
	@JoinColumn(name="idAgence")
	private Agences agence = new Agences();
	
	
	@OneToMany(mappedBy="salarie",orphanRemoval=true,fetch=FetchType.LAZY)
	private Collection<Avances> avances;
	
	@ManyToOne
	@JoinColumn(name="idSalaire")
	private Salaires salaire = new Salaires();
	
	@ManyToOne
	@JoinColumn(name="idGroupe")
	private Groupes groupe = new Groupes();
	
	@OneToMany(mappedBy="salarie", orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<Pointages> pointages;
	
	
	@OneToMany(mappedBy="salarie", orphanRemoval=true,fetch=FetchType.LAZY)
	private Collection<Absences> absences;
	
	@OneToMany(mappedBy="salarie",orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<Retards> retards;
	
	@OneToMany(mappedBy="salarie",orphanRemoval=true, fetch=FetchType.EAGER)
	private Collection<Conges> conges;
	
	@ManyToMany
	@JoinTable(name="salaries_jourFeries")
	private Collection<JourFeries> jourFeries;
	
	
	@ManyToOne
	@JoinColumn(name="idSociete")
	private Societes societe = new Societes();
	
	@OneToMany(mappedBy="salarie",orphanRemoval=true, fetch=FetchType.EAGER)
	private Collection<Contrats> contrats;
	
	@OneToMany(mappedBy="salarie", orphanRemoval=true,fetch=FetchType.LAZY)
	private Collection<AdressesPro> adressesPro;
	
	@OneToMany(mappedBy="salarie",orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<AdressesPrivee> adressesPrivee;
	
	@OneToMany(mappedBy="salarie", orphanRemoval=true, fetch=FetchType.EAGER)
	private Collection<PrimesAvantages> primesAvantages;
	
	@OneToMany(mappedBy="salarie",orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<Prets> prets;
	
	@ManyToMany
	@JoinColumn(name="salaries_cotisations")
	private Collection<Cotisations> cotisations;
	
	@ManyToMany
	@JoinTable(name="salaries_rubriques")
	private Collection<Rubriques> rubriques;
	
	
	// les message
	@OneToMany(mappedBy="destinataire",orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<Message> messageRecu;
	
	@OneToMany(mappedBy="destinateur",orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<Message> messageEnvoyer;
	
	// les heure sup
	@OneToMany(mappedBy="salarie",orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<HeureSupplementaire> HeureSup;
	
	// les demande des certificats administratif
	@OneToMany(mappedBy="salarie", orphanRemoval=true,fetch=FetchType.LAZY)
	private Collection<DemandeDesCertificatsParSalarie> certificatsDemander;
	
	
	//Les relations : Fin
	
	
	public Salaries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdEmploye() {
		return idSalarie;
	}

	public Salaries(String nom, String prenom, String cIN, String telephone_pro, String telephone_portable, String telecopie, String email, String situationFamiliale,
			int nbEnfants, String ribSalaire, String sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		CIN = cIN;
		this.telephone_pro = telephone_pro;
		this.telephone_portable = telephone_portable;
		this.telecopie = telecopie;
		this.email = email;
		this.situationFamiliale = situationFamiliale;
		this.nbEnfants = nbEnfants;
		this.ribSalaire = ribSalaire;
		this.sexe = sexe;
	}


	public void setIdEmploye(Long idSalarie) {
		this.idSalarie = idSalarie;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getCIN() {
		return CIN;
	}


	public void setCIN(String cIN) {
		CIN = cIN;
	}


	public String getTelephone_pro() {
		return telephone_pro;
	}


	public void setTelephone_pro(String telephone_pro) {
		this.telephone_pro = telephone_pro;
	}


	public String getTelephone_portable() {
		return telephone_portable;
	}


	public void setTelephone_portable(String telephone_portable) {
		this.telephone_portable = telephone_portable;
	}

	
	
	public String getTelecopie() {
		return telecopie;
	}


	public void setTelecopie(String telecopie) {
		this.telecopie = telecopie;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSituationFamiliale() {
		return situationFamiliale;
	}


	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}


	public int getNbEnfants() {
		return nbEnfants;
	}


	public void setNbEnfants(int nbEnfants) {
		this.nbEnfants = nbEnfants;
	}


	public String getRibSalaire() {
		return ribSalaire;
	}


	public void setRibSalaire(String ribSalaire) {
		this.ribSalaire = ribSalaire;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public Long getIdSalarie() {
		return idSalarie;
	}


	public void setIdSalarie(Long idSalarie) {
		this.idSalarie = idSalarie;
	}

	
	
	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getPaysNaissance() {
		return paysNaissance;
	}


	public void setPaysNaissance(String paysNaissance) {
		this.paysNaissance = paysNaissance;
	}


	public String getNationalite() {
		return nationalite;
	}


	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}


	public String getNumPassport() {
		return numPassport;
	}


	public void setNumPassport(String numPassport) {
		this.numPassport = numPassport;
	}


	public Date getDateValiditePassport() {
		return dateValiditePassport;
	}


	public void setDateValiditePassport(Date dateValiditePassport) {
		this.dateValiditePassport = dateValiditePassport;
	}


	public Date getDateEmissionPassport() {
		return dateEmissionPassport;
	}


	public void setDateEmissionPassport(Date dateEmissionPassport) {
		this.dateEmissionPassport = dateEmissionPassport;
	}


	public String getEmetteurPassport() {
		return emetteurPassport;
	}


	public void setEmetteurPassport(String emetteurPassport) {
		this.emetteurPassport = emetteurPassport;
	}


	public Collection<HistoriquePaies> getHistoriquePaies() {
		return historiquePaies;
	}


	public void setHistoriquePaies(Collection<HistoriquePaies> historiquePaies) {
		this.historiquePaies = historiquePaies;
	}


//	public Collection<Formations> getFormations() {
//		return formations;
//	}
//
//
//	public void setFormations(Collection<Formations> formations) {
//		this.formations = formations;
//	}


	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public Collection<Formations> getFormations() {
		return formations;
	}

	public void setFormations(Collection<Formations> formations) {
		this.formations = formations;
	}





	public Qualifications getQualification() {
		return qualification;
	}


	public void setQualification(Qualifications qualification) {
		this.qualification = qualification;
	}




	public Collection<Avances> getAvances() {
		return avances;
	}


	public void setAvances(Collection<Avances> avances) {
		this.avances = avances;
	}


	public Salaires getSalaire() {
		return salaire;
	}


	public void setSalaire(Salaires salaire) {
		this.salaire = salaire;
	}


	public Groupes getGroupe() {
		return groupe;
	}


	public void setGroupe(Groupes groupe) {
		this.groupe = groupe;
	}


	public Collection<Pointages> getPointages() {
		return pointages;
	}


	public void setPointages(Collection<Pointages> pointages) {
		this.pointages = pointages;
	}


	public Collection<Absences> getAbsences() {
		return absences;
	}


	public void setAbsences(Collection<Absences> absences) {
		this.absences = absences;
	}


	public Collection<Retards> getRetards() {
		return retards;
	}


	public void setRetards(Collection<Retards> retards) {
		this.retards = retards;
	}


	


	public Collection<Conges> getConges() {
		return conges;
	}


	public void setConges(Collection<Conges> conges) {
		this.conges = conges;
	}


	public Collection<JourFeries> getJourFeries() {
		return jourFeries;
	}


	public void setJourFeries(Collection<JourFeries> jourFeries) {
		this.jourFeries = jourFeries;
	}


	public Societes getSociete() {
		return societe;
	}


	public void setSociete(Societes societe) {
		this.societe = societe;
	}


	public Collection<Contrats> getContrats() {
		return contrats;
	}


	public void setContrats(Collection<Contrats> contrats) {
		this.contrats = contrats;
	}


	public Collection<PrimesAvantages> getPrimesAvantages() {
		return primesAvantages;
	}


	public void setPrimesAvantages(Collection<PrimesAvantages> primesAvantages) {
		this.primesAvantages = primesAvantages;
	}


	public Collection<Prets> getPrets() {
		return prets;
	}


	public void setPrets(Collection<Prets> prets) {
		this.prets = prets;
	}


	public Collection<Cotisations> getCotisations() {
		return cotisations;
	}


	public void setCotisations(Collection<Cotisations> cotisations) {
		this.cotisations = cotisations;
	}


	public Collection<Rubriques> getRubriques() {
		return rubriques;
	}


	public void setRubriques(Collection<Rubriques> rubriques) {
		this.rubriques = rubriques;
	}


	public String getCnss() {
		return cnss;
	}


	public void setCnss(String cnss) {
		this.cnss = cnss;
	}


	public Collection<AdressesPro> getAdressesPro() {
		return adressesPro;
	}


	public void setAdressesPro(Collection<AdressesPro> adressesPro) {
		this.adressesPro = adressesPro;
	}


	public Collection<AdressesPrivee> getAdressesPrivee() {
		return adressesPrivee;
	}


	public void setAdressesPrivee(Collection<AdressesPrivee> adressesPrivee) {
		this.adressesPrivee = adressesPrivee;
	}


	public Agences getAgence() {
		return agence;
	}


	public void setAgence(Agences agence) {
		this.agence = agence;
	}

	public Collection<Utilisateurs> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateurs> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Date getDateEntreeConge() {
		return dateEntreeConge;
	}

	public void setDateEntreeConge(Date dateEntreeConge) {
		this.dateEntreeConge = dateEntreeConge;
	}

	public double getNbrJourConge() {
		return nbrJourConge;
	}

	public void setNbrJourConge(double nbrJourConge) {
		this.nbrJourConge = nbrJourConge;
	}
}
