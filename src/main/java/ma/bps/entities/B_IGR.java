package ma.bps.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BI")
public class B_IGR extends Baremes {
	private double taux;
	private double deduction;
	public B_IGR() {
		super();
		// TODO Auto-generated constructor stub
	}
	public B_IGR(double tranche1, double tranche2, double taux, double deduction) {
		super(tranche1, tranche2);
		this.taux = taux;
		this.deduction = deduction;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public double getDeduction() {
		return deduction;
	}
	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}
}
