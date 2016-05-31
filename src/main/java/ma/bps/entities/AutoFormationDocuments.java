package ma.bps.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AutoFormationDocuments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFichier;
	private String nomReel;
	private String nomSurServeur;
	private String chemin;
	private long taille;
	
	@ManyToOne
	@JoinColumn(name="idAutoFormation")
	private AutoFormation autoFormation;

	public AutoFormationDocuments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AutoFormationDocuments(Long idFichier, String nomReel, String nomSurServeur, String chemin, long taille) {
		super();
		this.idFichier = idFichier;
		this.nomReel = nomReel;
		this.nomSurServeur = nomSurServeur;
		this.chemin = chemin;
		this.taille = taille;
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

	public AutoFormation getAutoFormation() {
		return autoFormation;
	}

	public void setAutoFormation(AutoFormation autoFormation) {
		this.autoFormation = autoFormation;
	}
	
	

}
