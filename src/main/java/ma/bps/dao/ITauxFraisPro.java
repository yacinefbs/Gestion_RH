package ma.bps.dao;

import java.util.List;

import ma.bps.entities.TauxFraisPro;

public interface ITauxFraisPro {
	public TauxFraisPro ajouterTauxFraisPro(TauxFraisPro t);
	public TauxFraisPro getTauxFraisProById(Long idTauxFraisPro);
	public List<TauxFraisPro> getAllTauxFraisPros();
	public TauxFraisPro modifierTauxFraisPro(TauxFraisPro t);
	public void supprimerTauxFraisPro(Long idTauxFraisPro);
}
