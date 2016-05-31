package ma.bps.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TauxFraisPro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTauxFraisPro;
	private String libelle;
	private double taux;
	private double plafond;
	public Long getIdTauxFraisPro() {
		return idTauxFraisPro;
	}
	public void setIdTauxFraisPro(Long idTauxFraisPro) {
		this.idTauxFraisPro = idTauxFraisPro;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
}
