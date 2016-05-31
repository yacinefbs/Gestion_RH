package ma.bps.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MessageFichierJoint {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFichier;
	private String nomReel;
	private String nomSurServeur;
	private String chemin;
	private long taille;
	
	@ManyToOne
	@JoinColumn(name="idMessage")
	private Message message;

	public MessageFichierJoint() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MessageFichierJoint(Long idFichier, String nomReel, String nomSurServeur, String chemin, long taille) {
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

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public long getTaille() {
		return taille;
	}

	public void setTaille(long taille) {
		this.taille = taille;
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
	
	public int longeurNomReel(){
		return this.nomReel.length();
	}
	
}
