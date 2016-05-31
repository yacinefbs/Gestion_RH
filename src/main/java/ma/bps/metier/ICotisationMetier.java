package ma.bps.metier;

import java.util.List;

import ma.bps.entities.Cotisations;

public interface ICotisationMetier {
	public Cotisations ajouterCotisation(Cotisations c);
	public Cotisations getCotisationsById(Long idCotisation);
	public List<Cotisations> getAllCotisations();
	public Cotisations modifierCotisation(Cotisations c);
	public void supprimerCotisation(Long idCotisation);
}
