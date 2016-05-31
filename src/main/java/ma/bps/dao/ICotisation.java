package ma.bps.dao;

import java.util.List;

import ma.bps.entities.Cotisations;

public interface ICotisation {
	public Cotisations ajouterCotisation(Cotisations c);
	public Cotisations getCotisationsById(Long idCotisation);
	public List<Cotisations> getAllCotisations();
	public Cotisations modifierCotisation(Cotisations c);
	public void supprimerCotisation(Long idCotisation);
}
