package ma.bps.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A_J")
public class A_Justifiee extends Absences {
	private String motif;

	public A_Justifiee() {
		// TODO Auto-generated constructor stub
	}

	public A_Justifiee( Date dateAbsence, String heureDebutAbsence,
			String heureFinAbsence, int duree, String motif) {
		super(dateAbsence,heureDebutAbsence,heureFinAbsence,duree);
		this.motif = motif;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	
}
