package ma.bps.metier;

import java.util.List;

import ma.bps.entities.AutoFormationDocuments;

public interface IAutoFormationDocumentsMetier {
	
	public AutoFormationDocuments ajouterAutoFormationDocuments(AutoFormationDocuments m);
	public AutoFormationDocuments getAutoAutoFormationDocumentsById(Long idAutoFormationDocuments);
	public List<AutoFormationDocuments> getAllAutoFormationDocuments();
	public AutoFormationDocuments modifierAutoFormationDocuments(AutoFormationDocuments m);
	public void supprimerAutoFormationDocuments(Long idAutoFormationDocuments);
	
	public List<AutoFormationDocuments> chargerListDocumentAutoFormationNonAffecterAuneAutoFormation();

}
