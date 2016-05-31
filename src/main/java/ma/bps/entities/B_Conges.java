package ma.bps.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BC")
public class B_Conges extends Baremes {
	private double joursParMois;
	private double joursSupp;
	public B_Conges() {
		super();
		// TODO Auto-generated constructor stub
	}
	public B_Conges(double tranche1, double tranche2, double joursParMois, double joursSupp) {
		super(tranche1, tranche2);
		this.joursParMois = joursParMois;
		this.joursSupp = joursSupp;
	}
	public double getJoursParMois() {
		return joursParMois;
	}
	public void setJoursParMois(double joursParMois) {
		this.joursParMois = joursParMois;
	}
	public double getJoursSupp() {
		return joursSupp;
	}
	public void setJoursSupp(double joursSupp) {
		this.joursSupp = joursSupp;
	}
}
