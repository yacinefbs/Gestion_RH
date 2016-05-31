package ma.bps.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BA")
public class B_Anciennetes extends Baremes {
	private double taux;

	public B_Anciennetes() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public B_Anciennetes(double tranche1, double tranche2, double taux) {
		super(tranche1, tranche2);
		this.taux = taux;
	}


	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	
}
