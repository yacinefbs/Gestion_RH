package ma.bps.metier;

import java.util.List;

import ma.bps.entities.AutoFormation;
import ma.bps.entities.AutoFormationDocuments;

public interface IAutoFormationMetier {
	
	public AutoFormation ajouterAutoFormation(AutoFormation m);
	public AutoFormation getAutoFormationById(Long idAutoFormation);
	public List<AutoFormation> getAllAutoFormation();
	public AutoFormation modifierAutoFormation(AutoFormation m);
	public void supprimerAutoFormation(Long idAutoFormation);

	public List<Object[]> chargerNombreDocumentFormation(Long idFormation);
	
	public List<AutoFormationDocuments> chargerLesDocumentUneFormation(Long idFormation);
	
	public List<AutoFormation> chargerListeAutoFormationUnTheme(long idTheme);
	
	public List<AutoFormation> chargerListeAutoFormationRechercheParSujet(String sujetChercher);
	
}
