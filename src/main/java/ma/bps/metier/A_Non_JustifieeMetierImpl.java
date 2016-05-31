package ma.bps.metier;

import java.util.List;

import ma.bps.dao.A_Non_JustifieeDaoImpl;
import ma.bps.dao.IA_Non_Justifiee;
import ma.bps.entities.A_Non_Justifiee;

public class A_Non_JustifieeMetierImpl implements IA_Non_JustifieeMetier {
	
	IA_Non_Justifiee dao = new A_Non_JustifieeDaoImpl();

	public void ajouterA_Non_Justifiee(A_Non_Justifiee a) {
		// TODO Auto-generated method stub
		dao.ajouterA_Non_Justifiee(a);
	}

	public A_Non_Justifiee getA_Non_JustifieeById(Long idA_Non_Justifiee) {
		// TODO Auto-generated method stub
		return dao.getA_Non_JustifieeById(idA_Non_Justifiee);
	}

	public List<A_Non_Justifiee> getAllA_Non_Justifiee() {
		// TODO Auto-generated method stub
		return dao.getAllA_Non_Justifiee();
	}

	public A_Non_Justifiee modifierA_Non_Justifiee(A_Non_Justifiee a) {
		// TODO Auto-generated method stub
		return dao.modifierA_Non_Justifiee(a);
	}

	public void supprimerA_Non_Justifiee(Long idA_Non_Justifiee) {
		// TODO Auto-generated method stub
		dao.supprimerA_Non_Justifiee(idA_Non_Justifiee);
	}

}
