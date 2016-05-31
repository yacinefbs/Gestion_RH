package ma.bps.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Rubriques {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRubrique;
	private String libelleRubrique;
	private String type;
	private String status;
	private double valeur;
	private double taux;
	private double plafond;
	private String imposable;
	private String positive;
	private String soumiseCNSS;
	private String soumiseMutuelle;
	private String soumiseIGR;
	private String soumiseAnciennete;
	private String soumiseCIMR;
	private String affichageEtatPrelev;
	private String indemniteverseFraisPro;
	private String remborseeOrganisme;
	private String rubriquePret;
	private String rubriqueAvance;
	
	
	//Debut relations
	
	@ManyToMany(mappedBy="rubriques")
	private Collection<Salaries> salaries;
	
	@ManyToOne
	@JoinColumn(name="idOrganisme")
	private Organismes organisme = new Organismes();
	
	//Fin relations
	public Rubriques() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rubriques(String libelleRubrique, String type, String status, double valeur, double taux, double plafond) {
		super();
		this.libelleRubrique = libelleRubrique;
		this.type = type;
		this.status = status;
		this.valeur = valeur;
		this.taux = taux;
		this.plafond = plafond;
	}
	public Long getIdRubrique() {
		return idRubrique;
	}
	public void setIdRubrique(Long idRubrique) {
		this.idRubrique = idRubrique;
	}
	public String getLibelleRubrique() {
		return libelleRubrique;
	}
	public void setLibelleRubrique(String libelleRubrique) {
		this.libelleRubrique = libelleRubrique;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public double getPlafond() {
		return plafond;
	}
	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}
	public Collection<Salaries> getSalaries() {
		return salaries;
	}
	public void setSalaries(Collection<Salaries> salaries) {
		this.salaries = salaries;
	}
	public Organismes getOrganisme() {
		return organisme;
	}
	public void setOrganisme(Organismes organisme) {
		this.organisme = organisme;
	}
	public String getImposable() {
		return imposable;
	}
	public void setImposable(String imposable) {
		this.imposable = imposable;
	}
	public String getPositive() {
		return positive;
	}
	public void setPositive(String positive) {
		this.positive = positive;
	}
	public String getSoumiseCNSS() {
		return soumiseCNSS;
	}
	public void setSoumiseCNSS(String soumiseCNSS) {
		this.soumiseCNSS = soumiseCNSS;
	}
	public String getSoumiseMutuelle() {
		return soumiseMutuelle;
	}
	public void setSoumiseMutuelle(String soumiseMutuelle) {
		this.soumiseMutuelle = soumiseMutuelle;
	}
	public String getSoumiseIGR() {
		return soumiseIGR;
	}
	public void setSoumiseIGR(String soumiseIGR) {
		this.soumiseIGR = soumiseIGR;
	}
	public String getSoumiseAnciennete() {
		return soumiseAnciennete;
	}
	public void setSoumiseAnciennete(String soumiseAnciennete) {
		this.soumiseAnciennete = soumiseAnciennete;
	}
	public String getSoumiseCIMR() {
		return soumiseCIMR;
	}
	public void setSoumiseCIMR(String soumiseCIMR) {
		this.soumiseCIMR = soumiseCIMR;
	}
	public String getAffichageEtatPrelev() {
		return affichageEtatPrelev;
	}
	public void setAffichageEtatPrelev(String affichageEtatPrelev) {
		this.affichageEtatPrelev = affichageEtatPrelev;
	}
	public String getIndemniteverseFraisPro() {
		return indemniteverseFraisPro;
	}
	public void setIndemniteverseFraisPro(String indemniteverseFraisPro) {
		this.indemniteverseFraisPro = indemniteverseFraisPro;
	}
	public String getRemborseeOrganisme() {
		return remborseeOrganisme;
	}
	public void setRemborseeOrganisme(String remborseeOrganisme) {
		this.remborseeOrganisme = remborseeOrganisme;
	}
	public String getRubriquePret() {
		return rubriquePret;
	}
	public void setRubriquePret(String rubriquePret) {
		this.rubriquePret = rubriquePret;
	}
	public String getRubriqueAvance() {
		return rubriqueAvance;
	}
	public void setRubriqueAvance(String rubriqueAvance) {
		this.rubriqueAvance = rubriqueAvance;
	}
}
