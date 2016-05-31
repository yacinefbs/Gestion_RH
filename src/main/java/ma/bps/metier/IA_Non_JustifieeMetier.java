package ma.bps.metier;

import java.util.List;

import ma.bps.entities.A_Non_Justifiee;

public interface IA_Non_JustifieeMetier {
	
	public void ajouterA_Non_Justifiee(A_Non_Justifiee a);
	public A_Non_Justifiee getA_Non_JustifieeById(Long idA_Non_Justifiee);
	public List<A_Non_Justifiee> getAllA_Non_Justifiee();
	public A_Non_Justifiee modifierA_Non_Justifiee(A_Non_Justifiee a);
	public void supprimerA_Non_Justifiee(Long idA_Non_Justifiee);

}
