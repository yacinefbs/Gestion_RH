package ma.bps.metier;

import java.util.List;

import ma.bps.entities.PrimesAvantages;

public interface IPrimeAvantageMetier {
	public PrimesAvantages ajouterPrimesAvantage(PrimesAvantages p);
	public PrimesAvantages getPrimesAvantageById(Long idPrimesAvantage);
	public List<PrimesAvantages> getAllPrimesAvantages();
	public PrimesAvantages modifierPrimesAvantage(PrimesAvantages p);
	public void supprimerPrimesAvantages(Long idPrimesAvantage);
	public PrimesAvantages getPrimeAvantageByIdSalarie(Long idSalarie);
}
