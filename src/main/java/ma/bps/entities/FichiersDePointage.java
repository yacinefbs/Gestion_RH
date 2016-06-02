package ma.bps.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FichiersDePointage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFichier;
	private String nomReel;
	private String nomSurServeur;
	private String chemin;
	private long taille;
	@Temporal(TemporalType.DATE)
	private Date dateUpload;
	
	
	public FichiersDePointage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FichiersDePointage(String nomReel, String nomSurServeur, String chemin, long taille, Date dateUpload) {
		super();
		this.nomReel = nomReel;
		this.nomSurServeur = nomSurServeur;
		this.chemin = chemin;
		this.taille = taille;
		this.dateUpload = dateUpload;
	}


	public Long getIdFichier() {
		return idFichier;
	}


	public void setIdFichier(Long idFichier) {
		this.idFichier = idFichier;
	}


	public String getNomReel() {
		return nomReel;
	}


	public void setNomReel(String nomReel) {
		this.nomReel = nomReel;
	}


	public String getNomSurServeur() {
		return nomSurServeur;
	}


	public void setNomSurServeur(String nomSurServeur) {
		this.nomSurServeur = nomSurServeur;
	}


	public String getChemin() {
		return chemin;
	}


	public void setChemin(String chemin) {
		this.chemin = chemin;
	}


	public long getTaille() {
		return taille;
	}


	public void setTaille(long taille) {
		this.taille = taille;
	}


	public Date getDateUpload() {
		return dateUpload;
	}


	public void setDateUpload(Date dateUpload) {
		this.dateUpload = dateUpload;
	}
	
	
	

}
