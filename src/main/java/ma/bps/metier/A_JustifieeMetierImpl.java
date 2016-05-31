package ma.bps.metier;

import java.util.List;

import ma.bps.dao.A_JustifieeDaoImpl;
import ma.bps.dao.IA_Justifiee;
import ma.bps.entities.A_Justifiee;
import ma.bps.entities.A_Non_Justifiee;

public class A_JustifieeMetierImpl implements IA_JustifieeMetier {
	
	IA_Justifiee dao = new A_JustifieeDaoImpl();

	public void ajouterA_Justifiee(A_Justifiee a) {
		// TODO Auto-generated method stub
		dao.ajouterA_Justifiee(a);
	}

	public A_Justifiee getA_JustifieeById(Long idA_Justifiee) {
		// TODO Auto-generated method stub
		return dao.getA_JustifieeById(idA_Justifiee);
	}

	public List<A_Justifiee> getAllA_Justifiee() {
		// TODO Auto-generated method stub
		return dao.getAllA_Justifiee();
	}

	public A_Justifiee modifierA_Justifiee(A_Justifiee a) {
		// TODO Auto-generated method stub
		return dao.modifierA_Justifiee(a);
	}

	public void supprimerA_Justifiee(Long idA_Justifiee) {
		// TODO Auto-generated method stub
		dao.supprimerA_Justifiee(idA_Justifiee);
	}

	

}
