package ma.bps.dao;

import java.util.List;

import ma.bps.entities.Rubriques;

public interface IRubriques {
	public Rubriques ajouterRubrique(Rubriques r);
	public Rubriques getRubriquesById(Long idRubrique);
	public List<Rubriques> getAllRubriques();
	public Rubriques modifierRubrique(Rubriques r);
	public void supprimerRubrique(Long idRubrique);
}
