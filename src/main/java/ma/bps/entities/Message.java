package ma.bps.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMessage;
	private String objet;
	@Type(type="text")
	private String contenu;
	private Date dateMessage;
	private String lu;
	private String supprimerFacultatifParDestinataire;
	private String supprimerFacultatifParDestinateur;
	private String supprimerDefinitifParDestinataire;
	private String supprimerDefinitifParDestinateur;	
	

	@ManyToOne
	@JoinColumn(name="idSalariedestinataire")
	private Salaries destinataire;
	
	@ManyToOne
	@JoinColumn(name="idSalariedestinateur")
	private Salaries destinateur;
	
	@OneToMany(mappedBy="message",orphanRemoval=true, fetch=FetchType.LAZY)
	private Collection<MessageFichierJoint> messageFichiers;

	
	
	public Collection<MessageFichierJoint> getMessageFichiers() {
		return messageFichiers;
	}

	public void setMessageFichiers(Collection<MessageFichierJoint> messageFichiers) {
		this.messageFichiers = messageFichiers;
	}

	public Message(String objet, String contenu, Date dateMessage) {
		super();
		this.objet = objet;
		this.contenu = contenu;
		this.dateMessage = dateMessage;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	public Salaries getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Salaries destinataire) {
		this.destinataire = destinataire;
	}

	public Salaries getDestinateur() {
		return destinateur;
	}

	public void setDestinateur(Salaries destinateur) {
		this.destinateur = destinateur;
	}

	public String getLu() {
		return lu;
	}

	public void setLu(String lu) {
		this.lu = lu;
	}

	public String getSupprimerFacultatifParDestinataire() {
		return supprimerFacultatifParDestinataire;
	}

	public void setSupprimerFacultatifParDestinataire(String supprimerFacultatifParDestinataire) {
		this.supprimerFacultatifParDestinataire = supprimerFacultatifParDestinataire;
	}

	public String getSupprimerFacultatifParDestinateur() {
		return supprimerFacultatifParDestinateur;
	}

	public void setSupprimerFacultatifParDestinateur(String supprimerFacultatifParDestinateur) {
		this.supprimerFacultatifParDestinateur = supprimerFacultatifParDestinateur;
	}

	public String getSupprimerDefinitifParDestinataire() {
		return supprimerDefinitifParDestinataire;
	}

	public void setSupprimerDefinitifParDestinataire(String supprimerDefinitifParDestinataire) {
		this.supprimerDefinitifParDestinataire = supprimerDefinitifParDestinataire;
	}

	public String getSupprimerDefinitifParDestinateur() {
		return supprimerDefinitifParDestinateur;
	}

	public void setSupprimerDefinitifParDestinateur(String supprimerDefinitifParDestinateur) {
		this.supprimerDefinitifParDestinateur = supprimerDefinitifParDestinateur;
	}


	
	
	
	
}
