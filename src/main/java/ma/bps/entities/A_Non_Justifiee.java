package ma.bps.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A_N_J")
public class A_Non_Justifiee extends Absences {
	
	private String description;
	
	
	public A_Non_Justifiee() {
		// TODO Auto-generated constructor stub
	}
	
	
	


	public A_Non_Justifiee( Date dateAbsence, String heureDebutAbsence, String heureFinAbsence,int duree,
			String description) {
		super(dateAbsence, heureDebutAbsence, heureFinAbsence, duree);
		this.description = description;
	}





	public A_Non_Justifiee(String description) {
		super();
		this.description = description;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
