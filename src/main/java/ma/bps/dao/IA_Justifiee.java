package ma.bps.dao;

import java.util.List;

import ma.bps.entities.A_Justifiee;
import ma.bps.entities.A_Non_Justifiee;

public interface IA_Justifiee {
	
	public void ajouterA_Justifiee(A_Justifiee a);
	public A_Justifiee getA_JustifieeById(Long idA_Justifiee);
	public List<A_Justifiee> getAllA_Justifiee();
	public A_Justifiee modifierA_Justifiee(A_Justifiee a);
	public void supprimerA_Justifiee(Long idA_Justifiee);

}
