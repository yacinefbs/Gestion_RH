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
public class Utilisateurs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String login;
	private String passe;
	private String role;
	
	//Debut : relations 
	@ManyToOne
	@JoinColumn(name="idSalarie")	
	private Salaries salarie = new Salaries();

	public Utilisateurs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateurs(String login, String passe, String role) {
		super();
		this.login = login;
		this.passe = passe;
		this.role = role;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasse() {
		return passe;
	}

	public void setPasse(String passe) {
		this.passe = passe;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Salaries getSalarie() {
		return salarie;
	}

	public void setSalarie(Salaries salarie) {
		this.salarie = salarie;
	}
	
	
	
	
	

}
