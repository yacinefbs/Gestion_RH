package ma.bps.dao;

import java.util.List;

import ma.bps.entities.AutoFormation;
import ma.bps.entities.AutoFormationDocuments;
import ma.bps.entities.Message;

public interface IAutoFormation {
	
	public AutoFormation ajouterAutoFormation(AutoFormation m);
	public AutoFormation getAutoFormationById(Long idAutoFormation);
	public List<AutoFormation> getAllAutoFormation();
	public AutoFormation modifierAutoFormation(AutoFormation m);
	public void supprimerAutoFormation(Long idAutoFormation);
	
	
	public List<Object[]> chargerNombreDocumentFormation(Long idFormation);
	
	public List<AutoFormationDocuments> chargerLesDocumentUneFormation(Long idFormation);
	
	public List<AutoFormation> chargerListeAutoFormationUnTheme(long idTheme);
	
	// charger liste des auto formation recherche sujet 
	public List<AutoFormation> chargerListeAutoFormationRechercheParSujet(String sujetChercher);

}
